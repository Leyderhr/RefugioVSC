package Interface;

import dao.DAOUsuario;
import logic.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Authentication extends JFrame {

    private ArrayList<Usuario> users;
    private DAOUsuario daoUsuario;

    private JTextField txtFUsuario;
    private JLabel lblLogin;
    private JLabel lblUsuario;
    private JLabel lblContrasenna;
    private JPasswordField passwordField;
    private JCheckBox chckbxShowPwd;
    private JButton btnEntrar;
    private Window window;


    public Authentication() {
        //Config del ContentPanel
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Config de la ventana
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 300, 375);
        setResizable(false);

        //Config del Panel
        contentPane.setLayout(null);
        contentPane.add(getPasswordField());
        contentPane.add(getLblContrasenna());
        contentPane.add(getLabel_1());
        contentPane.add(getTextFieldUsuario());
        contentPane.add(getLabel_2());
        contentPane.add(getBtnEnter());
        contentPane.add(getChckbxNewCheckBox());

        //Construimos la ventana principal


        daoUsuario = new DAOUsuario();
        users = daoUsuario.consultarUsuario();
    }

    private JPasswordField getPasswordField() {
        if (passwordField == null) {
            passwordField = new JPasswordField();
            passwordField.setBounds(14, 212, 228, 28);
            passwordField.setFont(new Font("Bahnschrift", Font.BOLD, 16));
            passwordField.setEchoChar('*');

            passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyChar() == '\n'){
                        Usuario user = new Usuario(getTextFieldUsuario().getText(), String.valueOf(passwordField.getPassword()));
                        if(users.contains(user)) {
                            try{
                                window = new Window();
                                window.setVisible(true);
                            }catch (Exception e1){
                                System.out.println(e1.getMessage());
                            }
                            dispose();

                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        }
                    }


                }
            });
        }
        return passwordField;
    }

    private JLabel getLblContrasenna() {
        if (lblContrasenna == null) {
            lblContrasenna = new JLabel("Contraseña");
            lblContrasenna.setFont(new Font("Bahnschrift", Font.BOLD, 16));
            lblContrasenna.setBounds(14, 173, 110, 28);
        }
        return lblContrasenna;
    }

    private JLabel getLabel_1() {
        if (lblUsuario == null) {
            lblUsuario = new JLabel("Usuario");
            lblUsuario.setFont(new Font("Bahnschrift", Font.BOLD, 16));
            lblUsuario.setBounds(10, 74, 110, 28);
        }
        return lblUsuario;
    }

    private JTextField getTextFieldUsuario() {
        if (txtFUsuario == null) {
            txtFUsuario = new JTextField();
            txtFUsuario.setBounds(10, 113, 228, 28);
            txtFUsuario.setColumns(10);


        }
        return txtFUsuario;
    }

    private JLabel getLabel_2() {
        if (lblLogin == null) {
            lblLogin = new JLabel("Login");
            lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
            lblLogin.setFont(new Font("Bahnschrift", Font.BOLD, 20));
            lblLogin.setBounds(77, 11, 110, 35);
        }
        return lblLogin;
    }

    private JButton getBtnEnter() {
        if (btnEntrar == null) {
            btnEntrar = new JButton("Entrar");
            btnEntrar.setBounds(185, 302, 89, 23);

            btnEntrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Usuario user = new Usuario(getTextFieldUsuario().getText(), String.valueOf(passwordField.getPassword()));

                    if(users.contains(user)){
                        try{
                            window = new Window();
                            window.setVisible(true);
                        }catch (Exception e1){
                            System.out.println(e1.getMessage());
                        }
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            });

        }
        return btnEntrar;
    }

    private JCheckBox getChckbxNewCheckBox() {
        if (chckbxShowPwd == null) {
            chckbxShowPwd = new JCheckBox("Mostrar Contraseña");
            chckbxShowPwd.setBounds(10, 249, 148, 23);

            chckbxShowPwd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(chckbxShowPwd.isSelected())
                        passwordField.setEchoChar((char)0);
                    else
                        passwordField.setEchoChar('*');
                }
            });
        }
        return chckbxShowPwd;
    }


}
