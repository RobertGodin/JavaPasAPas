import java.awt.*;
import javax.swing.JFrame;

public class ExercicePlusieursBotEtIti extends JFrame {

    public ExercicePlusieursBotEtIti() {
        super("Rassemblement de Bots et Itis");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,600);
        this.setVisible(true);
    }

    // Méthode qui dessine un Bot dans un objet Graphics g
    // à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
    public static void paintBot (Graphics g, int x, int y, int largeur, int hauteur) {
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La tête

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
        g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
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
        g.drawLine(x,y+hauteur/4,milieux,milieuy);
        g.drawLine(x+largeur,y+hauteur/4,milieux,milieuy);
        // Les jambes
        g.drawLine(x,y+hauteur,milieux,y+hauteur*3/4);
        g.drawLine(x+largeur,y+hauteur,milieux,y+hauteur*3/4);
    }

    public void paint (Graphics g) {
        super.paint(g);
        paintBot(g,10,40,50,100);
        paintBot(g,200,200,20,40);
        paintBot(g,150,500,50,25);
        paintBot(g,300,50,40,160);
        paintIti(g,150,200,40,80);
        paintIti(g,50,350,100,200);
        paintIti(g,300,300,60,120);
    }

    public static void main (String args[]) {
        new ExercicePlusieursBotEtIti();
    }
}