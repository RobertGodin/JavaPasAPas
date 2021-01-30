import java.io.Serializable;

public class PlantTailleFixe implements Serializable {
  private int noPlant; // numéro de catalogue du plant
  private char[] description = new char[15]; // description du plant
  private double prixUnitaire; // prix unitaire du plant

  public PlantTailleFixe(int noPlant, char[] description, double prixUnitaire) {
    this.noPlant = noPlant;
    this.description = description;
    this.prixUnitaire = prixUnitaire;
  }

  public void setNoPlant(int noPlant) {
    this.noPlant = noPlant;
  }

  public int getNoPlant() {
    return noPlant;
  }

  public void setDescription(char[] description) {
    this.description = description;
  }

  public char[] getDescription() {
    return description;
  }

  public void setPrixUnitaire(double prixUnitaire) {
    this.prixUnitaire = prixUnitaire;
  }

  public double getPrixUnitaire() {
    return prixUnitaire;
  }
}
