package dao;

import conexion.Conexion;
import logic.Clinica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOClinica {

    Conexion cx;

    public DAOClinica(){
        cx = new Conexion();
    }

    public boolean insertarClinica(Clinica c){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select clinica_insert(?,?)");

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Clinica> consultarClinica()  {
        ArrayList<Clinica> lista = new ArrayList<Clinica>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM clinica");
            rs = ps.executeQuery();
            while ((rs.next())){
                Clinica c = new Clinica();
                c.setId_clinica(rs.getInt("id_clinica"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarClinica(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT clinica_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarClinica(Clinica c){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select clinica_update(?,?,?)");

            ps.setInt(1, c.getId_clinica());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
