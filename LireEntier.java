/* Lecture dans le fichier d'un entier à l'aide d'un DataInputStream */
import java.io.*;
public class LireEntier{
    public static void main (String args[]) {
        DataInputStream unFichier;
        try{
            unFichier = 
                new DataInputStream(
                    new FileInputStream("UnEntier.dat"));
            int unEntier = unFichier.readInt();
            unFichier.close();
            System.out.println("Valeur d�cimale de l'entier : "+unEntier);
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}