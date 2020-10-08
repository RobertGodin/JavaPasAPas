
import java.awt.*;
import javax.swing.*;
public class CoqVolant extends EntitéAnimée {

    protected ImageIcon imagesAnimation[];
    protected MediaTracker unMediaTracker;
    protected Component contenant;
    public CoqVolant(int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY,
    boolean visible, String fichierAudio, int nombreEtats,
    Component contenant, ImageIcon imagesAnimation[]) {
        super(x,y,largeur,hauteur,vitesseX,vitesseY,visible,fichierAudio,8);
        this.contenant = contenant;
        this.imagesAnimation = imagesAnimation;

    }

    public void paint (Graphics g) {
        if (imagesAnimation[étatCourant].getImageLoadStatus()==MediaTracker.COMPLETE){
            //        imagesAnimation[étatCourant].paintIcon(contenant,g,x,y);
                    g.drawImage(imagesAnimation[étatCourant].getImage(),x,y,largeur,hauteur,contenant);
        }
    }
}