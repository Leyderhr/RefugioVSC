package Interface;


import dao.DAORol;
import logic.Rol;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RolPanel extends JPanel {

    // Atributos
    // ========================================================================
    public static final int VALUE = 8;
    private JLabel lblRol;
    private JTextField txtFRol;

    private JLabel lblIdRol;
    private JTextFieldSoloNumeros txtFIdRol;

    private JScrollPane scrollPane;
    private JTable tableRol;

    private final DAORol dao = new DAORol();
    private ArrayList<Rol> lista;
    private final DefaultTableModel model = new DefaultTableModel();
    // ========================================================================


    // Constructor
    public RolPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gestión de roles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184, 184, 184, 255)));
        setLayout(null);
        setVisible(false);

        add(getLblRol());
        add(getTextFieldRol());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!tableRol.contains(e.getPoint()))
                    tableRol.clearSelection();
            }
        });
    }


    // Cosas del nombre de usuario
    // ========================================================================
    private JLabel getLblRol() {
        if (lblRol == null) {
            lblRol = new JLabel("Tipo de rol");
            lblRol.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            lblRol.setBounds(10, 30, 226, 15);
        }
        return lblRol;
    }


    // JTextField para asignar el nombre de usuario
    // ========================================================================
    private JTextField getTextFieldRol() {
        if (txtFRol == null) {
            txtFRol = new JTextField();
            txtFRol.setBounds(10, 60, 226, 28);
            txtFRol.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            txtFRol.setColumns(10);
        }
        return txtFRol;
    }
    // ========================================================================


    // Cosas de la Contraseña del usuario
    // ========================================================================




    // ========================================================================


    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableRol());
            model.addColumn("Id de Rol");
            model.addColumn("Tipo de rol");
            actualizarTabla();
        }
        return scrollPane;
    }


    // Tabla del Cuidado diario de los animales
    // ========================================================================
    private JTable getTableRol() {
        if (tableRol == null) {
            tableRol = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableRol.getTableHeader().setReorderingAllowed(false);
            tableRol.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null},
                            {null, null},
                    },
                    new String[]{
                            "Id de Rol", "Tipo de rol"
                    }
            ));

            tableRol.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        if (tableRol.getSelectedRow() != -1) {
                            txtFRol.setText(lista.get(tableRol.getSelectedRow()).getRol());
                        }
                    }
                }
            });
        }
        return tableRol;
    }


    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarRol();
        for (Rol r : lista) {

            Object[] ob = new Object[2];
            ob[0] = r.getId();
            ob[1] = r.getRol();
            model.addRow(ob);
        }
        tableRol.setModel(model);
    }
    // ========================================================================


    // Método para eliminar una Actividad de Cuidado Diario
    // ========================================================================
    public void eliminarRol() {

        if (tableRol.getSelectedRowCount() >= 1) {
            Rol r = lista.get(tableRol.getSelectedRow());
            dao.eliminarRol(r.getId());
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================


    // Método para crear y agregar una Actividad de Cuidado Diario
    // ========================================================================
    public void agregarRol() {
        Rol r = new Rol();

        r.setRol(txtFRol.getText());

        dao.insertarRol(r);
        actualizarTabla();

    }
    // ========================================================================



    // ========================================================================
    public void actualizarRolPanel() {
        if (tableRol.getSelectedRowCount() >= 1) {
            Rol r = lista.get(tableRol.getSelectedRow());

            if (!txtFRol.getText().isEmpty())
                r.setRol(txtFRol.getText());
            if (!txtFIdRol.getText().isEmpty())
                r.setId(Integer.parseInt(txtFIdRol.getText()));

            dao.actualizarRol(r);
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar() {
        txtFRol.setText("");
        txtFIdRol.setText("");

    }

}
