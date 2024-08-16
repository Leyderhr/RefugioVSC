package dao;


import conexion.Conexion;
import logic.Animal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOAnimal {

    Conexion cx;

    public DAOAnimal(){
        cx = new Conexion();
    }

    public boolean insertarAnimal(Animal a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select animal_insert(?,?,?,?,?,?)");

            ps.setString(1, a.getNombre());
            ps.setString(2, a.getEspecie());
            ps.setString(3, a.getRaza());
            ps.setInt(4, a.getEdad());
            ps.setDouble(5,  a.getPeso());
            ps.setInt(6, a.getCant_dias_refugio());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Animal> consultarAnimales()  {
        ArrayList<Animal> lista = new ArrayList<Animal>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM animal");
            rs = ps.executeQuery();
            while ((rs.next())){
                Animal a = new Animal();
                a.setId_animal(rs.getInt("id_animal"));
                a.setNombre(rs.getString("nombre"));
                a.setEspecie(rs.getString("especie"));
                a.setRaza(rs.getString("raza"));
                a.setEdad(rs.getInt("edad"));
                a.setPeso((double)rs.getInt("peso"));
                a.setCant_dias_refugio(rs.getInt("cant_dias_refugio"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarAnimal(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT animal_delete(?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarAnimal(Animal a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select animal_update(?,?,?,?,?,?,?)");

            ps.setInt(1,a.getId_animal());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getEspecie());
            ps.setString(4, a.getRaza());
            ps.setInt(5, a.getEdad());
            ps.setInt(6, (int) a.getPeso());
            ps.setInt(7, a.getCant_dias_refugio());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
