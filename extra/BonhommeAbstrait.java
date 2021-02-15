import java.awt.*;

public class BonhommeAbstrait {
  protected int x,
      y,
      largeur,
      hauteur; // Protected permet aux sous-classes d'utiliser ces variables
  /** Constructeur de Bonhomme */
  public BonhommeAbstrait(int x, int y, int largeur, int hauteur) {
    this.x = x;
    this.y = y;
    this.hauteur = hauteur;
    this.largeur = largeur;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setLargeur(int largeur) {
    this.largeur = largeur;
  }

  public void setHauteur(int hauteur) {
    this.hauteur = hauteur;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getLargeur() {
    return largeur;
  }

  public int getHauteur() {
    return hauteur;
  }

  public void paint(Graphics g) {
    // Rien. La sous-classe doit redéfinir cette méthode.
    // La méthode est dite abstraite.
  }
}
