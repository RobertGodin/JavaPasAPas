/*
 * ExerciceWhile1.java
 * Afficher les valeurs 0,2,4,6,8,10
 */
import javax.swing.JOptionPane;
public class ExerciceWhile1{
   public static void main (String args[]) {
        int compteur = 0;
        while(compteur <= 10){
            JOptionPane.showMessageDialog(null,"Valeur du compteur: "+compteur);
            compteur = compteur + 2;
        }
        System.exit(0);
    }
}