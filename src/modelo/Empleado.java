package modelo;

public class Empleado extends Usuario{
    
    
    public  Empleado(String nombre, int edad, String correoElectronico, 
    String contrasenia){
        super(nombre, edad,correoElectronico,contrasenia);

    }

    public String toString(){
        return "Nombre: " + getNombre() + " Edad: " + getEdad() + 
        " Correo Electronico: " + getCorreoElectronico() +
        " Contrasenia: " + getContrasenia();
    }
    
}
