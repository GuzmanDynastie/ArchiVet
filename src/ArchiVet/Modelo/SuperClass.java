package ArchiVet.Modelo;

public class SuperClass {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String celular;
    private String email;
    private String direccion;
    private String CP;

    public SuperClass(String nombre, String apellidoP, String celular, String email, String direccion, String CP) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
        this.CP = CP;
    }

    public SuperClass(String nombre, String apellidoP, String apellidoM, String celular, String email, String direccion, String CP) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
        this.CP = CP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    @Override
    public String toString() {
        return "SuperClass{" + "nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", celular=" + celular + ", email=" + email + ", direccion=" + direccion + ", CP=" + CP + '}';
    }

    public Object[] toArray() {
        return new Object[]{nombre, apellidoP, apellidoM, celular, email, direccion, CP};
    }
    
    public Object[] toArrayMedico() {
        return new Object[]{nombre, apellidoP, celular};
    }
}
