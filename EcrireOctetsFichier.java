/* création d'un fichier et �criture d'un suite d'octets dans le fichier */
import java.io.*;
public class EcrireOctetsFichier{
    public static void main (String args[]) {
        FileOutputStream unFichier; 
        try{
            unFichier = new FileOutputStream("Fichier1.txt");
            
            unFichier.write(0X61);
            unFichier.write(0X62);
            unFichier.write(0X63);
            unFichier.write(0X0D);
            unFichier.write(0X0A);
            unFichier.write(0X31);
            unFichier.write(0X32);
            unFichier.write(0X0D);
            unFichier.write(0X0A);
           
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}