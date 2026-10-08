import java.awt.*;
import javax.swing.JFrame;

public class ExempleMethodePaintCrabe extends JFrame {

  public ExempleMethodePaintCrabe() {
    super("2 crabes avec méthode paintCrabe()");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  // Méthode qui dessine un crabe dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
  public static void paintCrabe(
      Graphics g, int x, int y, int largeur, int hauteur) {
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

  public void paint(Graphics g) {
    super.paint(g);
    // Dessin du premier crabe
    paintCrabe(g, 80, 100, 240, 160);
    // Dessin du deuxième crabe
    paintCrabe(g, 20, 280, 120, 80);
  }

  public static void main(String[] args) {
    new ExempleMethodePaintCrabe();
  }
}
