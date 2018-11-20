package DAO;

import Modelo.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CocheDAO {

    public void actualizar(Connection con, Coche coche) throws SQLException {

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE coche SET marca=?, puertas=?, precio=?, WHERE id_coche=?");
            stmt.setString(1, coche.getMarca());
            stmt.setString(2, coche.getPuertas());
            stmt.setInt(3, coche.getPrecio());
            stmt.setInt(4, coche.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void eliminar(Connection con, Coche coche) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM coche WHERE id_coche=?");
            stmt.setInt(1, coche.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problemas al eliminar el Coche: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertar(Connection con, Coche coche) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO coche (id_coche, marca, modelo, puertas, precio) VALUES(?,?,?,?,?)");
            stmt.setInt(1, coche.getId());
            stmt.setString(2, coche.getMarca());
            stmt.setString(3, coche.getModelo());
            stmt.setString(4, coche.getPuertas());
            stmt.setInt(5, coche.getPrecio());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problemas al insertar cliente " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /*private void obtenClienteFila(ResultSet rs, Cliente cliente) throws Exception{

        cliente.setDNI(rs.getInt("DNI"));
        cliente.setNombre(rs.getString("Nombre"));
        cliente.setApellido1(rs.getString("Ape1"));
        cliente.setApellido2(rs.getString("Ape2"));
        cliente.setNick(rs.getString("Nick"));
        cliente.setPassword(rs.getString("Passwd"));
        cliente.setSaldo(rs.getFloat("Saldo"));
        if(rs.getInt("Moroso")==0){
            cliente.setMoroso(false);
        }
        else{
            cliente.setMoroso(true);
        }
    }

    public Cliente findByDNI(Connection con, Cliente cliente) throws Exception{
        cliente=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;

        try{
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE DNI=?");
            stmt.setInt(1, cliente.getDNI());
            rs = stmt.executeQuery();

            while(rs.next()){
                cliente=new Cliente();
                obtenClienteFila(rs, cliente);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception("problema al buscar por DNI "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return cliente;
    }

    public Cliente findByNick(Connection con, Cliente cliente) throws Exception{
        cliente=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;

        try{
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE Nick=?");
            stmt.setString(1, cliente.getNick());
            rs = stmt.executeQuery();

            while(rs.next()){
                cliente=new Cliente();
                obtenClienteFila(rs, cliente);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception("problema al buscar por Nick "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return cliente;
    }

    public List<Cliente> findByNumberDNIStart(Connection con, int numero) throws Exception{
        List<Cliente> listaClientes=new ArrayList();

        PreparedStatement stmt=null;
        ResultSet rs=null;

        try{
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE DNI like ?");
            stmt.setString(1, numero+"%");
            rs = stmt.executeQuery();
            Cliente cliente=null;

            while(rs.next()){
                cliente=new Cliente();
                obtenClienteFila(rs, cliente);
                listaClientes.add(cliente);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception("problema al buscar por Nick "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return listaClientes;
    }

    public Cliente findByMayorGasto(Connection con) throws Exception{
        Cliente cliente=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;

        try{
            stmt = con.prepareStatement("SELECT Cliente_DNI AS DNI, (SUM(Precio*Numero))"
                    + "AS GASTO FROM articulo_factura af, articulo a, factura f"
                    + "WHERE af.Articulo_idArticulo = a.idArticulo "
                    + "AND afFactura_idFactura = f.idFactura "
                    + "GROU BY(Cliente_DNI");

            rs = stmt.executeQuery();
            float gatoAnterior=0;;

            while(rs.next()){
                float gasto=rs.getFloat("GASTO");
                if(gasto > gatoAnterior){
                    cliente=new Cliente();
                    cliente.setDNI(rs.getInt("DNI"));
                    gatoAnterior=gasto;
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception("problema al buscar por DNI "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        if(cliente!=null){
            cliente = findByDNI(con, cliente);
        }
        return cliente;
    }
*/
}
