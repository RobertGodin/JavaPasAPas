// Monde à animer
import java.awt.*;

public class MondeAnime {
  // Taille du monde
  public static int LARGEURMONDE = 400;
  public static int HAUTEURMONDE = 400;
  // Entités du monde à animer
  private CrabeSCEntiteRebondissante crabe1 =
      new CrabeSCEntiteRebondissante(0, 100, 120, 80, 5, 0);
  private CrabeSCEntiteRebondissante crabe2 =
      new CrabeSCEntiteRebondissante(100, 100, 75, 50, -10, 5);
  private SoucoupeSCEntiteRebondissante soucoupe1 =
      new SoucoupeSCEntiteRebondissante(200, 300, 100, 44, 6, 6);
  private SoucoupeSCEntiteRebondissante soucoupe2 =
      new SoucoupeSCEntiteRebondissante(200, 0, 64, 28, 0, 10);

  public MondeAnime() {
    // Initialise les entités à animer pour la première scène
    crabe1 = new CrabeSCEntiteRebondissante(0, 100, 120, 80, 5, 0);
    crabe2 = new CrabeSCEntiteRebondissante(100, 100, 75, 50, -10, 5);
    soucoupe1 = new SoucoupeSCEntiteRebondissante(200, 300, 100, 44, 6, 6);
    soucoupe2 = new SoucoupeSCEntiteRebondissante(200, 0, 64, 28, 0, 10);
  }

  public void prochaineScene() {
    // Modifie les entités à animer pour la prochaine scène
    crabe1.deplacer(LARGEURMONDE, HAUTEURMONDE);
    crabe2.deplacer(LARGEURMONDE, HAUTEURMONDE);
    soucoupe1.deplacer(LARGEURMONDE, HAUTEURMONDE);
    soucoupe2.deplacer(LARGEURMONDE, HAUTEURMONDE);
  }

  public void paint(Graphics g) {
    // Dessine la scène
    crabe1.paint(g);
    crabe2.paint(g);
    soucoupe1.paint(g);
    soucoupe2.paint(g);
  }
}
