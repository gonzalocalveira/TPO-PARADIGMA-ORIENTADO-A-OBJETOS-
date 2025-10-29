package controlador;

import javax.swing.JOptionPane;

import modelo.GestorUsuario;
import modelo.Usuario;
import modelo.Interface.ISistemaAlmacen;
import vista.VistaUsuario;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorUsuario {
     private VistaUsuario vista;
    private ISistemaAlmacen sistema;

    public ControladorUsuario(VistaUsuario vista, ISistemaAlmacen sistema) {
        this.vista = vista;
        this.sistema = sistema;

        this.vista.addRegistrarListener(new RegistrarListener());
    }

    class RegistrarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nombre = vista.getNombre();
            String correo = vista.getCorreo();
            String contrasenia = vista.getContrasenia();

            Cliente nuevo = new Cliente(nombre,25, correo, contrasenia);

            if (sistema.getGestorUsuario().registrarUsuario(nuevo)) {
                JOptionPane.showMessageDialog(vista, "Usuario registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(vista, "Error: el usuario ya existe o los datos son inválidos");
            }
        }
    
}
}
