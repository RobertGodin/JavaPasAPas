// Plusieurs Bot et Iti qui bougent dans un JPanel avec Timer
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExempleJPanelAvecAnimationParTimer extends JPanel implements ActionListener{

    public static final int INTERVALLEENTRESCENES = 50; // En ms

    // Le chrono g�n�re un �v�nement � chaque intervalle
    private Timer chrono;
    // Entit�s du monde � animer
    private BotSCEntiteRebondissante bot1;
    private BotSCEntiteRebondissante bot2;
    private ItiSCEntiteRebondissante iti1;
    private ItiSCEntiteRebondissante iti2;

    // Taille du JPanel
    public static final int LARGEURJPANEL = 400;
    public static final int HAUTEURJPANEL = 400;
    
    // Conctructeur initialise les entit�s � animer
    public ExempleJPanelAvecAnimationParTimer() {
      bot1 = new BotSCEntiteRebondissante(0,100,100,150,5,0);
      bot2 = new BotSCEntiteRebondissante(100,100,75,100,-10,5);
      iti1 = new ItiSCEntiteRebondissante(200,300,80,80,6,6);
      iti2 = new ItiSCEntiteRebondissante(200,0,50,50,0,10);
     }
    
    public void start(){
        if (chrono == null){
            chrono = new Timer(INTERVALLEENTRESCENES,this);
            chrono.start();
        }
    }
    // Le chrono appelle actionPerformed p�riodiquement (boucle d'animation)
    public void actionPerformed( ActionEvent e){
        // Affiche la sc�ne
        repaint();

        // D�place les entit�s � animer pour la prochaine sc�ne
        bot1.deplacer(LARGEURJPANEL, HAUTEURJPANEL); 
        bot2.deplacer(LARGEURJPANEL, HAUTEURJPANEL); 
        iti1.deplacer(LARGEURJPANEL, HAUTEURJPANEL); 
        iti2.deplacer(LARGEURJPANEL, HAUTEURJPANEL);
    }
    
    // paintComponent() est appel�e indirectement par repaint()
    // N.B. Swing utilise le double tampon : pas besoin d'effacer !  
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        // Dessine les entit�s de l'animation
        bot1.paint(g); bot2.paint(g); iti1.paint(g); iti2.paint(g);
    }
}