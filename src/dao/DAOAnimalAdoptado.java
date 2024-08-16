package dao;


import conexion.Conexion;
import logic.AnimalAdoptado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOAnimalAdoptado {

    Conexion cx;

    public DAOAnimalAdoptado(){
        cx = new Conexion();
    }

    public boolean insertarAnimalAdoptado(AnimalAdoptado a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select animaladoptado_insert(?)");

            ps.setInt(1, a.getId_animal());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<AnimalAdoptado> consultarAnimalesAdoptados()  {
        ArrayList<AnimalAdoptado> lista = new ArrayList<AnimalAdoptado>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM animaladoptado");
            rs = ps.executeQuery();
            while ((rs.next())){
                AnimalAdoptado a = new AnimalAdoptado();
                a.setId_animal(rs.getInt("id_animal"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarAnimalAdoptado(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT animaladoptado_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean actualizarAnimalAdoptado(Animal a){
//
//        PreparedStatement ps = null;
//        try{
//
//            ps = cx.conectar().prepareStatement("select animal_update(?,?,?,?,?,?,?)");
//
//            ps.setInt(1,a.getId_animal());
//            ps.setString(2, a.getNombre());
//            ps.setString(3, a.getEspecie());
//            ps.setString(4, a.getRaza());
//            ps.setInt(5, a.getEdad());
//            ps.setInt(6, (int) a.getPeso());
//            ps.setInt(7, a.getCant_dias_refugio());
//            ps.execute();
//            cx.desconectar();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
