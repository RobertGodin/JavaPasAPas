/*
 * ExerciceWhile3.java
 * Lire dix entiers et en afficher la somme avec un while
 */
import javax.swing.JOptionPane;
public class ExerciceWhile3 extends Object {
    public static void main (String args[]) {
        String serie;
        int entier;
        int compteur = 1;
        int somme = 0;
        while (compteur <=10){
            serie = javax.swing.JOptionPane.showInputDialog("Entrez un entier");
            entier = Integer.parseInt (serie);
            somme = somme + entier;
            compteur = compteur + 1;
        }
        JOptionPane.showMessageDialog(null,"La somme des dix entiers est " + somme);
        System.exit(0);
    }
}