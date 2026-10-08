package JeuSimple;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelPourMondeJeuSimple extends JPanel
    implements ActionListener, MouseListener, MouseMotionListener {

  public static final int INTERVALLEENTRESCENES = 50; // En ms

  // Le chrono génère un événement à chaque intervalle
  private Timer chrono;
  // Le monde à animer
  private MondeDuJeu leMondeDuJeu;

  // Taille du JPanel
  public static final int LARGEURJPANEL = MondeDuJeu.LARGEURMONDE;
  public static final int HAUTEURJPANEL = MondeDuJeu.HAUTEURMONDE;

  // Constructeur initialise le monde à animer
  public JPanelPourMondeJeuSimple() {
    leMondeDuJeu = new MondeDuJeu();
    setBackground(Color.black); // Le fond noir de l'espace
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void start() {
    if (chrono == null) {
      chrono = new Timer(INTERVALLEENTRESCENES, this);
      chrono.start();
    }
  }

  // Le chrono appelle actionPerformed périodiquement (boucle d'animation)
  public void actionPerformed(ActionEvent e) {
    repaint();
    // Produire la prochaine scène du monde à animer
    leMondeDuJeu.prochaineScene();
  }

  // paintComponent() est appelée indirectement par repaint()
  // N.B. Swing utilise le double tampon : pas besoin d'effacer !
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dessine les entités de l'animation
    leMondeDuJeu.paint(g);
  }

  public void mousePressed(MouseEvent leMouseEvent) {
    leMondeDuJeu.mousePressed(leMouseEvent);
  }

  public void mouseMoved(MouseEvent leMouseEvent) {
    leMondeDuJeu.mouseMoved(leMouseEvent);
  }

  // Le canon suit aussi la souris lorsqu'un bouton est enfoncé
  public void mouseDragged(MouseEvent leMouseEvent) {
    leMondeDuJeu.mouseMoved(leMouseEvent);
  }

  // Il faut absolument définir les autres méthodes pour les autres
  // événements de souris même s'ils ne font rien
  public void mouseClicked(MouseEvent leMouseEvent) {}

  public void mouseEntered(MouseEvent leMouseEvent) {}

  public void mouseExited(MouseEvent leMouseEvent) {}

  public void mouseReleased(MouseEvent leMouseEvent) {}
}
