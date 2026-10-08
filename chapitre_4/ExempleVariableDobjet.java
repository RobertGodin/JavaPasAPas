import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleVariableDobjet extends JFrame
    implements MouseListener {
  // Variables d'objet qui contiennent les coordonnées de la souris
  // Le premier sera dessiné à la coordonnée (0,0)
  private int x = 0; // Coordonnée x du crabe à dessiner
  private int y = 0; // Coordonnée y du crabe à dessiner

  public ExempleVariableDobjet() {
    super("Exemple de variable d'objet x et y");

    // Le paramètre this de addMouseListener() indique que l'objet qui
    // doit réagir aux événements de souris est l'objet
    // qui est créé par ce constructeur
    addMouseListener(this);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 600);
    this.setVisible(true);
  }

  // Méthode d'objet de la classe ExempleVariableDobjet
  // qui est appelée si le bouton de souris est enfoncé
  public void mousePressed(MouseEvent leMouseEvent) {
    // Place les coordonnées de la souris dans les variables x et y
    x = leMouseEvent.getX();
    y = leMouseEvent.getY();
    // repaint() provoque un nouvel appel à paint()
    repaint();
  }

  // Il faut absolument définir les autres méthodes pour les autres
  // événements de souris même s'ils ne font rien
  public void mouseClicked(MouseEvent leMouseEvent) {}

  public void mouseEntered(MouseEvent leMouseEvent) {}

  public void mouseExited(MouseEvent leMouseEvent) {}

  public void mouseReleased(MouseEvent leMouseEvent) {}

  public static void paintCrabe(
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
    paintCrabe(g, x, y, 60, 40);
    g.drawString("x=" + x + " y=" + y, 10, 550);
  }

  public static void main(String[] args) {
    new ExempleVariableDobjet();
    new ExempleVariableDobjet();
  }
}
