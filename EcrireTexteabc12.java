/* Cr�ation d'un PrintWriter � partir d'un fichier et �criture de texte avec println */

import java.io.*;
public class EcrireTexteabc12{
    public static void main (String args[]) {
        FileWriter unFichier;
        PrintWriter unPrintWriter;
        try{
            unFichier = new FileWriter("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Fichier1.txt");
            unPrintWriter = new PrintWriter(unFichier);
            unPrintWriter.println("abc");
            unPrintWriter.println(12);
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}