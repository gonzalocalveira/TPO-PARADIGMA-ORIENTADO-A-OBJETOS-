package modelo;

public class Cliente extends Persona{
    
    
    public  Cliente(String nombre, int edad, String correoElectronico, 
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

    public String toString(){
        return "Nombre: " + getNombre() + " Edad: " + getEdad() + 
        " Correo Electronico: " + getCorreoElectronico() +
        " Contrasenia: " + getContrasenia();
    }



}
