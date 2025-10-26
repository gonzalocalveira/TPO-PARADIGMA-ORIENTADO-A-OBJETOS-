package modelo;

public class GestorProductos {


    public GestorProductos(){

    }

    public boolean actualizarStockProducto(Producto p, int cantidadADescontar){
        int stockProductoActual=p.getStock();

        if(stockProductoActual>=cantidadADescontar){
            p.getStock(stockProductoActual - cantidadADescontar);
            return true;
        } else {
            return false;
        }
    }

}
