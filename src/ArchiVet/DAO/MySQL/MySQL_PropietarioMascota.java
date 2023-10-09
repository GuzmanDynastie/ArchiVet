package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.PropietarioMascota;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL_PropietarioMascota extends DAO {

    private final String POPIETARIO_MASCOTA = "SELECT propietario.ID, propietario.NOMBRE, propietario.APELLIDO_P, propietario.APELLIDO_M, mascota.NOMBRE, mascota.RAZA, mascota.SEXO, "
            + "mascota.AÑO_NACIMIENTO, mascota.ID FROM propietario JOIN mascota ON mascota.ID_propietario = propietario.ID";
    public static final String[] CAMPOS_TABLA = new String[]{"N° SOCIO", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "MASCOTA", "RAZA", "SEXO", "AÑO NACIMIENTO", ""};

    public PropietarioMascota[] listarPropietariosMascotas() {
        ArrayList<PropietarioMascota> lista = new ArrayList<>();
        try {
            ResultSet rs = connection.executeQuery(POPIETARIO_MASCOTA);
            while (rs.next()) {
                lista.add(new PropietarioMascota(rs.getInt("propietario.ID"), rs.getString("propietario.NOMBRE"),
                        rs.getString("propietario.APELLIDO_P"), rs.getString("propietario.APELLIDO_M"),
                        rs.getString("mascota.NOMBRE"), rs.getString("mascota.RAZA"), rs.getString("mascota.SEXO"),
                        rs.getInt("mascota.AÑO_NACIMIENTO"), rs.getInt("mascota.ID")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
        return lista.toArray(PropietarioMascota[]::new);
    }
}
