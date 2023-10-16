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
        if (desparacitante == null || desparacitante.length == 0) {
            return new Object[0][0];
        }
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
    
    public Object[][] obtenerDesparacitantesInventarioArray() throws SQLException {
        Desparacitante[] desparacitante = obtenerDesparacitantesInventario();
        if (desparacitante == null || desparacitante.length == 0) {
            return new Object[0][0];
        }
        Object[][] data = new Object[desparacitante.length][];
        for (int i = 0, len = desparacitante.length; i < len; i++) {
            data[i] = desparacitante[i].toArray();
        }
        return data;
    }
    
    public Desparacitante[] obtenerDesparacitantesInventario() throws SQLException {
        return dao.listarDesparacitantesInventario();
    }

    public DefaultTableModel obtenerModeloTablaDesparacitantes(JTable tabla, String opcion) throws SQLException {
        Object[][] data = null;
        String[] columnNames = MySQL_Desparacitante.CAMPOS_TABLA;
        int[] columnWidths = {569, 470, 200, 190, 245, 40};

        switch (opcion) {
            case "Productos":
                data = obtenerDesparacitantesArray();
                break;
            case "Inventario":
                data = obtenerDesparacitantesInventarioArray();
                break;
        }
        
        tabla.setDefaultRenderer(Object.class, new Render_Button_JTable());
        DefaultTableModel modeloTabla;

        if (data != null && data.length > 0) {
            modeloTabla = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } else {
            modeloTabla = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }
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
