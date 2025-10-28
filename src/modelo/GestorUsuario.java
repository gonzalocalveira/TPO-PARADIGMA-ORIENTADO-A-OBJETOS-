package modelo;

import java.util.*;

import modelo.Interface.IGestorUsuario;
import modelo.Interface.IManejoDeArchivos;

public class GestorUsuario implements IGestorUsuario {

    private List<Usuario> usuarios;
    private final String ARCHIVOS_USUARIOS = "usuarios.txt";
    private IManejoDeArchivos manejoDeArchivos;

    public GestorUsuario() {
        this.usuarios = new ArrayList<>();
        this.manejoDeArchivos = new ManejoDeArchivos();
    }

    @Override
    public boolean buscarUsuarioPorMail(String mail) {
        return manejoDeArchivos.leer(ARCHIVOS_USUARIOS, mail);
    }

    @Override
    public boolean buscarUsuarioPorContrasenia(String contrasenia) {
        return manejoDeArchivos.leer(ARCHIVOS_USUARIOS, contrasenia);
    }
    
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        if (!buscarUsuarioPorMail(usuario.getCorreoElectronico())) {
            if (validarCorreo(usuario) && validarContrasenia(usuario)) {
                usuarios.add(usuario);
                return manejoDeArchivos.escribir(ARCHIVOS_USUARIOS, usuario, true);
            }
        }
        return false;
    }

    @Override
    public void agregarUsuarioALaLista(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) {
        return buscarUsuarioPorMail(usuario.getCorreoElectronico()) &&
               buscarUsuarioPorContrasenia(usuario.getContrasenia());
    }

    @Override
    public boolean validarCorreo(Usuario usuario) {
        String correo = usuario.getCorreoElectronico();
        return correo.contains("@") && correo.contains(".");
    }

    @Override
    public boolean validarContrasenia(Usuario usuario) {
        return usuario.getContrasenia().length() >= 8;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
