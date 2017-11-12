/*
 * AppAnimerComposanteAnimation2.java
 * Utilise ComposanteAnimation2
 * Animation de plusieurs entités
 * Boucle d'animation explicite
 * Interactivité simple qui répond à la souris
 */
package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AppAnimerComposanteAnimation2 extends JPanel{
    
    protected ComposanteAnimation2 uneComposanteAnimation;
    
    /** Constructeur */
    public AppAnimerComposanteAnimation2() {
        uneComposanteAnimation = new ComposanteAnimation2(this);
        addMouseListener (
            new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    uneComposanteAnimation.mousePressed(e);
                }
            }
        );
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
            uneComposanteAnimation.changerMonde();
        }
    }
    
    // paintComponent() est appelée indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        uneComposanteAnimation.paint(g);
    }
    

    public static void main (String args[]) {
        AppAnimerComposanteAnimation2 lePanelAnimation =  new AppAnimerComposanteAnimation2();
        JFrame leFrame = new JFrame("Animation avec interactivité simple");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leFrame.setSize(500,500);
        leFrame.setVisible(true);
        lePanelAnimation.start();
    }
}