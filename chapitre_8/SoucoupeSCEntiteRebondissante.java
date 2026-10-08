import java.awt.*;

public class SoucoupeSCEntiteRebondissante extends EntiteRebondissante {

  // Constructeur
  public SoucoupeSCEntiteRebondissante(
      int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY) {
    super(x, y, largeur, hauteur, vitesseX, vitesseY);
  }

  // Corps de la méthode abstraite héritée de la super-classe
  public void paint(Graphics g) {
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
}
