package modelo;

import java.util.*;
public class GestorCompras {
    private List<Factura> facturas;

    private ManejoDeArchivos manejoDeArchivos;
    private final String ARCHIVO_COMPRA="compra.txt";
    private GestorProductos gestorProductos;

    private CarritoDeCompra carritoDeCompra;

    public GestorCompras(){
        facturas= new ArrayList<Factura>();
        manejoDeArchivos= new ManejoDeArchivos();
        gestorProductos= new GestorProductos();

    }

    public boolean guardarCompras(){
        for(Factura f: facturas){
            if(!manejoDeArchivos.leer(ARCHIVO_COMPRA, f.getNroFactura())){
                return manejoDeArchivos.escribir(ARCHIVO_COMPRA, f, true);
             }
            
        }
        return false;
    }

    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }

    public boolean actualizarStockProducto(){

        HashMap<Producto, Integer> productosDeCarritoCompra= carritoDeCompra.getProductos();
        for(Factura f: facturas){
            for(Map.Entry<Producto,Integer> p: productosDeCarritoCompra.entrySet()){
                
                return gestorProductos.actualizarStockProducto(p.getKey(), p.getValue());
            }
           
        }
        return false;
        
    }

     
    public String consultarCompraPorCliente(Usuario u){

       return manejoDeArchivos.buscarFacturaCliente(ARCHIVO_COMPRA, u.getNombre());

    }
    
}

