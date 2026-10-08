import java.io.*;
import java.nio.charset.StandardCharsets;

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

  public void ecrireEnregistrementTailleMax(RandomAccessFile unFichier)
      throws Exception {
    // 4 + 4 + 8 octets pour noPlant, la taille et prixUnitaire
    int tailleZoneDescription = tailleMaxEnregistrement() - 16;
    // Un octet par caractère (ISO-8859-1, qui comprend les accents)
    byte[] octets = description.getBytes(StandardCharsets.ISO_8859_1);
    if (octets.length > tailleZoneDescription) {
      System.exit(1);
    }
    unFichier.writeInt(noPlant); // 4 octets
    unFichier.writeInt(octets.length); // 4 octets
    unFichier.write(octets);
    // Compléter la zone description à 34 octets
    unFichier.write(new byte[tailleZoneDescription - octets.length]);
    unFichier.writeDouble(prixUnitaire); // 8 octets
  }

  public void lireEnregistrementTailleMax(RandomAccessFile unFichier)
      throws Exception {
    int tailleZoneDescription = tailleMaxEnregistrement() - 16;
    noPlant = unFichier.readInt();
    int tailleDescription = unFichier.readInt();
    byte[] tampon = new byte[tailleDescription];
    unFichier.readFully(tampon);
    description = new String(tampon, StandardCharsets.ISO_8859_1);
    unFichier.skipBytes(tailleZoneDescription - tailleDescription);
    prixUnitaire = unFichier.readDouble();
  }

  public static int tailleMaxEnregistrement() {
    return 50;
  }
}
