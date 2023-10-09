package ArchiVet.Modelo;

import java.util.Date;

public class Vacuna {
    
    private String descripcion;
    private String lote;
    private int cantidad;
    private double precio;
    private Date caducidad;

    public Vacuna(String descripcion, String lote, int cantidad, double precio, Date caducidad) {
        this.descripcion = descripcion;
        this.lote = lote;
        this.cantidad = cantidad;
        this.precio = precio;
        this.caducidad = caducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "descripcion=" + descripcion + ", lote=" + lote + ", cantidad=" + cantidad + ", precio=" + precio + ", caducidad=" + caducidad + '}';
    }
    
    
}
