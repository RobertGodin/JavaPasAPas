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
    public static final int LARGEURMONDE = 400;
    public static final int HAUTEURMONDE = 400;

    protected Vector vecteurEntit�s;
    
    public MondeDuJeu() {
        vecteurEntit�s = new Vector();
        vecteurEntit�s.addElement(new BotAnimeAvecCri(10,100,20,40,3,3,true,"Son2.wav"));
        vecteurEntit�s.addElement(new ItiAnimeAvecCriVolant(200,50,50,100,3,0,true,"Son3.wav"));
        vecteurEntit�s.addElement(new KennyAnimeAvecCri(100,50,30,60,3,9,true,"Son1.wav"));
        vecteurEntit�s.addElement(new EntiteAnimeAvecCriEtSequenceImages(50,100,100,100,5,5,true,"Son4.wav",9,"coq"));
        vecteurEntit�s.addElement(new EntiteAnimeAvecCriEtSequenceImages(175,350,50,50,0,0,true,"invince.wav",6,"homer"));
    }
    public void prochaineScene(){
        for(Iterator unIterator = vecteurEntit�s.iterator(); unIterator.hasNext();){
            ((EntiteAnime)unIterator.next()).prochaineScene(LARGEURMONDE,HAUTEURMONDE);
        }
    }
    public void paint(Graphics g){
        for(Iterator unIterator = vecteurEntit�s.iterator(); unIterator.hasNext();){
            ((EntiteAnime)unIterator.next()).paintSiVisible(g);
        }
    }
    // Si une entit� est cliqu�e, elle dispara�t en poussant un cri
    public void mousePressed(MouseEvent e){
        for(Iterator unIterator = vecteurEntit�s.iterator(); unIterator.hasNext();){
            EntiteAnimeAvecCri uneEntit�Anim�e = (EntiteAnimeAvecCri)unIterator.next();
            if (uneEntit�Anim�e.touche(e.getX(),e.getY())) {
                uneEntit�Anim�e.setVisible(false);
                uneEntit�Anim�e.crier();
            }
        }
    }
}