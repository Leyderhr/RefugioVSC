package dao;

import conexion.Conexion;
import logic.Proveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProveedor {

    Conexion cx;

    public DAOProveedor(){
        cx = new Conexion();
    }

    public boolean insertarProveedor(Proveedor p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select proveedor_insert(?,?,?,?,?)");

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getProvincia());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Proveedor> consultarProveedores()  {
        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM proveedor");
            rs = ps.executeQuery();
            while ((rs.next())){
                Proveedor p = new Proveedor();
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                p.setProvincia(rs.getString("id_provincia"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarProveedor(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT proveedor_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProveedor(Proveedor p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select proveedor_update(?,?,?,?,?,?)");

            ps.setInt(1, p.getId_proveedor());
            ps.setString(2, p.getNombre());
            ps.setString(3,p.getDireccion());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getProvincia());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
