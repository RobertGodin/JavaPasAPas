package JeuSimple;
/*
 * MondeDuJeu.java
 * Plusieurs bonhommes dans un Vector
 * Le Iti vole (changement du dessin à chaque état)
 * Ajoute un coq (animation par séquence d'images)
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class MondeDuJeu {

  // Taille du monde
  public static final int LARGEURMONDE = 1000;
  public static final int HAUTEURMONDE = 1000;

  protected Vector vecteurEntites;

  public MondeDuJeu() {
    vecteurEntites = new Vector();
    vecteurEntites.addElement(new BotAnimeAvecCri(10, 100, 100, 200, 3, 3, true, "Son2.wav"));
    vecteurEntites.addElement(new ItiAnimeAvecCriVolant(200, 50, 100, 200, 3, 0, true, "Son3.wav"));
    vecteurEntites.addElement(new KennyAnimeAvecCri(100, 50, 100, 200, 3, 9, true, "Son1.wav"));
    vecteurEntites.addElement(
        new EntiteAnimeAvecCriEtSequenceImages(
            50, 100, 300, 300, 5, 5, true, "Son4.wav", 9, "coq"));
    vecteurEntites.addElement(
        new EntiteAnimeAvecCriEtSequenceImages(
            175, 800, 200, 200, 0, 0, true, "invince.wav", 6, "homer"));
  }

  public void prochaineScene() {
    for (Iterator unIterator = vecteurEntites.iterator(); unIterator.hasNext(); ) {
      ((EntiteAnime) unIterator.next()).prochaineScene(LARGEURMONDE, HAUTEURMONDE);
    }
  }

  public void paint(Graphics g) {
    for (Iterator unIterator = vecteurEntites.iterator(); unIterator.hasNext(); ) {
      ((EntiteAnime) unIterator.next()).paintSiVisible(g);
    }
  }
  // Si une entité est cliquée, elle disparait en poussant un cri
  public void mousePressed(MouseEvent e) {
    for (Iterator unIterator = vecteurEntites.iterator(); unIterator.hasNext(); ) {
      EntiteAnimeAvecCri uneEntiteAnimee = (EntiteAnimeAvecCri) unIterator.next();
      if (uneEntiteAnimee.touche(e.getX(), e.getY())) {
        uneEntiteAnimee.setVisible(false);
        uneEntiteAnimee.crier();
      }
    }
  }
}
