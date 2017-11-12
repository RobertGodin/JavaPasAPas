import java.awt.*;
import javax.swing.JFrame;

public class ExempleDessin2DDansJFrame extends JFrame {

    public ExempleDessin2DDansJFrame() {
        super("Exemples de dessin avec les m�thodes de Graphics");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,600);
        this.setVisible(true);
    }

    // La m�thode paint() est appel�e automatiquement lors de la cr�ation du JFrame
    // La m�thode paint() fait un dessin d'un bonhomme
    public void paint (Graphics g) {
    
        // Il faut appeler la m�thode paint() de la super-classe
        super.paint(g);
        
        g.setColor(Color.green);
        g.fillOval(100,100,200,200); // La t�te

        g.setColor(Color.black);
        g.fillRect(150,150,20,20); // L'oeil gauche
        g.fillRect(230,150,20,20); // L'oeil droit
        g.drawLine(150,250,250,250); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(100,300,200,200); // Le corps
    }

    public static void main (String args[]) {
        new ExempleDessin2DDansJFrame();
    }
}