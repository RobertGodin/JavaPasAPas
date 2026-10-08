import java.awt.*;
import javax.swing.JFrame;

public class ExempleDessin2DDansJFrame extends JFrame {

  public ExempleDessin2DDansJFrame() {
    super("Exemples de dessin avec les méthodes de Graphics");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  // La méthode paint() est appelée automatiquement lors de la création
  // du JFrame
  // La méthode paint() fait le dessin d'un crabe
  public void paint(Graphics g) {

    // Il faut appeler la méthode paint() de la super-classe
    super.paint(g);

    g.setColor(Color.green);
    g.fillOval(110, 140, 180, 80); // Le corps

    g.setColor(Color.black);
    g.fillRect(170, 160, 20, 20); // L'oeil gauche
    g.fillRect(210, 160, 20, 20); // L'oeil droit
    g.drawLine(170, 200, 230, 200); // La bouche

    g.setColor(Color.red);
    g.fillRect(80, 120, 30, 80); // La pince gauche
    g.fillRect(290, 120, 30, 80); // La pince droite
  }

  public static void main(String[] args) {
    new ExempleDessin2DDansJFrame();
  }
}
