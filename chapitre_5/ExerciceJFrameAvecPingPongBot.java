// Bot se déplace en diagonale
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceJFrameAvecPingPongBot extends JFrame {

  // Constantes pour la taille de la fenêtre et du Bot
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;
  private static final int LARGEURBOT = LARGEURFENETRE / 4;
  private static final int HAUTEURBOT = HAUTEURFENETRE / 3;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExerciceJFrameAvecPingPongBot() {
    super("Ping pong Bot");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(LARGEURFENETRE, HAUTEURFENETRE);
    this.setVisible(true);
  }

  // Méthode qui dessine un Bot dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramêtres x,y,largeur,hauteur
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

  public void paint(Graphics g) {
    super.paint(g);
    tamponImage = createImage(LARGEURFENETRE, HAUTEURFENETRE);
    tamponGraphics = tamponImage.getGraphics();

    int xBot = 0; // Coordonnées du Bot
    int yBot = 0;
    int vitesseXBot = 5; // Vitesse du Bot
    int vitesseYBot = 10;

    while (true) {
      // Dessine le Bot dans le tampon
      paintBot(tamponGraphics, xBot, yBot, LARGEURBOT, HAUTEURBOT);
      // Copie le tampon dans le contexte graphique de la fenetre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
      // Efface le Bot
      tamponGraphics.clearRect(xBot, yBot, LARGEURBOT, HAUTEURBOT);
      // Déplace le Bot
      if (xBot + LARGEURBOT >= LARGEURFENETRE | xBot < 0) // Si atteint le bord
      vitesseXBot = -vitesseXBot; // Inverser la direction selon x
      xBot = xBot + vitesseXBot; // Déplacement du Bot selon x
      if (yBot + HAUTEURBOT >= HAUTEURFENETRE | yBot < 0) // Si atteint le bord
      vitesseYBot = -vitesseYBot; // Inverser la direction selon y
      yBot = yBot + vitesseYBot; // Déplacement du Bot selon y
    }
  }

  public static void main(String args[]) {
    new ExerciceJFrameAvecPingPongBot();
  }
}
