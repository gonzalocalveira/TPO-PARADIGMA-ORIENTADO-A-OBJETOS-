package modelo;
import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class GestionUsuario {

    //List<Usuario> usuarioList;

    private String nombreArchivo;
    private String rutaArchivo;

    public GestionUsuario(){
        nombreArchivo="usuario.txt";
        rutaArchivo="src/datos/";
    }

    public boolean buscarUsuario(Usuario u){


        String credencialesABuscar= u.getNombre()+","+u.getClave();
        String linea;
        try{
            //se crea un objeto para leer el archivo
            BufferedReader entrada = new BufferedReader(new FileReader(rutaArchivo+nombreArchivo));

            linea=entrada.readLine();//leer el archivo
            while (linea!=null){
                if(linea.equals(credencialesABuscar)){
                    return true;
                }

            linea=entrada.readLine();
            }

            entrada.close();
            return false;


        }catch (Exception e){
            return false;

        }
    }

    public boolean guardarEnArchivo(Usuario usuario){
        File archivo = new File(rutaArchivo + nombreArchivo);

        try{

            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo,true));
            if(!buscarUsuario(usuario)){
                if(validarCorreo(usuario)&& validarCorreo(usuario)) {

                    escribir.newLine();
                    escribir.write(usuario.getNombre() + ',' + usuario.getClave());

                    escribir.close();

                    return true;
                }
            }
            escribir.close();
            return false;
        } catch (Exception e){
            return false;
        }

    }

    public boolean validarCorreo(Usuario usuario){
        //ejemplo: gcalveira@uade.edu.ar

        String[] coincidencias = {"gmail", "hotmail", "uade", ".com", ".ar"};

        // Verifica que tenga exactamente un '@'
        String[] partesCorreo = usuario.getNombre().split("@");
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
        if(usuario.getClave().length()<8){
            return false;
        }
        return true;
    }


}
