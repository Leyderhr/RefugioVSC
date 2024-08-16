package dao;

import conexion.Conexion;
import logic.ServicioProveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOServicioProveedor {

    Conexion cx;

    public DAOServicioProveedor(){
        cx = new Conexion();
    }

    public boolean insertarServicioProveedor(ServicioProveedor t){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select servicioproveedor_insert(?,?)");

            ps.setInt(1, t.getId_proveedor());
            ps.setInt(2, t.getId_servicio());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ServicioProveedor> consultarServiciosProveedor()  {
        ArrayList<ServicioProveedor> lista = new ArrayList<ServicioProveedor>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM servicioproveedor");
            rs = ps.executeQuery();
            while ((rs.next())){
                ServicioProveedor t = new ServicioProveedor();
                t.setId_servicio(rs.getInt("id_servicio"));
                t.setId_proveedor(rs.getInt("id_proveedor"));
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarServiciosProveedor(int id_p, int id_s){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT servicioproveedor_delete(?,?)");
            ps.setInt(1, id_p);
            ps.setInt(2, id_s);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarServiciosProveedor(ServicioProveedor t){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select servicioproveedor_update(?,?)");

            ps.setInt(1, t.getId_proveedor());
            ps.setInt(2, t.getId_servicio());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
