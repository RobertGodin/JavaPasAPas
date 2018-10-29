/* Lecture dans le fichier d'un entier sous forme de texte � l'aide d'un FileReader */

import java.io.*;
public class LireEntierTexte{
    public static void main (String args[]) {
        FileReader unFichier;
        try{
            char[] tableauChar = new char[10];
            unFichier = new FileReader("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/UnEntier.txt");
            unFichier.read(tableauChar,0,10);
            int unEntier = Integer.parseInt(new String(tableauChar,0,10));
            unFichier.close();
            System.out.println("Valeur d�cimale de l'entier : "+unEntier);
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}