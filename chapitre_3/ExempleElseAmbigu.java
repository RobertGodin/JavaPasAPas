/**
 * ExempleElseAmbigu.java
 * Petit exemple illustrant l'ambiguité du else.
 */
import javax.swing.JOptionPane;
public class ExempleElseAmbigu{
    public static void main (String args[]) {
        String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
        int entier1 = Integer.parseInt(chaine1);
        int entier2 = Integer.parseInt(chaine2);

        // If ambigu
        if (entier1 > 10)
          if (entier2 > 10)
            JOptionPane.showMessageDialog(null,entier1 + " et "+ entier2 + " sont plus grands que 10");
        else
            JOptionPane.showMessageDialog(null,entier1 + " est inf�rieur ou �gal à 10");            

        System.exit(0);
    }
}
