package dao;

import conexion.Conexion;
import logic.Provincia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProvincia {

    Conexion cx;

    public DAOProvincia(){
        cx = new Conexion();
    }

    public boolean insertarProvincia(Provincia p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select provincia_insert(?)");

            ps.setString(1, p.getNombre());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Provincia> consultarProvincia()  {
        ArrayList<Provincia> lista = new ArrayList<Provincia>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM provincia");
            rs = ps.executeQuery();
            while ((rs.next())){
                Provincia p = new Provincia();
                p.setId_provinvcia(rs.getInt("id_provincia"));
                p.setNombre(rs.getString("nombre"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarProvincia(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT provincia_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProvincia(Provincia p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select provincia_update(?,?)");

            ps.setInt(1, p.getId_provinvcia());
            ps.setString(2, p.getNombre());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
