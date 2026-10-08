/*
 * Création d'un arbre DOM avec JAXP. Parcours de l'arbre pour extraire les
 * données et les insérer dans un vecteur (ArrayList) d'objets Plant
 */

import java.io.*;
import java.util.*;
// Packages de JAXP
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ExempleJAXPPlants {

  public static void main(String[] args) throws Exception {
    // Création d'un DocumentBuilderFactory et configuration des paramètres
    DocumentBuilderFactory unDocBuildFact =
        DocumentBuilderFactory.newInstance();
    unDocBuildFact.setValidating(true);
    unDocBuildFact.setIgnoringElementContentWhitespace(true);

    // Création d'un DocumentBuilder
    DocumentBuilder unDocumentBuilder =
        unDocBuildFact.newDocumentBuilder();

    // Parsage du document
    File leFile = new File("Plants.xml");
    Document unDocument = unDocumentBuilder.parse(leFile);
    ArrayList<Plant> vecteurDePlants = new ArrayList<Plant>();
    // Cherche l'élément racine <Catalogue>
    Node unElementCatalogue = unDocument.getDocumentElement();

    // Itérer sur les noeuds <Plant> qui sont les enfants de <Catalogue>
    NodeList listeNodePlants = unElementCatalogue.getChildNodes();
    int tailleListe = listeNodePlants.getLength();
    for (int i = 0; i < tailleListe; i++) {
      Node unNodePlant = listeNodePlants.item(i); // ELEMENT <Plant>

      // ELEMENT <noPlant> : la valeur est dans le premier enfant
      Node unNodeNoPlant = unNodePlant.getFirstChild();
      int noPlant =
          Integer.parseInt(unNodeNoPlant.getFirstChild().getNodeValue());

      // ELEMENT <description>
      Node unNodeDescription = unNodeNoPlant.getNextSibling();
      String description =
          unNodeDescription.getFirstChild().getNodeValue();

      // ELEMENT <prixUnitaire>
      Node unNodePrixUnitaire = unNodeDescription.getNextSibling();
      double prixUnitaire = Double.parseDouble(
          unNodePrixUnitaire.getFirstChild().getNodeValue());

      Plant unPlant = new Plant(noPlant, description, prixUnitaire);
      System.out.println(noPlant + " " + description + " " + prixUnitaire);
      vecteurDePlants.add(unPlant);
    }
  }
}
