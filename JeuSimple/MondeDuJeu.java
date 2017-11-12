package JeuSimple;
/*
 * MondeDuJeu.java
 * Plusieurs bonhommes dans un Vector
 * Le Iti vole (changement du dessin à chaque état)
 * Ajoute un coq (animation par séquence d'images)
 */
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
public class MondeDuJeu {

    // Taille du monde
    public static final int LARGEURMONDE = 400;
    public static final int HAUTEURMONDE = 400;

    protected Vector vecteurEntités;
    
    public MondeDuJeu() {
        vecteurEntités = new Vector();
        vecteurEntités.addElement(new BotAnimeAvecCri(10,100,20,40,3,3,true,"Son2.wav"));
        vecteurEntités.addElement(new ItiAnimeAvecCriVolant(200,50,50,100,3,0,true,"Son3.wav"));
        vecteurEntités.addElement(new KennyAnimeAvecCri(100,50,30,60,3,9,true,"Son1.wav"));
        vecteurEntités.addElement(new EntiteAnimeAvecCriEtSequenceImages(50,100,100,100,5,5,true,"Son4.wav",9,"coq"));
        vecteurEntités.addElement(new EntiteAnimeAvecCriEtSequenceImages(175,350,50,50,0,0,true,"invince.wav",6,"homer"));
    }
    public void prochaineScene(){
        for(Iterator unIterator = vecteurEntités.iterator(); unIterator.hasNext();){
            ((EntiteAnime)unIterator.next()).prochaineScene(LARGEURMONDE,HAUTEURMONDE);
        }
    }
    public void paint(Graphics g){
        for(Iterator unIterator = vecteurEntités.iterator(); unIterator.hasNext();){
            ((EntiteAnime)unIterator.next()).paintSiVisible(g);
        }
    }
    // Si une entité est cliquée, elle disparaît en poussant un cri
    public void mousePressed(MouseEvent e){
        for(Iterator unIterator = vecteurEntités.iterator(); unIterator.hasNext();){
            EntiteAnimeAvecCri uneEntitéAnimée = (EntiteAnimeAvecCri)unIterator.next();
            if (uneEntitéAnimée.touche(e.getX(),e.getY())) {
                uneEntitéAnimée.setVisible(false);
                uneEntitéAnimée.crier();
            }
        }
    }
}