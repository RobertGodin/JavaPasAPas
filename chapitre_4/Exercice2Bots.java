import java.awt.*;
import javax.swing.*;

public class Exercice2Bots extends JFrame {
  public Exercice2Bots() {
    super("Dessiner deux Bots");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 600);
    this.setVisible(true);
  }

  public void paint(Graphics g) {
    super.paint(g);
    // Le premier Bot
    g.setColor(Color.green);
    g.fillOval(100, 100, 200, 200); // La tête

    g.setColor(Color.black);
    g.fillRect(150, 150, 20, 20); // L'oeil gauche
    g.fillRect(230, 150, 20, 20); // L'oeil droit
    g.drawLine(150, 250, 250, 250); // La bouche

    g.setColor(Color.red);
    g.fillRect(100, 300, 200, 200); // Le corps

    // Le deuxième Bot
    g.setColor(Color.green);
    g.fillOval(25, 50, 100, 100); // La tête

    g.setColor(Color.black);
    g.fillRect(50, 75, 10, 10); // L'oeil gauche
    g.fillRect(90, 75, 10, 10); // L'oeil droit
    g.drawLine(50, 125, 100, 125); // La bouche

    g.setColor(Color.red);
    g.fillRect(25, 150, 100, 100); // Le corps
  }

  public static void main(String args[]) {
    new Exercice2Bots();
  }
}
