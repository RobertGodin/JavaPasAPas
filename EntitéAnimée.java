
import java.awt.*;
import java.net.URL;
import java.applet.*;
public class EntitéAnimée{

    protected int x,y,largeur,hauteur,vitesseX, vitesseY;
    protected boolean visible;
    protected AudioClip unSon;
    protected int étatCourant = 0;
    protected int nombreEtats = 3;

    public EntitéAnimée(int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY,
                    boolean visible, String fichierAudio, int nombreEtats) {
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.visible = visible;
        this.nombreEtats = nombreEtats;
        // Chargement du clip audio. L'URL part de la racine qui est le r�pertoire
        // contenant le fichier .class
        URL url = EntitéAnimée.class.getResource(fichierAudio);
        // Cast du contenu en AudioClip
        try{unSon = (AudioClip)url.getContent();}
        catch(Exception exception){System.err.println(exception.toString());}
    }

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setLargeur(int largeur){this.largeur = largeur;}
    public void setHauteur(int hauteur){this.hauteur = hauteur;}
    public void setVisible(boolean visible){this.visible = visible;}
    public int getX(){return x;}
    public int getY(){return y;}
    public int getLargeur(){return largeur;}
    public int getHauteur(){return hauteur;}
    public boolean getVisible(){return visible;}
    
    public void changer(){
        // Passer à l'état suivant dans le processus d'animation
        if (x+largeur+vitesseX > 500 || x < 0){
            vitesseX = -vitesseX;
            // Le bonhomme fait un son lorsqu'il frappe la fin du monde !
            // On arr�te le son pr�c�dent au cas o� il ne serait pas termin�
        }
        x=x+vitesseX;
        if (y+hauteur+vitesseY > 500 || y < 0){
            vitesseY = -vitesseY;
            // Le bonhomme fait un son lorsqu'il frappe la fin du monde !
        }
        y=y+vitesseY;
        // Etat suivant d'affichage
        étatCourant = (étatCourant + 1)%nombreEtats;
    }
    public void crier (){
        unSon.play();
    }
    public boolean touche(int unX, int unY){
        return ((unX >= x) && (unX <= x + largeur) && (unY >= y) && (unY <= y + hauteur));
    }
    public void paint (Graphics g) {
        // méthode abstraite
    }
    public void paintSiVisible (Graphics g) {
        if(visible){paint(g);}
    }
}