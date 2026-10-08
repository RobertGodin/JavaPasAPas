// Tentative d'animation par itération d'affichage de gauche à droite
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleJFrameAvecAnimationRatee
    extends JFrame {

  // Constantes pour la taille de la fenêtre et du crabe
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 600;
  private static final int LARGEURCRABE = LARGEURFENETRE / 4;
  private static final int HAUTEURCRABE = LARGEURCRABE * 2 / 3;

  public ExempleJFrameAvecAnimationRatee() {
    super("Exemple d'animation ratée");
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
    for (int x = 0; x <= LARGEURFENETRE - LARGEURCRABE; x = x + 5) {
      paintCrabe(g, x, HAUTEURFENETRE - 2 * HAUTEURCRABE, LARGEURCRABE,
          HAUTEURCRABE);
      try {
        Thread.sleep(50);
      } catch (InterruptedException uneException) {
        System.out.println(uneException.toString());
      }
    }
  }

  public static void main(String[] args) {
    new ExempleJFrameAvecAnimationRatee();
  }
}
