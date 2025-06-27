# JavaPasAPas

Site Web du livre :  Godin et Lemire (2021). Java Pas à Pas. Publié sur GitHub.


<p><a href="https://www.amazon.ca/Java-pas-Introduction-programmation-langage/dp/B0CR7RW87Y/">Vous pouvez aussi acheter la version papier du manuel Java pas à pas chez Amazon</a>:</p>
<div><a href="https://www.amazon.ca/Java-pas-Introduction-programmation-langage/dp/B0CR7RW87Y/"><img src="https://m.media-amazon.com/images/I/61tnblFlmmL._SL1499_.jpg" width="250px" style="margin-left:auto; margin-right:auto;"></a></div>


[Vous pouvez télécharger tout le code votre machine sous la forme d'un fichier zip](https://github.com/RobertGodin/JavaPasAPas/archive/refs/heads/main.zip).

## Conventions

- La norme Google est utilisée pour le style.
- Pour éviter les problèmes de compatibilité, tous les noms de fichier sont limités aux caractères ASCII (sans accent). En conséquence, toutes les classes Java publiques sont limités aux caractères ASCII.
- Plus généralement, le code Java utilise l'encodade de caractères [UTF-8](https://en.wikipedia.org/wiki/UTF-8). Sur certains systèmes, il peut être nécessaire de spécifier à Java l'encodage des caractères (par ex. `javac  -encoding UTF-8 *.java`). Assurez-vous d'utiliser un éditeur de texte qui supporte l'encodage UTF-8.
- Tous les fichiers sont organisés par chapitre, selon l'organisation du livre. Il est possible de compiler toutes les classes d'un même dossier sans faire appel aux autres dossiers. Un petit nombre de fichiers apparaissent dans plus d'un dossier.
- Notez que le fichier ExempleVariablesLocalesErreur.java ne compile pas, intentionnellement.




## Installation de Java (vidéo)

[![Watch the video](https://img.youtube.com/vi/1ttHH5MlNug/maxresdefault.jpg)](https://youtu.be/1ttHH5MlNug)

- Aller sur le site [adoptium](https://adoptium.net/fr/). Choisir la dernière version Java disponible.
- Il est préférable de laissez le programme d'installation configurer les variables PATH et JAVA_HOME.
- Une fois le fichier d’installation enregistré, démarrer l’installation et suivre les différentes étapes d’installation.
- Une fois le logiciel installé, la machine virtuelle Java (java.exe) et ses outils de compilation (javac.exe) auront été installés.

## Exécution des programmes Java chapitre par chapitre avec Gradle (optionnel)

Pour compiler et exécuter les programmes des premiers chapitres :

### Compilation

Sous macOS ou Linux, compilez un chapitre avec :

```bash
./gradlew buildChapitre_2   # Pour le chapitre 2
./gradlew buildChapitre_3   # Pour le chapitre 3
./gradlew buildChapitre_4   # Pour le chapitre 4
./gradlew buildChapitre_5   # Pour le chapitre 5
./gradlew buildChapitre_6   # Pour le chapitre 6
./gradlew buildChapitre_7   # Pour le chapitre 7
./gradlew buildChapitre_8   # Pour le chapitre 8
./gradlew buildChapitre_9   # Pour le chapitre 9
```



Sous Windows, utilisez `gradlew.bat` au lieu de `./gradlew` :

```bat
gradlew.bat buildChapitre_2
```


### Exécution

Après compilation, exécutez un programme avec :

```bash
java -cp build/classes/chapitre_X NomDeLaClasse
```
Par exemple, pour exécuter `ExempleBloc` du chapitre 3 :
```bash
java -cp build/classes/chapitre_3 ExempleBloc
```

Pour le chapitre 9, il peut être utile de copier les fichiers afin que les programmes
puissent s'exécuter correctement:

```
./gradlew copyNonJavaFilesChapitre9
```

### Liste des classes exécutables (avec `main`)

**Chapitre 2**
- Exemple1
- Exercice1
- ExempleScanner
- ExemplePrintln
- Exercice2
- Exemple2

**Chapitre 3**
- ExerciceWhile2
- Afficher12345
- ExerciceForFor
- ExempleWhile
- ExempleForSimple
- ExempleEtCourtcircuite
- ExempleForSentinelle
- ExerciceWhile3
- ExemplesMath
- ExerciceIf1
- ExempleIf
- ExempleCreationObjetString
- ExerciceIfMax2
- ExempleIfIfElse
- ExempleZero
- ExempleBloc
- ExempleElseAmbigu
- ExerciceIfMax3
- ExempleEmoji
- ExemplesStringVide
- ExerciceWhileIf
- ExempleLogique
- ExerciceWhileSentinelle
- ExerciceWhile1
- ExempleStringNonInitialise
- ExemplesString

**Chapitre 4**
- ExerciceDessinIti
- ExempleBotRectangleEnglobant
- ExempleDessin2DDansJFrame
- Exemple2BotsRectangleEnglobant
- ExempleVariablesLocales
- Exercice2Bots
- ExempleEvenementSouris2Fenetres
- ExercicePlusieursBotEtIti
- ExempleMethodePaintBot
- ExempleMethodeDobjetPaintBot
- ExerciceMethodePaintIti
- ExempleConstantesFinal
- ExempleVariableDobjet
- ExempleEvenementSouris

**Chapitre 5**
- ExerciceJFrameAvecItiRebondissant
- ExempleJFrameAnimationDoubleTampon
- ExerciceJFrameAvecPingPongBot
- ExerciceJFrameAvecPingPongBotsEtItis
- ExerciceJFrameAvecBotRebondissant
- ExempleJFrameAvecAnimationRatee


**Chapitre 6**
- ExempleJFrameAvecSuperClassePourBotEtIti
- ExempleJFrameAvecClassesPourBotEtIti

**Chapitre 7**
- ExempleJFrameIncluantJPanelAnimeMondeAnime
- JFrameIncluantJPanelAvecBoucleAnimeMondeAnime

**Chapitre 8**
- VerifierExistenceFichier
- CompterOctetsFichier
- EcrireEntierTextePrintWriter
- EcrireEntierEnOctets
- LireEntierEnOctets
- EcrireTexteabc12
- ExempleJFrameIncluantJPanelAvecAnimationParTimer
- AccesDirect
- CreerFichierDirect
- CopierFichier
- LireVecteurPlants
- ExempleStreamTokenizer
- CreerFichierFileChooser
- EcrireVecteurPlants
- LireFluxPlants
- EcrireEntier
- LireFichierFileChooser
- EcrireEntierTexte
- ExempleJAXPPlants
- EcrireFluxPlants

**Chapitre 9**
- ExempleJAXPDom
- TestJAXP
- CreerRepertoire
- LireEntier
- EcrireFluxEtTaille
- EcrireOctetsFichier
- LireEntierTexte


### Exemples de commandes d'exécution

```bash
# Chapitre 2
java -cp build/classes/chapitre_2 Exemple1
java -cp build/classes/chapitre_2 Exercice2

# Chapitre 3
java -cp build/classes/chapitre_3 ExempleBloc
java -cp build/classes/chapitre_3 ExerciceIf1
java -cp build/classes/chapitre_3 Afficher12345

# Chapitre 4
java -cp build/classes/chapitre_4 ExempleBotRectangleEnglobant
java -cp build/classes/chapitre_4 ExerciceDessinIti

# Chapitre 5
java -cp build/classes/chapitre_5 ExempleJFrameAvecAnimationRatee
java -cp build/classes/chapitre_5 ExerciceJFrameAvecPingPongBot
```

> Remplacez le nom de la classe par celle que vous souhaitez exécuter dans le chapitre concerné.



## Éditeur

Nous vous recommandons [Visual Studio Code](https://code.visualstudio.com) comme environnement de travail.
