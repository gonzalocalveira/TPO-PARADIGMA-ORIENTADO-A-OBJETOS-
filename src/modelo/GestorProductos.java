package modelo;
import java.util.*;

public class GestorProductos {

    private List<Producto> productos;
    private ManejoDeArchivos manejoDeArchivos;
    private final String ARCHIVO_PRODUCTOS="productos.txt";

    public GestorProductos(){
        productos= new ArrayList<Producto>();
        manejoDeArchivos= new ManejoDeArchivos();

    }

    public void agregarProducto(Producto p){
        productos.add(p);
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

    public List<Producto> getProductos(){
        return productos;
    }
    public boolean guardarProducto(){
        for(Producto p: productos){
            if(!manejoDeArchivos.leer(ARCHIVO_PRODUCTOS, p.getNombreProducto())){
                return manejoDeArchivos.escribir(ARCHIVO_PRODUCTOS, p, true);
             }
            
        }
        return manejoDeArchivos.escribir(ARCHIVO_PRODUCTOS, null, false);
    }

    public Producto buscarProductoPorNombre(String nombreProducto){
        for(Producto p: productos){
            if(p.getNombreProducto().equalsIgnoreCase(nombreProducto)){
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(Producto p){
        if(productos.contains(p)){
            productos.remove(p);
            return true;
        }
        return false;
    }


}
