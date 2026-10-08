import java.awt.*;
import javax.swing.JFrame;

public class ExerciceDessinSoucoupe extends JFrame {

  public ExerciceDessinSoucoupe() {
    super("Dessin d'une soucoupe");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(300, 300);
    this.setVisible(true);
  }

  public void paint(Graphics g) {
    super.paint(g);
    // Dessin de la soucoupe
    // Le dôme
    g.setColor(Color.cyan);
    g.fillOval(90, 90, 120, 80);
    // Le disque
    g.setColor(Color.red);
    g.fillOval(30, 130, 240, 80);
    // Les hublots
    g.setColor(Color.yellow);
    g.fillOval(70, 150, 30, 30);
    g.fillOval(135, 150, 30, 30);
    g.fillOval(200, 150, 30, 30);
  }

  public static void main(String[] args) {
    new ExerciceDessinSoucoupe();
  }
}
