/* Lecture dans le fichier d'un entier � l'aide d'un DataInputStream */
package LivreJava;
import java.io.*;
public class LireEntier{
    public static void main (String args[]) {
        DataInputStream unFichier;
        try{
            unFichier = 
                new DataInputStream(
                    new FileInputStream("C:/forte4j/Development/LivreJava/UnEntier.dat"));
            int unEntier = unFichier.readInt();
            unFichier.close();
            System.out.println("Valeur d�cimale de l'entier : "+unEntier);
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}