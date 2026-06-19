import java.io.*;

public class Plant implements Serializable {
  private int noPlant; // numéro de catalogue du plant
  private String description; // description du plant
  private double prixUnitaire; // prix unitaire du plant

  public Plant(int noPlant, String description, double prixUnitaire) {
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

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setPrixUnitaire(double prixUnitaire) {
    this.prixUnitaire = prixUnitaire;
  }

  public double getPrixUnitaire() {
    return prixUnitaire;
  }

  public void ecrireEnregistrementTailleMax(RandomAccessFile unFichier) throws Exception {
    int tailleZoneDescription = tailleMaxEnregistrement() - 16; // 4 + 4 + 8 octets
    unFichier.writeInt(noPlant); // 4 octets
    if (description.length() > tailleZoneDescription) {
      System.exit(1);
    }
    unFichier.writeInt(description.length()); // 4 octets
    unFichier.writeBytes(description);
    byte[] padding = new byte[tailleZoneDescription - description.length()];
    unFichier.write(padding); // compléter la zone description à 34 octets
    unFichier.writeDouble(prixUnitaire); // 8 octets
  }

  public void lireEnregistrementTailleMax(RandomAccessFile unFichier) throws Exception {
    int tailleZoneDescription = tailleMaxEnregistrement() - 16; // 4 + 4 + 8 octets
    noPlant = unFichier.readInt();
    int tailleDescription = unFichier.readInt();
    byte[] tampon = new byte[tailleDescription];
    unFichier.readFully(tampon);
    description = new String(tampon);
    unFichier.skipBytes(tailleZoneDescription - tailleDescription);
    prixUnitaire = unFichier.readDouble();
  }

  public static int tailleMaxEnregistrement() {
    return 50;
  }
}
