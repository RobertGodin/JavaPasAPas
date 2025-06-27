/*
 * ExempleScanner.java
 * Ce programme saisit deux entiers a la console avec Scanner et en affiche la somme avec System.out.println()
 */

import java.util.Scanner;

public class ExempleScanner {
  public static void main(String args[]) {

    int entier1, entier2, somme;
    Scanner unScanner = new Scanner(System.in);

    // Saisir les deux entiers avec Scanner
    System.out.print("Entrez un premier nombre entier:");
    entier1 = unScanner.nextInt();
    System.out.print("Entrez un second nombre entier:");
    entier2 = unScanner.nextInt();

    // Calculer la somme des deux entiers
    somme = entier1 + entier2;

    // Afficher la somme avec System.out.println()
    System.out.println("La somme des deux entiers est " + somme);
  }
}
