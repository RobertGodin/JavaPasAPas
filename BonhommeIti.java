
import java.awt.*;
import javax.swing.*;
public class BonhommeIti{
    private int x,y,largeur,hauteur;
    /** Constructeur de Bonhomme */
    public BonhommeIti(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setLargeur(int largeur){this.largeur = largeur;}
    public void setHauteur(int hauteur){this.hauteur = hauteur;}
    public int getX(){return x;}
    public int getY(){return y;}
    public int getLargeur(){return largeur;}
    public int getHauteur(){return hauteur;}
    
    public void paint (Graphics g) {
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
}