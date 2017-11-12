/*
 * ComposanteAnimation2.java
 * Plusieurs bonhommes dans un Vector
 * Le Iti vole (changement du dessin à chaque état)
 * Ajoute un coq (animation par séquence d'images)
 * Created on 1 juillet 2001, 21:52
 */
package LivreJava;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
public class ComposanteAnimation2 {
    protected Vector vecteurEntités;
    protected ImageIcon imagesCoq[];
    protected Component contenant;
    
    public ComposanteAnimation2(Component contenant) {
        this.contenant = contenant;
        
        vecteurEntités = new Vector();
        vecteurEntités.addElement(new KenyAnimé(100,50,100,200,3,3,true,"Son1.wav",1));
        vecteurEntités.addElement(new BotAnimé(10,100,20,40,3,3,true,"Son2.wav",1));
        vecteurEntités.addElement(new ItiVolant(200,50,100,200,3,0,true,"Son3.wav",3));
        
        // Charger les images du coq
        imagesCoq = new ImageIcon[8];
        for (int i = 0; i < 8; i++){
            URL url = getClass().getResource("coq/coqt"+(i+1)+".gif");
            imagesCoq[i] = new ImageIcon(url);
        }
        
        vecteurEntités.addElement(new CoqVolant(50,50,100,100,5,5,true,"Son4.wav",8,contenant,imagesCoq));
    }
    public void changerMonde(){
        for(Iterator unIterator = vecteurEntités.iterator(); unIterator.hasNext();){
            ((EntitéAnimée)unIterator.next()).changer();
        }
    }
    public void paint(Graphics g){
        for(Iterator unIterator = vecteurEntités.iterator(); unIterator.hasNext();){
            ((EntitéAnimée)unIterator.next()).paintSiVisible(g);
        }
    }
    public void mousePressed(MouseEvent e){
        for(Iterator unIterator = vecteurEntités.iterator(); unIterator.hasNext();){
            EntitéAnimée uneEntitéAnimée = (EntitéAnimée)unIterator.next();
            if (uneEntitéAnimée.touche(e.getX(),e.getY())) {
                uneEntitéAnimée.setVisible(false);
                uneEntitéAnimée.crier();
            }
        }
    }
}