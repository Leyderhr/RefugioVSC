package Interface;


import dao.DAOAnimal;
import logic.Animal;
import net.sf.jasperreports.engine.JRException;
import reportes.ReporteActividadCuidadoAnimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IdAnimalJDialog extends JDialog{


    private JLabel lbl;
    private JComboBox<String> comboBoxIdAnimal;

    public IdAnimalJDialog(JFrame window){
        super(window,"Id de Animal", true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setSize(300,200);
        contentPanel.setBackground(Color.WHITE);
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        contentPanel.add(getComboBoxIdAnimal());
        contentPanel.add(getLbl());
    }

    private JLabel getLbl(){
        if (lbl == null){
            lbl = new JLabel("<html> <p align: center> Seleccione el animal del que desea saber las <br> " +
                    "Actividades de Cuidado Diario </p></html>");
            lbl.setHorizontalTextPosition(SwingConstants.CENTER);
            lbl.setBounds(10,20,260,35);
            lbl.setOpaque(true);
            lbl.setBackground(new Color(33,196,58,255));
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        }
        return lbl;
    }

    private JComboBox<String> getComboBoxIdAnimal(){
        if(comboBoxIdAnimal == null){
            comboBoxIdAnimal = new JComboBox<>();
            comboBoxIdAnimal.setBounds(10, 80, 250, 30);
            comboBoxIdAnimal.setVisible(true);


            DAOAnimal daoAnimal = new DAOAnimal();
            ArrayList<Animal> a = daoAnimal.consultarAnimales();

            for(Animal animal: a){
                comboBoxIdAnimal.addItem("Id del Animal: "+animal.getId_animal()+" "+"Nombre: "+animal.getNombre());
            }


            comboBoxIdAnimal.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ReporteActividadCuidadoAnimal rp = new ReporteActividadCuidadoAnimal(comboBoxIdAnimal.getSelectedIndex()+1);
                        rp.mostrarVentanaReporte();
                        dispose();
                    } catch (JRException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        return comboBoxIdAnimal;
    }
}
