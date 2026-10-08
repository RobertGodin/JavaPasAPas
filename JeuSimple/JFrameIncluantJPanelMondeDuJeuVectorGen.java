package JeuSimple;

import javax.swing.JFrame;

public class JFrameIncluantJPanelMondeDuJeuVectorGen extends JFrame {

  public JFrameIncluantJPanelMondeDuJeuVectorGen() {
    super("Les envahisseurs");
    JPanelPourMondeDuJeuVectorGen leJPanelAnimation =
        new JPanelPourMondeDuJeuVectorGen();
    this.getContentPane().add(leJPanelAnimation);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(
        JPanelPourMondeDuJeuVectorGen.LARGEURJPANEL,
        JPanelPourMondeDuJeuVectorGen.HAUTEURJPANEL + 30);
    this.setVisible(true);
    leJPanelAnimation.start();
  }

  public static void main(String[] args) {
    new JFrameIncluantJPanelMondeDuJeuVectorGen();
  }
}
