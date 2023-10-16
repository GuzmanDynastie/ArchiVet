package ArchiVet.DAO;

import ArchiVet.Util.ConexionBaseDatosGenerica;
import java.sql.SQLException;

public abstract class DAO {

    final protected static String SERVIDOR = "localhost:3306"; //127.0.0.1
    final protected static String NOMBRE_BD = "sql9598240";
    final protected static String USUARIO = "root";
    final protected static String CONTRASENIA = "GuzmanJR7";

    protected static ConexionBaseDatosGenerica connection;

    public DAO() {
        this(SERVIDOR, 0, NOMBRE_BD, USUARIO, CONTRASENIA);
    }

    public DAO(String servidor, int puerto, String nombre_bd, String usuario, String contrasenia) {

        try {
            connection = new ConexionBaseDatosGenerica(SERVIDOR, 0, NOMBRE_BD, USUARIO, CONTRASENIA);
            //connection = new ConexionBaseDatosGenerica("sql9.freesqldatabase.com", 0, NOMBRE_BD, "sql9598240", "LfgbDjiVZ7");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

}
