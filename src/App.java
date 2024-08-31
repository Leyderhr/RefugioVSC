import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

import Interface.Authentication;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Conectado con éxito");


        try{
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new FlatDarculaLaf());
            Authentication w = new Authentication();
            w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            w.setLocationRelativeTo(null);
            w.setVisible(true);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
