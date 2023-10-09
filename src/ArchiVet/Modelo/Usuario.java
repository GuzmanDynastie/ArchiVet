package ArchiVet.Modelo;

public class Usuario {
    
    private String usuario;
    private String contrasenia;

    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Usuario() {
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }
    
    
}
