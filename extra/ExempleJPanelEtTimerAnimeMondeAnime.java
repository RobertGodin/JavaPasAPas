// JPanel avec Timer qui anime un objet de la classe MondeAnime
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExempleJPanelEtTimerAnimeMondeAnime extends JPanel implements ActionListener{

    public static int intervalleEntreScenes = 50; // En ms

    // Le chrono g�n�re un �v�nement � chaque intervalle
    private Timer chrono;
    // Entit�s du monde � animer
    private MondeAnime leMondeAnime;
    
    // Conctructeur initialise les entit�s � animer
    public ExempleJPanelEtTimerAnimeMondeAnime() {
      leMondeAnime = new MondeAnime();
     }
    
    public void start(){
        if (chrono == null){
            chrono = new Timer(intervalleEntreScenes,this);
            chrono.start();
        }
    }
    // Le chrono appelle actionPerformed p�riodiquement (boucle d'animation)
    public void actionPerformed( ActionEvent e){
        repaint();
        // Produire la prochaine sc�ne
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