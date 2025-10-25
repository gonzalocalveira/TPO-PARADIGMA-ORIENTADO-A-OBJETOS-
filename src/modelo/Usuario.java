package modelo;

public class Usuario {

    private String nombre;
    private String clave;

    public Usuario(String nombre, String clave){
        this.clave=clave;
        this.nombre=nombre;
    }

    public boolean validarUsuario(String nombre, String clave){
        if(this.clave.equals(clave)&& this.nombre.equals(nombre)){
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
