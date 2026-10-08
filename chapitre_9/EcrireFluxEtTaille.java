/* Illustration de la création d'un fichier d'objets sériel
 * Lit le fichier plants.txt, stocke le contenu dans un vecteur d'objets Plant et
 * crée ensuite le fichier d'objets fluxPlants.dat par accès sériel*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class EcrireFluxEtTaille {

  // La méthode lit les données de Plants.txt et les retournent dans un vecteur d'objets
  // de la classe Plant
  // Reprend essentiellement le code de ExempleStreamTokenizer
  public static ArrayList<Plant> lirePlantsFichierTexte() throws Exception {

    ArrayList<Plant> vecteurDePlants = new ArrayList<Plant>();
    try (FileReader unFichier =
        new FileReader("Plants.txt", StandardCharsets.UTF_8)) {
    StreamTokenizer unStreamTokenizer = new StreamTokenizer(unFichier);

    // Les 5 lignes suivantes ne sont pas nécessaires car les paramètres
    // donnés sont les valeurs de défaut
    unStreamTokenizer.quoteChar((int) '"');
    unStreamTokenizer.whitespaceChars((int) '\r', (int) '\r');
    unStreamTokenizer.whitespaceChars((int) '\n', (int) '\n');
    unStreamTokenizer.whitespaceChars((int) '\t', (int) '\t');
    unStreamTokenizer.whitespaceChars((int) ' ', (int) ' ');

    int noPlant = 0;
    String description = "";
    double prixUnitaire = 0.0;

    while (unStreamTokenizer.nextToken() != StreamTokenizer.TT_EOF) { // fin du fichier ?
      // Lecture du noPlant
      if (unStreamTokenizer.ttype == StreamTokenizer.TT_NUMBER) { // Est-ce bien un nombre ?
        noPlant = (int) unStreamTokenizer.nval; // nval est un double !
      } else {
        System.out.println("Le format du fichier est incorrect : noPlant attendu");
        System.exit(1);
      }
      // Lecture de la description
      unStreamTokenizer.nextToken();
      if (unStreamTokenizer.ttype == (int) '"') { // Est-ce bien une chaîne encadrée par " ?
        description = unStreamTokenizer.sval;
      } else {
        System.out.println("Le format du fichier est incorrect : description attendue");
        System.exit(1);
      }
      // Lecture du prixUnitaire
      unStreamTokenizer.nextToken();
      if (unStreamTokenizer.ttype == StreamTokenizer.TT_NUMBER) { // Est-ce bien un nombre ?
        prixUnitaire = unStreamTokenizer.nval;
      } else {
        System.out.println("Le format du fichier est incorrect : prix attendu");
        System.exit(1);
      }

      // création de l'objet Plant
      Plant unPlant = new Plant(noPlant, description, prixUnitaire);
      System.out.println(noPlant + " " + description + " " + prixUnitaire);
      vecteurDePlants.add(unPlant);
    }
    }
    return vecteurDePlants;
  }

  // La méthode suivante écrit les objets de vecteurDePlants les uns à la suite
  // des autres dans le fichier FluxPlants.dat par accès sériel
  public static void écrireFichierFluxPlants(ArrayList<Plant> vecteurDePlants)
      throws Exception {
    try (ObjectOutputStream fichierFluxPlants =
        new ObjectOutputStream(new FileOutputStream("FluxPlants.dat"))) {
      for (Plant unPlant : vecteurDePlants) {
        // Taille de l'objet sérialisé seul
        ByteArrayOutputStream unBAOS = new ByteArrayOutputStream();
        try (ObjectOutputStream unOOS = new ObjectOutputStream(unBAOS)) {
          unOOS.writeObject(unPlant);
        }
        System.out.println("Taille :" + unBAOS.size());
        System.out.write(unBAOS.toByteArray());
        System.out.println();
        // le writeObject ajoute le nouvel objet à la fin du fichier
        fichierFluxPlants.writeObject(unPlant);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    ArrayList<Plant> vecteurDePlants = lirePlantsFichierTexte();
    écrireFichierFluxPlants(vecteurDePlants);
  }
}
