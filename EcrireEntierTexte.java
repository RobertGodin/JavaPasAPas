/* Cr�ation d'un FileWriter à partir d'un fichier et �criture d'un entier dans le fichier 
sous forme d'une cha�ne de caractères */
import java.io.*;
public class EcrireEntierTexte{
    public static void main (String args[]) {
        FileWriter unFichier;
        try{
            unFichier = 
                new FileWriter("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/UnEntier.txt");
            unFichier.write("1629696561");
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}