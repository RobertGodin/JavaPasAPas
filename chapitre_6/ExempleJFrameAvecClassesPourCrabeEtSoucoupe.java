// Plusieurs crabes et soucoupes qui bougent
// Utilise les classes CrabeRebondissant et SoucoupeRebondissante
// du package Envahisseurs
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleJFrameAvecClassesPourCrabeEtSoucoupe
    extends JFrame {

  // Constantes pour la taille de la fenêtre
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExempleJFrameAvecClassesPourCrabeEtSoucoupe() {
    super("Ping pong avec classes pour crabes et soucoupes");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(LARGEURFENETRE, HAUTEURFENETRE);
    this.setVisible(true);
  }

  public void paint(Graphics g) {
    tamponImage = createImage(LARGEURFENETRE, HAUTEURFENETRE);
    tamponGraphics = tamponImage.getGraphics();

    Envahisseurs.CrabeRebondissant crabe1 =
        new Envahisseurs.CrabeRebondissant(0, 100, 120, 80, 5, 0);
    Envahisseurs.CrabeRebondissant crabe2 =
        new Envahisseurs.CrabeRebondissant(100, 100, 75, 50, -10, 5);
    Envahisseurs.SoucoupeRebondissante soucoupe1 =
        new Envahisseurs.SoucoupeRebondissante(200, 300, 100, 44, 6, 6);
    Envahisseurs.SoucoupeRebondissante soucoupe2 =
        new Envahisseurs.SoucoupeRebondissante(200, 0, 64, 28, 0, 10);

    while (true) {
      // Dessine les crabes et les soucoupes
      crabe1.paint(tamponGraphics);
      crabe2.paint(tamponGraphics);
      soucoupe1.paint(tamponGraphics);
      soucoupe2.paint(tamponGraphics);

      // Copie le tampon dans le contexte graphique de la fenêtre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
      // Efface les crabes et les soucoupes du tampon
      crabe1.effacer(tamponGraphics);
      crabe2.effacer(tamponGraphics);
      soucoupe1.effacer(tamponGraphics);
      soucoupe2.effacer(tamponGraphics);

      // Déplace les crabes et les soucoupes
      crabe1.deplacer(LARGEURFENETRE, HAUTEURFENETRE);
      crabe2.deplacer(LARGEURFENETRE, HAUTEURFENETRE);
      soucoupe1.deplacer(LARGEURFENETRE, HAUTEURFENETRE);
      soucoupe2.deplacer(LARGEURFENETRE, HAUTEURFENETRE);
    }
  }

  public static void main(String[] args) {
    new ExempleJFrameAvecClassesPourCrabeEtSoucoupe();
  }
}
