/* Illustration du StreamTokenizer
 * Lit le fichier Plants.txt, affiche à l'écran chacun des jetons
 * (noPlant, description, prixUnitaire) et stocke le contenu dans un
 * vecteur (ArrayList) d'objets Plant */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExempleStreamTokenizer {
  public static void main(String[] args) {
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

      // Jusqu'à la fin du fichier
      while (unStreamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
        // Lecture du noPlant : est-ce bien un nombre ?
        if (unStreamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
          noPlant = (int) unStreamTokenizer.nval; // nval est un double !
        } else {
          System.out.println("Format incorrect : noPlant attendu");
          System.exit(1);
        }
        // Lecture de la description : est-ce bien une chaîne entre " ?
        unStreamTokenizer.nextToken();
        if (unStreamTokenizer.ttype == (int) '"') {
          description = unStreamTokenizer.sval;
        } else {
          System.out.println("Format incorrect : description attendue");
          System.exit(1);
        }
        // Lecture du prixUnitaire : est-ce bien un nombre ?
        unStreamTokenizer.nextToken();
        if (unStreamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
          prixUnitaire = unStreamTokenizer.nval;
        } else {
          System.out.println("Format incorrect : prix attendu");
          System.exit(1);
        }

        // Création de l'objet Plant
        Plant unPlant = new Plant(noPlant, description, prixUnitaire);
        System.out.println(
            noPlant + " " + description + " " + prixUnitaire);
        vecteurDePlants.add(unPlant);
      }
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
