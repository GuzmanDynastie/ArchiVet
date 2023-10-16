package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Citas;
import ArchiVet.Util.closeResource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MySQL_Citas extends DAO {

    private static final closeResource CLOSE_RESOURCE = new closeResource();

    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");
    private final String FECHA_FORMATO = FORMATO_FECHA.format(new Date());

    private final static String INSERT = "INSERT INTO citas(Hora_Cita, Fecha_Cita, Estado, Servicio_Cita, Detalle_Cita, Observaciones, Especie, Nombre_Mascota, "
            + "Sexo_Mascota, Raza, Color, Año_Nacimiento, Propietario, Apellidos, Telefono, Correo, Domicilio, Codigo_Postal, Numero_Socio) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String GET = "SELECT ID, Hora_Cita, Fecha_Cita, Estado, Servicio_Cita, Detalle_Cita, Observaciones, Especie, Nombre_Mascota, Sexo_Mascota,"
            + " Raza, Color, Año_Nacimiento, Propietario, Apellidos, Telefono, Correo, Numero_Socio FROM citas WHERE Estado = 'Pendiente' AND Fecha_Cita >= ?";
    private final String CONSULTAR_POR_ID = "SELECT * FROM citas WHERE ID = ?";
    private final static String GET_BUSCADOR_CITAS = "SELECT * FROM mascota INNER JOIN propietario WHERE mascota.ID_propietario = propietario.ID";
    private final static String UPDATE = "UPDATE citas SET Hora_Cita = ?, Fecha_Cita = ?, Estado = ?, Servicio_Cita = ?, Detalle_Cita = ?, Observaciones = ? WHERE ID = ?";
    public static final String[] CAMPOS_TABLA = new String[]{"HORA CITA", "FECHA CITA", "ESTADO", "SERVICIO", "ESPECIE", "MASCOTA", "SEXO", "RAZA", "COLOR", "AÑO NAC.",
        "PROPIETARIO", "TELEFONO", "CORREO", "N° SOCIO", "", "ID"};
    public static final String[] CAMPOS_TABLA_BUSCADOR = new String[]{"MASCOTAS", "SEXO", "ESPECIE", "RAZA", "COLOR", "FECHA NAC.", "PROPIETARIO", "APELLIDO P", "APELLIDO M", "TELEFONO", "CORREO", "DOMICILIO", "C.P.", "N° SOCIO"};

    private void completarPreparedStatement(Citas citas, PreparedStatement prep) throws SQLException {
        prep.setString(1, citas.getHoraCita());
        prep.setString(2, citas.getFechaCita());
        prep.setString(3, citas.getEstadoCita());
        prep.setString(4, citas.getServicioCita());
        prep.setString(5, citas.getDetalleCita());
        prep.setString(6, citas.getObservacionesCita());
        prep.setString(7, citas.getEspecieMascota());
        prep.setString(8, citas.getNombreMascota());
        prep.setString(9, citas.getSexoMascota());
        prep.setString(10, citas.getRazaMascota());
        prep.setString(11, citas.getColorMascota());
        prep.setString(12, citas.getFechaNaciminetoMas());
        prep.setString(13, citas.getNombrePropietario());
        prep.setString(14, citas.getApellidosPropietario());
        prep.setString(15, citas.getTelefonoPropietario());
        prep.setString(16, citas.getCorreoPropietario());
        prep.setString(17, citas.getDomicilioPropietario());
        prep.setInt(18, citas.getCodigoPostal());
        prep.setInt(19, citas.getNumeroSocio());
    }

    public boolean incertarCita(Citas citas) {
        boolean resultado = false;
        PreparedStatement prep = null;
        try {
            prep = connection.prepare(INSERT);
            completarPreparedStatement(citas, prep);
            resultado = prep.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
        }
        return resultado;
    }

    public Citas[] listarCitas() {
        ArrayList<Citas> lista = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(GET);
            prep.setString(1, FECHA_FORMATO);
            rs = prep.executeQuery();

            while (rs.next()) {
                lista.add(new Citas(rs.getString("Hora_Cita"), rs.getString("Fecha_Cita"), rs.getString("Estado"), rs.getString("Servicio_Cita"),
                        rs.getString("Especie"), rs.getString("Nombre_Mascota"), rs.getString("Sexo_Mascota"), rs.getString("Raza"),
                        rs.getString("Color"), rs.getString("Año_Nacimiento"), rs.getString("Propietario"), rs.getString("Apellidos"),
                        rs.getString("Telefono"), rs.getString("Correo"), rs.getInt("Numero_Socio"), rs.getString("Detalle_Cita"),
                        rs.getString("Observaciones"), rs.getInt("ID")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {

            CLOSE_RESOURCE.closeResource(rs);
            CLOSE_RESOURCE.closeResource(prep);
        }
        return lista.toArray(Citas[]::new);
    }

    public Citas[] listarBuscadorMascotaCitas() {
        ArrayList<Citas> lista = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            rs = connection.executeQuery(GET_BUSCADOR_CITAS);

            while (rs.next()) {
                lista.add(new Citas(rs.getString("mascota.NOMBRE"), rs.getString("mascota.ESPECIE"), rs.getString("mascota.RAZA"),
                        rs.getString("mascota.COLOR"), rs.getString("mascota.SEXO"), rs.getString("mascota.AÑO_NACIMIENTO").substring(0, 4),
                        rs.getString("propietario.NOMBRE"), rs.getString("propietario.APELLIDO_P"), rs.getString("propietario.APELLIDO_M"),
                        rs.getString("propietario.TELEFONO"), rs.getString("propietario.CORREO"), rs.getString("propietario.DOMICILIO"),
                        rs.getInt("propietario.CODIGO_POSTAL"), rs.getInt("propietario.ID")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
            CLOSE_RESOURCE.closeResource(rs);
        }
        return lista.toArray(Citas[]::new);
    }

    public boolean actualizarCita(Citas citas) {
        PreparedStatement prep = null;
        try {
            prep = connection.prepare(UPDATE);
            prep.setString(1, citas.getHoraCita());
            prep.setString(2, citas.getFechaCita());
            prep.setString(3, citas.getEstadoCita());
            prep.setString(4, citas.getServicioCita());
            prep.setString(5, citas.getDetalleCita());
            prep.setString(6, citas.getObservacionesCita());
            prep.setInt(7, citas.getId());

            int rowsUpdated = prep.executeUpdate();

            if (rowsUpdated > 0) {
                return true; // La actualización fue exitosa
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            CLOSE_RESOURCE.closeResource(prep);
        }
        return false; // La actualización falló
    }

    public Citas consultarID(int ID) throws SQLException {
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            prep = connection.prepare(CONSULTAR_POR_ID);
            prep.setInt(1, ID);

            rs = prep.executeQuery();

            if (rs.next()) {

                return new Citas(rs.getString("Hora_Cita"), rs.getString("Fecha_Cita"), rs.getString("Estado"),
                        rs.getString("Servicio_Cita"), rs.getString("Detalle_Cita"), rs.getString("Observaciones"),
                        rs.getString("Especie"), rs.getString("Nombre_Mascota"), rs.getString("Sexo_Mascota"),
                        rs.getString("Raza"), rs.getString("Color"), rs.getString("Año_Nacimiento").substring(0, 4),
                        rs.getString("Propietario"), rs.getString("Apellidos"), rs.getString("Telefono"),
                        rs.getString("Correo"), rs.getString("Domicilio"), rs.getInt("Codigo_Postal"),
                        rs.getInt("Numero_Socio"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            CLOSE_RESOURCE.closeResource(rs);
            CLOSE_RESOURCE.closeResource(prep);
        }
    }
}
