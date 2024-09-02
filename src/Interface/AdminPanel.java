package Interface;

import dao.DAOAdministrador;
import logic.Administrador;
import logic.Usuario;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminPanel extends JPanel {

    // Atributos
    // ========================================================================
    public static final int VALUE = 7;
    private JLabel lblNombAdmin;
    private JTextField txtFNombAdmin;

    private JLabel lblContrasenna;
    private JTextField pwdFContrasenna;

    private JScrollPane scrollPane;
    private JTable tableAdmin;

    private final DAOAdministrador dao = new DAOAdministrador();
    ArrayList<Administrador> lista;
    private final DefaultTableModel model = new DefaultTableModel();
    // ========================================================================


    // Constructor
    public AdminPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los administradores de la Base de Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184,184,184,255)));
        setLayout(null);
        setVisible(false);

        add(getLblNombAdmin());
        add(getTextFieldNombUsuario());

        add(getLblContrasenna());
        add(getPwdFContrasenna());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!tableAdmin.contains(e.getPoint()))
                    tableAdmin.clearSelection();
            }
        });
    }


    // Cosas del nombre de usuario
    // ========================================================================
    private JLabel getLblNombAdmin() {
        if (lblNombAdmin == null) {
            lblNombAdmin = new JLabel("Nombre de Usuario");
            lblNombAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            lblNombAdmin.setBounds(10, 30, 226, 29);
        }
        return lblNombAdmin;
    }


    // JTextField para asignar el nombre de usuario
    // ========================================================================
    private JTextField getTextFieldNombUsuario() {
        if (txtFNombAdmin == null) {
            txtFNombAdmin = new JTextField();
            txtFNombAdmin.setBounds(10, 60, 226, 28);
            txtFNombAdmin.setColumns(10);
        }
        return txtFNombAdmin;
    }
    // ========================================================================


    // Cosas de la Contraseña del usuario
    // ========================================================================
    private JLabel getLblContrasenna() {
        if (lblContrasenna == null) {
            lblContrasenna = new JLabel("Contraseña");
            lblContrasenna.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
            lblContrasenna.setBounds(10, 95, 80, 29);
        }
        return lblContrasenna;
    }

    private JTextField getPwdFContrasenna() {
        if (pwdFContrasenna == null) {
            pwdFContrasenna = new JTextField();
            pwdFContrasenna.setBounds(10, 120, 226, 28);

        }
        return pwdFContrasenna;
    }

    // ========================================================================


    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableAdmin());
            model.addColumn("Nombre");
            model.addColumn("Contraseña");
            actualizarTabla();
        }
        return scrollPane;
    }


    // Tabla de los Administradores
    // ========================================================================
    private JTable getTableAdmin() {
        if (tableAdmin == null) {
            tableAdmin = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableAdmin.getTableHeader().setReorderingAllowed(false);
            tableAdmin.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            "Nombre", "Contraseña"
                    }
            ));

            tableAdmin.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() ==1){
                        if(tableAdmin.getSelectedRow() != -1){
                            txtFNombAdmin.setText(lista.get(tableAdmin.getSelectedRow()).getNombre());
                            pwdFContrasenna.setText(lista.get(tableAdmin.getSelectedRow()).getContrasegna());
                        }
                    }
                }
            });
        }
        return tableAdmin;
    }


    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarAdministrador();
        for (Usuario u : lista) {

            Object[] ob = new Object[2];
            ob[0] = u.getNombre();
            ob[1] = u.getContrasegna();
            model.addRow(ob);
        }
        tableAdmin.setModel(model);
    }
    // ========================================================================


    // Método para eliminar el Administrador seleccionado
    // ========================================================================
    public void eliminarAdmin(Usuario user) {
        if (tableAdmin.getSelectedRowCount() >= 1) {
            Usuario u = lista.get(tableAdmin.getSelectedRow());

            if (!(user.getNombre().equals(u.getNombre()) && user.getContrasegna().equals(u.getContrasegna()))) {
                dao.eliminarAdministrador(u.getNombre());
                actualizarTabla();
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "No se puede eliminar a usted mismo", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================


    // Método para crear y agregar un Administrador
    // ========================================================================
    public void agregarAdmin() {
        Administrador a = new Administrador();

        a.setNombre(txtFNombAdmin.getText());
        a.setContrasegna(String.valueOf(pwdFContrasenna.getText()));

        dao.insertarAdministrador(a);
        actualizarTabla();

    }
    // ========================================================================


    // Método para actualizar los datos del Administrador seleccionado
    // ========================================================================
    public void actualizarAdminPanel() {
        if (tableAdmin.getSelectedRowCount() >= 1) {
            Administrador a = lista.get(tableAdmin.getSelectedRow());

            if (!txtFNombAdmin.getText().isEmpty())
                a.setNombre(txtFNombAdmin.getText());
            if (!String.valueOf(pwdFContrasenna.getText()).isEmpty())
                a.setContrasegna(String.valueOf(pwdFContrasenna.getText()));

            dao.actualizarAdministrador(a);
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una" +
                    " celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar() {
        txtFNombAdmin.setText("");
        pwdFContrasenna.setText("");

    }


}
