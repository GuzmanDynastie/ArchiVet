package ArchiVet.Administrador;

import ArchiVet.DAO.MySQL.MySQL_Medico;
import ArchiVet.Modelo.Medico;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AdminMedico {

    private MySQL_Medico dao;

    public AdminMedico() {
        dao = new MySQL_Medico();
    }

    public Medico agregarMedico(String telefono, String usuario, String contrasenia, String cargo, String cedula, String nombre, String apellidoP,
            String celular, String email, String direccion, String CP) {
        try {
            Medico medico = new Medico(telefono, usuario, contrasenia, cargo, cedula, nombre, apellidoP, celular, email, direccion, CP);
            return dao.insertarMedico(medico) ? medico : null;

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Medico consultarMedicoPorID(int ID) {
        try {
            Medico medico = dao.consultarID(ID);

            if (medico != null) {
                return medico;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public Object[][] obtenerMedicosArray() {
        Medico[] medico = obtenerMedicos();
        Object[][] data = new Object[medico.length][];
        for (int i = 0, len = medico.length; i < len; i++) {
            data[i] = medico[i].toArray();
        }
        return data;
    }

    public Medico[] obtenerMedicos() {
        return dao.obtenerDatosMedico();
    }

    public DefaultTableModel obtenerModeloTablaPropietarios(JTable tabla) {
        Object[][] data = obtenerMedicosArray();
        String[] columnNames = MySQL_Medico.CAMPOS_TABLA;
        int[] columnWidths = {50, 210, 200, 130, 100};

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
    
    public boolean actualizarMedico(Medico medico) {
        return dao.actualizarMedico(medico);
    }
    
    public boolean eliminarMedico(Medico medico) {
        return dao.eliminarMedico(medico);
    }

}
