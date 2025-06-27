public class ExempleTableau {
  public static void main(String[] args) {
    int tableauDe5Int[] = {12, 3, 154, -5, 17};
    for (int i = 0; i < tableauDe5Int.length; i++) System.out.println(i + " " + tableauDe5Int[i]);
    for (int unInt : tableauDe5Int) System.out.println(unInt);
  }
}
