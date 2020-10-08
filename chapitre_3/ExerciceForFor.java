/** ExerciceForFor.java */

public class ExerciceForFor {
  public static void main(String args[]) {
    for (int compteur1 = 1; compteur1 <= 9; compteur1 = compteur1 + 1) {
      for (int compteur2 = 1; compteur2 <= compteur1; compteur2 = compteur2 + 1)
        System.out.print(compteur2);
      System.out.println();
    }
  }
}
