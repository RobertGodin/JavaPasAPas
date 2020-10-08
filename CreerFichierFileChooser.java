
import java.io.*;
import javax.swing.*;
public class CreerFichierFileChooser extends JFrame {
    public CreerFichierFileChooser () throws Exception {
        JFileChooser unFileChooser = new JFileChooser();
        unFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultat = unFileChooser.showSaveDialog(this);
        if (resultat != JFileChooser.CANCEL_OPTION){
            File leFile = unFileChooser.getSelectedFile();
            if (leFile != null && !(leFile.getName().equals(""))){
                FileOutputStream unFichier = new FileOutputStream(leFile);

                int unEntier = 1629696561;//(97*2^24)+(35*2^16)+(50<<2^8)+49 = "a#21" en String;
                // Convertir unEntier en un tableau de 4 octets
                byte[] tampon = new byte[4];
                for (int i = 3; i>=0;i--){
                    tampon[i] = (byte)(unEntier & 0XFF); //Extrait l'octet le moins significatif
                    unEntier >>>=8; //D�calage de 8 bits (remplissage à 0)
                }
                unFichier.write(tampon);
                unFichier.close();
                
            }else{System.out.println("Nom de fichier invalide");}
        }else {System.out.println("Fichier non choisi");}
        System.exit(0);
    }
    public static void main (String args[]) throws Exception {
        new CreerFichierFileChooser();
    }
}