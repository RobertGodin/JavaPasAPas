import java.awt.*;

public class KenyAnime extends EntiteAnimee {

  public KenyAnime(
      int x,
      int y,
      int largeur,
      int hauteur,
      int vitesseX,
      int vitesseY,
      boolean visible,
      String fichierAudio,
      int nombreEtats) {
    super(x, y, largeur, hauteur, vitesseX, vitesseY, visible, fichierAudio, 1);
  }

  public void paint(Graphics g) {
    int milieux = x + (largeur / 2);
    int milieuy = y + (hauteur / 2);
    // Le corps
    g.setColor(new Color(255, 100, 0));
    g.fillRect(
        x + (largeur / 8),
        milieuy - (hauteur / 16),
        largeur * 3 / 4,
        (hauteur / 2) + (hauteur / 16));
    g.setColor(Color.black);
    g.drawRect(
        x + (largeur / 8),
        milieuy - (hauteur / 16),
        largeur * 3 / 4,
        (hauteur / 2) + (hauteur / 16));
    // La tête
    g.setColor(new Color(255, 100, 0));
    g.fillOval(x, y, largeur, hauteur / 2);
    g.setColor(Color.black);
    g.drawOval(x, y, largeur, hauteur / 2);

    g.setColor(Color.orange);
    g.fillOval(x + largeur / 3, y + (hauteur / 10), largeur / 3, hauteur * 3 / 10);
    // Les yeux
    g.setColor(Color.white);
    g.fillOval(milieux - (largeur / 6), y + (hauteur / 5), largeur / 6, hauteur / 10);
    g.fillOval(milieux, y + (hauteur / 5), largeur / 6, hauteur / 10);
    g.setColor(Color.black);
    g.fillOval(milieux - (largeur / 12), y + (hauteur / 4), largeur / 24, largeur / 24);
    g.fillOval(milieux + (largeur / 24), y + (hauteur / 4), largeur / 24, largeur / 24);
    // Les bras
    g.setColor(new Color(255, 100, 0));
    g.fillRect(x, milieuy - (hauteur / 16), largeur / 8, (hauteur / 3) + (hauteur / 16));
    g.setColor(Color.black);
    g.drawRect(x, milieuy - (hauteur / 16), largeur / 8, (hauteur / 3) + (hauteur / 16));

    g.setColor(new Color(255, 100, 0));
    g.fillRect(
        x + (largeur * 7 / 8),
        milieuy - (hauteur / 16),
        largeur / 8,
        (hauteur / 3) + (hauteur / 16));
    g.setColor(Color.black);
    g.drawRect(
        x + (largeur * 7 / 8),
        milieuy - (hauteur / 16),
        largeur / 8,
        (hauteur / 3) + (hauteur / 16));
  }
}
