/*
 * JAppletPourPanelAnimeComposante.java
 * Applet qui utilise la composante PanelAnimeComposanteAnimation
 * Created on 2 juillet 2001, 18:43
 */

package LivreJava;
import java.awt.*;
import javax.swing.JApplet;
import java.awt.Graphics;
public class JAppletPourPanelAnimeComposante extends JApplet {

    public void init () {
        PanelAnimeComposanteAnimation unPanelAnimeComposanteAnimation = new PanelAnimeComposanteAnimation();
        getContentPane().add(unPanelAnimeComposanteAnimation);
        unPanelAnimeComposanteAnimation.start();
    }
}