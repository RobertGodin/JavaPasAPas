/* Cr�ation d'un fichier et �criture d'un suite d'octets dans le fichier */
import java.io.*;
public class EcrireTexteFichier{
    public static void main (String args[]) {
        FileOutputStream unFichier; 
        try{
            unFichier = new FileOutputStream("C:/forte4j/Development/LivreJava/Texte.txt");
            
            unFichier.write('a');
            unFichier.write('b');
            unFichier.write('c');
            unFichier.write('\r');
            unFichier.write('\n');
            unFichier.write('1');
            unFichier.write('2');
            unFichier.write('\r');
            unFichier.write('\n');
           
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
    }
}