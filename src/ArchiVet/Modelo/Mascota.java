package ArchiVet.Modelo;

public class Mascota {

    private int id_Mascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    private String sexo;
    private int anio;
    private int id_propietario;

    public Mascota(String nombre, String especie, String raza, String color, String sexo, int anio, int id_propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.sexo = sexo;
        this.anio = anio;
        this.id_propietario = id_propietario;
    }

    public int getID_Mascota() {
        return id_Mascota;
    }

    public void setID_Mascota(int id_Mascota) {
        this.id_Mascota = id_Mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id_Mascota=" + id_Mascota + ", nombre=" + nombre + ", raza=" + raza + ", sexo=" + sexo + ", anio=" + anio + '}';
    }
}
