package JeuSimple;

import java.net.URL;
import javax.sound.sampled.*;

public abstract class EntiteAnimeAvecCri extends EntiteAnime {
  protected Clip unCri; // Cri de l'entité

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
    try {
      // Charge le clip audio à partir de l'URL
      unCri = AudioSystem.getClip();
      unCri.open(AudioSystem.getAudioInputStream(url));
    } catch (Exception e) {
      // Sans dispositif audio, le jeu fonctionne en silence
      System.err.println("Son non disponible : " + e);
      unCri = null;
    }
  }

  public void crier() {
    if (unCri != null) {
      unCri.setFramePosition(0); // Revient au début du clip
      unCri.start();
    }
  }
}
