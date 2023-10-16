package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Usuario;
import ArchiVet.Util.closeResource;
import ArchiVet.ventana.ventana_iniciarSesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQL_Usuario extends DAO {

    private static final closeResource CLOSE_RESOURCE = new closeResource();

    private final String LOGIN = "SELECT COUNT(*) FROM medicos WHERE USUARIO = ? AND CONTRASEÑA = ? AND ESTADO = 1";
    private final String GET_NOMBRE_COMPLETO = "SELECT NOMBRE, APELLIDO FROM medicos WHERE USUARIO = ?";

    public boolean validarCredenciales(Usuario usuario) {
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(LOGIN);
            prep.setString(1, usuario.getUsuario());
            prep.setString(2, usuario.getContrasenia());

            rs = prep.executeQuery();

            if (rs.next()) {
                int cantidad = rs.getInt(1);
                return cantidad > 0;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
            CLOSE_RESOURCE.closeResource(rs);
        }
        return false;
    }

    public Usuario[] obtenerNombreUsuario() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList();
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(GET_NOMBRE_COMPLETO);
            prep.setString(1, ventana_iniciarSesion.nombreUsuario.get(0).toString());
            rs = prep.executeQuery();

            if (rs.next()) {
                lista.add(new Usuario(rs.getString("NOMBRE") + " " + rs.getString("APELLIDO")));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
            CLOSE_RESOURCE.closeResource(rs);
        }
        return lista.toArray(Usuario[]::new);
    }
}
