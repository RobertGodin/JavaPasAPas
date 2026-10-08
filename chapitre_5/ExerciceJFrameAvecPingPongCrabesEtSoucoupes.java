// Plusieurs crabes et soucoupes qui bougent
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceJFrameAvecPingPongCrabesEtSoucoupes
    extends JFrame {

  // Constantes pour la taille de la fenêtre
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExerciceJFrameAvecPingPongCrabesEtSoucoupes() {
    super("Ping pong crabes et soucoupes");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(LARGEURFENETRE, HAUTEURFENETRE);
    this.setVisible(true);
  }

  // Méthode qui dessine un crabe dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
  public void paintCrabe(
      Graphics g, int x, int y, int largeur, int hauteur) {
    g.setColor(Color.green);
    // Le corps
    g.fillOval(
        x + largeur / 8, y + hauteur / 4, largeur * 3 / 4, hauteur / 2);

    g.setColor(Color.black);
    // L'oeil gauche
    g.fillRect(
        x + largeur * 3 / 8,
        y + hauteur * 3 / 8,
        largeur / 12,
        hauteur / 8);
    // L'oeil droit
    g.fillRect(
        x + largeur * 5 / 8 - largeur / 12,
        y + hauteur * 3 / 8,
        largeur / 12,
        hauteur / 8);
    // La bouche
    g.drawLine(
        x + largeur * 3 / 8,
        y + hauteur * 5 / 8,
        x + largeur * 5 / 8,
        y + hauteur * 5 / 8);

    g.setColor(Color.red);
    // Les pinces
    g.fillRect(x, y + hauteur / 8, largeur / 8, hauteur / 2);
    g.fillRect(
        x + largeur * 7 / 8, y + hauteur / 8, largeur / 8, hauteur / 2);
  }

  // Méthode qui dessine une soucoupe dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
  public void paintSoucoupe(
      Graphics g, int x, int y, int largeur, int hauteur) {
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

  public void paint(Graphics g) {
    super.paint(g);
    tamponImage = createImage(LARGEURFENETRE, HAUTEURFENETRE);
    tamponGraphics = tamponImage.getGraphics();

    int xCrabe1 = 0; // Coordonnées du crabe1
    int yCrabe1 = 100;
    int vitesseXCrabe1 = 5; // Vitesse du crabe1
    int vitesseYCrabe1 = 0;
    int largeurCrabe1 = 120; // Taille du crabe1
    int hauteurCrabe1 = 80;

    int xCrabe2 = 100; // Coordonnées du crabe2
    int yCrabe2 = 100;
    int vitesseXCrabe2 = -10; // Vitesse du crabe2
    int vitesseYCrabe2 = 5;
    int largeurCrabe2 = 75; // Taille du crabe2
    int hauteurCrabe2 = 50;

    int xSoucoupe1 = 200; // Coordonnées de la soucoupe1
    int ySoucoupe1 = 300;
    int vitesseXSoucoupe1 = 6; // Vitesse de la soucoupe1
    int vitesseYSoucoupe1 = 6;
    int largeurSoucoupe1 = 100; // Taille de la soucoupe1
    int hauteurSoucoupe1 = 44;

    int xSoucoupe2 = 200; // Coordonnées de la soucoupe2
    int ySoucoupe2 = 0;
    int vitesseXSoucoupe2 = 0; // Vitesse de la soucoupe2
    int vitesseYSoucoupe2 = 10;
    int largeurSoucoupe2 = 64; // Taille de la soucoupe2
    int hauteurSoucoupe2 = 28;

    while (true) {
      // Dessine les crabes et les soucoupes
      paintCrabe(tamponGraphics, xCrabe1, yCrabe1,
          largeurCrabe1, hauteurCrabe1);
      paintCrabe(tamponGraphics, xCrabe2, yCrabe2,
          largeurCrabe2, hauteurCrabe2);
      paintSoucoupe(tamponGraphics, xSoucoupe1, ySoucoupe1,
          largeurSoucoupe1, hauteurSoucoupe1);
      paintSoucoupe(tamponGraphics, xSoucoupe2, ySoucoupe2,
          largeurSoucoupe2, hauteurSoucoupe2);
      // Copie le tampon dans le contexte graphique de la fenêtre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
      // Efface les crabes et les soucoupes
      tamponGraphics.clearRect(xCrabe1, yCrabe1,
          largeurCrabe1, hauteurCrabe1);
      tamponGraphics.clearRect(xCrabe2, yCrabe2,
          largeurCrabe2, hauteurCrabe2);
      tamponGraphics.clearRect(xSoucoupe1, ySoucoupe1,
          largeurSoucoupe1, hauteurSoucoupe1);
      tamponGraphics.clearRect(xSoucoupe2, ySoucoupe2,
          largeurSoucoupe2, hauteurSoucoupe2);

      // Déplace le crabe1 (au bord, inverser la direction)
      if (xCrabe1 + largeurCrabe1 >= LARGEURFENETRE | xCrabe1 < 0)
        vitesseXCrabe1 = -vitesseXCrabe1;
      xCrabe1 = xCrabe1 + vitesseXCrabe1; // Déplacement selon x
      if (yCrabe1 + hauteurCrabe1 >= HAUTEURFENETRE | yCrabe1 < 0)
        vitesseYCrabe1 = -vitesseYCrabe1;
      yCrabe1 = yCrabe1 + vitesseYCrabe1; // Déplacement selon y

      // Déplace le crabe2 (au bord, inverser la direction)
      if (xCrabe2 + largeurCrabe2 >= LARGEURFENETRE | xCrabe2 < 0)
        vitesseXCrabe2 = -vitesseXCrabe2;
      xCrabe2 = xCrabe2 + vitesseXCrabe2; // Déplacement selon x
      if (yCrabe2 + hauteurCrabe2 >= HAUTEURFENETRE | yCrabe2 < 0)
        vitesseYCrabe2 = -vitesseYCrabe2;
      yCrabe2 = yCrabe2 + vitesseYCrabe2; // Déplacement selon y

      // Déplace la soucoupe1 (au bord, inverser la direction)
      if (xSoucoupe1 + largeurSoucoupe1 >= LARGEURFENETRE | xSoucoupe1 < 0)
        vitesseXSoucoupe1 = -vitesseXSoucoupe1;
      xSoucoupe1 = xSoucoupe1 + vitesseXSoucoupe1; // Déplacement selon x
      if (ySoucoupe1 + hauteurSoucoupe1 >= HAUTEURFENETRE | ySoucoupe1 < 0)
        vitesseYSoucoupe1 = -vitesseYSoucoupe1;
      ySoucoupe1 = ySoucoupe1 + vitesseYSoucoupe1; // Déplacement selon y

      // Déplace la soucoupe2 (au bord, inverser la direction)
      if (xSoucoupe2 + largeurSoucoupe2 >= LARGEURFENETRE | xSoucoupe2 < 0)
        vitesseXSoucoupe2 = -vitesseXSoucoupe2;
      xSoucoupe2 = xSoucoupe2 + vitesseXSoucoupe2; // Déplacement selon x
      if (ySoucoupe2 + hauteurSoucoupe2 >= HAUTEURFENETRE | ySoucoupe2 < 0)
        vitesseYSoucoupe2 = -vitesseYSoucoupe2;
      ySoucoupe2 = ySoucoupe2 + vitesseYSoucoupe2; // Déplacement selon y
    }
  }

  public static void main(String args[]) {
    new ExerciceJFrameAvecPingPongCrabesEtSoucoupes();
  }
}
