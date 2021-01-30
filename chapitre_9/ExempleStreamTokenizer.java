/* Illustration du StreamTokenizer
 * Lit le fichier plants.txt, affiche à l'écran chacun des jetons (noPlant,description,prixUnitaire) et
 * stocke le contenu dans un vecteur d'objets Plant */

import java.io.*;
import java.util.*;

public class ExempleStreamTokenizer {
  public static void main(String args[]) {
    try {
      FileReader unFichier = new FileReader("Plants.txt");
      StreamTokenizer unStreamTokenizer = new StreamTokenizer(unFichier);

      // Les 5 lignes suivantes ne sont pas nécessaires car les paramètres
      // donnés sont les valeurs de défaut
      unStreamTokenizer.quoteChar((int) '"');
      unStreamTokenizer.whitespaceChars((int) '\r', (int) '\r');
      unStreamTokenizer.whitespaceChars((int) '\n', (int) '\n');
      unStreamTokenizer.whitespaceChars((int) '\t', (int) '\t');
      unStreamTokenizer.whitespaceChars((int) ' ', (int) ' ');

      Vector vecteurDePlants = new Vector();
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
        if (unStreamTokenizer.ttype == (int) '"') { // Est-ce bien une chaîne encadr�e par " ?
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
        vecteurDePlants.addElement(unPlant);
      }
      unFichier.close();
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
