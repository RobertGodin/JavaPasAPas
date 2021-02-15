/*
 * Exemple d'utilisation d'une méthode statique pour dessiner le bonhomme
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex3BonhommesAvecPaintBonhomme extends JFrame {

  public Ex3BonhommesAvecPaintBonhomme() {
    super("Exemple d'utilisation d'une méthode statique paintBonhomme");
  }

  public static void paintBonhomme(Graphics g, int x, int y, int largeur, int hauteur) {
    // Bonhomme à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
    g.setColor(Color.green);
    g.fillOval(x, y, largeur, hauteur / 2); // La tête

    g.setColor(Color.black);
    g.fillRect(x + largeur / 4, y + hauteur / 8, largeur / 10, hauteur / 20); // L'oeil gauche
    g.fillRect(
        x + largeur * 3 / 4 - largeur / 10,
        y + hauteur / 8,
        largeur / 10,
        hauteur / 20); // L'oeil droit
    g.drawLine(
        x + largeur / 4,
        y + hauteur * 3 / 8,
        x + largeur * 3 / 4,
        y + hauteur * 3 / 8); // La bouche

    g.setColor(Color.red);
    g.fillRect(x, y + hauteur / 2, largeur, hauteur / 2); // Le corps
  }

  public void paint(Graphics g) {
    paintBonhomme(g, 100, 100, 100, 200);
    paintBonhomme(g, 50, 50, 50, 100);
    paintBonhomme(g, 30, 30, 10, 20);
  }

  public static void main(String args[]) {
    Ex3BonhommesAvecPaintBonhomme leFrame = new Ex3BonhommesAvecPaintBonhomme();
    leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    leFrame.setSize(400, 600);
    leFrame.setVisible(true);
  }
}
