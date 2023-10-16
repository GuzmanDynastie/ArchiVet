package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_Vacuna;
import ArchiVet.Modelo.Vacuna;
import ArchiVet.ventana.componente.Render_Button_JTable;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AdminVacuna {

    private MySQL_Vacuna dao;

    public AdminVacuna() {
        dao = new MySQL_Vacuna();
    }

    public boolean insertarVacuna(Vacuna vacuna) {
        return dao.insertarVacuna(vacuna);
    }

    public Object[][] obtenerVacunasArray() throws SQLException {
        Vacuna[] vacuna = obtenerVacunas();
        if (vacuna == null || vacuna.length == 0) {
            return new Object[0][0];
        }
        int numColumns = vacuna[0].toArray().length + 1; // Agregar una columna para el botón
        Object[][] data = new Object[vacuna.length][numColumns];

        for (int i = 0; i < vacuna.length; i++) {
            Object[] rowData = vacuna[i].toArray();

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

    public Vacuna[] obtenerVacunas() throws SQLException {
        return dao.listarVacunas();
    }

    public Object[][] obtenerVacunasInventarioArray() throws SQLException {
        Vacuna[] vacuna = obtenerVacunasInventarios();
        if (vacuna == null || vacuna.length == 0) {
            return new Object[0][0];
        }
        Object[][] data = new Object[vacuna.length][];
        for (int i = 0, len = vacuna.length; i < len; i++) {
            data[i] = vacuna[i].toArray();
        }
            return data;
    }

    public Vacuna[] obtenerVacunasInventarios() throws SQLException {
        return dao.listarVacunasInventario();
    }

    public DefaultTableModel obtenerModeloTablaVacunas(JTable tabla, String opcion) throws SQLException {
        Object[][] data = null;
        String[] columnNames = MySQL_Vacuna.CAMPOS_TABLA;
        int[] columnWidths = {569, 470, 200, 190, 245, 40};

        switch (opcion) {
            case "Productos":
                data = obtenerVacunasArray();
                break;
            case "Inventario":
                data = obtenerVacunasInventarioArray();
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
