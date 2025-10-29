import controlador.ControladorLogin;
import controlador.ControladorUsuario;
import modelo.GestorUsuario;
import modelo.Interface.ISistemaAlmacen;
import vista.VistaLogin;
import vista.VistaUsuario;
import modelo.SistemaAlmacen;

public class Main {


    public static void main(String[] args) {
        ISistemaAlmacen sistema = new SistemaAlmacen();
        VistaLogin vista = new VistaLogin();
        new ControladorLogin(vista, sistema);
        vista.setVisible(true);
    
    }


    

}

