package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Desparacitante;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQL_Desparacitante extends DAO {
    
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private final String fechaFormato = formatoFecha.format(new java.util.Date());

    private static final String COMPARAR = "SELECT * FROM desparacitantes WHERE Descripcion = ? AND Lote = ? AND Precio = ? AND Caducidad = ?";
    private static final String UPDATE_INSERT = "UPDATE desparacitantes SET Cantidad = Cantidad + ? WHERE Id = ?";
    private static final String INSERT = "INSERT INTO desparacitantes(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL = "WITH CTE AS (SELECT Descripcion, Lote, Cantidad, Precio, Caducidad, ROW_NUMBER() OVER (PARTITION BY Descripcion ORDER BY Caducidad) "
            + "AS RowNum FROM desparacitantes WHERE Cantidad > 0 AND Caducidad >= ?) SELECT Descripcion, Lote, Cantidad, Precio, Caducidad FROM CTE WHERE RowNum = 1";
    public static final String[] CAMPOS_TABLA = {"DESCRIPCION", "LOTE", "STOCK", "PRECIO UNITARIO", "CADUCIDAD", ""};

    private void completarPrepareStatement(Desparacitante desparacitante, PreparedStatement prep) throws SQLException {
        prep.setString(1, desparacitante.getDescripcion());
        prep.setString(2, desparacitante.getLote());
        prep.setInt(3, desparacitante.getCantidad());
        prep.setDouble(4, desparacitante.getPrecio());
        prep.setDate(5, (Date) desparacitante.getCaducidad());
    }
    
    public boolean insertarDesparacitante(Desparacitante desparacitante) {
    boolean resultado = false;
    try {
        // Buscar una fila que coincida con los valores ingresados por el usuario
        PreparedStatement prepSelect = connection.prepare(COMPARAR);
        prepSelect.setString(1, desparacitante.getDescripcion());
        prepSelect.setString(2, desparacitante.getLote());
        prepSelect.setDouble(3, desparacitante.getPrecio());
        prepSelect.setDate(4, (Date) desparacitante.getCaducidad());
        ResultSet rs = prepSelect.executeQuery();
        if (rs.next()) {
            // Si se encuentra una fila que coincide, actualizar la cantidad sumándole la nueva cantidad ingresada por el usuario
            PreparedStatement prepUpdate = connection.prepare(UPDATE_INSERT);
            prepUpdate.setInt(1, desparacitante.getCantidad());
            prepUpdate.setInt(2, rs.getInt("Id"));
            resultado = prepUpdate.executeUpdate() > 0;
        } else {
            // Si no se encuentra una fila que coincide, insertar una nueva fila con los datos ingresados por el usuario
            PreparedStatement prepInsert = connection.prepare(INSERT);
            completarPrepareStatement(desparacitante, prepInsert);
            resultado = prepInsert.executeUpdate() > 0;
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return resultado;
}
    
    public Desparacitante[] listarDesparacitantes() throws SQLException {
        ArrayList<Desparacitante> lista = new ArrayList<>();
        
        PreparedStatement prep = connection.prepare(GET_ALL);
        prep.setString(1, fechaFormato);
        
        try {
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                lista.add(new Desparacitante(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"), 
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista.toArray(Desparacitante[]::new);
    }
}
