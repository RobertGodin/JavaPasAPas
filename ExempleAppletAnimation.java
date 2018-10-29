/*
 * ExempleAppletAnimation.java
 * Applet qui utilise la composante ExempleAnimation
 * Created on 15 ao�t 2000, 15:36
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