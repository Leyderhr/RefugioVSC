package dao;

import conexion.Conexion;
import logic.Administrador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOAdministrador {

    Conexion cx;

    public DAOAdministrador(){
        cx = new Conexion();
    }

    public boolean insertarAdministrador(Administrador a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select administrador_insert(?,?)");

            ps.setString(1, a.getContrasegna());
            ps.setString(2, a.getNombre());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Administrador> consultarAdministrador()  {
        ArrayList<Administrador> lista = new ArrayList<Administrador>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM administrador ORDER BY nombre ASC");
            rs = ps.executeQuery();
            while ((rs.next())){
                Administrador a = new Administrador();
                a.setNombre(rs.getString("nombre"));
                a.setContrasegna(rs.getString("contrasegna"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarAdministrador(String id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT administrador_delete(?)");
            ps.setString(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarAdministrador(Administrador a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select administrador_update(?,?)");

            ps.setString(1, a.getContrasegna());
            ps.setString(2, a.getNombre());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
