/* Création d'un fichier et écriture d'un entier sous forme d'une suite
 * d'octets dans le fichier */
import java.io.*;

public class EcrireEntierEnOctets {
  public static void main(String[] args) {
    try (FileOutputStream unFichier = new FileOutputStream("Octets.dat")) {
      int unEntier = 1629696561; // "a#21" vu comme 4 octets
      // Convertir unEntier en un tableau de 4 octets
      byte[] tampon = new byte[4];
      for (int i = 3; i >= 0; i--) {
        // Extrait l'octet le moins significatif
        tampon[i] = (byte) (unEntier & 0XFF);
        unEntier >>>= 8; // Décalage de 8 bits (remplissage à 0)
      }
      unFichier.write(tampon);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
