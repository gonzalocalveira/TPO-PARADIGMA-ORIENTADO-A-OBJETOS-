package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

public class Factura {
    //atributos
    private String nroFactura;
    private LocalDateTime fecha;

    private MediosDePago mediosDePago;
    private double total;
    private CarritoDeCompra carritoDeCompra;
    private boolean pagoProcesado;

    //constructor
    public Factura (String nroFactura, CarritoDeCompra carritoDeCompra, MediosDePago mediosDePago){
        this.nroFactura = nroFactura;
        this.carritoDeCompra = carritoDeCompra;
        this.fecha = LocalDateTime.now();

        this.mediosDePago = mediosDePago;
        this.pagoProcesado = false;
        this.total = carritoDeCompra.getPrecioTotal();
    }
    //getters, setters y metodos
    public String getNroFactura(){
        return nroFactura;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }

    public double calcularTotal(){
        return total=carritoDeCompra.getPrecioTotal();
    }

    public CarritoDeCompra getCarritoDeCompras(){
        return carritoDeCompra;
    }

    public MediosDePago getMediosDePago(){
        return mediosDePago;
    }

    public double getTotal(){
        return total;
    }

    public void setNroFactura(String nuevoNroFactura){
        this.nroFactura = nuevoNroFactura;
    }

    public void setFecha(LocalDateTime nuevaFecha){
        this.fecha = nuevaFecha;
    }

    

    public boolean procesarPago() {
    if (carritoDeCompra.getPrecioTotal() <= 0) {
        System.out.println("No se puede procesar el pago: carrito vacío o total inválido.");
        return false;
    }
        boolean exito = mediosDePago.procesarPago(carritoDeCompra.getPrecioTotal());
        if (!exito) {
            return false;
        }
        pagoProcesado = true;
        return true;
}

    public void mostrarFactura(){
        System.out.println("===============================================================");
        System.out.println("                 FACTURA                        ");
        System.out.println("Factura nro: " + nroFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + carritoDeCompra.getCliente().getNombre());
        System.out.println("===============================================================");

        System.out.printf("%-20s %-15s %-10s %-10s\n", "Producto", "Marca", "Cantidad", "Subtotal");
        System.out.println("---------------------------------------------------------------");

        for (Map.Entry<Producto, Integer> p : carritoDeCompra.getProductos().entrySet()) {
        Producto prod = p.getKey();
        int cantidad = p.getValue();
        double subtotal = prod.getPrecioProducto() * cantidad;

        System.out.printf("%-20s %-15s %-10d $%-10.2f\n",
                prod.getNombreProducto(),
                prod.getMarcaProducto(),
                cantidad,
                subtotal);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("Medio de pago: %-20s Total: $%.2f\n", mediosDePago.getTipoPago(), total);
        System.out.println("===============================================================");
    } 

    public String toString(){
        return "Factura nro: " + nroFactura + 
        ", Fecha: " + fecha + 
        ", Cliente: " + carritoDeCompra.getCliente().getNombre() +
        ", Productos: "+carritoDeCompra.getProductos()+", Total: " + total +
        ", Medio de pago: " + mediosDePago.getTipoPago();
    }
}
