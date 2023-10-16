package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL_Usuario extends DAO {

    private final String LOGIN = "SELECT COUNT(*) FROM medicos WHERE USUARIO = ? AND CONTRASEÑA = ? AND ESTADO = 1";
    private final String GET_NOMBRE_COMPLETO = "SELECT NOMBRE, APELLIDO FROM medicos WHERE USUARIO = ?";

    public boolean validarCredenciales(Usuario usuario) {
        try (PreparedStatement prep = connection.prepare(LOGIN)) {
            prep.setString(1, usuario.getUsuario());
            prep.setString(2, usuario.getContrasenia());

            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    int cantidad = rs.getInt(1);
                    return cantidad > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    public Usuario obtenerNombreUsuario(String usuario) throws SQLException {
        
        PreparedStatement prep = connection.prepare(GET_NOMBRE_COMPLETO);
        prep.setString(0, usuario);
        try (ResultSet rs = prep.executeQuery()) {
            if (rs.next()) {

                return new Usuario(rs.getString("NOMBRE"), rs.getString("APELLIDO"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
