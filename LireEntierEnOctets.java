/* Lecture dans le fichier d'un entier sous forme d'une suite d'octets et conversion en int */

import java.io.*;
public class LireEntierEnOctets{
    public static void main (String args[]) {
        FileInputStream unFichier;
        try{
            unFichier = new FileInputStream("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Octets.dat");
          
            byte[] tampon = new byte[4];
            unFichier.read(tampon); //Lecture des 4 octets
            
            // Convertir le tableau d'octets tampon en int unEntier
            int unEntier=0;
            for (int i = 0; i<=3;i++){
                unEntier <<=8;
                unEntier +=((int) tampon[i])&0XFF;
            }
            unFichier.close();
            System.out.println("Valeur d�cimale de l'entier : "+unEntier);
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}