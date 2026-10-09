# Transforme l'AST pandoc (docx+styles) de Java pas à pas en un AST propre
# pour l'EPUB : blocs de code, encadrés, légendes, images PNG.
import json, os, re, subprocess, sys

ICI = os.getcwd()  # dossier de construction
src, dst = sys.argv[1], sys.argv[2]
d = json.load(open(src))

CODE = {'Code': 'java', 'CodeJava9pt': 'java', 'codeCompact': 'java',
        'CodeJava': 'java', 'SQL': 'sql'}
LARGEUR_TEXTE = 6639 / 1440  # pouces
manquants = []


def style(b):
    if b['t'] != 'Div':
        return None
    return dict(b['c'][0][2]).get('custom-style')


def texte(x):
    """Texte brut d'une liste d'éléments en ligne ou de blocs."""
    if isinstance(x, list):
        return ''.join(texte(e) for e in x)
    t = x['t']
    if t == 'Str':
        return x['c']
    if t in ('Space', 'SoftBreak'):
        return ' '
    if t == 'LineBreak':
        return '\n'
    if t == 'Code':
        return x['c'][1]
    if t == 'Math':
        return x['c'][1]
    if t in ('Para', 'Plain', 'Emph', 'Strong', 'Underline', 'SmallCaps',
             'Superscript', 'Subscript', 'Strikeout'):
        return texte(x['c'])
    if t in ('Span', 'Link', 'Div'):
        return texte(x['c'][1])
    if t == 'Quoted':
        q = '"' if x['c'][0]['t'] == 'DoubleQuote' else "'"
        return q + texte(x['c'][1]) + q
    if t == 'Note':
        return ''
    return ''


def math_inline(tex):
    """Convertit les petites expressions (2^{7}, \\times) en texte."""
    out, i = [], 0
    tex = tex.replace('\\times', '×').replace('\\ ', ' ')
    for m in re.finditer(r'([_^])\{([^}]*)\}', tex):
        if m.start() > i:
            out.append({'t': 'Str', 'c': tex[i:m.start()]})
        out.append({'t': 'Subscript' if m.group(1) == '_' else 'Superscript',
                    'c': [{'t': 'Str', 'c': m.group(2)}]})
        i = m.end()
    if i < len(tex):
        out.append({'t': 'Str', 'c': tex[i:]})
    return out


def image(el):
    attr, alt, (cible, titre) = el['c']
    base, ext = os.path.splitext(cible)
    nom = os.path.basename(base)
    ext = ext.lower()
    if ext in ('.emf', '.wmf'):
        png = os.path.join('png', nom + '.png')
        if not os.path.exists(os.path.join(ICI, png)):
            manquants.append(cible)
        cible = png
    elif ext == '.svg':
        png = os.path.join('png', nom + '.png')
        subprocess.run(['rsvg-convert', '-z', '3', '-b', 'white', '-o',
                        os.path.join(ICI, png), os.path.join(ICI, cible)],
                       check=True)
        cible = png
    kv = dict(attr[2])
    largeur = kv.get('width', '')
    nouv = []
    if largeur.endswith('in'):
        pc = min(100, round(100 * float(largeur[:-2]) / LARGEUR_TEXTE))
        nouv.append(['width', f'{pc}%'])
    el['c'] = [[attr[0], attr[1], nouv], alt, [cible, titre]]
    return el


def en_ligne(lst):
    out = []
    for e in lst:
        t = e['t']
        if t == 'Span':
            st = dict(e['c'][0][2]).get('custom-style')
            contenu = en_ligne(e['c'][1])
            if st == 'HTML Code':
                out.append({'t': 'Code', 'c': [['', [], []], texte(contenu)]})
            elif st is not None:
                out.extend(contenu)
            else:
                e['c'][1] = contenu
                out.append(e)
            continue
        if t == 'Math':
            out.extend(math_inline(e['c'][1]))
            continue
        if t == 'Image':
            out.append(image(e))
            continue
        if t in ('Emph', 'Strong', 'Underline', 'Superscript', 'Subscript',
                 'SmallCaps', 'Strikeout'):
            e['c'] = en_ligne(e['c'])
        elif t in ('Link',):
            e['c'][1] = en_ligne(e['c'][1])
        elif t == 'Quoted':
            e['c'][1] = en_ligne(e['c'][1])
        elif t == 'Note':
            e['c'] = blocs(e['c'])
        out.append(e)
    return out


def div(classe, contenu):
    return {'t': 'Div', 'c': [['', [classe], []], contenu]}


def blocs(lst):
    out, i = [], 0
    while i < len(lst):
        b = lst[i]
        st = style(b)
        if st in CODE:
            lignes, lang = [], CODE[st]
            while i < len(lst) and style(lst[i]) in CODE:
                lignes.append(texte(lst[i]['c'][1]))
                i += 1
            code = '\n'.join(lignes).replace(' ', ' ')
            code = '\n'.join(l.rstrip() for l in code.split('\n')).strip('\n')
            out.append({'t': 'CodeBlock', 'c': [['', [lang], []], code]})
            continue
        if st in ('C encadré', 'encadré'):
            contenu = []
            while i < len(lst) and style(lst[i]) in ('C encadré', 'encadré'):
                contenu += blocs(lst[i]['c'][1])
                i += 1
            out.append(div('encadre', contenu))
            continue
        i += 1
        if st and st.startswith('toc '):
            continue
        if st == 'Entête de code':
            out.append(div('entete-code', blocs(b['c'][1])))
        elif st == 'caption':
            out.append(div('legende', blocs(b['c'][1])))
        elif st == 'Sous-titre de chapitre':
            out.append(div('epigraphe', blocs(b['c'][1])))
        elif st is not None:
            out.extend(blocs(b['c'][1]))
        elif b['t'] in ('Para', 'Plain'):
            b['c'] = en_ligne(b['c'])
            # Paragraphe vide ou fait d'espaces : on l'omet
            if b['c'] and texte(b['c']).strip() or any(
                    e['t'] == 'Image' for e in b['c']):
                out.append(b)
        elif b['t'] == 'Header':
            b['c'][2] = en_ligne(b['c'][2])
            titre = texte(b['c'][2]).strip()
            if titre in ('Préface', 'À propos des auteurs'):
                b['c'][1][1].append('unnumbered')
            out.append(b)
        elif b['t'] == 'Div':
            b['c'][1] = blocs(b['c'][1])
            out.append(b)
        elif b['t'] in ('BulletList', 'OrderedList'):
            if b['t'] == 'BulletList':
                b['c'] = [blocs(item) for item in b['c']]
            else:
                b['c'][1] = [blocs(item) for item in b['c'][1]]
            out.append(b)
        elif b['t'] == 'BlockQuote':
            b['c'] = blocs(b['c'])
            out.append(b)
        elif b['t'] == 'Figure':
            b['c'][2] = blocs(b['c'][2])
            b['c'][1][1] = blocs(b['c'][1][1])
            out.append(b)
        elif b['t'] == 'Table':
            def cellules(rangs):
                for r in rangs:
                    for c in r[1]:
                        c[4] = blocs(c[4])
            tab = b['c']
            cellules(tab[3][1])
            for corps in tab[4]:
                cellules(corps[2]); cellules(corps[3])
            cellules(tab[5][1])
            out.append(b)
        elif b['t'] == 'DisplayMath':
            out.append(b)
        else:
            out.append(b)
    return out


bl = d['blocks']
# Page de titre du manuscrit : remplacée par celle de l'EPUB
premier = next(k for k, b in enumerate(bl) if b['t'] == 'Header')
d['blocks'] = blocs(bl[premier:])
json.dump(d, open(dst, 'w'))
if manquants:
    print('Images manquantes :', manquants)
