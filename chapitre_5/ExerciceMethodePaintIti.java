import java.awt.*;
import javax.swing.JFrame;

public class ExerciceMethodePaintIti extends JFrame {

  public ExerciceMethodePaintIti() {
    super("2 Itis avec méthode paintIti()");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 600);
    this.setVisible(true);
  }

  // Méthode qui dessine un Iti dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
  public static void paintIti(Graphics g, int x, int y, int largeur, int hauteur) {
    // Coordonnées du milieu du rectangle englobant pour faciliter
    // les calculs
    int milieux = x + largeur / 2;
    int milieuy = y + hauteur / 2;
    // La tête
    g.setColor(Color.pink);
    g.fillOval(x + largeur / 3, y, largeur / 3, hauteur / 4);
    // Le sourire
    g.setColor(Color.black);
    g.drawArc(x + largeur / 3, y - hauteur / 12, largeur / 3, hauteur / 4, -125, 70);
    // Les yeux
    g.fillOval(milieux - largeur / 8, y + hauteur / 12, largeur / 12, hauteur / 24);
    g.fillOval(milieux + largeur / 8 - largeur / 12, y + hauteur / 12, largeur / 12, hauteur / 24);
    // Le corps
    g.drawLine(milieux, y + hauteur / 4, milieux, y + hauteur * 3 / 4);
    // Les bras
    g.drawLine(x, y + hauteur / 4, milieux, milieuy);
    g.drawLine(x + largeur, y + hauteur / 4, milieux, milieuy);
    // Les jambes
    g.drawLine(x, y + hauteur, milieux, y + hauteur * 3 / 4);
    g.drawLine(x + largeur, y + hauteur, milieux, y + hauteur * 3 / 4);
  }

  public void paint(Graphics g) {
    super.paint(g);
    // Dessin du premier Bot
    paintIti(g, 100, 100, 200, 400);
    // Dessin du deuxième Bot
    paintIti(g, 25, 50, 100, 200);
  }

  public static void main(String args[]) {
    new ExerciceMethodePaintIti();
  }
}
