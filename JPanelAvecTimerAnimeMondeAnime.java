// JPanel qui anime un objet de MondeAnime
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JPanelAvecTimerAnimeMondeAnime extends JPanel implements ActionListener{

    public static final int INTERVALLEENTRESCENES  = 50; // En ms

    // Le chrono g�n�re un �v�nement � chaque intervalle
    private Timer chrono;
    // Le monde � animer
    private MondeAnime leMondeAnime;

    // Taille du JPanel
    public static final int LARGEURJPANEL = MondeAnime.LARGEURMONDE;
    public static final int HAUTEURJPANEL = MondeAnime.HAUTEURMONDE;
    
    // Conctructeur initialise le monde � animer
    public JPanelAvecTimerAnimeMondeAnime() {
      leMondeAnime = new MondeAnime();
     }
    
    public void start(){
        if (chrono == null){
            chrono = new Timer(INTERVALLEENTRESCENES,this);
            chrono.start();
        }
    }
    // Le chrono appelle actionPerformed p�riodiquement (boucle d'animation)
    public void actionPerformed( ActionEvent e){
        repaint();
        // Produire la prochaine sc�ne du monde � animer
        leMondeAnime.prochaineScene(); 
    }
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double tampon : pas besoin d'effacer !  
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        // Dessine les entit�s de l'animation
        leMondeAnime.paint(g);
    }
}