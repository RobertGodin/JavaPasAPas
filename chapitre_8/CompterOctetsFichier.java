/* Lire un fichier et en compter le nombre d'octets */

import java.io.*;

public class CompterOctetsFichier {
  public static void main(String[] args) {
    int unOctet;
    int compteurOctet = 0;
    // Le fichier est fermé automatiquement à la fin du bloc try
    try (FileInputStream unFichier = new FileInputStream("Fichier1.txt")) {
      while ((unOctet = unFichier.read()) != -1) compteurOctet++;
      System.out.println(
          "Nombre d'octets du fichier Fichier1.txt : " + compteurOctet);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
