/*
 * ExempleAppletAnimation.java
 * Applet qui utilise la composante AnimationBoucleTest
 * Lorsque l'on appelle uneAnimation.start() dans init(), il n'y a rien qui se passe ????
 * Est-ce un problème de Thread avec l'applet ?
 */

import java.awt.*;
import java.awt.Graphics;
import javax.swing.JApplet;

public class ApTest extends JApplet {
  private AnimationBoucleTest uneAnimation;

  public void init() {
    uneAnimation = new AnimationBoucleTest();
    getContentPane().add(uneAnimation);
  }

  public void paint(Graphics g) {
    uneAnimation.paintComponent(g);
    repaint();
  }
}
