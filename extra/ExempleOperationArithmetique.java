/*
 * ExempleOperationArithmetique.java
 * Ce programme saisit deux entiers et affiche le r�sultat d'op�rations arithm�tiques de base
 */
import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane
public class ExempleOperationArithmetique{

    public static void main (String args[]) {

        // Saisir les deux chaînes de caractères qui repr�sentent des nombres entiers
        String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");

        // Convertir les chaînes en entiers
        int entier1 = Integer.parseInt(chaine1);
        int entier2 = Integer.parseInt(chaine2);

        // Afficher la somme avec JOptionPane.showMessageDialog
        JOptionPane.showMessageDialog(null,entier1 + "+" + entier2 + "=" + (entier1 + entier2));
        JOptionPane.showMessageDialog(null,entier1 + "-" + entier2 + "=" + (entier1 - entier2));
        JOptionPane.showMessageDialog(null,entier1 + "*" + entier2 + "=" + (entier1 * entier2));
        JOptionPane.showMessageDialog(null,entier1 + "/" + entier2 + "=" + (entier1 / entier2));
        JOptionPane.showMessageDialog(null,entier1 + "%" + entier2 + "=" + (entier1 % entier2));

        System.exit(0);
    }
}