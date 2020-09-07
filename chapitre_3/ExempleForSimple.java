/**
 * ExempleForSimple.java
 * Exemple d'utilisation d'un énoncé for qui affiche les entiers de 1 à 5
 */
import javax.swing.JOptionPane;
public class ExempleForSimple {
   public static void main (String args[]) {
    for (int compteur = 1; compteur <=5; compteur = compteur + 1)
        JOptionPane.showMessageDialog(null,"Valeur du compteur: "+compteur);
    System.exit(0);
    }
}
