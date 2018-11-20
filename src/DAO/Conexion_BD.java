package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion_BD {

    public Connection AbrirConexion() throws Exception {
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        String urlOdbc = "jdbc:mysql://localhost:3306/concesionario";
        con = java.sql.DriverManager.getConnection(urlOdbc, "root", "");

        return con;
    }

    public void CerrarConexion(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("Error, la conexión no se puede cerrar.");
                e.printStackTrace();
            }
        }
    }
}
