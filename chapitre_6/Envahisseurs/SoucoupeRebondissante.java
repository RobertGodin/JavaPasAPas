// Le nom du paquetage ne respecte pas l'usage commun.
package Envahisseurs;

import java.awt.*;

public class SoucoupeRebondissante {
  // Variables d'objet qui décrivent l'état de l'objet
  private int x, y; // Coordonnées de la soucoupe
  private int largeur, hauteur; // Taille de la soucoupe
  private int vitesseX; // Vitesse de déplacement dans l'axe x
  private int vitesseY; // Vitesse de déplacement dans l'axe y

  // Constructeur pour initialiser l'état de la SoucoupeRebondissante
  public SoucoupeRebondissante(
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

  // Dessin de la soucoupe
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

  // Effacer le rectangle de la soucoupe dans tamponGraphics
  public void effacer(Graphics tamponGraphics) {
    tamponGraphics.clearRect(x, y, largeur, hauteur);
  }
}
