package JeuSimple;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class JFrameIncluantJPanelMondeDuJeuVectorGen extends JFrame{

    public JFrameIncluantJPanelMondeDuJeuVectorGen() {
        super("Jeu simple");
        JPanelPourMondeDuJeuVectorGen leJPanelAnimation =  
            new JPanelPourMondeDuJeuVectorGen();
        this.getContentPane().add(leJPanelAnimation);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(
          JPanelPourMondeDuJeuVectorGen.LARGEURJPANEL,
          JPanelPourMondeDuJeuVectorGen.HAUTEURJPANEL+60);
        this.setVisible(true);
        leJPanelAnimation.start();
    }

    public static void main (String args[]) {
        new JFrameIncluantJPanelMondeDuJeuVectorGen();
    }
}
