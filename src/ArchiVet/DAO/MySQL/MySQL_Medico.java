package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQL_Medico extends DAO {

    private final String INSERT = "INSERT INTO medicos(NOMBRE, APELLIDO, USUARIO, CONTRASEÑA, TELEFONO, CELULAR, CORREO_ELECTRONICO, DOMICILIO, CODIGO_POSTAL, CARGO, CEDULA)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CONSULTAR_POR_ID = "SELECT * FROM medicos WHERE ID = ?";
    private final String UPDATE = "UPDATE medicos SET NOMBRE = ?, APELLIDO = ?, USUARIO = ?, CONTRASEÑA = ?, TELEFONO = ?, CELULAR = ?, CORREO_ELECTRONICO = ?, DOMICILIO = ?,"
            + " CODIGO_POSTAL = ?, CARGO = ?, CEDULA = ? WHERE ID = ?";
    private final String GET_ALL = "SELECT * FROM medicos WHERE ID <> 7 AND ESTADO = 1";
    private final String DELETE = "UPDATE medicos SET ESTADO = ? WHERE ID = ?";
    public static final String[] CAMPOS_TABLA = new String[]{"ID", "NOMBRE", "APELLIDO", "CELULAR", "CARGO"};

    private void completarPrepareStatement(Medico medico, PreparedStatement prep) throws SQLException {
        prep.setString(1, medico.getNombre());
        prep.setString(2, medico.getApellidoP());
        prep.setString(3, medico.getUsuario());
        prep.setString(4, medico.getContrasenia());
        prep.setString(5, medico.getTelefono());
        prep.setString(6, medico.getCelular());
        prep.setString(7, medico.getEmail());
        prep.setString(8, medico.getDireccion());
        prep.setString(9, medico.getCP());
        prep.setString(10, medico.getCargo());
        prep.setString(11, medico.getCelular());
    }

    public boolean insertarMedico(Medico medico) {
        boolean resultado = false;
        try {
            PreparedStatement prep = connection.prepare(INSERT);
            completarPrepareStatement(medico, prep);
            resultado = prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }

    public Medico consultarID(int ID) throws SQLException {

        PreparedStatement prep = connection.prepare(CONSULTAR_POR_ID);
        prep.setInt(1, ID);

        try (ResultSet rs = prep.executeQuery()) {
            if (rs.next()) {

                return new Medico(rs.getString("TELEFONO"), rs.getString("USUARIO"), rs.getString("CONTRASEÑA"),
                        rs.getString("CARGO"), rs.getString("CEDULA"), rs.getString("NOMBRE"), rs.getString("APELLIDO"),
                        rs.getString("CELULAR"), rs.getString("CORREO_ELECTRONICO"), rs.getString("DOMICILIO"),
                        rs.getString("CODIGO_POSTAL"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean actualizarMedico(Medico medico) {
        PreparedStatement prep = null;
        try {
            prep = connection.prepare(UPDATE);
            completarPrepareStatement(medico, prep);
            prep.setInt(12, medico.getId());

            int rowsUpdated = prep.executeUpdate();

            if (rowsUpdated > 0) {
                return true; // La actualización fue exitosa
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
        }
        return false; // La actualización falló
    }
    
    public boolean eliminarMedico(Medico medico) {
        PreparedStatement prep = null;
        try {
            prep = connection.prepare(DELETE);
            prep.setInt(1, medico.getEstado());
            prep.setInt(2, medico.getId());

            int rowsUpdated = prep.executeUpdate();
            if (rowsUpdated > 0) {
                return true; // La actualización fue exitosa
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
        }
        return false; // La actualización falló
    }

    public Medico[] obtenerDatosMedico() {
        ArrayList<Medico> lista = new ArrayList();
        try {
            ResultSet rs = connection.executeQuery(GET_ALL);
            while (rs.next()) {
                lista.add(new Medico(rs.getInt("ID"), rs.getString("TELEFONO"), rs.getString("USUARIO"),
                        rs.getString("CONTRASEÑA"), rs.getString("CARGO"), rs.getString("CEDULA"),
                        rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("CELULAR"),
                        rs.getString("CORREO_ELECTRONICO"), rs.getString("DOMICILIO"), rs.getString("CODIGO_POSTAL")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista.toArray(Medico[]::new);
    }

    

}
