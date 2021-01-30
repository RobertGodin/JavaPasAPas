import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane
public class ExempleMethodesDeString{

    public static void main (String args[]) {

      String string1 = new String("abcdef");
      String string2 = new String("cd");
      System.out.println("String string1 = new String(\"abcdef\")");
      System.out.println("String string2 = new String(\"cd\")");
      System.out.println("La longueur de string1 est :" + string1.length());      
      System.out.println("Le caractère en position 2 de string1 est :" + string1.charAt(2));
      System.out.println("La sous-chaine en position 2 de string1 est :" + string1.substring(2));
      System.out.println("La sous-chaine qui débute en position 2 et fini en 4 est :" + string1.substring(2,5));
      System.out.println("La première occurrence de string2 dans string1 est à la position :" + string1.indexOf(string2));    
      System.out.println("La concaténation de string2 à string1 donne :" + string1.concat(string2));    
      }
}