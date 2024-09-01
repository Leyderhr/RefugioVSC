package dao;

import conexion.Conexion;
import logic.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOProveedor {

    Conexion cx;

    public DAOProveedor(){
        cx = new Conexion();
    }


    public int obtenerUltimoID() throws SQLException {
        ResultSet rs = null;
        Statement stmt = cx.conectar().createStatement();
        int ultimoId = 0;
        String sql = "SELECT obtener_ultimo_idProveedor();";
        rs = stmt.executeQuery(sql);

        // Procesar el resultado
        if (rs.next()) {
            ultimoId = rs.getInt(1); // Obtener el primer (y único) valor de la fila
        }

        return ultimoId;
    }

    public boolean insertarProveedor(Proveedor p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select proveedor_insert(?,?,?,?,?,?)");

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getEmail());
            ps.setInt(5, p.getProvincia());
            ps.setString(6, String.valueOf(p.getTipo_proveedor()));
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Los campos para agregar la información de un proveedor no pueden estar vacios");
        }
    }

    public ArrayList<Proveedor> consultarProveedores()  {
        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM proveedor ORDER BY id_proveedor ASC");
            rs = ps.executeQuery();
            while ((rs.next())){
                Proveedor p = new Proveedor();
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                p.setProvincia(rs.getInt("id_provincia"));
                p.setTipo_proveedor(rs.getString("tipo_proveedor").charAt(0));
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
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean actualizarProveedor(Proveedor p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select proveedor_update(?,?,?,?,?,?,?)");

            ps.setInt(1, p.getId_proveedor());
            ps.setString(2, p.getNombre());
            ps.setString(3,p.getDireccion());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getEmail());
            ps.setInt(6, p.getProvincia());
            ps.setString(7, String.valueOf(p.getTipo_proveedor()));

            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
            //return false;
        }
    }
}
