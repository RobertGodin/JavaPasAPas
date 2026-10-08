// Animation par double tampon
// La soucoupe se déplace à la verticale
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceJFrameAvecSoucoupeRebondissante
    extends JFrame {

  // Constantes pour la taille de la fenêtre et de la soucoupe
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 400;
  private static final int LARGEURSOUCOUPE = LARGEURFENETRE / 4;
  private static final int HAUTEURSOUCOUPE = LARGEURSOUCOUPE / 2;

  // Tampon pour construire l'image avant d'afficher
  Graphics tamponGraphics;
  Image tamponImage;

  public ExerciceJFrameAvecSoucoupeRebondissante() {
    super("Soucoupe rebondissante");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(LARGEURFENETRE, HAUTEURFENETRE);
    this.setVisible(true);
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
    int x = LARGEURFENETRE - 2 * LARGEURSOUCOUPE; // Coordonnée x fixe
    int y = 0; // Coordonnée y de la soucoupe
    int directionSoucoupe = 1; // +1 vers le bas et -1 vers le haut
    // Nombre d'unités de déplacement à chaque itération de la boucle
    int vitesseSoucoupe = 5;
    while (true) {
      // Dessine la soucoupe dans le tampon
      paintSoucoupe(tamponGraphics, x, y, LARGEURSOUCOUPE,
          HAUTEURSOUCOUPE);
      // Copie le tampon dans le contexte graphique de la fenêtre
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
      // Efface la soucoupe
      tamponGraphics.clearRect(x, y, LARGEURSOUCOUPE, HAUTEURSOUCOUPE);
      // Déplace la soucoupe
      // Si atteint le bord
      if (y + HAUTEURSOUCOUPE >= HAUTEURFENETRE | y < 0)
        directionSoucoupe = -directionSoucoupe; // Inverser la direction
      y = y + vitesseSoucoupe * directionSoucoupe; // Déplacement
    }
  }

  public static void main(String[] args) {
    new ExerciceJFrameAvecSoucoupeRebondissante();
  }
}
