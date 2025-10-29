package controlador;

import modelo.GestorUsuario;
import modelo.SistemaAlmacen;
import modelo.Usuario;
import modelo.Cliente;
import modelo.SistemaAlmacen;
import vista.VistaLogin;
import vista.VistaUsuario;
import modelo.Interface.ISistemaAlmacen;

import javax.swing.*;
import java.awt.event.*;

public class ControladorLogin {
    private VistaLogin vista;
     private ISistemaAlmacen sistema;


    public ControladorLogin(VistaLogin vista, ISistemaAlmacen sistema) {
        this.vista = vista;
        this.sistema = sistema;

        this.vista.addIniciarSesionListener(new IniciarSesionListener());
        this.vista.addRegistrarseListener(new RegistrarseListener());
    }

class IniciarSesionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String correo = vista.getCorreo();
            String contrasenia = vista.getContrasenia();
            
            if (correo.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(vista,
                    "Por favor, complete todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario usuario = new Cliente("Temporal", 0, correo, contrasenia);

            if (sistema.getGestorUsuario().iniciarSesion(usuario)) {
                JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso");
                // Acá podrías abrir la siguiente ventana del sistema
            } else {
                JOptionPane.showMessageDialog(vista, "Correo o contraseña incorrectos");
            }
        }
    }

    class RegistrarseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Abrir ventana de registro
            VistaUsuario vistaRegistro = new VistaUsuario();
            new ControladorUsuario(vistaRegistro, sistema);
            vistaRegistro.setVisible(true);
        }
    }
}
