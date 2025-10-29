package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class VistaLogin extends JFrame {
    private JTextField txtCorreo;
    private JPasswordField txtContrasenia;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;

    public VistaLogin(){
        setTitle("Inicio de Sesión");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCentral = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        panelCentral.add(new JLabel("Correo electrónico:"));
        txtCorreo = new JTextField();
        panelCentral.add(txtCorreo);

        panelCentral.add(new JLabel("Contraseña:"));
        txtContrasenia = new JPasswordField();
        panelCentral.add(txtContrasenia);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnIniciarSesion = new JButton("Iniciar sesión");
        btnRegistrarse = new JButton("Registrarse");

        panelBotones.add(btnIniciarSesion);
        panelBotones.add(btnRegistrarse);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // --- Métodos para acceder a los datos ---
    public String getCorreo() {
        return txtCorreo.getText();
    }

    public String getContrasenia() {
        return new String(txtContrasenia.getPassword());
    }

    // --- Métodos para registrar los listeners ---
    public void addIniciarSesionListener(ActionListener listener) {
        btnIniciarSesion.addActionListener(listener);
    }

    public void addRegistrarseListener(ActionListener listener) {
        btnRegistrarse.addActionListener(listener);
    }

}
