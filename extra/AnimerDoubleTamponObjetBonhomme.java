/*
 * Animation en utilisant la technique de double tamponnage et en utilisant
 * un objet de la classe Bonhomme
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimerDoubleTamponObjetBonhomme extends JFrame {
  Graphics tamponGraphics;
  Image tamponImage;
  Bonhomme unBonhomme;

  public AnimerDoubleTamponObjetBonhomme() {
    super("Animation par double tamponnage avec objet Bonhomme");
  }

  public void paint(Graphics g) {
    tamponImage = createImage(400, 600);
    tamponGraphics = tamponImage.getGraphics();
    unBonhomme = new Bonhomme(0, 100, 200, 400);
    for (int x = 0; x <= 200; x = x + 5) {
      unBonhomme.setX(x);
      unBonhomme.paint(tamponGraphics);
      g.drawImage(tamponImage, 0, 0, this);
      try {
        Thread.sleep(50);
      } catch (InterruptedException exception) {
        System.err.println(exception.toString());
      }
      tamponGraphics.clearRect(x, 100, 200, 400);
    }
  }

  public static void main(String args[]) {
    AnimerDoubleTamponObjetBonhomme leFrame = new AnimerDoubleTamponObjetBonhomme();
    leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    leFrame.setSize(400, 600);
    leFrame.setVisible(true);
  }
}
