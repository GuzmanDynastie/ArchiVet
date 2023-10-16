package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Desparacitante;
import ArchiVet.Util.closeResource;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQL_Desparacitante extends DAO {

    private static final closeResource CLOSE_RESOURCE = new closeResource();
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");
    private final String FECHA_FORMATO = FORMATO_FECHA.format(new java.util.Date());

    private static final String COMPARAR = "SELECT * FROM desparacitantes WHERE Descripcion = ? AND Lote = ? AND Precio = ? AND Caducidad = ?";
    private static final String UPDATE_INSERT = "UPDATE desparacitantes SET Cantidad = Cantidad + ? WHERE Id = ?";
    private static final String INSERT = "INSERT INTO desparacitantes(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL_VALIDATION = "WITH CTE AS (SELECT Descripcion, Lote, Cantidad, Precio, Caducidad, ROW_NUMBER() OVER (PARTITION BY Descripcion ORDER BY Caducidad) "
            + "AS RowNum FROM desparacitantes WHERE Cantidad > 0 AND Caducidad >= ?) SELECT Descripcion, Lote, Cantidad, Precio, Caducidad FROM CTE WHERE RowNum = 1";
    private static final String GET_ALL = "SELECT * FROM desparacitantes WHERE Caducidad >= ?";
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
        PreparedStatement prepSelect = null;
        PreparedStatement prepUpdate = null;
        PreparedStatement prepInsert = null;
        ResultSet rs = null;

        try {
            // Buscar una fila que coincida con los valores ingresados por el usuario
            prepSelect = connection.prepare(COMPARAR);
            prepSelect.setString(1, desparacitante.getDescripcion());
            prepSelect.setString(2, desparacitante.getLote());
            prepSelect.setDouble(3, desparacitante.getPrecio());
            prepSelect.setDate(4, (Date) desparacitante.getCaducidad());
            rs = prepSelect.executeQuery();
            if (rs.next()) {
                // Si se encuentra una fila que coincide, actualizar la cantidad sumándole la nueva cantidad ingresada por el usuario
                prepUpdate = connection.prepare(UPDATE_INSERT);
                prepUpdate.setInt(1, desparacitante.getCantidad());
                prepUpdate.setInt(2, rs.getInt("Id"));
                resultado = prepUpdate.executeUpdate() > 0;
            } else {
                // Si no se encuentra una fila que coincide, insertar una nueva fila con los datos ingresados por el usuario
                prepInsert = connection.prepare(INSERT);
                completarPrepareStatement(desparacitante, prepInsert);
                resultado = prepInsert.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(rs);
            CLOSE_RESOURCE.closeResource(prepSelect);
            CLOSE_RESOURCE.closeResource(prepUpdate);
            CLOSE_RESOURCE.closeResource(prepInsert);
        }
        return resultado;
    }

    public Desparacitante[] listarDesparacitantes() throws SQLException {
        ArrayList<Desparacitante> lista = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(GET_ALL_VALIDATION);
            prep.setString(1, FECHA_FORMATO);
            rs = prep.executeQuery();

            while (rs.next()) {
                lista.add(new Desparacitante(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"),
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prep != null) {
                    prep.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
        return lista.toArray(Desparacitante[]::new);
    }

    public Desparacitante[] listarDesparacitantesInventario() throws SQLException {
        ArrayList<Desparacitante> lista = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;
  
        try {
            prep = connection.prepare(GET_ALL);
            prep.setString(1, FECHA_FORMATO);
            rs = prep.executeQuery();
            while (rs.next()) {
                lista.add(new Desparacitante(rs.getString("Descripcion"), rs.getString("Lote"), rs.getInt("Cantidad"),
                        rs.getDouble("Precio"), rs.getDate("Caducidad")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(rs);
            CLOSE_RESOURCE.closeResource(prep);
        }
        return lista.toArray(Desparacitante[]::new);
    }
}
