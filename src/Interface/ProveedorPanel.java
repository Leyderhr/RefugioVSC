package Interface;

import dao.*;
import logic.*;
import util.JTextFieldSoloLetras;
import util.JTextFieldSoloNumeros;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProveedorPanel extends JPanel {

    // Atributos de la clase
    // ========================================================================
    public static final int VALUE = 2;
    private JLabel lblNombre;
    private JTextField txtFNombre;

    private JTextField txtFDireccion;
    private JLabel lblDireccion;

    private JTextFieldSoloNumeros txtFTelefono;
    private JLabel lblTelefono;

    private JComboBox<String> comboBoxProvincia;
    private JLabel lblProvincia;

    private JTextField txtFEmail;
    private JLabel lblEmail;

    // Atributos correspondientes a la selección del tipo de Proveedor
    private JLabel lblRepresentante;
    private JTextFieldSoloLetras txtFRepresentante;
    private JLabel lblTipoProveedor;
    private JComboBox<String> comboBoxTipoProveedor;
    private JLabel lblFax;
    private JTextField txtFFax;
    private JLabel lblEspecialidad;
    private JTextFieldSoloLetras txtFEspecialidad;
    private JLabel lblClinica;
    private JTextFieldSoloLetras txtFClinica;

    private JScrollPane scrollPane;
    private JTable tableProveedor;
    private final DAOProveedor dao = new DAOProveedor();
    private ArrayList<Proveedor> lista;
    private ArrayList<Provincia> listaProvincia;
    private final DefaultTableModel model = new DefaultTableModel();
    // ========================================================================

    public ProveedorPanel() {
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Proveedores",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(184, 184, 184, 255)));
        setLayout(null);
        setVisible(false);

        add(getLblNombre());
        add(getTxtFNombre());

        add(getTxtFDireccion());
        add(getLblDireccion());

        add(getTxtFTelefono());
        add(getLblTelefono());

        add(getComboBoxProvincia());
        add(getLblProvincia());

        add(getTxtFEmail());
        add(getLblEmail());

        add(getLblTipoProveedor());
        add(getComboBoxTipoProveedor());

        add(getLblRepresentante());
        add(getTxtFRepresentante());

        add(getLblFax());
        add(getTxtFFax());

        add(getLblEspecialidad());
        add(getTxtFEspecialidad());

        add(getLblClinica());
        add(getTxtFClinica());

        add(getScrollPane());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!tableProveedor.contains(e.getPoint()))
                    tableProveedor.clearSelection();
            }
        });
    }

    private JLabel getLblNombre() {
        if (lblNombre == null) {
            lblNombre = new JLabel("Nombre");
            lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblNombre.setBounds(10, 36, 66, 15);
        }
        return lblNombre;
    }

    private JTextField getTxtFNombre() {
        if (txtFNombre == null) {
            txtFNombre = new JTextField();
            txtFNombre.setBounds(102, 30, 131, 28);
            txtFNombre.setColumns(10);
        }
        return txtFNombre;
    }

    private JLabel getLblDireccion() {
        if (lblDireccion == null) {
            lblDireccion = new JLabel("Dirección");
            lblDireccion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblDireccion.setBounds(10, 74, 76, 15);
        }
        return lblDireccion;
    }

    private JTextField getTxtFDireccion() {
        if (txtFDireccion == null) {
            txtFDireccion = new JTextField();
            txtFDireccion.setColumns(10);
            txtFDireccion.setBounds(102, 68, 131, 28);
        }
        return txtFDireccion;
    }

    private JLabel getLblTelefono() {
        if (lblTelefono == null) {
            lblTelefono = new JLabel("Teléfono");
            lblTelefono.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblTelefono.setBounds(10, 116, 66, 15);
        }
        return lblTelefono;
    }

    private JTextFieldSoloNumeros getTxtFTelefono() {
        if (txtFTelefono == null) {
            txtFTelefono = new JTextFieldSoloNumeros();
            txtFTelefono.setLimite(8);
            txtFTelefono.setBounds(102, 106, 131, 28);
        }
        return txtFTelefono;
    }

    private JLabel getLblProvincia() {
        if (lblProvincia == null) {
            lblProvincia = new JLabel("Provincia");
            lblProvincia.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblProvincia.setBounds(10, 150, 76, 15);
        }
        return lblProvincia;
    }

    private JComboBox<String> getComboBoxProvincia() {
        if (comboBoxProvincia == null) {
            comboBoxProvincia = new JComboBox<>();
            comboBoxProvincia.setBounds(102, 144, 131, 28);
            comboBoxProvincia.setVisible(true);

            DAOProvincia daoProvincia = new DAOProvincia();
            ArrayList<Provincia> provincias = daoProvincia.consultarProvincia();

            for (Provincia p : provincias) {
                comboBoxProvincia.addItem("Id:" + p.getId_provinvcia() + "  " + p.getNombre());
            }
            comboBoxProvincia.setSelectedIndex(-1);

        }
        return comboBoxProvincia;
    }

    private JLabel getLblEmail() {
        if (lblEmail == null) {
            lblEmail = new JLabel("email");
            lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEmail.setBounds(10, 188, 66, 15);
        }
        return lblEmail;
    }

    private JTextField getTxtFEmail() {
        if (txtFEmail == null) {
            txtFEmail = new JTextField();
            txtFEmail.setColumns(10);
            txtFEmail.setBounds(102, 182, 131, 28);
        }
        return txtFEmail;
    }

    // Métodos para elegir el tipo de Proveedor
    // =========================================================================
    private JLabel getLblTipoProveedor() {
        if (lblTipoProveedor == null) {
            lblTipoProveedor = new JLabel("Tipo de Proveedor");
            lblTipoProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblTipoProveedor.setBounds(10, 220, 150, 15);
            lblTipoProveedor.setVisible(true);
        }
        return lblTipoProveedor;
    }

    private JComboBox<String> getComboBoxTipoProveedor() {
        if (comboBoxTipoProveedor == null) {
            comboBoxTipoProveedor = new JComboBox<>();
            comboBoxTipoProveedor.setBounds(10, 240, 131, 28);
            comboBoxTipoProveedor.setVisible(true);

            comboBoxTipoProveedor.addItem("Alimentario");
            comboBoxTipoProveedor.addItem("Veterinario");
            comboBoxTipoProveedor.addItem("Complementario");
            comboBoxTipoProveedor.setSelectedIndex(-1);

            comboBoxTipoProveedor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selected = comboBoxTipoProveedor.getSelectedIndex();

                    switch (selected) {
                        case -1:
                            lblRepresentante.setVisible(false);
                            txtFRepresentante.setVisible(false);
                            lblFax.setVisible(false);
                            txtFFax.setVisible(false);
                            lblEspecialidad.setVisible(false);
                            txtFEspecialidad.setVisible(false);
                            lblClinica.setVisible(false);
                            txtFClinica.setVisible(false);
                            break;
                        case 0, 2:
                            lblRepresentante.setVisible(true);
                            txtFRepresentante.setVisible(true);
                            lblFax.setVisible(false);
                            txtFFax.setVisible(false);
                            lblEspecialidad.setVisible(false);
                            txtFEspecialidad.setVisible(false);
                            lblClinica.setVisible(false);
                            txtFClinica.setVisible(false);
                            break;
                        case 1:
                            lblFax.setVisible(true);
                            txtFFax.setVisible(true);
                            lblEspecialidad.setVisible(true);
                            txtFEspecialidad.setVisible(true);
                            lblClinica.setVisible(true);
                            txtFClinica.setVisible(true);
                            lblRepresentante.setVisible(false);
                            txtFRepresentante.setVisible(false);
                            break;
                        default:
                            break;
                    }
                }
            });

        }
        return comboBoxTipoProveedor;
    }

    // Métodos para los proveedores de tipo Complementario y Alimentario
    public JLabel getLblRepresentante() {
        if (lblRepresentante == null) {
            lblRepresentante = new JLabel("Representante");
            lblRepresentante.setFont(new Font("Bahnschrift", Font.BOLD, 13));
            lblRepresentante.setBounds(10, 284, 90, 15);
            lblRepresentante.setVisible(false);
        }
        return lblRepresentante;
    }

    private JTextFieldSoloLetras getTxtFRepresentante() {
        if (txtFRepresentante == null) {
            txtFRepresentante = new JTextFieldSoloLetras();
            txtFRepresentante.setBounds(102, 278, 131, 28);
            txtFRepresentante.setVisible(false);
        }
        return txtFRepresentante;
    }

    // Metodos para los proveedores de tipo Veterinario
    public JLabel getLblFax() {
        if (lblFax == null) {
            lblFax = new JLabel("Fax");
            lblFax.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblFax.setBounds(10, 284, 76, 15);
            lblFax.setVisible(false);
        }
        return lblFax;
    }

    private JTextField getTxtFFax() {
        if (txtFFax == null) {
            txtFFax = new JTextField();
            txtFFax.setBounds(102, 278, 131, 28);
            txtFFax.setVisible(false);

        }
        return txtFFax;
    }

    public JLabel getLblEspecialidad() {
        if (lblEspecialidad == null) {
            lblEspecialidad = new JLabel("Especialidad");
            lblEspecialidad.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEspecialidad.setBounds(10, 316, 90, 15);
            lblEspecialidad.setVisible(false);
        }
        return lblEspecialidad;
    }

    private JTextFieldSoloLetras getTxtFEspecialidad() {
        if (txtFEspecialidad == null) {
            txtFEspecialidad = new JTextFieldSoloLetras();
            txtFEspecialidad.setBounds(102, 311, 131, 28);
            txtFEspecialidad.setVisible(false);

        }
        return txtFEspecialidad;
    }

    public JLabel getLblClinica() {
        if (lblClinica == null) {
            lblClinica = new JLabel("Clínica");
            lblClinica.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblClinica.setBounds(10, 350, 76, 15);
            lblClinica.setVisible(false);
        }
        return lblClinica;
    }

    private JTextFieldSoloLetras getTxtFClinica() {
        if (txtFClinica == null) {
            txtFClinica = new JTextFieldSoloLetras();
            txtFClinica.setBounds(102, 344, 131, 28);
            txtFClinica.setVisible(false);

        }
        return txtFClinica;
    }

    // =========================================================================

    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(272, 30, 632, 329);
            scrollPane.setViewportView(getTableProveedor());
            model.addColumn("id");
            model.addColumn("Nombre");
            model.addColumn("Dirección");
            model.addColumn("Teléfono");
            model.addColumn("Email");
            model.addColumn("id Provincia");
            model.addColumn("Tipo de Proveedor");
            actualizarTabla();
        }
        return scrollPane;
    }

    // Método de la tabla de los proveedores
    // ========================================================================
    private JTable getTableProveedor() {
        if (tableProveedor == null) {
            tableProveedor = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableProveedor.getTableHeader().setReorderingAllowed(false);
            tableProveedor = new JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
            tableProveedor.getTableHeader().setReorderingAllowed(false);
            tableProveedor.setModel(new DefaultTableModel(
                    new Object[][] {
                            { null, null, null, null, null, null, null },
                            { null, null, null, null, null, null, null },
                    },
                    new String[] {
                            "Id", "Nombre", "Dirección", "Teléfono", "Provincia", "Email", "Tipo de Proveedor"
                    }));
            tableProveedor.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        if (tableProveedor.getSelectedRow() != -1) {
                            limpiar();
                            txtFNombre.setText(lista.get(tableProveedor.getSelectedRow()).getNombre());
                            txtFDireccion.setText(lista.get(tableProveedor.getSelectedRow()).getDireccion());
                            txtFTelefono.setText(lista.get(tableProveedor.getSelectedRow()).getTelefono());

                            int pos = -1;
                            for (int i = 0; i < listaProvincia.size() && pos == -1; i++) {
                                if (listaProvincia.get(i).getId_provinvcia() == lista
                                        .get(tableProveedor.getSelectedRow()).getProvincia())
                                    pos = i;
                            }
                            comboBoxProvincia.setSelectedIndex(pos);

                            txtFEmail.setText(lista.get(tableProveedor.getSelectedRow()).getEmail());
                            switch (lista.get(tableProveedor.getSelectedRow()).getTipo_proveedor()) {
                                case 'A':
                                    comboBoxTipoProveedor.setSelectedIndex(0);
                                    DAOProveedorAlimentos daoA = new DAOProveedorAlimentos();
                                    ProvAlimentos provA = daoA.buscarProveedorAlimentos(
                                            lista.get(tableProveedor.getSelectedRow()).getId_proveedor());
                                    txtFRepresentante.setText(provA.getRepresentante());
                                    break;
                                case 'V':
                                    comboBoxTipoProveedor.setSelectedIndex(1);
                                    DAOVeterinario daoV = new DAOVeterinario();
                                    Veterinario vet = daoV.buscarVeterinario(
                                            lista.get(tableProveedor.getSelectedRow()).getId_proveedor());
                                    txtFClinica.setText(vet.getClinica());
                                    txtFEspecialidad.setText(vet.getEspecialidad());
                                    txtFFax.setText(vet.getFax());
                                    break;

                                default:
                                    comboBoxTipoProveedor.setSelectedIndex(2);
                                    DAOProvServComplementarios daoC = new DAOProvServComplementarios();
                                    ProvServComplementarios provC = daoC.buscarProvServComplementarios(
                                            lista.get(tableProveedor.getSelectedRow()).getId_proveedor());
                                    txtFRepresentante.setText(provC.getRepresentante());
                                    break;
                            }

                        }
                    }
                }
            });
        }
        return tableProveedor;
    }

    public void actualizarTabla() {
        while (model.getRowCount() > 0)
            model.removeRow(0);

        lista = dao.consultarProveedores();
        for (Proveedor a : lista) {

            Object[] ob = new Object[7];
            ob[0] = a.getId_proveedor();
            ob[1] = a.getNombre();
            ob[2] = a.getDireccion();
            ob[3] = a.getTelefono();
            ob[4] = a.getEmail();
            ob[5] = a.getProvincia();
            ob[6] = a.getTipo_proveedor();
            model.addRow(ob);
        }
        tableProveedor.setModel(model);
    }
    // ========================================================================

    // Método para eliminar a un proveedor
    // ========================================================================
    public void eliminarProveedor() {

        if (tableProveedor.getSelectedRowCount() >= 1) {
            dao.eliminarProveedor(lista.get(tableProveedor.getSelectedRow()).getId_proveedor());
            actualizarTabla();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No puede eliminar si no tiene seleccionada una celda", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    // ========================================================================

    // Método para crear y agregar un Proveedor
    // ========================================================================
    public Proveedor agregarProveedor() {
        Proveedor p = new Proveedor();
        int idProveedor = -1;
        boolean add = false;

        try {
            p.setNombre(txtFNombre.getText());
            p.setDireccion(txtFDireccion.getText());
            p.setTelefono(txtFTelefono.getText());
            p.setProvincia(comboBoxProvincia.getSelectedIndex() + 1);
            p.setEmail(txtFEmail.getText());
            p.setTipo_proveedor(((String)comboBoxTipoProveedor.getSelectedItem()).charAt(0));

            dao.insertarProveedor(p);
            idProveedor = dao.obtenerUltimoID();
            add = true;

            switch (comboBoxTipoProveedor.getSelectedIndex()) {
                case 0:
                    ProvAlimentos provAlimentos = new ProvAlimentos();
                    DAOProveedorAlimentos daoProvAlimentos = new DAOProveedorAlimentos();
                    provAlimentos.setId_proveedor(idProveedor);
                    provAlimentos.setRepresentante(txtFRepresentante.getText());
                    daoProvAlimentos.insertarProveedorAlimentos(provAlimentos);
                    break;
                case 1:
                    Veterinario vet = new Veterinario();
                    DAOVeterinario daoVeterinario = new DAOVeterinario();
                    vet.setId_proveedor(idProveedor);
                    vet.setEspecialidad(txtFEspecialidad.getText());
                    vet.setFax(txtFFax.getText());
                    vet.setClinica(txtFClinica.getText());
                    daoVeterinario.insertarVeterinario(vet);
                    break;
                case 2:
                    ProvServComplementarios provServCompl = new ProvServComplementarios();
                    DAOProvServComplementarios daoProvServComp = new DAOProvServComplementarios();
                    provServCompl.setId_proveedor(idProveedor);
                    provServCompl.setRepresentante(txtFRepresentante.getText());
                    daoProvServComp.insertarProvServComplementarios(provServCompl);
                    break;
                default:
                    break;
            }
            limpiar();
            actualizarTabla();

        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            if (comboBoxTipoProveedor.getSelectedIndex() != -1 && add) {
                dao.eliminarProveedor(idProveedor);
            }
        }

        return p;
    }
    // ========================================================================

    // Método para actualizar un Proveedor
    // ========================================================================
    public void actualizarProveedor() {
        if (tableProveedor.getSelectedRowCount() >= 1) {
            try {
                Proveedor p = lista.get(tableProveedor.getSelectedRow());

                p.setNombre(txtFNombre.getText());
                p.setDireccion(txtFDireccion.getText());
                p.setTelefono(txtFTelefono.getText());
                p.setProvincia(comboBoxProvincia.getSelectedIndex() + 1);
                p.setEmail(txtFEmail.getText());

                dao.actualizarProveedor(p);

                switch (p.getTipo_proveedor()) {
                    case 'A':
                        ProvAlimentos provAlimentos = new ProvAlimentos();
                        DAOProveedorAlimentos daoProvAlimentos = new DAOProveedorAlimentos();
                        provAlimentos.setId_proveedor(p.getId_proveedor());
                        provAlimentos.setRepresentante(txtFRepresentante.getText());
                        daoProvAlimentos.actualizarProveedorAlimentos(provAlimentos);
                        break;
                    case 'V':
                        Veterinario vet = new Veterinario();
                        DAOVeterinario daoVeterinario = new DAOVeterinario();
                        vet.setId_proveedor(p.getId_proveedor());
                        vet.setEspecialidad(txtFEspecialidad.getText());
                        vet.setFax(txtFFax.getText());
                        vet.setClinica(txtFClinica.getText());
                        daoVeterinario.actualizarVeterinario(vet);
                        break;
                    case 'C':
                        ProvServComplementarios provServCompl = new ProvServComplementarios();
                        DAOProvServComplementarios daoProvServComp = new DAOProvServComplementarios();
                        provServCompl.setId_proveedor(p.getId_proveedor());
                        provServCompl.setRepresentante(txtFRepresentante.getText());
                        daoProvServComp.actualizarProvServComplementarios(provServCompl);
                        break;
                    default:
                        break;
                }
                limpiar();
                actualizarTabla();

                dao.actualizarProveedor(p);

            } catch (Exception e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        txtFDireccion.setText("");
        txtFEmail.setText("");
        txtFNombre.setText("");
        comboBoxProvincia.setSelectedIndex(-1);
        txtFTelefono.setText("");

        if (comboBoxTipoProveedor.getSelectedIndex() != -1) {
            txtFClinica.setText("");
            txtFRepresentante.setText("");
            txtFFax.setText("");
            txtFEspecialidad.setText("");
            comboBoxTipoProveedor.setSelectedIndex(-1);
        }
    }

    public void cargarListas() {
        DAOProvincia daoP = new DAOProvincia();
        listaProvincia = daoP.consultarProvincia();
    }
}
