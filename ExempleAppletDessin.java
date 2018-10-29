/*
 * ExempleAppletDessin.java
 * Dessins avec m�thodes de la classe Graphics dans le contexte d'un applet
 * Created on 15 ao�t 2000, 15:36
 */

import java.awt.*;
import javax.swing.JApplet;
import java.awt.Graphics;
/**
 *
 * @author  Godin, Robert
 * @version 
 */
public class ExempleAppletDessin extends JApplet {

    public void paint (Graphics g) {
        int x = 100; // Coordonn�es x,y du coin sup�rieur gauche du bonhomme
        int y = 20;
        int largeur = 100; // Largeur et hauteur du bonhomme
        int hauteur = 200;
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
        g.drawLine(x,y+hauteur/4,milieux,milieuy);
        g.drawLine(x+largeur,y+hauteur/4,milieux,milieuy);
        // Les jambes
        g.drawLine(x,y+hauteur,milieux,y+hauteur*3/4);
        g.drawLine(x+largeur,y+hauteur,milieux,y+hauteur*3/4);
    }
}