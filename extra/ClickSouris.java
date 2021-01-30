
/*
 * Exemple d'interaction avec la souris. Lorsque le bouton est enfoncé, 
 * le programme dessine un autre bonhomme à la position courante de la souris
 * (coin inférieur gauche du rectangle englobant).
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClickSouris extends JFrame {
    private int x = 0; 
    private int y = 0;
    
    public ClickSouris() {
        super("Exemple d'utilisation d'une méthode statique paintBonhomme");
        // Ajoute un objet écouteur des événements de souris du JFrame
        addMouseListener (
            new MouseAdapter(){
                // Cette méthode indique comment répondre à l'événement correspondant
                // à enfoncer le bouton de la souris
                public void mousePressed(MouseEvent e){
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
            }
        );
    }
   
    public static void paintBonhomme (Graphics g, int x, int y, int largeur, int hauteur) {
    //Bonhomme à l'échelle dans un rectangle englobant de paramètres x,y,largeur,hauteur
        g.setColor(Color.green);
        g.fillOval(x,y,largeur,hauteur/2); // La tête

        g.setColor(Color.black);
        g.fillRect(x+largeur/4,y+hauteur/8,largeur/10,hauteur/20); // L'oeil gauche
       g.fillRect(x+largeur*3/4-largeur/10,y+hauteur/8,largeur/10,hauteur/20); // L'oeil droit
        g.drawLine(x+largeur/4,y+hauteur*3/8,x+largeur*3/4,y+hauteur*3/8); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(x,y+hauteur/2,largeur,hauteur/2); // Le corps
    }

    public void paint (Graphics g) {
        paintBonhomme(g,x,y,200,400);
    }

    public static void main (String args[]) {
        ClickSouris leFrame =  new ClickSouris();
        leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
    }
}