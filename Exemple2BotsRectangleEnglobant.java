import java.awt.*;
import javax.swing.JFrame;

public class Exemple2BotsRectangleEnglobant extends JFrame {

    public Exemple2BotsRectangleEnglobant() {
        super("2 Bots avec rectangle englobant");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,600);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        
        // Rectangle englobant du premier Bot
        int x = 100;
        int y = 100;
        int largeur = 200;
        int hauteur = 400;
        
        // Bonhomme à l'échelle dans un rectangle englobant défini par x,y,largeur,hauteur
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La tête

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
       g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps

        // Rectangle englobant du deuxième Bot
        x = 25;
        y = 50;
        largeur = 100;
        hauteur = 200;

        // Bonhomme à l'échelle dans un rectangle englobant défini par x,y,largeur,hauteur
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La tête

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
       g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps

    }

    public static void main (String args[]) {
        new Exemple2BotsRectangleEnglobant();
    }
}