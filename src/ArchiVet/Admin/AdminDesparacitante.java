package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_Desparacitante;
import ArchiVet.Modelo.Desparacitante;
import ArchiVet.ventana.componente.Render_Button_JTable;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AdminDesparacitante {
    
    private MySQL_Desparacitante dao;
    
    public AdminDesparacitante() {
        dao = new MySQL_Desparacitante();
    }
    
    public boolean insertarDesparacitante(Desparacitante desparacitante) {
        return dao.insertarDesparacitante(desparacitante);
    }

    public Object[][] obtenerDesparacitantesArray() throws SQLException {
        Desparacitante[] desparacitante = obtenerDesparacitantes();
        int numColumns = desparacitante[0].toArray().length + 1; // Agregar una columna para el botón
        Object[][] data = new Object[desparacitante.length][numColumns];

        for (int i = 0; i < desparacitante.length; i++) {
            Object[] rowData = desparacitante[i].toArray();
            
            // Copiar los datos de la vacuna a las primeras columnas
            System.arraycopy(rowData, 0, data[i], 0, rowData.length);
            
            // Agregar el botón en la última columna
            JButton btn = new JButton("");
            ImageIcon icono = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/mas.png"));
            btn.setIcon(icono);
            btn.setBounds(0, 0, 50, 35);
            btn.setName("AGREGAR");
            data[i][numColumns - 1] = btn;
        }
        return data;
    }

    public Desparacitante[] obtenerDesparacitantes() throws SQLException {
        return dao.listarDesparacitantes();
    }

    public DefaultTableModel obtenerModeloTablaDesparacitantes(JTable tabla) throws SQLException {
        Object[][] data = obtenerDesparacitantesArray();
        String[] columnNames = MySQL_Desparacitante.CAMPOS_TABLA;
        int[] columnWidths = {569, 470, 200, 190, 245, 40};

        tabla.setDefaultRenderer(Object.class, new Render_Button_JTable());
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
