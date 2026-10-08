/* Lecture dans le fichier d'un entier sous forme de texte à l'aide d'un
 * FileReader */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LireEntierTexte {
  public static void main(String[] args) {
    try (FileReader unFichier =
        new FileReader("UnEntier.txt", StandardCharsets.UTF_8)) {
      char[] tableauChar = new char[10];
      unFichier.read(tableauChar, 0, 10);
      int unEntier = Integer.parseInt(new String(tableauChar, 0, 10));
      System.out.println("Valeur décimale de l'entier : " + unEntier);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
