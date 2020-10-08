package JeuSimple;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JPanelPourMondeDuJeuSimpleAvecAdapator extends JPanel implements ActionListener{

    public static final int INTERVALLEENTRESCENES = 50; // En ms

    // Le chrono g�n�re un événement à chaque intervalle
    private Timer chrono;
    // Le monde à animer
    private MondeDuJeu leMondeDuJeu;

    // Taille du JPanel
    public static final int LARGEURJPANEL = MondeDuJeu.LARGEURMONDE;
    public static final int HAUTEURJPANEL = MondeDuJeu.HAUTEURMONDE;
    
    // Conctructeur initialise le monde à animer
    public JPanelPourMondeDuJeuSimpleAvecAdapator() {
      leMondeDuJeu = new MondeDuJeu();
      addMouseListener (
            new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    leMondeDuJeu.mousePressed(e);
                }
            }
      );
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
        // Produire la prochaine sc�ne du monde à animer
        leMondeDuJeu.prochaineScene(); 
    }
    
    // paintComponent() est appelée indirectement par repaint()
    // N.B. Swing utilise le double tampon : pas besoin d'effacer !  
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        // Dessine les entités de l'animation
        leMondeDuJeu.paint(g);
    }
}