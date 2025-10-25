package modelo;

public class Proveedor {
    
    private String marca;
    private String direccion;


    public Proveedor(String marca, String direccion){
        this.marca = marca;
        this.direccion = direccion;
    }

    //getters y setters

    public String getMarca(){
        return marca;
    }

    public String getDirecciones(){
        return direccion;
    }

    public void setMarca(String nuevaMarca){
        this.marca = nuevaMarca;
    }

    public void setDireccion(String nuevaDireccion){
        this.direccion = nuevaDireccion;
    }

}
