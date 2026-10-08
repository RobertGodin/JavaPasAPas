import java.io.*;

public class CreerRepertoire {
  public static void main(String[] args) throws Exception {
    File unFile = new File("DossierA/DossierB");
    unFile.mkdirs();
    if (unFile.exists()) {
      System.out.println("Il a été créé");
    } else {
      System.out.println("Il n'a pas été créé");
    }
  }
}
