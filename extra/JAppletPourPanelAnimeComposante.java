/*
 * JAppletPourPanelAnimeComposante.java
 * Applet qui utilise la composante PanelAnimeComposanteAnimation
 */

import java.awt.*;
import javax.swing.JApplet;

public class JAppletPourPanelAnimeComposante extends JApplet {

  public void init() {
    PanelAnimeComposanteAnimation unPanelAnimeComposanteAnimation =
        new PanelAnimeComposanteAnimation();
    getContentPane().add(unPanelAnimeComposanteAnimation);
    unPanelAnimeComposanteAnimation.start();
  }
}
