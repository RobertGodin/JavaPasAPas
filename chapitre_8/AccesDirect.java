/* Illustration de l'accès direct avec un fichier à adressage relatif
 * Opérations permises :
 *      sélectionner un enregistrement par son NER
 *      modifier le prix d'un enregistrement sélectionné par son NER
 *      créer un nouvel enregistrement (toujours à la fin)
 *      (ne permet pas la suppression)
 */

import java.io.*;
import javax.swing.JOptionPane;

public class AccesDirect {

  // Affiche le contenu d'un enregistrement
  public static void afficher(int numeroER, Plant unPlant) {
    JOptionPane.showMessageDialog(null,
        "NER :" + numeroER
            + "\nnoPlant :" + unPlant.getNoPlant()
            + "\ndescription :" + unPlant.getDescription()
            + "\nprixUnitaire :" + unPlant.getPrixUnitaire());
  }

  public static void main(String[] args) throws Exception {
    File leFichier = new File("DirectPlants.dat");
    boolean existe = leFichier.exists();
    // Ouverture du fichier ou création s'il n'existe pas
    // Le fichier est fermé automatiquement à la fin du bloc try
    try (RandomAccessFile fichierDirectPlants =
        new RandomAccessFile(leFichier, "rw")) {
      int nombreAlloue; // nombre d'enregistrements actuellement alloués
      if (existe) {
        // Cherche le nombre d'enregistrements actuellement alloués
        nombreAlloue = fichierDirectPlants.readInt();
      } else { // Le fichier n'existe pas, il faut initialiser nombreAlloue
        nombreAlloue = 0;
        fichierDirectPlants.writeInt(nombreAlloue);
      }

      String chaineNER;
      int numeroER;
      Plant unPlant = new Plant(0, "", 0.0);
      boolean continuer = true;

      while (continuer) {
        String chaineChoix = JOptionPane.showInputDialog(
            "Menu: 1(lire); 2(modifier prix); 3(ajouter) ; 0 (terminer)");
        int choix = Integer.parseInt(chaineChoix);

        switch (choix) {
          case 1: // Lire et afficher l'enregistrement
            chaineNER = JOptionPane.showInputDialog(
                "Entrez le numéro d'enregistrement relatif :");
            numeroER = Integer.parseInt(chaineNER);
            if (numeroER >= 0 && numeroER < nombreAlloue) {
              // Sélectionner un enregistrement par son NER
              fichierDirectPlants.seek(
                  numeroER * Plant.tailleMaxEnregistrement() + 4);
              unPlant.lireEnregistrementTailleMax(fichierDirectPlants);
              afficher(numeroER, unPlant);
            } else {
              JOptionPane.showMessageDialog(
                  null, "Numéro incorrect :" + numeroER);
            }
            break;

          case 2: // Modifier un enregistrement
            chaineNER = JOptionPane.showInputDialog(
                "Entrez le numéro d'enregistrement relatif :");
            numeroER = Integer.parseInt(chaineNER);
            if (numeroER >= 0 && numeroER < nombreAlloue) {
              // D'abord sélectionner l'enregistrement par son NER
              fichierDirectPlants.seek(
                  numeroER * Plant.tailleMaxEnregistrement() + 4);
              unPlant.lireEnregistrementTailleMax(fichierDirectPlants);

              // Modifier son prix en mémoire centrale
              String chainePrix =
                  JOptionPane.showInputDialog("Entrez le nouveau prix :");
              unPlant.setPrixUnitaire(Double.parseDouble(chainePrix));

              // Écrire l'enregistrement modifié
              fichierDirectPlants.seek(
                  numeroER * Plant.tailleMaxEnregistrement() + 4);
              unPlant.ecrireEnregistrementTailleMax(fichierDirectPlants);
              afficher(numeroER, unPlant);
            } else {
              JOptionPane.showMessageDialog(
                  null, "Numéro incorrect :" + numeroER);
            }
            break;

          case 3: // Créer un enregistrement
            String chaineNoPlant =
                JOptionPane.showInputDialog("Entrez le noPlant :");
            unPlant.setNoPlant(Integer.parseInt(chaineNoPlant));
            unPlant.setDescription(
                JOptionPane.showInputDialog("Entrez la description :"));
            String chainePrix =
                JOptionPane.showInputDialog("Entrez le prixUnitaire :");
            unPlant.setPrixUnitaire(Double.parseDouble(chainePrix));

            // Allocation sérielle : NER du nouvel enregistrement =
            // nombreAlloue
            fichierDirectPlants.seek(
                nombreAlloue * Plant.tailleMaxEnregistrement() + 4);
            unPlant.ecrireEnregistrementTailleMax(fichierDirectPlants);
            afficher(nombreAlloue, unPlant);

            // Incrémenter le nombre d'enregistrements alloués
            nombreAlloue++;
            fichierDirectPlants.seek(0);
            fichierDirectPlants.writeInt(nombreAlloue);
            break;

          case 0: // Terminer
            continuer = false;
            break;

          default:
            JOptionPane.showMessageDialog(
                null, "Choix incorrect :" + choix);
        }
      }
    }
    System.exit(0);
  }
}
