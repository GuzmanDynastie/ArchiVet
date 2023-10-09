package ArchiVet.Modelo;

public class Citas {

    private String horaCita;
    private String fechaCita;
    private String estadoCita;
    private String servicioCita;
    private String detalleCita;
    private String observacionesCita;
    private String especieMascota;
    private String nombreMascota;
    private String sexoMascota;
    private String razaMascota;
    private String colorMascota;
    private String fechaNaciminetoMas;
    private String nombrePropietario;
    private String apellidosPropietario;
    private String telefonoPropietario;
    private String correoPropietario;
    private String domicilioPropietario;
    private int codigoPostal;
    private int numeroSocio;
    private int id;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Citas(String horaCita, String fechaCita, String estadoCita, String servicioCita, String detalleCita, String observacionesCita, String especieMascota, String nombreMascota, String sexoMascota, String razaMascota, String colorMascota, String fechaNaciminetoMas, String nombrePropietario, String apellidosPropietario, String telefonoPropietario, String correoPropietario, String domicilioPropietario, int codigoPostal, int numeroSocio) {
        this.horaCita = horaCita;
        this.fechaCita = fechaCita;
        this.estadoCita = estadoCita;
        this.servicioCita = servicioCita;
        this.detalleCita = detalleCita;
        this.observacionesCita = observacionesCita;
        this.especieMascota = especieMascota;
        this.nombreMascota = nombreMascota;
        this.sexoMascota = sexoMascota;
        this.razaMascota = razaMascota;
        this.colorMascota = colorMascota;
        this.fechaNaciminetoMas = fechaNaciminetoMas;
        this.nombrePropietario = nombrePropietario;
        this.apellidosPropietario = apellidosPropietario;
        this.telefonoPropietario = telefonoPropietario;
        this.correoPropietario = correoPropietario;
        this.domicilioPropietario = domicilioPropietario;
        this.codigoPostal = codigoPostal;
        this.numeroSocio = numeroSocio;
    }

    public Citas(String horaCita, String fechaCita, String estadoCita, String servicioCita, String especieMascota, String nombreMascota, String sexoMascota, String razaMascota, String colorMascota, String fechaNaciminetoMas, String nombrePropietario, String apellidosPropietario, String telefonoPropietario, String correoPropietario, int numeroSocio, String detalleCita, String observacionesCita, int id) {
        this.horaCita = horaCita;
        this.fechaCita = fechaCita;
        this.estadoCita = estadoCita;
        this.servicioCita = servicioCita;
        this.especieMascota = especieMascota;
        this.nombreMascota = nombreMascota;
        this.sexoMascota = sexoMascota;
        this.razaMascota = razaMascota;
        this.colorMascota = colorMascota;
        this.fechaNaciminetoMas = fechaNaciminetoMas;
        this.nombrePropietario = nombrePropietario + " " + apellidosPropietario;
        this.telefonoPropietario = telefonoPropietario;
        this.correoPropietario = correoPropietario;
        this.numeroSocio = numeroSocio;
        this.detalleCita = detalleCita + "\n\n" + observacionesCita;
        this.id = id;
    }
    
    public Citas(String horaCita, String fechaCita, String estadoCita, String servicioCita, String detalleCita, String observacionesCita, int id) {
        this.horaCita = horaCita;
        this.fechaCita = fechaCita;
        this.estadoCita = estadoCita;
        this.servicioCita = servicioCita;
        this.detalleCita = detalleCita;
        this.observacionesCita = observacionesCita;
        this.id = id;
    }
    
    public Citas(String nombreMascota, String especieMascota, String razaMascota, String colorMascota, String sexoMascota, String fechaNaciminetoMas, String nombrePropietario, String apellidoPaterno, String apellidoMaterno, String telefonoPropietario, String correoPropietario, String domicilioPropietario, int codigoPostal, int id) {
        this.nombreMascota = nombreMascota;
        this.sexoMascota = sexoMascota;
        this.especieMascota = especieMascota;
        this.razaMascota = razaMascota;
        this.colorMascota = colorMascota;
        this.sexoMascota = sexoMascota;
        this.fechaNaciminetoMas = fechaNaciminetoMas;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefonoPropietario = telefonoPropietario;
        this.correoPropietario = correoPropietario;
        this.domicilioPropietario = domicilioPropietario;
        this.codigoPostal = codigoPostal;
        this.id = id;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getServicioCita() {
        return servicioCita;
    }

    public void setServicioCita(String servicioCita) {
        this.servicioCita = servicioCita;
    }

    public String getDetalleCita() {
        return detalleCita;
    }

    public void setDetalleCita(String detalleCita) {
        this.detalleCita = detalleCita;
    }

    public String getObservacionesCita() {
        return observacionesCita;
    }

    public void setObservacionesCita(String observacionesCita) {
        this.observacionesCita = observacionesCita;
    }

    public String getEspecieMascota() {
        return especieMascota;
    }

    public void setEspecieMascota(String especieMascota) {
        this.especieMascota = especieMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getSexoMascota() {
        return sexoMascota;
    }

    public void setSexoMascota(String sexoMascota) {
        this.sexoMascota = sexoMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }

    public String getFechaNaciminetoMas() {
        return fechaNaciminetoMas;
    }

    public void setFechaNaciminetoMas(String fechaNaciminetoMas) {
        this.fechaNaciminetoMas = fechaNaciminetoMas;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidosPropietario() {
        return apellidosPropietario;
    }

    public void setApellidosPropietario(String apellidosPropietario) {
        this.apellidosPropietario = apellidosPropietario;
    }

    public String getTelefonoPropietario() {
        return telefonoPropietario;
    }

    public void setTelefonoPropietario(String telefonoPropietario) {
        this.telefonoPropietario = telefonoPropietario;
    }

    public String getCorreoPropietario() {
        return correoPropietario;
    }

    public void setCorreoPropietario(String correoPropietario) {
        this.correoPropietario = correoPropietario;
    }

    public String getDomicilioPropietario() {
        return domicilioPropietario;
    }

    public void setDomicilioPropietario(String domicilioPropietario) {
        this.domicilioPropietario = domicilioPropietario;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Citas{" + "horaCita=" + horaCita + ", fechaCita=" + fechaCita + ", estadoCita=" + estadoCita + ", servicioCita=" + servicioCita + ", detalleCita=" + detalleCita + ", observacionesCita=" + observacionesCita + ", especieMascota=" + especieMascota + ", nombreMascota=" + nombreMascota + ", sexoMascota=" + sexoMascota + ", razaMascota=" + razaMascota + ", colorMascota=" + colorMascota + ", fechaNaciminetoMas=" + fechaNaciminetoMas + ", nombrePropietario=" + nombrePropietario + ", apellidosPropietario=" + apellidosPropietario + ", telefonoPropietario=" + telefonoPropietario + ", correoPropietario=" + correoPropietario + ", domicilioPropietario=" + domicilioPropietario + ", codigoPostal=" + codigoPostal + ", numeroSocio=" + numeroSocio + ", id=" + id + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + '}';
    }

    public Object[] toArray() {
        return new Object[]{horaCita, fechaCita, estadoCita, servicioCita, especieMascota, nombreMascota, sexoMascota, razaMascota, colorMascota, fechaNaciminetoMas, nombrePropietario, telefonoPropietario, correoPropietario, numeroSocio, detalleCita, id};
    }
    
    public Object[] toArray2() {
        return new Object[]{nombreMascota, sexoMascota, especieMascota, razaMascota, colorMascota, fechaNaciminetoMas, nombrePropietario, apellidoPaterno, apellidoMaterno, telefonoPropietario, correoPropietario, domicilioPropietario, codigoPostal, id};
    }

}
