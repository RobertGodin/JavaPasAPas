/**
 * ExerciceIfMax2.java
 * Lire trois entiers et afficher le maximum des trois
 */
import javax.swing.JOptionPane;
public class ExerciceIfMax2{

    public static void main (String args[]) {
    
    String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
    String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
    
    int entier1 = Integer.parseInt(chaine1);
    int entier2 = Integer.parseInt(chaine2);
    
    if (entier1 > entier2)
      JOptionPane.showMessageDialog(null,"Le maximum des deux entiers est " + entier1);
    else
      JOptionPane.showMessageDialog(null,"Le maximum des deux entiers est " + entier2);

    System.exit(0);
    }
}
