package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_Citas;
import ArchiVet.Modelo.Citas;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.SQLException;

public class AdminCitas {

    private MySQL_Citas dao;

    public AdminCitas() {
        dao = new MySQL_Citas();
    }

    public Citas insertarCita(String horaCita, String fechaCita, String estadoCita, String servicioCita, String detalleCita, String observacionesCita, String especieMascota, String nombreMascota, String sexoMascota, String razaMascota, String colorMascota, String fechaNaciminetoMas, String nombrePropietario, String apellidosPropietario, String telefonoPropietario, String correoPropietario, String domicilioPropietario, int codigoPostal, int numeroSocio) {
        Citas cita = new Citas(horaCita, fechaCita, estadoCita, servicioCita, detalleCita, observacionesCita, especieMascota, nombreMascota, sexoMascota, razaMascota, colorMascota, fechaNaciminetoMas, nombrePropietario, apellidosPropietario, telefonoPropietario, correoPropietario, domicilioPropietario, codigoPostal, numeroSocio);
        return dao.incertarCita(cita) ? cita : null;
    }

    public Object[][] obtenerCitasArray() {
        Citas[] citas = obtenerCitas();
        Object[][] data = new Object[citas.length][];
        for (int i = 0, len = citas.length; i < len; i++) {
            data[i] = citas[i].toArray();
        }
        return data;
    }

    public Citas[] obtenerCitas() {
        return dao.listarCitas();
    }
    
    public Object[][] obtenerBuscadorMascotaCitasArray() {
        Citas[] citas = obtenerBuscadorMascotaCitas();
        Object[][] data = new Object[citas.length][];
        for (int i = 0, len = citas.length; i < len; i++) {
            data[i] = citas[i].toArray2();
        }
        return data;
    }

    public Citas[] obtenerBuscadorMascotaCitas() {
        return dao.listarBuscadorMascotaCitas();
    }

    public DefaultTableModel obtenerModeloTablaCitas(JTable tabla, String opcion) {
        Object[][] data = null;
        String[] columnNames = null;
        int[] columnWidths = null;
                
        switch(opcion){
            case "agendarCitas" -> {
                data = obtenerCitasArray();
                columnNames = MySQL_Citas.CAMPOS_TABLA;
                columnWidths = new int[]{150, 150, 150, 200, 100, 150, 120, 150, 150, 120, 350, 200, 350, 70, 0, 0};
            }
            case "buscadorMascota" -> {
                data = obtenerBuscadorMascotaCitasArray();
                columnNames = MySQL_Citas.CAMPOS_TABLA_BUSCADOR;
                columnWidths = new int[]{150, 100, 100, 150, 140, 120, 200, 150, 150, 200, 250, 250, 80, 70};
            }
        }
        DefaultTableModel modeloTabla = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(modeloTabla);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Obtener las columnas de la tabla
        TableColumnModel columnModel = tabla.getColumnModel();

        // Configurar el ancho preferido para cada columna en función del arreglo
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        return modeloTabla;
    }
    
    public Citas consultarCitasPorID(int ID) {
        try {
            Citas citas = dao.consultarID(ID);

            if (citas != null) {
                return citas;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public boolean actualizarCita(Citas citas) {
        return dao.actualizarCita(citas);
    }
}