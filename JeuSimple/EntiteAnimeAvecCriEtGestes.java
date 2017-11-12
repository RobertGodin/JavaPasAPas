package JeuSimple;
public abstract class EntiteAnimeAvecCriEtGestes extends EntiteAnimeAvecCri
{
  protected int etatCourant = 0;
  protected int nombreEtats = 1;
  
  public EntiteAnimeAvecCriEtGestes(
      int x, int y, int largeur, int hauteur,
      int vitesseX,int vitesseY, boolean visible, String nomFichierAudio,
      int nombreEtats) {
        super(x,y,largeur,hauteur,vitesseX,vitesseY,visible,nomFichierAudio);
      this.nombreEtats = nombreEtats;
  }
  public void prochaineScene(int largeurFenetre, int hauteurFenetre){
    super.prochaineScene(largeurFenetre,hauteurFenetre);
    etatCourant = (etatCourant + 1)%nombreEtats;
  }
}