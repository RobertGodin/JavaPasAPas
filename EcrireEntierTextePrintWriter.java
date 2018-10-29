/* Cr�ation d'un PrintWriter � partir d'un fichier et �criture d'un entier dans le fichier 
sous forme d'une cha�ne de caract�res */

import java.io.*;
public class EcrireEntierTextePrintWriter{
    public static void main (String args[]) {
        FileWriter unFichier;
        PrintWriter unPrintWriter;
        try{
            unFichier = new FileWriter("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/UnEntierPW.txt");
            unPrintWriter = new PrintWriter(unFichier);
            unPrintWriter.print(1629696561);
            System.out.println(unFichier.getEncoding());
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}