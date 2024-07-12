// Plusieurs Bot et Iti qui bougent dans un JPanel avec Timer
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleJPanelAvecAnimationParTimer extends JPanel implements ActionListener {

  public static final int INTERVALLEENTRESCENES = 50; // En ms

  // Le chrono génère un événement à chaque intervalle
  private Timer chrono;
  // Entités du monde à animer
  private BotSCEntiteRebondissante bot1;
  private BotSCEntiteRebondissante bot2;
  private ItiSCEntiteRebondissante iti1;
  private ItiSCEntiteRebondissante iti2;

  // Taille du JPanel
  public static final int LARGEURJPANEL = 400;
  public static final int HAUTEURJPANEL = 400;

  // Conctructeur initialise les entit�s � animer
  public ExempleJPanelAvecAnimationParTimer() {
    bot1 = new BotSCEntiteRebondissante(0, 100, 100, 150, 5, 0);
    bot2 = new BotSCEntiteRebondissante(100, 100, 75, 100, -10, 5);
    iti1 = new ItiSCEntiteRebondissante(200, 300, 80, 80, 6, 6);
    iti2 = new ItiSCEntiteRebondissante(200, 0, 50, 50, 0, 10);
  }

  public void start() {
    if (chrono == null) {
      chrono = new Timer(INTERVALLEENTRESCENES, this);
      chrono.start();
    }
  }
  // Le chrono appelle actionPerformed périodiquement (boucle d'animation)
  public void actionPerformed(ActionEvent e) {
    // Affiche la scène
    repaint();

    // Déplace les entités à animer pour la prochaine scène
    bot1.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    bot2.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    iti1.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    iti2.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
  }

  // paintComponent() est appelée indirectement par repaint()
  // N.B. Swing utilise le double tampon : pas besoin d'effacer !
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dessine les entités de l'animation
    bot1.paint(g);
    bot2.paint(g);
    iti1.paint(g);
    iti2.paint(g);
  }
}
