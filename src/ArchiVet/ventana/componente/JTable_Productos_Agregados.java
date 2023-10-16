package ArchiVet.ventana.componente;

import ArchiVet.Admin.AdminDesparacitante;
import ArchiVet.Admin.AdminMedicamento;
import ArchiVet.Admin.AdminVacuna;
import Archivet.Controlador.Filtraciones;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class JTable_Productos_Agregados {

    private static int Pieza;
    private final static String[] TITULOS = {"DESCRIPCION", "LOTE", "PRECIO UNITARIO", "CADUCIDAD", "PIEZAS", "BORRAR", ""};

    private static Object[] Compra = new Object[9];
    private static final DefaultTableModel model = new DefaultTableModel(null, TITULOS) {

        Class[] types = new Class[]{
            java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };

    public void tablaGeneralProductos(JTable tabla, int seleccion, int columna, int fila, JTable tablaProductos, String opcion) throws SQLException {
        int[] columnWidths = {640, 460, 190, 245, 115, 65, 0};
        tablaProductos.setDefaultRenderer(Object.class, new Render_Button_JTable());

        ImageIcon icono;

        JButton btn = new JButton("");
        icono = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/borrar1.png"));
        btn.setIcon(icono);
        btn.setBounds(0, 0, 50, 35);
        btn.setName("E");

        tablaProductos.setModel(model);
        TableColumnModel columnModel = tablaProductos.getColumnModel();

        // Configurar el ancho preferido para cada columna en función del arreglo
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        if (fila < tabla.getRowCount() && fila >= 0 && columna < tabla.getColumnCount() && columna >= 0) {
            Object value = tabla.getValueAt(fila, columna);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equalsIgnoreCase("AGREGAR")) {
                    int stock = Integer.parseInt(String.valueOf(tabla.getValueAt(seleccion, 2)));

                    if (stock == 0) {
                        JOptionPane.showMessageDialog(null, "Ya no exiten piezas en existencia, recuerde surtir mas");
                    } else {
                        do {
                            try {

                                if (stock <= 10) {
                                    JOptionPane.showMessageDialog(null, "Quedan solamente " + stock + " piezas en existencia, recuerde surtir mas");
                                }
                                JOptionPane.showMessageDialog(null, "Recuerda que solo hay " + stock + " piezas");
                                Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));

                                if (Pieza < 0) {
                                    JOptionPane.showMessageDialog(null, "Error, no puedes ingresar numeros negativos", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error, Solo puedes ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } while (stock < Pieza || Pieza <= 0 || stock == 0);

                        Compra[0] = String.valueOf(tabla.getValueAt(seleccion, 0)); //DESCRIPCION
                        Compra[1] = String.valueOf(tabla.getValueAt(seleccion, 1)); //LOTE
                        Compra[2] = String.valueOf(tabla.getValueAt(seleccion, 3)); //CADUCIDAD
                        Compra[3] = String.valueOf(tabla.getValueAt(seleccion, 4)); //PRECIO UNITARIO
                        Compra[4] = Pieza;
                        Compra[5] = btn;
                        Compra[6] = stock;

                        JOptionPane.showMessageDialog(null, "Productos Agregados");

                        int filaExistente = -1;
                        int ultimoValor = 0;

                        // Buscar la fila correspondiente en Tabla_PRODUCTOS_ADD
                        for (int i = 0; i < tablaProductos.getRowCount(); i++) {
                            String descripcion = String.valueOf(tablaProductos.getValueAt(i, 0));
                            String lote = String.valueOf(tablaProductos.getValueAt(i, 1));
                            if (descripcion.equals(Compra[0]) && lote.equals(Compra[1])) {
                                filaExistente = i;
                                ultimoValor = Integer.parseInt(String.valueOf(tablaProductos.getValueAt(i, 4))); // Obtener el último valor de "PIEZAS"
                                break;
                            }
                        }

                        if (filaExistente != -1) {
                            // Sumar el valor de Compra[4] al último valor de "PIEZAS" y actualizarlo en la fila existente
                            int nuevoValor = Integer.parseInt(Compra[4].toString());
                            int NN = nuevoValor + ultimoValor;
                            tablaProductos.setValueAt(NN, filaExistente, 4); // Actualizar el valor de "PIEZAS"
                            // Actualizar otros valores si es necesario
                        } else {
                            // Agregar una nueva fila si no existe una fila correspondiente
                            model.addRow(Compra);
                        }

                        try {
                            switch (opcion) {
                                case "Vacunas":
                                    Filtraciones.UPDATE_VACUNAS((stock - Pieza), Compra[1].toString());
                                    AdminVacuna adminVacuna = new AdminVacuna();
                                    adminVacuna.obtenerModeloTablaVacunas(tabla, "Productos");
                                    break;
                                case "Desparacitante":
                                    Filtraciones.UPDATE_DESPARACITANTES((stock - Pieza), Compra[1].toString());
                                    AdminDesparacitante adminDesparacitante = new AdminDesparacitante();
                                    adminDesparacitante.obtenerModeloTablaDesparacitantes(tabla, "Productos");
                                    break;
                                case "Medicamento":
                                    Filtraciones.UPDATE_MEDICAMENTOS((stock - Pieza), Compra[1].toString());
                                    AdminMedicamento adminMedicmento = new AdminMedicamento();
                                    adminMedicmento.obtenerModeloTablaMedicamentos(tabla, "Productos");
                                    break;
                            }

                        } catch (IndexOutOfBoundsException e) {
                            System.err.println(e.getMessage());
                        }

                    }
                    tablaProductos.setCellSelectionEnabled(true);

                }
            }

            if (value instanceof JCheckBox) {
                JCheckBox CH = (JCheckBox) value;
                if (CH.isSelected() == true) {
                    CH.setSelected(false);
                }
                if (CH.isSelected() == false) {
                    CH.setSelected(true);
                }
            }
        }
    }
}
