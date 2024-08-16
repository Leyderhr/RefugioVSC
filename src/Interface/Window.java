package Interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Window extends JFrame {

    private final int cantPaneles = 5;
    private JPanel contentPane;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnLimpiar;

    // Atributos del menu
    private JMenuBar menuBar;
    private JMenu mnVisualizar;
    private JMenuItem mntmAnimales;
    private JMenuItem mntmContratos;
    private JMenuItem mntmProveedores;
    private JMenuItem mntmServicios;
    private JMenuItem mntmCuidadoDiario;

    private JMenu mnReportes;
    private JMenuItem mntmContratoProvDeAlimento;

    //Atributos de los paneles
    private ArrayList<Boolean> ventanas;
    private AnimalPanel animalPanel;
    private ProveedorPanel proveedorPanel;
    private ContratoPanel contratoPanel;
    private ServicioPanel servicioPanel;
    private CuidadoDiarioPanel cuidadoDiarioPanel;


    /**
     * Constructor de la ventana.
     */
    public Window() {

        //Declaración de atributos de la ventana
        //======================================
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        setTitle("Gestor del Refugio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 500);
        setJMenuBar(getMenuBarVisualizar());
        setLocationRelativeTo(null);
        setResizable(false);


        contentPane.setLayout(null);
        contentPane.add(getBtnAgregar());
        contentPane.add(getBtnEliminar());
        contentPane.add(getBtnActualizar());
        contentPane.add(getBtnLimpiar());

        contentPane.add(getAnimalPanel());
        contentPane.add(getProovedorPanel());
        contentPane.add(getContratoPanel());
        contentPane.add(getServicioPanel());
        contentPane.add(getCuidadoDiarioPanel());

        ventanas = new ArrayList<>();
        for(int i = 0; i < cantPaneles; i++){
            ventanas.add(false);
        }

    }


    //Métodos para obtener los paneles personalizados
    //=========================================================================
    private ContratoPanel getContratoPanel(){
        if(contratoPanel == null){
            contratoPanel = new ContratoPanel();
        }
        return contratoPanel;
    }

    private AnimalPanel getAnimalPanel(){
        if(animalPanel == null){
            animalPanel = new AnimalPanel();
        }
        return animalPanel;
    }

    private ProveedorPanel getProovedorPanel(){
        if(proveedorPanel == null){
            proveedorPanel = new ProveedorPanel();
        }
        return proveedorPanel;
    }

    private ServicioPanel getServicioPanel(){
        if(servicioPanel == null){
            servicioPanel = new ServicioPanel();
        }
        return servicioPanel;
    }

    private CuidadoDiarioPanel getCuidadoDiarioPanel(){
        if(cuidadoDiarioPanel == null){
            cuidadoDiarioPanel = new CuidadoDiarioPanel();
        }
        return cuidadoDiarioPanel;
    }
    //=========================================================================

    //Método para controlar la visibilidad de los paneles en la ventana
    //=========================================================================
    private void controlPanel(int value) {
        switch (value) {
            case 1:

                for(int i = 0; i < cantPaneles; i++){
                    ventanas.set(i, false);
                }
                animalPanel.setVisible(true);
                ventanas.set(0, true);
                proveedorPanel.setVisible(false);
                contratoPanel.setVisible(false);
                servicioPanel.setVisible(false);

                break;
            case 2:

                for(int i = 0; i < cantPaneles; i++){
                    ventanas.set(i, false);
                }
                proveedorPanel.setVisible(true);
                ventanas.set(1, true);
                animalPanel.setVisible(false);
                contratoPanel.setVisible(false);
                servicioPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                break;
            case 3:

                for(int i = 0; i < cantPaneles; i++){
                    ventanas.set(i, false);
                }
                contratoPanel.setVisible(true);
                ventanas.set(2, true);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                break;
            case 4:

                for(int i = 0; i < cantPaneles; i++){
                    ventanas.set(i, false);
                }
                servicioPanel.setVisible(true);
                ventanas.set(3, true);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                break;
            case 5:

                for(int i = 0; i < cantPaneles; i++){
                    ventanas.set(i, false);
                }
                cuidadoDiarioPanel.setVisible(true);
                ventanas.set(4, true);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
            default:
                break;
        }
    }

    private JButton getBtnAgregar() {
        if (btnAgregar == null) {
            btnAgregar = new JButton("Agregar");
            btnAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
            btnAgregar.setBounds(20, 407, 107, 23);
        }
        return btnAgregar;
    }

    private JButton getBtnEliminar() {
        if (btnEliminar == null) {
            btnEliminar = new JButton("Eliminar");
            btnEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                }
            });
            btnEliminar.setBounds(146, 407, 107, 23);
        }
        return btnEliminar;
    }

    private JButton getBtnActualizar() {
        if (btnActualizar == null) {
            btnActualizar = new JButton("Actualizar");
            btnActualizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            btnActualizar.setBounds(272, 407, 107, 23);
        }
        return btnActualizar;
    }

    private JButton getBtnLimpiar() {
        if (btnLimpiar == null) {
            btnLimpiar = new JButton("Limpiar");
            btnLimpiar.setBounds(398, 407, 107, 23);
        }
        return btnLimpiar;
    }



    // Elementos del menuBar para Visualizar
    // ========================================================================
    private JMenuBar getMenuBarVisualizar() {
        if (menuBar == null) {
            menuBar = new JMenuBar();
            menuBar.add(getMnVisualizar());
            menuBar.add(getMnReportes());
        }
        return menuBar;
    }


    // Elementos de la visualización de los datos de las tablas
    // ========================================================================
    private JMenu getMnVisualizar() {
        if (mnVisualizar == null) {
            mnVisualizar = new JMenu("Visualizar");
            mnVisualizar.add(getMntmAnimales());
            mnVisualizar.add(getMntmContratos());
            mnVisualizar.add(getMntmServicios());
            mnVisualizar.add(getMntmProveedores());
            mnVisualizar.add(getMntmCuidadoDiario());
        }
        return mnVisualizar;
    }

    private JMenuItem getMntmAnimales() {
        if (mntmAnimales == null) {
            mntmAnimales = new JMenuItem("Animales");
            mntmAnimales.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    controlPanel(AnimalPanel.VALUE);
                }
            });
        }
        return mntmAnimales;
    }

    private JMenuItem getMntmContratos() {
        if (mntmContratos == null) {
            mntmContratos = new JMenuItem("Contratos");
            mntmContratos.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    controlPanel(ContratoPanel.VALUE);
                }
            });
        }
        return mntmContratos;
    }

    private JMenuItem getMntmProveedores() {
        if (mntmProveedores == null) {
            mntmProveedores = new JMenuItem("Proveedores");
            mntmProveedores.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    controlPanel(ProveedorPanel.VALUE);
                }
            });
        }
        return mntmProveedores;
    }

    private JMenuItem getMntmServicios() {
        if (mntmServicios == null) {
            mntmServicios = new JMenuItem("Servicios");
            mntmServicios.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    controlPanel(ServicioPanel.VALUE);
                }
            });
        }
        return mntmServicios;
    }


    private JMenuItem getMntmCuidadoDiario() {
        if (mntmCuidadoDiario == null) {
            mntmCuidadoDiario = new JMenuItem("Actividad de Cuidado Diario");
            mntmCuidadoDiario.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    controlPanel(CuidadoDiarioPanel.VALUE);
                }
            });
        }
        return mntmCuidadoDiario;
    }


    // Elementos de la visualización de los Reportes
    // ========================================================================
    private JMenu getMnReportes() {
        if (mnReportes == null) {
            mnReportes = new JMenu("Reportes");
            mnReportes.add(getMntmContratoProvDeAlimento());
        }
        return mnReportes;
    }

    private JMenuItem getMntmContratoProvDeAlimento() {
        if (mntmContratoProvDeAlimento == null) {
            mntmContratoProvDeAlimento = new JMenuItem("Mostrar Contratos de Proveedores de Alimentos");
            mntmContratoProvDeAlimento.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                   /**todo*/
                    // Aquí hay que llamar al método de Abdiel para mostrar los contratos de los Proveedores
                }
            });
        }
        return mntmContratoProvDeAlimento;
    }




}
