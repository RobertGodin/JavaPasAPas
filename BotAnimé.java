
import java.awt.*;
public class BotAnim� extends Entit�Anim�e {
    
    // Il faut d�finir au moins un constructeur
    public BotAnim�(int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY, 
                    boolean visible, String fichierAudio, int nombreEtats) {
        super(x,y,largeur,hauteur,vitesseX,vitesseY,visible,fichierAudio,1);
    }

    public void paint (Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La t�te

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
       g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
    }
}