package Interface;

import dao.DAOAnimal;
import logic.Animal;
import util.JTextFieldSoloLetras;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AnimalPanel extends JPanel {

    public static final int VALUE = 1;
    private JLabel lblNombreAnimal;
    private JTextFieldSoloLetras txtFNombreAnimal;
    private JTextFieldSoloLetras txtFEspecie;
    private JLabel lblEspecie;
    private JTextFieldSoloLetras txtFRaza;
    private JLabel lblRaza;
    private JTextFieldSoloNumeros txtFEdad;
    private JLabel lblEdad;
    private JTextFieldSoloNumeros txtFPeso;
    private JLabel lblPeso;
    private JLabel lblCantDasEn;
    private JSpinner spinnerDiasRefugio;
    private JCheckBox chckbxesAdoptado;
    private JScrollPane scrollPane;
    private JTable tableAnimal;
    private DefaultTableModel model = new DefaultTableModel();
    private DAOAnimal dao = new DAOAnimal();
    ArrayList<Animal> lista;


    public AnimalPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Animales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(null);
        setVisible(false);
        add(getLblNombreAnimal());
        add(getTxtFNombreAnimal());
        add(getTxtFEspecie());
        add(getLblEspecie());
        add(getTxtFRaza());
        add(getLblRaza());
        add(getTxtFEdad());
        add(getLblEdad());
        add(getTxtFPeso());
        add(getLblPeso());
        add(getLblCantDasEn());
        add(getSpinnerDiasRefugio());
        add(getChckbxesAdoptado());
        add(getScrollPane());
    }


    private JLabel getLblNombreAnimal() {
        if (lblNombreAnimal == null) {
            lblNombreAnimal = new JLabel("Nombre");
            lblNombreAnimal.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblNombreAnimal.setBounds(10, 30, 66, 29);
        }
        return lblNombreAnimal;
    }

    private JTextFieldSoloLetras getTxtFNombreAnimal() {
        if (txtFNombreAnimal == null) {
            txtFNombreAnimal = new JTextFieldSoloLetras();
            txtFNombreAnimal.setBounds(102, 36, 131, 20);
            txtFNombreAnimal.setColumns(10);
        }
        return txtFNombreAnimal;
    }

    private JTextFieldSoloLetras getTxtFEspecie() {
        if (txtFEspecie == null) {
            txtFEspecie = new JTextFieldSoloLetras();
            txtFEspecie.setColumns(10);
            txtFEspecie.setBounds(102, 85, 131, 20);
        }
        return txtFEspecie;
    }

    private JLabel getLblEspecie() {
        if (lblEspecie == null) {
            lblEspecie = new JLabel("Especie");
            lblEspecie.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEspecie.setBounds(10, 79, 66, 29);
        }
        return lblEspecie;
    }

    private JTextFieldSoloLetras getTxtFRaza() {
        if (txtFRaza == null) {
            txtFRaza = new JTextFieldSoloLetras();
            txtFRaza.setColumns(10);
            txtFRaza.setBounds(102, 136, 131, 20);
        }
        return txtFRaza;
    }

    private JLabel getLblRaza() {
        if (lblRaza == null) {
            lblRaza = new JLabel("Raza");
            lblRaza.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblRaza.setBounds(10, 130, 66, 29);
        }
        return lblRaza;
    }

    private JTextFieldSoloNumeros getTxtFEdad() {
        if (txtFEdad == null) {
            txtFEdad = new JTextFieldSoloNumeros();
            txtFEdad.setColumns(10);
            txtFEdad.setBounds(102, 183, 131, 20);
        }
        return txtFEdad;
    }

    private JLabel getLblEdad() {
        if (lblEdad == null) {
            lblEdad = new JLabel("Edad");
            lblEdad.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEdad.setBounds(10, 177, 66, 29);
        }
        return lblEdad;
    }

    private JTextFieldSoloNumeros getTxtFPeso() {
        if (txtFPeso == null) {
            txtFPeso = new JTextFieldSoloNumeros();
            txtFPeso.setColumns(10);
            txtFPeso.setBounds(102, 231, 131, 20);
        }
        return txtFPeso;
    }

    private JLabel getLblPeso() {
        if (lblPeso == null) {
            lblPeso = new JLabel("Peso");
            lblPeso.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblPeso.setBounds(10, 225, 66, 29);
        }
        return lblPeso;
    }

    private JLabel getLblCantDasEn() {
        if (lblCantDasEn == null) {
            lblCantDasEn = new JLabel("Cant. días en el Refigio");
            lblCantDasEn.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblCantDasEn.setBounds(10, 286, 171, 29);
        }
        return lblCantDasEn;
    }

    private JSpinner getSpinnerDiasRefugio() {
        if (spinnerDiasRefugio == null) {
            spinnerDiasRefugio = new JSpinner();
            spinnerDiasRefugio.setModel(new SpinnerNumberModel(0, 0, null, 1));
            spinnerDiasRefugio.setBounds(191, 292, 42, 20);
        }
        return spinnerDiasRefugio;
    }

    private JCheckBox getChckbxesAdoptado() {
        if (chckbxesAdoptado == null) {
            chckbxesAdoptado = new JCheckBox("¿Es adoptado?");
            chckbxesAdoptado.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            chckbxesAdoptado.setBounds(10, 336, 137, 23);
        }
        return chckbxesAdoptado;
    }

    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableAnimal());
            model.addColumn("id");
            model.addColumn("Nombre");
            model.addColumn("Especie");
            model.addColumn("Raza");
            model.addColumn("Edad");
            model.addColumn("Peso");
            model.addColumn("Cant. dias refugio");
            actualizarTabla();
        }
        return scrollPane;
    }

    private JTable getTableAnimal() {
        if (tableAnimal == null) {
            tableAnimal = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableAnimal.getTableHeader().setReorderingAllowed(false);
            tableAnimal.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                    },
                    new String[]{
                            "id", "Nombre", "Especie", "Raza", "Edad", "Peso", "Cant. dias refugio"
                    }
            ));
        }
        return tableAnimal;
    }

    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarAnimales();
        for (Animal a : lista) {
            if (a.getRaza() == null)
                a.setRaza("-");
            Object[] ob = new Object[7];
            ob[0] = a.getId_animal();
            ob[1] = a.getNombre();
            ob[2] = a.getEspecie();
            ob[3] = a.getRaza();
            ob[4] = a.getEdad();
            ob[5] = a.getPeso();
            ob[6] = a.getCant_dias_refugio();
            model.addRow(ob);
        }
        tableAnimal.setModel(model);
    }

}
