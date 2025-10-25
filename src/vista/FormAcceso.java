package vista;

import controlador.ControladorUsuario;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormAcceso extends  JFrame{
    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JPanel pnlDatos;
    private JPanel pnlMensaje;
    private JButton btnIngresar;
    private JLabel lblMensaje;
    private JTextField txtUsuarioTextField;
    private JTextField contraseniaTextField;
    private JButton btnRegistrar;

    ControladorUsuario controladorUsuario=new ControladorUsuario();

    public FormAcceso(){
        iniciarFormulario();

        btnIngresar.addMouseListener(new MouseAdapter() { //escuchador para el boton "ingresar"
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                validarCredenciales();
            }
        });
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                registrarUsuario();
            }
        });
    }


    private void iniciarFormulario(){
        setContentPane(pnlPrincipal); //agrego el Jpanel principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cuando se cierre la ventana, finalice todo
        setSize(600,400); //tamanio
        setLocationRelativeTo(null); //se pone en el centro la ventana
    }

    public void validarCredenciales(){

        String elUsuario= txtUsuarioTextField.getText();
        String laClave=contraseniaTextField.getText();

        String resultado= controladorUsuario.autenticarUsuario(elUsuario,laClave);
        if(resultado.equals("ACCESO CONCEDIDO")){
            lblMensaje.setText(resultado);

        }
        else{
            lblMensaje.setText("ERROR. Volver a ingresar los datos");
        }
    }


    public void registrarUsuario(){
        String elUsuario= txtUsuarioTextField.getText();
        String laClave=contraseniaTextField.getText();

        String resultado= controladorUsuario.registroUsuario(elUsuario,laClave);
        if(resultado.equals("El usuario fue almacenado con exito")){
            lblMensaje.setText(resultado);

        }
        else {
            lblMensaje.setText(resultado);
        }

    }
}
