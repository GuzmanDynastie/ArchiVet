package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_Usuario;
import ArchiVet.Modelo.Usuario;
import java.util.ArrayList;
import java.sql.SQLException;

public class AdminUsuario  {
    
    private MySQL_Usuario dao;
    private static ArrayList<String> listaUsuario;
    
    public AdminUsuario(){
        listaUsuario = new ArrayList<>();
        dao = new MySQL_Usuario();
    }
    
    public void agregarUsuario(String usuario) {
        listaUsuario.add(usuario);
    }

    public String dameListaUsuarios() {
        return listaUsuario.toString().replaceAll("\\[|\\]", "");
    }
    
    public boolean ingresarDataBase(Usuario usuario) {
        return dao.validarCredenciales(usuario);
    } 
    
    public Usuario[] dameNombreMedico() throws SQLException {
        return dao.obtenerNombreUsuario();
    }
}
