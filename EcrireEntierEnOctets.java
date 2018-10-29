/* Creation d'un fichier et �criture d'un entier sous forme d'une suite d'octets dans le fichier */
import java.io.*;
public class EcrireEntierEnOctets{
    public static void main (String args[]) {
        FileOutputStream unFichier;
        try{
            unFichier = new FileOutputStream("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Octets.dat");
            
            int unEntier = 1629696561;//(97*2^24)+(35*2^16)+(50<<2^8)+49 = "a#21" en String;
            // Convertir unEntier en un tableau de 4 octets
            byte[] tampon = new byte[4];
            for (int i = 3; i>=0;i--){
                tampon[i] = (byte)(unEntier & 0XFF); //Extrait l'octet le moins significatif
                unEntier >>>=8; //D�calage de 8 bits (remplissage � 0)
            }
            unFichier.write(tampon);
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}