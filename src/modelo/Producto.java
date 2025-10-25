package modelo;

import java.util.Date;
import java.util.Objects;
public abstract class Producto {
    
    private String nombreProducto;
    private double precioProducto;
    private Date fechaVencimiento;
    private int stock;
    private String marcaProducto;

    public Producto(String nombreProducto, double precioProducto, Date fechaVencimiento,
     int stock, String marcaProducto){
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.fechaVencimiento = fechaVencimiento;
        this.stock = stock;
        this.marcaProducto = marcaProducto;
    }

    //getters y setters

    public String getNombreProducto(){
        return nombreProducto;
    }

    public double getPrecioProducto(){
        return precioProducto;
    }

    public int getStock(){
        return stock;
    }

    public Date getFechaVencimiento(){
        return fechaVencimiento;
    }

    public String getMarcaProducto(){
        return marcaProducto;
    }

    public void setMarcaProducto(String nuevaMarcaProducto){
        this.marcaProducto = nuevaMarcaProducto;
    }

    public void setNombreProducto(String nuevoNombreProducto){
        this.nombreProducto = nuevoNombreProducto;
    }

    public void setPrecioProducto(int nuevoPrecioProducto){
        this.precioProducto = nuevoPrecioProducto;
    }

    public void getStock(int nuevoStock){
        this.stock = nuevoStock;
    }
    public void getFechaVencimiento(Date nuevaFechaVencimiento){
        this.fechaVencimiento = nuevaFechaVencimiento;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Producto producto = (Producto) obj;
         return nombreProducto.equalsIgnoreCase(producto.nombreProducto)
            && marcaProducto.equalsIgnoreCase(producto.marcaProducto);
    }

    @Override
    public int hashCode() {
         return Objects.hash(nombreProducto.toLowerCase(), marcaProducto.toLowerCase());
    }



}
