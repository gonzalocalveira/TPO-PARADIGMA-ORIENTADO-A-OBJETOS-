package testeo;
import modelo.*;
public class TesteoGestionUsuario {
    public static void main (String args[]){

        GestionUsuario gestionUsuario= new GestionUsuario();
        Cliente cliente1 = new Cliente ("Gonzalo",
             25,"gcalveira@uade.edu.ar",
             "12345");

        //Registro de usuario
        if(gestionUsuario.registrarUsuario(cliente1)){
            System.out.println("Usuario registrado con exito");
        }
        else{
            System.out.println("El usuario ya existe");
        }
        //Inicio de sesion
        if(gestionUsuario.iniciarSesion(cliente1)){
            System.out.println("Inicio de sesion exitoso");
        }
        else{
            System.out.println("Error en el inicio de sesion");
        }
        
        
        
    }

}
