/*
 * ExempleDessinJFrame.java
 * Exemple de dessin avec paint dans JFrame
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test extends JFrame {

    /** Constructeur de ExempleDessinJFrame */
    public Test() {
        super("Exemples de méthodes de Graphics dans un JFrame");
    }
    // paint() est appelée indirectement lors de la création du JFrame par show()
    public void paint (Graphics g) {
        int x = 100; // Coordonnées x,y du coin supérieur gauche du bonhomme
        int y = 50;
        int largeur = 100; // Largeur et hauteur du bonhomme
        int hauteur = 200;
        int milieux = x + largeur/2;
        int milieuy = y + hauteur/2;
        // La tête
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
        g.drawLine(x,y+hauteur/4,milieux,milieuy);
        g.drawLine(x+largeur,y+hauteur/4,milieux,milieuy);
        // Les jambes
        g.drawLine(x,y+hauteur,milieux,y+hauteur*3/4);
        g.drawLine(x+largeur,y+hauteur,milieux,y+hauteur*3/4);
    }

    public static void main (String args[]) {
        Test leFrame =  new Test();
        leFrame.setSize(300,300);
        leFrame.show();        
    }
}