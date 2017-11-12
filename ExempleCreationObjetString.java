import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane
public class ExempleCreationObjetString{

    public static void main (String args[]) {

      String string1 = new String("abcdef");
      String string2 = string1;
      String string3 = new String("abcdef");

      // string1 et string2 font référence au même objet
      System.out.println(string1 == string2); //true
      // string1 et string3 sont deux objets différents
      System.out.println(string1 == string3); //true
      // par contre, string1 et string3 ont le même contenu
      System.out.println(string1.equals(string3)); //true
      }
}