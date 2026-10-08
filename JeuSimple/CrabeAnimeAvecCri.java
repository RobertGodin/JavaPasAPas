package JeuSimple;

import java.awt.*;

public class CrabeAnimeAvecCri extends EntiteAnimeAvecCriEtGestes {
  public CrabeAnimeAvecCri(
      int x,
      int y,
      int largeur,
      int hauteur,
      int vitesseX,
      int vitesseY,
      boolean visible,
      String fichierAudio) {
    super(x, y, largeur, hauteur, vitesseX, vitesseY, visible,
        fichierAudio, 2);
  }

  public void paint(Graphics g) {
    g.setColor(Color.green);
    // Le corps
    g.fillOval(
        x + largeur / 8, y + hauteur / 4, largeur * 3 / 4, hauteur / 2);

    g.setColor(Color.black);
    // Les yeux
    g.fillRect(
        x + largeur * 3 / 8, y + hauteur * 3 / 8, largeur / 12,
        hauteur / 8);
    g.fillRect(
        x + largeur * 5 / 8 - largeur / 12, y + hauteur * 3 / 8,
        largeur / 12, hauteur / 8);
    // La bouche
    g.drawLine(
        x + largeur * 3 / 8, y + hauteur * 5 / 8, x + largeur * 5 / 8,
        y + hauteur * 5 / 8);

    g.setColor(Color.red);
    // Les pinces : leur hauteur dépend de etatCourant
    int hautPinces = y + hauteur / 8 + (hauteur / 4) * etatCourant;
    g.fillRect(x, hautPinces, largeur / 8, hauteur / 2);
    g.fillRect(x + largeur * 7 / 8, hautPinces, largeur / 8, hauteur / 2);
  }
}
