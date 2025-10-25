package modelo;

public class Empleado extends Persona{
    
    
    public  Empleado(String nombre, int edad, String correoElectronico, 
    String contrasenia){
        super(nombre, edad,correoElectronico,contrasenia);

    }

    @Override
    public boolean validarUsuario(String correoElectronico, 
        String contrasenia){
        if(getContrasenia().equals(contrasenia)&& getCorreoElectronico().equals(correoElectronico)){
            return true;
        }
        return false;
    }
    
}
