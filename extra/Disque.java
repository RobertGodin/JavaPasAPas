// La classe Disque implémente la couche d'accès au disque par bloc (1) du MSGF.
// La couche d'accès au disque par bloc simule les services de bas niveau d'une unité de disque
// simple permettant la lecture et l'écriture d'un bloc à la fois.

import java.io.*;

public class Disque {
  RandomAccessFile file;
  public static final int tailleBloc = 10;
  public static final int nbBloc = 10;

  public Disque() {
    // Le constructeur ouvre le fichier disque.dat qui sert � simuler le disque. Dans le cas
    // o� il n'existe pas, le fichier est cr�� et initialis�.
    File leFile = new File("disque.dat");
    if (leFile.exists()) { // Fichier existe ?
      try {
        file = new RandomAccessFile("disque.dat", "rw");
      } catch (IOException e) {
        System.err.println("Erreur d'ouverture de disque.dat\n" + e.toString());
      }
    } else { // Le fichier n'existe pas et il faut l'initialiser.
      try {
        file = new RandomAccessFile("disque.dat", "rw");
      } catch (IOException e) {
        System.out.println("Erreur d'ouverture de disque.dat\n" + e.toString());
      }
      byte tableauDeZero[] = new byte[tailleBloc];
      for (int i = 0; i < tailleBloc; i++) {
        tableauDeZero[i] = 0;
      }
      // Pour éviter une exception lors de la lecture d'un bloc dont le noBloc est
      // dans l'intervalle [0..nbBloc-1], il faut écrire le bloc � l'adresse nbBloc-1.
      // Ceci alloue l'espace jusqu'au bloc nbBloc-1. Ceci permet d'�viter d'avoir une
      // exception lorsqu'une lecture est tentée pour un bloc non �crit.
      // Pour simplifier le débogage, nous initialisons tous les blocs avec des '0' mais
      // ceci n'est pas nécessaire. Il suffit d'effectuer l'écriture du bloc nbBloc-1.
      // N.B. ADA alloue aussi l'espace de cette manière pour les fichiers �
      // accès direct (Package Direct_IO).
      for (int i = 0; i < nbBloc; i++) {
        this.écrireBloc(i, tableauDeZero);
      }
    }
  }

  public void fermer() {
    try {
      file.close();
    } catch (IOException e) {
      System.out.println("Erreur de fermeture de disque.dat\n" + e.toString());
    }
  }

  public void lireBloc(int noBloc, byte tamponApplication[])
      // La fonction lireBloc lit le contenu du bloc dont le num�ro est noBloc dans
      // tamponApplication. Pour les besoins du travail, on suppose que chaque bloc
      // a une taille d�termin�e par une constante globale tailleBloc et, par cons�quent,
      // tamponApplication a la m�me taille. Le param�tre noBloc devra se situer dans
      // l'intervalle [0..nbBloc-1] o� nbBloc est une constante globale.

      // Exceptions � pr�voir :
      // 1: le param�tre noBloc est � l'ext�rieur de l'intervalle [0..nbBloc-1]
      // 2: autre exception

      throws NoBlocIllegalException, IOException {
    if (noBloc < 0 || noBloc >= nbBloc) {
      throw new NoBlocIllegalException(noBloc);
    }
    file.seek(noBloc * tailleBloc);
    file.readFully(tamponApplication);
  }

  public void écrireBloc(int noBloc, byte tamponApplication[]) {
    // La fonction écrireBloc �crit le contenu de tamponApplication dans le bloc
    // dont le num�ro est noBloc.

    // Exceptions � pr�voir :
    // 1: le param�tre noBloc est � l'ext�rieur de l'intervalle [0..nbBloc-1]
    // 2: autre exception

    if (noBloc < 0 || noBloc >= nbBloc) {
      System.out.println("Erreur : ecrireBloc dans Disque, noBloc ill�gal");
    }
    try {
      file.seek(noBloc * tailleBloc);
      file.write(tamponApplication);
    } catch (IOException e) {
      System.out.println("Erreur de lecture dans lireBloc\n" + e.toString());
    }
  }
}
