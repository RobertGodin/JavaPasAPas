import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExempleEvenementSouris extends JFrame 
  implements MouseListener
{
    // Variables d'objet qui contiennent les coordonn�es de la souris
    // Le premier sera dessin� � la coordonn�e (0,0)
    private static int x = 0; // Coordonn�e x du Bot � dessiner
    private static int y = 0; // Coordonn�e y du Bot � dessiner
    
    public ExempleEvenementSouris() {
        super("Exemple de traitement d'�v�nements de la souris");
        
        // Le param�tre this de addMouseListener() indique que l'objet qui doit 
        // r�agir aux �v�nements de souris est l'objet 
        // qui est cr�� par ce constructeur
        addMouseListener(this);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,600);
        this.setVisible(true);
    }

    // M�thode d'objet de la classe ExempleEvenementSouris qui est 
    // appel�e si le bouton de souris est enfonc�
    public void mousePressed(MouseEvent leMouseEvent){
      x = leMouseEvent.getX(); // place la coordonn�e x de la souris dans la variable x
      y = leMouseEvent.getY(); // place la coordonn�e y de la souris dans la variable y
      // repaint() provoque un nouvel appel � paint()
      repaint();
    }

    // Il faut absolument d�finir les autres m�thodes pour les autres
    // �v�nements de souris m�me s'il ne font rien
    public void mouseClicked(MouseEvent leMouseEvent){}
    public void mouseEntered(MouseEvent leMouseEvent){}
    public void mouseExited(MouseEvent leMouseEvent){}
    public void mouseReleased(MouseEvent leMouseEvent){}
   
    public static void paintBot (Graphics g, int x, int y, int largeur, int hauteur) {
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La t�te

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
        g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
    }

    public void paint (Graphics g) {
        super.paint(g);
        paintBot(g,x,y,50,100);
    }

    public static void main (String args[]) {
        new ExempleEvenementSouris();
    }
}