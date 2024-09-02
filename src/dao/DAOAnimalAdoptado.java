package dao;

import conexion.Conexion;
import logic.AnimalAdoptado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOAnimalAdoptado {

    Conexion cx;

    public DAOAnimalAdoptado() {
        cx = new Conexion();
    }

    public boolean insertarAnimalAdoptado(AnimalAdoptado a) {

        PreparedStatement ps = null;
        try {

            ps = cx.conectar().prepareStatement("select animaladoptado_insert(?,?,?)");

            ps.setInt(1, a.getId_animal());
            ps.setDouble(2, a.getPrecio_Total_adopcion());
            ps.setDouble(3, a.getCant_dondaciones());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public ArrayList<AnimalAdoptado> consultarAnimalesAdoptados() {
        ArrayList<AnimalAdoptado> lista = new ArrayList<AnimalAdoptado>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM animaladoptado");
            rs = ps.executeQuery();
            while ((rs.next())) {
                AnimalAdoptado a = new AnimalAdoptado();
                a.setId_animal(rs.getInt("id_animal"));
                lista.add(a);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return lista;
    }

    public boolean eliminarAnimalAdoptado(int id) {

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT animaladoptado_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean actualizarAnimalAdoptado(AnimalAdoptado a) {

        PreparedStatement ps = null;
        try {

            ps = cx.conectar().prepareStatement("select animaladoptado_update(?,?,?)");

            ps.setInt(1, a.getId_animal());
            ps.setDouble(2, a.getPrecio_Total_adopcion());
            ps.setDouble(3, a.getCant_dondaciones());

            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AnimalAdoptado buscarAnimalAdoptado(int id) {
        AnimalAdoptado ad = null;

        try {
            ResultSet rs = null;
            PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM find_animaladoptado(?)");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                ad = new AnimalAdoptado();
                ad.setId_animal(rs.getInt(1));
                ad.setPrecio_Total_adopcion(rs.getDouble(2));
                ad.setCant_dondaciones(rs.getDouble(3));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return ad;
    }
}
