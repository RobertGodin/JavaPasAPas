/*
 * BonhommeQuiBouge.java
 * A une position (x,y), une dimension (largeur, hauteur) et
 * une vitesse de déplacement (vitesseX,vitesseY)
 */
import java.awt.*;
import java.net.URL;
import java.applet.*;
import javax.swing.*;
public class BonhommeQuiBouge{
    
    private int x,y,largeur,hauteur,vitesseX, vitesseY;
    AudioClip unSon;
    
    /** Constructeur de Bonhomme */
    public BonhommeQuiBouge(int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY) {
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        // Chargement du clip audio. L'URL part de la racine qui est le répertoire
        // contenant le fichier .class
        URL url = BonhommeQuiBouge.class.getResource("Son1.wav");
        // Cast du contenu en AudioClip
        try{unSon = (AudioClip)url.getContent();}
        catch(Exception exception){System.err.println(exception.toString());}
    }
    
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void deplacer(){
        if (x+largeur+vitesseX > 400 || x < 0){
            vitesseX = -vitesseX;
            // Le bonhomme fait un son lorsqu'il frappe la fin du monde !
            // On arrête le son précédent au cas o� il ne serait pas terminé
            unSon.stop();
            unSon.play();
        }
        x=x+vitesseX;
        if (y+hauteur+vitesseY > 600 || y < 0){
            vitesseY = -vitesseY;
            // Le bonhomme fait un son lorsqu'il frappe la fin du monde !
            unSon.stop();
            unSon.play();
        }
        y=y+vitesseY;
    }
    public void paint (Graphics g) {
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
}