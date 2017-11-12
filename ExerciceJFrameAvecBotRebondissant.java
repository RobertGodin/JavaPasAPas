// Animation par double tampon
// Le Bot rebondit lorsqu'il atteint le bord de la fen�tre
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExerciceJFrameAvecBotRebondissant extends JFrame {

    // Constantes pour la taille de la fenetre et du Bot
    private static final int LARGEURFENETRE = 400;
    private static final int HAUTEURFENETRE = 400;
    private static final int LARGEURBOT = LARGEURFENETRE/4;
    private static final int HAUTEURBOT = HAUTEURFENETRE/3;

    // Tampon pour construire l'image avant d'afficher
    Graphics tamponGraphics; 
    Image tamponImage;
    

    public ExerciceJFrameAvecBotRebondissant() {
        super("Bot rebondissant");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(LARGEURFENETRE,HAUTEURFENETRE);
        this.setVisible(true);
    }
   
    // M�thode qui dessine un Bot dans un objet Graphics g
    // � l'�chelle dans un rectangle englobant de param�tres x,y,largeur,hauteur
    public void paintBot (Graphics g, int x, int y, int largeur, int hauteur) {
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La t�te

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
        g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
    }

    public void paint (Graphics g) {
        super.paint(g);
        tamponImage = createImage(LARGEURFENETRE,HAUTEURFENETRE);
        tamponGraphics = tamponImage.getGraphics();
        int x = 0; // Coordonn�e x du Bot
        int directionBot = 1; //+1 vers la droite et -1 vers la gauche
        int vitesseBot = 5; //nombre d'unit�s de d�placement � chaque it�ration de la boucle
        while(true){
            // Dessine le Bot dans le tampon
            paintBot(tamponGraphics,x,HAUTEURFENETRE-2*HAUTEURBOT,LARGEURBOT,HAUTEURBOT);
            //Copie le tampon dans le contexte graphique de la fenetre
            g.drawImage(tamponImage,0,0,this);
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException uneException){
                System.out.println(uneException.toString()); 
            }
            // Efface le Bot
            tamponGraphics.clearRect(x,HAUTEURFENETRE-2*HAUTEURBOT,LARGEURBOT,HAUTEURBOT);
            // D�place le Bot
            if (x+LARGEURBOT>=LARGEURFENETRE | x < 0) // Si atteint le bord
              directionBot = -directionBot; // Inverser la direction
            x = x + vitesseBot*directionBot; // D�placement du Bot       
        }
    }

    public static void main (String args[]) {
        new ExerciceJFrameAvecBotRebondissant();
    }
}
