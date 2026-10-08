import java.awt.*;
import javax.swing.JFrame;

public class ExerciceMethodePaintSoucoupe extends JFrame {

  public ExerciceMethodePaintSoucoupe() {
    super("2 soucoupes avec méthode paintSoucoupe()");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  // Méthode qui dessine une soucoupe dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
  public static void paintSoucoupe(
      Graphics g, int x, int y, int largeur, int hauteur) {
    g.setColor(Color.cyan);
    // Le dôme
    g.fillOval(x + largeur / 4, y, largeur / 2, hauteur * 2 / 3);

    g.setColor(Color.red);
    // Le disque
    g.fillOval(x, y + hauteur / 3, largeur, hauteur * 2 / 3);

    g.setColor(Color.yellow);
    // Les hublots
    g.fillOval(x + largeur / 6, y + hauteur / 2, largeur / 8, hauteur / 4);
    g.fillOval(
        x + largeur / 2 - largeur / 16, y + hauteur / 2, largeur / 8,
        hauteur / 4);
    g.fillOval(
        x + largeur * 5 / 6 - largeur / 8, y + hauteur / 2, largeur / 8,
        hauteur / 4);
  }

  public void paint(Graphics g) {
    super.paint(g);
    // Dessin de la première soucoupe
    paintSoucoupe(g, 80, 100, 240, 120);
    // Dessin de la deuxième soucoupe
    paintSoucoupe(g, 20, 280, 120, 60);
  }

  public static void main(String args[]) {
    new ExerciceMethodePaintSoucoupe();
  }
}
