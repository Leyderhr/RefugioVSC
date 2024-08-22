import javax.swing.JFrame;
import conexion.Conexion;
import Interface.Authentication;
import dao.DAOContrato;
import logic.Contrato;

import java.sql.Date;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Conectado con éxito");


        try{
            Authentication w = new Authentication();
            w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            w.setLocationRelativeTo(null);
            w.setVisible(true);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
