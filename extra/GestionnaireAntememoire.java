import java.io.*;

public class GestionnaireAntememoire {
  // Le gestionnaire d'antémémoire réalise les mêmes Opérations de lecture et
  // d'écriture de bloc que la couche précédente (classe Disque) en utilisant une antémémoire
  // disque pour améliorer la performance des entrées/sorties.
  // La stratégie de remplacement utilisée est : moins fréquemment utilisé (LFU).

  static final int nbTampon = 3;
  Disque leDisque;
  // Réalisation d'un répertoire simple à l'aide d'un tableau noBloc
  // qui contient le noBloc du bloc dans le tampon
  int noBlocDansTampon[];
  boolean sale[];
  int fréquence[];
  byte tampon[][];

  public GestionnaireAntememoire() {
    // Constructeur qui initilise les structures de données de l'antémémoire
    leDisque = new Disque();
    noBlocDansTampon = new int[nbTampon];
    sale = new boolean[nbTampon];
    tampon = new byte[nbTampon][Disque.tailleBloc];
    fréquence = new int[nbTampon];
    for (int i = 0; i < nbTampon; i++) {
      noBlocDansTampon[i] = -1;
    }
  }

  public void fermerAntememoire() {
    // La fonction fermerAntémémoire doit évacuer les tampons sales. Cette opération doit être
    //  appelée à la fin du programme pour assurer que les blocs modifiés sont propagés sur disque.
    for (int i = 0; i < nbTampon; i++) this.évacuerTampon(i);
    leDisque.fermer();
  }

  public void lireBlocAntememoire(int noBloc, byte tamponApplication[])
      // La fonction lireBlocAntémémoire lit le contenu du bloc dont le numéro est
      // noBloc dans tamponApplication.

      // Exceptions à prévoir :
      // 1: le paramètre noBloc est à l'extérieur de l'intervalle [0..nbBloc-1]
      // 2: autre exception

      throws IOException, NoBlocIllegalException {
    if (noBloc < 0 || noBloc >= Disque.nbBloc) {
      throw new NoBlocIllegalException(noBloc);
    }
    // Chercher numéroBloc dans le répertoire (simple fouille séquentielle)
    int positionAntememoire;
    for (positionAntememoire = 0; positionAntememoire < nbTampon; positionAntememoire++) {
      if (noBloc == noBlocDansTampon[positionAntememoire]) {
        break;
      }
    }
    if (positionAntememoire < nbTampon) { // SI présent
      // transférer le tampon de l'anté-mémoire dans tamponApplication
      for (int i = 0; i < Disque.tailleBloc; i++) {
        tamponApplication[i] = tampon[positionAntememoire][i];
      }
      ++fréquence[positionAntememoire];
    } else {
      int indiceLibre;
      for (indiceLibre = 0; indiceLibre < nbTampon; indiceLibre++) {
        if (noBlocDansTampon[indiceLibre] == -1) {
          break;
        }
      }
      if (indiceLibre < nbTampon) { // SI il y a un tampon libre dans l'anté-mémoire
        // transférer le bloc noBloc dans le tampon libre
        leDisque.lireBloc(noBloc, tampon[indiceLibre]);
        // mettre à jour le répertoire d'anté-mémoire
        noBlocDansTampon[indiceLibre] = noBloc;
        sale[indiceLibre] = false;
        fréquence[indiceLibre] = 0;
        for (int i = 0; i < Disque.tailleBloc; i++) {
          tamponApplication[i] = tampon[indiceLibre][i];
        }
      } else {
        // sélectionner le tamponVictime à évacuer selon LFU
        int indiceVictime = 1;
        int fréquenceMinimum = fréquence[1];
        for (int i = 0; i < nbTampon; i++) {
          if (fréquence[i] < fréquenceMinimum) {
            fréquenceMinimum = fréquence[i];
            indiceVictime = i;
          }
        }
        this.évacuerTampon(indiceVictime);
        leDisque.lireBloc(noBloc, tampon[indiceVictime]);
        // mettre à jour le répertoire d'anté-mémoire
        noBlocDansTampon[indiceVictime] = noBloc;
        sale[indiceVictime] = false;
        fréquence[indiceVictime] = 0;
        for (int i = 0; i < Disque.tailleBloc; i++) {
          tamponApplication[i] = tampon[indiceVictime][i];
        }
      }
    }
  }

  public void écrireBlocAntememoire(int noBloc, byte tamponApplication[])
      throws NoBlocIllegalException {
    // La fonction écrireBlocAntémémoire écrit le contenu de tamponApplication dans le bloc dont le
    // numéro est noBloc.

    if (noBloc < 0 || noBloc >= Disque.nbBloc) {
      throw new NoBlocIllegalException(noBloc);
    }
    // Chercher noBloc dans le répertoire (simple fouille séquentielle)
    int positionAntememoire;
    for (positionAntememoire = 0; positionAntememoire < nbTampon; positionAntememoire++) {
      if (noBloc == noBlocDansTampon[positionAntememoire]) {
        break;
      }
    }
    if (positionAntememoire < nbTampon) { // SI présent
      // transférer tamponApplication dans le tampon de l'Antememoire
      for (int i = 0; i < Disque.tailleBloc; i++) {
        tampon[positionAntememoire][i] = tamponApplication[i];
      }
      sale[positionAntememoire] = true;
      ++fréquence[positionAntememoire];
    } else {
      int indiceLibre;
      for (indiceLibre = 0; indiceLibre < nbTampon; indiceLibre++) {
        if (noBlocDansTampon[indiceLibre] == -1) {
          break;
        }
      }
      if (indiceLibre < nbTampon) { // SI il y a un tampon libre dans l'anté-mémoire
        // transférer tamponApplication dans le tampon libre
        for (int i = 0; i < Disque.tailleBloc; i++) {
          tampon[indiceLibre][i] = tamponApplication[i];
        }
        sale[indiceLibre] = true;
        // mettre à jour le répertoire d'anté-mémoire
        noBlocDansTampon[indiceLibre] = noBloc;
        fréquence[indiceLibre] = 0;
      } else {
        // sélectionner le tamponVictime à évacuer selon LFU
        int indiceVictime = 1;
        int fréquenceMinimum = fréquence[1];
        for (int i = 0; i < nbTampon; i++) {
          if (fréquence[i] < fréquenceMinimum) {
            fréquenceMinimum = fréquence[i];
            indiceVictime = i;
          }
        }
        this.évacuerTampon(indiceVictime);
        for (int i = 0; i < Disque.tailleBloc; i++) {
          tampon[indiceVictime][i] = tamponApplication[i];
        }
        // mettre à jour le répertoire d'anté-mémoire
        noBlocDansTampon[indiceVictime] = noBloc;
        sale[indiceVictime] = true;
        fréquence[indiceVictime] = 0;
      }
    }
  }

  public void évacuerTampon(int indiceTampon) {
    // La fonction évacuerTampon force l'évacuation du tampon noTampon.

    // Exceptions à prévoir :
    // 1: le noTampon n'est pas dans l'intervalle [0..nbTampon-1]
    // 2: autre exception

    if (sale[indiceTampon]) {
      leDisque.écrireBloc(noBlocDansTampon[indiceTampon], tampon[indiceTampon]);
      sale[indiceTampon] = false;
    }
  }

  public void afficherDisque() {
    // Pour les essais
    byte tamponApplication[] = new byte[Disque.tailleBloc];
    String contenuString;
    System.out.println("Contenu du disque:");
    for (int i = 0; i < Disque.nbBloc; i++) {
      try {
        leDisque.lireBloc(i, tamponApplication);
      } catch (Exception e) {
        System.out.println("Erreur de lecture dans Disque.lireBloc\n" + e.toString());
      }
      contenuString = new String(tamponApplication, 0);
      System.out.print("|" + contenuString);
    }
    System.out.println("");
    System.out.println("Contenu antememoire:");
    for (int i = 0; i < nbTampon; i++) {
      contenuString = new String(tampon[i], 0);
      System.out.println(
          i + ":" + contenuString + "|" + noBlocDansTampon[i] + "|" + fréquence[i] + "|" + sale[i]);
    }
  }
}
