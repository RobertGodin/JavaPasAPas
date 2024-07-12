// Le nom du paquetage ne respecte pas l'usage commun.
package Bonhommes;

import java.awt.*;

public class BotRebondissant {
  // Variables d'objet qui décrivent l'état d'un objet BotRebondissant
  private int x, y; // Coordonnées x du Bot
  private int largeur, hauteur; // Taille du Bot
  private int vitesseX; // Vitesse de déplacement dans l'axe x
  private int vitesseY; // Vitesse de déplacement dans l'axe y

  // Constructeur pour initialiser l'état du BotRebondissant
  public BotRebondissant(int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY) {
    this.x = x;
    this.y = y;
    this.hauteur = hauteur;
    this.largeur = largeur;
    this.vitesseX = vitesseX;
    this.vitesseY = vitesseY;
  }

  // déplacement pour la prochaine itération
  public void deplacer(int largeurFenetre, int hauteurFenetre) {
    if (x + largeur >= largeurFenetre | x < 0) // Si atteint le bord selon x
    vitesseX = -vitesseX; // Inverser la direction selon x
    x = x + vitesseX; // déplacement selon x
    if (y + hauteur >= hauteurFenetre | y < 0) // Si atteint le bord selon y
    vitesseY = -vitesseY; // Inverser la direction selon y
    y = y + vitesseY; // déplacement selon y
  }

  // Dessin du Bot
  public void paint(Graphics g) {
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
  // Effacer le rectangle du Bot dans tamponGraphics
  public void effacer(Graphics tamponGraphics) {
    tamponGraphics.clearRect(x, y, largeur, hauteur);
  }
}
