import javax.swing.JFrame;

public class ExempleJFrameIncluantJPanelAvecAnimationParTimer extends JFrame {

  public ExempleJFrameIncluantJPanelAvecAnimationParTimer() {
    super("Animation dans JPanel avec Timer");
    ExempleJPanelAvecAnimationParTimer leJPanelAnimation = new ExempleJPanelAvecAnimationParTimer();
    this.getContentPane().add(leJPanelAnimation);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(
        ExempleJPanelAvecAnimationParTimer.LARGEURJPANEL,
        ExempleJPanelAvecAnimationParTimer.HAUTEURJPANEL + 30);
    this.setVisible(true);
    leJPanelAnimation.start();
  }

  public static void main(String args[]) {
    new ExempleJFrameIncluantJPanelAvecAnimationParTimer();
  }
}
