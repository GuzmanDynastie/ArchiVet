package ArchiVet.Modelo;

public class Medico extends SuperClass {
    
    private int id;
    private String telefono;
    private String usuario;
    private String contrasenia;
    private String cargo;
    private String cedula;
    private int estado;

    public Medico(String telefono, String usuario, String contrasenia, String cargo, String cedula, String nombre, String apellidoP, String celular, String email, String direccion, String CP) {
        super(nombre, apellidoP, celular, email, direccion, CP);
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
        this.cedula = cedula;
    }

    public Medico(int id, String telefono, String usuario, String contrasenia, String cargo, String cedula, String nombre, String apellidoP, String celular, String email, String direccion, String CP) {
        super(nombre, apellidoP, celular, email, direccion, CP);
        this.id = id;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
        this.cedula = cedula;
    }
    
    public Medico(int id, String telefono, String usuario, String contrasenia, String cargo, String cedula, String nombre, String apellidoP, String celular, String email, String direccion, String CP, int estado) {
        super(nombre, apellidoP, celular, email, direccion, CP);
        this.id = id;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
        this.cedula = cedula;
        this.estado = estado;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

    
    @Override
    public Object[] toArray() {
        Object[] superClassArray = super.toArrayMedico(); // Este array contiene 3 valores
        Object[] combinedArray = new Object[superClassArray.length + 2];

        // Agrega el valor de id_propietario al principio del arreglo combinado
        combinedArray[0] = id;
        combinedArray[4] = cargo;

        // Copia los valores de la superclase al resto del arreglo combinado
        System.arraycopy(superClassArray, 0, combinedArray, 1, superClassArray.length);

        return combinedArray;
    }

}
