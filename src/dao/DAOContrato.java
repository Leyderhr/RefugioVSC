package dao;

import conexion.Conexion;
import logic.Contrato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOContrato {

    Conexion cx;

    public DAOContrato(){
        cx = new Conexion();
    }

    public boolean insertarContrato(Contrato c){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select contrato_insert(?,?,?,?,?,?,?,?)");

            ps.setDate(1, c.getFecha_term());
            ps.setDate(2, c.getFecha_ini());
            ps.setDate(3, c.getFecha_conc());
            ps.setString(4, c.getDesc_cont());
            ps.setString(5, c.getNom_resp());
            ps.setInt(6, c.getId_proveedor());
            ps.setDouble(8, c.getRecargo());
            ps.setInt(7, c.getId_servicio());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Contrato> consultarContratos()  {
        ArrayList<Contrato> lista = new ArrayList<Contrato>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM contrato ORDER BY id_contrato ASC");
            rs = ps.executeQuery();
            while ((rs.next())){
                Contrato c = new Contrato();
                c.setId_contrato(rs.getInt("id_contrato"));
                c.setFecha_term(rs.getDate("fecha_term"));
                c.setFecha_ini(rs.getDate("fecha_ini"));
                c.setFecha_conc(rs.getDate("fecha_conc"));
                c.setDesc_cont(rs.getString("desc_contrato"));
                c.setNom_resp(rs.getString("nom_resp"));
                c.setId_proveedor(rs.getInt("id_proveedor"));
                c.setId_servicio(rs.getInt("id_servicio"));
                c.setRecargo(rs.getDouble("recargo"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarContrato(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT contrato_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

        public boolean actualizarContrato(Contrato c){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select contrato_update(?,?,?,?,?,?,?,?,?)");

            ps.setInt(1,c.getId_contrato());
            ps.setDate(2, c.getFecha_term());
            ps.setDate(3, c.getFecha_ini());
            ps.setDate(4, c.getFecha_conc());
            ps.setString(5, c.getDesc_cont());
            ps.setString(6, c.getNom_resp() );
            ps.setInt(7, c.getId_proveedor());
            ps.setDouble(8, c.getRecargo());
            ps.setInt(9, c.getId_servicio());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
