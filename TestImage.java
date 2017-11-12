package LivreJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestImage extends JApplet {

        public ImageIcon imageIcon;
        public Image image;

    /** Constructeur de ExempleDessinJFrame */
    public void init() {
        
        image = getImage(getDocumentBase(),"coq/coq1.gif");
//        imageIcon = new ImageIcon("coq/coq1.gif");
    }
    // paint() est appelée indirectement lors de la création du JFrame par show()
    public void paint (Graphics g) {
        
        g.setColor(new Color(255,100,0));
        g.fillOval(10,20,10,20);
        g.drawImage(image,0,30,100,100,this);
//        imageIcon.paintIcon(this,g,200,0);
    }
}