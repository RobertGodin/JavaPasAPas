/*
 * AnimationBoucleTest.java
 * Exemple de composante pour l'animation r�alis�e avec un JPanel
 * Boucle d'animation explicite
 * Created on 18 ao�t 2000, 10:15
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AnimationBoucleTest extends JPanel{
    
    private Bonhomme unBonhomme;
    
    /** Constructeur  */
    public AnimationBoucleTest() {
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
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double buffering
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        unBonhomme.paint(g);
        unBonhomme.setX(unBonhomme.getX()+5);
    }

    public static void main (String args[]) {
        AnimationBoucleTest lePanelAnimation =  new AnimationBoucleTest();
        JFrame leFrame = new JFrame("AnimationBoucleTest");
        leFrame.getContentPane().add(lePanelAnimation);
        leFrame.addWindowListener ( 
            new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            }
        );
        leFrame.setSize(300,300);
        leFrame.show();
        lePanelAnimation.start();
    }
}

