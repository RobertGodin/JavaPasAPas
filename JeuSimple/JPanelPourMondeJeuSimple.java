package JeuSimple;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JPanelPourMondeJeuSimple extends JPanel implements ActionListener, MouseListener{

    public static final int INTERVALLEENTRESCENES = 50; // En ms

    // Le chrono génère un événement à chaque intervalle
    private Timer chrono;
    // Le monde à animer
    private MondeDuJeu leMondeDuJeu;

    // Taille du JPanel
    public static final int LARGEURJPANEL = MondeDuJeu.LARGEURMONDE;
    public static final int HAUTEURJPANEL = MondeDuJeu.HAUTEURMONDE;
    
    // Conctructeur initialise le monde à animer
    public JPanelPourMondeJeuSimple() {
      leMondeDuJeu = new MondeDuJeu();
      addMouseListener (this);
     }
    
    public void start(){
        if (chrono == null){
            chrono = new Timer(INTERVALLEENTRESCENES,this);
            chrono.start();
        }
    }
    // Le chrono appelle actionPerformed périodiquement (boucle d'animation)
    public void actionPerformed( ActionEvent e){
        repaint();
        // Produire la prochaine scène du monde à animer
        leMondeDuJeu.prochaineScene(); 
    }
    
    // paintComponent() est appelée indirectement par repaint()
    // N.B. Swing utilise le double tampon : pas besoin d'effacer !  
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        // Dessine les entités de l'animation
        leMondeDuJeu.paint(g);
    }

    public void mousePressed(MouseEvent leMouseEvent){
      leMondeDuJeu.mousePressed(leMouseEvent);
    }
    // Il faut absolument définir les autres méthodes pour les autres
    // événements de souris même s'il ne font rien
    public void mouseClicked(MouseEvent leMouseEvent){}
    public void mouseEntered(MouseEvent leMouseEvent){}
    public void mouseExited(MouseEvent leMouseEvent){}
    public void mouseReleased(MouseEvent leMouseEvent){}

}