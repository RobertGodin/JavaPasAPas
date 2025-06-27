package JeuSimple;

import java.awt.*;

public class ItiAnimeAvecCriVolant extends EntiteAnimeAvecCriEtGestes {
  public ItiAnimeAvecCriVolant(
      int x,
      int y,
      int largeur,
      int hauteur,
      int vitesseX,
      int vitesseY,
      boolean visible,
      String fichierAudio) {
    super(x, y, largeur, hauteur, vitesseX, vitesseY, visible, fichierAudio, 3);
  }

  public void paint(Graphics g) {
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
    g.drawLine(x, y + hauteur / 4 + (hauteur / 4) * etatCourant, milieux, milieuy);
    g.drawLine(x + largeur, y + hauteur / 4 + (hauteur / 4) * etatCourant, milieux, milieuy);
    // Les jambes
    g.drawLine(x, y + hauteur, milieux, y + hauteur * 3 / 4);
    g.drawLine(x + largeur, y + hauteur, milieux, y + hauteur * 3 / 4);
  }
}
