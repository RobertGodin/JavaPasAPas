/*
 * Animation2.java
 * Animation d'un bonhomme bondissant
 * Utilise BonhommeQuiBouge
 * Boucle d'animation explicite
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Animation2 extends JPanel{
    
    private BonhommeQuiBouge unBonhomme;
    
    /** Constructeur */
    public Animation2() {
        unBonhomme = new BonhommeQuiBouge(100,50,100,200,3,3);
     }
    
    public void start(){
        while (true){
            repaint();
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException exception){
                System.err.println(exception.toString()); 
            }
            changerMonde();
        }
    }
    
    // paintComponent() est appelée indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        unBonhomme.paint(g);
    }
    
    public void changerMonde(){
        unBonhomme.deplacer();
        
    }

    public static void main (String args[]) {
        Animation2 lePanelAnimation =  new Animation2();
        JFrame leFrame = new JFrame("Animation simple");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.addWindowListener ( 
            new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            }
        );
        leFrame.setSize(500,500);
        leFrame.show();
        lePanelAnimation.start();
    }
}
