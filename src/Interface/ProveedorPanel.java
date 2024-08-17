package Interface;

import dao.DAOProveedor;
import logic.Proveedor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ProveedorPanel extends JPanel {

    // Atributos de la clase
    // ========================================================================
    public static final int VALUE = 2;
    private JLabel lblNombre;
    private JTextField txtFNombre;

    private JTextField txtFDireccion;
    private JLabel lblDireccion;

    private JTextField txtFTelefono;
    private JLabel lblTelefono;

    private JTextField txtFProvincia;
    private JLabel lblProvincia;

    private JTextField txtFEmail;
    private JLabel lblEmail;

    private JScrollPane scrollPane;
    private JTable tableProveedor;
    private final DAOProveedor dao = new DAOProveedor();
    ArrayList<Proveedor> lista;
    private DefaultTableModel model = new DefaultTableModel();
    // ========================================================================



    public ProveedorPanel(){
        setBounds(20, 11, 914, 385);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de los Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(null);
        setVisible(false);
        add(getLblNombre());
        add(getTxtFNombre());
        add(getTxtFDireccion());
        add(getLblDireccion());
        add(getTxtFTelefono());
        add(getLblTelefono());
        add(getTxtFProvincia());
        add(getLblProvincia());
        add(getTxtFEmail());
        add(getLblEmail());
        add(getScrollPane());
    }



    private JLabel getLblNombre() {
        if (lblNombre == null) {
            lblNombre = new JLabel("Nombre");
            lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblNombre.setBounds(10, 30, 66, 29);
        }
        return lblNombre;
    }


    private JTextField getTxtFNombre() {
        if (txtFNombre == null) {
            txtFNombre = new JTextField();
            txtFNombre.setBounds(102, 36, 131, 20);
            txtFNombre.setColumns(10);
        }
        return txtFNombre;
    }


    private JTextField getTxtFDireccion() {
        if (txtFDireccion == null) {
            txtFDireccion = new JTextField();
            txtFDireccion.setColumns(10);
            txtFDireccion.setBounds(102, 85, 131, 20);
        }
        return txtFDireccion;
    }



    private JLabel getLblDireccion() {
        if (lblDireccion == null) {
            lblDireccion = new JLabel("Dirección");
            lblDireccion.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblDireccion.setBounds(10, 79, 76, 29);
        }
        return lblDireccion;
    }



    private JTextField getTxtFTelefono() {
        if (txtFTelefono == null) {
            txtFTelefono = new JTextField();
            txtFTelefono.setColumns(10);
            txtFTelefono.setBounds(102, 136, 131, 20);
        }
        return txtFTelefono;
    }



    private JLabel getLblTelefono() {
        if (lblTelefono == null) {
            lblTelefono = new JLabel("Teléfono");
            lblTelefono.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblTelefono.setBounds(10, 130, 66, 29);
        }
        return lblTelefono;
    }



    private JTextField getTxtFProvincia() {
        if (txtFProvincia == null) {
            txtFProvincia = new JTextField();
            txtFProvincia.setColumns(10);
            txtFProvincia.setBounds(102, 183, 131, 20);
        }
        return txtFProvincia;
    }



    private JLabel getLblProvincia() {
        if (lblProvincia == null) {
            lblProvincia = new JLabel("Provincia");
            lblProvincia.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblProvincia.setBounds(10, 177, 76, 29);
        }
        return lblProvincia;
    }



    private JTextField getTxtFEmail() {
        if (txtFEmail == null) {
            txtFEmail = new JTextField();
            txtFEmail.setColumns(10);
            txtFEmail.setBounds(102, 231, 131, 20);
        }
        return txtFEmail;
    }
    private JLabel getLblEmail() {
        if (lblEmail == null) {
            lblEmail = new JLabel("email");
            lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 14));
            lblEmail.setBounds(10, 225, 66, 29);
        }
        return lblEmail;
    }


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
            actualizarTabla();
        }
        return scrollPane;
    }


    // Método de la tabla de los proveedores
    // ========================================================================
    private JTable getTableProveedor() {
        if (tableProveedor == null) {
            tableProveedor = new JTable(){
                public boolean isCellEditable(int rowIndex, int colIndex){
                    return false;
                }
            };
            tableProveedor.getTableHeader().setReorderingAllowed(false);
            tableProveedor.setModel(new DefaultTableModel(
                    new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[] {
                            "Id", "Nombre", "Dirección", "Teléfono", "Provincia", "Email"
                    }
            ));
        }
        return tableProveedor;
    }


    public void actualizarTabla(){
        while(model.getRowCount()>0)
            model.removeRow(0);

        lista = dao.consultarProveedores();
        for(Proveedor a:lista){

            Object[] ob = new Object[6];
            ob[0] = a.getId_proveedor();
            ob[1] = a.getNombre();
            ob[2] = a.getDireccion();
            ob[3] = a.getTelefono();
            ob[4] = a.getEmail();
            ob[5] = a.getProvincia();
            model.addRow(ob);
        }
        tableProveedor.setModel(model);
    }
    // ========================================================================



    // Método para eliminar a un proveedor
    // ========================================================================
    public int eliminarProveedor(){
        return lista.get(tableProveedor.getSelectedRow()).getId_proveedor();
    }
    // ========================================================================



    // Método para crear y agregar un Proveedor
    // ========================================================================
    public Proveedor agregarProveedor(){
        Proveedor p = new Proveedor();

        p.setNombre(txtFNombre.getText());
        p.setDireccion(txtFDireccion.getText());
        p.setTelefono(txtFTelefono.getText());
        p.setProvincia(txtFProvincia.getText());
        p.setEmail(txtFEmail.getText());

        return p;
    }
    // ========================================================================



    // Método para actualizar un Proveedor
    // ========================================================================
    public Proveedor actualizarProveedor(){
        Proveedor p = lista.get(tableProveedor.getSelectedRow());

        if(!txtFNombre.getText().equals(""))
            p.setNombre(txtFNombre.getText());
        if(!txtFDireccion.getText().equals(""))
            p.setDireccion(txtFDireccion.getText());
        if(!txtFTelefono.getText().equals(""))
            p.setTelefono(txtFTelefono.getText());
        if(!txtFProvincia.getText().equals(""))
            p.setProvincia(txtFProvincia.getText());
        if(!txtFEmail.getText().equals(""))
            p.setEmail(txtFEmail.getText());

        return p;
    }
    // ========================================================================

}
