public class ExemplesString {

  public static void main(String args[]) {

    String string1 = "abc";
    String string2 = "def";
    String string3 = "abcdef";
    String string4 = new String("abcdef");

    // Tous les littéraux identiques (à la compilation) sont traduits
    // par une référence au même objet
    System.out.println(string3 == "abcdef"); // true
    System.out.println("abc" + "def" == "abcdef"); // true

    // Par contre, si le littéral est calculé à l'exécution, ce n'est pas le cas
    System.out.println(string1 + string2 == "abcdef"); // false

    // Le constructeur String produit toujours un objet différent de l'objet
    // correspondant au littéral
    System.out.println(string4 == "abcdef"); // false

    // La méthode intern() de la classe String permet de convertir
    // la référence à l'objet correspondant au littéral
    System.out.println((string1 + string2).intern() == "abcdef"); // true
    System.out.println(string4.intern() == "abcdef"); // true

    // La méthode equals() permet de comparer le contenu de l'objet plutôt que la référence
    System.out.println((string1 + string2).equals("abcdef")); // true
    System.out.println(string4.equals("abcdef")); // true
  }
}
