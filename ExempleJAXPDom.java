
// Packages de JAXP
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;

import java.io.*;


/**
 * Program to echo a DOM tree using DOM Level 2 interfaces.  Use JAXP to
 * read in and create a DOM tree.  DOM currently does not provide a method
 * to do this.  (This is planned for Level 3.)  See the method main for the
 * three basic steps.  Once the application obtains a DOM Document tree, it
 * dumps out the nodes in the tree and associated node attributes for each
 * node.
 *
 * Notes: Program flags may be used to create possibly non-conformant (but
 * useful) DOM trees.  Program also shows an example of using an
 * ErrorHandler.
 *
 * @author Edwin Goei <edwingo@apache.org>
 */
public class ExempleJAXPDom {
    /** All output will be use this encoding */
//    static final String outputEncoding = "UTF-8";

    /** Output goes here */
    private PrintWriter out;

    /** Indent level */
    private int indent = 0;

    /** Indentation will be in multiples of basicIndent  */
    private final String basicIndent = "  ";

    ExempleJAXPDom(PrintWriter out) {
        this.out = out;
    }

    /**
     * Echo common attributes of a DOM2 Node and terminate output with an
     * EOL character.
     */
    private void printlnCommon(Node n) {
        out.print(" nodeName=\"" + n.getNodeName() + "\"");

        String val = n.getNamespaceURI();
        if (val != null) {
            out.print(" uri=\"" + val + "\"");
        }

        val = n.getPrefix();
        if (val != null) {
            out.print(" pre=\"" + val + "\"");
        }

        val = n.getLocalName();
        if (val != null) {
            out.print(" local=\"" + val + "\"");
        }

        val = n.getNodeValue();
        if (val != null) {
            out.print(" nodeValue=");
            if (val.trim().equals("")) {
                // Whitespace
                out.print("[WS]");
            } else {
                out.print("\"" + n.getNodeValue() + "\"");
            }
        }
        out.println();
    }

    /**
     * Indent to the current level in multiples of basicIndent
     */
    private void outputIndentation() {
        for (int i = 0; i < indent; i++) {
            out.print(basicIndent);
        }
    }

    /**
     * Recursive routine to print out DOM tree nodes
     */
    private void echo(Node n) {
        // Indent to the current level before printing anything
        outputIndentation();

        int type = n.getNodeType();
        switch (type) {
        case Node.ATTRIBUTE_NODE:
            out.print("ATTR:");
            printlnCommon(n);
            break;
        case Node.CDATA_SECTION_NODE:
            out.print("CDATA:");
            printlnCommon(n);
            break;
        case Node.COMMENT_NODE:
            out.print("COMM:");
            printlnCommon(n);
            break;
        case Node.DOCUMENT_FRAGMENT_NODE:
            out.print("DOC_FRAG:");
            printlnCommon(n);
            break;
        case Node.DOCUMENT_NODE:
            out.print("DOC:");
            printlnCommon(n);
            break;
        case Node.DOCUMENT_TYPE_NODE:
            out.print("DOC_TYPE:");
            printlnCommon(n);

            // Print entities if any
            NamedNodeMap nodeMap = ((DocumentType)n).getEntities();
            indent += 2;
            for (int i = 0; i < nodeMap.getLength(); i++) {
                Entity entity = (Entity)nodeMap.item(i);
                echo(entity);
            }
            indent -= 2;
            break;
        case Node.ELEMENT_NODE:
            out.print("ELEM:");
            printlnCommon(n);

            // Print attributes if any.  Note: element attributes are not
            // children of ELEMENT_NODEs but are properties of their
            // associated ELEMENT_NODE.  For this reason, they are printed
            // with 2x the indent level to indicate this.
            NamedNodeMap atts = n.getAttributes();
            indent += 2;
            for (int i = 0; i < atts.getLength(); i++) {
                Node att = atts.item(i);
                echo(att);
            }
            indent -= 2;
            break;
        case Node.ENTITY_NODE:
            out.print("ENT:");
            printlnCommon(n);
            break;
        case Node.ENTITY_REFERENCE_NODE:
            out.print("ENT_REF:");
            printlnCommon(n);
            break;
        case Node.NOTATION_NODE:
            out.print("NOTATION:");
            printlnCommon(n);
            break;
        case Node.PROCESSING_INSTRUCTION_NODE:
            out.print("PROC_INST:");
            printlnCommon(n);
            break;
        case Node.TEXT_NODE:
            out.print("TEXT:");
            printlnCommon(n);
            break;
        default:
            out.print("UNSUPPORTED NODE: " + type);
            printlnCommon(n);
            break;
        }

        // Print children if any
        indent++;
        for (Node child = n.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            echo(child);
        }
        indent--;
    }

    public static void main(String[] args) throws Exception {
        // Step 1: create a DocumentBuilderFactory and configure it
        DocumentBuilderFactory dbf =
            DocumentBuilderFactory.newInstance();

        // Optional: set various configuration options
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);

        // Step 2: create a DocumentBuilder that satisfies the constraints
        // specified by the DocumentBuilderFactory
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException pce) {
            System.err.println(pce);
            System.exit(1);
        }

        // Set an ErrorHandler before parsing
        OutputStreamWriter errorWriter =
            new OutputStreamWriter(System.err);
        db.setErrorHandler(
            new MyErrorHandler(new PrintWriter(errorWriter, true)));

        // Step 3: parse the input file
        Document doc = null;
        try {
            doc = db.parse("C:/forte4j/Development/LivreJava/Plants.xml");
        } catch (SAXException se) {
            System.err.println(se.getMessage());
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println(ioe);
            System.exit(1);
        }

        // Print out the DOM tree
        OutputStreamWriter outWriter =
            new OutputStreamWriter(System.out);
        new ExempleJAXPDom(new PrintWriter(outWriter, true)).echo(doc);
    }

    // Error handler to report errors and warnings
    private static class MyErrorHandler implements ErrorHandler {
        /** Error handler output goes here */
        private PrintWriter out;

        MyErrorHandler(PrintWriter out) {
            this.out = out;
        }

        /**
         * Returns a string describing parse exception details
         */
        private String getParseExceptionInfo(SAXParseException spe) {
            String systemId = spe.getSystemId();
            if (systemId == null) {
                systemId = "null";
            }
            String info = "URI=" + systemId +
                " Line=" + spe.getLineNumber() +
                ": " + spe.getMessage();
            return info;
        }

        // The following methods are standard SAX ErrorHandler methods.
        // See SAX documentation for more info.

        public void warning(SAXParseException spe) throws SAXException {
            out.println("Warning: " + getParseExceptionInfo(spe));
        }
        
        public void error(SAXParseException spe) throws SAXException {
            String message = "Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException spe) throws SAXException {
            String message = "Fatal Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }
    }
}