package dao;

import conexion.Conexion;
import logic.ProvServComplementarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProvServComplementarios {

    Conexion cx;

    public DAOProvServComplementarios(){
        cx = new Conexion();
    }

    public boolean insertarProvServComplementarios(ProvServComplementarios p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select provservcomplementarios_insert(?,?)");

            ps.setString(1, p.getRepresentante());
            ps.setInt(2, p.getId_proveedor());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ProvServComplementarios> consultarProvServComplemetarios()  {
        ArrayList<ProvServComplementarios> lista = new ArrayList<ProvServComplementarios>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM provservcomplementarios");
            rs = ps.executeQuery();
            while ((rs.next())){
                ProvServComplementarios p = new ProvServComplementarios();
                p.setRepresentante(rs.getString("representante"));
                p.setId_proveedor(rs.getInt("id_proveedor"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminarProvServComplementarios(int id){

        PreparedStatement ps = null;

        try {
            ps = cx.conectar().prepareStatement("SELECT provservcomplementarios_delete(?)");
            ps.setInt(1, id);
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProvServComplementarios(ProvServComplementarios p){

        PreparedStatement ps = null;
        try{

            ps = cx.conectar().prepareStatement("select provservcomplementarios_update(?,?)");

            ps.setString(1, p.getRepresentante());
            ps.setInt(2, p.getId_proveedor());
            ps.execute();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
