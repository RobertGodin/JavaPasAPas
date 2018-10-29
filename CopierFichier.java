/* Copier un fichier octet par octet */

import java.io.*;
public class CopierFichier{
    public static void main (String args[]) {
        int unOctet;
        FileInputStream unFileInputStream;
        FileOutputStream unFileOutputStream;
        try{
            unFileInputStream = new FileInputStream("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Fichier1.txt");
            unFileOutputStream = new FileOutputStream("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Fichier2.txt");
            while((unOctet = unFileInputStream.read()) != -1)
                unFileOutputStream.write(unOctet);
            unFileInputStream.close();
            unFileOutputStream.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}