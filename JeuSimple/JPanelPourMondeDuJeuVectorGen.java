package JeuSimple;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelPourMondeDuJeuVectorGen extends JPanel implements ActionListener, MouseListener {

  public static final int INTERVALLEENTRESCENES = 50; // En ms

  // Le chrono génère un évènement a chaque intervalle
  private Timer chrono;
  // Le monde a animer
  private MondeDuJeuVectorGen leMondeDuJeu;

  // Taille du JPanel
  public static final int LARGEURJPANEL = MondeDuJeuVectorGen.LARGEURMONDE;
  public static final int HAUTEURJPANEL = MondeDuJeuVectorGen.HAUTEURMONDE;

  // Conctructeur initialise le monde à animer
  public JPanelPourMondeDuJeuVectorGen() {
    leMondeDuJeu = new MondeDuJeuVectorGen();
    addMouseListener(this);
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
  // Il faut absolument définir les autres méthodes pour les autres
  // événements de souris même s'il ne font rien
  public void mouseClicked(MouseEvent leMouseEvent) {}

  public void mouseEntered(MouseEvent leMouseEvent) {}

  public void mouseExited(MouseEvent leMouseEvent) {}

  public void mouseReleased(MouseEvent leMouseEvent) {}
}
