/*
 * ExerciceIfMax3.java
 * Lire trois entiers et afficher le maximum des trois
 */
import javax.swing.JOptionPane;
public class ExerciceIfMax3{

    public static void main (String args[]) {
    
    String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
    String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
    String chaine3 = JOptionPane.showInputDialog("Entrez un troisième nombre entier");
    
    int entier1 = Integer.parseInt(chaine1);
    int entier2 = Integer.parseInt(chaine2);
    int entier3 = Integer.parseInt(chaine3);
    
    if (entier1 > entier2)
        if (entier1 > entier3)
            JOptionPane.showMessageDialog(null,"Le maximum des trois entiers est " + entier1);
        else
            JOptionPane.showMessageDialog(null,"Le maximum des trois entiers est " + entier3);
    else
        if (entier2 > entier3)
            JOptionPane.showMessageDialog(null,"Le maximum des trois entiers est " +entier2);
        else
            JOptionPane.showMessageDialog(null,"Le maximum des trois entiers est " +entier3);
    System.exit(0);
    }
}