package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_PropietarioMascota;
import ArchiVet.Modelo.PropietarioMascota;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AdminPropietarioMascota {

    private MySQL_PropietarioMascota dao;
    
    public AdminPropietarioMascota() {
        dao = new MySQL_PropietarioMascota();
    }

    public Object[][] obtenerPropietariosMascotasArray() {
        PropietarioMascota[] propietariosmascotas = obtenerPropietariosMascotas();
        Object[][] data = new Object[propietariosmascotas.length][];
        for (int i = 0, len = propietariosmascotas.length; i < len; i++) {
            data[i] = propietariosmascotas[i].toArray();
        }
        return data;
    }

    public PropietarioMascota[] obtenerPropietariosMascotas() {
        return dao.listarPropietariosMascotas();
    }

    public DefaultTableModel obtenerModeloTablaPropietariosMascotas(JTable tabla) {
        Object[][] data = obtenerPropietariosMascotasArray();
        String[] columnNames = MySQL_PropietarioMascota.CAMPOS_TABLA;
        int[] columnWidths = {100, 300, 200, 200, 200, 200, 200, 150, 0};

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
