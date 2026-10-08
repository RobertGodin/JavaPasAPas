import java.io.*;
import javax.swing.JOptionPane;

public class VerifierExistenceFichier {
  public static void main(String[] args) {
    File leFile = new File("Octets.dat");
    if (leFile.exists()) {
      String reponse = JOptionPane.showInputDialog(
          "Voulez-vous détruire le contenu existant (oui ou non)?");
      if (reponse.equals("non")) {
        System.out.println("Le fichier demeure tel quel");
        System.exit(0);
      }
    }
    try (FileOutputStream unFichier = new FileOutputStream(leFile)) {
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
    System.exit(0);
  }
}
