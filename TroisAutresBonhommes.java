
/*
 * Exercice trois autres bonhommes (Keny)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TroisAutresBonhommes extends JFrame {

    public TroisAutresBonhommes() {
        super("Exemple d'utilisation d'une méthode statique paintBonhomme");
    }
   
    public static void paintBonhomme (Graphics g, int x, int y, int largeur, int hauteur) {
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

    public void paint (Graphics g) {
        paintBonhomme(g,100,100,100,200);
        paintBonhomme(g,50,50,50,100);
        paintBonhomme(g,30,30,10,20);
    }

    public static void main (String args[]) {
        TroisAutresBonhommes leFrame =  new TroisAutresBonhommes();
        leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
    }
}