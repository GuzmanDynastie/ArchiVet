package BD;

import ArchiVet.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class OBD extends DAO {

    public static Object[] datos = new Object[25];
    public static String sSQL;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Medicamentos                //////////////////////////////////////////////////
    public void tablaMedicamentos(JTable tabla, DefaultTableModel mode) {
        sSQL = "SELECT * FROM medicamentos";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getString("Descripcion");
                datos[1] = rs.getString("Lote");
                datos[2] = rs.getInt("Cantidad");
                datos[3] = rs.getDouble("Precio");
                datos[4] = rs.getDate("Caducidad");
                mode.addRow(datos);
                tabla.setModel(mode);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                  Vacunas                 //////////////////////////////////////////////////
    public void tablaVacunas(JTable tabla, DefaultTableModel mode) {
        sSQL = "SELECT * FROM vacunas";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getString("Descripcion");
                datos[1] = rs.getString("Lote");
                datos[2] = rs.getInt("Cantidad");
                datos[3] = rs.getDouble("Precio");
                datos[4] = rs.getDate("Caducidad");
                mode.addRow(datos);
                tabla.setModel(mode);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Desparacitantes             //////////////////////////////////////////////////
    public void tablaDesparacitantes(JTable tabla, DefaultTableModel mode) {
        sSQL = "SELECT * FROM desparacitantes";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getString("Descripcion");
                datos[1] = rs.getString("Lote");
                datos[2] = rs.getInt("Cantidad");
                datos[3] = rs.getDouble("Precio");
                datos[4] = rs.getDate("Caducidad");
                mode.addRow(datos);
                tabla.setModel(mode);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              ComboBox                    //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                  Vacunas                 //////////////////////////////////////////////////
    public void combovacu(JComboBox Des) {
        sSQL = "SELECT Descripcion FROM vacunas";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                Des.addItem(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Desparacitantes             //////////////////////////////////////////////////
    public void combodesp(JComboBox Des) {
        sSQL = "SELECT Descripcion FROM desparacitantes";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                Des.addItem(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                     Lotes                       //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                  Vacunas                 //////////////////////////////////////////////////
    public void datvacunas(String des, JTextField lote, JTextField precio) {
        sSQL = "SELECT Lote, Precio FROM vacunas WHERE Descripcion='" + des + "'";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getString("Lote");
                datos[1] = rs.getString("Precio");
                lote.setText(datos[0].toString());
                precio.setText(datos[1].toString());
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Desparacitantes             //////////////////////////////////////////////////

    public void datdesp(String des, JTextField lote, JTextField precio) {
        sSQL = "SELECT Lote, Precio FROM desparacitantes WHERE Descripcion='" + des + "'";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getString("Lote");
                datos[1] = rs.getString("Precio");
                lote.setText(datos[0].toString());
                precio.setText(datos[1].toString());
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                  Inventario                  //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Medicamentos                //////////////////////////////////////////////////
    public void medicamentos(String des, String lote, int can, Double pre, java.sql.Date cadu) {
        sSQL = "INSERT INTO medicamentos(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setString(1, des);
            pst.setString(2, lote);
            pst.setInt(3, can);
            pst.setDouble(4, pre);
            pst.setDate(5, cadu);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                      Vacunas                 //////////////////////////////////////////////////
    public void vacunas(String des, String lote, int can, Double pre, java.sql.Date cadu) {
        sSQL = "INSERT INTO vacunas(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setString(1, des);
            pst.setString(2, lote);
            pst.setInt(3, can);
            pst.setDouble(4, pre);
            pst.setDate(5, cadu);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Desparacitantes             //////////////////////////////////////////////////
    public void desparacitantes(String des, String lote, int can, Double pre, java.sql.Date cadu) {
        sSQL = "INSERT INTO desparacitantes(Descripcion, Lote, Cantidad, Precio, Caducidad) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setString(1, des);
            pst.setString(2, lote);
            pst.setInt(3, can);
            pst.setDouble(4, pre);
            pst.setDate(5, cadu);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////             Historial Medico               //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////             Consulta Medica              //////////////////////////////////////////////////
    public void tablaConsultas(JTable tabla, String Mascota) {
        DefaultTableModel mode = (DefaultTableModel) tabla.getModel();
        sSQL = "SELECT * FROM historialconsultas WHERE NOMBRE_MASCOTA='" + Mascota + "'";
        mode.setRowCount(0);
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getDate("FECHA").toString();
                datos[1] = rs.getString("MOTIVO");
                datos[2] = rs.getString("MEDICO");
                datos[3] = rs.getString("DIAGNOSTICO");
                datos[4] = rs.getString("RECETA");
                datos[5] = rs.getString("PARAMETROS");
                mode.addRow(datos);
            }
            tabla.setModel(mode);
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    public void subirConsulta(int IDm, String mas, java.sql.Date fec, String ser, float pre, String mot, String dia, String rec, String par, int IDp, String med) {
        sSQL = "INSERT INTO historialconsultas(ID_MASCOTA, NOMBRE_MASCOTA, FECHA, SERVICIO, PRECIO, MOTIVO, DIAGNOSTICO, RECETA, PARAMETROS , ID_PROPIETARIO, MEDICO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setInt(1, IDm);
            pst.setString(2, mas);
            pst.setDate(3, fec);
            pst.setString(4, ser);
            pst.setFloat(5, pre);
            pst.setString(6, mot);
            pst.setString(7, dia);
            pst.setString(8, rec);
            pst.setString(9, par);
            pst.setInt(10, IDp);
            pst.setString(11, med);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex + "pe");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////                     Vacunas                 //////////////////////////////////////////////////
    public void tablaVacunasapli(JTable tabla, DefaultTableModel mode, String Mascota) {
        sSQL = "SELECT * FROM vacunasaplicadas WHERE NOMBRE_MASCOTA='" + Mascota + "'";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getDate("fecha_aplicacion");
                datos[1] = rs.getString("descripción");
                datos[2] = rs.getString("lote");
                datos[3] = rs.getDouble("Precio");
                datos[4] = rs.getString("MEDICO");

                mode.addRow(datos);
                tabla.setModel(mode);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    public void aplivacunas(java.sql.Date apli, String des, String lote, Double pre, String mas, String med) {
        sSQL = "INSERT INTO vacunasaplicadas(fecha_aplicacion, descripción, lote, Precio, NOMBRE_MASCOTA, MEDICO) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setDate(1, apli);
            pst.setString(2, des);
            pst.setString(3, lote);
            pst.setDouble(4, pre);
            pst.setString(5, mas);
            pst.setString(6, med);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////              Desparacitante              //////////////////////////////////////////////////
    public void tablaDesparapli(JTable tabla, DefaultTableModel mode, String Mascota) {
        sSQL = "SELECT * FROM desparacitacionaplicadas WHERE NOMBRE_MASCOTA='" + Mascota + "'";
        try {
            ResultSet rs = connection.executeQuery(sSQL);
            while (rs.next()) {
                datos[0] = rs.getDate("fecha_aplicacion");
                datos[1] = rs.getString("descripción");
                datos[2] = rs.getString("lote");
                datos[3] = rs.getDouble("Precio");
                datos[4] = rs.getString("MEDICO");

                mode.addRow(datos);
                tabla.setModel(mode);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR\n" + ex);
        }
    }

    public void aplidesp(java.sql.Date apli, String des, String lote, Double pre, String mas, String med) {
        sSQL = "INSERT INTO desparacitacionaplicadas(fecha_aplicacion, descripción, lote, Precio, NOMBRE_MASCOTA, MEDICO) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setDate(1, apli);
            pst.setString(2, des);
            pst.setString(3, lote);
            pst.setDouble(4, pre);
            pst.setString(5, mas);
            pst.setString(6, med);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void historial(int IDm, String mascota, String sexo, String servicio, float precio, String descripcion, int IDp) {
        sSQL = "INSERT INTO historial(ID_MASCOTA, NOMBRE_MASCOTA, SEXO, SERVICIO, PRECIO, DESCRIPCION, ID_PROPIETARIO) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepare(sSQL);
            pst.setInt(1, IDm);
            pst.setString(2, mascota);
            pst.setString(3, sexo);
            pst.setString(4, servicio);
            pst.setFloat(5, precio);
            pst.setString(6, descripcion);
            pst.setInt(7, IDp);
            int n = pst.executeUpdate();
            if (n > 0) {
                System.out.println("Registro realizado");
            } else {
                System.out.println("Registro negado");
            }
        } catch (SQLException ex) {
            System.out.println("error\n" + ex);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
}
