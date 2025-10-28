package modelo.testeo;
import modelo.Interface.IGestorUsuario;
import modelo.GestorUsuario;
import modelo.Interface.ISistemaAlmacen;
import modelo.SistemaAlmacen;
import modelo.Cliente;
public class TesteoGestorUsuario {
    public static void main (String args[]){


        IGestorUsuario gestionUsuario= new GestorUsuario();
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
