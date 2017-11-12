package LivreJava;
import java.awt.*;
import javax.swing.*;
public class BonhommeBot{
    private int x,y,largeur,hauteur;
    /** Constructeur de Bonhomme */
    public BonhommeBot(int x, int y, int largeur, int hauteur) {
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
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La tête

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
       g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
    }
}