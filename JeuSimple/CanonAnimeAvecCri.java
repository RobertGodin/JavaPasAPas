package JeuSimple;

import java.awt.*;

public class CanonAnimeAvecCri extends EntiteAnimeAvecCri {

  public CanonAnimeAvecCri(
      int x,
      int y,
      int largeur,
      int hauteur,
      int vitesseX,
      int vitesseY,
      boolean visible,
      String fichierAudio) {
    super(x, y, largeur, hauteur, vitesseX, vitesseY, visible,
        fichierAudio);
  }

  public void paint(Graphics g) {
    g.setColor(Color.white);
    // La base
    g.fillRect(x, y + hauteur / 2, largeur, hauteur / 2);
    // Le dessus de la base
    g.fillRect(
        x + largeur / 10, y + hauteur / 3, largeur * 8 / 10, hauteur / 6);
    // Le tube du canon
    g.fillRect(
        x + largeur / 2 - largeur / 16, y, largeur / 8, hauteur / 3);
  }
}
