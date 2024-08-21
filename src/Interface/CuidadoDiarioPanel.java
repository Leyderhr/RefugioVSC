package Interface;

import com.toedter.calendar.JDateChooser;
import dao.DAOActividadCuidadoDiario;
import logic.ActividadCuidadoDiario;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CuidadoDiarioPanel extends JPanel {


    // Atributos
    // ========================================================================
    public static final int VALUE = 5;
    private JLabel lblFecha;
    private JDateChooser fecha;

    private JLabel lblHora;
    private JSpinner spinnerHora;

    private JScrollPane scrollPane;
    private JTable tableActividad;

    private JLabel lblDescActividad;
    private JTextField txtFDescActividad;

    private JLabel lblIdAnimal;
    private JTextFieldSoloNumeros txtFIdAnimal;

    private JLabel lblIdContrato;
    private JTextFieldSoloNumeros txtFIdContrato;

    private final DAOActividadCuidadoDiario dao = new DAOActividadCuidadoDiario();
    ArrayList<ActividadCuidadoDiario> lista;
    private DefaultTableModel model = new DefaultTableModel();
    // ========================================================================


    // Constructor
    public CuidadoDiarioPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de las Actividades de Cuidado Diario Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(null);
        setVisible(false);
        add(getLblFecha());
        add(getFecha());
        //add(getSpinnerFecha());

        add(getSpinnerHora());
        add(getLblHora());
        add(getScrollPane());
        add(getLblDescActividad());
        add(getTextFieldDescAct());
        add(getLblIdAnimal());
        add(getTxtDIdAnimal());
        add(getLblIdContrato());
        add(getTxtDIdContrato());

    }


    // Cosas de la Fecha
    // ========================================================================
    private JLabel getLblFecha() {
        if (lblFecha == null) {
            lblFecha = new JLabel("Fecha");
            lblFecha.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFecha.setBounds(10, 30, 66, 29);
        }
        return lblFecha;
    }


    // JDateChooser para asignar la fecha de finalización del contrato
    // ========================================================================
    private JDateChooser getFecha() {
        if (fecha == null) {
            fecha = new JDateChooser();
            fecha.setBounds(102, 36, 131, 20);
            fecha.setMinSelectableDate(Calendar.getInstance().getTime());
        }
        return fecha;
    }
    // ========================================================================


    // Cosas de la Hora
    // ========================================================================
    private JLabel getLblHora() {
        if (lblHora == null) {
            lblHora = new JLabel("Hora");
            lblHora.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblHora.setBounds(10, 79, 76, 29);
        }
        return lblHora;
    }


    private JSpinner getSpinnerHora() {
        if (spinnerHora == null) {

            Date hoy = Calendar.getInstance().getTime();
            SpinnerDateModel modelo = new SpinnerDateModel(hoy, null, null, Calendar.DAY_OF_MONTH);

            spinnerHora = new JSpinner();
            spinnerHora.setModel(modelo);
            spinnerHora.setBounds(102, 85, 131, 20);
            JSpinner.DateEditor de = new JSpinner.DateEditor(spinnerHora, "HH:mm");
            spinnerHora.setEditor(de);
        }

        return spinnerHora;
    }
    // ========================================================================


    // Cosas de la Descripción de la Actividad Diaria
    // ========================================================================
    private JLabel getLblDescActividad() {
        if (lblDescActividad == null) {
            lblDescActividad = new JLabel("Desc. Actividad");
            lblDescActividad.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblDescActividad.setBounds(10, 125, 130, 29);
        }
        return lblDescActividad;
    }


    private JTextField getTextFieldDescAct() {
        if (txtFDescActividad == null) {
            txtFDescActividad = new JTextField();
            txtFDescActividad.setBounds(10, 160, 226, 28);
            txtFDescActividad.setColumns(10);
        }
        return txtFDescActividad;
    }
    // =========================================================================


    // Cosas del Id del Animal
    //=========================================================================
    private JLabel getLblIdAnimal() {
        if (lblIdAnimal == null) {
            lblIdAnimal = new JLabel("Id. Animal");
            lblIdAnimal.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblIdAnimal.setBounds(10, 208, 70, 29);
        }
        return lblIdAnimal;
    }


    private JTextFieldSoloNumeros getTxtDIdAnimal() {
        if (txtFIdAnimal == null) {
            txtFIdAnimal = new JTextFieldSoloNumeros();
            txtFIdAnimal.setBounds(10, 242, 70, 28);
            txtFIdAnimal.setColumns(10);
        }
        return txtFIdAnimal;
    }
    // ========================================================================


    // Cosas del Id del Contrato
    // ========================================================================
    private JLabel getLblIdContrato() {
        if (lblIdContrato == null) {
            lblIdContrato = new JLabel("Id. Contrato");
            lblIdContrato.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblIdContrato.setBounds(150, 208, 90, 29);
        }
        return lblIdContrato;
    }


    private JTextFieldSoloNumeros getTxtDIdContrato() {
        if (txtFIdContrato == null) {
            txtFIdContrato = new JTextFieldSoloNumeros();
            txtFIdContrato.setBounds(150, 242, 90, 28);
            txtFIdContrato.setColumns(10);
        }
        return txtFIdContrato;
    }
    // ========================================================================


    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableActividad());
            model.addColumn("Fecha");
            model.addColumn("Hora");
            model.addColumn("Descripción");
            model.addColumn("id Animal");
            model.addColumn("id Contrato");
            actualizarTabla();
        }
        return scrollPane;
    }


    // Tabla del Cuidado diario de los animales
    // ========================================================================
    private JTable getTableActividad() {
        if (tableActividad == null) {
            tableActividad = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableActividad.getTableHeader().setReorderingAllowed(false);
            tableActividad.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            "Id", "Fecha", "Hora", "Desc. Actividad", "Id Animal", "Id Contrato"
                    }
            ));
        }
        return tableActividad;
    }


    public void actualizarTabla() {

        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarACD();
        for (ActividadCuidadoDiario a : lista) {

            Object[] ob = new Object[9];
            ob[0] = a.getFecha();
            ob[1] = a.getHora();
            ob[2] = a.getDesc_act();
            ob[3] = a.getId_animal();
            ob[4] = a.getId_contrato();
            model.addRow(ob);
        }
        tableActividad.setModel(model);
    }
    // ========================================================================


    // Método para eliminar una Actividad de Cuidado Diario
    // ========================================================================
    public void eliminarActividad() {

        if(tableActividad.getSelectedRowCount() >= 1) {
            ActividadCuidadoDiario ac = lista.get(tableActividad.getSelectedRow());
            dao.eliminarACD(ac.getFecha(), ac.getHora(), ac.getId_animal());
            actualizarTabla();
        }else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================


    // Método para crear y agregar una Actividad de Cuidado Diario
    // ========================================================================
    public void agregarDiarioPanel() {
        ActividadCuidadoDiario ac = new ActividadCuidadoDiario();

        ac.setDesc_act(txtFDescActividad.getText());
        ac.setFecha(new java.sql.Date(fecha.getDate().getTime()));
        ac.setHora(new Time(((Date) (spinnerHora.getValue())).getTime()));
        ac.setId_animal(Integer.parseInt(txtFIdAnimal.getText()));
        ac.setId_contrato(Integer.parseInt(txtFIdContrato.getText()));

        dao.insertarACD(ac);
        actualizarTabla();

    }
    // ========================================================================


    // Método para actualizar una Actividad de Cuidado Diario
    // ========================================================================
    public void actualizarDiarioPanel() {
        if(tableActividad.getSelectedRowCount() >= 1) {
            ActividadCuidadoDiario ac = lista.get(tableActividad.getSelectedRow());

            if (!txtFDescActividad.getText().isEmpty())
                ac.setDesc_act(txtFDescActividad.getText());
            if (!txtFIdAnimal.getText().isEmpty())
                ac.setId_animal(Integer.parseInt(txtFIdAnimal.getText()));
            if (!txtFIdContrato.getText().isEmpty())
                ac.setId_contrato(Integer.parseInt(txtFIdContrato.getText()));

            if (fecha.getDate() != null)
                ac.setFecha(new java.sql.Date(fecha.getDate().getTime()));

            dao.actualizarACD(ac);
            actualizarTabla();
        }
        else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar(){
        txtFDescActividad.setText("");
        txtFIdAnimal.setText("");
        txtFIdContrato.setText("");
        fecha.setDate(null);
        spinnerHora.setValue(Calendar.getInstance().getTime());

    }
}
