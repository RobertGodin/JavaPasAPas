/* Lire un fichier et en compter le nombre d'octets */

import java.io.*;
public class CompterOctetsFichier{
    public static void main (String args[]) {
        int unOctet;
        int compteurOctet;
        FileInputStream unFichier; 
        try{
            unFichier = new FileInputStream("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Fichier1.txt");
            compteurOctet = 0;
            while((unOctet = unFichier.read()) != -1)
                compteurOctet++;
            unFichier.close();
            System.out.println("Nombre d'octets du fichier Fichier1.txt : "+compteurOctet);
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}