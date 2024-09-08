package Interface;

import dao.DAOProvincia;
import logic.Provincia;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProvinciaPanel extends JPanel {


    // Atributos
    // ========================================================================
    public static final int VALUE = 7;
    private JLabel lblNombUsuario;
    private JTextField txtFNombUsuario;

    private JLabel lblIdProvincia;
    private JTextFieldSoloNumeros txtFIdProvincia;

    private JScrollPane scrollPane;
    private JTable tableProvincia;

    private final DAOProvincia dao = new DAOProvincia();
    private ArrayList<Provincia> lista;
    private final DefaultTableModel model = new DefaultTableModel();
    // ========================================================================


    // Constructor
    public ProvinciaPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gestión de provincias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184, 184, 184, 255)));
        setLayout(null);
        setVisible(false);

        add(getLblNombUsuario());
        add(getTextFieldNombUsuario());

        add(getLblIdProvincia());
        add(getTxtFIdProvincia());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!tableProvincia.contains(e.getPoint()))
                    tableProvincia.clearSelection();
            }
        });
    }


    // Cosas del nombre de usuario
    // ========================================================================
    private JLabel getLblNombUsuario() {
        if (lblNombUsuario == null) {
            lblNombUsuario = new JLabel("Nombre de Provincia");
            lblNombUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            lblNombUsuario.setBounds(10, 30, 226, 15);
        }
        return lblNombUsuario;
    }


    // JTextField para asignar el nombre de usuario
    // ========================================================================
    private JTextField getTextFieldNombUsuario() {
        if (txtFNombUsuario == null) {
            txtFNombUsuario = new JTextField();
            txtFNombUsuario.setBounds(10, 60, 226, 28);
            txtFNombUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            txtFNombUsuario.setColumns(10);
        }
        return txtFNombUsuario;
    }
    // ========================================================================


    // Cosas de la Contraseña del usuario
    // ========================================================================
    private JLabel getLblIdProvincia() {
        if (lblIdProvincia == null) {
            lblIdProvincia = new JLabel("Id de Provincia");
            lblIdProvincia.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            lblIdProvincia.setBounds(10, 95, 100, 15);
        }
        return lblIdProvincia;
    }

    private JTextFieldSoloNumeros getTxtFIdProvincia() {
        if (txtFIdProvincia == null) {
            txtFIdProvincia = new JTextFieldSoloNumeros();
            txtFIdProvincia.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            txtFIdProvincia.setBounds(10, 120, 226, 28);

        }
        return txtFIdProvincia;
    }

    // ========================================================================


    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableProvincia());
            model.addColumn("Nombre");
            model.addColumn("Contraseña");
            actualizarTabla();
        }
        return scrollPane;
    }


    // Tabla del Cuidado diario de los animales
    // ========================================================================
    private JTable getTableProvincia() {
        if (tableProvincia == null) {
            tableProvincia = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableProvincia.getTableHeader().setReorderingAllowed(false);
            tableProvincia.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null},
                            {null, null},
                    },
                    new String[]{
                            "Id de Provincia", "Nombre"
                    }
            ));

            tableProvincia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        if (tableProvincia.getSelectedRow() != -1) {
                            txtFNombUsuario.setText(lista.get(tableProvincia.getSelectedRow()).getNombre());
                            txtFIdProvincia.setText(String.valueOf(lista.get(tableProvincia.getSelectedRow()).getId_provinvcia()));
                        }
                    }
                }
            });
        }
        return tableProvincia;
    }


    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarProvincia();
        for (Provincia u : lista) {

            Object[] ob = new Object[2];
            ob[0] = u.getId_provinvcia();
            ob[1] = u.getNombre();
            model.addRow(ob);
        }
        tableProvincia.setModel(model);
    }
    // ========================================================================


    // Método para eliminar una Actividad de Cuidado Diario
    // ========================================================================
    public void eliminarProvincia() {

        if (tableProvincia.getSelectedRowCount() >= 1) {
            Provincia p = lista.get(tableProvincia.getSelectedRow());
            dao.eliminarProvincia(p.getId_provinvcia());
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================


    // Método para crear y agregar una Actividad de Cuidado Diario
    // ========================================================================
    public void agregarProvincia() {
        Provincia p = new Provincia();

        p.setNombre(txtFNombUsuario.getText());
        p.setId_provinvcia(Integer.parseInt(txtFIdProvincia.getText()));

        dao.insertarProvincia(p);
        actualizarTabla();

    }
    // ========================================================================



    // ========================================================================
    public void actualizarProvinciaPanel() {
        if (tableProvincia.getSelectedRowCount() >= 1) {
            Provincia p = lista.get(tableProvincia.getSelectedRow());

            if (!txtFNombUsuario.getText().isEmpty())
                p.setNombre(txtFNombUsuario.getText());
            if (!txtFIdProvincia.getText().isEmpty())
                p.setId_provinvcia(Integer.parseInt(txtFIdProvincia.getText()));

            dao.actualizarProvincia(p);
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar() {
        txtFNombUsuario.setText("");
        txtFIdProvincia.setText("");

    }


}
