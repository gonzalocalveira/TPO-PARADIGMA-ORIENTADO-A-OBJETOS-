package modelo;

public abstract class Persona {

    private String nombre;
    private int edad;

    private String correoElectronico;

    private String contrasenia;

    public Persona(String nombre, int edad, String correoElectronico, 
    String contrasenia){
        this.nombre=nombre;
        this.edad=edad;
        this.correoElectronico=correoElectronico;
        this.contrasenia=contrasenia;


    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
        
    }
    
    public int getEdad(){
        return edad;
    }

    public void setEdad(int nuevaEdad){
        this.edad=nuevaEdad;
    }

    public String getCorreoElectronico(){
        return correoElectronico;
    }

    public void setCorreoElectronico(String nuevoCorreoElectronico){
        this.correoElectronico=nuevoCorreoElectronico;

    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String nuevaContrasenia){
        this.contrasenia=contrasenia;
    }

    public abstract boolean validarUsuario(String correoElectronico, String contrasenia);
    
}
