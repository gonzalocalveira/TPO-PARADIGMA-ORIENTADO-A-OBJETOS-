package modelo;

import java.util.Date;



public class Queso  extends Producto  {
    private String tipoQueso;
    

  public Queso(String nombreProducto, double precioProducto, Date fechaVencimiento,
    int stock, String marcaProducto, String tipoQueso)
    {
        super(nombreProducto,precioProducto,
        fechaVencimiento,stock,marcaProducto);
        this.tipoQueso = tipoQueso;
    }

    

    //getters y setters

    public String getTipoQueso(){
        return tipoQueso;
    }
    
      

    public String toString(){
        return "Queso: "+ getNombreProducto() +", Marca: "+ getMarcaProducto() +
        ", Precio: "+ getPrecioProducto() +
        ", Stock: "+ getStock() +", Vence: "+ getFechaVencimiento();
    }
}


