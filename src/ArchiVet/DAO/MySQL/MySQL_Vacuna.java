package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Vacuna;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class MySQL_Vacuna extends DAO {
    
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private final String fechaFormato = formatoFecha.format(new java.util.Date());
    
    private static final String INSERT = "INSERT INTO vacunas(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL = "WITH CTE AS (SELECT Descripcion, Lote, Cantidad, Precio, Caducidad, ROW_NUMBER() OVER (PARTITION BY Descripcion ORDER BY Caducidad) "
            + "AS RowNum FROM vacunas WHERE Cantidad > 0 AND Caducidad >= ?) SELECT Descripcion, Lote, Cantidad, Precio, Caducidad FROM CTE WHERE RowNum = 1";
    public static final String[] CAMPOS_TABLA = {"DESCRIPCION", "LOTE", "STOCK", "PRECIO UNITARIO", "CADUCIDAD", ""};
    
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
    
    public Vacuna[] listarVacunas() throws SQLException {
        ArrayList<Vacuna> lista = new ArrayList<>();
        
        PreparedStatement prep = connection.prepare(GET_ALL);
        prep.setString(1, fechaFormato);
        
        try {
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                lista.add(new Vacuna(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"), 
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista.toArray(Vacuna[]::new);
    }
}
