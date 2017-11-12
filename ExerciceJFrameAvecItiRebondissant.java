// Animation par double tampon
// Le Iti se déplace à la verticale
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExerciceJFrameAvecItiRebondissant extends JFrame {

    // Constantes pour la taille de la fenetre et du Iti
    private static final int LARGEURFENETRE = 400;
    private static final int HAUTEURFENETRE = 400;
    private static final int LARGEURITI = LARGEURFENETRE/5;
    private static final int HAUTEURITI = HAUTEURFENETRE/4;

    // Tampon pour construire l'image avant d'afficher
    Graphics tamponGraphics; 
    Image tamponImage;
    

    public ExerciceJFrameAvecItiRebondissant() {
        super("Iti rebondissant");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(LARGEURFENETRE,HAUTEURFENETRE);
        this.setVisible(true);
    }
   
    // Méthode qui dessine un Iti dans un objet Graphics g
    // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
    public static void paintIti (Graphics g, int x, int y, int largeur, int hauteur) {
        // Coordonnées du milieu du rectangle englobant pour faciliter les calculs
        int milieux = x + largeur/2;
        int milieuy = y + hauteur/2;
        // La tête
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
        g.drawLine(x+1,y+hauteur/4,milieux,milieuy);
        g.drawLine(x+largeur-1,y+hauteur/4,milieux,milieuy);
        // Les jambes
        g.drawLine(x+1,y+hauteur-1,milieux,y+hauteur*3/4);
        g.drawLine(x+largeur-1,y+hauteur-1,milieux,y+hauteur*3/4);
    }

    public void paint (Graphics g) {
        super.paint(g);
        tamponImage = createImage(LARGEURFENETRE,HAUTEURFENETRE);
        tamponGraphics = tamponImage.getGraphics();
        int y = 0; // Coordonnée y du Iti
        int directionIti = 1; //+1 vers la droite et -1 vers la gauche
        int vitesseIti = 5; //nombre d'unités de déplacement à chaque itération de la boucle
        while(true){
            // Dessine le Iti dans le tampon
            paintIti(tamponGraphics,LARGEURFENETRE-3*LARGEURITI,y,LARGEURITI,HAUTEURITI);
            //Copie le tampon dans le contexte graphique de la fenetre
            g.drawImage(tamponImage,0,0,this);
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException uneException){
                System.out.println(uneException.toString()); 
            }
            // Efface le Iti
            tamponGraphics.clearRect(LARGEURFENETRE-3*LARGEURITI,y,LARGEURITI,HAUTEURITI);
            // Déplace le Iti
            if (y+HAUTEURITI>=HAUTEURFENETRE | y < 0) // Si atteint le bord
              directionIti = -directionIti; // Inverser la direction
            y = y + vitesseIti*directionIti; // Déplacement du Iti       
        }
    }

    public static void main (String args[]) {
        new ExerciceJFrameAvecItiRebondissant();
    }
}
