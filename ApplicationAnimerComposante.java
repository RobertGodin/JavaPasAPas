/*
 * ApplicationAnimerComposante.java
 * Utilise ComposanteAnimation
 * Animation d'un bonhomme bondissant
 * Utilise BonhommeQuiBouge
 * Boucle d'animation explicite
 * Created on 18 ao�t 2000, 10:15
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ApplicationAnimerComposante extends JPanel{
    
    protected ComposanteAnimation uneComposanteAnimation;
    
    /** Constructeur */
    public ApplicationAnimerComposante() {
        uneComposanteAnimation = new ComposanteAnimation();
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
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        uneComposanteAnimation.paint(g);
    }
    

    public static void main (String args[]) {
        ApplicationAnimerComposante lePanelAnimation =  new ApplicationAnimerComposante();
        JFrame leFrame = new JFrame("Animation simple");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
        lePanelAnimation.start();
    }
}