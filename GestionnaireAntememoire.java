
import java.io.*;
public class GestionnaireAntememoire {
    //Le gestionnaire d'ant�mémoire r�alise les mêmes Opérations de lecture et
    //d'�criture de bloc que la couche pr�c�dente (classe Disque) en utilisant une ant�mémoire
    //disque pour am�liorer la performance des entrées/sorties.
    //La strat�gie de remplacement utilisée est : moins fr�quemment utilisé (LFU).

    static final int nbTampon = 3;
    Disque leDisque;
    // R�alisation d'un r�pertoire simple à l'aide d'un tableau noBloc
    // qui contient le noBloc du bloc dans le tampon
    int noBlocDansTampon[];
    boolean sale[];
    int fr�quence[];
    byte tampon [][];

    public GestionnaireAntememoire() {
        //Constructeur qui initilise les structures de données de l'ant�mémoire
        leDisque = new Disque();
        noBlocDansTampon = new int[nbTampon];
        sale = new boolean[nbTampon];
        tampon = new byte[nbTampon][Disque.tailleBloc];
        fr�quence = new int[nbTampon];
        for(int i=0; i<nbTampon; i++){
            noBlocDansTampon[i] = -1;
        }
    }

    public void fermerAntememoire() {
        // La fonction fermerAnt�mémoire doit �vacuer les tampons sales. Cette op�ration doit �tre
        //  appelée à la fin du programme pour assurer que les blocs modifiés sont propag�s sur disque.
        for(int i=0; i<nbTampon; i++)
        this.�vacuerTampon(i);
        leDisque.fermer();
    }

    public void lireBlocAntememoire(int noBloc, byte tamponApplication[])
    //La fonction lireBlocAnt�mémoire lit le contenu du bloc dont le numéro est
    // noBloc dans tamponApplication.

    //Exceptions à pr�voir :
    //1: le param�tre noBloc est à l'ext�rieur de l'intervalle [0..nbBloc-1]
    //2: autre exception

    throws IOException, NoBlocIllegalException
    {
        if (noBloc <0 || noBloc >= Disque.nbBloc) {
            throw new NoBlocIllegalException(noBloc);
        }
        // Chercher numéroBloc dans le r�pertoire (simple fouille s�quentielle)
        int positionAntememoire;
        for (positionAntememoire = 0; positionAntememoire<nbTampon ; positionAntememoire++){
            if (noBloc == noBlocDansTampon[positionAntememoire]){
                break;
            }
        }
        if (positionAntememoire<nbTampon){  //SI pr�sent
            //transf�rer le tampon de l'ant�-mémoire dans tamponApplication
            for(int i=0; i<Disque.tailleBloc ; i++){
                tamponApplication[i] = tampon[positionAntememoire][i];
            }
            ++fr�quence[positionAntememoire];
        }
        else{
            int indiceLibre;
            for (indiceLibre = 0; indiceLibre<nbTampon ; indiceLibre++){
                if (noBlocDansTampon[indiceLibre] == -1){
                    break;
                }
            }
            if (indiceLibre < nbTampon){//SI il y a un tampon libre dans l'ant�-mémoire
                //transf�rer le bloc noBloc dans le tampon libre
                leDisque.lireBloc(noBloc, tampon[indiceLibre]);
                //mettre à jour le r�pertoire d'ant�-mémoire
                noBlocDansTampon[indiceLibre]=noBloc;
                sale[indiceLibre]= false;
                fr�quence[indiceLibre] = 0;
                for(int i=0; i<Disque.tailleBloc ; i++){
                    tamponApplication[i] = tampon[indiceLibre][i];
                }
            }
            else{
                //sélectionner le tamponVictime à �vacuer selon LFU
                int indiceVictime = 1;
                int fr�quenceMinimum = fr�quence[1];
                for(int i =0; i < nbTampon; i++){
                    if (fr�quence[i]<fr�quenceMinimum){
                        fr�quenceMinimum = fr�quence[i];
                        indiceVictime = i;
                    }
                }
                this.�vacuerTampon(indiceVictime);
                leDisque.lireBloc(noBloc, tampon[indiceVictime]);
                //mettre à jour le r�pertoire d'ant�-mémoire
                noBlocDansTampon[indiceVictime]=noBloc;
                sale[indiceVictime]= false;
                fr�quence[indiceVictime]=0;
                for(int i=0; i<Disque.tailleBloc ; i++){
                    tamponApplication[i] = tampon[indiceVictime][i];
                }
            }
        }
    }

    public void �crireBlocAntememoire(int noBloc, byte tamponApplication[])
    throws NoBlocIllegalException{
        //La fonction �crireBlocAnt�mémoire �crit le contenu de tamponApplication dans le bloc dont le numéro est noBloc.

        if (noBloc <0 || noBloc >= Disque.nbBloc) {
            throw new NoBlocIllegalException(noBloc);
        }
        // Chercher noBloc dans le r�pertoire (simple fouille s�quentielle)
        int positionAntememoire;
        for (positionAntememoire = 0; positionAntememoire<nbTampon ; positionAntememoire++){
            if (noBloc == noBlocDansTampon[positionAntememoire]){
                break;
            }
        }
        if (positionAntememoire<nbTampon){  //SI pr�sent
            //transf�rer tamponApplication dans le tampon de l'Antememoire
            for(int i=0; i<Disque.tailleBloc ; i++){
                tampon[positionAntememoire][i] = tamponApplication[i];
            }
            sale[positionAntememoire] = true;
            ++fr�quence[positionAntememoire];
        }
        else{
            int indiceLibre;
            for (indiceLibre = 0; indiceLibre<nbTampon ; indiceLibre++){
                if (noBlocDansTampon[indiceLibre] == -1){
                    break;
                }
            }
            if (indiceLibre < nbTampon){//SI il y a un tampon libre dans l'ant�-mémoire
                //transf�rer tamponApplication dans le tampon libre
                for(int i=0; i<Disque.tailleBloc ; i++){
                    tampon[indiceLibre][i] = tamponApplication[i];
                }
                sale[indiceLibre] = true;
                //mettre à jour le r�pertoire d'ant�-mémoire
                noBlocDansTampon[indiceLibre] = noBloc;
                fr�quence[indiceLibre] = 0;
            }
            else{
                //sélectionner le tamponVictime à �vacuer selon LFU
                int indiceVictime = 1;
                int fr�quenceMinimum = fr�quence[1];
                for(int i =0; i < nbTampon; i++){
                    if (fr�quence[i]<fr�quenceMinimum){
                        fr�quenceMinimum = fr�quence[i];
                        indiceVictime = i;
                    }
                }
                this.�vacuerTampon(indiceVictime);
                for(int i=0; i<Disque.tailleBloc ; i++){
                    tampon[indiceVictime][i] = tamponApplication[i];
                }
                //mettre à jour le r�pertoire d'ant�-mémoire
                noBlocDansTampon[indiceVictime]=noBloc;
                sale[indiceVictime]= true;
                fr�quence[indiceVictime] = 0;
            }
        }
    }
    public void �vacuerTampon(int indiceTampon){
        //La fonction �vacuerTampon force l'�vacuation du tampon noTampon.

        //Exceptions à pr�voir :
        //1: le noTampon n'est pas dans l'intervalle [0..nbTampon-1]
        //2: autre exception

        if (sale[indiceTampon]){
            leDisque.�crireBloc(noBlocDansTampon[indiceTampon],tampon[indiceTampon]);
            sale[indiceTampon] = false;
        }
    }

    public void afficherDisque() {
        //Pour les essais
        byte tamponApplication[] = new byte[Disque.tailleBloc];
        String contenuString;
        System.out.println("Contenu du disque:");
        for(int i = 0; i<Disque.nbBloc; i++){
            try{
            leDisque.lireBloc(i,tamponApplication);}
            catch (Exception e){
                System.out.println("Erreur de lecture dans Disque.lireBloc\n" + e.toString());
            }
            contenuString = new String(tamponApplication,0);
            System.out.print("|"+contenuString);
        }
        System.out.println("");
        System.out.println("Contenu antememoire:");
        for(int i = 0; i<nbTampon; i++){
            contenuString = new String(tampon[i],0);
            System.out.println(i+":"+contenuString+"|"+noBlocDansTampon[i]+"|"+fr�quence[i]+"|"+sale[i]);
        }
    }
}