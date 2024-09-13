package dao;

import conexion.Conexion;
import logic.ProvAlimentos;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProveedorAlimentos {

    Conexion cx;

    public DAOProveedorAlimentos(){
        cx = new Conexion();
    }

    public boolean insertarProveedorAlimentos(ProvAlimentos p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select provalimentos_insert(?,?)");

            ps.setString(1, p.getRepresentante());
            ps.setInt(2, p.getId_proveedor());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Los campos para agregar la información de un proveedor de alimentos no pueden estar vacios");
        }
    }

    public ArrayList<ProvAlimentos> consultarProveedoresAlimentos()  {
        ArrayList<ProvAlimentos> lista = new ArrayList<ProvAlimentos>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM provalimentos");
            rs = ps.executeQuery();
            while ((rs.next())){
                ProvAlimentos p = new ProvAlimentos();
                p.setRepresentante(rs.getString("representante"));
                p.setId_proveedor(rs.getInt("id_proveedor"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarProveedorAlimentos(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT provalimentos_delete(?)");
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

    public boolean actualizarProveedorAlimentos(ProvAlimentos p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select provalimentos_update(?,?)");

            ps.setString(1, p.getRepresentante());
            ps.setInt(2, p.getId_proveedor());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProvAlimentos buscarProveedorAlimentos(int id) {
        ProvAlimentos pv = null;

        try {
            ResultSet rs = null;
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM find_provalimentos(?)");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                pv = new ProvAlimentos();
                pv.setRepresentante(rs.getString(1));
                pv.setId_proveedor(rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pv;
    }
}
