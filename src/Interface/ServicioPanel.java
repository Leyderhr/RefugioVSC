package Interface;


import dao.DAOServicio;

import logic.Servicio;
import util.JTextFieldSoloLetras;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ServicioPanel extends JPanel {


    // Atributos
    // ========================================================================
    public static final int VALUE = 4;
    private JLabel lblPrecio;
    private JTextFieldSoloNumeros txtFPrecio;

    private JTextFieldSoloLetras txtFModalidad;
    private JLabel lblModalidad;

    private JLabel lblTipoServicio;
    private JComboBox<String> ComboBoxTipoServicio;

    private JScrollPane scrollPane;
    private JTable tableServicio;
    private final DefaultTableModel model = new DefaultTableModel();
    private final DAOServicio dao = new DAOServicio();
    ArrayList<Servicio> lista;
    // ========================================================================



    // Constructor
    public ServicioPanel(){
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(null);
        setVisible(false);
        add(getLblPrecio());
        add(getTxtFPrecio());
        add(getTxtFModalidad());
        add(getLblModalidad());
        add(getScrollPane());
        add(getLblTipoServicio());
        add(getComboBoxTipoServicio());
    }


    // Cosas del Precio
    // ========================================================================
    private JLabel getLblPrecio() {
        if (lblPrecio == null) {
            lblPrecio = new JLabel("Precio");
            lblPrecio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblPrecio.setBounds(10, 30, 66, 29);
        }
        return lblPrecio;
    }
    private JTextFieldSoloNumeros getTxtFPrecio() {
        if (txtFPrecio == null) {
            txtFPrecio = new JTextFieldSoloNumeros();
            txtFPrecio.setBounds(102, 36, 131, 20);
            txtFPrecio.setColumns(10);
        }
        return txtFPrecio;
    }
    // ========================================================================



    // Cosas de Modalidad
    // ========================================================================
    private JTextFieldSoloLetras getTxtFModalidad() {
        if (txtFModalidad == null) {
            txtFModalidad = new JTextFieldSoloLetras();
            txtFModalidad.setColumns(10);
            txtFModalidad.setBounds(102, 85, 131, 20);
        }
        return txtFModalidad;
    }

    private JLabel getLblModalidad() {
        if (lblModalidad == null) {
            lblModalidad = new JLabel("Modalidad");
            lblModalidad.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblModalidad.setBounds(10, 79, 76, 29);
        }
        return lblModalidad;
    }
    // ========================================================================



    // JLabel y ComboBox para ingresar los tipos de Servicios
    // ========================================================================
    private JLabel getLblTipoServicio() {
        if (lblTipoServicio == null) {
            lblTipoServicio = new JLabel("Tipo de Servicio");
            lblTipoServicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblTipoServicio.setBounds(10, 120, 150, 29);
        }
        return lblTipoServicio;
    }



    private JComboBox<String> getComboBoxTipoServicio() {
        if (ComboBoxTipoServicio == null) {
            ComboBoxTipoServicio = new JComboBox<>();
            ComboBoxTipoServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            ComboBoxTipoServicio.setBounds(10, 145, 150, 20);

            // ArrayList de prueba para cargar todos los identificadores
            ArrayList<String> items = new ArrayList<>();
            items.add("Item 1");
            items.add("Item 2");
            items.add("Item 3");

            // Cargar el JComboBox con los datos del ArrayList
//            for (String item : items) {
//                ComboBoxTipoServicio.addItem(item);
//            }

            ComboBoxTipoServicio.setModel(new DefaultComboBoxModel<String>(new String[] {"Alimentario", "Veterinario", "Complementario"}));
        }

        return ComboBoxTipoServicio;
    }
    // ========================================================================



    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableProveedor());
            model.addColumn("id");
            model.addColumn("Precio");
            model.addColumn("Tipo");
            model.addColumn("Modalidad");
            actualizarTabla();
        }
        return scrollPane;
    }


    // Método de la tabla de los Proveedores
    // ========================================================================
    private JTable getTableProveedor() {
        if (tableServicio == null) {
            tableServicio = new JTable(){
                public boolean isCellEditable(int rowIndex, int colIndex){
                    return false;
                }
            };
            tableServicio.getTableHeader().setReorderingAllowed(false);
            tableServicio.setModel(new DefaultTableModel(
                    new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[] {
                            "Id", "Tipo. Servicio", "Modalidad", "Precio"
                    }
            ));
        }
        return tableServicio;
    }

    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarServicios();
        for (Servicio a : lista) {
            Object[] ob = new Object[4];
            ob[0] = a.getId_servicio();
            ob[1] = a.getPrecio();
            ob[2] = a.getTipo_servicio();
            ob[3] = a.getModalidad();
            model.addRow(ob);
        }
        tableServicio.setModel(model);
    }
    // ========================================================================



    // Método para eliminar a un proveedor
    // ========================================================================
    public void eliminarServicio(){

        dao.eliminarServicio(lista.get(tableServicio.getSelectedRow()).getId_servicio());
        actualizarTabla();
    }
    // ========================================================================



    // Método para crear y agregar un Servicio
    // ========================================================================
    public Servicio agregarServicio(){
        Servicio s = new Servicio();

        s.setPrecio(Double.parseDouble(txtFPrecio.getText()));
        s.setModalidad(txtFModalidad.getText());
        s.setTipo_servicio((String) getComboBoxTipoServicio().getSelectedItem());

        dao.insertarServicio(s);
        actualizarTabla();

        return s;
    }
    // ========================================================================



    // Método para actualizar un Servicio
    // ========================================================================
    public void actualizarServicio(){
        Servicio s = lista.get(tableServicio.getSelectedRow());

        if(!txtFPrecio.getText().equals(""))
            s.setPrecio(Double.parseDouble(txtFPrecio.getText()));
        if(!txtFModalidad.getText().equals(""))
            s.setModalidad(txtFModalidad.getText());


        dao.actualizarTipoServicio(s);
        actualizarTabla();
    }
    // ========================================================================


    public void limpiar(){
        txtFModalidad.setText(" ");
        txtFPrecio.setText(" ");
    }
}
