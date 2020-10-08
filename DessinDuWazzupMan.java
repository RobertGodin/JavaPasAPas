
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author  Godin, Robert
 * @version 
 */
public class DessinDuWazzupMan extends JFrame {

    /** Constructeur de ExempleDessinJFrame */
    public DessinDuWazzupMan() {
        super("Creation de Fred");
    }
    // paint() est appelée indirectement lors de la cr�ation du JFrame par show()
    public void paint (Graphics g) {
        int x = 100; // Coordonn�es x,y du coin sup�rieur gauche du bonhomme
        int y = 50;
        int largeur = 100; // Largeur et hauteur du bonhomme
        int hauteur = 200;
        int milieux = x + largeur/2;
        int milieuy = y + hauteur/2;
        g.setColor(Color.pink);
        g.fillOval(largeur/2-20,hauteur/2-20,40,40);
        g.setColor(Color.black);
        g.fillOval(largeur/2-4,hauteur/2-4,8,8);
        g.drawLine(largeur/2-14,hauteur/2+14,largeur/4,hauteur);
        g.drawLine(largeur/2+14,hauteur/2+14,largeur*3/4,hauteur);
        
        
        
        
    }
        public static void main (String args[]) {
        DessinDuWazzupMan leFrame =  new DessinDuWazzupMan();
        leFrame.addWindowListener ( 
            new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            }
        );
        leFrame.setSize(1000,1000);
        leFrame.show();        
    }
}