package JeuSimple;
/*
 * MondeDuJeu.java
 * Plusieurs bonhommes dans un Vector
 * Le Iti vole (changement du dessin � chaque �tat)
 * Ajoute un coq (animation par s�quence d'images)
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
    public static final int LARGEURMONDE = 600;
    public static final int HAUTEURMONDE = 600;

    protected Vector vecteurEntites;
    
    public MondeDuJeu() {
        vecteurEntites = new Vector();
        vecteurEntites.addElement(new BotAnimeAvecCri(10,100,20,40,3,3,true,"Son2.wav"));
        vecteurEntites.addElement(new ItiAnimeAvecCriVolant(200,50,50,100,3,0,true,"Son3.wav"));
        vecteurEntites.addElement(new KennyAnimeAvecCri(100,50,30,60,3,9,true,"Son1.wav"));
        vecteurEntites.addElement(new EntiteAnimeAvecCriEtSequenceImages(50,100,100,100,5,5,true,"Son4.wav",9,"coq"));
        vecteurEntites.addElement(new EntiteAnimeAvecCriEtSequenceImages(175,300,50,50,0,0,true,"invince.wav",6,"homer"));
    }
    public void prochaineScene(){
        for(Iterator unIterator = vecteurEntites.iterator(); unIterator.hasNext();){
            ((EntiteAnime)unIterator.next()).prochaineScene(LARGEURMONDE,HAUTEURMONDE);
        }
    }
    public void paint(Graphics g){
        for(Iterator unIterator = vecteurEntites.iterator(); unIterator.hasNext();){
            ((EntiteAnime)unIterator.next()).paintSiVisible(g);
        }
    }
    // Si une entite est clique, elle disparait en poussant un cri
    public void mousePressed(MouseEvent e){
        for(Iterator unIterator = vecteurEntites.iterator(); unIterator.hasNext();){
            EntiteAnimeAvecCri uneEntiteAnimee = (EntiteAnimeAvecCri)unIterator.next();
            if (uneEntiteAnimee.touche(e.getX(),e.getY())) {
                uneEntiteAnimee.setVisible(false);
                uneEntiteAnimee.crier();
            }
        }
    }
}