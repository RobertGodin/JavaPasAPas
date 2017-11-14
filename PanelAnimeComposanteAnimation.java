/*
 * PanelAnimeComposanteAnimation.java
 * Animation de ComposanteAnimation
 * Exemple de composante pour l'animation r�alis�e avec un JPanel
 * Un Timer est utilis� pour r�aliser la boucle d'animation
 */
package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PanelAnimeComposanteAnimation extends JPanel implements ActionListener{
    
    protected ComposanteAnimation uneComposanteAnimation;
    private Timer chrono;

    public PanelAnimeComposanteAnimation() {
        uneComposanteAnimation = new ComposanteAnimation();
     }
    
    public void start(){
        if (chrono == null){
            chrono = new Timer(50,this);
            chrono.start();
        }
    }
    // Le chrono appelle actionPerformed p�riodiquement (boucle d'animation)
    public void actionPerformed( ActionEvent e){
        repaint();
        uneComposanteAnimation.changerMonde();
    }
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        uneComposanteAnimation.paint(g);
    }

    public static void main (String args[]) {
        PanelAnimeComposanteAnimation lePanelAnimation =  new PanelAnimeComposanteAnimation();
        JFrame leFrame = new JFrame("Animation de ComposanteAnimation avec Timer");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
        lePanelAnimation.start();
    }
}