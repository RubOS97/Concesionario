package Controlador;

import Modelo.Coche;
import Modelo.Motor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;

public class ControlCoche extends ControlDOM{

    private final static String ET_COCHE="coche";
    private final static String ET_MARCA="marca";
    private final static String ET_MODELO="modelo";
    private final static String ET_MOTORES ="motores";
    private final static String ET_MOTOR ="motor";
    private final static String ET_COMBUSTIBLE="combustible";
    private final static String ET_POTENCIA="potencia";
    private final static String ET_PUERTAS="puertas";
    private final static String AT_PRECIO="precio";

    public static Coche LeerCoche(Element elemCoche) {
        Coche coche = new Coche();

        coche.setMarca(getValorEtiqueta(ET_MARCA, elemCoche));
        coche.setModelo(getValorEtiqueta(ET_MODELO, elemCoche));
        coche.setPuertas(getValorEtiqueta(ET_PUERTAS, elemCoche));

        coche.setPrecio(Integer.parseInt(getAtributoEtiqueta(elemCoche, AT_PRECIO)));

        coche.setListaMotores(LeerMotor(getElementEtiqueta(ET_MOTORES, elemCoche)));

        return coche;
    }

    private static ArrayList<Motor> LeerMotor(Element elemMotores) {
        ArrayList<Motor> listaMotor = new ArrayList<Motor>();
        NodeList nListaMotor = elemMotores.getChildNodes();

        for (int i = 0; i < nListaMotor.getLength(); i++) {
            if (nListaMotor.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Motor motor = new Motor();

                motor.setCombustible(getValorEtiqueta(ET_COMBUSTIBLE, (Element)nListaMotor.item(i)));
                motor.setPotencia(getValorEtiqueta(ET_POTENCIA,  (Element)nListaMotor.item(i)));

                listaMotor.add(motor);
            }
        }
        return listaMotor;
    }

    public static void EscribirCoche(Document doc, Element elemTienda, Coche coche) {
        Element elemCoche = doc.createElement(ET_COCHE);
        elemCoche.setAttribute(AT_PRECIO, Integer.toString(coche.getPrecio()));

        Element elemMarca = doc.createElement(ET_MARCA);
        elemMarca.setTextContent(coche.getMarca());
        elemCoche.appendChild(elemMarca);

        Element elemModelo = doc.createElement(ET_MODELO);
        elemModelo.setTextContent(coche.getModelo());
        elemCoche.appendChild(elemModelo);

        Element elemPuertas = doc.createElement(ET_PUERTAS);
        elemPuertas.setTextContent(coche.getPuertas());
        elemCoche.appendChild(elemPuertas);

        Element elemMotores = doc.createElement(ET_MOTORES);
        EscribirMotores(coche, elemMotores, doc);
        elemCoche.appendChild(elemMotores);

        elemTienda.appendChild(elemCoche);
    }

    private static void EscribirMotores(Coche coche, Element elemMotores, Document doc) {
        ArrayList<Motor>listaMotores = coche.getListaMotores();

        for (int i = 0; i < listaMotores.size(); i++) {
            Element elemMotor = doc.createElement(ET_MOTOR);

            Element elemCombustible = doc.createElement(ET_COMBUSTIBLE);
            elemCombustible.setTextContent(listaMotores.get(i).getCombustible());
            elemMotor.appendChild(elemCombustible);

            Element elemPotencia = doc.createElement(ET_POTENCIA);
            elemPotencia.setTextContent(listaMotores.get(i).getPotencia());
            elemMotor.appendChild(elemPotencia);

            elemMotores.appendChild(elemMotor);
        }
    }

}







