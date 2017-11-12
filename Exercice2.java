/*
 * Exercice2.java
 * Lire 3 entiers et en faire la somme. Utiliser seulement une variable String
 * et deux variables int.
 */
import javax.swing.JOptionPane;
public class Exercice2{

    public static void main (String args[]) {
        
        String chaine = JOptionPane.showInputDialog ("Entrez un entier dans cette case");
        int entier = Integer.parseInt(chaine);
        int somme = entier;
        
        chaine = JOptionPane.showInputDialog ("Entrez un entier dans cette case");
        entier = Integer.parseInt(chaine);
        somme = somme + entier;
        
        chaine = JOptionPane.showInputDialog ("Entrez un entier dans cette case");
        entier = Integer.parseInt(chaine);
        somme = somme + entier;
        
        JOptionPane.showMessageDialog(null,"La somme des trois entiers est " + somme);
        System.exit(0);
    }
}
