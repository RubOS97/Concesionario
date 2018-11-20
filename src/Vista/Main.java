package Vista;

import Controlador.ControlDOM;
import Controlador.ControlTienda;
import DAO.Conexion_BD;
import DAO.TiendaDAO;
import Modelo.Coche;
import Modelo.Motor;
import Modelo.Tienda;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner tec = new Scanner(System.in);
        int opcion = 0;

        ControlDOM controlDOM =new ControlDOM();
        ControlTienda controlTienda = new ControlTienda();
        Document doc = null;
        File file1 = new File("coches.xml");
        File file2 = new File("coches_Final.xml");
        Tienda tienda = null;

        Conexion_BD conex = new Conexion_BD();
        Connection con  = conex.AbrirConexion();
        TiendaDAO tiendaDAO = new TiendaDAO();

        do {
            menu();
            opcion = tec.nextInt();
            tec.nextLine();

            switch (opcion){
                case 1:
                    doc = controlTienda.Recuperar(file1);
                    break;

                case 2:
                    tienda = controlTienda.Leer(doc);
                    break;

                case 3:
                    System.out.println(tienda);
                    break;

                case 4:
                    tienda = generarTienda();
                    controlTienda.setTienda(tienda);
                    break;

                case 5:
                    doc = controlDOM.deXMLaDOM();
                    controlTienda.Escribir(doc);
                    break;

                case 6:
                    controlTienda.Guardar(file2, doc);
                    break;
                case 7:
                    tiendaDAO.cargarDatos(tienda, con);
                    break;
                case 8:
                    tiendaDAO.descargarDatos(tienda, con);
                    break;
            }
        }while (opcion != 0);
        System.out.println("Conexión cerrada");
        conex.CerrarConexion(con);
    }

    public static void menu(){
        System.out.println("1. Recuperar (XML a DOM)");
        System.out.println("2. Leer (DOM a OBJETO)");
        System.out.println("3. Mostrar datos");
        System.out.println("4. Añadir coches de ejemplo");
        System.out.println("5. Escribir (OBJETO a DOM)");
        System.out.println("6. Guardar (DOM a XML)");
        System.out.println("7. Cargar Base de Datos");
        System.out.println("8. Descargar Base de Datos");
        System.out.println("0. Salir");
    }

    private static Tienda generarTienda(){
        Tienda tienda = new Tienda();
        ArrayList<Motor>motores = new ArrayList<Motor>();
        Coche coche;
        Motor motor;
        Motor motor2;

        coche = new Coche(1000, "Ford", "Mondeo", "cinco");
        motor = new Motor("Gasolina", "120cv");
        motor2 = new Motor("Gas", "20cv");
        motores.add(motor);
        motores.add(motor2);
        coche.setListaMotores(motores);
        tienda.add(coche);

        return tienda;
    }
}