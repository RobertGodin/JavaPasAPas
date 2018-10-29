/*
 * ComposanteAnimation.java
 * 
 * Created on 1 juillet 2001, 21:52
 */
import java.awt.*;
import java.awt.event.*;
public class ComposanteAnimation {
    protected BonhommeQuiBouge unBonhomme;
    public ComposanteAnimation() {
        unBonhomme = new BonhommeQuiBouge(100,50,100,200,3,3);
    }
    public void changerMonde(){
        unBonhomme.deplacer();
    }
    public void paint(Graphics g){
        unBonhomme.paint(g);
    }
    public void mousePressed(MouseEvent e){
        unBonhomme.setX(e.getX());
        unBonhomme.setY(e.getY());        
    }
}