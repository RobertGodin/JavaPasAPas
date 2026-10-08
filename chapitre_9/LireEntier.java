/* Lecture dans le fichier d'un entier à l'aide d'un DataInputStream */
import java.io.*;

public class LireEntier {
  public static void main(String[] args) {
    try (DataInputStream unFichier =
        new DataInputStream(new FileInputStream("UnEntier.dat"))) {
      int unEntier = unFichier.readInt();
      System.out.println("Valeur décimale de l'entier : " + unEntier);
    } catch (IOException e) {
      System.err.println("Exception\n" + e.toString());
    }
  }
}
