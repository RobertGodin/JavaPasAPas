/*
 * ExempleLogique.java
 * Petit exemple illustrant l'énoncé if.
 */
import javax.swing.JOptionPane;
public class ExempleLogique{
    public static void main (String args[]) {
        String unString = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        int unInt = Integer.parseInt(unString);

        // Exemples d'opérateurs logiques
        if (unInt > 10 & unInt < 20)
            JOptionPane.showMessageDialog(null,unInt + " est entre 10 et 20");
        if (unInt == 100 | unInt == 200)
            JOptionPane.showMessageDialog(null,unInt + " est 100 ou 200");
        if (!(unInt > 30))
            JOptionPane.showMessageDialog(null,unInt + " n'est pas plus grand que 30");
        
        System.exit(0);
    }
}