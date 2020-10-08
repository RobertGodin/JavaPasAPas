public class ExemplesStringVide {

  public static void main(String args[]) {

    String string1 = "";
    String string2 = new String("");
    String string3 = new String();
    String string4 = null;

    System.out.println(string1 == ""); // true
    System.out.println(string1.equals("")); // true
    System.out.println(string1 == null); // false

    System.out.println(string2 == ""); // false
    System.out.println(string2.equals("")); // true
    System.out.println(string2 == null); // false

    System.out.println(string3 == ""); // false
    System.out.println(string3.equals("")); // true
    System.out.println(string3 == null); // false

    System.out.println(string4 == ""); // false
    // System.out.println(string4.equals("")); provoquerait une exception à l'exécution
    System.out.println(string4 == null); // true
  }
}
