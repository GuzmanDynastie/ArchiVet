package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Vacuna;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL_Vacuna extends DAO {
    
    private static final String INSERT = "INSERT INTO vacunas(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?, ?, ?, ?, ?)";
    
    private void completarPrepareStatement(Vacuna vacuna, PreparedStatement prep) throws SQLException {
        prep.setString(1, vacuna.getDescripcion());
        prep.setString(2, vacuna.getLote());
        prep.setInt(3, vacuna.getCantidad());
        prep.setDouble(4, vacuna.getPrecio());
        prep.setDate(5, (Date) vacuna.getCaducidad());
    }

    public boolean insertarVacuna(Vacuna vacuna) {
        boolean resultado = false;
        try {
            PreparedStatement prep = connection.prepare(INSERT);
            completarPrepareStatement(vacuna, prep);
            resultado = prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }
}
