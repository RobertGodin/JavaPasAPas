// Le nom du paquetage ne respecte pas l'usage commun.
package Envahisseurs;

import java.awt.*;

public class CrabeRebondissant {
  // Variables d'objet qui décrivent l'état de l'objet
  private int x, y; // Coordonnées du crabe
  private int largeur, hauteur; // Taille du crabe
  private int vitesseX; // Vitesse de déplacement dans l'axe x
  private int vitesseY; // Vitesse de déplacement dans l'axe y

  // Constructeur pour initialiser l'état du CrabeRebondissant
  public CrabeRebondissant(
      int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY) {
    this.x = x;
    this.y = y;
    this.hauteur = hauteur;
    this.largeur = largeur;
    this.vitesseX = vitesseX;
    this.vitesseY = vitesseY;
  }

  // Déplacement pour la prochaine itération
  public void deplacer(int largeurFenetre, int hauteurFenetre) {
    if (x + largeur >= largeurFenetre | x < 0) // Au bord selon x
      vitesseX = -vitesseX; // Inverser la direction selon x
    x = x + vitesseX; // Déplacement selon x
    if (y + hauteur >= hauteurFenetre | y < 0) // Au bord selon y
      vitesseY = -vitesseY; // Inverser la direction selon y
    y = y + vitesseY; // Déplacement selon y
  }

  // Dessin du crabe
  public void paint(Graphics g) {
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

  // Effacer le rectangle du crabe dans tamponGraphics
  public void effacer(Graphics tamponGraphics) {
    tamponGraphics.clearRect(x, y, largeur, hauteur);
  }
}
