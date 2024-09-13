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

            ps.setString(1, v.getFax());
            ps.setString(2, v.getEspecialidad());
            ps.setInt(3, v.getId_proveedor());
            ps.setString(4, v.getClinica());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
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
            throw new IllegalArgumentException(e.getMessage());
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
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean actualizarVeterinario(Veterinario v){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select veterinario_update(?,?,?,?)");

            ps.setString(1, v.getFax());
            ps.setString(2, v.getEspecialidad());
            ps.setInt(3, v.getId_proveedor());
            ps.setString(4, v.getClinica());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Veterinario buscarVeterinario(int id) {
        Veterinario v = null;

        try {
            ResultSet rs = null;
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM find_veterinario(?)");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                v = new Veterinario();
                v.setFax(rs.getString(1));
                v.setEspecialidad(rs.getString(2));
                v.setId_proveedor(rs.getInt(3));
                v.setClinica(rs.getString(4));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return v;
    }
}
