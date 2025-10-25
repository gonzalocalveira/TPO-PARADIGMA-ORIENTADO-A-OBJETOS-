package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;

public class ManejoDeArchivos{

    private Usuario usuario;
    private String nombreArchivo;
    private String rutaArchivo;

    public ManejoDeArchivos(){
        
    }

    public boolean leer(){
        String linea;
        try{
            //se crea un objeto para leer el archivo
            BufferedReader entrada = new BufferedReader(new FileReader(rutaArchivo+nombreArchivo));

            linea=entrada.readLine();//leer el archivo
            while (linea!=null){
                if(linea.equals(){
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

    public boolean escribir(){
        
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
    


    



}