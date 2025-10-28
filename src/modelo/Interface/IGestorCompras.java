package modelo.Interface;

import modelo.Factura;
import modelo.Usuario;

public interface IGestorCompras {
    public boolean guardarCompras();

    public void agregarFactura(IFactura factura);

    public boolean actualizarStockProducto();

    public String consultarCompraPorCliente(Usuario u);

}
