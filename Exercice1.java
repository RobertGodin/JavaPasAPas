/*
 * Exercice1.java
 * Lire 3 entiers et en afficher la somme
 */
import javax.swing.JOptionPane;
public class Exercice1{

    public static void main (String args[]) {
    
        String chaine1 = JOptionPane.showInputDialog("Entrez un premier nombre entier");
        String chaine2 = JOptionPane.showInputDialog("Entrez un second nombre entier");
        String chaine3 = JOptionPane.showInputDialog("Entrez un troisième nombre entier");

        int entier1 = Integer.parseInt(chaine1);
        int entier2 = Integer.parseInt(chaine2);
        int entier3 = Integer.parseInt(chaine3);
        
        int somme = entier1 + entier2 + entier3;

        JOptionPane.showMessageDialog(null,"La somme des trois entiers est " + somme);
        System.exit(0);
    }
}