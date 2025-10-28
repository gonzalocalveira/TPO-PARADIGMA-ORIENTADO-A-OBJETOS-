package modelo;
import java.util.*;

import modelo.Interface.IGestorProductos;
import modelo.Interface.IManejoDeArchivos;

public class GestorProductos implements IGestorProductos {

    private List<Producto> productos;
    private IManejoDeArchivos manejoDeArchivos;
    private final String ARCHIVO_PRODUCTOS="productos.txt";

    public GestorProductos(){
        productos= new ArrayList<Producto>();
        manejoDeArchivos= new ManejoDeArchivos();

    }

    @Override
    public void agregarProducto(Producto p){
        productos.add(p);
    }

    @Override
    public boolean actualizarStockProducto(Producto p, int cantidadADescontar){
        int stockProductoActual=p.getStock();

        if(stockProductoActual>=cantidadADescontar){
            p.getStock(stockProductoActual - cantidadADescontar);
            return true;
        } else {
            return false;
        }
    }

     @Override
    public List<Producto> getProductos(){
        return productos;
    }

     @Override
    public boolean guardarProducto(){
        for(Producto p: productos){
            if(!manejoDeArchivos.leer(ARCHIVO_PRODUCTOS, p.getNombreProducto())){
                return manejoDeArchivos.escribir(ARCHIVO_PRODUCTOS, p, true);
             }
            
        }
        return manejoDeArchivos.escribir(ARCHIVO_PRODUCTOS, null, false);
    }
    
    @Override
    public Producto buscarProductoPorNombre(String nombreProducto){
        for(Producto p: productos){
            if(p.getNombreProducto().equalsIgnoreCase(nombreProducto)){
                return p;
            }
        }
        return null;
    }
    
    @Override
    public boolean eliminarProducto(Producto p){
        if(productos.contains(p)){
            productos.remove(p);
            return true;
        }
        return false;
    }


}
