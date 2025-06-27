/** ExempleIfIfElse.java Introduction d'un bloc pour terminer un if sans else */
import javax.swing.JOptionPane;

public class ExempleIfIfElse {
  public static void main(String args[]) {
    String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
    String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
    int entier1 = Integer.parseInt(chaine1);
    int entier2 = Integer.parseInt(chaine2);

    // If ambigu
    if (entier1 > 10) {
      if (entier2 > 10)
        JOptionPane.showMessageDialog(
            null, entier1 + " et " + entier2 + " sont plus grands que 10");
    } else JOptionPane.showMessageDialog(null, entier1 + " est inférieur ou égal à 10");

    System.exit(0);
  }
}
