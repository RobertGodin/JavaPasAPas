/*
 * ExempleAnimation.java
 * Animation simple qui bouge le bonhomme de gauche � droite
 * Exemple de composante pour l'animation r�alis�e avec un JPanel
 * Un Timer est utilis� pour r�aliser la boucle d'animation
 * Created on 18 ao�t 2000, 10:15
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ExempleAnimation extends JPanel implements ActionListener{
    
    private Bonhomme unBonhomme;
    private Timer chrono;
    /** Constructeur de ExempleObjetBonhomme */
    public ExempleAnimation() {
        unBonhomme = new Bonhomme(0,100,200,400);
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
        unBonhomme.setX(unBonhomme.getX()+5);
        if (unBonhomme.getX() >= 200){chrono.stop();}
    }
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        unBonhomme.paint(g);
    }

    public static void main (String args[]) {
        ExempleAnimation lePanelAnimation =  new ExempleAnimation();
        JFrame leFrame = new JFrame("Animation simple avec objet et composantes Swing");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
        lePanelAnimation.start();
    }
}