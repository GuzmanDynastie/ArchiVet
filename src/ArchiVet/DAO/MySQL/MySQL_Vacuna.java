package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Vacuna;
import ArchiVet.Util.closeResource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class MySQL_Vacuna extends DAO {

    private static final closeResource CLOSE_RESOURCE = new closeResource();
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");
    private final String FECHA_FORMATO = FORMATO_FECHA.format(new java.util.Date());

    private static final String COMPARAR = "SELECT * FROM vacunas WHERE Descripcion = ? AND Lote = ? AND Precio = ? AND Caducidad = ?";
    private static final String UPDATE_INSERT = "UPDATE vacunas SET Cantidad = Cantidad + ? WHERE Id = ?";
    private static final String INSERT = "INSERT INTO vacunas(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL_VALIDATION = "WITH CTE AS (SELECT Descripcion, Lote, Cantidad, Precio, Caducidad, ROW_NUMBER() OVER (PARTITION BY Descripcion ORDER BY Caducidad) "
            + "AS RowNum FROM vacunas WHERE Cantidad > 0 AND Caducidad >= ?) SELECT Descripcion, Lote, Cantidad, Precio, Caducidad FROM CTE WHERE RowNum = 1";
    private static final String GET_ALL = "SELECT * FROM vacunas WHERE Caducidad >= ? AND Cantidad > 0";
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
        PreparedStatement prepSelect = null;
        PreparedStatement prepUpdate = null;
        PreparedStatement prepInsert = null;
        ResultSet rs = null;

        try {
            // Buscar una fila que coincida con los valores ingresados por el usuario
            prepSelect = connection.prepare(COMPARAR);
            prepSelect.setString(1, vacuna.getDescripcion());
            prepSelect.setString(2, vacuna.getLote());
            prepSelect.setDouble(3, vacuna.getPrecio());
            prepSelect.setDate(4, (Date) vacuna.getCaducidad());
            rs = prepSelect.executeQuery();
            if (rs.next()) {
                // Si se encuentra una fila que coincide, actualizar la cantidad sumándole la nueva cantidad ingresada por el usuario
                prepUpdate = connection.prepare(UPDATE_INSERT);
                prepUpdate.setInt(1, vacuna.getCantidad());
                prepUpdate.setInt(2, rs.getInt("Id"));
                resultado = prepUpdate.executeUpdate() > 0;
            } else {
                // Si no se encuentra una fila que coincide, insertar una nueva fila con los datos ingresados por el usuario
                prepInsert = connection.prepare(INSERT);
                completarPrepareStatement(vacuna, prepInsert);
                resultado = prepInsert.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prepSelect);
            CLOSE_RESOURCE.closeResource(rs);
            CLOSE_RESOURCE.closeResource(prepUpdate);
            CLOSE_RESOURCE.closeResource(prepInsert);
        }
        return resultado;
    }

    public Vacuna[] listarVacunas() throws SQLException {
        ArrayList<Vacuna> lista = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(GET_ALL_VALIDATION);
            prep.setString(1, FECHA_FORMATO);
            rs = prep.executeQuery();

            while (rs.next()) {
                lista.add(new Vacuna(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"),
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
            CLOSE_RESOURCE.closeResource(rs);
        }
        return lista.toArray(Vacuna[]::new);
    }

    public Vacuna[] listarVacunasInventario() throws SQLException {
        ArrayList<Vacuna> lista = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(GET_ALL);
            prep.setString(1, FECHA_FORMATO);
            rs = prep.executeQuery();
            while (rs.next()) {
                lista.add(new Vacuna(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"),
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
            CLOSE_RESOURCE.closeResource(rs);
        }
        return lista.toArray(Vacuna[]::new);
    }
}
