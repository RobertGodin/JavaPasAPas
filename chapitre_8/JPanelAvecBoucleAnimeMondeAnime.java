// JPanel avec boucle qui anime un objet de MondeAnime
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelAvecBoucleAnimeMondeAnime extends JPanel {

  public static final int INTERVALLEENTRESCENES = 50; // En ms

  // Le chrono génère un évènement à chaque intervalle
  //    private Timer chrono;
  // Le monde à animer
  private MondeAnime leMondeAnime;

  // Taille du JPanel
  public static final int LARGEURJPANEL = MondeAnime.LARGEURMONDE;
  public static final int HAUTEURJPANEL = MondeAnime.HAUTEURMONDE;

  // Conctructeur initialise le monde à animer
  public JPanelAvecBoucleAnimeMondeAnime() {
    leMondeAnime = new MondeAnime();
  }

  public void start() {
    while (true) {
      repaint();
      try {
        Thread.sleep(INTERVALLEENTRESCENES);
      } catch (InterruptedException exception) {
        System.err.println(exception.toString());
      }
      leMondeAnime.prochaineScene();
    }
  }

  // paintComponent() est appelée indirectement par repaint()
  // N.B. Swing utilise le double tampon : pas besoin d'effacer !
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dessine les entités de l'animation
    leMondeAnime.paint(g);
  }
}
