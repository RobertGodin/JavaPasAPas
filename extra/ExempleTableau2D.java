public class ExempleTableau2D {
  public static void main(String[] args) {
    int matrice2par3[][] = {{11, 3, 2}, {-5, 7, 2}};
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) System.out.print(matrice2par3[i][j] + " ");
      System.out.println();
    }
    for (int[] ligne : matrice2par3) {
      for (int unInt : ligne) System.out.print(unInt + " ");
      System.out.println();
    }
  }
}
