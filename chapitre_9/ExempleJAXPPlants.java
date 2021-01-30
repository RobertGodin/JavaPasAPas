/**
 * création d'un arbre DOM avec JAXP Parcours de l'arbre pour extraire les données et les ins�rer
 * dans le vecteurs d'objets Plant
 */

// Packages de JAXP
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class ExempleJAXPPlants {

  public static void main(String[] args) throws Exception {
    // création d'un DocumentBuilderFactory et configuration des paramètres
    DocumentBuilderFactory unDocBuildFact = DocumentBuilderFactory.newInstance();
    unDocBuildFact.setValidating(true);
    unDocBuildFact.setIgnoringElementContentWhitespace(true);

    // création d'un DocumentBuilder
    DocumentBuilder unDocumentBuilder = unDocBuildFact.newDocumentBuilder();

    // Parsage du document
    File leFile = new File("Plants.xml");
    Document unDocument = unDocumentBuilder.parse(leFile);
    Vector vecteurDePlants = new Vector();
    Node unElementCatalogue =
        unDocument.getDocumentElement(); // Cherche l'�l�ment racine <catalogue>

    // It�rer sur les noeuds <Plant> qui sont les enfants de <Catalogue>
    NodeList listeNodePlants = unElementCatalogue.getChildNodes();
    int tailleListe = listeNodePlants.getLength();
    for (int i = 0; i < tailleListe; i++) {
      Node unNodePlant = listeNodePlants.item(i); // ELEMENT <Plant>

      Node unNodeNoPlant = unNodePlant.getFirstChild(); // ELEMENT <noPlant>
      // la valeur est dans le premier enfant
      int noPlant = Integer.parseInt(unNodeNoPlant.getFirstChild().getNodeValue());

      Node unNodeDescription = unNodeNoPlant.getNextSibling(); // ELEMENT <description>
      String description = unNodeDescription.getFirstChild().getNodeValue();

      Node unNodePrixUnitaire = unNodeDescription.getNextSibling(); // ELEMENT <prixUnitaire>
      double prixUnitaire = Double.parseDouble(unNodePrixUnitaire.getFirstChild().getNodeValue());

      Plant unPlant = new Plant(noPlant, description, prixUnitaire);
      System.out.println(noPlant + " " + description + " " + prixUnitaire);
      vecteurDePlants.addElement(unPlant);
    }
  }
}
