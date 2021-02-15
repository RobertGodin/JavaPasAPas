// Title:      Mini SGF
// Version:
// Copyright:  Copyright (c) 1999
// Author:     Godin
// Company:    UQAM
// Description: petite application de test pour GestionnaireAntememoire

import java.io.*;
import javax.swing.JOptionPane;

public class MiniSGFApp {

  public static void main(String[] args) throws Exception {
    GestionnaireAntememoire leGestionnaireAntememoire = new GestionnaireAntememoire();
    int noBloc;
    int choix;
    String chaineNoBloc;
    int input;
    byte tamponApplication[] = new byte[Disque.tailleBloc];
    String contenuString;

    while (true) {
      String chaineChoix =
          JOptionPane.showInputDialog("Menu:(1)lireBloc,(2)écrireBloc,(3)afficher,(4)exit: ");
      choix = Integer.parseInt(chaineChoix);
      switch (choix) {
        case 1: // lire un bloc
          chaineNoBloc = JOptionPane.showInputDialog("Entrez le noBloc à lire: ");
          noBloc = Integer.parseInt(chaineNoBloc);
          try {
            leGestionnaireAntememoire.lireBlocAntememoire(noBloc, tamponApplication);
          } catch (Exception e) {
            System.out.println("Erreur de lecture dans lireBlocAntememoire\n" + e.toString());
          }
          contenuString = new String(tamponApplication, 0);
          JOptionPane.showMessageDialog(null, "Contenu du bloc #" + noBloc + " :" + contenuString);
          break;

        case 2: // écrire un bloc
          chaineNoBloc = JOptionPane.showInputDialog("Entrez le noBloc à écrire : ");
          noBloc = Integer.parseInt(chaineNoBloc);
          String chaineContenu = JOptionPane.showInputDialog("Entrez le contenu du bloc : ");
          tamponApplication = chaineContenu.getBytes();
          leGestionnaireAntememoire.écrireBlocAntememoire(noBloc, tamponApplication);
          JOptionPane.showMessageDialog(null, "Bloc #" + noBloc + ":" + chaineContenu);
          break;

        case 3:
          leGestionnaireAntememoire.afficherDisque();
          break;

        case 4:
          leGestionnaireAntememoire.fermerAntememoire();
          System.exit(0);

        default:
          JOptionPane.showMessageDialog(null, "Choix incorrect :" + choix);
      }
    }
  }
}
