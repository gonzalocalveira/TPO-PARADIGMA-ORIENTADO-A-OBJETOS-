package modelo;




import java.io.*;
import java.util.*;

import modelo.Interface.IManejoDeArchivos;
public class ManejoDeArchivos implements IManejoDeArchivos{


   


    public ManejoDeArchivos(){
        
    }

    @Override
    public boolean leer(String nombreArchivo, String datoBuscado){
        String linea;
        try{
            //se crea un objeto para leer el archivo
            BufferedReader entrada = new BufferedReader(new FileReader(nombreArchivo));

            linea=entrada.readLine();//leer el archivo
            while (linea!=null){

                if(linea.contains(datoBuscado)){

        
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
    


    @Override
    public <T> boolean escribir( String nombreArchivo,  T objeto, boolean append){
        try{

            BufferedWriter salida= new BufferedWriter(
                new FileWriter(nombreArchivo, append));
            salida.write(objeto.toString());
            salida.newLine();
            salida.close();
            return true;
        }
        catch (Exception e){

            return false;
        }
    }
    @Override
    public String buscarFacturaCliente(String nombreArchivo, String correoCliente){
        String linea;
        try{
            //se crea un objeto para leer el archivo
            BufferedReader entrada = new BufferedReader(new FileReader(nombreArchivo));

            linea=entrada.readLine();//leer el archivo
            while (linea!=null){

                if(linea.contains(correoCliente)){
                    return linea;

        
                    
                }

            linea=entrada.readLine();
            }

            entrada.close();
            return null;


        }catch (Exception e){
            return null;
        }
    }
}