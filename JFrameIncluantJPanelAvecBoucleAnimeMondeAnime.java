import javax.swing.JFrame;
public class JFrameIncluantJPanelAvecBoucleAnimeMondeAnime extends JFrame{

    public JFrameIncluantJPanelAvecBoucleAnimeMondeAnime() {
        super("Animation dans JPanel avec boucle");
        JPanelAvecBoucleAnimeMondeAnime leJPanelAnimation =  
            new JPanelAvecBoucleAnimeMondeAnime();
        this.getContentPane().add(leJPanelAnimation);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(
          JPanelAvecBoucleAnimeMondeAnime.LARGEURJPANEL,
          JPanelAvecBoucleAnimeMondeAnime.HAUTEURJPANEL+30);
        this.setVisible(true);
        leJPanelAnimation.start();
    }

    public static void main (String args[]) {
        new JFrameIncluantJPanelAvecBoucleAnimeMondeAnime();
    }
}