/** ExempleWhile.java Exemple d'utilisation d'une boucle while avec un compteur */
import javax.swing.JOptionPane;

public class ExempleWhile {
  public static void main(String args[]) {
    int compteur = 1;
    while (compteur <= 5) {
      JOptionPane.showMessageDialog(null, "Valeur du compteur: " + compteur);
      compteur = compteur + 1;
    }
    System.exit(0);
  }
}
