package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Medicamento;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;

public class MySQL_Medicamento extends DAO {
    
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private final String fechaFormato = formatoFecha.format(new java.util.Date());
    
    private static final String INSERT = "INSERT INTO medicamentos(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL = "WITH CTE AS (SELECT Descripcion, Lote, Cantidad, Precio, Caducidad, ROW_NUMBER() OVER (PARTITION BY Descripcion ORDER BY Caducidad) "
            + "AS RowNum FROM medicamentos WHERE Cantidad > 0 AND Caducidad >= ?) SELECT Descripcion, Lote, Cantidad, Precio, Caducidad FROM CTE WHERE RowNum = 1";
    public static final String[] CAMPOS_TABLA = {"DESCRIPCION", "LOTE", "STOCK", "PRECIO UNITARIO", "CADUCIDAD", ""};
    
    private void completarPrepareStatement(Medicamento medicamento, PreparedStatement prep) throws SQLException {
        prep.setString(1, medicamento.getDescripcion());
        prep.setString(2, medicamento.getLote());
        prep.setInt(3, medicamento.getCantidad());
        prep.setDouble(4, medicamento.getPrecio());
        prep.setDate(5, (Date) medicamento.getCaducidad());
    }

    public boolean insertarMedicamento(Medicamento medicamento) {
        boolean resultado = false;
        try {
            PreparedStatement prep = connection.prepare(INSERT);
            completarPrepareStatement(medicamento, prep);
            resultado = prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }
    
    public Medicamento[] listarMedicamentos() throws SQLException {
        ArrayList<Medicamento> lista = new ArrayList<>();
        
        PreparedStatement prep = connection.prepare(GET_ALL);
        prep.setString(1, fechaFormato);
        
        try {
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                lista.add(new Medicamento(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"), 
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista.toArray(Medicamento[]::new);
    }
}
