package modelo.Interface;

public interface IManejoDeArchivos {
    public boolean leer(String nombreArchivo, String datoBuscado);
    public <T> boolean escribir( String nombreArchivo,  T objeto, boolean append);

    public String buscarFacturaCliente(String nombreArchivo, String correoCliente);





}
