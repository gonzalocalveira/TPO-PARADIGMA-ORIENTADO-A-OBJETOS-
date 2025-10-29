package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;


public class VistaUsuario extends JFrame{

    private JTextField txtNombre, txtCorreo, txtContrasenia;
    private JButton btnRegistrar;  

    public VistaUsuario() {
        setTitle("Gestión de Usuarios");
        setSize(5000, 4000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 200, 25);
        add(txtNombre);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(30, 70, 100, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(140, 70, 200, 25);
        add(txtCorreo);

        JLabel lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setBounds(30, 110, 100, 25);
        add(lblContrasenia);

        txtContrasenia = new JTextField();
        txtContrasenia.setBounds(140, 110, 200, 25);
        add(txtContrasenia);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(140, 160, 120, 30);
        add(btnRegistrar);
    }

    public String getNombre() { return txtNombre.getText(); }
    public String getCorreo() { return txtCorreo.getText(); }
    public String getContrasenia() { return txtContrasenia.getText(); }
    

    public void addRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }
}
