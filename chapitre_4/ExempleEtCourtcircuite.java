/**
 * ExempleEtCourtcircuite.java
 * Petit exemple illustrant l'�nonc� if.
 */
import javax.swing.JOptionPane;
public class ExempleEtCourtcircuite{
    public static void main (String args[]) {
        String unString = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        int unInt = Integer.parseInt(unString);

        // Exemple de l'op�rateur &
        if (unInt != 0 && 10 % unInt == 0)
            JOptionPane.showMessageDialog(null,unInt + " est un diviseur de 10");
        else
            JOptionPane.showMessageDialog(null,unInt + " n'est pas un diviseur de 10");
        System.exit(0);
    }
}
