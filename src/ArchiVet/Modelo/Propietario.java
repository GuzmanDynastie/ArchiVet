package ArchiVet.Modelo;

public class Propietario extends SuperClass {

    private int id_propietario;

    public Propietario(String nombre, String apellidoP, String apellidoM, String celular, String email, String direccion, String CP) {
        super(nombre, apellidoP, apellidoM, celular, email, direccion, CP);
    }

    public Propietario(int id_propietario, String nombre, String apellidoP, String apellidoM, String celular, String email, String direccion, String CP) {
        super(nombre, apellidoP, apellidoM, celular, email, direccion, CP);
        this.id_propietario = id_propietario;
    }

    public int getID_Propieatario() {
        return id_propietario;
    }

    public void setID_Propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    @Override
    public String toString() {
        return "Propietario{" + "id_propietario=" + id_propietario + '}';
    }

    @Override
    public Object[] toArray() {
        Object[] superClassArray = super.toArray();
        Object[] combinedArray = new Object[superClassArray.length + 1];

        // Agrega el valor de id_propietario al principio del arreglo combinado
        combinedArray[0] = id_propietario;

        // Copia los valores de la superclase al resto del arreglo combinado
        System.arraycopy(superClassArray, 0, combinedArray, 1, superClassArray.length);

        return combinedArray;
    }
}
