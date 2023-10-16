package ArchiVet.ventana;


import ArchiVet.ventana.componente.Creacion_PDF;
import Archivet.Controlador.Filtraciones;
import static ArchiVet.ventana.ventana_puntoVenta.ID_PET;
import static ArchiVet.ventana.ventana_puntoVenta.NAME_PET;
import static ArchiVet.ventana.ventana_puntoVenta.NumeroID;
import static ArchiVet.ventana.ventana_puntoVenta.mostradorCaja;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_menu.panel;
import com.lowagie.text.DocumentException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ventana_pagarCaja extends javax.swing.JInternalFrame {

    private static Creacion_PDF creacion_pdf;
    private ArchiVet.Imagen.imagenes imagen;
    
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    public static String SEX = "";
    public static int ID_DELETE_HISTORIAL;

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    public ventana_pagarCaja() {
        initComponents();
        creacion_pdf = new Creacion_PDF();
        imagen = new ArchiVet.Imagen.imagenes();
        ocultarBarraTitulo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.usuario,0,0,getWidth(),getHeight(),this);
            }
        };
        Nombre_Usuario_Pagar_Cuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Usuario1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.mascotas3,0,0,getWidth(),getHeight(),this);
            }
        };
        Nombre_Mascota_Pagar_Cuenta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Total_Pagar_Cuenta = new javax.swing.JTextField();
        Ingresar_Pago_Cuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion_Pagar_Cuenta = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Cambio_Cuenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Hora_Fecha = new javax.swing.JLabel();
        AceptarEfectivo = new javax.swing.JButton();
        Cancelar_Volver = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel2.setBackground(new java.awt.Color(47, 69, 56));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(215, 208, 183));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dueño");

        Usuario.setPreferredSize(new java.awt.Dimension(50, 50));

        Nombre_Usuario_Pagar_Cuenta.setEditable(false);
        Nombre_Usuario_Pagar_Cuenta.setBackground(new java.awt.Color(47, 69, 56));
        Nombre_Usuario_Pagar_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_Usuario_Pagar_Cuenta.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Usuario_Pagar_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        Nombre_Usuario_Pagar_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_Usuario_Pagar_CuentaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mascota");

        Usuario1.setPreferredSize(new java.awt.Dimension(50, 50));

        Nombre_Mascota_Pagar_Cuenta.setEditable(false);
        Nombre_Mascota_Pagar_Cuenta.setBackground(new java.awt.Color(47, 69, 56));
        Nombre_Mascota_Pagar_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_Mascota_Pagar_Cuenta.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Mascota_Pagar_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        Nombre_Mascota_Pagar_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_Mascota_Pagar_CuentaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(215, 208, 183)));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel4.setText("Total a pagar");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel5.setText("Pagar ahora");

        Total_Pagar_Cuenta.setEditable(false);
        Total_Pagar_Cuenta.setBackground(new java.awt.Color(255, 255, 255));
        Total_Pagar_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Total_Pagar_Cuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total_Pagar_Cuenta.setText("0.00");
        Total_Pagar_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(253, 0, 0)));
        Total_Pagar_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_Pagar_CuentaActionPerformed(evt);
            }
        });

        Ingresar_Pago_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Ingresar_Pago_Cuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ingresar_Pago_Cuenta.setText("0.00");
        Ingresar_Pago_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 255, 102)));
        Ingresar_Pago_Cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ingresar_Pago_CuentaMouseClicked(evt);
            }
        });
        Ingresar_Pago_Cuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Ingresar_Pago_CuentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Ingresar_Pago_CuentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Ingresar_Pago_CuentaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel6.setText("$");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel7.setText("$");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel8.setText("MXN");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel9.setText("MXN");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel10.setText("Fecha reportada del cobro");

        Descripcion_Pagar_Cuenta.setEditable(false);
        Descripcion_Pagar_Cuenta.setColumns(20);
        Descripcion_Pagar_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Descripcion_Pagar_Cuenta.setRows(5);
        jScrollPane1.setViewportView(Descripcion_Pagar_Cuenta);

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel11.setText("Descripción");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel12.setText("Cambio a devolver");

        Cambio_Cuenta.setEditable(false);
        Cambio_Cuenta.setBackground(new java.awt.Color(255, 255, 255));
        Cambio_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Cambio_Cuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cambio_Cuenta.setText("0.00");
        Cambio_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 204)));

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel13.setText("$");

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel14.setText("MXN");

        Hora_Fecha.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Hora_Fecha.setForeground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Total_Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Ingresar_Pago_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cambio_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(47, 47, 47)
                .addComponent(Hora_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Total_Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ingresar_Pago_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cambio_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(101, 101, 101)
                        .addComponent(jLabel10)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Hora_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        AceptarEfectivo.setBackground(new java.awt.Color(242, 242, 242));
        AceptarEfectivo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        AceptarEfectivo.setText("Aceptar efectivo");
        AceptarEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarEfectivoActionPerformed(evt);
            }
        });

        Cancelar_Volver.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Cancelar_Volver.setText("Cancelar");
        Cancelar_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar_VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nombre_Usuario_Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nombre_Mascota_Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AceptarEfectivo)
                    .addComponent(Cancelar_Volver))
                .addGap(343, 343, 343))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre_Usuario_Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(734, 734, 734)
                        .addComponent(AceptarEfectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancelar_Volver))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Nombre_Mascota_Pagar_Cuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nombre_Usuario_Pagar_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_Usuario_Pagar_CuentaActionPerformed

    }//GEN-LAST:event_Nombre_Usuario_Pagar_CuentaActionPerformed

    private void Nombre_Mascota_Pagar_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_Mascota_Pagar_CuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_Mascota_Pagar_CuentaActionPerformed

    private void Total_Pagar_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_Pagar_CuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_Pagar_CuentaActionPerformed

    private void AceptarEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarEfectivoActionPerformed

        JTextField Folio = new JTextField();
        Filtraciones.ObtenerFolio(Folio);

        int folio = Integer.parseInt(Folio.getText());
        int Folio2 = folio + 1;
        String Fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        float Cargo, Pago, Cambio;
        String Descripcion, NombreU;
        NombreU = Nombre_Usuario_Pagar_Cuenta.getText();
        Descripcion = Descripcion_Pagar_Cuenta.getText();
        Cargo = Float.parseFloat(Total_Pagar_Cuenta.getText());
        Pago = Float.parseFloat(Ingresar_Pago_Cuenta.getText());
        Cambio = Float.parseFloat(Cambio_Cuenta.getText());

        float Total, Pagar;
        Total = Float.parseFloat(Total_Pagar_Cuenta.getText());
        Pagar = Float.parseFloat(Ingresar_Pago_Cuenta.getText());

        try {

            if (Pagar >= Total) {
                if (Folio2 < 10) {
                    creacion_pdf.crearPDF(Nombre_Usuario_Pagar_Cuenta.getText(), Nombre_Mascota_Pagar_Cuenta.getText(), "0000" + String.valueOf(Folio2));
                } else if (Folio2 > 9 && Folio2 < 100) {
                    creacion_pdf.crearPDF(Nombre_Usuario_Pagar_Cuenta.getText(), Nombre_Mascota_Pagar_Cuenta.getText(),"000" + String.valueOf(Folio2));
                } else if (Folio2 > 99 && Folio2 < 1000) {
                    creacion_pdf.crearPDF(Nombre_Usuario_Pagar_Cuenta.getText(), Nombre_Mascota_Pagar_Cuenta.getText(),"00" + String.valueOf(Folio2));
                } else if (Folio2 > 999 && Folio2 < 10000) {
                    creacion_pdf.crearPDF(Nombre_Usuario_Pagar_Cuenta.getText(), Nombre_Mascota_Pagar_Cuenta.getText(),"0" + String.valueOf(Folio2));
                } else if (Folio2 > 9999 && Folio2 < 100000) {
                    creacion_pdf.crearPDF(Nombre_Usuario_Pagar_Cuenta.getText(), Nombre_Mascota_Pagar_Cuenta.getText(),String.valueOf(Folio2));
                }

                //System.out.println(sexoMascota);
                Filtraciones.insertDatos_Historial(folio + 1, NAME_PET, SEX, NombreU, Descripcion, Fecha, Cargo, Pago, Cambio, NumeroID, ID_PET);
                ventana_menu.FondoBotones.setVisible(true);
                ventana_menu.cerrar.setVisible(true);
                this.dispose();
                panel.setVisible(true);
                Filtraciones.DELETE_SERVICIO_COUNCLUIDO(ID_PET);

            } else {
                JOptionPane.showMessageDialog(null, "Recuerda que solo aceptamos pagos en una sola exhibición");
            }
        } catch (FileNotFoundException | DocumentException | NumberFormatException ex) {
        }
    }//GEN-LAST:event_AceptarEfectivoActionPerformed

    private void Cancelar_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar_VolverActionPerformed
        try {
            Fondo.add(mostradorCaja);
            mostradorCaja.setVisible(true);
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Cancelar_VolverActionPerformed

    private void Ingresar_Pago_CuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ingresar_Pago_CuentaKeyReleased
        try {
            double Total, Pagar, Cambio;

            Total = Double.parseDouble(Total_Pagar_Cuenta.getText());
            Pagar = Double.parseDouble(Ingresar_Pago_Cuenta.getText());

            String numero = Ingresar_Pago_Cuenta.getText();

            if (Total >= Pagar) {
                Cambio_Cuenta.setText("0.00");
            } else if (numero.equals("") == false) {
                Cambio = Pagar - Total;
                DecimalFormat df = new DecimalFormat("#.00");

                Cambio_Cuenta.setText(df.format(Cambio));
            }
        } catch (NumberFormatException e) {
        }

    }//GEN-LAST:event_Ingresar_Pago_CuentaKeyReleased

    private void Ingresar_Pago_CuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ingresar_Pago_CuentaKeyTyped

        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || Ingresar_Pago_Cuenta.getText().contains("."))) {
            evt.consume();
        }

    }//GEN-LAST:event_Ingresar_Pago_CuentaKeyTyped

    private void Ingresar_Pago_CuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ingresar_Pago_CuentaKeyPressed
        
    }//GEN-LAST:event_Ingresar_Pago_CuentaKeyPressed

    private void Ingresar_Pago_CuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ingresar_Pago_CuentaMouseClicked
        Ingresar_Pago_Cuenta.setText("");
    }//GEN-LAST:event_Ingresar_Pago_CuentaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarEfectivo;
    private javax.swing.JTextField Cambio_Cuenta;
    private javax.swing.JButton Cancelar_Volver;
    public static javax.swing.JTextArea Descripcion_Pagar_Cuenta;
    public static javax.swing.JLabel Hora_Fecha;
    private javax.swing.JTextField Ingresar_Pago_Cuenta;
    public static javax.swing.JTextField Nombre_Mascota_Pagar_Cuenta;
    public static javax.swing.JTextField Nombre_Usuario_Pagar_Cuenta;
    public static javax.swing.JTextField Total_Pagar_Cuenta;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel Usuario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
