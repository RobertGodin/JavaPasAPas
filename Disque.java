// La classe Disque implémente la couche d'accès au disque par bloc (1) du MSGF.
// La couche d'accès au disque par bloc simule les services de bas niveau d'une unité de disque
// simple permettant la lecture et l'écriture d'un bloc à la fois.

package LivreJava;
import java.io.*;

public class Disque {
  RandomAccessFile file;
  public static final int tailleBloc = 10;
  public static final int nbBloc = 10;

  public Disque() {
  // Le constructeur ouvre le fichier disque.dat qui sert à simuler le disque. Dans le cas
  // où il n'existe pas, le fichier est créé et initialisé.
    File leFile = new File("disque.dat");
    if (leFile.exists()){// Fichier existe ?
      try {
        file = new RandomAccessFile("disque.dat","rw");
      }
      catch (IOException e){
        System.err.println("Erreur d'ouverture de disque.dat\n" + e.toString());
      }
    }
    else {//Le fichier n'existe pas et il faut l'initialiser.
      try {
        file = new RandomAccessFile("disque.dat","rw");
      }
      catch (IOException e){
        System.out.println("Erreur d'ouverture de disque.dat\n" + e.toString());
      }
      byte tableauDeZero[] = new byte[tailleBloc];
      for (int i=0; i<tailleBloc; i++){
        tableauDeZero[i] = 0;
      }
      // Pour éviter une exception lors de la lecture d'un bloc dont le noBloc est
      //dans l'intervalle [0..nbBloc-1], il faut écrire le bloc à l'adresse nbBloc-1.
      //Ceci alloue l'espace jusqu'au bloc nbBloc-1. Ceci permet d'éviter d'avoir une
      // exception lorsqu'une lecture est tentée pour un bloc non écrit.
      // Pour simplifier le débogage, nous initialisons tous les blocs avec des '0' mais
      // ceci n'est pas nécessaire. Il suffit d'effectuer l'écriture du bloc nbBloc-1.
      // N.B. ADA alloue aussi l'espace de cette manière pour les fichiers à
      // accès direct (Package Direct_IO).
      for (int i=0; i<nbBloc; i++){
        this.écrireBloc(i,tableauDeZero);
      }
    }
  }

   public void fermer() {
    try {
      file.close();
    }
    catch (IOException e){
      System.out.println("Erreur de fermeture de disque.dat\n" + e.toString());
    }
  }

  public void lireBloc(int noBloc, byte tamponApplication[])
  // La fonction lireBloc lit le contenu du bloc dont le numéro est noBloc dans
  // tamponApplication. Pour les besoins du travail, on suppose que chaque bloc
  //a une taille déterminée par une constante globale tailleBloc et, par conséquent,
  // tamponApplication a la même taille. Le paramètre noBloc devra se situer dans
  // l'intervalle [0..nbBloc-1] où nbBloc est une constante globale.

  //Exceptions à prévoir :
  //1: le paramètre noBloc est à l'extérieur de l'intervalle [0..nbBloc-1]
  //2: autre exception

  throws NoBlocIllegalException, IOException{
    if (noBloc <0 || noBloc >= nbBloc) {
      throw new NoBlocIllegalException(noBloc);
    }
    file.seek(noBloc* tailleBloc);
    file.readFully(tamponApplication);
  }

  public void écrireBloc(int noBloc, byte tamponApplication[]){
  //La fonction écrireBloc écrit le contenu de tamponApplication dans le bloc
  //dont le numéro est noBloc.

  //Exceptions à prévoir :
  //1: le paramètre noBloc est à l'extérieur de l'intervalle [0..nbBloc-1]
  //2: autre exception

    if (noBloc <0 || noBloc >= nbBloc) {
      System.out.println("Erreur : ecrireBloc dans Disque, noBloc illégal");
    }
    try {
      file.seek(noBloc* tailleBloc);
      file.write(tamponApplication);
    }
    catch (IOException e){
      System.out.println("Erreur de lecture dans lireBloc\n" + e.toString());
    }
  }
}
