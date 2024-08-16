package dao;

import conexion.Conexion;
import logic.Servicio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOServicio {

    Conexion cx;

    public DAOServicio(){
        cx = new Conexion();
    }

    public boolean insertarServicio(Servicio t){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select servicio_insert(?,?,?)");

            ps.setDouble(1, t.getPrecio());
            ps.setString(2, t.getTipo_servicio());
            ps.setString(3, t.getModalidad());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Servicio> consultarServicios()  {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM servicio");
            rs = ps.executeQuery();
            while ((rs.next())){
                Servicio t = new Servicio();
                t.setId_servicio(rs.getInt("id_servicio"));
                t.setPrecio(rs.getDouble("precio"));
                t.setTipo_servicio(rs.getString("tipo_servicio"));
                t.setModalidad(rs.getString("modalidad"));
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarServicio(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT servicio_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarTipoServicio(Servicio t){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select servicio_update(?,?,?,?)");

            ps.setInt(1, t.getId_servicio());
            ps.setDouble(2, t.getPrecio());
            ps.setString(3, t.getTipo_servicio());
            ps.setString(4, t.getModalidad());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
