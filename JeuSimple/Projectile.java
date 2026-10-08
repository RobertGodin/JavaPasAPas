package JeuSimple;

import java.awt.*;

public class Projectile extends EntiteAnime {
  protected Color couleur; // Couleur du projectile

  public Projectile(int x, int y, int vitesseY, Color couleur) {
    super(x, y, 4, 12, 0, vitesseY, true);
    this.couleur = couleur;
  }

  // Le projectile file en ligne droite et disparaît à la sortie du monde
  public void prochaineScene(int largeurMonde, int hauteurMonde) {
    y = y + vitesseY;
    if (y + hauteur < 0 || y > hauteurMonde) {
      visible = false;
    }
  }

  public void paint(Graphics g) {
    g.setColor(couleur);
    g.fillRect(x, y, largeur, hauteur);
  }
}
