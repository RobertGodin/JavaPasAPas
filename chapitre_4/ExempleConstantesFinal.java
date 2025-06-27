import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleConstantesFinal extends JFrame
    implements MouseListener { // Constantes pour la taille de la fenetre
  private static final int LARGEURFENETRE = 400;
  private static final int HAUTEURFENETRE = 600;

  // Variables d'objet qui contiennent les coordonnées de la souris
  // Le premier sera dessiné à la coordonnée (0,0)
  private int x = 0; // Coordonnée x du Bot à dessiner
  private int y = 0; // Coordonnée y du Bot à dessiner

  public ExempleConstantesFinal() {
    super("Exemple de traitement d'événements de la souris");

    // Le paramêtre this de addMouseListener() indique que l'objet qui doit
    // réagir aux événements de souris est l'objet
    // qui est créé par ce constructeur
    addMouseListener(this);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(LARGEURFENETRE, HAUTEURFENETRE);
    this.setVisible(true);
  }

  // Méthode d'objet de la classe ExempleEvenementSouris qui est
  // appelée si le bouton de souris est enfoncé
  public void mousePressed(MouseEvent leMouseEvent) {
    x = leMouseEvent.getX(); // place la coordonnée x de la souris dans la variable x
    y = leMouseEvent.getY(); // place la coordonnée y de la souris dans la variable y
    // repaint() provoque un nouvel appel à paint()
    repaint();
  }

  // Il faut absolument définir les autres méthodes pour les autres
  // événements de souris même s'il ne font rien
  public void mouseClicked(MouseEvent leMouseEvent) {}

  public void mouseEntered(MouseEvent leMouseEvent) {}

  public void mouseExited(MouseEvent leMouseEvent) {}

  public void mouseReleased(MouseEvent leMouseEvent) {}

  public void paintBot(Graphics g, int largeur, int hauteur) {
    // La méthode d'objet utilise directment les variables d'objet x et y
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
    paintBot(g, LARGEURFENETRE / 8, HAUTEURFENETRE / 6);
    g.drawString("x=" + x + " y=" + y, 10, HAUTEURFENETRE - 50);
  }

  public static void main(String args[]) {
    new ExempleConstantesFinal();
    new ExempleConstantesFinal();
  }
}
