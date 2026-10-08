import java.awt.*;
import javax.swing.JFrame;

public class ExercicePlusieursCrabesEtSoucoupes extends JFrame {

  public ExercicePlusieursCrabesEtSoucoupes() {
    super("Rassemblement de crabes et de soucoupes");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  // Méthode qui dessine un crabe dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
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

  // Méthode qui dessine une soucoupe dans un objet Graphics g
  // à l'échelle dans un rectangle englobant de paramètres
  // x,y,largeur,hauteur
  public static void paintSoucoupe(
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
    paintCrabe(g, 10, 40, 90, 60);
    paintCrabe(g, 200, 200, 45, 30);
    paintCrabe(g, 150, 330, 60, 40);
    paintCrabe(g, 280, 60, 105, 70);
    paintSoucoupe(g, 140, 120, 80, 40);
    paintSoucoupe(g, 30, 250, 100, 50);
    paintSoucoupe(g, 270, 280, 110, 55);
  }

  public static void main(String[] args) {
    new ExercicePlusieursCrabesEtSoucoupes();
  }
}
