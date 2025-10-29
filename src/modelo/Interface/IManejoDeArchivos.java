package modelo.Interface;

public interface IManejoDeArchivos {
    public boolean leer(String nombreArchivo, String datoBuscado);
    public <T> boolean escribir( String nombreArchivo,  T objeto, boolean append);
    public boolean validarLogin(String nombreArchivo, String correo, String contrasenia);
    public String buscarFacturaCliente(String nombreArchivo, String correoCliente);





}
