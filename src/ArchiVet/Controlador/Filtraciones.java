package Archivet.Controlador;

import ArchiVet.DAO.DAO;
import ArchiVet.ventana.componente.Render_Button_JTable;
import static ArchiVet.ventana.ventana_pagarCaja.ID_DELETE_HISTORIAL;
import static ArchiVet.ventana.ventana_mostradorCaja.Contador_Servicio;
import static ArchiVet.ventana.ventana_consultaEntreFechas.Tabla_Consulta_Fechas;
import static ArchiVet.ventana.ventana_mostradorCaja.Tabla_Historial;
import java.awt.Color;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static ArchiVet.ventana.ventana_mostradorCaja.sexoMascota;
import static ArchiVet.ventana.ventana_mostradorCaja.Tabla_Venta_Extras;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Filtraciones extends DAO {

    static String SQL;

/////////////////////////////////////-----------------------------------------------------------------------------------------------    
    //Carga los datos de la mascota atendida
    public static void cargarGastos_Mascota(int NUMERO_SOCIO, int MASCOTA, JTextArea Area) throws SQLException {

        try {
            String[] datosUsuario = new String[4];
            String[] Descripcion = new String[1];

            int contadorServicios = 1;
            String[] Titulos = {"NOMBRE MASCOTA", "SEXO", "SERVICIO", "PRECIO"};
            DefaultTableModel model = new DefaultTableModel(null, Titulos);

            SQL = "SELECT NOMBRE_MASCOTA, SEXO, SERVICIO, PRECIO, ID FROM historial WHERE " + NUMERO_SOCIO + " = ID_PROPIETARIO AND " + MASCOTA + " = ID_MASCOTA";

            ResultSet rs = connection.executeQuery(SQL);

            Tabla_Venta_Extras.setModel(model);

            Tabla_Venta_Extras.getColumn("NOMBRE MASCOTA").setPreferredWidth(150);
            Tabla_Venta_Extras.getColumn("SEXO").setPreferredWidth(100);
            Tabla_Venta_Extras.getColumn("SERVICIO").setPreferredWidth(250);
            Tabla_Venta_Extras.getColumn("PRECIO").setPreferredWidth(100);

            for (int i = 0; i < Tabla_Venta_Extras.getColumnCount(); i++) {
                Class<?> columnClass = Tabla_Venta_Extras.getColumnClass(i);
                Tabla_Venta_Extras.setDefaultEditor(columnClass, null);
            }

            while (rs.next()) {

                ID_DELETE_HISTORIAL = Integer.parseInt(rs.getString(5));
                datosUsuario[0] = rs.getString(1);
                datosUsuario[1] = rs.getString(2);
                datosUsuario[2] = rs.getString(3);
                datosUsuario[3] = rs.getString(4);
                //datosUsuario[3] = rs.getString(4);
                //Descripcion[0] = rs.getString(4);

                model.addRow(datosUsuario);

                for (String Des : Descripcion) {
                    Area.append("Servicio " + contadorServicios++ + "-.      " + rs.getString(3) + "\n");
                    sexoMascota = rs.getString(2);
                }
            }
        } catch (SQLException e) {

        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Carga la suma total de la mascota atendida
    public static void cargarSuma_Total(int NUMERO_SOCIO, int MASCOTA, JTextField Field, JTextField Signo) {

        try {
            String[] Suma = new String[1];

            SQL = "SELECT sum(PRECIO) FROM historial WHERE " + NUMERO_SOCIO + " = ID_PROPIETARIO AND " + MASCOTA + " = ID_MASCOTA";

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {
                Suma[0] = rs.getString(1);

                for (String sum : Suma) {
                    if (rs.getString(1) == null) {
                        Field.setText("0.00");
                        Field.setForeground(Color.green);
                        Signo.setForeground(Color.green);
                        Signo.setText("$");

                    } else {
                        Field.setText(sum);
                        Field.setForeground(Color.red);
                        Signo.setForeground(Color.red);
                        Signo.setText("$");
                    }
                }
            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////-----------------------------------------------------------------------------------------------
    //Carga el nombre de la mascota atendida y su cargo total
    public static void cargarNombre_Mascota(int NUMERO_SOCIO, int ID_MASCOTA, JTextField Mascota, JTextField Total) {

        try {
            String[] PET = new String[1];
            String[] Suma = new String[1];

            SQL = "SELECT NOMBRE_MASCOTA, sum(PRECIO) FROM historial WHERE " + NUMERO_SOCIO + " = ID_PROPIETARIO AND " + ID_MASCOTA + " = ID_MASCOTA";

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {
                PET[0] = rs.getString(1);
                Suma[0] = rs.getString(2);

                for (String pet : PET) {
                    Mascota.setText(pet);
                }

                for (String total : Suma) {
                    Total.setText(total);
                }
            }

        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Carga la descripcion completa de la mascota atendida para la ventana Ventana_pagarCaja
    public static void cargarDescripcion_Pagos(int NUMERO_SOCIO, int MASCOTA, JTextArea DES) {

        try {
            String[] Descripcion = new String[1];
            String[] Precio = new String[1];

            int contadorServicio = 1;
            SQL = "SELECT SERVICIO, PRECIO FROM historial WHERE " + NUMERO_SOCIO + " = ID_PROPIETARIO AND " + MASCOTA + " = ID_MASCOTA";

            ResultSet rs = connection.executeQuery(SQL);
            while (rs.next()) {
                Descripcion[0] = rs.getString(1);
                Precio[0] = rs.getString(2);

                for (String des : Descripcion) {
                    for (String pre : Precio) {
                        String Formato = String.format("%10s %10s", "Servicio " + contadorServicio++, "    |    $" + pre + "      |      " + des);
                        Contador_Servicio = contadorServicio++;
                        //DES.append("Servicio "+contadorServicio++ +"        $"+pre+"    x    "+des+"\n");
                        DES.append(Formato + "\n");
                    }
                }
            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////-----------------------------------------------------------------------------------------------
    //Inserta los datos de la venta
    public static void insertDatos_Historial(int Folio, String Mascota, String Sexo, String Nombre_Propietario, String Descripcion, String Fecha, Float Cargo, Float Pago, Float Cambio, int ID_Propietario, int ID_PET) {

        try {
            SQL = "INSERT INTO historia_ventas(Folio, Nombre_Mascota, Sexo_Mascota, Nombre_Propietario, Descripcion, Fecha_Venta, Cargo, Pago, Cambio, ID_Propietario, ID_MASCOTA) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement PST = connection.prepare(SQL);

            PST.setInt(1, Folio);
            PST.setString(2, Mascota);
            PST.setString(3, Sexo);
            PST.setString(4, Nombre_Propietario);
            PST.setString(5, Descripcion);
            PST.setString(6, Fecha);
            PST.setFloat(7, Cargo);
            PST.setFloat(8, Pago);
            PST.setFloat(9, Cambio);
            PST.setInt(10, ID_Propietario);
            PST.setInt(11, ID_PET);

            PST.executeUpdate();

        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Obtiene el ultimo folio registrado
    public static void ObtenerFolio(JTextField Folio) {
        try {

            SQL = "SELECT max(Folio) FROM historia_ventas";

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {
                if (rs.getString(1) == null) {
                    Folio.setText("0");
                } else if (Integer.parseInt(rs.getString(1)) >= 1) {
                    Folio.setText(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Carga los datos del Historial y da la opcion para generar el PDF
    public static void cargarHistorial_Ventas(int NUMERO_SOCIO, int MASCOTA, JTable Tabla) {

        try {
            String[] datosUsuario = new String[9];
            String[] Titulos = {"FOLIO", "MASCOTA", "SEXO", "PROPIETARIO", "DESCRIPCION", "FECHA VENTA", "CARGO", "PAGO", "CAMBIO"};

            DefaultTableModel model = new DefaultTableModel(null, Titulos);

            SQL = "SELECT Folio, Nombre_Mascota, Sexo_Mascota, Nombre_Propietario, Descripcion, Fecha_Venta, Cargo, Pago, Cambio FROM historia_ventas WHERE " + NUMERO_SOCIO + " = ID_Propietario AND " + MASCOTA + " = ID_MASCOTA";

            ResultSet rs = connection.executeQuery(SQL);

            Tabla.setModel(model);
            Tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            Tabla.getColumn("FOLIO").setPreferredWidth(100);
            Tabla.getColumn("MASCOTA").setPreferredWidth(200);
            Tabla.getColumn("SEXO").setPreferredWidth(150);
            Tabla.getColumn("PROPIETARIO").setPreferredWidth(400);
            Tabla.getColumn("DESCRIPCION").setPreferredWidth(450);
            Tabla.getColumn("FECHA VENTA").setPreferredWidth(250);
            Tabla.getColumn("CARGO").setPreferredWidth(130);
            Tabla.getColumn("PAGO").setPreferredWidth(130);
            Tabla.getColumn("CAMBIO").setPreferredWidth(130);

            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Class<?> columnClass = Tabla.getColumnClass(i);
                Tabla.setDefaultEditor(columnClass, null);
            }

            while (rs.next()) {

                if (Integer.parseInt(rs.getString(1)) < 10) {
                    datosUsuario[0] = "0000" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 9 && Integer.parseInt(rs.getString(1)) < 100) {
                    datosUsuario[0] = "000" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 99 && Integer.parseInt(rs.getString(1)) < 1000) {
                    datosUsuario[0] = "00" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 999 && Integer.parseInt(rs.getString(1)) < 10000) {
                    datosUsuario[0] = "0" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 9999) {
                    datosUsuario[0] = "" + rs.getString(1);
                }

                datosUsuario[1] = rs.getString(2);
                datosUsuario[2] = rs.getString(3);
                datosUsuario[3] = rs.getString(4);
                datosUsuario[4] = rs.getString(5);
                datosUsuario[5] = rs.getString(6);
                datosUsuario[6] = rs.getString(7);
                datosUsuario[7] = rs.getString(8);
                datosUsuario[8] = rs.getString(9);

                model.addRow(datosUsuario);

            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Busca datos por Nombrer de la Mascota y Fecha
    public static void BusquedaMascota_Fecha(String Mascota, String Fecha) {

        try {
            String[] datosUsuario = new String[9];
            String[] Titulos = {"FOLIO", "MASCOTA", "SEXO", "PROPIETARIO", "DESCRIPCION", "FECHA VENTA", "CARGO", "PAGO", "CAMBIO"};

            DefaultTableModel model = new DefaultTableModel(null, Titulos);

            SQL = "SELECT Folio, Nombre_Mascota, Sexo_Mascota, Nombre_Propietario, Descripcion, Fecha_Venta, Cargo, Pago, Cambio FROM historia_ventas WHERE Nombre_Mascota LIKE '%" + Mascota + "%' AND Fecha_Venta LIKE '%" + Fecha + "%'";

            ResultSet rs = connection.executeQuery(SQL);

            Tabla_Historial.setModel(model);

            Tabla_Historial.getColumn("FOLIO").setPreferredWidth(100);
            Tabla_Historial.getColumn("MASCOTA").setPreferredWidth(200);
            Tabla_Historial.getColumn("SEXO").setPreferredWidth(150);
            Tabla_Historial.getColumn("PROPIETARIO").setPreferredWidth(400);
            Tabla_Historial.getColumn("DESCRIPCION").setPreferredWidth(450);
            Tabla_Historial.getColumn("FECHA VENTA").setPreferredWidth(250);
            Tabla_Historial.getColumn("CARGO").setPreferredWidth(130);
            Tabla_Historial.getColumn("PAGO").setPreferredWidth(130);
            Tabla_Historial.getColumn("CAMBIO").setPreferredWidth(130);

            for (int i = 0; i < Tabla_Historial.getColumnCount(); i++) {
                Class<?> columnClass = Tabla_Historial.getColumnClass(i);
                Tabla_Historial.setDefaultEditor(columnClass, null);
            }

            while (rs.next()) {

                if (Integer.parseInt(rs.getString(1)) < 10) {
                    datosUsuario[0] = "0000" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 9 && Integer.parseInt(rs.getString(1)) < 100) {
                    datosUsuario[0] = "000" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 99 && Integer.parseInt(rs.getString(1)) < 1000) {
                    datosUsuario[0] = "00" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 999 && Integer.parseInt(rs.getString(1)) < 10000) {
                    datosUsuario[0] = "0" + rs.getString(1);
                } else if (Integer.parseInt(rs.getString(1)) > 9999) {
                    datosUsuario[0] = "" + rs.getString(1);
                }

                datosUsuario[1] = rs.getString(2);
                datosUsuario[2] = rs.getString(3);
                datosUsuario[3] = rs.getString(4);
                datosUsuario[4] = rs.getString(5);
                datosUsuario[5] = rs.getString(6);
                datosUsuario[6] = rs.getString(7);
                datosUsuario[7] = rs.getString(8);
                datosUsuario[8] = rs.getString(9);

                model.addRow(datosUsuario);
                Tabla_Historial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Busca datos de la tabla mascota y propietadrio    
    public void Inventario_Vacunas(String Opcion, JTable Tabla) {

        try {
            Object[] datosUsuario = new Object[7];
            String[] Titulos = {"DESCRIPCION", "LOTE", "STOCK", "PRECIO UNITARIO", "CADUCIDAD", ""};

            Tabla.setDefaultRenderer(Object.class, new Render_Button_JTable());
            DefaultTableModel model = new DefaultTableModel(null, Titulos) {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }

            };

            JButton btn = new JButton("");
            ImageIcon icono = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/mas.png"));
            btn.setIcon(icono);
            btn.setBounds(0, 0, 50, 35);
            btn.setName("AGREGAR");

            Tabla.setModel(model);
            Tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            Tabla.getColumn("DESCRIPCION").setPreferredWidth(569);
            Tabla.getColumn("LOTE").setPreferredWidth(470);
            Tabla.getColumn("STOCK").setPreferredWidth(200);
            Tabla.getColumn("PRECIO UNITARIO").setPreferredWidth(190);
            Tabla.getColumn("CADUCIDAD").setPreferredWidth(245);
            Tabla.getColumn("").setPreferredWidth(40);

            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Class<?> columnClass = Tabla.getColumnClass(i);
                Tabla.setDefaultEditor(columnClass, null);
            }
            switch (Opcion) {
                case "A":
                    SQL = "SELECT * FROM vacunas";
                    System.out.println("Imprimiendo Vacunas");
                    break;
                case "B":
                    SQL = "SELECT * FROM desparacitantes";
                    System.out.println("Imprimiendo Desparacitantes");
                    break;
                case "C":
                    SQL = "SELECT * FROM medicamentos";
                    System.out.println("Imprimiendo Medicamentos");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {

                datosUsuario[0] = rs.getString(1);
                datosUsuario[1] = rs.getString(2);
                datosUsuario[2] = rs.getString(3);
                datosUsuario[3] = rs.getString(4);
                datosUsuario[4] = rs.getString(5);
                datosUsuario[5] = btn;

                model.addRow(datosUsuario);

            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Busca citas comparando Servicio y Fecha   
    public static void Filtro_Fechas_Fechas() {

        try {
            String[] datosUsuario = new String[16];

            String[] Titulos = {"HORA CITA", "FECHA CITA", "ESTADO", "SERVICIO", "ESPECIE", "MASCOTA", "SEXO", "RAZA", "COLOR", "AÑO NAC.", "PROPIETARIO", "TELEFONO", "CORREO", "N° SOCIO", "", "ID"};

            DefaultTableModel model = new DefaultTableModel(null, Titulos);

            SQL = "SELECT * FROM citas";

            ResultSet rs = connection.executeQuery(SQL);

            Tabla_Consulta_Fechas.setModel(model);
            Tabla_Consulta_Fechas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            Tabla_Consulta_Fechas.getColumn("HORA CITA").setPreferredWidth(150);
            Tabla_Consulta_Fechas.getColumn("FECHA CITA").setPreferredWidth(150);
            Tabla_Consulta_Fechas.getColumn("ESTADO").setPreferredWidth(100);
            Tabla_Consulta_Fechas.getColumn("SERVICIO").setPreferredWidth(200);
            Tabla_Consulta_Fechas.getColumn("ESPECIE").setPreferredWidth(100);
            Tabla_Consulta_Fechas.getColumn("MASCOTA").setPreferredWidth(200);
            Tabla_Consulta_Fechas.getColumn("SEXO").setPreferredWidth(120);
            Tabla_Consulta_Fechas.getColumn("RAZA").setPreferredWidth(250);
            Tabla_Consulta_Fechas.getColumn("COLOR").setPreferredWidth(150);
            Tabla_Consulta_Fechas.getColumn("AÑO NAC.").setPreferredWidth(120);
            Tabla_Consulta_Fechas.getColumn("PROPIETARIO").setPreferredWidth(400);
            Tabla_Consulta_Fechas.getColumn("TELEFONO").setPreferredWidth(200);
            Tabla_Consulta_Fechas.getColumn("CORREO").setPreferredWidth(450);
            Tabla_Consulta_Fechas.getColumn("N° SOCIO").setPreferredWidth(70);
            Tabla_Consulta_Fechas.getColumn("").setPreferredWidth(0);
            Tabla_Consulta_Fechas.getColumn("ID").setPreferredWidth(0);

            for (int i = 0; i < Tabla_Consulta_Fechas.getColumnCount(); i++) {
                Class<?> columnClass = Tabla_Consulta_Fechas.getColumnClass(i);
                Tabla_Consulta_Fechas.setDefaultEditor(columnClass, null);
            }

            while (rs.next()) {

                datosUsuario[0] = rs.getString(2);
                datosUsuario[1] = rs.getString(3);
                datosUsuario[2] = rs.getString(4);
                datosUsuario[3] = rs.getString(5);
                datosUsuario[4] = rs.getString(8);
                datosUsuario[5] = rs.getString(9);
                datosUsuario[6] = rs.getString(10);
                datosUsuario[7] = rs.getString(11);
                datosUsuario[8] = rs.getString(12);
                datosUsuario[9] = rs.getString(13);
                datosUsuario[10] = rs.getString(14) + " " + rs.getString(15);
                datosUsuario[11] = rs.getString(16);
                datosUsuario[12] = rs.getString(17);
                datosUsuario[13] = rs.getString(20);
                datosUsuario[14] = rs.getString(6) + "\n\n" + rs.getString(7);
                datosUsuario[15] = rs.getString(1);

                model.addRow(datosUsuario);
            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Busca citas comparando Servicio y Fecha   
    public static void Filtro_Fechas_Fechas_2(String Fecha, String Fecha2) {

        try {

            String[] datosUsuario = new String[16];

            String[] Titulos = {"HORA CITA", "FECHA CITA", "ESTADO", "SERVICIO", "ESPECIE", "MASCOTA", "SEXO", "RAZA", "COLOR", "AÑO NAC.", "PROPIETARIO", "TELEFONO", "CORREO", "N° SOCIO", "", "ID"};

            DefaultTableModel model = new DefaultTableModel(null, Titulos);

            PreparedStatement PST = connection.prepare("SELECT * FROM citas WHERE Fecha_Cita BETWEEN ? AND ?");

            PST.setString(1, Fecha);
            PST.setString(2, Fecha2);

            ResultSet rs = PST.executeQuery();

            Tabla_Consulta_Fechas.setModel(model);
            Tabla_Consulta_Fechas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            Tabla_Consulta_Fechas.getColumn("HORA CITA").setPreferredWidth(150);
            Tabla_Consulta_Fechas.getColumn("FECHA CITA").setPreferredWidth(150);
            Tabla_Consulta_Fechas.getColumn("ESTADO").setPreferredWidth(100);
            Tabla_Consulta_Fechas.getColumn("SERVICIO").setPreferredWidth(200);
            Tabla_Consulta_Fechas.getColumn("ESPECIE").setPreferredWidth(100);
            Tabla_Consulta_Fechas.getColumn("MASCOTA").setPreferredWidth(200);
            Tabla_Consulta_Fechas.getColumn("SEXO").setPreferredWidth(120);
            Tabla_Consulta_Fechas.getColumn("RAZA").setPreferredWidth(250);
            Tabla_Consulta_Fechas.getColumn("COLOR").setPreferredWidth(150);
            Tabla_Consulta_Fechas.getColumn("AÑO NAC.").setPreferredWidth(120);
            Tabla_Consulta_Fechas.getColumn("PROPIETARIO").setPreferredWidth(400);
            Tabla_Consulta_Fechas.getColumn("TELEFONO").setPreferredWidth(200);
            Tabla_Consulta_Fechas.getColumn("CORREO").setPreferredWidth(450);
            Tabla_Consulta_Fechas.getColumn("N° SOCIO").setPreferredWidth(70);
            Tabla_Consulta_Fechas.getColumn("").setPreferredWidth(0);
            Tabla_Consulta_Fechas.getColumn("ID").setPreferredWidth(0);

            for (int i = 0; i < Tabla_Consulta_Fechas.getColumnCount(); i++) {
                Class<?> columnClass = Tabla_Consulta_Fechas.getColumnClass(i);
                Tabla_Consulta_Fechas.setDefaultEditor(columnClass, null);
            }

            while (rs.next()) {

                datosUsuario[0] = rs.getString(2);
                datosUsuario[1] = rs.getString(3);
                datosUsuario[2] = rs.getString(4);
                datosUsuario[3] = rs.getString(5);
                datosUsuario[4] = rs.getString(8);
                datosUsuario[5] = rs.getString(9);
                datosUsuario[6] = rs.getString(10);
                datosUsuario[7] = rs.getString(11);
                datosUsuario[8] = rs.getString(12);
                datosUsuario[9] = rs.getString(13);
                datosUsuario[10] = rs.getString(14) + " " + rs.getString(15);
                datosUsuario[11] = rs.getString(16);
                datosUsuario[12] = rs.getString(17);
                datosUsuario[13] = rs.getString(20);
                datosUsuario[14] = rs.getString(6) + "\n\n" + rs.getString(7);
                datosUsuario[15] = rs.getString(1);

                model.addRow(datosUsuario);
            }
        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Agrega datos al combobox independiente 
    public static void Combobox_Independiente(JComboBox Combo) {

        try {

            SQL = "SELECT * FROM vacunas";

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {
                Combo.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
        }
    }
    /////////////////////////////////////-----------------------------------------------------------------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Agrega datos al combobox independiente 
    public static void Combobox_Independiente2(JComboBox Combo) {

        try {

            SQL = "SELECT * FROM medicamentos";

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {
                Combo.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
        }
    }
    /////////////////////////////////////-----------------------------------------------------------------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////----------------------------------------------------------------------------------------------- 
    //Agrega datos al combobox independiente 
    public static void Combobox_Independiente3(JComboBox Combo) {

        try {

            SQL = "SELECT * FROM desparacitantes";

            ResultSet rs = connection.executeQuery(SQL);

            while (rs.next()) {
                Combo.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
        }
    }
    /////////////////////////////////////-----------------------------------------------------------------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////-----------------------------------------------------------------------------------------------
    //Actualiza los datos de la tabla VACUNAS
    public static void UPDATE_VACUNAS(int Stock, String LOTE) {

        try {
            SQL = "UPDATE vacunas SET Cantidad = '" + Stock + "' WHERE Lote = '" + LOTE + "'";

            PreparedStatement PST = connection.prepare(SQL);

            PST.executeUpdate();

        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////-----------------------------------------------------------------------------------------------
    //Actualiza los datos de la tabla MEDICAMENTOS
    public static void UPDATE_MEDICAMENTOS(int Stock, String LOTE) {

        try {
            SQL = "UPDATE medicamentos SET Cantidad = '" + Stock + "' WHERE Lote = '" + LOTE + "'";

            PreparedStatement PST = connection.prepare(SQL);

            PST.executeUpdate();

        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////-----------------------------------------------------------------------------------------------
    //Actualiza los datos de la tabla DESPARACITANTES
    public static void UPDATE_DESPARACITANTES(int Stock, String LOTE) {

        try {
            SQL = "UPDATE desparacitantes SET Cantidad = '" + Stock + "' WHERE Lote = '" + LOTE + "'";

            PreparedStatement PST = connection.prepare(SQL);

            PST.executeUpdate();

        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
/////////////////////////////////////-----------------------------------------------------------------------------------------------
    //Elimina los datos de los servicios concluidos
    public static void DELETE_SERVICIO_COUNCLUIDO(int ID_MASCOTA) {

        try {
            SQL = "DELETE FROM historial WHERE ID_MASCOTA = ?";

            PreparedStatement PST = connection.prepare(SQL);
            PST.setInt(1, ID_MASCOTA);

            PST.executeUpdate();

        } catch (SQLException e) {
        }
    }
/////////////////////////////////////-----------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
}