package Interface;

import dao.DAOUsuario;
import logic.Usuario;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class UsuarioPanel extends JPanel {


    // Atributos
    // ========================================================================
    public static final int VALUE = 6;
    private JLabel lblNombUsuario;
    private JTextField txtFNombUsuario;

    private JLabel lblContrasenna;
    private JPasswordField pwdFContrasenna;
    private JCheckBox chckbxShowPwd;

    private JScrollPane scrollPane;
    private JTable tableUsuario;

    private final DAOUsuario dao = new DAOUsuario();
    ArrayList<Usuario> lista;
    private final DefaultTableModel model = new DefaultTableModel();
    // ========================================================================


    // Constructor
    public UsuarioPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los usuarios con acceso a la Base de Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(null);
        setVisible(false);

        add(getLblNombUsuario());
        add(getTextFieldNombUsuario());

        add(getLblContrasenna());
        add(getPwdFContrasenna());
        add(getChckbxNewCheckBox());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!tableUsuario.contains(e.getPoint()))
                    tableUsuario.clearSelection();
            }
        });
    }


    // Cosas del nombre de usuario
    // ========================================================================
    private JLabel getLblNombUsuario() {
        if (lblNombUsuario == null) {
            lblNombUsuario = new JLabel("Nombre de Usuario");
            lblNombUsuario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblNombUsuario.setBounds(10, 30, 226, 29);
        }
        return lblNombUsuario;
    }



    // JTextField para asignar el nombre de usuario
    // ========================================================================
    private JTextField getTextFieldNombUsuario() {
        if (txtFNombUsuario == null) {
            txtFNombUsuario = new JTextField();
            txtFNombUsuario.setBounds(10, 60, 226, 28);
            txtFNombUsuario.setColumns(10);
        }
        return txtFNombUsuario;
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
            scrollPane.setViewportView(getTableUsuario());
            model.addColumn("Nombre");
            model.addColumn("Contraseña");
            actualizarTabla();
        }
        return scrollPane;
    }


    // Tabla del Cuidado diario de los animales
    // ========================================================================
    private JTable getTableUsuario() {
        if (tableUsuario == null) {
            tableUsuario = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableUsuario.getTableHeader().setReorderingAllowed(false);
            tableUsuario.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            "Nombre", "Contraseña"
                    }
            ));
        }
        return tableUsuario;
    }


    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarUsuario();
        for (Usuario u : lista) {

            Object[] ob = new Object[2];
            ob[0] = u.getNombre();
            ob[1] = u.getContrasegna();
            model.addRow(ob);
        }
        tableUsuario.setModel(model);
    }
    // ========================================================================


    // Método para eliminar una Actividad de Cuidado Diario
    // ========================================================================
    public void eliminarUsuario() {

        if (tableUsuario.getSelectedRowCount() >= 1) {
            Usuario u = lista.get(tableUsuario.getSelectedRow());
            dao.eliminarUsuario(u.getNombre());
            actualizarTabla();
        }
        else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================


    // Método para crear y agregar una Actividad de Cuidado Diario
    // ========================================================================
    public void agregarUsuario() {
        Usuario u = new Usuario();

        u.setNombre(txtFNombUsuario.getText());
        u.setContrasegna(String.valueOf(pwdFContrasenna.getPassword()));

        dao.insertarUsuario(u);
        actualizarTabla();

    }
    // ========================================================================


    // Método para actualizar una Actividad de Cuidado Diario
    // ========================================================================
    public void actualizarUsuarioPanel() {
        if (tableUsuario.getSelectedRowCount() >= 1) {
            Usuario u = lista.get(tableUsuario.getSelectedRow());

            if (!txtFNombUsuario.getText().isEmpty())
                u.setNombre(txtFNombUsuario.getText());
            if (!String.valueOf(pwdFContrasenna.getPassword()).isEmpty())
                u.setContrasegna(String.valueOf(pwdFContrasenna.getPassword()));

            dao.actualizarUsuario(u);
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede actualizar si no tiene seleccionada una celda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    public void limpiar() {
        txtFNombUsuario.setText("");
        pwdFContrasenna.setText("");

    }


}
