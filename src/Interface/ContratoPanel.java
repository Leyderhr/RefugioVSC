package Interface;


import com.toedter.calendar.JDateChooser;
import dao.DAOContrato;
import logic.Contrato;
import util.JTextFieldNumerosFlotantes;
import util.JTextFieldSoloLetras;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JTextFieldSoloNumeros txtFIDServicio;

    private JLabel lblIDProveedor;
    private JTextFieldSoloNumeros txtFIDProveedor;

    private JLabel lblFechConciliacion;
    private JDateChooser fechaConciliacion;

    private JLabel lblFechInicio;
    private JDateChooser fechaInicio;

    private JLabel lblFechFin;
    //   private JSpinner spinnerFechFin;
    private JDateChooser fechaFin;

    private JLabel lblRecargo;
    private JTextFieldNumerosFlotantes txtFRecargo;

    private JScrollPane scrollPane;
    private JTable tableContrato;
    private final DefaultTableModel model = new DefaultTableModel();

    private final DAOContrato dao = new DAOContrato();
    ArrayList<Contrato> lista;
    // ========================================================================


    public ContratoPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
        add(getTxtFIDServicio());

        add(getLblIDProveedor());
        add(getTxtFIDProveedor());

        add(getLblRecargo());
        add(getTxtFRecargo());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!tableContrato.contains(e.getPoint()))
                    tableContrato.clearSelection();
            }
        });
    }


    //Cosas del Responsable
    //=========================================================================
    private JLabel getLblResponsable() {
        if (lblResponsable == null) {
            lblResponsable = new JLabel("Responsable");
            lblResponsable.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblResponsable.setBounds(10, 30, 87, 29);
        }
        return lblResponsable;
    }

    private JTextFieldSoloLetras getTxtFResponsable() {
        if (txtFResponsable == null) {
            txtFResponsable = new JTextFieldSoloLetras();
            txtFResponsable.setBounds(102, 36, 131, 20);
            txtFResponsable.setColumns(10);
        }
        return txtFResponsable;
    }
    //=========================================================================


    //Cosas de la Descripción
    //=========================================================================
    private JTextFieldSoloLetras getTxtFDescripcion() {
        if (txtFDescripcion == null) {
            txtFDescripcion = new JTextFieldSoloLetras();
            txtFDescripcion.setColumns(10);
            txtFDescripcion.setBounds(102, 85, 131, 20);
        }
        return txtFDescripcion;
    }

    private JLabel getLblDescripcion() {
        if (lblDescripcion == null) {
            lblDescripcion = new JLabel("Descripción");
            lblDescripcion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblDescripcion.setBounds(10, 79, 87, 29);
        }
        return lblDescripcion;
    }
    //=========================================================================


    //Cosas de la Fecha de Conciliación
    //=========================================================================
    private JLabel getLblFechaConciliacion() {
        if (lblFechConciliacion == null) {
            lblFechConciliacion = new JLabel("Fecha de Conciliación");
            lblFechConciliacion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechConciliacion.setBounds(10, 128, 171, 29);
        }
        return lblFechConciliacion;
    }


    // JDateChooser para asignar la fecha de la conciliación del contrato
    // ========================================================================
    private JDateChooser getFechaConciliacion() {
        if (fechaConciliacion == null) {
            fechaConciliacion = new JDateChooser();
            fechaConciliacion.setBounds(163, 130, 100, 20);
            fechaConciliacion.setMaxSelectableDate(Calendar.getInstance().getTime());
        }
        return fechaConciliacion;
    }
    // ========================================================================


    //Cosas de la Fecha de Inicio
    //=========================================================================
    private JLabel getLblFechaInicio() {
        if (lblFechInicio == null) {
            lblFechInicio = new JLabel("Fecha de Inicio");
            lblFechInicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechInicio.setBounds(10, 160, 171, 29);
        }
        return lblFechInicio;
    }


    // JDateChooser para asignar la fecha de la inicio del contrato
    // ========================================================================
    private JDateChooser getFechaInicio() {
        if (fechaInicio == null) {
            fechaInicio = new JDateChooser();
            fechaInicio.setBounds(163, 162, 100, 20);
        }
        return fechaInicio;
    }
    // ========================================================================


    //Cosas de la Fecha de Terminación
    //=========================================================================
    private JLabel getLblFechaFin() {
        if (lblFechFin == null) {
            lblFechFin = new JLabel("Fecha de Finalización");
            lblFechFin.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFechFin.setBounds(10, 200, 171, 29);
        }
        return lblFechFin;
    }

    // JDateChooser para asignar la fecha de finalización del contrato
    // ========================================================================
    private JDateChooser getFechaFin() {
        if (fechaFin == null) {
            fechaFin = new JDateChooser();
            fechaFin.setBounds(163, 202, 100, 20);
        }
        return fechaFin;
    }
    // ========================================================================


    //Cosas para el ID de Servicio
    //=========================================================================
    private JLabel getLblIDServicio() {
        if (lblIDServicio == null) {
            lblIDServicio = new JLabel("Id. Servicio");
            lblIDServicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblIDServicio.setBounds(10, 238, 181, 29);
        }
        return lblIDServicio;
    }


    private JTextField getTxtFIDServicio() {
        if (txtFIDServicio == null) {
            txtFIDServicio = new JTextFieldSoloNumeros();
            txtFIDServicio.setColumns(10);
            txtFIDServicio.setBounds(102, 240, 131, 20);
        }
        return txtFIDServicio;
    }
    //=========================================================================


    //Cosas para seleccionar el id del Proveedor
    //=========================================================================
    private JLabel getLblIDProveedor() {
        if (lblIDProveedor == null) {
            lblIDProveedor = new JLabel("Id. Proveedor");
            lblIDProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 13));
            lblIDProveedor.setBounds(10, 280, 181, 29);
        }
        return lblIDProveedor;
    }

    private JTextFieldSoloNumeros getTxtFIDProveedor() {
        if (txtFIDProveedor == null) {
            txtFIDProveedor = new JTextFieldSoloNumeros();
            txtFIDProveedor.setColumns(10);
            txtFIDProveedor.setBounds(102, 282, 131, 20);
        }
        return txtFIDProveedor;
    }
    //=========================================================================


    //Cosas para el Recargo
    //=========================================================================
    private JLabel getLblRecargo() {
        if (lblRecargo == null) {
            lblRecargo = new JLabel("Recargo");
            lblRecargo.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblRecargo.setBounds(10, 318, 181, 29);
        }
        return lblRecargo;
    }


    private JTextFieldNumerosFlotantes getTxtFRecargo() {
        if (txtFRecargo == null) {
            txtFRecargo = new JTextFieldNumerosFlotantes();
            txtFRecargo.setColumns(10);
            txtFRecargo.setBounds(102, 320, 131, 20);
        }
        return txtFRecargo;
    }
    //=========================================================================


    //Panel de Scroll de la Tabla
    //=========================================================================
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
            c.setId_proveedor(Integer.parseInt(txtFIDProveedor.getText()));
            c.setId_servicio(Integer.parseInt(txtFIDServicio.getText()));
            c.setFecha_ini(new java.sql.Date(fechaInicio.getDate().getTime()));
            c.setFecha_term(new java.sql.Date(fechaFin.getDate().getTime()));
            c.setFecha_conc((new java.sql.Date(fechaConciliacion.getDate().getTime())));
            c.setDesc_cont(txtFDescripcion.getText());
            c.setNom_resp(txtFResponsable.getText());
            c.setRecargo(Float.parseFloat(txtFRecargo.getText()));

            dao.insertarContrato(c);
            actualizarTabla();
            limpiar();
        }catch (Exception e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se puede agregar un animal si algún campo está" +
                    " vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return c;
    }
    // ========================================================================


    // Método para actualizar un contrato
    // ========================================================================
    public void actualizarContrato() {
        if (tableContrato.getSelectedRowCount() >= 1) {
            Contrato c = lista.get(tableContrato.getSelectedRow());

            if (!txtFIDProveedor.getText().isEmpty())
                c.setId_proveedor(Integer.parseInt(txtFIDProveedor.getText()));
            if (!txtFIDServicio.getText().isEmpty())
                c.setId_servicio(Integer.parseInt(txtFIDServicio.getText()));
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
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        txtFRecargo.setText("");
        txtFResponsable.setText("");
        txtFIDProveedor.setText("");
        txtFIDServicio.setText("");
        txtFDescripcion.setText("");
        fechaConciliacion.setDate(null);
        fechaInicio.setDate(null);
        fechaFin.setDate(null);
    }

}
