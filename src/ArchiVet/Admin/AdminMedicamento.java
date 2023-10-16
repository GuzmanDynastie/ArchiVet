package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_Medicamento;
import ArchiVet.Modelo.Medicamento;
import ArchiVet.ventana.componente.Render_Button_JTable;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AdminMedicamento {

    private MySQL_Medicamento dao;

    public AdminMedicamento() {
        dao = new MySQL_Medicamento();
    }

    public boolean insertarMedicamento(Medicamento medicamento) {
        return dao.insertarMedicamento(medicamento);
    }

    public Object[][] obtenerMedicamentosArray() throws SQLException {
        Medicamento[] medicamento = obtenerMedicamentos();
        if (medicamento == null || medicamento.length == 0) {
            return new Object[0][0];
        }
        int numColumns = medicamento[0].toArray().length + 1; // Agregar una columna para el botón
        Object[][] data = new Object[medicamento.length][numColumns];

        for (int i = 0; i < medicamento.length; i++) {
            Object[] rowData = medicamento[i].toArray();

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

    public Medicamento[] obtenerMedicamentos() throws SQLException {
        return dao.listarMedicamentos();
    }

    public Object[][] obtenerMedicamentosInventarioArray() throws SQLException {
        Medicamento[] medicamento = obtenerMedicamentosInventario();
        if (medicamento == null || medicamento.length == 0) {
            return new Object[0][0];
        }
        Object[][] data = new Object[medicamento.length][];
        for (int i = 0, len = medicamento.length; i < len; i++) {
            data[i] = medicamento[i].toArray();
        }
        return data;
    }

    public Medicamento[] obtenerMedicamentosInventario() throws SQLException {
        return dao.listarMedicamentosInventario();
    }

    public DefaultTableModel obtenerModeloTablaMedicamentos(JTable tabla, String opcion) throws SQLException {
        Object[][] data = null;
        String[] columnNames = MySQL_Medicamento.CAMPOS_TABLA;
        int[] columnWidths = {569, 470, 200, 190, 245, 40};

        switch (opcion) {
            case "Productos":
                data = obtenerMedicamentosArray();
                break;
            case "Inventario":
                data = obtenerMedicamentosInventarioArray();
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
