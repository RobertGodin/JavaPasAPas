/*
 * AppAnimerComposanteEtClickSouris.java
 * Utilise ComposanteAnimation
 * Animation d'un bonhomme bondissant
 * Utilise BonhommeQuiBouge
 * Boucle d'animation explicite
 * Interactivit� simple qui r�pond � la souris
 * Created on 18 ao�t 2000, 10:15
 */
package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AppAnimerComposanteEtClickSouris extends JPanel{
    
    protected ComposanteAnimation uneComposanteAnimation;
    
    /** Constructeur */
    public AppAnimerComposanteEtClickSouris() {
        uneComposanteAnimation = new ComposanteAnimation();
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
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        uneComposanteAnimation.paint(g);
    }
    

    public static void main (String args[]) {
        AppAnimerComposanteEtClickSouris lePanelAnimation =  new AppAnimerComposanteEtClickSouris();
        JFrame leFrame = new JFrame("Animation avec interactivit� simple");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
        lePanelAnimation.start();
    }
}