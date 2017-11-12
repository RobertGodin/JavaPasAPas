package JeuSimple;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class EntiteAnimeAvecCriEtSequenceImages extends EntiteAnimeAvecCriEtGestes {

    protected Image imagesAnimation[];
    protected Component contenant;
    
    public EntiteAnimeAvecCriEtSequenceImages(
      int x, int y, int largeur, int hauteur, int vitesseX, int vitesseY,
      boolean visible, String fichierAudio, int nombreEtats, String nomDossier) {
        super(x,y,largeur,hauteur,vitesseX,vitesseY,visible,fichierAudio,nombreEtats);

        // Charge les images de l'animation
        // On suppose que les fichiers .gif se trouvent dans un dossier nommé nomDossier
        // dans le répertoire du code compilé et que les noms de fichiers gif sont
        // de la forme nomDossiern.gif, n = 1 .. nombreEtats
        this.imagesAnimation = new Image[nombreEtats];
        for (int i = 0; i < nombreEtats; i++){
            URL url = getClass().getResource(nomDossier+"/"+nomDossier+(i+1)+".gif");
            this.imagesAnimation[i] = new ImageIcon(url).getImage();
        }
    }

    public void paint (Graphics g) {
      g.drawImage(imagesAnimation[etatCourant],x,y,largeur,hauteur,null);
    }
}