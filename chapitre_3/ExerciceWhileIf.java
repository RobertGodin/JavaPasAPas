/**
 * ExerciceWhileIf.java
 * Lire 5 entiers et afficher l'entier maximal
 */
import javax.swing.JOptionPane;
public class ExerciceWhileIf{
   public static void main (String args[]) {
   
    String chaine = JOptionPane.showInputDialog("Entrez un nombre");
    int plusGrand = Integer.parseInt (chaine);
    for (int compteur = 1; compteur < 5; compteur=compteur+1){
      chaine = JOptionPane.showInputDialog("Entrez un nombre entier");
      int entier = Integer.parseInt (chaine);
      if (entier > plusGrand) {
        plusGrand = entier;
      }
    }
    JOptionPane.showMessageDialog(null,"L'entier le plus grand est " + plusGrand);
    System.exit(0);
    }
}
