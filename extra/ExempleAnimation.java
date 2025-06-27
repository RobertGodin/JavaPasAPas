/*
 * ExempleAnimation.java
 * Animation simple qui bouge le bonhomme de gauche à droite
 * Exemple de composante pour l'animation réalisée avec un JPanel
 * Un Timer est utilisé pour réaliser la boucle d'animation
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleAnimation extends JPanel implements ActionListener {

  private Bonhomme unBonhomme;
  private Timer chrono;
  /** Constructeur de ExempleObjetBonhomme */
  public ExempleAnimation() {
    unBonhomme = new Bonhomme(0, 100, 200, 400);
  }

  public void start() {
    if (chrono == null) {
      chrono = new Timer(50, this);
      chrono.start();
    }
  }
  // Le chrono appelle actionPerformed périodiquement (boucle d'animation)
  public void actionPerformed(ActionEvent e) {
    repaint();
    unBonhomme.setX(unBonhomme.getX() + 5);
    if (unBonhomme.getX() >= 200) {
      chrono.stop();
    }
  }

  // paintComponent() est appelée indirectement par repaint()
  // N.B. Swing utilise le double buffering

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    unBonhomme.paint(g);
  }

  public static void main(String args[]) {
    ExempleAnimation lePanelAnimation = new ExempleAnimation();
    JFrame leFrame = new JFrame("Animation simple avec objet et composantes Swing");
    leFrame.getContentPane().add(lePanelAnimation);
    leFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    leFrame.setSize(400, 600);
    leFrame.setVisible(true);
    lePanelAnimation.start();
  }
}
