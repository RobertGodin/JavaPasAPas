/*
 * Exemple de dessin avec paint dans JFrame
 */

package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DessinDansJFrame extends JFrame {

    /** Constructeur de ExempleDessinJFrame */
    public DessinDansJFrame() {
        super("Exemples de méthodes de Graphics dans un JFrame");
    }
    // paint() est appelée indirectement lors de la création du JFrame par show()
    public void paint (Graphics g) {
        
        g.setColor(Color.green);
        g.fillOval(100,100,200,200); // La tête

        g.setColor(Color.black);
        g.fillRect(150,150,20,20); // L'oeil gauche
        g.fillRect(230,150,20,20); // L'oeil droit
        g.drawLine(150,250,250,250); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(100,300,200,200); // Le corps
    }

    public static void main (String args[]) {
        DessinDansJFrame leFrame =  new DessinDansJFrame();
        leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
    }
}