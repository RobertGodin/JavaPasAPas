/* Lit un fichier octet par octet et copie les octets lus sur System.out */

import java.io.*;
public class CopieFichierSurOut{
    public static void main (String args[]) {
        int unOctet;
        FileInputStream unFichier; 
        try{
            unFichier = new FileInputStream("C:/forte4j/Development/LivreJava/Fichier1.txt");
            while((unOctet = unFichier.read()) != -1)
                //System.out.writeByte((byte)unOctet);
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}