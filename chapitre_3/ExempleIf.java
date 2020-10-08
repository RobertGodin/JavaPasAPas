/**
 * ExempleIf.java
 * Petit exemple illustrant l'énoncé if.
 */
import javax.swing.JOptionPane;
public class ExempleIf{
    public static void main (String args[]) {
        String unString = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        int unInt = Integer.parseInt(unString);

        // Exemple d'énoncé if
        if (unInt > 10)
            JOptionPane.showMessageDialog(null,unInt + " est plus grand que 10");
        else
            JOptionPane.showMessageDialog(null,unInt + " n'est pas plus grand que 10");            

        System.exit(0);
    }
}
