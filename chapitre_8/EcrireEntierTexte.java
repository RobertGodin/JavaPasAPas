/* Création d'un FileWriter à partir d'un fichier et écriture d'un entier
 * dans le fichier sous forme d'une chaîne de caractères */
import java.io.*;
import java.nio.charset.StandardCharsets;

public class EcrireEntierTexte {
  public static void main(String[] args) {
    // Le texte est encodé en UTF-8
    try (FileWriter unFichier =
        new FileWriter("UnEntier.txt", StandardCharsets.UTF_8)) {
      unFichier.write("1629696561");
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
