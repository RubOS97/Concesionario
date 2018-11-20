package DAO;

import Modelo.Coche;
import Modelo.Motor;
import Modelo.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TiendaDAO {
    //Cargas y Descargas de todos los elementos de la Base de datos

    public void descargarDatos(Tienda tienda, Connection connection) throws Exception {
        PreparedStatement stmt=null;
        ResultSet rsCoche=null;
        ResultSet rsMotor=null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM coche");
            rsCoche = stmt.executeQuery();

            while (rsCoche.next()){
                Coche coche = new Coche();
                obtenerCocheFila(rsCoche, coche);
                tienda.add(coche);
            }

            for (Coche c : tienda.getTienda()){
                stmt = connection.prepareStatement("SELECT * FROM motor WHERE id_coche=?");
                stmt.setInt(1, c.getId());
                rsMotor = stmt.executeQuery();

                while (rsMotor.next()){
                    Motor motor = new Motor();
                    obtenerMotorFila(rsMotor, motor);
                    c.getListaMotores().add(motor);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rsCoche!=null) rsCoche.close();
            if(stmt!=null) stmt.close();
        }
    }

    public void cargarDatos(Tienda tienda, Connection connection) throws Exception {
        PreparedStatement stmt=null;
        ResultSet rsCoche=null;

       for (Coche c : tienda.getTienda()){
           try {
               stmt = connection.prepareStatement("INSERT INTO coche (marca, modelo, puertas, precio) VALUES(?,?,?,?)");
               stmt.setString(1, c.getMarca());
               stmt.setString(2, c.getModelo());
               stmt.setString(3, c.getPuertas());
               stmt.setInt(4, c.getPrecio());

               stmt.executeUpdate();

               stmt = connection.prepareStatement("SELECT * FROM coche WHERE modelo=?");
               stmt.setString(1, c.getModelo());
               rsCoche = stmt.executeQuery();
               Coche coche = new Coche();
               if (rsCoche.next()){
                   obtenerCocheFila(rsCoche, coche);
               }

               for (Motor m : c.getListaMotores()){
                   stmt = connection.prepareStatement("INSERT INTO motor (id_coche, combustible, potencia) VALUES(?,?,?)");
                   stmt.setInt(1, coche.getId());
                   stmt.setString(2, m.getCombustible());
                   stmt.setString(3, m.getPotencia());
                   stmt.executeUpdate();
               }

           }catch (Exception e){
               System.err.println(e);
           }finally {
               if(stmt!=null) stmt.close();
           }
       }
    }

    private void obtenerCocheFila(ResultSet rsCoche, Coche coche) throws Exception{
        coche.setId(rsCoche.getInt("id_coche"));
        coche.setPrecio(rsCoche.getInt("precio"));
        coche.setMarca(rsCoche.getString("marca"));
        coche.setModelo(rsCoche.getString("modelo"));
        coche.setPuertas(rsCoche.getString("puertas"));
    }

    private void obtenerMotorFila(ResultSet rsMotor, Motor motor) throws Exception{
        motor.setId(rsMotor.getInt("id_motor"));
        motor.setCombustible(rsMotor.getString("combustible"));
        motor.setPotencia(rsMotor.getString("potencia"));
    }

}