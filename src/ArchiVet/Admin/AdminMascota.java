package ArchiVet.Administrador;

import ArchiVet.DAO.MySQL.MySQL_Mascota;
import ArchiVet.Modelo.Mascota;

public class AdminMascota {

    private MySQL_Mascota dao;

    public AdminMascota() {
        dao = new MySQL_Mascota();
    }

    public Mascota agregarMascota(String nombre, String especie, String raza, String color, String sexo, int anio, int id_propietario) {
        try {
            Mascota mascota = new Mascota(nombre, especie, raza, color, sexo, anio, id_propietario);
            return dao.insertarMascota(mascota) ? mascota : null;

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
