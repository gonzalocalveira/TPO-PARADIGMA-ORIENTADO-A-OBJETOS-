package modelo;

import java.util.Date;


public class Gaseosa extends Producto {

    private String marca;
    private double litros;

    public Gaseosa(String nombreProducto, double precioProducto,Date fechaVencimiento,
    int stock, double litros, String marcaProducto){
        super(nombreProducto,precioProducto,
        fechaVencimiento,stock,marcaProducto);
        this.litros = litros;
        
    }

    //getters y setters

    public String getMarca(){
        return marca;
    }

    public double getLitros(){
        return litros;
    }

   

    public void setMarca(String nuevaMarca){
        this.marca = nuevaMarca;
    }

    public void setLitros(double nuevosLitros){
        this.litros = nuevosLitros;
    }


    public String toString(){
        return "Gaseosa: "+ getNombreProducto() +", Marca: "+ marca +
        ", Litros: "+ litros +", Precio: "+ getPrecioProducto() +
        ", Stock: "+ getStock() +", Vence: "+ getFechaVencimiento();
    }
    
}