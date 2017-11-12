// JPanel avec boucle qui anime un objet de MondeAnime
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JPanelAvecBoucleAnimeMondeAnime extends JPanel{

    public static final int INTERVALLEENTRESCENES = 50; // En ms

    // Le chrono g�n�re un �v�nement � chaque intervalle
//    private Timer chrono;
    // Le monde � animer
    private MondeAnime leMondeAnime;

    // Taille du JPanel
    public static final int LARGEURJPANEL = MondeAnime.LARGEURMONDE;
    public static final int HAUTEURJPANEL = MondeAnime.HAUTEURMONDE;
    
    // Conctructeur initialise le monde � animer
    public JPanelAvecBoucleAnimeMondeAnime() {
      leMondeAnime = new MondeAnime();
     }
    
    public void start(){
        while (true){
            repaint();
            try {Thread.sleep(INTERVALLEENTRESCENES);}
            catch(InterruptedException exception){
                System.err.println(exception.toString()); 
            }
            leMondeAnime.prochaineScene(); 
        }
    }
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double tampon : pas besoin d'effacer !  
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        // Dessine les entit�s de l'animation
        leMondeAnime.paint(g);
    }
}