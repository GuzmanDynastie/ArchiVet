package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Propietario;
import ArchiVet.Util.closeResource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQL_Propietario extends DAO {

    private static final closeResource CLOSE_RESOURCE = new closeResource();

    private final String INSERT = "INSERT INTO propietario(NOMBRE, APELLIDO_P, APELLIDO_M, TELEFONO, CORREO, DOMICILIO, CODIGO_POSTAL) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String GET_LAST_ID = "SELECT MAX(ID) FROM propietario";
    private final String GET_ALL = "SELECT * FROM propietario";
    public static final String[] CAMPOS_TABLA = new String[]{"N° SOCIO", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "TELEFONO", "CORREO", "DOMICILIO", "C.P."};

    public boolean insertarPropietario(Propietario propietario) throws SQLException {
        boolean resultado = false;
        PreparedStatement prep = null;
        try {
            prep = connection.prepare(INSERT);
            prep.setString(1, propietario.getNombre());
            prep.setString(2, propietario.getApellidoP());
            prep.setString(3, propietario.getApellidoM());
            prep.setString(4, propietario.getCelular());
            prep.setString(5, propietario.getEmail());
            prep.setString(6, propietario.getDireccion());
            prep.setString(7, propietario.getCP());

            resultado = prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
        }
        return resultado;
    }

    public int obtenerUltimoID() throws SQLException {
        int ultimoID = -1;
        ResultSet rs = null;

        try {
            rs = connection.executeQuery(GET_LAST_ID);

            if (rs.next()) {
                ultimoID = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(rs);
        }
        return ultimoID;
    }

    public Propietario[] obtenerTodoPropietario() {
        ArrayList<Propietario> lista = new ArrayList();
        ResultSet rs = null;

        try {
            rs = connection.executeQuery(GET_ALL);
            while (rs.next()) {
                lista.add(new Propietario(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO_P"),
                        rs.getString("APELLIDO_M"), rs.getString("TELEFONO"), rs.getString("CORREO"),
                        rs.getString("DOMICILIO"), rs.getString("CODIGO_POSTAL")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(rs);
        }
        return lista.toArray(Propietario[]::new);
    }

}
