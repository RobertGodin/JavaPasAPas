/*
 * Exercice : dessinner trois bonhommes simples
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExerciceTroisBonhommes extends JFrame {

    /** Constructeur de ExempleDessinJFrame */
    public ExerciceTroisBonhommes() {
        super("Dessiner trois bonhommes");
    }
    // paint() est appel�e indirectement lors de la cr�ation du JFrame par show()
    public void paint (Graphics g) {
        int a = 2;
        int b = 3;
        g.setColor(Color.green);
        g.fillOval(100,100,200,200); // La t�te

        g.setColor(Color.black);
        g.fillRect(150,150,20,20); // L'oeil gauche
        g.fillRect(230,150,20,20); // L'oeil droit
        g.drawLine(150,250,250,250); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(100,300,200,200); // Le corps
                
        g.setColor(Color.green);
        g.fillOval(100/a,100/a,200/a,200/a); // La t�te

        g.setColor(Color.black);
        g.fillRect(150/a,150/a,20/a,20/a); // L'oeil gauche
        g.fillRect(230/a,150/a,20/a,20/a); // L'oeil droit
        g.drawLine(150/a,250/a,250/a,250/a); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(100/a,300/a,200/a,200/a); // Le corps
                
        g.setColor(Color.green);
        g.fillOval(100/b,100/b,200/b,200/b); // La t�te

        g.setColor(Color.black);
        g.fillRect(150/b,150/b,20/b,20/b); // L'oeil gauche
        g.fillRect(230/b,150/b,20/b,20/b); // L'oeil droit
        g.drawLine(150/b,250/b,250/b,250/b); // La bouche
        
        g.setColor(Color.red);
        g.fillRect(100/b,300/b,200/b,200/b); // Le corps
    }

    public static void main (String args[]) {
        ExerciceTroisBonhommes leFrame =  new ExerciceTroisBonhommes();
        leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
    }
}
