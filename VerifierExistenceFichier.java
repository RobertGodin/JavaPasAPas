package LivreJava;
import java.io.*;
import javax.swing.JOptionPane;
public class VerifierExistenceFichier {
    public static void main (String args[]) {
        FileOutputStream unFichier;
        try{
            File leFile = new File("Octets.dat");
            if (leFile.exists()){
                String reponse = JOptionPane.showInputDialog("Voulez-vous détruire le contenu existant (oui ou non)?");
                if(reponse == "non"){
                    System.out.println("Le fichier demeure tel quel");
                    System.exit(0);
                }
            }
            unFichier = new FileOutputStream(leFile);

            int unEntier = 1629696561;//(97*2^24)+(35*2^16)+(50<<2^8)+49 = "a#21" en String;
            // Convertir unEntier en un tableau de 4 octets
            byte[] tampon = new byte[4];
            for (int i = 3; i>=0;i--){
                tampon[i] = (byte)(unEntier & 0XFF); //Extrait l'octet le moins significatif
                unEntier >>>=8; //Décalage de 8 bits (remplissage à 0)
            }
            unFichier.write(tampon);
            unFichier.close();
        }
        catch (IOException e){
            System.err.println("Exception\n" + e.toString());
        }
        System.exit(0);
    }
}