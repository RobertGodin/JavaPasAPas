// Plusieurs Bot et Iti qui bougent
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceJFrameAvecPingPongBotsEtItis extends JFrame {

  // Constantes pour la taille de la fenetre et du Bot
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExerciceJFrameAvecPingPongBotsEtItis() {
    super("Ping pong Bots et Itis");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(LARGEURFENETRE, HAUTEURFENETRE);
    this.setVisible(true);
  }

  // Méthode qui dessine un Bot dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
  public void paintBot(Graphics g, int x, int y, int largeur, int hauteur) {
    g.setColor(Color.green);
    g.fillOval(x, y, largeur, hauteur / 2); // La tête

    g.setColor(Color.black);
    g.fillRect(x + largeur / 4, y + hauteur / 8, largeur / 10, hauteur / 20); // L'oeil gauche
    g.fillRect(
        x + largeur * 3 / 4 - largeur / 10,
        y + hauteur / 8,
        largeur / 10,
        hauteur / 20); // L'oeil droit
    g.drawLine(
        x + largeur / 4,
        y + hauteur * 3 / 8,
        x + largeur * 3 / 4,
        y + hauteur * 3 / 8); // La bouche

    g.setColor(Color.red);
    g.fillRect(x, y + hauteur / 2, largeur, hauteur / 2); // Le corps
  }

  // Méthode qui dessine un Iti dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
  // Méthode qui dessine un Iti dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
  // Méthode qui dessine un Iti dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
  public static void paintIti(Graphics g, int x, int y, int largeur, int hauteur) {
    // Coordonnées du milieu du rectangle englobant pour faciliter les calculs
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
    g.drawLine(x + 1, y + hauteur / 4, milieux, milieuy);
    g.drawLine(x + largeur - 1, y + hauteur / 4, milieux, milieuy);
    // Les jambes
    g.drawLine(x + 1, y + hauteur - 1, milieux, y + hauteur * 3 / 4);
    g.drawLine(x + largeur - 1, y + hauteur - 1, milieux, y + hauteur * 3 / 4);
  }

  public void paint(Graphics g) {
    super.paint(g);
    tamponImage = createImage(LARGEURFENETRE, HAUTEURFENETRE);
    tamponGraphics = tamponImage.getGraphics();

    int xBot1 = 0; // Coordonnées du Bot1
    int yBot1 = 100;
    int vitesseXBot1 = 5; // Vitesse du Bot1
    int vitesseYBot1 = 0;
    int largeurBot1 = 100; // Taille du Bot1
    int hauteurBot1 = 150;

    int xBot2 = 100; // Coordonnées du Bot2
    int yBot2 = 100;
    int vitesseXBot2 = -10; // Vitesse du Bot2
    int vitesseYBot2 = 5;
    int largeurBot2 = 75; // Taille du Bot2
    int hauteurBot2 = 100;

    int xIti1 = 200; // Coordonnées du Iti1
    int yIti1 = 300;
    int vitesseXIti1 = 6; // Vitesse du Iti1
    int vitesseYIti1 = 6;
    int largeurIti1 = 80; // Taille du Iti1
    int hauteurIti1 = 80;

    int xIti2 = 200; // Coordonnées du Iti2
    int yIti2 = 0;
    int vitesseXIti2 = 0; // Vitesse du Iti2
    int vitesseYIti2 = 10;
    int largeurIti2 = 50; // Taille du Iti2
    int hauteurIti2 = 50;

    while (true) {
      // Dessine les Bot et Iti
      paintBot(tamponGraphics, xBot1, yBot1, largeurBot1, hauteurBot1);
      paintBot(tamponGraphics, xBot2, yBot2, largeurBot2, hauteurBot2);
      paintIti(tamponGraphics, xIti1, yIti1, largeurIti1, hauteurIti1);
      paintIti(tamponGraphics, xIti2, yIti2, largeurIti2, hauteurIti2);
      // Copie le tampon dans le contexte graphique de la fenetre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
      // Efface les Bot et Iti
      tamponGraphics.clearRect(xBot1, yBot1, largeurBot1, hauteurBot1);
      tamponGraphics.clearRect(xBot2, yBot2, largeurBot2, hauteurBot2);
      tamponGraphics.clearRect(xIti1, yIti1, largeurIti1, hauteurIti1);
      tamponGraphics.clearRect(xIti2, yIti2, largeurIti2, hauteurIti2);

      // Déplace le Bot1
      if (xBot1 + largeurBot1 >= LARGEURFENETRE | xBot1 < 0) // Si atteint le bord
      vitesseXBot1 = -vitesseXBot1; // Inverser la direction selon x
      xBot1 = xBot1 + vitesseXBot1; // Déplacement du Bot selon x
      if (yBot1 + hauteurBot1 >= HAUTEURFENETRE | yBot1 < 0) // Si atteint le bord
      vitesseYBot1 = -vitesseYBot1; // Inverser la direction selon y
      yBot1 = yBot1 + vitesseYBot1; // Déplacement du Bot selon y

      // Déplace le Bot2
      if (xBot2 + largeurBot2 >= LARGEURFENETRE | xBot2 < 0) // Si atteint le bord
      vitesseXBot2 = -vitesseXBot2; // Inverser la direction selon x
      xBot2 = xBot2 + vitesseXBot2; // Déplacement du Bot selon x
      if (yBot2 + hauteurBot2 >= HAUTEURFENETRE | yBot2 < 0) // Si atteint le bord
      vitesseYBot2 = -vitesseYBot2; // Inverser la direction selon y
      yBot2 = yBot2 + vitesseYBot2; // Déplacement du Bot selon y

      // Déplace le Iti1
      if (xIti1 + largeurIti1 >= LARGEURFENETRE | xIti1 < 0) // Si atteint le bord
      vitesseXIti1 = -vitesseXIti1; // Inverser la direction selon x
      xIti1 = xIti1 + vitesseXIti1; // Déplacement du Iti selon x
      if (yIti1 + hauteurIti1 >= HAUTEURFENETRE | yIti1 < 0) // Si atteint le bord
      vitesseYIti1 = -vitesseYIti1; // Inverser la direction selon y
      yIti1 = yIti1 + vitesseYIti1; // Déplacement du Iti selon y
      // Déplace le Iti2
      if (xIti2 + largeurIti2 >= LARGEURFENETRE | xIti2 < 0) // Si atteint le bord
      vitesseXIti2 = -vitesseXIti2; // Inverser la direction selon x
      xIti2 = xIti2 + vitesseXIti2; // Déplacement du Iti selon x
      if (yIti2 + hauteurIti2 >= HAUTEURFENETRE | yIti2 < 0) // Si atteint le bord
      vitesseYIti2 = -vitesseYIti2; // Inverser la direction selon y
      yIti2 = yIti2 + vitesseYIti2; // Déplacement du Iti selon y
    }
  }

  public static void main(String args[]) {
    new ExerciceJFrameAvecPingPongBotsEtItis();
  }
}
