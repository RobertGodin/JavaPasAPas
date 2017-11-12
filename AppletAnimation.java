// Applet compatible Java 1 avec double tampon
package LivreJava;
import java.awt.*;

public class AppletAnimation
    extends java.applet.Applet implements Runnable {

  protected Image tamponImage;
  protected Graphics tamponGraphics;
  protected Thread leThreadAnimation;
  protected Dimension d;
  //Déclarer objets du monde
  protected BonhommeQuiBouge unBonhomme;

  public void init() {
    //Initialiser objets du monde
    d = getSize();
    tamponImage = createImage(d.width, d.height);
    tamponGraphics = tamponImage.getGraphics();
    unBonhomme = new BonhommeQuiBouge(100,50,100,200,3,3);
  }


  public void update(Graphics g) {

    tamponGraphics.clearRect(0,0,d.width,d.height);
    unBonhomme.deplacer();
    unBonhomme.paint(tamponGraphics);
    // copier tamponImage sur l'écran
    g.drawImage(tamponImage, 0, 0, this);
  }

  public void paint(Graphics g) {
    update(g);
  }

  public void start() {
    leThreadAnimation = new Thread(this);
    leThreadAnimation.start();
  }

  public void stop() {
    leThreadAnimation = null;
  }

  public void run() {
    while (Thread.currentThread() == leThreadAnimation) {
      try {
        Thread.currentThread().sleep(50);
      } catch  (InterruptedException  e) {}
        repaint();
    }
  }
}