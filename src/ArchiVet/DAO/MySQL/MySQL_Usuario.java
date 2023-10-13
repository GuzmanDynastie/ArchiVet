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
    
    
//    private final String LOGIN = "SELECT NOMBRE, APELLIDO FROM medicos WHERE USUARIO = ? AND CONTRASEÑA = ? AND ESTADO = 1";
//
//public boolean validarCredenciales(Usuario usuario) {
//    try (PreparedStatement prep = connection.prepareStatement(LOGIN)) {
//        prep.setString(1, usuario.getUsuario());
//        prep.setString(2, usuario.getContrasenia());
//
//        try (ResultSet rs = prep.executeQuery()) {
//            if (rs.next()) {
//                // Los datos de nombre y apellido se encuentran en las columnas 1 y 2 respectivamente
//                String nombre = rs.getString(1);
//                String apellido = rs.getString(2);
//                // Puedes almacenar estos valores en el objeto Usuario o hacer lo que necesites con ellos
//                usuario.setNombre(nombre);
//                usuario.setApellido(apellido);
//                return true;
//            }
//        }
//    } catch (SQLException e) {
//        System.err.println(e.getMessage());
//    }
//    return false;
//}
}
