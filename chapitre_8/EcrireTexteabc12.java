/* Création d'un PrintWriter à partir d'un fichier et écriture de texte
 * avec println */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EcrireTexteabc12 {
  public static void main(String[] args) {
    try (PrintWriter unPrintWriter = new PrintWriter(
        new FileWriter("Fichier1.txt", StandardCharsets.UTF_8))) {
      unPrintWriter.println("abc");
      unPrintWriter.println(12);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
