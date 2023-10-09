package ArchiVet.Administrador;

import ArchiVet.DAO.MySQL.MySQL_Propietario;
import ArchiVet.Modelo.Propietario;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AdminPropietario {

    private MySQL_Propietario dao;

    public AdminPropietario() {
        dao = new MySQL_Propietario();
    }

    public Propietario agregarPropietario(String nombre, String apellidoP, String apellidoM, String celular, String email, String direccion, String CP) {
        try {
            Propietario propietario = new Propietario(nombre, apellidoP, apellidoM, celular, email, direccion, CP);
            return dao.insertarPropietario(propietario) ? propietario : null;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public int obtenerUltimoID() {
        try {
            return dao.obtenerUltimoID();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public Object[][] obtenerPropietariosArray() {
        Propietario[] propietario = obtenerPropieatios();
        Object[][] data = new Object[propietario.length][];
        for (int i = 0, len = propietario.length; i < len; i++) {
            data[i] = propietario[i].toArray();
        }
        return data;
    }

    public Propietario[] obtenerPropieatios() {
        return dao.obtenerTodoPropietario();
    }

    public DefaultTableModel obtenerModeloTablaPropietarios(JTable tabla) {
        Object[][] data = obtenerPropietariosArray();
        String[] columnNames = MySQL_Propietario.CAMPOS_TABLA;
        int[] columnWidths = {100, 300, 230, 230, 200, 400, 400, 150};

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
}
