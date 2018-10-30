package Controlador;

import Modelo.Coche;
import Modelo.Tienda;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class ControlTienda extends ControlDOM {

    Tienda tienda = null;

    public ControlTienda() {
        this.tienda = new Tienda();
    }
    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Document Recuperar(File file) throws IOException, SAXException, ParserConfigurationException {
        Document doc = null;
        doc = deXMLaDOM(file);
        return doc;
    }

    public Tienda Leer(Document doc) {
        Element elemTienda = doc.getDocumentElement();
        NodeList listaCoches = elemTienda.getChildNodes();

        for (int i = 0; i < listaCoches.getLength(); i++) {
            if (listaCoches.item(i).getNodeType() == Node.ELEMENT_NODE) {
                tienda.add(ControlCoche.LeerCoche((Element) listaCoches.item(i)));
            }
        }
        return tienda;
    }

    public void Escribir(Document doc) {
        Element elemTienda = doc.createElement("tienda");

        for (Coche coche : tienda) {
            ControlCoche.EscribirCoche(doc, elemTienda, coche);
        }

        doc.appendChild(elemTienda);
    }

    public void Guardar(File f, Document doc) throws TransformerException {
        deDOMaXML(doc, f);
    }

}