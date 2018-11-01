
import java.io.*;
import javax.swing.*;
public class LireFichierFileChooser extends JFrame {
    public LireFichierFileChooser () throws Exception {
        JFileChooser unFileChooser = new JFileChooser();
        unFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultat = unFileChooser.showOpenDialog(this);
        if (resultat != JFileChooser.CANCEL_OPTION){
            File leFile = unFileChooser.getSelectedFile();
            if (leFile != null && !(leFile.getName().equals(""))){
                FileInputStream unFichier = new FileInputStream(leFile);

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

            }else{System.out.println("Nom de fichier invalide");}
        }else {System.out.println("Fichier non choisi");}
        System.exit(0);
    }
    public static void main (String args[]) throws Exception {
        new LireFichierFileChooser();
    }
}