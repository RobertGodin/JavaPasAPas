package JeuSimple;
import java.awt.*;
public abstract class EntiteAnime {
    // Variables d'objet qui d�crivent l'�tat d'un objet EntiteAnime
    protected int x,y;              // Coordonn�es de l'entit�
    protected int largeur,hauteur;  // Taille du rectangle englobant
    protected int vitesseX;         // Vitesse de d�placement dans l'axe x 
    protected int vitesseY;         // Vitesse de d�placement dans l'axe y
    protected boolean visible;      // Indique si l'entit� doit �tre affich�e
    
    // Constructeur
    public EntiteAnime(
      int x, int y, int largeur, int hauteur,
      int vitesseX, int vitesseY, boolean visible) {
        this.x = x; this.y = y;
        this.hauteur = hauteur; this.largeur = largeur;
        this.vitesseX = vitesseX; this.vitesseY = vitesseY;
        this.visible = visible;
    }
    // M�thode de lecture et d'�criture des variables d'objet
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setLargeur(int largeur){this.largeur = largeur;}
    public void setHauteur(int hauteur){this.hauteur = hauteur;}
    public void setVisible(boolean visible){this.visible = visible;}
    public void setVitesseX(int vitesseX){this.vitesseX = vitesseX;}
    public void setVitesseY(int vitesseY){this.vitesseY = vitesseY;}

    public int getX(){return x;}
    public int getY(){return y;}
    public int getLargeur(){return largeur;}
    public int getHauteur(){return hauteur;}
    public boolean getVisible(){return visible;}
    public int getVitesseX(){return vitesseX;}
    public int getVitesseY(){return vitesseY;}

    // Modifier les coordonn�es pour la prochaine sc�ne
    public void prochaineScene(int largeurMonde, int hauteurMonde){
      if (x+largeur>=largeurMonde | x < 0) // Si atteint le bord selon x
        vitesseX = -vitesseX; // Inverser la direction selon x
      x = x + vitesseX; // D�placement selon x     
      if (y+hauteur>=hauteurMonde | y < 0) // Si atteint le bord selon y
        vitesseY = -vitesseY; // Inverser la direction selon y
      y = y + vitesseY; // D�placement selon y           
    }
    // D�termine si la coordonn�e unX,unY touche au rectangle englobant de l'entit�
    public boolean touche(int unX, int unY){
        return ((unX >= x) && (unX <= x + largeur) && (unY >= y) && (unY <= y + hauteur));
    }
    // M�thode abstraite de dessin de l'entit�
    public abstract void paint (Graphics g) ;
    // Dessine seulement si visible
    public void paintSiVisible (Graphics g) {
        if(visible){paint(g);}
    }
    
    // Effacer l'entit�
    public void effacer(Graphics g){
      g.clearRect(x,y,largeur,hauteur);
    }
}