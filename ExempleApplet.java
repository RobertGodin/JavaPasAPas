/*
 * ExempleApplet.java
 * Petit exemple d'applette 
 * Created on 15 août 2000, 15:05
 */
package LivreJava;
import javax.swing.JApplet;
import java.awt.Graphics;
/**
 *
 * @author  Godin, Robert
 * @version 
 */
public class ExempleApplet extends JApplet {

    public void paint (Graphics g) {
        g.drawString("Mon premier applet un peu simplet",10,20);
    }
}