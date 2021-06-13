public class ExempleZero {
  public static void main(String[] s) {
    double minus_zero = -0.0;
    double plus_zero = +0.0;
    System.out.println(minus_zero == plus_zero);
    System.out.println(1/minus_zero);
    System.out.println(1/plus_zero);
    System.out.println(1/minus_zero == 1/plus_zero);
    double n = 0.0 / 0.0;
    System.out.println(n);
    System.out.println(n == n);
  }
}
