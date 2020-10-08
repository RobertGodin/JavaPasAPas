package JeuSimple;
/*
 * MondeDuJeuVectorGen.java
 * Plusieurs bonhommes dans un Vector<EntiteAnime>
 * Le Iti vole (changement du dessin a chaque etat)
 * Ajoute un coq (animation par séquence d'images)
 */
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
public class MondeDuJeuVectorGen {

    // Taille du monde
    public static final int LARGEURMONDE = 1000;
    public static final int HAUTEURMONDE = 1000;

    protected Vector<EntiteAnimeAvecCri> vecteurEntites;
    
    public MondeDuJeuVectorGen() {
        vecteurEntites = new Vector<EntiteAnimeAvecCri>();
        vecteurEntites.addElement(new BotAnimeAvecCri(10,100,100,200,3,3,true,"Son2.wav"));
        vecteurEntites.addElement(new ItiAnimeAvecCriVolant(200,50,100,200,3,0,true,"Son3.wav"));
        vecteurEntites.addElement(new KennyAnimeAvecCri(100,50,100,200,3,9,true,"Son1.wav"));
        vecteurEntites.addElement(new EntiteAnimeAvecCriEtSequenceImages(50,100,300,300,5,5,true,"Son4.wav",9,"coq"));
        vecteurEntites.addElement(new EntiteAnimeAvecCriEtSequenceImages(175,800,200,200,0,0,true,"invince.wav",6,"homer"));
    }
    public void prochaineScene(){
        for(EntiteAnimeAvecCri uneEntiteAnime : vecteurEntites){
            	uneEntiteAnime.prochaineScene(LARGEURMONDE,HAUTEURMONDE);
        }
    }
    public void paint(Graphics g){
        for(EntiteAnimeAvecCri uneEntiteAnime : vecteurEntites){
            	uneEntiteAnime.paintSiVisible(g);
        }
    }
    // Si une entite est clique, elle disparait en poussant un cri
    public void mousePressed(MouseEvent e){
        for(EntiteAnimeAvecCri uneEntiteAnime : vecteurEntites){
            if (uneEntiteAnime.touche(e.getX(),e.getY())) {
                uneEntiteAnime.setVisible(false);
                uneEntiteAnime.crier();
            }
        }
    }
}