import java.awt.*;
public class BotSCEntiteRebondissante extends EntiteRebondissante {
    
    // Constructeur
    public BotSCEntiteRebondissante(
      int x, int y, int largeur, int hauteur,int vitesseX,int vitesseY) {
        super(x,y,largeur,hauteur,vitesseX,vitesseY);
    }

    // Corps de la méthode abstraite héritée de la super-classe
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