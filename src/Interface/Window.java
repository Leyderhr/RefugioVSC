package Interface;

import logic.Usuario;
import net.sf.jasperreports.engine.JRException;
import reportes.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class Window extends JFrame {

    private final int cantPaneles = 6;
    private final JPanel contentPane;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnLimpiar;

    // Atributos del menu
    private JMenuBar menuBar;
    private JMenu mnLogOut;
    private JMenuItem mntmLogOut;

    private JMenu mnVisualizar;
    private JMenuItem mntmPanelPrincipal;
    private JMenuItem mntmAnimales;
    private JMenuItem mntmContratos;
    private JMenuItem mntmProveedores;
    private JMenuItem mntmServicios;
    private JMenuItem mntmCuidadoDiario;
    private JMenuItem mntmUsuario;

    private JMenu mnReportes;
    private JMenuItem mntmContratoProvDeAlimento;
    private JMenuItem mntmConceptoAdopciones;
    private JMenuItem mntmContratoVeterinario;
    private JMenuItem mntmContratoVeterinarioActivo;
    private JMenuItem mntmActCuidadoAnimal;
    private JMenuItem mntmContratoServComplement;


    //Atributos de los paneles
    private ArrayList<Boolean> ventanas;
    private AnimalPanel animalPanel;
    private ProveedorPanel proveedorPanel;
    private ContratoPanel contratoPanel;
    private ServicioPanel servicioPanel;
    private CuidadoDiarioPanel cuidadoDiarioPanel;
    private UsuarioPanel usuarioPanel;

    // Atributos del fondo principal
    private JLabel lblFotoZooIzq;
    private JLabel lblFotoZooDer;
    private JLabel lblHeader;
    private JLabel lblText;


    /**
     * Constructor de la ventana.
     */
    public Window(Object user) {

        //Declaración de atributos de la ventana
        //======================================
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        setTitle("Gestor del Refugio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 500);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Authentication.class.getResource("/util/ico.png")));
        setJMenuBar(getMenuBarVisualizar(user));
        setLocationRelativeTo(null);
        setResizable(false);


        contentPane.add(getBtnAgregar(user));
        contentPane.add(getBtnEliminar(user));
        contentPane.add(getBtnActualizar(user));
        contentPane.add(getBtnLimpiar());

        contentPane.add(getAnimalPanel());
        contentPane.add(getProovedorPanel());
        contentPane.add(getContratoPanel());
        contentPane.add(getServicioPanel());
        contentPane.add(getCuidadoDiarioPanel());
        contentPane.add(getUsuarioPanel());

        contentPane.add(getFotoZooIzq());
        contentPane.add(getFotoZooDer());
        contentPane.add(getLblHeader());
        contentPane.add(getLblText());


        ventanas = new ArrayList<>();
        for (int i = 0; i < cantPaneles; i++) {
            ventanas.add(false);
        }

    }

    // Métodos para obtener los labels del fondo principal
    //=========================================================================
    private JLabel getFotoZooIzq() {
        if (lblFotoZooIzq == null) {
            lblFotoZooIzq = new JLabel();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/util/Rcortada.png")));
            lblFotoZooIzq.setIcon(icon);
            lblFotoZooIzq.setBounds(20, 80, 250, 300);
            lblFotoZooIzq.setHorizontalAlignment(SwingConstants.CENTER);
            lblFotoZooIzq.setHorizontalTextPosition(SwingConstants.CENTER);
            lblFotoZooIzq.setIconTextGap(1);
        }
        return lblFotoZooIzq;
    }

    private JLabel getFotoZooDer() {
        if (lblFotoZooDer == null) {
            lblFotoZooDer = new JLabel();
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/util/LogoZooEdit.png")));
            lblFotoZooDer.setIcon(icon);
            lblFotoZooDer.setBounds(780, 80, 150, 100);
            lblFotoZooDer.setHorizontalAlignment(SwingConstants.CENTER);
            lblFotoZooDer.setHorizontalTextPosition(SwingConstants.CENTER);
            lblFotoZooDer.setIconTextGap(1);
        }
        return lblFotoZooDer;
    }

    private JLabel getLblHeader() {
        if (lblHeader == null) {
            lblHeader = new JLabel("Gestor del Refugio Animal");
            lblHeader.setFont(new Font("Bahnschrift", Font.BOLD, 34));
            lblHeader.setForeground(Color.WHITE);
            lblHeader.setOpaque(true);
            lblHeader.setBounds(20, 11, 910, 60);
            lblHeader.setVisible(true);
            lblHeader.setBackground(new Color(33, 196, 58, 255));
            lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
            lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
            lblHeader.setVerticalTextPosition(SwingConstants.CENTER);
        }
        return lblHeader;
    }

    private JLabel getLblText() {
        if (lblText == null) {
            lblText = new JLabel();
            lblText.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
            lblText.setText("<html> <p align: left><br>El refugio de Animales \"Amigos de Pata\" se dedica a la " +
                    "protección, cuidado y adopción de animales abandonados o en situación de riesgo." +
                    "Ofrece una amplia gama de servicios que incluyen la alimentación, atención médica, " +
                    "actividades de socialización, adopciones, y programas de voluntariado.</p></html>");
            lblText.setBounds(280, 90, 580, 300);
            lblText.setVisible(true);
            lblText.setHorizontalAlignment(SwingConstants.CENTER);
            lblText.setHorizontalTextPosition(SwingConstants.CENTER);
            lblText.setVerticalTextPosition(SwingConstants.CENTER);
        }
        return lblText;
    }


    // Métodos para obtener los paneles personalizados
    //=========================================================================
    private ContratoPanel getContratoPanel() {
        if (contratoPanel == null) {
            contratoPanel = new ContratoPanel();
        }
        return contratoPanel;
    }

    private AnimalPanel getAnimalPanel() {
        if (animalPanel == null) {
            animalPanel = new AnimalPanel();
        }
        return animalPanel;
    }

    private ProveedorPanel getProovedorPanel() {
        if (proveedorPanel == null) {
            proveedorPanel = new ProveedorPanel();
        }
        return proveedorPanel;
    }

    private ServicioPanel getServicioPanel() {
        if (servicioPanel == null) {
            servicioPanel = new ServicioPanel();
        }
        return servicioPanel;
    }

    private CuidadoDiarioPanel getCuidadoDiarioPanel() {
        if (cuidadoDiarioPanel == null) {
            cuidadoDiarioPanel = new CuidadoDiarioPanel();
        }
        return cuidadoDiarioPanel;
    }

    private UsuarioPanel getUsuarioPanel() {
        if (usuarioPanel == null) {
            usuarioPanel = new UsuarioPanel();
        }
        return usuarioPanel;
    }

    //=========================================================================


    //Método para controlar la visibilidad de los paneles en la ventana
    //=========================================================================
    private void controlPanel(int value) {
        switch (value) {
            case 1:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                animalPanel.setVisible(true);
                ventanas.set(0, true);
                proveedorPanel.setVisible(false);
                contratoPanel.setVisible(false);
                servicioPanel.setVisible(false);
                usuarioPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                break;
            case 2:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                proveedorPanel.setVisible(true);
                proveedorPanel.cargarListas();
                ventanas.set(1, true);
                animalPanel.setVisible(false);
                contratoPanel.setVisible(false);
                servicioPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                usuarioPanel.setVisible(false);
                break;
            case 3:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                contratoPanel.setVisible(true);
                contratoPanel.cargarListas();
                ventanas.set(2, true);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                usuarioPanel.setVisible(false);
                break;
            case 4:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                servicioPanel.setVisible(true);
                ventanas.set(3, true);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                usuarioPanel.setVisible(false);
                break;
            case 5:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                cuidadoDiarioPanel.setVisible(true);
                cuidadoDiarioPanel.cargarLista();
                ventanas.set(4, true);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
                usuarioPanel.setVisible(false);
                break;

            case 6:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                usuarioPanel.setVisible(true);
                ventanas.set(5, true);
                cuidadoDiarioPanel.setVisible(false);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
                break;
            case 7:

                for (int i = 0; i < cantPaneles; i++) {
                    ventanas.set(i, false);
                }
                usuarioPanel.setVisible(false);
                ventanas.set(6, true);
                cuidadoDiarioPanel.setVisible(false);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
                break;
            default:
                usuarioPanel.setVisible(false);
                cuidadoDiarioPanel.setVisible(false);
                contratoPanel.setVisible(false);
                animalPanel.setVisible(false);
                proveedorPanel.setVisible(false);
                servicioPanel.setVisible(false);
                break;
        }
    }

    private JButton getBtnAgregar(Object user) {
        if (btnAgregar == null) {
            btnAgregar = new JButton("Agregar");
            if (((Usuario)user).getRol() == 3)
                btnAgregar.setEnabled(false);

            btnAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int vent = 0;
                    for (int i = 0; i < cantPaneles; i++)
                        if (ventanas.get(i)) {
                            vent = i + 1;
                            i = cantPaneles;
                        }
                    switch (vent) {
                        case 1:
                            try {
                                animalPanel.agregarAnimal();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        case 2:
                            proveedorPanel.agregarProveedor();
                            break;
                        case 3:
                            contratoPanel.agregarContrato();
                            break;
                        case 4:
                            servicioPanel.agregarServicio();
                            break;
                        case 5:
                            cuidadoDiarioPanel.agregarDiarioPanel();
                            break;
                        case 6:
                            usuarioPanel.agregarUsuario();
                            break;
                        default:
                            break;
                    }
                }
            });
            btnAgregar.setBounds(20, 407, 107, 23);
        }
        return btnAgregar;
    }

    private JButton getBtnEliminar(Object user) {
        if (btnEliminar == null) {
            btnEliminar = new JButton("Eliminar");

            if (((Usuario)user).getRol() == 3)
                btnEliminar.setEnabled(false);

            btnEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int vent = 0;
                    for (int i = 0; i < cantPaneles; i++)
                        if (ventanas.get(i)) {
                            vent = i + 1;
                            i = cantPaneles;
                        }
                    switch (vent) {
                        case 1:
                            animalPanel.eliminarAnimal();
                            break;
                        case 2:
                            proveedorPanel.eliminarProveedor();
                            break;
                        case 3:
                            contratoPanel.eliminarContrato();
                            break;
                        case 4:
                            servicioPanel.eliminarServicio();
                            break;
                        case 5:
                            cuidadoDiarioPanel.eliminarActividad();
                            break;
                        case 6:
                            usuarioPanel.eliminarUsuario();
                            break;
                        default:
                            break;
                    }

                }
            });
            btnEliminar.setBounds(146, 407, 107, 23);
        }
        return btnEliminar;
    }

    private JButton getBtnActualizar(Object user) {
        if (btnActualizar == null) {
            btnActualizar = new JButton("Actualizar");

            if (((Usuario)user).getRol() == 3)
                btnActualizar.setEnabled(false);

            btnActualizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int vent = 0;
                    for (int i = 0; i < cantPaneles; i++)
                        if (ventanas.get(i)) {
                            vent = i + 1;
                            i = cantPaneles;
                        }
                    switch (vent) {
                        case 1:
                            animalPanel.actualizarAnimal();
                            break;
                        case 2:
                            proveedorPanel.actualizarProveedor();
                            break;
                        case 3:
                            contratoPanel.actualizarContrato();
                            break;
                        case 4:
                            servicioPanel.actualizarServicio();
                            break;
                        case 5:
                            cuidadoDiarioPanel.actualizarDiarioPanel();
                            break;
                        case 6:
                            usuarioPanel.actualizarUsuarioPanel();
                            break;
                        default:
                            break;
                    }
                }
            });
            btnActualizar.setBounds(272, 407, 107, 23);
        }
        return btnActualizar;
    }

    private JButton getBtnLimpiar() {
        if (btnLimpiar == null) {
            btnLimpiar = new JButton("Limpiar");
            btnLimpiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int vent = 0;
                    for (int i = 0; i < cantPaneles; i++)
                        if (ventanas.get(i)) {
                            vent = i + 1;
                            i = cantPaneles;
                        }
                    switch (vent) {
                        case 1:
                            animalPanel.limpiar();
                            break;
                        case 2:
                            proveedorPanel.limpiar();
                            break;
                        case 3:
                            contratoPanel.limpiar();
                            break;
                        case 4:
                            servicioPanel.limpiar();
                            break;
                        case 5:
                            cuidadoDiarioPanel.limpiar();
                            break;
                        case 6:
                            usuarioPanel.limpiar();
                            break;
                        default:
                            break;
                    }
                }
            });
            btnLimpiar.setBounds(398, 407, 107, 23);
        }
        return btnLimpiar;
    }


    // Elementos del menuBar para Visualizar
    // ========================================================================
    private JMenuBar getMenuBarVisualizar(Object user) {
        if (menuBar == null) {
            menuBar = new JMenuBar();
            menuBar.add(getMnLogOut());
            menuBar.add(getMnVisualizar(user));
            menuBar.add(getMnReportes());
        }
        return menuBar;
    }


    // Elemento para desloguearse
    // ========================================================================
    private JMenu getMnLogOut() {
        if (mnLogOut == null) {
            mnLogOut = new JMenu("Opciones");
            mnLogOut.add(getMntmLogOut());
        }
        return mnLogOut;
    }

    private JMenuItem getMntmLogOut() {
        if (mntmLogOut == null) {
            mntmLogOut = new JMenuItem("Cambiar de Usuario");
            mntmLogOut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    try {
                        dispose();
                        Authentication a = new Authentication();
                        a.setLocationRelativeTo(null);
                        a.setVisible(true);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
        return mntmLogOut;
    }


    // Elementos de la visualización de los datos de las tablas
    // ========================================================================
    private JMenu getMnVisualizar(Object user) {
        if (mnVisualizar == null) {
            mnVisualizar = new JMenu("Visualizar");
            mnVisualizar.add(getMntmPanelPrincipal());
            mnVisualizar.add(getMntmAnimales());
            mnVisualizar.add(getMntmContratos());
            mnVisualizar.add(getMntmServicios());
            mnVisualizar.add(getMntmProveedores());
            mnVisualizar.add(getMntmCuidadoDiario());
            mnVisualizar.add(getMntmUsuario(user));
            //mnVisualizar.add(getMntmAdmin(user));
        }
        return mnVisualizar;
    }

    private JMenuItem getMntmPanelPrincipal() {
        if (mntmPanelPrincipal == null) {
            mntmPanelPrincipal = new JMenuItem("Inicio");
            mntmPanelPrincipal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    controlPanel(-1);
                }
            });
        }
        return mntmPanelPrincipal;
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

    private JMenuItem getMntmUsuario(Object user) {
        if (mntmUsuario == null) {
            mntmUsuario = new JMenuItem("Usuarios");
            mntmUsuario.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    if (((Usuario)user).getRol() != 1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Sólo los administradores pueden " +
                                "acceder a estos datos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else
                        controlPanel(UsuarioPanel.VALUE);
                }
            });
        }
        return mntmUsuario;
    }


    // Elementos de la visualización de los Reportes
    // ========================================================================
    private JMenu getMnReportes() {
        if (mnReportes == null) {
            mnReportes = new JMenu("Reportes");
            mnReportes.add(getMntmContratoProvDeAlimento());
            mnReportes.add(getMntmConceptoAdopciones());
            mnReportes.add(getMntmContratoVeterinario());
            mnReportes.add(getMntmContratoVeterinarioActivo());
            mnReportes.add(getMntmActCuidadoAnimal());
            mnReportes.add(getMntmContratoServComplement());
        }
        return mnReportes;
    }

    private JMenuItem getMntmContratoProvDeAlimento() {
        if (mntmContratoProvDeAlimento == null) {
            mntmContratoProvDeAlimento = new JMenuItem("Mostrar Contratos de Proveedores de Alimentos");

            mntmContratoProvDeAlimento.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        ContratosProveedoresAlimentos contratosProveedoresAlimentos = new ContratosProveedoresAlimentos();
                        contratosProveedoresAlimentos.mostrarVentanaReporte();
                    } catch (JRException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        return mntmContratoProvDeAlimento;
    }


    private JMenuItem getMntmConceptoAdopciones() {
        if (mntmConceptoAdopciones == null) {
            mntmConceptoAdopciones = new JMenuItem("Mostrar Concepto de Adopciones");

            mntmConceptoAdopciones.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        ConceptoAdopciones conceptoAdopciones = new ConceptoAdopciones();
                        conceptoAdopciones.mostrarVentanaReporte();
                    } catch (JRException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        return mntmConceptoAdopciones;
    }


    private JMenuItem getMntmContratoVeterinario() {
        if (mntmContratoVeterinario == null) {
            mntmContratoVeterinario = new JMenuItem("Mostrar Contratos de Veterinarios");

            mntmContratoVeterinario.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        ContratosVeterinarios contratosVeterinarios = new ContratosVeterinarios();
                        contratosVeterinarios.mostrarVentanaReporte();
                    } catch (JRException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        return mntmContratoVeterinario;
    }


    private JMenuItem getMntmContratoVeterinarioActivo() {
        if (mntmContratoVeterinarioActivo == null) {
            mntmContratoVeterinarioActivo = new JMenuItem("Mostrar Contratos de Veterinarios Activos");

            mntmContratoVeterinarioActivo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        ContratosVeterinariosActivos contratosVeterinariosActivos = new ContratosVeterinariosActivos();
                        contratosVeterinariosActivos.mostrarVentanaReporte();
                    } catch (JRException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        return mntmContratoVeterinarioActivo;
    }

    private JMenuItem getMntmActCuidadoAnimal() {
        if (mntmActCuidadoAnimal == null) {
            mntmActCuidadoAnimal = new JMenuItem("Mostrar Actividades de Cuidado Animal");

            mntmActCuidadoAnimal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        IdAnimalJDialog jDialog = new IdAnimalJDialog(Window.this);
                        jDialog.setVisible(true);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            });
        }
        return mntmActCuidadoAnimal;
    }


    private JMenuItem getMntmContratoServComplement() {
        if (mntmContratoServComplement == null) {
            mntmContratoServComplement = new JMenuItem("Mostrar Contratos de Servicios Complementarios");

            mntmContratoServComplement.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        ContratosServicioComplementario csc = new ContratosServicioComplementario();
                        csc.mostrarVentanaReporte();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            });
        }
        return mntmContratoServComplement;
    }

}
