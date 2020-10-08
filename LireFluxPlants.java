/* Illustration de la lecture d'un fichier d'objets par itération sérielle
 * Lit le fichier fluxPlants.dat et en affiche le contenu */

import java.io.*;
public class LireFluxPlants{

    public static void main (String args[]) throws Exception {
        
        ObjectInputStream fichierFluxPlants =
        new ObjectInputStream (
            new FileInputStream("FluxPlants.dat"));
        
        while(true){
            Plant unPlant =  new Plant(0,"",0.0);
            try{// Lecture de l'objet suivant
                unPlant = (Plant) fichierFluxPlants.readObject();
            }
            catch (EOFException e){
                break;
            }
            System.out.println(
                unPlant.getNoPlant() + " " +
                unPlant.getDescription() + " " + 
                unPlant.getPrixUnitaire());
        }
        fichierFluxPlants.close();
    }
}