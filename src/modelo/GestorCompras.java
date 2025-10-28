package modelo;

import java.util.*;


import modelo.Interface.*;
public class GestorCompras implements IGestorCompras {
    private List<IFactura> facturas;

    private IManejoDeArchivos manejoDeArchivos;
    private final String ARCHIVO_COMPRA="compra.txt";
    private IGestorProductos gestorProductos;

    private CarritoDeCompra carritoDeCompra;

    
    public GestorCompras(){
        facturas= new ArrayList<IFactura>();
        manejoDeArchivos= new ManejoDeArchivos();
        gestorProductos= new GestorProductos();

    }
    
    @Override
    public boolean guardarCompras(){
        for(IFactura f: facturas){
            if(!manejoDeArchivos.leer(ARCHIVO_COMPRA, f.getNroFactura())){
                return manejoDeArchivos.escribir(ARCHIVO_COMPRA, f, true);
             }
            
        }
        return false;
    }

    @Override
    public void agregarFactura(IFactura factura){
        facturas.add(factura);
    }

    @Override
    public boolean actualizarStockProducto(){

        HashMap<Producto, Integer> productosDeCarritoCompra= carritoDeCompra.getProductos();
        for(IFactura f: facturas){
            for(Map.Entry<Producto,Integer> p: productosDeCarritoCompra.entrySet()){
                
                return gestorProductos.actualizarStockProducto(p.getKey(), p.getValue());
            }
           
        }
        return false;
        
    }

    
    @Override
    public String consultarCompraPorCliente(Usuario u){

       return manejoDeArchivos.buscarFacturaCliente(ARCHIVO_COMPRA, u.getNombre());

    }
    
}

