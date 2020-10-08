/*
 * Exemple2.java
 * Ce programme saisit deux entiers et en affiche la somme
 */
import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane

public class Exemple2 {

  public static void main(String args[]) {

    // Saisir les deux chaînes de caractères qui représentent des nombres entiers
    String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
    String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");

    // Convertir les chaînes en entiers
    int entier1 = Integer.parseInt(chaine1);
    int entier2 = Integer.parseInt(chaine2);

    // Calculer la somme des deux entiers
    int somme = entier1 + entier2;

    // Afficher la somme avec JOptionPane.showMessageDialog
    JOptionPane.showMessageDialog(null, "La somme des deux entiers est " + somme);

    // Appel de System.exit(0) nécessaire à cause des appels à
    // JOptionPane.showInputDialog et JOptionPane.showMessageDialog
    System.exit(0);
  }
}
