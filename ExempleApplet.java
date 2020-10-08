/*
 * ExempleApplet.java
 * Petit exemple d'applette 
 */
package LivreJava;
import javax.swing.JApplet;
import java.awt.Graphics;

public class ExempleApplet extends JApplet {

    public void paint (Graphics g) {
        g.drawString("Mon premier applet un peu simplet",10,20);
    }
}