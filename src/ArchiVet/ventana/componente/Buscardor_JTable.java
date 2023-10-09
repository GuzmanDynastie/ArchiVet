package ArchiVet.ventana.componente;

import javax.swing.table.DefaultTableModel;

public class Buscardor_JTable {
    
    public void buscarEnTabla(DefaultTableModel tabla, Object[][] datos, String textoABuscar, String columnaABuscar) {
    // Limpia la tabla
    DefaultTableModel modelo = (DefaultTableModel) tabla;
    modelo.setRowCount(0);

    if (textoABuscar.trim().isEmpty() || columnaABuscar.trim().isEmpty()) {
        // Si el campo de búsqueda está vacío o no se ha especificado la columna, muestra todas las filas
        for (Object[] fila : datos) {
            modelo.addRow(fila);
        }
    } else {
        // Encuentra el índice de la columna a buscar por su nombre (ignorando mayúsculas y minúsculas)
        int columnaABuscarIndex = -1;
        String columnaABuscarLowerCase = columnaABuscar.toLowerCase();
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            if (tabla.getColumnName(i).toLowerCase().equals(columnaABuscarLowerCase)) {
                columnaABuscarIndex = i;
                break;
            }
        }

        if (columnaABuscarIndex != -1) {
            // Filtrar las filas que coincidan con el texto de búsqueda en la columna especificada
            for (Object[] fila : datos) {
                Object valor = fila[columnaABuscarIndex];
                if (valor.toString().toLowerCase().contains(textoABuscar.toLowerCase())) {
                    modelo.addRow(fila);
                }
            }
        } else {
            // Maneja el caso en el que la columna no se encuentra
            System.out.println("La columna especificada no existe en la tabla.");
        }
    }
}
}
