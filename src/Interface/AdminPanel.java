package Interface;

import dao.DAOAdministrador;
import dao.DAOUsuario;
import logic.Administrador;
import logic.Usuario;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPanel extends JPanel {

    // Atributos
    // ========================================================================
    public static final int VALUE = 7;
    private JLabel lblNombAdmin;
    private JTextField txtFNombAdmin;

    private JLabel lblContrasenna;
    private JPasswordField pwdFContrasenna;
    private JCheckBox chckbxShowPwd;

    private JScrollPane scrollPane;
    private JTable tableAdmin;

    private final DAOAdministrador dao = new DAOAdministrador();
    ArrayList<Administrador> lista;
    private final DefaultTableModel model = new DefaultTableModel();
    // ========================================================================


    // Constructor
    public AdminPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los administradores de la Base de Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(null);
        setVisible(false);

        add(getLblNombAdmin());
        add(getTextFieldNombUsuario());

        add(getLblContrasenna());
        add(getPwdFContrasenna());
        add(getChckbxNewCheckBox());

        add(getScrollPane());
    }


    // Cosas del nombre de usuario
    // ========================================================================
    private JLabel getLblNombAdmin() {
        if (lblNombAdmin == null) {
            lblNombAdmin = new JLabel("Nombre de Usuario");
            lblNombAdmin.setFont(new Font("Bahnschrift", Font.BOLD, 14));
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
            lblContrasenna.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblContrasenna.setBounds(10, 95, 80, 29);
        }
        return lblContrasenna;
    }

    private JPasswordField getPwdFContrasenna() {
        if (pwdFContrasenna == null) {
            pwdFContrasenna = new JPasswordField();
            pwdFContrasenna.setBounds(10, 120, 226, 28);
            pwdFContrasenna.setFont(new Font("Bahnschrift", Font.BOLD, 16));
            pwdFContrasenna.setEchoChar('*');

        }
        return pwdFContrasenna;
    }


    private JCheckBox getChckbxNewCheckBox() {
        if (chckbxShowPwd == null) {
            chckbxShowPwd = new JCheckBox("Mostrar Contraseña");
            chckbxShowPwd.setBounds(10, 152, 148, 23);

            chckbxShowPwd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (chckbxShowPwd.isSelected())
                        pwdFContrasenna.setEchoChar((char) 0);
                    else
                        pwdFContrasenna.setEchoChar('*');
                }
            });
        }
        return chckbxShowPwd;
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


    // Tabla del Cuidado diario de los animales
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


    // Método para eliminar una Actividad de Cuidado Diario
    // ========================================================================
    public void eliminarAdmin() {
        if (tableAdmin.getSelectedRowCount() >= 1) {
            Usuario u = lista.get(tableAdmin.getSelectedRow());
            dao.eliminarAdministrador(u.getNombre());
            actualizarTabla();
        } else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================


    // Método para crear y agregar una Actividad de Cuidado Diario
    // ========================================================================
    public void agregarAdmin() {
        Administrador a = new Administrador();

        a.setNombre(txtFNombAdmin.getText());
        a.setContrasegna(String.valueOf(pwdFContrasenna.getPassword()));

        dao.insertarAdministrador(a);
        actualizarTabla();

    }
    // ========================================================================


    // Método para actualizar una Actividad de Cuidado Diario
    // ========================================================================
    public void actualizarAdminPanel() {
        if (tableAdmin.getSelectedRowCount() >= 1) {
            Administrador a = lista.get(tableAdmin.getSelectedRow());

            if (!txtFNombAdmin.getText().isEmpty())
                a.setNombre(txtFNombAdmin.getText());
            if (!String.valueOf(pwdFContrasenna.getPassword()).isEmpty())
                a.setContrasegna(String.valueOf(pwdFContrasenna.getPassword()));

            dao.actualizarAdministrador(a);
            actualizarTabla();
        } else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar() {
        txtFNombAdmin.setText("");
        pwdFContrasenna.setText("");

    }


}
