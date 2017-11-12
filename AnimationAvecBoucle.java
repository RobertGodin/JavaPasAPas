/*
 * AnimationAvecBoucle.java
 * Exemple de composante pour l'animation réalisée avec un JPanel
 * Boucle d'animation explicite
 * Created on 18 août 2000, 10:15
 */
package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AnimationAvecBoucle extends JPanel{
    
    private Bonhomme unBonhomme;
    /** Constructeur de ExempleObjetBonhomme */
    public AnimationAvecBoucle() {
        unBonhomme = new Bonhomme(100,50,100,200);
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
        }
    }
    
    // paintComponent() est appelée indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        unBonhomme.paint(g);
        unBonhomme.setX(unBonhomme.getX()+5);
    }

    public static void main (String args[]) {
        AnimationAvecBoucle lePanelAnimation =  new AnimationAvecBoucle();
        JFrame leFrame = new JFrame("Animation simple");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
        lePanelAnimation.start();
    }
}

