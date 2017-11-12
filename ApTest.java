/*
 * ExempleAppletAnimation.java
 * Applet qui utilise la composante AnimationBoucleTest
 * Lorsque l'on appelle uneAnimation.start() dans init(), il n'y a rien qui se passe ????
 * Est-ce un problème de Thread avec l'applet ? 
 * Created on 15 août 2000, 15:36
 */

package LivreJava;
import java.awt.*;
import javax.swing.JApplet;
import java.awt.Graphics;
public class ApTest extends JApplet {
    private AnimationBoucleTest uneAnimation;
    public void init () {
        uneAnimation = new AnimationBoucleTest();
        getContentPane().add(uneAnimation);
    }
    public void paint(Graphics g){ uneAnimation.paintComponent(g); repaint();}
}