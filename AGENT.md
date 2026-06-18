# AGENT.md — working guide for *Java pas à pas*

Guidance for AI coding agents working in this repository.

## What this repo is
- **`JavaPasAPas.docx`** — the manuscript (Word). The primary deliverable.
- **`JavaPasAPas.pdf`** — the rendered book, regenerated from the `.docx`.
- **`chapitre_*/`, `JeuSimple/`, `extra/`** — the Java source files. The code
  **listings inside the book are copies of these files** — keep them in sync.
- **`styleconventions.md`** — the authoritative formatting/style reference. Read it
  before changing the document; update it when a convention changes.
- **`diagrammes/`** — modern SVG/PNG versions of the book's UML figures.

## ⚠️ Do NOT touch `IntroProgrammationPython.docx`
It is the author's *other* book and is often open in Word. Never edit, render, or
save it. Be aware the render step (below) closes open Word documents — warn the
user that unsaved Python work may need recovery if Word had it open.

## Editing the .docx
Word XML is fiddly; edit it programmatically, not by hand.
1. `unzip` the `.docx` to a working dir (it's a ZIP of XML parts).
2. Edit `word/document.xml` (and `styles.xml`, `numbering.xml`, `header*.xml`,
   `settings.xml`, `[Content_Types].xml`, `_rels/document.xml.rels`) with **lxml**
   in Python. Namespace `w = http://…/wordprocessingml/2006/main`.
3. Repackage: `zip -r -X out.docx '[Content_Types].xml' _rels word docProps customXml`.
   Verify with `zipfile.testzip()` and no duplicate entries before deploying.
- A Python venv with lxml/Pillow lives at `/tmp/docxvenv` (recreate if missing).
- Keep a `.bak` before overwriting `JavaPasAPas.docx`.
- `w:sz` is half-points (`16`→8 pt); spacing is in twips (`240`→12 pt).

## Rendering to PDF (the tricky part)
Rendering uses **`docx2pdf`** (drives MS Word). Two hard-won gotchas:
1. **docx2pdf converts Word's *active* document**, not the path you pass. If the
   Python book (or any doc) is open and active, you get the wrong PDF. **Fix:**
   quit Word, `pkill -9 "Microsoft Word"`, remove `~$*.docx` locks, relaunch Word
   fresh, close all docs, *then* run docx2pdf so the target opens as the sole doc.
2. **Wedged Word** after force-kills shows a recovery dialog → AppleScript times
   out (`-1712`/"Message incompréhensible"). Re-`pkill`, wait, relaunch.

Reliable sequence (zsh/macOS):
```sh
osascript -e 'tell application "Microsoft Word" to quit saving no'; sleep 2
pkill -9 "Microsoft Word"; rm -f /…/~$*.docx; sleep 6
open -ga "Microsoft Word"; sleep 12
osascript -l JavaScript -e 'function run(){var w=Application("Microsoft Word");\
  while(w.documents.length>0){w.documents[0].close({saving:"no"});}}'
/tmp/docxvenv/bin/python -c "from docx2pdf import convert; \
  convert('/…/JavaPasAPas.docx','/tmp/out.pdf')"
```
- Do **not** raw-AppleScript `save as … format PDF` (hangs on a modal dialog).
- OpenOffice/LibreOffice headless is unavailable/hangs here.
- Inspect output with `pymupdf` (system `python3 -c "import fitz"`).

## Diagrams (figures)
Generate as **SVG** (Python scripts), then convert to **EMF** for insertion:
`/Applications/Inkscape.app/Contents/MacOS/inkscape in.svg \
  --actions="select-all;object-to-path" --export-type=emf --export-filename=out.emf`
(`object-to-path` makes fonts render identically.) Measure text width with
`rsvg-convert` + Pillow so boxes never overflow. See `styleconventions.md` §10.

## Table of contents
After edits that shift pages, the TOC is stale. **Refresh manually in Word**
(`Cmd+A` → `F9` → update entire table). Do **not** set
`<w:updateFields w:val="true"/>` in `settings.xml` — it makes Word prompt and
hangs the headless render.

## Workflow rules
- **Verify in the rendered PDF** after every change (render figure pages, check
  margins ≤ text width, check for stray blank pages from section breaks).
- Keep book code listings and the `.java` source files **in sync**.
- **Commit/push only when explicitly asked.** This repo's history is on `master`.
- Follow `styleconventions.md`; update it (and this file) when conventions change.
