package Interface;

import net.sf.jasperreports.engine.JRException;
import reportes.ContratosVeterinarios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class Window extends JFrame {

    private final int cantPaneles = 5;
    private final JPanel contentPane;
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

    // Atributos del fondo principal
    private JLabel lblFotoZooIzq;
    private JLabel lblFotoZooDer;
    private JLabel lblHeader;
    private JLabel lblText;


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

        contentPane.add(getFotoZooIzq());
        contentPane.add(getFotoZooDer());
        contentPane.add(getLblHeader());
        contentPane.add(getLblText());


        ventanas = new ArrayList<>();
        for(int i = 0; i < cantPaneles; i++){
            ventanas.add(false);
        }

    }

    // Métodos para obtener los labels del fondo principal
    //=========================================================================
    private JLabel getFotoZooIzq(){
        if(lblFotoZooIzq == null){
            lblFotoZooIzq = new JLabel();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/util/Rcortada.png")));
            lblFotoZooIzq.setIcon(icon);
            lblFotoZooIzq.setBounds(20,80, 250, 300);
            lblFotoZooIzq.setHorizontalAlignment(SwingConstants.CENTER);
            lblFotoZooIzq.setHorizontalTextPosition(SwingConstants.CENTER);
            lblFotoZooIzq.setIconTextGap(1);
        }
        return lblFotoZooIzq;
    }

    private JLabel getFotoZooDer(){
        if(lblFotoZooDer == null){
            lblFotoZooDer = new JLabel();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/util/LogoZooEdit.png")));
            lblFotoZooDer.setIcon(icon);
            lblFotoZooDer.setBounds(780,80, 150, 100);
            lblFotoZooDer.setHorizontalAlignment(SwingConstants.CENTER);
            lblFotoZooDer.setHorizontalTextPosition(SwingConstants.CENTER);
            lblFotoZooDer.setIconTextGap(1);
        }
        return  lblFotoZooDer;
    }

    private JLabel getLblHeader(){
        if(lblHeader == null){
            lblHeader = new JLabel("Gestor del Refugio Animal");
            lblHeader.setFont(new Font("Bahnschrift", Font.BOLD, 34));
            lblHeader.setForeground(Color.WHITE);
            lblHeader.setOpaque(true);
            lblHeader.setBounds(20,11, 910, 60);
            lblHeader.setVisible(true);
            lblHeader.setBackground(new Color(33,196,58,255));
            lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
            lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
            lblHeader.setVerticalTextPosition(SwingConstants.CENTER);
        }
        return  lblHeader;
    }

    private JLabel getLblText(){
        if(lblText == null){
            lblText = new JLabel();
            lblText.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
            lblText.setText("<html> <p align: left><br>El refugio de Animales \"Amigos de Pata\" se dedica a la " +
                    "protección, cuidado y adopción de animales abandonados o en situación de riego." +
                    "Ofrece una amplia gama de servicios que incluyen la alimentación, atención médica, " +
                    "actividades de socialización, adopciones, y programas de voluntariado.</p></html>");
            lblText.setBounds(280,90, 580,300 );
            lblText.setVisible(true);
            lblText.setHorizontalAlignment(SwingConstants.CENTER);
            lblText.setHorizontalTextPosition(SwingConstants.CENTER);
            lblText.setVerticalTextPosition(SwingConstants.CENTER);
        }
        return  lblText;
    }


    // Métodos para obtener los paneles personalizados
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
                    int vent = 0;
                    for(int i = 0; i < cantPaneles; i++)
                        if(ventanas.get(i)) {
                            vent = i + 1;
                            i = cantPaneles;
                        }
                    switch (vent) {
                        case 1:
                            animalPanel.getDao().insertarAnimal(animalPanel.agregarAnimal());
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
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
                    animalPanel.eliminarAnimal();

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
                    getAnimalPanel().actualizarAnimal();
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
                    try {
                        ContratosVeterinarios contVeterinarios = new ContratosVeterinarios();
                        contVeterinarios.mostrarVentanaReporte();
                    } catch (JRException e) {
                        throw new RuntimeException(e);
                    }
                    /**todo*/
                    // Aquí hay que llamar al método de Abdiel para mostrar los contratos de los Proveedores
                }
            });
        }
        return mntmContratoProvDeAlimento;
    }




}
