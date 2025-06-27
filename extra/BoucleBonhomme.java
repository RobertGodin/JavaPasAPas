/*
 * BoucleBonhomme.java
 * Exemple de boucle qui affiche une série de bonhommes
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoucleBonhomme extends JFrame {

  /** Constructeur de ExempleObjetBonhomme */
  public BoucleBonhomme() {
    super("Affichage d'une série de bonhommes");
  }

  // paint() est appelée indirectement lors de la création du JFrame par show()
  public void paint(Graphics g) {
    Bonhomme unBonhomme = new Bonhomme(0, 50, 100, 200);
    for (int x = 0; x <= 200; x = x + 5) {
      unBonhomme.setX(x);
      unBonhomme.paint(g);
    }
  }

  public static void main(String args[]) {
    BoucleBonhomme leFrame = new BoucleBonhomme();
    leFrame.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });
    leFrame.setSize(300, 300);
    leFrame.show();
  }
}
