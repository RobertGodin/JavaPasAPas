import java.awt.*;
import javax.swing.*;

public class Exercice2Crabes extends JFrame {

  public Exercice2Crabes() {
    super("Dessiner deux crabes");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  public void paint(Graphics g) {
    super.paint(g);
    // Le premier crabe
    g.setColor(Color.green);
    g.fillOval(110, 140, 180, 80); // Le corps

    g.setColor(Color.black);
    g.fillRect(170, 160, 20, 20); // L'oeil gauche
    g.fillRect(210, 160, 20, 20); // L'oeil droit
    g.drawLine(170, 200, 230, 200); // La bouche

    g.setColor(Color.red);
    g.fillRect(80, 120, 30, 80); // La pince gauche
    g.fillRect(290, 120, 30, 80); // La pince droite

    // Le deuxième crabe
    g.setColor(Color.green);
    g.fillOval(35, 300, 90, 40); // Le corps

    g.setColor(Color.black);
    g.fillRect(65, 310, 10, 10); // L'oeil gauche
    g.fillRect(85, 310, 10, 10); // L'oeil droit
    g.drawLine(65, 330, 95, 330); // La bouche

    g.setColor(Color.red);
    g.fillRect(20, 290, 15, 40); // La pince gauche
    g.fillRect(125, 290, 15, 40); // La pince droite
  }

  public static void main(String[] args) {
    new Exercice2Crabes();
  }
}
