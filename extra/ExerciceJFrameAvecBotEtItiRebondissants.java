// Animation par double tampon
// Le Bot et le Iti qui rebondissent dans la même animation
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceJFrameAvecBotEtItiRebondissants extends JFrame {

  // Constantes pour la taille de la fenêtre et du Bot
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;
  // Constantes pour la taille du Bot
  private static final int LARGEURBOT = LARGEURFENETRE / 4;
  private static final int HAUTEURBOT = HAUTEURFENETRE / 3;
  // Constantes pour la taille du Iti
  private static final int LARGEURITI = LARGEURFENETRE / 5;
  private static final int HAUTEURITI = HAUTEURFENETRE / 4;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExerciceJFrameAvecBotEtItiRebondissants() {
    super("Bot rebondissant");
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

  // méthode qui dessine un Iti dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
  // méthode qui dessine un Iti dans un objet Graphics g
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
    g.drawLine(x, y + hauteur / 4, milieux, milieuy);
    g.drawLine(x + largeur, y + hauteur / 4, milieux, milieuy);
    // Les jambes
    g.drawLine(x, y + hauteur, milieux, y + hauteur * 3 / 4);
    g.drawLine(x + largeur, y + hauteur, milieux, y + hauteur * 3 / 4);
  }

  public void paint(Graphics g) {
    tamponImage = createImage(LARGEURFENETRE, HAUTEURFENETRE);
    tamponGraphics = tamponImage.getGraphics();

    int x = 0; // Coordonnée x du Bot
    int directionBot = 1; // +1 vers la droite et -1 vers la gauche
    int vitesseBot = 5; // nombre d'unités de déplacement à chaque itération de la boucle

    int y = 0; // Coordonnée y du Iti
    int directionIti = 1; // +1 vers la droite et -1 vers la gauche
    int vitesseIti = 5; // nombre d'unités de déplacement à chaque itération de la boucle

    while (true) {
      // Dessine le Bot dans le tampon
      paintBot(tamponGraphics, x, HAUTEURFENETRE - 2 * HAUTEURBOT, LARGEURBOT, HAUTEURBOT);
      // Dessine le Iti dans le tampon
      paintIti(tamponGraphics, LARGEURFENETRE - 3 * LARGEURITI, y, LARGEURITI, HAUTEURITI);

      // Copie le tampon dans le contexte graphique de la fenêtre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }

      // Efface le Bot
      tamponGraphics.clearRect(x, HAUTEURFENETRE - 2 * HAUTEURBOT, LARGEURBOT, HAUTEURBOT);
      // Efface le Iti
      tamponGraphics.clearRect(LARGEURFENETRE - 3 * LARGEURITI, y, LARGEURITI, HAUTEURITI);

      // Déplace le Bot
      if (x + LARGEURBOT >= LARGEURFENETRE | x < 0) // Si atteint le bord
      directionBot = -directionBot; // Inverser la direction
      x = x + vitesseBot * directionBot; // Déplacement du Bot

      // Déplace le Iti
      if (y + HAUTEURITI >= HAUTEURFENETRE | y < 0) // Si atteint le bord
      directionIti = -directionIti; // Inverser la direction
      y = y + vitesseIti * directionIti; // Déplacement du Iti
    }
  }

  public static void main(String args[]) {
    ExerciceJFrameAvecBotEtItiRebondissants laFenetre =
        new ExerciceJFrameAvecBotEtItiRebondissants();
  }
}
