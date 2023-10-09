package ArchiVet.Modelo;

public class PropietarioMascota {

    private int idPropietario;
    private String nombrePropietario;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int id_mascota;
    private String nombreMascota;
    private String raza;
    private String sexo;
    private int añoNacimiento;

    public PropietarioMascota(int idPropietario, String nombrePropietario, String apellidoPaterno, String apellidoMaterno, String nombreMascota, String raza, String sexo, int añoNacimiento, int id_mascota) {
        this.idPropietario = idPropietario;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.sexo = sexo;
        this.añoNacimiento = añoNacimiento;
        this.id_mascota = id_mascota;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

   

//    @Override
//    public String toString() {
//        return "Mascota_Propietario{" + "idPropietario=" + idPropietario + ", nombrePropietario=" + nombrePropietario + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", id_mascota=" + id_mascota + ", nombreMascota=" + nombreMascota + ", raza=" + raza + ", sexo=" + sexo + ", a\u00f1oNacimiento=" + añoNacimiento + '}';
//    }

    public Object[] toArray() {
        return new Object[]{idPropietario, nombrePropietario, apellidoPaterno, apellidoMaterno, nombreMascota, raza, sexo, añoNacimiento, id_mascota};
    }

}
