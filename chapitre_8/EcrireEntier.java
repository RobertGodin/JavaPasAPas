/* Création d'un DataOutputStream à partir d'un fichier et écriture d'un
 * entier dans le fichier */

import java.io.*;

public class EcrireEntier {
  public static void main(String[] args) {
    try (DataOutputStream unFichier =
        new DataOutputStream(new FileOutputStream("UnEntier.dat"))) {
      int unEntier = 1629696561; // "a#21" vu comme 4 octets
      unFichier.writeInt(unEntier);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
