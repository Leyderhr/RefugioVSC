package Interface;

import com.toedter.calendar.JDateChooser;
import dao.DAOAnimal;
import dao.DAOAnimalAdoptado;
import logic.Animal;
import logic.AnimalAdoptado;
import util.JTextFieldNumerosFlotantes;
import util.JTextFieldSoloLetras;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
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

    private JTextFieldNumerosFlotantes txtFPeso;
    private JLabel lblPeso;

    private JLabel lblCantDasEn;
    private JLabel lblFechaEntrada;
    private JDateChooser fechaEntrada;
    private JSpinner spinnerDiasRefugio;

    private JCheckBox chckbxesAdoptado;

    private JTextFieldNumerosFlotantes txtFPrecioAdopcion;
    private JLabel lblPrecioAdopcion;

    private JTextFieldNumerosFlotantes txtFCantDonaciones;
    private JLabel lblCantDonaciones;

    private JScrollPane scrollPane;
    private JTable tableAnimal;
    private final DefaultTableModel model = new DefaultTableModel();

    private final DAOAnimal dao = new DAOAnimal();
    private final DAOAnimalAdoptado daoAdoptado = new DAOAnimalAdoptado();
    ArrayList<Animal> lista;

    public AnimalPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Animales",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184, 184, 184, 255)));
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

//        add(getLblCantDasEn());
//        add(getSpinnerDiasRefugio());
        add(getLblFechaEntrada());
        add(getFechaEntrada());

        add(getChckbxesAdoptado());

        add(getLblPrecioTotalAdopcion());
        add(getTxtFPrecioTotalAdopcion());

        add(getLblCantDonaciones());
        add(getTxtCantDonaciones());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!tableAnimal.contains(e.getPoint()))
                    tableAnimal.clearSelection();
            }
        });
    }

    private JLabel getLblNombreAnimal() {
        if (lblNombreAnimal == null) {
            lblNombreAnimal = new JLabel("Nombre");
            lblNombreAnimal.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblNombreAnimal.setBounds(10, 36, 66, 15);
        }
        return lblNombreAnimal;
    }

    private JTextFieldSoloLetras getTxtFNombreAnimal() {
        if (txtFNombreAnimal == null) {
            txtFNombreAnimal = new JTextFieldSoloLetras();
            txtFNombreAnimal.setBounds(102, 30, 131, 28);
            txtFNombreAnimal.setColumns(10);
        }
        return txtFNombreAnimal;
    }

    private JLabel getLblEspecie() {
        if (lblEspecie == null) {
            lblEspecie = new JLabel("Especie");
            lblEspecie.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEspecie.setBounds(10, 74, 66, 15);
        }
        return lblEspecie;
    }

    private JTextFieldSoloLetras getTxtFEspecie() {
        if (txtFEspecie == null) {
            txtFEspecie = new JTextFieldSoloLetras();
            txtFEspecie.setColumns(10);
            txtFEspecie.setBounds(102, 68, 131, 28);
        }
        return txtFEspecie;
    }

    private JLabel getLblRaza() {
        if (lblRaza == null) {
            lblRaza = new JLabel("Raza");
            lblRaza.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblRaza.setBounds(10, 112, 66, 15);
        }
        return lblRaza;
    }

    private JTextFieldSoloLetras getTxtFRaza() {
        if (txtFRaza == null) {
            txtFRaza = new JTextFieldSoloLetras();
            txtFRaza.setColumns(10);
            txtFRaza.setBounds(102, 106, 131, 28);
        }
        return txtFRaza;
    }

    private JLabel getLblEdad() {
        if (lblEdad == null) {
            lblEdad = new JLabel("Edad");
            lblEdad.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEdad.setBounds(10, 150, 66, 15);
        }
        return lblEdad;
    }

    private JTextFieldSoloNumeros getTxtFEdad() {
        if (txtFEdad == null) {
            txtFEdad = new JTextFieldSoloNumeros();
            txtFEdad.setColumns(10);
            txtFEdad.setBounds(102, 144, 131, 28);
        }
        return txtFEdad;
    }

    private JLabel getLblPeso() {
        if (lblPeso == null) {
            lblPeso = new JLabel("Peso");
            lblPeso.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblPeso.setBounds(10, 190, 66, 15);
        }
        return lblPeso;
    }

    private JTextFieldNumerosFlotantes getTxtFPeso() {
        if (txtFPeso == null) {
            txtFPeso = new JTextFieldNumerosFlotantes();
            txtFPeso.setColumns(10);
            txtFPeso.setBounds(102, 182, 131, 28);
        }
        return txtFPeso;
    }

    private JLabel getLblFechaEntrada() {
        if (lblFechaEntrada == null) {
            lblFechaEntrada = new JLabel("Fecha de Entrada");
            lblFechaEntrada.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechaEntrada.setBounds(10, 226, 130, 15);
        }
        return lblFechaEntrada;
    }

    private JDateChooser getFechaEntrada() {
        if (fechaEntrada == null) {
            fechaEntrada = new JDateChooser();
            fechaEntrada.setBounds(150, 220, 100, 25);
        }
        return fechaEntrada;
    }

//    private JLabel getLblCantDasEn() {
//        if (lblCantDasEn == null) {
//            lblCantDasEn = new JLabel("Cant. días en el Refugio");
//            lblCantDasEn.setFont(new Font("Bahnschrift", Font.BOLD, 14));
//            lblCantDasEn.setBounds(10, 226, 160, 15);
//        }
//        return lblCantDasEn;
//    }
//
//    private JSpinner getSpinnerDiasRefugio() {
//        if (spinnerDiasRefugio == null) {
//            spinnerDiasRefugio = new JSpinner();
//            spinnerDiasRefugio.setModel(new SpinnerNumberModel(0, 0, null, 1));
//            spinnerDiasRefugio.setBounds(191, 220, 60, 25);
//        }
//        return spinnerDiasRefugio;
//    }

    // Métodos para ingresar a un animal adoptado
    // =========================================================================
    private JCheckBox getChckbxesAdoptado() {
        if (chckbxesAdoptado == null) {
            chckbxesAdoptado = new JCheckBox("¿Es adoptado?");
            chckbxesAdoptado.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            chckbxesAdoptado.setBounds(10, 255, 137, 23);

            chckbxesAdoptado.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (chckbxesAdoptado.isSelected()) {
                        txtFPrecioAdopcion.setVisible(true);
                        lblPrecioAdopcion.setVisible(true);

                        lblCantDonaciones.setVisible(true);
                        txtFCantDonaciones.setVisible(true);
                    } else {
                        txtFPrecioAdopcion.setVisible(false);
                        lblPrecioAdopcion.setVisible(false);

                        txtFCantDonaciones.setVisible(false);
                        lblCantDonaciones.setVisible(false);
                    }
                }
            });
        }
        return chckbxesAdoptado;
    }

    private JLabel getLblPrecioTotalAdopcion() {
        if (lblPrecioAdopcion == null) {
            lblPrecioAdopcion = new JLabel("Precio Total de Adopción");
            lblPrecioAdopcion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblPrecioAdopcion.setBounds(10, 304, 171, 15);
            lblPrecioAdopcion.setVisible(false);
        }
        return lblPrecioAdopcion;
    }

    private JTextFieldNumerosFlotantes getTxtFPrecioTotalAdopcion() {
        if (txtFPrecioAdopcion == null) {
            txtFPrecioAdopcion = new JTextFieldNumerosFlotantes();
            txtFPrecioAdopcion.setColumns(10);
            txtFPrecioAdopcion.setBounds(191, 298, 42, 28);
            txtFPrecioAdopcion.setVisible(false);
        }
        return txtFPrecioAdopcion;
    }

    private JLabel getLblCantDonaciones() {
        if (lblCantDonaciones == null) {
            lblCantDonaciones = new JLabel("Cantidad de Donaciones");
            lblCantDonaciones.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblCantDonaciones.setBounds(10, 342, 171, 15);
            lblCantDonaciones.setVisible(false);
        }
        return lblCantDonaciones;
    }

    private JTextFieldNumerosFlotantes getTxtCantDonaciones() {
        if (txtFCantDonaciones == null) {
            txtFCantDonaciones = new JTextFieldNumerosFlotantes();
            txtFCantDonaciones.setColumns(10);
            txtFCantDonaciones.setBounds(191, 336, 42, 28);
            txtFCantDonaciones.setVisible(false);
        }
        return txtFCantDonaciones;
    }

    // =========================================================================

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
            model.addColumn("Fecha de Entrada");
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
                    new Object[][] {
                            { null, null, null, null, null, null, null },
                            { null, null, null, null, null, null, null },
                    },
                    new String[] {
                            "id", "Nombre", "Especie", "Raza", "Edad", "Peso", "Fecha de Entrada", "Cant. dias refugio"
                    }));
            tableAnimal.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        if (tableAnimal.getSelectedRow() != -1) {
                            limpiar();
                            txtFNombreAnimal.setText(lista.get(tableAnimal.getSelectedRow()).getNombre());
                            txtFEspecie.setText(lista.get(tableAnimal.getSelectedRow()).getEspecie());
                            txtFRaza.setText(lista.get(tableAnimal.getSelectedRow()).getRaza());
                            txtFEdad.setText(String.valueOf(lista.get(tableAnimal.getSelectedRow()).getEdad()));
                            txtFPeso.setText(String.valueOf(lista.get(tableAnimal.getSelectedRow()).getPeso()));
                            spinnerDiasRefugio.setValue(lista.get(tableAnimal.getSelectedRow()).getCant_dias_refugio());
                            AnimalAdoptado ad = daoAdoptado
                                    .buscarAnimalAdoptado(lista.get(tableAnimal.getSelectedRow()).getId_animal());

                            if (ad != null) {
                                chckbxesAdoptado.setSelected(true);
                                txtFPrecioAdopcion.setText(String.valueOf(ad.getPrecio_Total_adopcion()));
                                txtFCantDonaciones.setText(String.valueOf(ad.getCant_dondaciones()));
                            }
                        }
                    }
                }
            });
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

    // Métodos para Agregar, Eliminar y Actualizar
    // ========================================================================
    public Animal agregarAnimal() throws SQLException {
        Animal a = new Animal();
        int idAnimal = -1;
        boolean add = false;

        try {
            a.setNombre(txtFNombreAnimal.getText());
            a.setEdad(Integer.parseInt(txtFEdad.getText()));
            a.setRaza(txtFRaza.getText());
            a.setEspecie(txtFEspecie.getText());
            a.setPeso(Double.parseDouble(txtFPeso.getText()));
            a.setCant_dias_refugio((Integer) spinnerDiasRefugio.getValue());

            dao.insertarAnimal(a);
            add = true;

            if (chckbxesAdoptado.isSelected()) {
                idAnimal = dao.obtenerUltimoID();

                AnimalAdoptado adoptado = new AnimalAdoptado();
                adoptado.setId_animal(idAnimal);
                adoptado.setPrecio_Total_adopcion(Double.parseDouble(txtFPrecioAdopcion.getText()));
                adoptado.setCant_dondaciones(Double.parseDouble(txtFCantDonaciones.getText()));

                daoAdoptado.insertarAnimalAdoptado(adoptado);
            }
            actualizarTabla();

        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            if (chckbxesAdoptado.isSelected() && add) {
                dao.eliminarAnimal(idAnimal);
            }
        }
        limpiar();
        return a;
    }

    public void eliminarAnimal() {

        if (tableAnimal.getSelectedRowCount() >= 1) {

            dao.eliminarAnimal(lista.get(tableAnimal.getSelectedRow()).getId_animal());
            actualizarTabla();

        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void actualizarAnimal() {
        if (tableAnimal.getSelectedRowCount() >= 1) {
            Animal a = lista.get(tableAnimal.getSelectedRow());

            try{
                a.setNombre(txtFNombreAnimal.getText());
                a.setEdad(Integer.parseInt(txtFEdad.getText()));
                a.setRaza(txtFRaza.getText());
                a.setEspecie(txtFEspecie.getText());
                a.setPeso(Double.parseDouble(txtFPeso.getText()));
                a.setCant_dias_refugio((Integer) spinnerDiasRefugio.getValue());

                dao.actualizarAnimal(a);
                DAOAnimalAdoptado dao_a = new DAOAnimalAdoptado();
                AnimalAdoptado ad = dao_a.buscarAnimalAdoptado(a.getId_animal());

                if(ad != null){
                    ad.setPrecio_Total_adopcion(Double.parseDouble(txtFPrecioAdopcion.getText()));
                    ad.setCant_dondaciones(Double.parseDouble(txtFCantDonaciones.getText()));
                    dao_a.actualizarAnimalAdoptado(ad);
                }

            }catch(Exception e){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar() {

        txtFRaza.setText("");
        txtFPeso.setText("");
        txtFNombreAnimal.setText("");
        txtFEspecie.setText("");
        txtFEdad.setText("");
        spinnerDiasRefugio.setValue(0);
        if (chckbxesAdoptado.isSelected()) {
            txtFCantDonaciones.setText("");
            txtFPrecioAdopcion.setText("");
            chckbxesAdoptado.setSelected(false);
        }

    }

}
