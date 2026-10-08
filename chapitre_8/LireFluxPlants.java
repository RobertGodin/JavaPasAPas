/* Illustration de la lecture d'un fichier d'objets par itération sérielle
 * Lit le fichier FluxPlants.dat et en affiche le contenu */

import java.io.*;

public class LireFluxPlants {

  public static void main(String[] args) throws Exception {
    try (ObjectInputStream fichierFluxPlants =
        new ObjectInputStream(new FileInputStream("FluxPlants.dat"))) {
      while (true) {
        Plant unPlant;
        try { // Lecture de l'objet suivant
          unPlant = (Plant) fichierFluxPlants.readObject();
        } catch (EOFException e) {
          break; // Fin du fichier
        }
        System.out.println(unPlant.getNoPlant() + " "
            + unPlant.getDescription() + " " + unPlant.getPrixUnitaire());
      }
    }
  }
}
