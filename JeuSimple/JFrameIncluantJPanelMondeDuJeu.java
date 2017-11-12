package JeuSimple;
import javax.swing.JFrame;
public class JFrameIncluantJPanelMondeDuJeu extends JFrame{

    public JFrameIncluantJPanelMondeDuJeu() {
        super("Jeu simple");
        JPanelPourMondeJeuSimple leJPanelAnimation =  
            new JPanelPourMondeJeuSimple();
        this.getContentPane().add(leJPanelAnimation);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(
          JPanelPourMondeJeuSimple.LARGEURJPANEL,
          JPanelPourMondeJeuSimple.HAUTEURJPANEL+30);
        this.setVisible(true);
        leJPanelAnimation.start();
    }

    public static void main (String args[]) {
        new JFrameIncluantJPanelMondeDuJeu();
    }
}