/* Illustration de l'�criture d'un objet complexe dans un fichier par s�rialisation
 * Lit le fichier plants.txt, stocke le contenu dans un vecteur d'objets Plant et
 * �crit ensuite le vecteur dans le fichier VecteurPlants.dat*/

import java.io.*;
import java.util.*;
public class EcrireVecteurPlants{

        // La m�thode lit les donn�es de Plants.txt et les retournent dans un vecteur d'objets 
        // de la classe Plant
        // Reprend essentiellement le code de ExempleStreamTokenizer
    public static Vector lirePlantsFichierTexte()throws Exception{

        FileReader unFichier = new FileReader("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/Plants.txt");
        StreamTokenizer unStreamTokenizer = new StreamTokenizer(unFichier);

        // Les 5 lignes suivantes ne sont pas nécessaires car les param�tres
        // donn�s sont les valeurs de d�faut
        unStreamTokenizer.quoteChar((int)'"');
        unStreamTokenizer.whitespaceChars((int)'\r',(int)'\r');
        unStreamTokenizer.whitespaceChars((int)'\n',(int)'\n');
        unStreamTokenizer.whitespaceChars((int)'\t',(int)'\t');
        unStreamTokenizer.whitespaceChars((int)' ',(int)' ');

        Vector vecteurDePlants = new Vector();
        int noPlant = 0;
        String description = "";
        double prixUnitaire = 0.0;

        while(unStreamTokenizer.nextToken()!= StreamTokenizer.TT_EOF){// fin du fichier ?
            // Lecture du noPlant
            if(unStreamTokenizer.ttype == StreamTokenizer.TT_NUMBER){//Est-ce bien un nombre ?
                noPlant = (int) unStreamTokenizer.nval; //nval est un double !
            } else
        {System.out.println("Le format du fichier est incorrect : noPlant attendu"); System.exit(1);}
            //Lecture de la description
            unStreamTokenizer.nextToken();
            if(unStreamTokenizer.ttype == (int)'"'){//Est-ce bien une cha�ne encadr�e par " ?
                description = unStreamTokenizer.sval;
            } else
        {System.out.println("Le format du fichier est incorrect : description attendue"); System.exit(1);}
            //Lecture du prixUnitaire
            unStreamTokenizer.nextToken();
            if(unStreamTokenizer.ttype == StreamTokenizer.TT_NUMBER){//Est-ce bien un nombre ?
                prixUnitaire = unStreamTokenizer.nval;
            } else
        {System.out.println("Le format du fichier est incorrect : prix attendu"); System.exit(1);}

            //Cr�ation de l'objet Plant
            Plant unPlant = new Plant(noPlant, description, prixUnitaire);
            System.out.println(noPlant + " " + description + " " + prixUnitaire);
            vecteurDePlants.addElement(unPlant);
        }
        unFichier.close();
        return vecteurDePlants;
    }
    
    // La m�thode suivante �crit les objets de vecteurDePlants les uns à la suite
    // des autres dans le fichier FluxPlants.dat par accès s�riel
    public static void ecrireFichierFluxPlants (Vector vecteurDePlants) throws Exception{
        ObjectOutputStream fichierFluxPlants =
        new ObjectOutputStream (
        new FileOutputStream("C:/Users/Robert/Documents/NetBeansProjects/JavaLivre/build/classes/VecteurPlants.dat"));
        fichierFluxPlants.writeObject(vecteurDePlants);
        fichierFluxPlants.close();
    }

    public static void main (String args[]) throws Exception{
        Vector vecteurDePlants = lirePlantsFichierTexte();
        ecrireFichierFluxPlants(vecteurDePlants);
    }
}