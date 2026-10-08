// Animation par double tampon
// Le crabe rebondit lorsqu'il atteint le bord de la fenêtre
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceJFrameAvecCrabeRebondissant
    extends JFrame {

  // Constantes pour la taille de la fenêtre et du crabe
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;
  private static final int LARGEURCRABE = LARGEURFENETRE / 4;
  private static final int HAUTEURCRABE = LARGEURCRABE * 2 / 3;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExerciceJFrameAvecCrabeRebondissant() {
    super("Crabe rebondissant");
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

  public void paint(Graphics g) {
    super.paint(g);
    tamponImage = createImage(LARGEURFENETRE, HAUTEURFENETRE);
    tamponGraphics = tamponImage.getGraphics();
    int x = 0; // Coordonnée x du crabe
    int directionCrabe = 1; // +1 vers la droite et -1 vers la gauche
    // Nombre d'unités de déplacement à chaque itération de la boucle
    int vitesseCrabe = 5;
    while (true) {
      // Dessine le crabe dans le tampon
      paintCrabe(tamponGraphics, x, HAUTEURFENETRE - 2 * HAUTEURCRABE,
          LARGEURCRABE, HAUTEURCRABE);
      // Copie le tampon dans le contexte graphique de la fenêtre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
      // Efface le crabe
      tamponGraphics.clearRect(x, HAUTEURFENETRE - 2 * HAUTEURCRABE,
          LARGEURCRABE, HAUTEURCRABE);
      // Déplace le crabe
      if (x + LARGEURCRABE >= LARGEURFENETRE | x < 0) // Si atteint le bord
        directionCrabe = -directionCrabe; // Inverser la direction
      x = x + vitesseCrabe * directionCrabe; // Déplacement du crabe
    }
  }

  public static void main(String args[]) {
    new ExerciceJFrameAvecCrabeRebondissant();
  }
}
