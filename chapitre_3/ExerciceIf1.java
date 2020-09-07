/**
 * ExerciceIf1.java
 * Lire deux entiers et afficher la division entière.
 * Si le diviseur est 0 afficher un message à cet effet.
 */
import javax.swing.JOptionPane;
public class ExerciceIf1 {

    public static void main (String args[]) {
    
        String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
        int entier1 = Integer.parseInt(chaine1);
        int entier2 = Integer.parseInt(chaine2);
        
        if (entier2 == 0)
             JOptionPane.showMessageDialog(null,"La division est impossible");
        else
            JOptionPane.showMessageDialog(null,entier1 + "/" + entier2 + "=" + entier1 / entier2);
        System.exit(0);
    }
}
