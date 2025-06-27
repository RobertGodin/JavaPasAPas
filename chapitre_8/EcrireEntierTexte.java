/* création d'un FileWriter à partir d'un fichier et écriture d'un entier dans le fichier
sous forme d'une chaîne de caractères */
import java.io.*;

public class EcrireEntierTexte {
  public static void main(String args[]) {
    FileWriter unFichier;
    try {
      unFichier = new FileWriter("UnEntier.txt");
      unFichier.write("1629696561");
      unFichier.close();
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
