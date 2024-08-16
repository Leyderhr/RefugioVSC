package dao;

import conexion.Conexion;
import logic.ActividadCuidadoDiario;

import java.sql.*;
import java.util.ArrayList;

public class DAOActividadCuidadoDiario {

    Conexion cx;

    public DAOActividadCuidadoDiario(){
        cx = new Conexion();
    }

    public boolean insertarACD(ActividadCuidadoDiario a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select actividadcuidadodiario_insert(?,?,?,?,?)");

            ps.setDate(1, a.getFecha());
            ps.setTime(2, a.getHora());
            ps.setString(3, a.getDesc_act());
            ps.setInt(4, a.getId_animal());
            ps.setInt(5, (int) a.getId_contrato());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ActividadCuidadoDiario> consultarACD()  {
        ArrayList<ActividadCuidadoDiario> lista = new ArrayList<ActividadCuidadoDiario>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM actividadcuidadodiario ORDER BY fecha ASC, hora ASC, id_animal ASC ");
            rs = ps.executeQuery();
            while ((rs.next())){
                ActividadCuidadoDiario a = new ActividadCuidadoDiario();
                a.setHora(rs.getTime("hora"));
                a.setFecha(rs.getDate("fecha"));
                a.setDesc_act(rs.getString("desc_act"));
                a.setId_animal(rs.getInt("id_animal"));
                a.setId_contrato(rs.getInt("id_contrato"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarACD(Date d, Time t, int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT actividadcuidadodiario_delete(?,?,?)");
            ps.setDate(1, d);
            ps.setTime(2, t);
            ps.setInt(3, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarACD(ActividadCuidadoDiario a){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select actividadcuidadodiario_update(?,?,?,?,?)");

            ps.setDate(1, a.getFecha());
            ps.setTime(2, a.getHora());
            ps.setString(3, a.getDesc_act());
            ps.setInt(4, a.getId_animal());
            ps.setInt(5, a.getId_contrato());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public ActividadCuidadoDiario encontrarACD(Date d, Time t, int id){
//        ActividadCuidadoDiario a = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            ps = cx.conectar().prepareStatement("SELECT find_actividadcuidadodiario('1923/10/21','12:00:00',1)");
//            ps.setDate(1, d);
//            ps.setTime(2, t);
//          ps.setInt(3, id);
//            rs = ps.executeQuery();
//            a = new ActividadCuidadoDiario();
//            a.setHora(rs.getTime("hora"));
//            a.setFecha(rs.getDate("fecha"));
//            a.setDesc_act(rs.getString("desc_act"));
//            a.setId_animal(rs.getInt("id_animal"));
//            a.setId_contrato(rs.getInt("id_contrato"));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return a;
//    }
}
