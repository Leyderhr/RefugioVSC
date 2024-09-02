package Interface;

import com.toedter.calendar.JDateChooser;
import dao.DAOContrato;
import dao.DAOProveedor;
import dao.DAOServicio;
import logic.Contrato;
import logic.Proveedor;
import logic.Servicio;
import util.JTextFieldNumerosFlotantes;
import util.JTextFieldSoloLetras;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("Unchecked")
public class ContratoPanel extends JPanel {

    // Atributos de la clase
    // ========================================================================
    public static final int VALUE = 3;
    private JLabel lblResponsable;
    private JTextFieldSoloLetras txtFResponsable;

    private JLabel lblDescripcion;
    private JTextFieldSoloLetras txtFDescripcion;

    private JLabel lblIDServicio;
    private JComboBox<String> comboBoxIdServicio;

    private JLabel lblIDProveedor;
    private JComboBox<String> comboBoxIdProveedor;

    private JLabel lblFechConciliacion;
    private JDateChooser fechaConciliacion;

    private JLabel lblFechInicio;
    private JDateChooser fechaInicio;

    private JLabel lblFechFin;
    private JDateChooser fechaFin;

    private JLabel lblRecargo;
    private JTextFieldNumerosFlotantes txtFRecargo;

    private JScrollPane scrollPane;
    private JTable tableContrato;
    private final DefaultTableModel model = new DefaultTableModel();

    private final DAOContrato dao = new DAOContrato();
    private ArrayList<Contrato> lista;
    private ArrayList<Servicio> listaServicio;
    private ArrayList<Proveedor> listaProveedor;
    // ========================================================================

    public ContratoPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Contratos",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184, 184, 184, 255)));
        setLayout(null);
        setVisible(false);

        add(getLblResponsable());
        add(getTxtFResponsable());

        add(getLblDescripcion());
        add(getTxtFDescripcion());

        add(getLblFechaConciliacion());
        add(getFechaConciliacion());

        add(getLblFechaInicio());
        add(getFechaInicio());

        add(getLblFechaFin());
        add(getFechaFin());

        add(getLblIDServicio());
        add(getComboBoxIServicio());

        add(getLblIDProveedor());
        add(getComboBoxIdProveedor());

        add(getLblRecargo());
        add(getTxtFRecargo());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!tableContrato.contains(e.getPoint()))
                    tableContrato.clearSelection();
            }
        });
    }

    // Cosas del Responsable
    // =========================================================================
    private JLabel getLblResponsable() {
        if (lblResponsable == null) {
            lblResponsable = new JLabel("Responsable");
            lblResponsable.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblResponsable.setBounds(10, 36, 87, 29);
        }
        return lblResponsable;
    }

    private JTextFieldSoloLetras getTxtFResponsable() {
        if (txtFResponsable == null) {
            txtFResponsable = new JTextFieldSoloLetras();
            txtFResponsable.setBounds(102, 30, 131, 28);
            txtFResponsable.setColumns(10);
        }
        return txtFResponsable;
    }
    // =========================================================================

    // Cosas de la Descripción
    // =========================================================================
    private JLabel getLblDescripcion() {
        if (lblDescripcion == null) {
            lblDescripcion = new JLabel("Descripción");
            lblDescripcion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblDescripcion.setBounds(10, 74, 87, 29);
        }
        return lblDescripcion;
    }

    private JTextFieldSoloLetras getTxtFDescripcion() {
        if (txtFDescripcion == null) {
            txtFDescripcion = new JTextFieldSoloLetras();
            txtFDescripcion.setColumns(10);
            txtFDescripcion.setBounds(102, 68, 131, 28);
        }
        return txtFDescripcion;
    }
    // =========================================================================

    // Cosas de la Fecha de Conciliación
    // =========================================================================
    private JLabel getLblFechaConciliacion() {
        if (lblFechConciliacion == null) {
            lblFechConciliacion = new JLabel("Fecha de Conciliación");
            lblFechConciliacion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechConciliacion.setBounds(10, 112, 171, 29);
        }
        return lblFechConciliacion;
    }

    // JDateChooser para asignar la fecha de la conciliación del contrato
    // ========================================================================
    private JDateChooser getFechaConciliacion() {
        if (fechaConciliacion == null) {
            fechaConciliacion = new JDateChooser();
            fechaConciliacion.setBounds(163, 106, 105, 28);
            fechaConciliacion.setMaxSelectableDate(Calendar.getInstance().getTime());

            // Obtener el JFormattedTextField que contiene la fecha
            JFormattedTextField campoFecha = (JFormattedTextField) fechaConciliacion.getComponent(1);

            // Agregar un FocusListener para cambiar el color del texto
            fechaConciliacion.getComponent(1).addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // No hacer nada cuando se gana el foco
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Cambiar el color del texto a blanco cuando se pierde el foco
                    campoFecha.setForeground(new Color(184, 184, 184, 255));
                }
            });
        }
        return fechaConciliacion;
    }
    // ========================================================================

    // Cosas de la Fecha de Inicio
    // =========================================================================
    private JLabel getLblFechaInicio() {
        if (lblFechInicio == null) {
            lblFechInicio = new JLabel("Fecha de Inicio");
            lblFechInicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechInicio.setBounds(10, 150, 171, 29);
        }
        return lblFechInicio;
    }

    // JDateChooser para asignar la fecha de la inicio del contrato
    // ========================================================================
    private JDateChooser getFechaInicio() {
        if (fechaInicio == null) {
            fechaInicio = new JDateChooser();
            // Obtener el JFormattedTextField que contiene la fecha
            JFormattedTextField campoFecha = (JFormattedTextField) fechaInicio.getComponent(1);

            // Agregar un FocusListener para cambiar el color del texto
            fechaInicio.getComponent(1).addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // No hacer nada cuando se gana el foco
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Cambiar el color del texto a blanco cuando se pierde el foco
                    campoFecha.setForeground(Color.WHITE);
                }
            });
            fechaInicio.setBounds(163, 144, 105, 28);
        }
        return fechaInicio;
    }
    // ========================================================================

    // Cosas de la Fecha de Terminación
    // =========================================================================
    private JLabel getLblFechaFin() {
        if (lblFechFin == null) {
            lblFechFin = new JLabel("Fecha de Finalización");
            lblFechFin.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechFin.setBounds(10, 188, 171, 15);
        }
        return lblFechFin;
    }

    // JDateChooser para asignar la fecha de finalización del contrato
    // ========================================================================
    private JDateChooser getFechaFin() {
        if (fechaFin == null) {
            fechaFin = new JDateChooser();

            // Obtener el JFormattedTextField que contiene la fecha
            JFormattedTextField campoFecha = (JFormattedTextField) fechaFin.getComponent(1);

            // Agregar un FocusListener para cambiar el color del texto
            fechaFin.getComponent(1).addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // No hacer nada cuando se gana el foco
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Cambiar el color del texto a blanco cuando se pierde el foco
                    campoFecha.setForeground(Color.WHITE);
                }
            });
            fechaFin.setBounds(163, 182, 105, 28);
        }
        return fechaFin;
    }
    // ========================================================================

    // Cosas para el ID de Servicio
    // =========================================================================
    private JLabel getLblIDServicio() {
        if (lblIDServicio == null) {
            lblIDServicio = new JLabel("Id. Servicio");
            lblIDServicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblIDServicio.setBounds(10, 226, 181, 15);
        }
        return lblIDServicio;
    }

    private JComboBox<String> getComboBoxIServicio() {
        if (comboBoxIdServicio == null) {
            comboBoxIdServicio = new JComboBox<>();
            comboBoxIdServicio.setBounds(102, 220, 131, 28);
            comboBoxIdServicio.setVisible(true);

            DAOServicio daoServicio = new DAOServicio();
            ArrayList<Servicio> a = daoServicio.consultarServicios();

            for (Servicio servicio : a) {
                comboBoxIdServicio.addItem("Id del Servicio: " + servicio.getId_servicio() + "    " + "Tipo: "
                        + servicio.getTipo_servicio());
            }
            comboBoxIdServicio.setSelectedIndex(-1);
        }
        return comboBoxIdServicio;
    }

    // =========================================================================

    // Cosas para seleccionar el id del Proveedor
    // =========================================================================
    private JLabel getLblIDProveedor() {
        if (lblIDProveedor == null) {
            lblIDProveedor = new JLabel("Id. Proveedor");
            lblIDProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 13));
            lblIDProveedor.setBounds(10, 264, 181, 15);
        }
        return lblIDProveedor;
    }

    private JComboBox<String> getComboBoxIdProveedor() {
        if (comboBoxIdProveedor == null) {
            comboBoxIdProveedor = new JComboBox<>();
            comboBoxIdProveedor.setBounds(102, 258, 131, 28);
            comboBoxIdProveedor.setVisible(true);

            DAOProveedor daoProveedor = new DAOProveedor();
            ArrayList<Proveedor> proveedors = daoProveedor.consultarProveedores();

            for (Proveedor p : proveedors) {
                comboBoxIdProveedor.addItem(
                        "Id del Proveedor: " + p.getId_proveedor() + "    " + "Tipo: " + p.getTipo_proveedor());
            }
            comboBoxIdProveedor.setSelectedIndex(-1);
        }
        return comboBoxIdProveedor;
    }

    // =========================================================================

    // Cosas para el Recargo
    // =========================================================================
    private JLabel getLblRecargo() {
        if (lblRecargo == null) {
            lblRecargo = new JLabel("Recargo");
            lblRecargo.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblRecargo.setBounds(10, 302, 181, 15);
        }
        return lblRecargo;
    }

    private JTextFieldNumerosFlotantes getTxtFRecargo() {
        if (txtFRecargo == null) {
            txtFRecargo = new JTextFieldNumerosFlotantes();
            txtFRecargo.setColumns(10);
            txtFRecargo.setBounds(102, 296, 131, 28);
        }
        return txtFRecargo;
    }
    // =========================================================================

    // Panel de Scroll de la Tabla
    // =========================================================================
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableContrato());
            model.addColumn("id");
            model.addColumn("Fecha Terminación");
            model.addColumn("Fecha Inicio");
            model.addColumn("Fecha Conciliación");
            model.addColumn("Descripción");
            model.addColumn("Responsable");
            model.addColumn("id Proveedor");
            model.addColumn("Recargo");
            model.addColumn("id Servicio");
            actualizarTabla();
        }
        return scrollPane;
    }
    // ========================================================================

    // Tabla con los contratos
    // ========================================================================
    private JTable getTableContrato() {
        if (tableContrato == null) {
            tableContrato = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableContrato.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        if (tableContrato.getSelectedRow() != -1) {
                            txtFResponsable.setText(lista.get(tableContrato.getSelectedRow()).getNom_resp());
                            txtFDescripcion.setText(lista.get(tableContrato.getSelectedRow()).getDesc_cont());
                            fechaConciliacion.setDate(lista.get(tableContrato.getSelectedRow()).getFecha_conc());
                            fechaInicio.setDate(lista.get(tableContrato.getSelectedRow()).getFecha_ini());
                            fechaFin.setDate(lista.get(tableContrato.getSelectedRow()).getFecha_term());

                            int size;
                            int[] pos = { -1, -1 };

                            if (listaProveedor.size() >= listaServicio.size())
                                size = listaProveedor.size();
                            else
                                size = listaServicio.size();

                            for (int i = 0; i < size && (pos[0] == -1 || pos[1] == -1); i++) {
                                if (listaProveedor.size() > i)
                                    if (listaProveedor.get(i).getId_proveedor() == lista
                                            .get(tableContrato.getSelectedRow()).getId_proveedor())
                                        pos[0] = i;
                                if (listaServicio.size() > i)
                                    if (listaServicio.get(i).getId_servicio() == lista.get(tableContrato.getSelectedRow()).getId_servicio())
                                        pos[1] = i;
                            }
                            comboBoxIdProveedor.setSelectedIndex(pos[0]);
                            comboBoxIdServicio.setSelectedIndex(pos[1]);
                            txtFRecargo.setText(String.valueOf(lista.get(tableContrato.getSelectedRow()).getRecargo()));
                        }
                    }
                }
            });
            tableContrato.getTableHeader().setReorderingAllowed(false);
        }
        return tableContrato;
    }

    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarContratos();
        for (Contrato a : lista) {

            Object[] ob = new Object[9];
            ob[0] = a.getId_contrato();
            ob[1] = a.getFecha_term();
            ob[2] = a.getFecha_ini();
            ob[3] = a.getFecha_conc();
            ob[4] = a.getDesc_cont();
            ob[5] = a.getNom_resp();
            ob[6] = a.getId_proveedor();
            ob[7] = a.getRecargo();
            ob[8] = a.getId_servicio();
            model.addRow(ob);
        }
        tableContrato.setModel(model);
    }
    // ========================================================================

    // Método para crear y agregar un contrato
    // ========================================================================
    public Contrato agregarContrato() {
        Contrato c = new Contrato();

        try {
            c.setId_proveedor(listaProveedor.get(comboBoxIdProveedor.getSelectedIndex()).getId_proveedor());
            c.setId_servicio(listaServicio.get(comboBoxIdServicio.getSelectedIndex()).getId_servicio());
            c.setFecha_ini(new java.sql.Date(fechaInicio.getDate().getTime()));
            c.setFecha_term(new java.sql.Date(fechaFin.getDate().getTime()));
            c.setFecha_conc((new java.sql.Date(fechaConciliacion.getDate().getTime())));
            c.setDesc_cont(txtFDescripcion.getText());
            c.setNom_resp(txtFResponsable.getText());
            c.setRecargo(Float.parseFloat(txtFRecargo.getText()));

            dao.insertarContrato(c);
            actualizarTabla();
            limpiar();
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return c;
    }
    // ========================================================================

    // Método para actualizar un contrato
    // ========================================================================
    public void actualizarContrato() {
        if (tableContrato.getSelectedRowCount() >= 1) {
            Contrato c = lista.get(tableContrato.getSelectedRow());

            if (comboBoxIdProveedor.getSelectedIndex() != -1)
                c.setId_proveedor(listaProveedor.get(comboBoxIdProveedor.getSelectedIndex()).getId_proveedor());
            if (comboBoxIdServicio.getSelectedIndex() != -1)
                c.setId_servicio(listaServicio.get(comboBoxIdServicio.getSelectedIndex()).getId_servicio());
            if (!txtFDescripcion.getText().isEmpty())
                c.setDesc_cont(txtFDescripcion.getText());
            if (!txtFResponsable.getText().isEmpty())
                c.setNom_resp(txtFResponsable.getText());
            if (!txtFRecargo.getText().isEmpty())
                c.setRecargo(Float.parseFloat(txtFRecargo.getText()));

            if (fechaInicio.getDate() != null)
                c.setFecha_ini(new java.sql.Date(fechaInicio.getDate().getTime()));
            if (fechaFin.getDate() != null)
                c.setFecha_term(new java.sql.Date(fechaFin.getDate().getTime()));
            if (fechaConciliacion.getDate() != null)
                c.setFecha_conc((new java.sql.Date(fechaConciliacion.getDate().getTime())));

            dao.actualizarContrato(c);
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    // Método para eliminar un contrato
    // ========================================================================
    public void eliminarContrato() {
        if (tableContrato.getSelectedRowCount() >= 1) {
            dao.eliminarContrato(lista.get(tableContrato.getSelectedRow()).getId_contrato());
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        txtFRecargo.setText("");
        txtFResponsable.setText("");
        comboBoxIdProveedor.setSelectedIndex(-1);
        comboBoxIdServicio.setSelectedIndex(-1);
        txtFDescripcion.setText("");
        fechaConciliacion.setDate(null);
        fechaInicio.setDate(null);
        fechaFin.setDate(null);
    }

    public void cargarListas() {
        DAOServicio daoServicio = new DAOServicio();
        DAOProveedor daoProveedor = new DAOProveedor();

        cargarComboBox();
        listaServicio = daoServicio.consultarServicios();
        listaProveedor = daoProveedor.consultarProveedores();
    }

    public void cargarComboBox(){

        comboBoxIdProveedor.removeAllItems();
        comboBoxIdServicio.removeAllItems();

        int x = 7;

        DAOServicio daoServicio = new DAOServicio();
        ArrayList<Servicio> a = daoServicio.consultarServicios();

        for (Servicio servicio : a) {
            comboBoxIdServicio.addItem("Id del Servicio: " + servicio.getId_servicio() + "    " + "Tipo: "
                    + servicio.getTipo_servicio());
        }
        comboBoxIdServicio.setSelectedIndex(-1);

        DAOProveedor daoProveedor = new DAOProveedor();
        ArrayList<Proveedor> proveedors = daoProveedor.consultarProveedores();

        for (Proveedor p : proveedors) {
            comboBoxIdProveedor.addItem(
                    "Id del Proveedor: " + p.getId_proveedor() + "    " + "Tipo: " + p.getTipo_proveedor());
        }
        comboBoxIdProveedor.setSelectedIndex(-1);
    }
}
