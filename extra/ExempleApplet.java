/*
 * ExempleApplet.java
 * Petit exemple d'applette
 */
package LivreJava;

import java.awt.Graphics;
import javax.swing.JApplet;

public class ExempleApplet extends JApplet {

  public void paint(Graphics g) {
    g.drawString("Mon premier applet un peu simplet", 10, 20);
  }
}
