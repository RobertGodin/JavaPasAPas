/*
 * ExempleTypesPrimitifs.java
 * Ce programme illustre les types primitifs de Java
 */
import javax.swing.JOptionPane; // Importe la classe javax.swing.JOptionPane

public class ExempleTypesPrimitifs {

  public static void main(String args[]) {

    boolean unBoolean = true;
    JOptionPane.showMessageDialog(
        null, "La valeur de unBoolean après boolean unBoolean = true; est " + unBoolean);

    char unChar = 'A';
    JOptionPane.showMessageDialog(
        null, "La valeur de unChar après char unChar = 'A'; est " + unChar);

    unChar = '\'';
    JOptionPane.showMessageDialog(null, "La valeur de unChar après unChar = '\''; est " + unChar);

    System.exit(0);
  }
}
