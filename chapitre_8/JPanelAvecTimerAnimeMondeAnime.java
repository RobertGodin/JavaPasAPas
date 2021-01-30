// JPanel qui anime un objet de MondeAnime
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelAvecTimerAnimeMondeAnime extends JPanel implements ActionListener {

  public static final int INTERVALLEENTRESCENES = 50; // En ms

  // Le chrono génère un événement à chaque intervalle
  private Timer chrono;
  // Le monde à animer
  private MondeAnime leMondeAnime;

  // Taille du JPanel
  public static final int LARGEURJPANEL = MondeAnime.LARGEURMONDE;
  public static final int HAUTEURJPANEL = MondeAnime.HAUTEURMONDE;

  // Conctructeur initialise le monde à animer
  public JPanelAvecTimerAnimeMondeAnime() {
    leMondeAnime = new MondeAnime();
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
    // Produire la prochaine scàne du monde à animer
    leMondeAnime.prochaineScene();
  }

  // paintComponent() est appelée indirectement par repaint()
  // N.B. Swing utilise le double tampon : pas besoin d'effacer !
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dessine les entités de l'animation
    leMondeAnime.paint(g);
  }
}
