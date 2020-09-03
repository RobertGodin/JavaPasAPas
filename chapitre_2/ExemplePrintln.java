/*
 * ExemplePrintln.java
 * Ce programme saisit deux entiers et en affiche la somme avec System.out.println()
 */
import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane
public class ExemplePrintln{

    public static void main (String args[]) {

        // Déclaration de variables
        String chaine1, chaine2;      // Les entiers sous forme de chaînes
        int entier1, entier2, somme;  // Les entiers à additionner

        // Saisir les deux chaînes de caractères qui représentent des nombres entiers
        chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");

        // Convertir les chaînes en entiers
        entier1 = Integer.parseInt(chaine1);
        entier2 = Integer.parseInt(chaine2);

        // Calculer la somme des deux entiers
        somme = entier1 + entier2;

        // Afficher la somme avec System.out.println()
        System.out.println("La somme des deux entiers est " + somme);

        System.exit(0);
    }
}