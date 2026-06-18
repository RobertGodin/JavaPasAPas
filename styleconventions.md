# Conventions de style — *Java pas à pas*

Document de référence pour assurer la cohérence de mise en forme du manuel
(`JavaPasAPas.docx`). Il décrit l'état normalisé du document et les règles à
suivre pour toute modification future.

> **Unités OOXML.** `w:sz` est en **demi-points** (`sz=16` → 8 pt). Les espacements
> `before`/`after`/`line` sont en **twips** (`240` → 12 pt, `120` → 6 pt).

---

## 1. Polices par rôle

| Rôle | Police | Taille |
|---|---|---|
| Texte courant | **Garamond** | 12 pt |
| Titres et en-têtes | **Arial Black** | selon le niveau |
| Code (blocs et en ligne) | **Consolas** | 8 pt (blocs) ; taille du texte environnant (en ligne) |
| Mathématiques | Cambria Math | — |
| Pictogrammes | Wingdings / Symbol | — |

**Règle.** Tout code utilise **Consolas**. N'utilisez aucune autre police pour le
code (ni Monaco, Courier New, Courier, DejaVu Sans Mono, Segoe UI, Verdana, ni
aucune police héritée d'un copier-coller web). Le texte courant et les tableaux
sont en **Garamond** ; aucune police serif parasite (Times New Roman, DejaVu
Serif) dans la prose. La police de thème (Calibri) reste inutilisée.

## 2. Code

Le code est la **signature visuelle** du livre : il doit être strictement
uniforme d'un bout à l'autre.

### 2.1 Police et alignement
- **Consolas 8 pt** partout.
- **Jamais justifié** : tous les styles de code sont ferrés à gauche (`jc=left`,
  drapeau à droite). La justification étire les espaces et détruit l'alignement
  en colonnes du monospace.

### 2.2 Traitement visuel (un seul)
- Fond **gris clair `F6F8FA`**, **sans bordure**, sans retrait de première ligne.
- Les blocs contigus forment un seul aplat gris continu (`contextualSpacing`).
- Aucune autre présentation (pas de boîte encadrée, pas de trame, pas de
  monospace nu sur fond blanc).

### 2.3 Entête de fichier — style `EnteteCode`
Un bloc d'exemple est précédé d'une **entête** donnant le chemin du fichier
(p. ex. *Exemple.* `JavaPasAPas/chapitre_2/Exemple1.java`) :
- style **`EnteteCode`** : Consolas 9 pt gras, texte `24292E`, bandeau gris
  `E1E4E8` (légèrement plus foncé que le corps), `keepNext`/`keepLines` ;
- `before=120` (6 pt au-dessus), `after=0` (collée au bloc) ;
- le chemin reste un **lien hypertexte** (`0366D6`) vers le dépôt GitHub ;
- conserver le préfixe « *Exemple.* » ou « *Solution.* » au besoin.

### 2.4 Espacement
Les styles de bloc portent `contextualSpacing` avec `before=0` / `after=120`.
Résultat uniforme : **6 pt au-dessus** (par le `before` de l'entête), entête
collée au bloc, **aucun** espace entre les lignes, **6 pt sous** le bloc.
Ne jamais ajouter de lignes vides ni d'espacement direct autour du code.

### 2.5 Largeur des lignes et repli
Le cadre fait **≈ 76 caractères** (Consolas 8 pt, page de 6 po). Une ligne plus
longue se replie et devient illisible. **Garder chaque ligne ≤ 76 caractères** :
- couper à un point logique : après `(`, après `,`, après `;` (boucles `for`),
  après `=`, avant un opérateur (`+`, `==`, `!=`, `&&`, `||`), avant un `.` de
  chaînage, avant `extends`/`implements`/`throws` ;
- **indentation de continuation de +4 espaces** (jamais à la marge) ;
- chaîne trop longue : la scinder par concaténation `"…" + "…"` ;
- commentaire qui se poursuit : préfixer la suite par `//` (ou `*` en bloc).

### 2.6 Coloration syntaxique
La coloration se fait par la couleur de caractère (`w:color`). **Quatre couleurs
seulement :**

| Catégorie | Couleur | Hex |
|---|---|---|
| Texte ordinaire, identifiants, ponctuation | noir | `000000` |
| Mots-clés | violet | `7F0055` |
| Chaînes et littéraux caractères | bleu | `2A00FF` |
| Commentaires | vert | `008C00` |

N'introduire aucune autre couleur. Les liens hypertexte dans le code conservent
leur couleur de lien.

> **En pratique**, la coloration varie d'un bloc à l'autre (héritage de versions
> antérieures) : plusieurs blocs colorent les **nombres en vert `008C00`**, les
> **`;` `{` `}` en violet `7F0055`**, les **types** (primitifs + noms de classe)
> et **chaînes en bleu `2A00FF`**, le reste (mots-clés, commentaires) en noir.
> **Règle d'or pour toute édition : reproduire exactement le schéma du bloc
> environnant** (voir les couleurs des runs voisins) afin de rester cohérent
> *dans* le bloc.

### 2.7 Sorties console (traces de pile)
Les messages d'erreur reproduisent la **vraie sortie Java** (`printStackTrace`),
en texte simple non coloré :

```
java.lang.NumberFormatException: For input string: "1R"
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at Exemple1.main(Exemple1.java:13)
```

Format : `nom.complet.Exception: message`, puis une ligne
`\tat classe.methode(Fichier.java:ligne)` par appel, en ordre inverse.

### 2.8 Styles de code

| Style | Type | Emploi |
|---|---|---|
| `Code` | paragraphe | **Bloc de code principal** |
| `CodeJava`, `CodeJava9pt`, `codeCompact`, `SQL` | paragraphe | Variantes (même rendu) |
| `Textebrut`, `Textedemacro`, `PrformatHTML` | paragraphe | Texte préformaté |
| `EnteteCode` | paragraphe | Entête de fichier (§2.3) |
| `CODE0`, `CodeHTML`, `SQLCar`, `PrformatHTMLCar` | caractère | Code **en ligne** |

➡️ Nouveau bloc : style **`Code`**. Code dans une phrase : style de caractère
`CODE0` (ou, à défaut, police Consolas sur la sélection).

## 3. Texte courant et titres

### 3.1 Styles principaux

| Style | Police / taille | Rôle |
|---|---|---|
| `Corpsdetexte` | Garamond 12 pt, justifié | **Texte courant** |
| `Corpslivre` | Times 12 pt, justifié | Variante de corps de texte |
| `Cencadr` | Garamond 10 pt | Encadrés |
| `Lgende` | Garamond 10 pt | Légendes de figures |
| `Titre1` / `Titre2` / `Titre3` | Arial Black, gris foncé `1A1A1A` | Chapitre / section / sous-section |
| `TM1` / `TM2` / `TM3` | Times New Roman | Table des matières (générée) |

Les titres sont en **`1A1A1A`** (quasi noir) : un gris pâle « délavé » nuit à la
lisibilité et à l'autorité des titres.

### 3.2 Espacement des titres (par le style, jamais à la main)
Tous les titres d'un même niveau sont identiques, l'espacement étant défini dans
le style :

| Style | `before` | `after` |
|---|---|---|
| `Titre1` | 240 (12 pt) | 120 (6 pt) |
| `Titre2` | 180 (9 pt) | 90 (4,5 pt) |
| `Titre3` | 120 (6 pt) | 60 (3 pt) |

Ne **jamais** insérer de paragraphe vide pour espacer un titre (sauf saut de page
volontaire en début de chapitre) ni appliquer d'espacement direct sur un titre.

## 4. Ouvertures de chapitre

Chaque chapitre numéroté s'ouvre de façon **uniforme** :
- **Épigraphe** juste après le titre, style **`Sous-titredechapitre`**, au format
  `« citation » — Auteur` ;
- **Lettrine** (drop cap) sur la première lettre du premier paragraphe : style
  **`Corpsdetextegarder`**, `framePr w:dropCap="drop" w:lines="3"`, lettre en
  `caps` à `sz=114`.

Veiller à ce qu'aucun paragraphe vide ne suive immédiatement le paragraphe à
lettrine, sinon le texte ne s'enroule pas autour de la lettre et un vide
disgracieux apparaît à sa droite.

## 5. Mise en page

### 5.1 Page de titre (intérieure)
La **couverture** est fournie séparément ; cette page est la page de titre
*intérieure*. Titre, sous-titre, auteurs et édition **centrés** ; titre en Arial
Black 32 pt (capitales) souligné d'un filet ; sous-titre en italique.
- **Touche de couleur :** le titre « JAVA PAS À PAS » est en **bleu profond
  `1F4E79`** (le reste demeure quasi noir). Sobriété : une seule couleur d'accent.
- Ne **pas** transformer cette page en couverture pleine page colorée.

### 5.2 En-têtes courants (running heads)
`evenAndOddHeaders` activé. Trois en-têtes : `header1` =
`STYLEREF "heading 2"` (section, recto), `header2` = `STYLEREF "heading 1"`
(chapitre, verso), `header3` = **vide**.
- **Verso** (pages paires) : titre de **chapitre**, ferré à gauche.
- **Recto** (pages impaires) : titre de **section**, ferré à droite.
- **Aucun en-tête** sur : la **page de titre**, les **pages liminaires**
  (préface, table des matières) et **chaque page d'ouverture de chapitre**.
- Mise en œuvre : le document est découpé en **sections** — une pour les pages
  liminaires (en-têtes vides) et **une par chapitre**. Chaque section de chapitre
  a `titlePg` activé avec l'en-tête de première page = `header3` (vide), si bien
  que la page d'ouverture du chapitre n'a pas d'en-tête. Saut de section
  `type=nextPage` ; retirer alors le saut de page manuel (`<w:br w:type="page"/>`)
  pour éviter une page blanche en double.
- Filet fin sous l'en-tête. Numéros de page dans les pieds de page.

## 6. Typographie française
- **Apostrophe** typographique « ’ » dans la prose. *Exception :* garder
  l'apostrophe droite « ' » dans le **code** (littéraux `'a'`, `'\n'`, chaînes).
- **Guillemets** français « … » avec **espace insécable** à l'intérieur.
- **Espace insécable** (U+00A0) avant `: ; ! ?` (jamais dans le code).
- **Pas d'espace** avant la virgule ni le point ; **pas de double espace**.
- Points de suspension : caractère « … ».
- **Langue** du document : `fr-CA`.

## 7. Pages liminaires et annexes
- Une section **« À propos des auteurs »** (non numérotée) figure en fin d'ouvrage.
- **Pas d'index** des termes.

## 8. Règles pour les modifications futures
1. **Code** → style `Code` (bloc) ou `CODE0`/Consolas (en ligne) ; jamais d'autre
   police, jamais justifié, jamais > 76 caractères par ligne.
2. **Coloration** → uniquement les 4 couleurs du §2.6.
3. **Aucun copier-coller** de mise en forme depuis le web : coller en **texte
   brut**, puis appliquer les styles (évite les polices et noms de police
   corrompus, p. ex. `&quot;`).
4. **Apostrophes** typographiques dans la prose, droites dans le code ; espaces
   insécables avant la ponctuation double et dans les guillemets.
5. **Espacement** du code et des titres géré par les styles, jamais par des lignes
   vides ou des réglages directs.
6. Conserver l'uniformité des **ouvertures de chapitre** (épigraphe + lettrine).
7. **Langue `fr-CA`** pour tout nouveau texte.
8. Ne pas recréer de styles de débogage ou de doublons (le jeu de styles a été
   nettoyé ; les styles standard inutilisés du gabarit Word sont conservés).

## 9. À vérifier dans Word avant publication
1. **Tout sélectionner puis F9** pour mettre à jour les champs : table des matières,
   numéros de figures (`SEQ`/`REF`) et en-têtes courants (`STYLEREF`). La **table
   des matières** (numéros de page) devient périmée après des modifications qui
   décalent la pagination ; il faut donc la régénérer (clic droit → *Mettre à jour
   les champs* → *Mettre à jour toute la table*).
   ⚠️ Ne **pas** forcer `<w:updateFields w:val="true"/>` dans `settings.xml` :
   Word affiche alors une boîte de dialogue « mettre à jour les champs ? » qui
   **bloque** la conversion `docx2pdf` automatisée. Rafraîchir manuellement.
2. Contrôler visuellement les **lettrines** (3 lignes) et la **page de titre**.
3. Si un en-tête affiche « Erreur… », vérifier que le champ `STYLEREF` cible bien
   le nom de style « heading 1 » / « heading 2 ».
4. Vérifier qu'aucune **page blanche** parasite n'a été introduite par les sauts
   de section (ouvertures de chapitre).

> **Décision — numérotation des dossiers de code.** Les libellés (`chapitre_2` …
> `chapitre_9`) pointent vers les dossiers **réels** du dépôt ; ils ne suivent pas
> la numérotation des chapitres (le chapitre 4 « Types et expressions » n'a pas de
> dossier propre, d'où un décalage de −1 à partir du chapitre 5). **Convention
> retenue : laisser tel quel** — les libellés correspondent aux fichiers source
> réels, ce qui prime.

## 10. Figures et diagrammes UML

Les diagrammes (séquence, activité, classes, hiérarchie, package) sont **recréés
en SVG moderne**, convertis en **EMF** (vectoriel) puis insérés. Style commun :

- **Génération par script** (SVG), puis **texte vectorisé en tracés** à l'export
  EMF (Inkscape : `--actions="select-all;object-to-path"`) pour que les polices
  rendent à l'identique partout. Insérés comme **image DrawingML en ligne**
  (remplacer les anciens objets VML/OLE).
- **Palette sobre** : texte/traits gris ardoise `37474F` ; accents par
  participant/classe (bleu `1E88E5`, vert `43A047`, ambre `FB8C00`, violet
  `8E24AA`, etc.) sur fonds clairs ; libellés de code en **Consolas**, noms en
  sans-serif.
- **Conventions UML** :
  - *Séquence* : lignes de vie pointillées, **barres d'activation**, appel = trait
    plein + tête pleine, retour = trait **pointillé** + tête ouverte.
  - *Activité* : nœud initial plein, nœud final cerclé, actions arrondies, losange
    de décision ambre, gardes `[condition]`.
  - *Classes* : 3 compartiments (nom / attributs / méthodes), visibilité
    `+` `-` `#`, **statique souligné**, **abstrait en italique** ; généralisation =
    trait plein + **triangle creux** ; dépendance = **pointillé + flèche ouverte**.
- **Largeur des boîtes calculée à partir de la largeur de texte mesurée** (rendu +
  mesure des pixels) pour éviter tout débordement.
- **Placement** : en ligne, **centré**, largeur ≤ ~335 pt (colonne).
- Scripts de génération conservés (à régénérer en cas de modification).

## 11. Captures d'écran

- Toute capture (fenêtre, dialogue) reçoit un **cadre élégant** : filet fin à
  **coins arrondis**, un peu de **blanc** entre le filet et la capture, et les
  **coins de la capture arrondis**. **Centrée** sur la page.
- Les **diagrammes** ne sont **pas** encadrés (seules les vraies captures le sont).
- ⚠️ **`srcRect`** : si l'image porte un recadrage Word, recadrer l'image source
  **avant** d'ajouter le cadre, puis retirer le `srcRect` — sinon le recadrage
  rogne le cadre ajouté.

## 12. Tableaux

- **Bordures fines uniformes** : `single`, `sz=4`, couleur `A6A6A6` (intérieures
  et extérieures). **Jamais** de bordures `outset`/`inset`/`double` (effet
  3D/ombre).
- **Aucun `tblCellSpacing`** (cellules jointives ; pas d'effet « cellules
  séparées »).
- **En-tête** : ligne en **gras**, fond `ECECEC`, `tblHeader` (répétée si le
  tableau s'étend sur plusieurs pages).
- **Police** : Garamond 10 pt (`sz=20`), héritée (référence : le tableau des
  séquences d'échappement). Pas de Courier New parasite dans les cellules.
- Tableau qui dépasse une page : le laisser **se scinder** (ni `cantSplit`, ni
  chaîne de `keepNext` sur toutes les lignes) ; seul l'en-tête se répète.

## 13. Cohérence livre ↔ code source

Les blocs de code du manuel sont des **copies** des fichiers `.java` des dossiers
`chapitre_*/` et `JeuSimple/`. Toute correction d'un bloc de code (logique,
commentaire, chaîne affichée) doit être **répercutée dans le fichier source**
correspondant, et inversement, afin que le livre et le dépôt restent cohérents.
