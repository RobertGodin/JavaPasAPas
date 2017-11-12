package Bonhommes;
import java.awt.*;
public class ItiRebondissant {
    // Variables d'objet qui d�crivent l'�tat d'un objet ItiRebondissant
    private int x,y;              // Coordonn�es x du Bot
    private int largeur,hauteur;  // Taille du Bot
    private int vitesseX;         // Vitesse de d�placement dans l'axe x 
    private int vitesseY;         // Vitesse de d�placement dans l'axe y
    
    // Constructeur pour initialiser l'�tat du ItiRebondissant
    public ItiRebondissant(
      int x, int y, int largeur, int hauteur,
      int vitesseX,int vitesseY) {
        this.x = x; this.y = y;
        this.hauteur = hauteur; this.largeur = largeur;
        this.vitesseX = vitesseX; this.vitesseY = vitesseY;
    }

    // D�placement pour la prochaine it�ration
    public void deplacer(int largeurFenetre, int hauteurFenetre){
      if (x+largeur>=largeurFenetre | x < 0) // Si atteint le bord selon x
        vitesseX = -vitesseX; // Inverser la direction selon x
      x = x + vitesseX; // D�placement selon x     
      if (y+hauteur>=hauteurFenetre | y < 0) // Si atteint le bord selon y
        vitesseY = -vitesseY; // Inverser la direction selon y
      y = y + vitesseY; // D�placement selon y           
    }

    // Dessin du Iti
    public void paint(Graphics g) {
        // Coordonn�es du milieu du rectangle englobant pour faciliter les calculs
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
        g.drawLine(x+1,y+hauteur/4,milieux,milieuy);
        g.drawLine(x+largeur-1,y+hauteur/4,milieux,milieuy);
        // Les jambes
        g.drawLine(x+1,y+hauteur-1,milieux,y+hauteur*3/4);
        g.drawLine(x+largeur-1,y+hauteur-1,milieux,y+hauteur*3/4);
    }

    // Effacer le rectangle du Iti dans tamponGraphics
    public void effacer(Graphics tamponGraphics){
      tamponGraphics.clearRect(x,y,largeur,hauteur);
    }
}