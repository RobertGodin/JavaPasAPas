/*
 * ExempleObjetBonhomme.java
 * Utilisation de la classe Bonhomme
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ExempleObjetBonhomme extends JFrame {
        
    /** Constructeur de ExempleObjetBonhomme */
    public ExempleObjetBonhomme() {
        super("Exemple d'utilisation d'un objet de la classe Bonhomme");
    }   
    
    // paint() est appel�e indirectement lors de la cr�ation du JFrame par show()
    public void paint (Graphics g) {
        Bonhomme unBonhomme = new Bonhomme(100,100,100,200);
        unBonhomme.paint(g);
        unBonhomme.setX(50);
        unBonhomme.setY(50);
        unBonhomme.setLargeur(50);
        unBonhomme.setHauteur(100);
        unBonhomme.paint(g);
        unBonhomme.setX(30);
        unBonhomme.setY(30);
        unBonhomme.setLargeur(10);
        unBonhomme.setHauteur(20);
        unBonhomme.paint(g);
    }

    public static void main (String args[]) {
        ExempleObjetBonhomme leFrame =  new ExempleObjetBonhomme();
        leFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leFrame.setSize(400,600);
        leFrame.setVisible(true);
    }
}