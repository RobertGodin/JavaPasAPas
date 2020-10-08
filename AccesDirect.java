/* Illustration de l'accès direct avec un fichier à adressage relatif
 * Opérations permises :
 *      sélectionner un enregistrement par son NER
 *      modifier le prix d'un enregistrement sélectionné par son NER
 *      créer un nouvel enregistrement (toujours à la fin)
 *      (ne permet pas la suppression)
 */

import java.io.*;
import javax.swing.JOptionPane;

public class AccesDirect{
    
    public static void main (String args[]) throws Exception{
        //Ouverture du fichier ou creation si n'existe pas
        int nombreAlloue; // nombre d'enregistrements actuellement alloués
        RandomAccessFile fichierDirectPlants;
        File leFichier = new File("paramètres/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/DirectPlants.dat");
        if (leFichier.exists()){// Fichier existe ?
            fichierDirectPlants = new RandomAccessFile (leFichier,"rw");
            // Cherche le nombre d'enregistrements actuellement alloués
            nombreAlloue = fichierDirectPlants.readInt();
        }else{ // Le fichier n'existe pas, il faut initialiser nombreAlloue
            fichierDirectPlants = new RandomAccessFile (leFichier,"rw");
            // Initialiser nombreAlloue
            nombreAlloue = 0;
            fichierDirectPlants.writeInt(nombreAlloue);
        }

        String chaineNER;
        int numeroER;
        Plant unPlant = new Plant(0,"",0.0);

        while(true) {
            String chaineChoix = JOptionPane.showInputDialog("Menu: 1(lire); 2(modifier prix); 3(ajouter) ; 0 (terminer)");
            int choix = Integer.parseInt(chaineChoix);

            switch(choix){
                case 1: // Lire et afficher l'enregistrement
                chaineNER = JOptionPane.showInputDialog("Entrez le numéro d'enregistrement relatif :");
                numeroER = Integer.parseInt(chaineNER);
                if (numeroER >= 0 && numeroER < nombreAlloue){
                    // sélectionner un enregistrement par son NER
                    fichierDirectPlants.seek(numeroER*Plant.tailleMaxEnregistrement()+4);
                    unPlant.lireEnregistrementTailleMax(fichierDirectPlants);

                    JOptionPane.showMessageDialog(null,
                    "NER :" + numeroER +
                    "\nnoPlant :" + unPlant.getNoPlant() +
                    "\ndescription :" + unPlant.getDescription() +
                    "\nprixUnitaire :" + unPlant.getPrixUnitaire());

                } else
                {
                    JOptionPane.showMessageDialog(null,"Numéro incorrect :" + numeroER);
                }
                break;

                case 2: // Modifier un enregistrement
                chaineNER = JOptionPane.showInputDialog("Entrez le numéro d'enregistrement relatif :");
                numeroER = Integer.parseInt(chaineNER);
                if (numeroER >= 0 && numeroER < nombreAlloue){
                    // D'abord sélectionner l'enregistrement par son NER
                    fichierDirectPlants.seek(numeroER*Plant.tailleMaxEnregistrement()+4);
                    unPlant.lireEnregistrementTailleMax(fichierDirectPlants);

                    // Modifier son prix en mémoire centrale
                    String chainePrix = JOptionPane.showInputDialog("Entrez le nouveau prix :");
                    unPlant.setPrixUnitaire(Double.parseDouble(chainePrix));

                    // Ecrire l'enregistrement modifié
                    fichierDirectPlants.seek(numeroER*Plant.tailleMaxEnregistrement()+4);
                    unPlant.ecrireEnregistrementTailleMax(fichierDirectPlants);

                    JOptionPane.showMessageDialog(null,
                    "NER :" + numeroER +
                    "\nnoPlant :" + unPlant.getNoPlant() +
                    "\ndescription :" + unPlant.getDescription() +
                    "\nprixUnitaire :" + unPlant.getPrixUnitaire());
                } else
                {
                    JOptionPane.showMessageDialog(null,"Numéro incorrect :" + numeroER);
                }
                break;

                case 3: // créer un enregistrement
                String chaineNoPlant = JOptionPane.showInputDialog("Entrez le noPlant :");
                unPlant.setNoPlant(Integer.parseInt(chaineNoPlant));
                unPlant.setDescription(JOptionPane.showInputDialog("Entrez la description :"));
                String chainePrix = JOptionPane.showInputDialog("Entrez le prixUnitaire :");
                unPlant.setPrixUnitaire(Double.parseDouble(chainePrix));

                // Allocation sérielle : le NER du nouvel enregistrement = nombreAlloue
                fichierDirectPlants.seek(nombreAlloue*Plant.tailleMaxEnregistrement()+4);
                unPlant.ecrireEnregistrementTailleMax(fichierDirectPlants);

                JOptionPane.showMessageDialog(null,
                "NER :" + nombreAlloue +
                "\nnoPlant :" + unPlant.getNoPlant() +
                "\ndescription :" + unPlant.getDescription() +
                "\nprixUnitaire :" + unPlant.getPrixUnitaire());

                // Incr�menter le nombre d'enregistrements alloués
                nombreAlloue++;
                fichierDirectPlants.seek(0);
                fichierDirectPlants.writeInt(nombreAlloue);
                break;

                case 0: // Terminer
                fichierDirectPlants.close();
                System.exit(0);
                break;

                default: JOptionPane.showMessageDialog(null,"Choix incorrect :" + choix);

            }
        }
    }
}