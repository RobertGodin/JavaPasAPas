/*
 * Exercice2.java
 * Lire 3 entiers et en faire la somme. Utiliser seulement une variable String
 * et deux variables int.
 */
import javax.swing.JOptionPane;

public class Exercice2 {

  public static void main(String args[]) {

    String chaine = JOptionPane.showInputDialog("Entrez un entier dans cette case");
    int somme = Integer.parseInt(chaine);

    chaine = JOptionPane.showInputDialog("Entrez un entier dans cette case");
    somme = somme + Integer.parseInt(chaine);

    chaine = JOptionPane.showInputDialog("Entrez un entier dans cette case");
    somme = somme + Integer.parseInt(chaine);

    JOptionPane.showMessageDialog(null, "La somme des trois entiers est " + somme);
    System.exit(0);
  }
}
