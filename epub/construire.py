#!/usr/bin/env python3
"""Construit JavaPasAPas.epub à partir de JavaPasAPas.docx.

Usage : python3 epub/construire.py [--docx F.docx] [--sortie F.epub]

Étapes :
  1. copie du docx et préparation des paragraphes de code (espaces
     insécables pour garder l'indentation, lignes vides conservées) ;
  2. rendu des images EMF/WMF (illisibles sur Kindle) en PNG à 300 ppp par
     Microsoft Word (docx2pdf) ; les rendus sont mis en cache dans
     epub/cache_png/ selon le contenu de l'image, donc Word n'est requis que
     pour les images nouvelles ou modifiées ;
  3. conversion pandoc (docx+styles -> JSON), transformation par
     transformer.py, puis pandoc -> EPUB 3 ;
  4. validation par epubcheck s'il est installé.

Outils requis : pandoc, rsvg-convert, python3 avec lxml, PyMuPDF et Pillow ;
docx2pdf et Microsoft Word seulement si le cache est incomplet.
"""
import argparse, hashlib, json, os, shutil, subprocess, sys, time, zipfile
from lxml import etree

ICI = os.path.dirname(os.path.abspath(__file__))
DEPOT = os.path.dirname(ICI)
CACHE = os.path.join(ICI, 'cache_png')
BUILD = os.path.join(ICI, 'build')

W = 'http://schemas.openxmlformats.org/wordprocessingml/2006/main'
R = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships'
A = 'http://schemas.openxmlformats.org/drawingml/2006/main'
V = 'urn:schemas-microsoft-com:vml'
NS = {'w': W}
CODE = {'Code', 'CodeJava9pt', 'codeCompact', 'CodeJava', 'SQL'}
NBSP = ' '


def q(t):
    return '{%s}%s' % (W, t)


def dezipper(docx, dossier):
    shutil.rmtree(dossier, ignore_errors=True)
    with zipfile.ZipFile(docx) as z:
        z.extractall(dossier)


def zipper(dossier, docx):
    if os.path.exists(docx):
        os.remove(docx)
    with zipfile.ZipFile(docx, 'w', zipfile.ZIP_DEFLATED) as z:
        z.write(os.path.join(dossier, '[Content_Types].xml'),
                '[Content_Types].xml')
        for racine, _, fichiers in os.walk(dossier):
            for f in sorted(fichiers):
                chemin = os.path.join(racine, f)
                nom = os.path.relpath(chemin, dossier)
                if nom != '[Content_Types].xml':
                    z.write(chemin, nom)


def preparer_code(dossier):
    """Espaces insécables dans le code et lignes vides non vides."""
    p_doc = os.path.join(dossier, 'word', 'document.xml')
    doc = etree.parse(p_doc)
    n = 0
    for p in doc.iter(q('p')):
        st = p.find('w:pPr/w:pStyle', NS)
        if st is None or st.get(q('val')) not in CODE:
            continue
        n += 1
        for e in list(p.iter(q('t'), q('tab'))):
            if e.tag == q('tab'):
                if e.getparent().tag == q('r'):
                    t = etree.Element(q('t'))
                    t.text = NBSP * 4
                    e.getparent().replace(e, t)
            elif e.text:
                e.text = e.text.replace(' ', NBSP).replace('\t', NBSP * 4)
        vide = not ''.join(t.text or '' for t in p.iter(q('t'))).strip(NBSP + ' ')
        if vide and next(p.iter('{%s}blip' % A), None) is None:
            etree.SubElement(etree.SubElement(p, q('r')), q('t')).text = NBSP
    doc.write(p_doc, xml_declaration=True, encoding='UTF-8', standalone=True)
    print(f'{n} paragraphes de code préparés')


def images_emf(dossier):
    """Liste ordonnée des (cible, run) des images EMF/WMF du document."""
    rels = etree.parse(os.path.join(dossier, 'word', '_rels',
                                    'document.xml.rels'))
    cible = {r.get('Id'): r.get('Target') for r in rels.getroot()}
    doc = etree.parse(os.path.join(dossier, 'word', 'document.xml'))
    vues, res = set(), []
    for r in doc.getroot().iter(q('r')):
        ids = [b.get('{%s}embed' % R) for b in r.iter('{%s}blip' % A)]
        ids += [b.get('{%s}id' % R) for b in r.iter('{%s}imagedata' % V)]
        for i in ids:
            t = cible.get(i, '')
            if t.lower().endswith(('.emf', '.wmf')) and t not in vues:
                vues.add(t)
                res.append((t, r))
    return doc, res


def empreinte(chemin):
    return hashlib.sha1(open(chemin, 'rb').read()).hexdigest()


def osa(*lignes, delai=60):
    args = ['osascript']
    for l in lignes:
        args += ['-e', l]
    return subprocess.run(args, capture_output=True, text=True,
                          timeout=delai + 30)


def rendre_par_word(dossier, doc, a_rendre):
    """Rend les images EMF/WMF dans un docx temporaire, une par page."""
    import copy
    import fitz
    from PIL import Image, ImageChops
    try:
        from docx2pdf import convert
    except ImportError:
        sys.exit('docx2pdf est requis pour rendre les nouvelles images EMF.')
    tmp = os.path.join(BUILD, 'emfdoc')
    shutil.rmtree(tmp, ignore_errors=True)
    shutil.copytree(dossier, tmp)
    racine = copy.deepcopy(doc.getroot())
    body = racine.find('w:body', NS)
    sect = copy.deepcopy(body.find('w:sectPr', NS))
    for c in list(body):
        body.remove(c)
    for k, (_, r) in enumerate(a_rendre):
        p = etree.SubElement(body, q('p'))
        p.append(copy.deepcopy(r))
        if k < len(a_rendre) - 1:
            br = etree.SubElement(etree.SubElement(p, q('r')), q('br'))
            br.set(q('type'), 'page')
    for e in list(sect):
        nom = etree.QName(e).localname
        if nom == 'pgSz':
            e.set(q('w'), '17280')
            e.set(q('h'), '17280')
        elif nom == 'pgMar':
            for a in ('top', 'bottom', 'left', 'right'):
                e.set(q(a), '720')
            e.set(q('gutter'), '0')
        elif nom in ('headerReference', 'footerReference', 'titlePg',
                     'pgNumType'):
            sect.remove(e)
    body.append(sect)
    etree.ElementTree(racine).write(
        os.path.join(tmp, 'word', 'document.xml'),
        xml_declaration=True, encoding='UTF-8', standalone=True)
    # Word (bac à sable) n'ouvre sans dialogue que les fichiers du dépôt
    nom_tmp = f'_emf_tmp_{os.getpid()}.docx'
    docx = os.path.join(DEPOT, nom_tmp)
    pdf = os.path.join(BUILD, 'emf.pdf')
    zipper(tmp, docx)
    try:
        chemin_mac = 'Macintosh HD' + docx.replace('/', ':')
        print(f'Rendu de {len(a_rendre)} images EMF/WMF par Word…')
        r = osa('with timeout of 180 seconds',
                f'tell application "Microsoft Word" to open file name '
                f'"{chemin_mac}"', 'end timeout', delai=180)
        time.sleep(3)
        actif = osa('tell application "Microsoft Word" to get name of '
                    'active document').stdout.strip()
        if actif != nom_tmp:
            sys.exit(f'Word n\'a pas ouvert {nom_tmp} (document actif : '
                     f'{actif!r}; {r.stderr.strip()}). Réessayez quand Word '
                     f'est libre.')
        # docx2pdf convertit le document actif de Word
        convert(docx, pdf)
        osa('tell application "Microsoft Word" to close (first document '
            f'whose name is "{nom_tmp}") saving no')
    finally:
        os.remove(docx)
    pages = fitz.open(pdf)
    if len(pages) != len(a_rendre):
        sys.exit(f'{len(pages)} pages rendues pour {len(a_rendre)} images.')
    os.makedirs(CACHE, exist_ok=True)
    for (cible, _), page in zip(a_rendre, pages):
        pix = page.get_pixmap(matrix=fitz.Matrix(300 / 72, 300 / 72))
        im = Image.frombytes('RGB', (pix.width, pix.height), pix.samples)
        bb = ImageChops.difference(im, Image.new('RGB', im.size,
                                                 'white')).getbbox()
        im = im.crop((max(0, bb[0] - 12), max(0, bb[1] - 12),
                      min(im.width, bb[2] + 12), min(im.height, bb[3] + 12)))
        h = empreinte(os.path.join(dossier, 'word', cible))
        im.save(os.path.join(CACHE, h + '.png'), optimize=True)


def images_png(dossier):
    """Place dans build/png/ un PNG pour chaque image EMF/WMF."""
    doc, imgs = images_emf(dossier)
    a_rendre = [(c, r) for c, r in imgs if not os.path.exists(
        os.path.join(CACHE, empreinte(os.path.join(dossier, 'word', c))
                     + '.png'))]
    print(f'{len(imgs)} images EMF/WMF, {len(a_rendre)} à rendre')
    if a_rendre:
        rendre_par_word(dossier, doc, a_rendre)
    os.makedirs(os.path.join(BUILD, 'png'), exist_ok=True)
    for c, _ in imgs:
        nom = os.path.splitext(os.path.basename(c))[0] + '.png'
        h = empreinte(os.path.join(dossier, 'word', c))
        shutil.copy(os.path.join(CACHE, h + '.png'),
                    os.path.join(BUILD, 'png', nom))


def couverture():
    """Couverture 1600 × 2560 : titre sur fond bleu, illustration dessous."""
    sortie = os.path.join(ICI, 'couverture.jpg')
    if os.path.exists(sortie):
        return sortie
    from PIL import Image, ImageDraw, ImageFont
    art = Image.open(os.path.join(DEPOT, 'cover.png')).convert('RGB')
    art = art.resize((1600, 1600), Image.LANCZOS)
    L, H = 1600, 2560
    c = Image.new('RGB', (L, H))
    d = ImageDraw.Draw(c)
    for y in range(H - 1600):
        t = y / (H - 1600)
        d.line([0, y, L, y], fill=(int(18 + 20 * t), int(48 + 40 * t),
                                   int(92 + 50 * t)))
    c.paste(art, (0, H - 1600))

    def police(taille, gras=False):
        return ImageFont.truetype('/System/Library/Fonts/Helvetica.ttc',
                                  taille, index=1 if gras else 0)

    def centre(y, texte, f, couleur):
        d.text(((L - d.textlength(texte, font=f)) / 2, y), texte, font=f,
               fill=couleur)
    centre(150, 'Java pas à pas', police(170, True), 'white')
    centre(380, 'Introduction à la programmation', police(70), (220, 232, 245))
    centre(470, 'et au langage Java', police(70), (220, 232, 245))
    centre(650, 'Robert Godin   ·   Daniel Lemire', police(66, True), 'white')
    centre(780, 'Cinquième édition', police(54), (255, 214, 102))
    c.save(sortie, quality=92)
    return sortie


def main():
    ap = argparse.ArgumentParser(description=__doc__.split('\n')[0])
    ap.add_argument('--docx', default=os.path.join(DEPOT, 'JavaPasAPas.docx'))
    ap.add_argument('--sortie', default=os.path.join(DEPOT, 'JavaPasAPas.epub'))
    args = ap.parse_args()

    shutil.rmtree(BUILD, ignore_errors=True)
    os.makedirs(BUILD)
    dossier = os.path.join(BUILD, 'docx')
    dezipper(args.docx, dossier)
    preparer_code(dossier)
    images_png(dossier)
    pre = os.path.join(BUILD, 'pre.docx')
    zipper(dossier, pre)

    def lancer(*cmd):
        subprocess.run(cmd, check=True, cwd=BUILD)
    lancer('pandoc', '-f', 'docx+styles', pre, '-t', 'json',
           '--extract-media=.', '-o', 'pre.json')
    lancer(sys.executable, os.path.join(ICI, 'transformer.py'), 'pre.json',
           'propre.json')
    lancer('pandoc', '-f', 'json', 'propre.json',
           '--metadata-file=' + os.path.join(ICI, 'meta.yaml'),
           '-o', os.path.abspath(args.sortie), '--toc', '--toc-depth=2',
           '--split-level=1', '--number-sections',
           '--css', os.path.join(ICI, 'livre.css'),
           '--epub-cover-image', couverture(), '--resource-path=.',
           '--syntax-highlighting=pygments')
    print('EPUB écrit :', args.sortie)
    if shutil.which('epubcheck'):
        subprocess.run(['epubcheck', '-q', args.sortie])
    else:
        print('epubcheck absent (brew install epubcheck) : validation omise')


if __name__ == '__main__':
    main()
