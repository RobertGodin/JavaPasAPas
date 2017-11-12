// Animation par double tampon
// Le Iti se d�place sur la verticale en alternance
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExerciceJFrameItiRebondissant extends JFrame {

    // Constantes pour la taille de la fenetre et du Bot
    private static final int LARGEURFENETRE = 400;
    private static final int HAUTEURFENETRE = 400;
    private static final int LARGEURBOT = LARGEURFENETRE/4;
    private static final int HAUTEURBOT = HAUTEURFENETRE/3;

    // Tampon pour construire l'image avant d'afficher
    Graphics tamponGraphics; 
    Image tamponImage;
    

    public ExerciceJFrameItiRebondissant() {
        super("Iti rebondissant");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(LARGEURFENETRE,HAUTEURFENETRE);
        this.setVisible(true);
    }
   
    // M�thode qui dessine un Iti dans un objet Graphics g
    // � l'�chelle dans un rectangle englobant de param�tres x,y,largeur,hauteur
    public static void paintIti (Graphics g, int x, int y, int largeur, int hauteur) {
        // Coordonn�es du milieu du rectangle englobant pour faciliter les calculs
        int milieux = x + largeur/2;
        int milieuy = y + hauteur/2;
        // La t�te
        g.setColor(Color.pink);
        g.fillOval(x+largeur/3,y,largeur/3,hauteur/4);
        // Le sourire
        g.setColor(Color.black);
        g.drawArc(x+largeur/3,y-hauteur/12,largeur/3,hauteur/4,-125,70);
        // Les yeux 
        g.fillOval(milieux-largeur/8,y+hauteur/12,largeur/12,hauteur/24);
        g.fillOval(milieux+largeur/8-largeur/12,y+hauteur/12,largeur/12,hauteur/24);
        // Le corps
        g.drawLine(milieux,y+hauteur/4,milieux,y+hauteur*3/4);
        // Les bras
        g.drawLine(x,y+hauteur/4,milieux,milieuy);
        g.drawLine(x+largeur,y+hauteur/4,milieux,milieuy);
        // Les jambes
        g.drawLine(x,y+hauteur,milieux,y+hauteur*3/4);
        g.drawLine(x+largeur,y+hauteur,milieux,y+hauteur*3/4);
    }

    public void paint (Graphics g) {
        tamponImage = createImage(LARGEURFENETRE,HAUTEURFENETRE);
        tamponGraphics = tamponImage.getGraphics();
        int x = 0; // Coordonn�e x du Bot
        int directionBot = 1; //+1 vers la droite et -1 vers la gauche
        int vitesseBot = 5; //nombre d'unit�s de d�placement � chaque it�ration de la boucle
        while(true){
            // Dessine le Iti dans le tampon
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
        ExerciceJFrameItiRebondissant laFenetre = new ExerciceJFrameItiRebondissant();
    }
}
