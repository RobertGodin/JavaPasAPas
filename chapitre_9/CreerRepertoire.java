import java.io.*;

public class CreerRepertoire {
  public static void main(String args[]) throws Exception {
    File unFile = new File("C:/forte4j/Development/DossierA/DossierB/");
    unFile.mkdirs();
    if (unFile.exists()) {
      System.out.println("il a été créé");
    } else {
      System.out.println("Il n'a pas été créé");
    }
  }
}
