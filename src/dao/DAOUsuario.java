package dao;

import conexion.Conexion;
import logic.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuario {

    Conexion cx;

    public DAOUsuario(){
        cx = new Conexion();
    }

    public boolean insertarUsuario(Usuario u){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select usuarios_insert(?,?,?)");

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getContrasegna());
            ps.setInt(3, u.getRol());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public ArrayList<Usuario> consultarUsuario()  {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM usuarios");
            rs = ps.executeQuery();
            while ((rs.next())){
                Usuario c = new Usuario();
                c.setNombre(rs.getString("nombre"));
                c.setContrasegna(rs.getString("contrasegna"));
                c.setRol(rs.getInt("id_rol"));
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return lista;
    }

    public boolean eliminarUsuario(String id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT usuarios_delete(?)");
            ps.setString(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean actualizarUsuario(Usuario u){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select usuarios_update(?,?,?)");

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getContrasegna());
            ps.setInt(3, u.getRol());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
