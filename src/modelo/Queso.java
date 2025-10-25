package modelo;

import java.util.Date;



public class Queso  extends Producto  {
    private String tipoQueso;
    private String marca;
    


    public Queso(String nombreProducto, double precioProducto,Date fechaVencimiento,
    int stock, String marca, double litros, String marcaProducto){
        super(nombreProducto,precioProducto,fechaVencimiento,stock, marcaProducto);
        this.tipoQueso=tipoQueso;
        this.marca=marca;

    }
    
    
    public String getMarca(){
        return marca;
    }


  

    public void setMarca(String nuevaMarca){
        this.marca = nuevaMarca;
    }
    public String toString(){
        return "Queso: "+ getNombreProducto() +", Marca: "+ marca +
        ", Precio: "+ getPrecioProducto() +
        ", Stock: "+ getStock() +", Vence: "+ getFechaVencimiento();
    }


}


