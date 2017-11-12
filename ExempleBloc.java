/*
 * ExempleBloc.java
 * Modification de Exemple1 avec un bloc imbriqu�
 */
import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane
public class ExempleBloc{

    public static void main (String args[]) {

        // D�claration de variables
        String chaine1, chaine2;      // Les entiers sous forme de cha�nes
        int entier1, entier2, somme;  // Les entiers � additionner

        // Saisir les deux cha�nes de caract�res qui repr�sentent des nombres entiers
        {
          chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
          chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
        }

        // Convertir les cha�nes en entiers
        entier1 = Integer.parseInt(chaine1);
        entier2 = Integer.parseInt(chaine2);

        // Calculer la somme des deux entiers
        somme = entier1 + entier2;

        // Afficher la somme avec JOptionPane.showMessageDialog
        JOptionPane.showMessageDialog(null,"La somme des deux entiers est " + somme);

        // Appel de System.exit(0) n�cessaire � cause des appels �
        // JOptionPane.showInputDialog et JOptionPane.showMessageDialog
        System.exit(0);
    }
}