import java.awt.*;
import javax.swing.JFrame;

public class Exemple2CrabesRectangleEnglobant extends JFrame {

  public Exemple2CrabesRectangleEnglobant() {
    super("2 crabes avec rectangle englobant");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  public void paint(Graphics g) {
    super.paint(g);

    // Rectangle englobant du premier crabe
    int x = 80;
    int y = 100;
    int largeur = 240;
    int hauteur = 160;

    // Crabe à l'échelle dans un rectangle englobant
    // défini par x,y,largeur,hauteur
    g.setColor(Color.green);
    // Le corps
    g.fillOval(
        x + largeur / 8, y + hauteur / 4, largeur * 3 / 4, hauteur / 2);

    g.setColor(Color.black);
    // L'oeil gauche
    g.fillRect(
        x + largeur * 3 / 8,
        y + hauteur * 3 / 8,
        largeur / 12,
        hauteur / 8);
    // L'oeil droit
    g.fillRect(
        x + largeur * 5 / 8 - largeur / 12,
        y + hauteur * 3 / 8,
        largeur / 12,
        hauteur / 8);
    // La bouche
    g.drawLine(
        x + largeur * 3 / 8,
        y + hauteur * 5 / 8,
        x + largeur * 5 / 8,
        y + hauteur * 5 / 8);

    g.setColor(Color.red);
    // Les pinces
    g.fillRect(x, y + hauteur / 8, largeur / 8, hauteur / 2);
    g.fillRect(
        x + largeur * 7 / 8, y + hauteur / 8, largeur / 8, hauteur / 2);

    // Rectangle englobant du deuxième crabe
    x = 20;
    y = 280;
    largeur = 120;
    hauteur = 80;

    // Crabe à l'échelle dans un rectangle englobant
    // défini par x,y,largeur,hauteur
    g.setColor(Color.green);
    // Le corps
    g.fillOval(
        x + largeur / 8, y + hauteur / 4, largeur * 3 / 4, hauteur / 2);

    g.setColor(Color.black);
    // L'oeil gauche
    g.fillRect(
        x + largeur * 3 / 8,
        y + hauteur * 3 / 8,
        largeur / 12,
        hauteur / 8);
    // L'oeil droit
    g.fillRect(
        x + largeur * 5 / 8 - largeur / 12,
        y + hauteur * 3 / 8,
        largeur / 12,
        hauteur / 8);
    // La bouche
    g.drawLine(
        x + largeur * 3 / 8,
        y + hauteur * 5 / 8,
        x + largeur * 5 / 8,
        y + hauteur * 5 / 8);

    g.setColor(Color.red);
    // Les pinces
    g.fillRect(x, y + hauteur / 8, largeur / 8, hauteur / 2);
    g.fillRect(
        x + largeur * 7 / 8, y + hauteur / 8, largeur / 8, hauteur / 2);
  }

  public static void main(String[] args) {
    new Exemple2CrabesRectangleEnglobant();
  }
}
