/* Copier un fichier octet par octet */

import java.io.*;

public class CopierFichier {
  public static void main(String[] args) {
    int unOctet;
    // Les deux fichiers sont fermés automatiquement à la fin du bloc try
    try (FileInputStream unFileInputStream =
            new FileInputStream("Fichier1.txt");
        FileOutputStream unFileOutputStream =
            new FileOutputStream("Fichier2.txt")) {
      while ((unOctet = unFileInputStream.read()) != -1)
        unFileOutputStream.write(unOctet);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
