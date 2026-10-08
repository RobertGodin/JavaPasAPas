package JeuSimple;
/*
 * MondeDuJeuVectorGen.java
 * Les envahisseurs dans un Vector<EntiteAnimeAvecCri>
 * Les projectiles dans un Vector<Projectile>
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MondeDuJeuVectorGen {

  // Taille du monde
  public static final int LARGEURMONDE = 800;
  public static final int HAUTEURMONDE = 600;
  // Descente de la formation lorsqu'elle atteint un bord
  public static final int DESCENTE = 20;

  protected Vector<EntiteAnimeAvecCri> vecteurEntites; // Les envahisseurs
  protected Vector<Projectile> vecteurProjectiles; // Tirs et bombes
  protected SoucoupeAnimeAvecCri soucoupe;
  protected CanonAnimeAvecCri canon;
  protected Random hasard = new Random();
  protected int score = 0;
  protected boolean partieTerminee = false;

  public MondeDuJeuVectorGen() {
    vecteurEntites = new Vector<EntiteAnimeAvecCri>();
    for (int colonne = 0; colonne < 8; colonne++) {
      int x = 40 + colonne * 64;
      vecteurEntites.addElement(
          new EntiteAnimeAvecCriEtSequenceImages(
              x, 80, 48, 32, 3, 0, true, "explosion1.wav", 2, "calmar"));
      vecteurEntites.addElement(
          new CrabeAnimeAvecCri(x, 130, 48, 32, 3, 0, true,
              "explosion2.wav"));
      vecteurEntites.addElement(
          new EntiteAnimeAvecCriEtSequenceImages(
              x, 180, 48, 32, 3, 0, true, "explosion3.wav", 4, "pieuvre"));
    }
    vecteurProjectiles = new Vector<Projectile>();
    soucoupe = new SoucoupeAnimeAvecCri(0, 30, 64, 28, 5, 0, true,
        "soucoupe.wav");
    canon =
        new CanonAnimeAvecCri(370, 530, 60, 30, 0, 0, true, "canon.wav");
  }

  public void prochaineScene() {
    if (partieTerminee) {
      return; // Le monde ne bouge plus
    }
    // Si la formation atteint un bord, elle descend et change de direction
    if (formationAuBord()) {
      for (EntiteAnimeAvecCri uneEntite : vecteurEntites) {
        uneEntite.setVitesseX(-uneEntite.getVitesseX());
        uneEntite.setY(uneEntite.getY() + DESCENTE);
      }
    }
    for (EntiteAnimeAvecCri uneEntite : vecteurEntites) {
      uneEntite.prochaineScene(LARGEURMONDE, HAUTEURMONDE);
    }
    soucoupe.prochaineScene(LARGEURMONDE, HAUTEURMONDE);
    lancerBombe();
    // Un Iterator explicite est nécessaire pour retirer des éléments
    for (Iterator<Projectile> unIterator = vecteurProjectiles.iterator();
        unIterator.hasNext(); ) {
      Projectile unProjectile = unIterator.next();
      unProjectile.prochaineScene(LARGEURMONDE, HAUTEURMONDE);
      traiterCollisions(unProjectile);
      if (!unProjectile.getVisible()) {
        unIterator.remove();
      }
    }
    verifierFinDePartie();
  }

  // Vrai si un envahisseur visible va dépasser un bord du monde
  private boolean formationAuBord() {
    for (EntiteAnimeAvecCri uneEntite : vecteurEntites) {
      int prochainX = uneEntite.getX() + uneEntite.getVitesseX();
      if (uneEntite.getVisible()
          && (prochainX < 0
              || prochainX + uneEntite.getLargeur() >= LARGEURMONDE)) {
        return true;
      }
    }
    return false;
  }

  // De temps en temps, un envahisseur choisi au hasard lâche une bombe
  private void lancerBombe() {
    if (hasard.nextInt(20) == 0) {
      int indice = hasard.nextInt(vecteurEntites.size());
      EntiteAnimeAvecCri uneEntite = vecteurEntites.elementAt(indice);
      if (uneEntite.getVisible()) {
        vecteurProjectiles.addElement(
            new Projectile(
                uneEntite.getX() + uneEntite.getLargeur() / 2,
                uneEntite.getY() + uneEntite.getHauteur(),
                6,
                Color.yellow));
      }
    }
  }

  // Si le projectile touche l'entité, les deux disparaissent
  // et l'entité pousse un cri
  private boolean collision(
      EntiteAnimeAvecCri uneEntite, Projectile unProjectile) {
    if (uneEntite.getVisible()
        && unProjectile.getVisible()
        && uneEntite.touche(unProjectile.getX(), unProjectile.getY())) {
      uneEntite.setVisible(false);
      uneEntite.crier();
      unProjectile.setVisible(false);
      return true;
    }
    return false;
  }

  // Une bombe peut toucher le canon. Un tir du canon peut toucher la
  // soucoupe ou un envahisseur.
  private void traiterCollisions(Projectile unProjectile) {
    if (unProjectile.getVitesseY() > 0) { // Une bombe descend
      if (collision(canon, unProjectile)) {
        partieTerminee = true;
      }
    } else { // Un tir monte
      if (collision(soucoupe, unProjectile)) {
        score = score + 100;
      }
      for (EntiteAnimeAvecCri uneEntite : vecteurEntites) {
        if (collision(uneEntite, unProjectile)) {
          score = score + 10;
        }
      }
    }
  }

  // La partie est gagnée lorsqu'il ne reste plus d'envahisseurs et
  // perdue lorsqu'un envahisseur atteint le canon
  private void verifierFinDePartie() {
    boolean resteDesEnvahisseurs = false;
    for (EntiteAnimeAvecCri uneEntite : vecteurEntites) {
      if (uneEntite.getVisible()) {
        resteDesEnvahisseurs = true;
        if (uneEntite.getY() + uneEntite.getHauteur() >= canon.getY()) {
          canon.setVisible(false);
          canon.crier();
          partieTerminee = true;
        }
      }
    }
    if (!resteDesEnvahisseurs) {
      partieTerminee = true;
    }
  }

  public void paint(Graphics g) {
    for (EntiteAnimeAvecCri uneEntite : vecteurEntites) {
      uneEntite.paintSiVisible(g);
    }
    for (Projectile unProjectile : vecteurProjectiles) {
      unProjectile.paintSiVisible(g);
    }
    soucoupe.paintSiVisible(g);
    canon.paintSiVisible(g);
    // Le score et le message de fin de partie
    g.setColor(Color.white);
    g.setFont(new Font("SansSerif", Font.BOLD, 18));
    g.drawString("Score : " + score, 10, 20);
    if (partieTerminee) {
      g.setFont(new Font("SansSerif", Font.BOLD, 48));
      if (canon.getVisible()) {
        g.drawString("Victoire !", 280, 320);
      } else {
        g.drawString("Partie perdue", 240, 320);
      }
    }
  }

  // Le canon suit la souris
  public void mouseMoved(MouseEvent e) {
    canon.setX(e.getX() - canon.getLargeur() / 2);
  }

  // Un clic lance un tir à partir du canon
  public void mousePressed(MouseEvent e) {
    if (!partieTerminee) {
      vecteurProjectiles.addElement(
          new Projectile(
              canon.getX() + canon.getLargeur() / 2 - 2,
              canon.getY(),
              -12,
              Color.white));
    }
  }
}
