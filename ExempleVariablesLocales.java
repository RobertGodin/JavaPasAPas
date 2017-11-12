public class ExempleVariablesLocales 
{
  public static int x = 0;
  public ExempleVariablesLocales(){}
  
  public static void m1(){
    int x = 1;
    System.out.println("Valeur de la variable locale x dans la m�thode de classe m1() =" + x);
    System.out.println("Valeur de la variable de classe x dans la m�thode de classe m1() =" + ExempleVariablesLocales.x);
  }

  public void m2(){
    int x = 2;
    System.out.println("Valeur de la variable locale x dans la m�thode d'objet m2() =" + x);
    System.out.println("Valeur de la variable de classe x dans la m�thode d'objet m2() =" + this.x);
    System.out.println("Valeur de la variable de classe x dans la m�thode d'objet m2() =" + ExempleVariablesLocales.x);
  }

  public static void main (String args[]) {

    System.out.println("Appel de la m�thode de classe m1() :");
    ExempleVariablesLocales.m1();
    
    System.out.println("Cr�ation d'un objet :");
    ExempleVariablesLocales unObjet =  new ExempleVariablesLocales();
    System.out.println("Appel de la m�thode de d'objet m2() :");
    unObjet.m2();
  }
}