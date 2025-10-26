package modelo;
import java.io.*;
import java.nio.Buffer;
import java.util.*;
import modelo.*;
public class GestionUsuario {

    private List<Usuario> usuarios;
    private final String ARCHIVOS_USUARIOS="usuario.txt";
    private ManejoDeArchivos manejoDeArchivos;

    public GestionUsuario(){
        manejoDeArchivos= new ManejoDeArchivos();
        usuarios= new ArrayList<Usuario>();
    }

    public boolean buscarUsuarioPorMail(String mail){
       return manejoDeArchivos.leer(ARCHIVOS_USUARIOS, mail);
    }

    public boolean buscarUsuarioPorContrasenia(String contrasenia){
        return manejoDeArchivos.leer(ARCHIVOS_USUARIOS, contrasenia);
    }

    public boolean registrarUsuario(Usuario usuario){
        if(!buscarUsuarioPorMail(usuario.getCorreoElectronico())){
            if(validarCorreo(usuario) && validarContrasenia(usuario)){
              
                
                return manejoDeArchivos.escribir(ARCHIVOS_USUARIOS,usuario, true);
            }
            return false;
           
                
         
        }
        else{
            return  false;
        }
    
    }

    public boolean iniciarSesion(Usuario usuario){
          //busco el usuario por correo y contrasnia 
        if(buscarUsuarioPorMail(usuario.getCorreoElectronico()) && 
        buscarUsuarioPorContrasenia(usuario.getContrasenia())){
            return true;

        }
        return false;




    }

    
    public boolean validarCorreo(Usuario usuario){
        //ejemplo: gcalveira@uade.edu.ar

        String[] coincidencias = {"gmail", "hotmail", "uade", "com", "ar"};

        // Verifica que tenga exactamente un '@'
        String[] partesCorreo = usuario.getCorreoElectronico().split("@");
        if (partesCorreo.length != 2) {
            return false;
        }

        // Verifica el dominio después del '@'
        String dominio = partesCorreo[1]; // Ej: "uade.edu.ar"
        String[] partesCorrePunto = dominio.split("\\."); // separa por puntos

        for (String parte : partesCorrePunto) {
            for (String coincidencia : coincidencias) {
                if (parte.contains(coincidencia)) {
                    return true;
                }
            }
        }

        return false;


    }

    public boolean validarContrasenia(Usuario usuario){
        if(usuario.getContrasenia().length()<8){
            return true;
        }
        return false;
    }

    public void agregarUsuarioALaLista(Usuario usuario){
        usuarios.add(usuario);
    }


}
