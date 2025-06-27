public class ExemplePorteeVariables {
  public int x;
  public static int y;
  public int z;
  public static int w;

  public ExemplePorteeVariables() {
    x = 1;
    y = 2;
    z = 3;
    w = 4;
  }

  public void m1(int x) {
    int y = 12;
    System.out.println("Valeur du paramètre x dans la méthode m1() =" + x);
    System.out.println("Valeur de la variable locale y dans la méthode m1() =" + y);
    System.out.println("Valeur de la variable d'objet x dans la méthode m1() =" + this.x);
    System.out.println("Valeur de la variable de classe y dans la méthode m1() =" + this.y);
    System.out.println("Valeur de la variable d'objet z dans la méthode m1() =" + z);
    System.out.println("Valeur de la variable de classe w dans la méthode m1() =" + w);
  }

  public void m2(int x) {
    int y = 22;
    System.out.println("Valeur du paramètre x dans la méthode m2() =" + x);
    System.out.println("Valeur dela variable locale y dans la méthode m2() =" + y);
    System.out.println("Valeur de la variable d'objet x dans la méthode m2() =" + this.x);
    System.out.println("Valeur de la variable de classe y dans la méthode m2() =" + this.y);
    System.out.println("Valeur de la variable d'objet z dans la méthode m2() =" + z);
    System.out.println("Valeur de la variable de classe w dans la méthode m2() =" + w);
  }

  public static void main(String args[]) {
    System.out.println("Création de l'objet1 :");
    ExemplePorteeVariables objet1 = new ExemplePorteeVariables();
    objet1.m1(30);
    objet1.m2(40);
    System.out.println("Création de l'objet2 :");
    ExemplePorteeVariables objet2 = new ExemplePorteeVariables();
  }
}
