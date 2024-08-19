package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection cx = null;
    String url = "jdbc:postgresql://localhost:5432/Refugio";
    String user = "postgres";
    String pass = "uchiha";

    public Connection conectar() {

        try {
            Class.forName("org.postgresql.Driver");
            cx = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado...");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return cx;
    }


    public void desconectar() {

        try {
            cx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
