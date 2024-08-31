package dao;

import conexion.Conexion;
import logic.ActividadCuidadoDiario;

import javax.swing.*;
import java.awt.*;
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
            throw new IllegalArgumentException("Los campos para agregar la información de una actividad de cuidado diario no pueden estar vacios");
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
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            ps.setInt(5, (int) a.getId_contrato());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     public ActividadCuidadoDiario buscarACD(Date d, Time t, int id) {
         ActividadCuidadoDiario acd = null;

         try {
             ResultSet rs = null;
             PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM find_actividadcuidadodiario(?, ?, ?)");

             ps.setDate(1, d);
             ps.setTime(2, t);
             ps.setInt(3, id);

             rs = ps.executeQuery();

             if (rs.next()) {
                 acd = new ActividadCuidadoDiario();
                 acd.setFecha(rs.getDate(1));
                 acd.setHora(rs.getTime(2));
                 acd.setDesc_act(rs.getString(3));
                 acd.setId_animal(rs.getInt(4));
                 acd.setId_contrato(rs.getInt(5));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return acd;
     }
}
