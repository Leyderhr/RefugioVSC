package Interface;

import dao.DAOServicio;

import logic.Servicio;
import util.JTextFieldNumerosFlotantes;
import util.JTextFieldSoloLetras;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ServicioPanel extends JPanel {

    // Atributos
    // ========================================================================
    public static final int VALUE = 4;
    private JLabel lblPrecio;
    private JTextFieldNumerosFlotantes txtFPrecio;

    private JTextFieldSoloLetras txtFModalidad;
    private JLabel lblModalidad;

    private JLabel lblTipoServicio;
    private JComboBox<String> comboBoxTipoServicio;

    private JScrollPane scrollPane;
    private JTable tableServicio;
    private final DefaultTableModel model = new DefaultTableModel();
    private final DAOServicio dao = new DAOServicio();
    private ArrayList<Servicio> lista;
    // ========================================================================

    // Constructor
    public ServicioPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Servicios",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184, 184, 184, 255)));
        setLayout(null);
        setVisible(false);

        add(getLblPrecio());
        add(getTxtFPrecio());

        add(getLblModalidad());
        add(getTxtFModalidad());

        add(getLblTipoServicio());
        add(getComboBoxTipoServicio());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!tableServicio.contains(e.getPoint()))
                    tableServicio.clearSelection();
            }
        });
    }

    // Cosas del Precio
    // ========================================================================
    private JLabel getLblPrecio() {
        if (lblPrecio == null) {
            lblPrecio = new JLabel("Precio");
            lblPrecio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblPrecio.setBounds(10, 36, 66, 15);
        }
        return lblPrecio;
    }

    private JTextFieldNumerosFlotantes getTxtFPrecio() {
        if (txtFPrecio == null) {
            txtFPrecio = new JTextFieldNumerosFlotantes();
            txtFPrecio.setBounds(102, 30, 131, 28);
            txtFPrecio.setColumns(10);
        }
        return txtFPrecio;
    }
    // ========================================================================

    // Cosas de Modalidad
    // ========================================================================
    private JLabel getLblModalidad() {
        if (lblModalidad == null) {
            lblModalidad = new JLabel("Modalidad");
            lblModalidad.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblModalidad.setBounds(10, 74, 76, 15);
        }
        return lblModalidad;
    }

    private JTextFieldSoloLetras getTxtFModalidad() {
        if (txtFModalidad == null) {
            txtFModalidad = new JTextFieldSoloLetras();
            txtFModalidad.setColumns(10);
            txtFModalidad.setBounds(102, 68, 131, 28);
        }
        return txtFModalidad;
    }
    // ========================================================================

    // JLabel y ComboBox para ingresar los tipos de Servicios
    // ========================================================================
    private JLabel getLblTipoServicio() {
        if (lblTipoServicio == null) {
            lblTipoServicio = new JLabel("Tipo de Servicio");
            lblTipoServicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblTipoServicio.setBounds(10, 116, 150, 15);
        }
        return lblTipoServicio;
    }

    private JComboBox<String> getComboBoxTipoServicio() {
        if (comboBoxTipoServicio == null) {
            comboBoxTipoServicio = new JComboBox<>();
            comboBoxTipoServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            comboBoxTipoServicio.setBounds(10, 135, 150, 28);

            // ArrayList de prueba para cargar todos los identificadores
            // ArrayList<String> items = new ArrayList<>();
            // items.add("Item 1");
            // items.add("Item 2");
            // items.add("Item 3");

            // Cargar el JComboBox con los datos del ArrayList
            // for (String item : items) {
            // ComboBoxTipoServicio.addItem(item);
            // }

            comboBoxTipoServicio.setModel(
                    new DefaultComboBoxModel<String>(new String[] { "Alimentario", "Veterinario", "Complementario" }));
            comboBoxTipoServicio.setSelectedIndex(-1);
        }

        return comboBoxTipoServicio;
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
            tableServicio = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableServicio.getTableHeader().setReorderingAllowed(false);
            tableServicio.setModel(new DefaultTableModel(
                    new Object[][] {
                            { null, null, null, null, null },
                            { null, null, null, null, null },
                    },
                    new String[] {
                            "Id", "Tipo. Servicio", "Modalidad", "Precio"
                    }));
            tableServicio.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        if (tableServicio.getSelectedRow() != -1) {
                            txtFModalidad.setText(lista.get(tableServicio.getSelectedRow()).getModalidad());
                            txtFPrecio.setText(String.valueOf(lista.get(tableServicio.getSelectedRow()).getPrecio()));
                            switch (lista.get(tableServicio.getSelectedRow()).getTipo_servicio()) {
                                case "Alimentario":
                                    comboBoxTipoServicio.setSelectedIndex(0);
                                    break;
                                case "Veterinario":
                                    comboBoxTipoServicio.setSelectedIndex(1);
                                    break;
                                default:
                                    comboBoxTipoServicio.setSelectedIndex(2);
                                    break;
                            }
                        }
                    }
                }
            });
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
    public void eliminarServicio() {

        if (tableServicio.getSelectedRowCount() >= 1) {
            dao.eliminarServicio(lista.get(tableServicio.getSelectedRow()).getId_servicio());
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    // Método para crear y agregar un Servicio
    // ========================================================================
    public Servicio agregarServicio() {
        Servicio s = new Servicio();

        try {
            s.setPrecio(Double.parseDouble(txtFPrecio.getText()));
            s.setModalidad(txtFModalidad.getText());
            s.setTipo_servicio((String) getComboBoxTipoServicio().getSelectedItem());

            dao.insertarServicio(s);
            actualizarTabla();
            limpiar();
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }
    // ========================================================================

    // Método para actualizar un Servicio
    // ========================================================================
    public void actualizarServicio() {
        if (tableServicio.getSelectedRowCount() >= 1) {
            Servicio s = lista.get(tableServicio.getSelectedRow());

            try {
                s.setPrecio(Double.parseDouble(txtFPrecio.getText()));
                s.setModalidad(txtFModalidad.getText());
                s.setTipo_servicio((String) getComboBoxTipoServicio().getSelectedItem());
                dao.actualizarTipoServicio(s);
            } catch (Exception e) {
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
        txtFModalidad.setText("");
        txtFPrecio.setText("");
        if (comboBoxTipoServicio.getSelectedIndex() != -1) {
            comboBoxTipoServicio.setSelectedIndex(-1);
        }
    }
}
