/**
 * Création d'un arbre DOM avec JAXP
 * Parcours de l'arbre pour extraire les données et les insérer
 * dans le vecteurs d'objets Plant
 */

package LivreJava;

// Packages de JAXP
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;

import java.io.*;
import java.util.*;


public class ExempleJAXPPlants {

    public static void main(String[] args) throws Exception {
        // Création d'un DocumentBuilderFactory et configuration des paramètres
        DocumentBuilderFactory unDocBuildFact = DocumentBuilderFactory.newInstance();
        unDocBuildFact.setValidating(true);
        unDocBuildFact.setIgnoringElementContentWhitespace(true);

        // Création d'un DocumentBuilder
        DocumentBuilder unDocumentBuilder = unDocBuildFact.newDocumentBuilder();

        // Parsage du document
        File leFile = new File("D:/oracle/oraDev/jdev/mywork/WorkspaceLivreJava/LivreJava/classes/LivreJava/Plants.xml");
        Document unDocument = unDocumentBuilder.parse(leFile);
        Vector vecteurDePlants = new Vector();
        Node unElementCatalogue = unDocument.getDocumentElement(); // Cherche l'élément racine <catalogue>

        // Itérer sur les noeuds <Plant> qui sont les enfants de <Catalogue>
        NodeList listeNodePlants = unElementCatalogue.getChildNodes();
        int tailleListe = listeNodePlants.getLength();
        for (int i = 0; i < tailleListe ; i++) {
            Node unNodePlant = listeNodePlants.item(i); //ELEMENT <Plant>
            
            Node unNodeNoPlant = unNodePlant.getFirstChild(); //ELEMENT <noPlant>
            // la valeur est dans le premier enfant
            int noPlant = Integer.parseInt(unNodeNoPlant.getFirstChild().getNodeValue());

            Node unNodeDescription = unNodeNoPlant.getNextSibling(); //ELEMENT <description>
            String description = unNodeDescription.getFirstChild().getNodeValue();

            Node unNodePrixUnitaire = unNodeDescription.getNextSibling(); //ELEMENT <prixUnitaire>
            double prixUnitaire = Double.parseDouble(unNodePrixUnitaire.getFirstChild().getNodeValue());

            Plant unPlant = new Plant(noPlant, description, prixUnitaire);
            System.out.println(noPlant + " " + description + " " + prixUnitaire);
            vecteurDePlants.addElement(unPlant);
        }
    }
}