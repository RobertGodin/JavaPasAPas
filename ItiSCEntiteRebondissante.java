import java.awt.*;
public class ItiSCEntiteRebondissante extends EntiteRebondissante {
    
    // Constructeur
    public ItiSCEntiteRebondissante(
      int x, int y, int largeur, int hauteur,int vitesseX,int vitesseY) {
        super(x,y,largeur,hauteur,vitesseX,vitesseY);
    }

    // Corps de la méthode abstraite héritée de la super-classe
    public void paint(Graphics g) {
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
}