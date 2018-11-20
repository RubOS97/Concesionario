package Vista;

import DAO.Conexion_BD;
import DAO.TiendaDAO;
import Modelo.Tienda;

import java.sql.Connection;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Conexion_BD conex = new Conexion_BD();
        Connection con  = conex.AbrirConexion();
        TiendaDAO tiendaDAO = new TiendaDAO();

        Tienda tienda = new Tienda();

        tiendaDAO.descargarDatos(tienda, con);

        System.out.println(tienda);

        /*CocheDAO cocheDAO = new CocheDAO();
        Coche coche = new Coche(20000, "Skoda", "Vision RS", "cinco");
        cocheDAO.insertar(con, coche);*/

        System.out.println("Conexión cerrada");
        conex.CerrarConexion(con);
    }
}