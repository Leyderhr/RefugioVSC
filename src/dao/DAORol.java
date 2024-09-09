package dao;

import conexion.Conexion;
import logic.Rol;
import logic.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAORol {
    Conexion cx;

    public DAORol(){
        cx = new Conexion();
    }

    public boolean insertarRol(Rol r){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select roles_insert(?)");

            ps.setString(1, r.getRol());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public ArrayList<Rol> consultarRol()  {
        ArrayList<Rol> lista = new ArrayList<Rol>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM roles");
            rs = ps.executeQuery();
            while ((rs.next())){
                Rol r = new Rol();
                r.setId(rs.getInt("id_rol"));
                r.setRol(rs.getString("rol"));
                lista.add(r);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return lista;
    }

    public boolean eliminarRol(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT roles_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean actualizarRol(Rol r){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select roles_update(?,?)");

            ps.setInt(1, r.getId());
            ps.setString(2, r.getRol());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
