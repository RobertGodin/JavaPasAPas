import java.awt.*;

public abstract class EntiteRebondissante {
  // Variables d'objet qui décrivent l'état d'un objet EntiteRebondissante
  // Protected permet aux sous-classes d'utiliser les variables
  protected int x, y; // Coordonnées x du Bot
  protected int largeur, hauteur; // Taille du Bot
  protected int vitesseX; // Vitesse de déplacement dans l'axe x
  protected int vitesseY; // Vitesse de déplacement dans l'axe y

  // Constructeur
  public EntiteRebondissante(int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY) {
    this.x = x;
    this.y = y;
    this.hauteur = hauteur;
    this.largeur = largeur;
    this.vitesseX = vitesseX;
    this.vitesseY = vitesseY;
  }

  // Déplacement pour la prochaine itération
  public void deplacer(int largeurFenetre, int hauteurFenetre) {
    if (x + largeur >= largeurFenetre | x < 0) // Si atteint le bord selon x
    vitesseX = -vitesseX; // Inverser la direction selon x
    x = x + vitesseX; // Déplacement selon x
    if (y + hauteur >= hauteurFenetre | y < 0) // Si atteint le bord selon y
    vitesseY = -vitesseY; // Inverser la direction selon y
    y = y + vitesseY; // Déplacement selon y
  }

  // Méthode abstraite : corps doit être précisé dans la sous-classe concr�te
  public abstract void paint(Graphics g);

  // Effacer le rectangle dans tamponGraphics
  public void effacer(Graphics g) {
    g.clearRect(x, y, largeur, hauteur);
  }
}
