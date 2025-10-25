package controlador;

import modelo.GestionUsuario;
import modelo.Usuario;

public class ControladorUsuario {

    GestionUsuario gestionUsuarioDAO = new GestionUsuario();


    public ControladorUsuario(){

    }

    public String autenticarUsuario(String nombbreUsuario, String clave){

        if(nombbreUsuario.trim().isEmpty() || clave.trim().isEmpty()){
            return "Error: usuario y clave son obligatorios";
        }
        Usuario u=new Usuario(nombbreUsuario,clave);

        if(gestionUsuarioDAO.buscarUsuario(u)){
            return "ACCESO CONCEDIDO";
        }
        else{
            return  "Error: Credenciales incorrectas";

        }
    }

    public String registroUsuario(String nombbreUsuario, String clave){
        if(nombbreUsuario.trim().isEmpty() || clave.trim().isEmpty()){
            return "Error: usuario y clave son obligatorios";
        }
        Usuario usuario= new Usuario(nombbreUsuario, clave);
        if(gestionUsuarioDAO.guardarEnArchivo(usuario)){
            return "El usuario fue almacenado con exito";

        }
        else{
            return "Error";

        }

    }

}
