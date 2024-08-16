package dao;

import conexion.Conexion;
import logic.Veterinario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOVeterinario {

    Conexion cx;

    public DAOVeterinario(){
        cx = new Conexion();
    }

    public boolean insertarVeterinario(Veterinario v){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select veterinario_insert(?,?,?,?)");

            ps.setString(1, v.getClinica());
            ps.setString(2, v.getFax());
            ps.setString(3, v.getEspecialidad());
            ps.setInt(4, v.getId_proveedor());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Veterinario> consultarVeterinarios()  {
        ArrayList<Veterinario> lista = new ArrayList<Veterinario>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM veterinario");
            rs = ps.executeQuery();
            while ((rs.next())){
                Veterinario v = new Veterinario();
                v.setClinica(rs.getString("clinica"));
                v.setId_proveedor(rs.getInt("id_proveedor"));
                v.setEspecialidad(rs.getString("especialidad"));
                v.setFax(rs.getString("fax"));
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarVeterinario(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT veterinario_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarVeterinario(Veterinario v){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select veterinario_update(?,?,?,?)");

            ps.setString(1, v.getClinica());
            ps.setString(2, v.getFax());
            ps.setString(3, v.getEspecialidad());
            ps.setInt(4, v.getId_proveedor());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
