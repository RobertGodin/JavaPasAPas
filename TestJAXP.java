/**
 * Cr�ation d'un arbre DOM avec JAXP
 * Parcours de l'arbre pour extraire les donn�es et les ins�rer
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


public class TestJAXP {

    public static void main(String[] args) throws Exception {
        // Cr�ation d'un DocumentBuilderFactory et configuration des param�tres
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);

        // Cr�ation d'un DocumentBuilder
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Parsage du document
        Document unDocument = db.parse("D:/oracle/oraDev/jdev/mywork/WorkspaceLivreJava/LivreJava/classes/LivreJava/Plants.xml");
        Vector vecteurDePlants = new Vector();
        Element unElementCatalogue = unDocument.getDocumentElement(); // Cherche l'�l�ment racine <catalogue>

        // It�rer sur les noeuds <Plant> qui sont les enfants de <Catalogue>
        NodeList listeNodePlants = unElementCatalogue.getChildNodes();
        int tailleListe = listeNodePlants.getLength();
        for (int i = 0; i < tailleListe ; i++) {
            Element unNodePlant = (Element)listeNodePlants.item(i); //ELEMENT <Plant>
            
            Element unNodeNoPlant = (Element)unNodePlant.getFirstChild(); //ELEMENT <noPlant>
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