/*
 * ExempleObjetBonhomme.java
 * Exemple de dessin avec paint dans JFrame
 * Encapsulation du dessin dans une méthode statique pintBonhomme
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceBoucleBonhomme extends JFrame {

  private Bonhomme unBonhomme;

  /** Constructeur de ExempleObjetBonhomme */
  public ExerciceBoucleBonhomme() {
    super("Exemple d'utilisation d'un objet de la classe Bonhomme");
  }

  // paint() est appelée indirectement lors de la création du JFrame par show()
  public void paint(Graphics g) {
    int w = 50;
    int compteur = 10;
    while (compteur > 0) {
      unBonhomme = new Bonhomme(100, w, 100, 200);
      unBonhomme.paint(g);
      compteur = compteur - 1;
      w = w + 30;
    }
  }

  public static void main(String args[]) {
    ExerciceBoucleBonhomme leFrame = new ExerciceBoucleBonhomme();
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
