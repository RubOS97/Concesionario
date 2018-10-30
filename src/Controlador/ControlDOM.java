package Controlador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ControlDOM {

    //De XML a DOM
    public Document deXMLaDOM() throws ParserConfigurationException {
        Document doc = null;
        doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        return doc;
    }

    public Document deXMLaDOM(File fXmlFile) throws ParserConfigurationException, IOException, SAXException {
        Document doc = null;
        doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    //De DOM a XML
    public static void deDOMaXML(Document doc, File file) throws TransformerConfigurationException, TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes"); //indentar XML

        StreamResult result = new StreamResult(file);
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
    }

    //Obtener ATRIBUTO
    public static String getAtributoEtiqueta(Element elemento, String ETIQUETA) {
        return elemento.getAttribute(ETIQUETA);
    }

    //Obtener ETIQUETAS
    public static Element getElementEtiqueta(String ETIQUETA, Element elemento) {
        return (Element) elemento.getElementsByTagName(ETIQUETA).item(0);
    }

    //Obtener VALOR de las etiquetas
    public static String getValorEtiqueta(String ETIQUETA, Element elemento) {
        Node nValue = elemento.getElementsByTagName(ETIQUETA).item(0);
        return nValue.getChildNodes().item(0).getNodeValue();
    }
}
