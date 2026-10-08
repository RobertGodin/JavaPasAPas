/* Illustration de la lecture d'un objet complexe par désérialisation
 * Lit un vecteur (ArrayList) de plants de VecteurPlants.dat et en affiche
 * le contenu */

import java.io.*;
import java.util.*;

public class LireVecteurPlants {

  // La conversion de type de readObject() ne peut être vérifiée
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    ArrayList<Plant> vecteurDePlants;
    try (ObjectInputStream fichierFluxPlants = new ObjectInputStream(
        new FileInputStream("VecteurPlants.dat"))) {
      vecteurDePlants = (ArrayList<Plant>) fichierFluxPlants.readObject();
    }
    for (Plant unPlant : vecteurDePlants) {
      System.out.println(unPlant.getNoPlant() + " "
          + unPlant.getDescription() + " " + unPlant.getPrixUnitaire());
    }
  }
}
