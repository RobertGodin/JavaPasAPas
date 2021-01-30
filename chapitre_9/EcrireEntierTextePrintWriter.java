/* création d'un PrintWriter à partir d'un fichier et écriture d'un entier dans le fichier
sous forme d'une chaîne de caractères */

import java.io.*;

public class EcrireEntierTextePrintWriter {
  public static void main(String args[]) {
    FileWriter unFichier;
    PrintWriter unPrintWriter;
    try {
      unFichier = new FileWriter("UnEntierPW.txt");
      unPrintWriter = new PrintWriter(unFichier);
      unPrintWriter.print(1629696561);
      System.out.println(unFichier.getEncoding());
      unFichier.close();
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
