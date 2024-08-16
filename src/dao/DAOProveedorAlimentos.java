package dao;

import conexion.Conexion;
import logic.ProvAlimentos;

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
            e.printStackTrace();
            return false;
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
            e.printStackTrace();
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
}
