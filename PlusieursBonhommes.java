
/*
 * Exercice : dessiner plusieurs bonhommes avec méthodes statiques
 */

package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PlusieursBonhommes extends JFrame {

    public PlusieursBonhommes() {
        super("Exemple d'utilisation d'une méthode statique paintBonhomme");
    }
   
    public static void paintBonhommeKeny (Graphics g, int x, int y, int largeur, int hauteur) {
    //Bonhomme à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
        int milieux = x + (largeur/2);
        int milieuy = y + (hauteur/2);
        // Le corps
        g.setColor(new Color(255,100,0));
        g.fillRect(x+(largeur/8),milieuy-(hauteur/16),largeur*3/4,(hauteur/2)+(hauteur/16));
        g.setColor(Color.black);
        g.drawRect(x+(largeur/8),milieuy-(hauteur/16),largeur*3/4,(hauteur/2)+(hauteur/16));
        // La tête
        g.setColor(new Color(255,100,0));
        g.fillOval(x,y,largeur,hauteur/2);
        g.setColor(Color.black);
        g.drawOval(x,y,largeur,hauteur/2);
        
        g.setColor(Color.orange);
        g.fillOval(x+largeur/3,y+(hauteur/10),largeur/3,hauteur*3/10);
        // Les yeux
        g.setColor(Color.white);
        g.fillOval(milieux-(largeur/6),y+(hauteur/5),largeur/6,hauteur/10);
        g.fillOval(milieux,y+(hauteur/5),largeur/6,hauteur/10);
        g.setColor(Color.black);
        g.fillOval(milieux-(largeur/12),y+(hauteur/4),largeur/24,largeur/24);
        g.fillOval(milieux+(largeur/24),y+(hauteur/4),largeur/24,largeur/24);
        // Les bras
        g.setColor(new Color(255,100,0));
        g.fillRect(x,milieuy-(hauteur/16),largeur/8,(hauteur/3)+(hauteur/16));
        g.setColor(Color.black);
        g.drawRect(x,milieuy-(hauteur/16),largeur/8,(hauteur/3)+(hauteur/16));

        g.setColor(new Color(255,100,0));
        g.fillRect(x+(largeur*7/8),milieuy-(hauteur/16),largeur/8,(hauteur/3)+(hauteur/16));
        g.setColor(Color.black);
        g.drawRect(x+(largeur*7/8),milieuy-(hauteur/16),largeur/8,(hauteur/3)+(hauteur/16));
    }

            public static void paintBonhommeBot (Graphics g, int x, int y, int largeur, int hauteur) {
    //Bonhomme à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La tête

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
       g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
    }

    public static void paintBonhommeIti (Graphics g, int x, int y, int largeur, int hauteur) {
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
        paintBonhommeKeny(g,100,100,100,200);
        paintBonhommeKeny(g,50,50,50,100);
        paintBonhommeKeny(g,30,30,10,20);
        paintBonhommeBot(g,200,200,10,20);
        paintBonhommeBot(g,150,400,15,30);
        paintBonhommeBot(g,300,50,40,80);
        paintBonhommeIti(g,150,200,40,80);
        paintBonhommeIti(g,50,350,100,200);
        paintBonhommeIti(g,300,300,60,120);
    }

    public static void main (String args[]) {
        PlusieursBonhommes leFrame =  new PlusieursBonhommes();
        leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
    }
}