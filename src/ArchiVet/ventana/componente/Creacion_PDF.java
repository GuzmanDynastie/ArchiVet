package ArchiVet.ventana.componente;

import static ArchiVet.ventana.ventana_pagarCaja.Descripcion_Pagar_Cuenta;
import static ArchiVet.ventana.ventana_pagarCaja.Total_Pagar_Cuenta;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Creacion_PDF {
    
    ArchiVet.Imagen.imagenes imagen = new ArchiVet.Imagen.imagenes();

    //Crear PDF
    public void crearPDF(String nombrePropietario, String nombreMascota, String Folio) throws FileNotFoundException, DocumentException {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(new Date());

        File Carpeta = new File("Ventas");

        Document documento = new Document();

        try {
            //PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            if (!Carpeta.exists()) {
                Carpeta.mkdir();
            } else {

                PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(Carpeta + "/" + "Folio N°" + Folio + "__" + date + ".pdf"));
                documento.open();
                PdfContentByte cb = writer.getDirectContent();
                Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                //Lineas divisorias
                //Linea Superior
                g.setColor(Color.red);
                g.drawRect(36, 200, 520, 0);

                //Linea Inferor
                g.setColor(Color.red);
                g.drawRect(36, 230, 520, 0);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
                //Titulo y subtitulo del PDF
                Font font1 = new Font("Arial", Font.BOLD + Font.ITALIC, 35);
                g.setFont(font1);

                g.setColor(Color.BLACK);
                g.drawString("ArchiVet", 200, 37);
                /////////// ---------------------------------------------------------------------
                Font font2 = new Font("Arial", Font.BOLD + Font.ITALIC, 18);
                g.setFont(font2);

                g.setColor(Color.GRAY);
                g.drawString("Atención y Servicio +", 182, 60);
                /////////// ---------------------------------------------------------------------
                Font font3 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
                g.setFont(font3);

                g.setColor(Color.red);
                g.drawString("Folio N°. ", 460, 110);
                /////////// ---------------------------------------------------------------------
                Font font4 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
                g.setFont(font4);

                g.setColor(Color.black);

                //Condicional para los numeros del Folio  
                g.drawString(Folio, 520, 110);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
                //Agrega Fecha y hora
                Font font5 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
                g.setFont(font5);

                g.setColor(Color.black);

                DateFormat dateFormat2 = new SimpleDateFormat("EEEEEEEEE, dd/MM/yyyy, HH:mm:ss z");

                String date2 = dateFormat2.format(new Date());

                g.drawString("" + date2, 35, 110);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                //Nombre del dueño y nombre de la mascota
                Font font6 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font6);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("Nombre dueño:", 35, 150);
                /////////// ---------------------------------------------------------------------
                Font font7 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.ITALIC, 16);
                g.setFont(font7);

                g.setColor(Color.BLACK);
                g.drawString("" + nombrePropietario, 130, 150);
                /////////// --------------------------------------------------------------------- 
                Font font8 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font8);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("Nombre paciente:", 35, 170);
                /////////// ---------------------------------------------------------------------
                Font font9 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.ITALIC, 16);
                g.setFont(font9);

                g.setColor(Color.BLACK);
                g.drawString("" + nombreMascota, 140, 170);
                /////////// ---------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Titulos entre lineas
                Font font10 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font10);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("SERVICIOS", 35, 221);
                /////////// ---------------------------------------------------------------------
                Font font11 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font11);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("PRECIO", 125, 221);
                /////////// ---------------------------------------------------------------------
                Font font12 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font12);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("DESCRIPCIÓN", 205, 221);
                /////////// ---------------------------------------------------------------------
                Font font13 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font13);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("TOTAL", 510, 221);
                /////////// ---------------------------------------------------------------------

                //Total
                Font font14 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 20);
                g.setFont(font14);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("$" + Total_Pagar_Cuenta.getText(), 500, 256);
                /////////// ---------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//                ImageIcon img1 = new ImageIcon(getClass().getResource("/Imagen/Logo.png"));
//                g.drawImage(img1.getImage(), 360, 5, 100, 60, null);
                    g.drawImage(imagen.logo, 360, 5, 100, 60, null);

            }
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        }

        documento.add(new Paragraph(("\n\n\n\n\n\n\n\n\n\n\n\n\n\n") + Descripcion_Pagar_Cuenta.getText()));
        documento.close();

        JOptionPane.showMessageDialog(null, "Se genero el PDF con el Folio N°" + Folio + " en la carpeta " + Carpeta);
    }

    public void PDF_Historial(String Fecha, String Folio, String Nombre_Propietario, String Nombre_Mascota, String Descripcion, String Total) throws FileNotFoundException, DocumentException {

        File Carpeta = new File("Historial-Ventas");

        Document documento = new Document();

        try {
            //PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            if (!Carpeta.exists()) {
                Carpeta.mkdir();
            } else {

                PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(Carpeta + "/" + "Folio N°" + Folio + "__" + Nombre_Mascota + ".pdf"));
                documento.open();
                PdfContentByte cb = writer.getDirectContent();
                Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                //Lineas divisorias
                //Linea Superior
                g.setColor(Color.red);
                g.drawRect(36, 200, 520, 0);

                //Linea Inferor
                g.setColor(Color.red);
                g.drawRect(36, 230, 520, 0);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
                //Titulo y subtitulo del PDF
                Font font1 = new Font("Arial", Font.BOLD + Font.ITALIC, 35);
                g.setFont(font1);

                g.setColor(Color.BLACK);
                g.drawString("ArchiVet", 200, 37);
                /////////// ---------------------------------------------------------------------
                Font font2 = new Font("Arial", Font.BOLD + Font.ITALIC, 18);
                g.setFont(font2);

                g.setColor(Color.GRAY);
                g.drawString("Atención y Servicio +", 182, 60);
                /////////// ---------------------------------------------------------------------
                Font font3 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
                g.setFont(font3);

                g.setColor(Color.red);
                g.drawString("Folio N°. ", 460, 110);
                /////////// ---------------------------------------------------------------------
                Font font4 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
                g.setFont(font4);

                g.setColor(Color.black);

                //Condicional para los numeros del Folio
                g.drawString("" + Folio, 520, 110);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
                //Agrega Fecha y hora
                Font font5 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
                g.setFont(font5);

                g.setColor(Color.black);

                g.drawString("" + Fecha, 35, 110);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                //Nombre del dueño y nombre de la mascota
                Font font6 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font6);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("Nombre dueño:", 35, 150);
                /////////// ---------------------------------------------------------------------
                Font font7 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.ITALIC, 16);
                g.setFont(font7);

                g.setColor(Color.BLACK);
                g.drawString("" + Nombre_Propietario, 130, 150);
                /////////// --------------------------------------------------------------------- 
                Font font8 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font8);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("Nombre paciente:", 35, 170);
                /////////// ---------------------------------------------------------------------
                Font font9 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.ITALIC, 16);
                g.setFont(font9);

                g.setColor(Color.BLACK);
                g.drawString("" + Nombre_Mascota, 140, 170);
                /////////// ---------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Titulos entre lineas
                Font font10 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font10);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("SERVICIOS", 35, 221);
                /////////// ---------------------------------------------------------------------
                Font font11 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font11);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("PRECIO", 125, 221);
                /////////// ---------------------------------------------------------------------
                Font font12 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font12);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("DESCRIPCIÓN", 205, 221);
                /////////// ---------------------------------------------------------------------
                Font font13 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 18);
                g.setFont(font13);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("TOTAL", 510, 221);
                /////////// ---------------------------------------------------------------------

                //Total
                Font font14 = new Font("Gill Sans MT Condensed", Font.BOLD + Font.PLAIN, 20);
                g.setFont(font14);

                g.setColor(Color.decode("#223C6C"));
                g.drawString("$" + Total, 500, 256);
                /////////// ---------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //ImageIcon img1 = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/Clinica-Veterinaria.png"));
                
                //g.drawImage(img1.getImage(), 360, 5, 100, 60, null);
                g.drawImage(imagen.logo, 360, 5, 100, 60, null);
                

            }
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        }

        documento.add(new Paragraph(("\n\n\n\n\n\n\n\n\n\n\n\n\n\n") + Descripcion));
        documento.close();

        JOptionPane.showMessageDialog(null, "Se genero el PDF con el Folio N°" + Folio + " en la carpeta " + Carpeta);
    }

}
