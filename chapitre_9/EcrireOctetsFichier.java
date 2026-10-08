/* Création d'un fichier et écriture d'une suite d'octets */
import java.io.*;

public class EcrireOctetsFichier {
  public static void main(String[] args) {
    try (FileOutputStream unFichier =
        new FileOutputStream("Fichier1.txt")) {
      unFichier.write(0X61);
      unFichier.write(0X62);
      unFichier.write(0X63);
      unFichier.write(0X0D);
      unFichier.write(0X0A);
      unFichier.write(0X31);
      unFichier.write(0X32);
      unFichier.write(0X0D);
      unFichier.write(0X0A);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
