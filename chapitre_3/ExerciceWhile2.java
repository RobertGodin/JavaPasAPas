/** ExerciceWhile2.java Afficher les valeurs de compteur 5,4,3,2,1,0,-1,-2,-3,-4,-5 */
import javax.swing.JOptionPane;

public class ExerciceWhile2 {
  public static void main(String args[]) {
    int compteur;
    compteur = 5;
    while (compteur >= -5) {
      JOptionPane.showMessageDialog(null, "Valeur du compteur:" + compteur);
      compteur = compteur - 1;
    }
    System.exit(0);
  }
}
