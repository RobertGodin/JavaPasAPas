/**
 * ExerciceWhileSentinelle.java
 * Lire une suite d'entiers jusqu'à ce que l'entier 0 soit entré et afficher la somme
 * des entiers lus.
 */
import javax.swing.JOptionPane;
public class ExerciceWhileSentinelle {
    public static void main (String args[]) {
        String serie;
        int somme = 0;
        int entier = 1; // N'importe quelle valeur différente de 0 ferait l'affaire
        while (entier != 0) {
            serie = JOptionPane.showInputDialog("Entrez un nombre");
            entier = Integer.parseInt (serie);
            somme = somme + entier;
    }
        JOptionPane.showMessageDialog(null,"La somme de tous les nombres est de " +somme+ ".");
        System.exit(0);
    }
}
