package JeuSimple;

import java.applet.*;
import java.net.URL;

public abstract class EntiteAnimeAvecCri extends EntiteAnime {
  protected AudioClip unCri; // Cri de l'Entité

  public EntiteAnimeAvecCri(
      int x,
      int y,
      int largeur,
      int hauteur,
      int vitesseX,
      int vitesseY,
      boolean visible,
      String nomFichierAudio) {
    super(x, y, largeur, hauteur, vitesseX, vitesseY, visible);
    // Charge le son dans le fichier nomFichierAudio
    // Le fichier est dans le dossier de EntiteAnimeAvecCri.class
    // Cherche l'URL du fichier
    URL url = EntiteAnimeAvecCri.class.getResource(nomFichierAudio);
    // Charge le clip audio à partir de l'URL
    unCri = Applet.newAudioClip(url);
  }

  public void crier() {
    unCri.play();
  }
}
