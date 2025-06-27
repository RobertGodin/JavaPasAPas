/* Lit un fichier octet par octet et affiche la valeur décimale de chaque octet, une par ligne */
import java.io.*;

public class LireFichierOctet {
  public static void main(String args[]) {
    int unOctet;
    FileInputStream unFichier;
    try {
      unFichier = new FileInputStream("C:/forte4j/Development/LivreJava/Fichier1.txt");
      while ((unOctet = unFichier.read()) != -1) System.out.println(unOctet);
      unFichier.close();
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
