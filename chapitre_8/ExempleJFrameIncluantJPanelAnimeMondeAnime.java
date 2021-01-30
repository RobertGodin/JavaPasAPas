// JFrame qui inclue le JPanelAnimeMondeAnime
import javax.swing.JFrame;

public class ExempleJFrameIncluantJPanelAnimeMondeAnime extends JFrame {

  public ExempleJFrameIncluantJPanelAnimeMondeAnime() {
    super("Animation dans JPanel avec Timer");
    JPanelAvecTimerAnimeMondeAnime leJPanelAnimation = new JPanelAvecTimerAnimeMondeAnime();
    this.getContentPane().add(leJPanelAnimation);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(
        JPanelAvecTimerAnimeMondeAnime.LARGEURJPANEL,
        JPanelAvecTimerAnimeMondeAnime.HAUTEURJPANEL + 30);
    this.setVisible(true);
    leJPanelAnimation.start();
  }

  public static void main(String args[]) {
    new ExempleJFrameIncluantJPanelAnimeMondeAnime();
  }
}
