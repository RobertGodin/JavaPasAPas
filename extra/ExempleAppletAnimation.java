/*
 * ExempleAppletAnimation.java
 * Applet qui utilise la composante ExempleAnimation
 */

import java.awt.*;
import javax.swing.JApplet;
import java.awt.Graphics;
public class ExempleAppletAnimation extends JApplet {

    public void init () {
        ExempleAnimation uneAnimation = new ExempleAnimation();
        getContentPane().add(uneAnimation);
        uneAnimation.start();
    }
}