/*
 * ComposanteAnimation2.java
 * Plusieurs bonhommes dans un Vector
 * Le Iti vole (changement du dessin à chaque �tat)
 * Ajoute un coq (animation par s�quence d'images)
 * Created on 1 juillet 2001, 21:52
 */

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
public class ComposanteAnimation2 {
    protected Vector vecteurEntit�s;
    protected ImageIcon imagesCoq[];
    protected Component contenant;
    
    public ComposanteAnimation2(Component contenant) {
        this.contenant = contenant;
        
        vecteurEntit�s = new Vector();
        vecteurEntit�s.addElement(new KenyAnim�(100,50,100,200,3,3,true,"Son1.wav",1));
        vecteurEntit�s.addElement(new BotAnim�(10,100,20,40,3,3,true,"Son2.wav",1));
        vecteurEntit�s.addElement(new ItiVolant(200,50,100,200,3,0,true,"Son3.wav",3));
        
        // Charger les images du coq
        imagesCoq = new ImageIcon[8];
        for (int i = 0; i < 8; i++){
            URL url = getClass().getResource("coq/coqt"+(i+1)+".gif");
            imagesCoq[i] = new ImageIcon(url);
        }
        
        vecteurEntit�s.addElement(new CoqVolant(50,50,100,100,5,5,true,"Son4.wav",8,contenant,imagesCoq));
    }
    public void changerMonde(){
        for(Iterator unIterator = vecteurEntit�s.iterator(); unIterator.hasNext();){
            ((Entit�Anim�e)unIterator.next()).changer();
        }
    }
    public void paint(Graphics g){
        for(Iterator unIterator = vecteurEntit�s.iterator(); unIterator.hasNext();){
            ((Entit�Anim�e)unIterator.next()).paintSiVisible(g);
        }
    }
    public void mousePressed(MouseEvent e){
        for(Iterator unIterator = vecteurEntit�s.iterator(); unIterator.hasNext();){
            Entit�Anim�e uneEntit�Anim�e = (Entit�Anim�e)unIterator.next();
            if (uneEntit�Anim�e.touche(e.getX(),e.getY())) {
                uneEntit�Anim�e.setVisible(false);
                uneEntit�Anim�e.crier();
            }
        }
    }
}