public class ExemplesString{

    public static void main (String args[]) {

      String string1 = "abc";
      String string2 = "def";
      String string3 = "abcdef";
      String string4 = new String("abcdef");

      // Tous les lit�raux identiques (� la compilation) sont traduits
      // par une r�f�rence au m�me objet
      System.out.println(string3 == "abcdef"); // true
      System.out.println("abc"+"def" == "abcdef"); //true
      
      // Par contre, si le lit�ral est calcul� à l'exécution, ce n'est pas le cas
      System.out.println(string1 + string2 == "abcdef"); //false

      // Le constructeur String produit toujours un objet diff�rent de l'objet
      // correspondant au lit�ral
      System.out.println(string4 == "abcdef"); //false

      // La m�thode intern() de la classe String permet de convertir 
      // la r�f�rence à l'objet correspondant au lit�ral
      System.out.println((string1 + string2).intern() == "abcdef"); //true
      System.out.println(string4.intern() == "abcdef"); //true

      // La m�thode equals() permet de comparer le contenu de l'objet plut�t que la r�f�rence
      System.out.println((string1 + string2).equals("abcdef")); //true
      System.out.println(string4.equals("abcdef")); //true
    }
}