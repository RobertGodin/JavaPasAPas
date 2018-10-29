
import java.awt.*;
import javax.swing.*;
public class CoqVolant extends Entit�Anim�e {

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
        if (imagesAnimation[�tatCourant].getImageLoadStatus()==MediaTracker.COMPLETE){
            //        imagesAnimation[�tatCourant].paintIcon(contenant,g,x,y);
                    g.drawImage(imagesAnimation[�tatCourant].getImage(),x,y,largeur,hauteur,contenant);
        }
    }
}