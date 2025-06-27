/*
 * ExerciceIf2.java
 * Lire trois entiers et afficher le plus grand des trois
 */
import javax.swing.JOptionPane;

public class ExerciceIf2 {

  public static void main(String args[]) {

    String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
    String chaine2 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
    String chaine3 = JOptionPane.showInputDialog("Entrez un premier nombre entier");

    int entier1 = Integer.parseInt(chaine1);
    int entier2 = Integer.parseInt(chaine2);
    int entier3 = Integer.parseInt(chaine3);

    if (entier1 > entier2)
      if (entier1 > entier3)
        JOptionPane.showMessageDialog(null, "Le premier nombre est le plus grand, soit " + entier1);
      else
        JOptionPane.showMessageDialog(
            null, "Le troisième nombre est le plus grand, soit " + entier3);
    else if (entier2 > entier3)
      JOptionPane.showMessageDialog(
          null, "Le deuxième nombre est le plus grand, c'est-à-dire " + entier2);
    else
      JOptionPane.showMessageDialog(
          null, "Le troisième nombre est le plus grand, c'est-à-dire " + entier3);
    System.exit(0);
  }
}
