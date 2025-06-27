// Applet compatible Java 1 avec double tampon qui anime avec ComposanteAnimation
import java.awt.*;

public class AppletAnimerComposante extends java.applet.Applet implements Runnable {

  protected Image tamponImage;
  protected Graphics tamponGraphics;
  protected Thread leThreadAnimation;
  protected Dimension d;
  // Déclarer la composante
  protected ComposanteAnimation uneComposanteAnimation;

  public void init() {
    d = getSize();
    tamponImage = createImage(d.width, d.height);
    tamponGraphics = tamponImage.getGraphics();
    // Initialiser la composante
    uneComposanteAnimation = new ComposanteAnimation();
  }

  public void update(Graphics g) {
    tamponGraphics.clearRect(0, 0, d.width, d.height);
    // Changer l'état du monde pour le prochain cliché
    uneComposanteAnimation.changerMonde();
    // Prendre un clichédu monde
    uneComposanteAnimation.paint(tamponGraphics);
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
      } catch (InterruptedException e) {
      }
      repaint(); // Appelle paint() implicitement qui lui appelle update()
    }
  }
}
