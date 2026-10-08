// Plusieurs crabes et soucoupes qui bougent dans un JPanel avec Timer
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExempleJPanelAvecAnimationParTimer extends JPanel
    implements ActionListener {

  public static final int INTERVALLEENTRESCENES = 50; // En ms

  // Le chrono génère un événement à chaque intervalle
  private Timer chrono;
  // Entités du monde à animer
  private CrabeSCEntiteRebondissante crabe1;
  private CrabeSCEntiteRebondissante crabe2;
  private SoucoupeSCEntiteRebondissante soucoupe1;
  private SoucoupeSCEntiteRebondissante soucoupe2;

  // Taille du JPanel
  public static final int LARGEURJPANEL = 400;
  public static final int HAUTEURJPANEL = 400;

  // Constructeur initialise les entités à animer
  public ExempleJPanelAvecAnimationParTimer() {
    crabe1 = new CrabeSCEntiteRebondissante(0, 100, 120, 80, 5, 0);
    crabe2 = new CrabeSCEntiteRebondissante(100, 100, 75, 50, -10, 5);
    soucoupe1 =
        new SoucoupeSCEntiteRebondissante(200, 300, 100, 44, 6, 6);
    soucoupe2 = new SoucoupeSCEntiteRebondissante(200, 0, 64, 28, 0, 10);
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
    crabe1.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    crabe2.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    soucoupe1.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    soucoupe2.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
  }

  // paintComponent() est appelée indirectement par repaint()
  // N.B. Swing utilise le double tampon : pas besoin d'effacer !
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dessine les entités de l'animation
    crabe1.paint(g);
    crabe2.paint(g);
    soucoupe1.paint(g);
    soucoupe2.paint(g);
  }
}
