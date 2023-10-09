package ArchiVet.ventana;

import ArchiVet.Admin.AdminCitas;
import ArchiVet.ventana.componente.Buscardor_JTable;
import static ArchiVet.ventana.ventana_agendarCitas.registrarCita;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_registrarCita.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class ventana_buscadorMascotaCita extends javax.swing.JInternalFrame {

    private ArchiVet.Imagen.imagenes imagen;
    private AdminCitas adminCitas;
    private Buscardor_JTable buscadorJTable;

    public static String nombreMascota, Especie, Raza, Color, fechaNacimiento, nombrePropietario, apellidoPaterno, apellidoMaterno, Telefono, Correo, Domicilio, CP, NSocio, sexoM;

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void aceptarDatos(java.awt.event.ActionEvent evt) {
        try {
            if (MascotaSeleccionada.getText().isEmpty() || PropietarioSeleccionado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede acceder con campos vacios");
            } else {
                ventana_registrarCita Cita = new ventana_registrarCita();
                Fondo.add(Cita);
                Cita.setVisible(true);
                Cita.setLocation(0, 0);
                LabelUPDATE.setVisible(false);
                MNombre.setText(nombreMascota);
                MEspecie.setText(Especie);
                MRaza.setText(Raza);
                MColor.setText(Color);
                MFecha.setText(fechaNacimiento);
                MSEXO.setText(sexoM);
                PNombre.setText(nombrePropietario);
                PApellidos.setText(apellidoPaterno + " " + apellidoMaterno);
                PTelefono.setText(Telefono);
                PCorreo.setText(Correo);
                PDomicilio.setText(Domicilio);
                PCP.setText(CP);
                PSocio.setText(NSocio);
                this.dispose();
            }
        } catch (HeadlessException e) {
            System.err.println(e.getMessage());
        }
    }

    private void tablaCitas(java.awt.event.MouseEvent evt) {
        try {
            int seleccion = Tabla_Citas.rowAtPoint(evt.getPoint());
            nombreMascota = String.valueOf(Tabla_Citas.getValueAt(seleccion, 0));
            sexoM = String.valueOf(Tabla_Citas.getValueAt(seleccion, 1));
            Especie = String.valueOf(Tabla_Citas.getValueAt(seleccion, 2));
            Raza = String.valueOf(Tabla_Citas.getValueAt(seleccion, 3));
            Color = String.valueOf(Tabla_Citas.getValueAt(seleccion, 4));
            fechaNacimiento = String.valueOf(Tabla_Citas.getValueAt(seleccion, 5));
            nombrePropietario = String.valueOf(Tabla_Citas.getValueAt(seleccion, 6));
            apellidoPaterno = String.valueOf(Tabla_Citas.getValueAt(seleccion, 7));
            apellidoMaterno = String.valueOf(Tabla_Citas.getValueAt(seleccion, 8));
            Telefono = String.valueOf(Tabla_Citas.getValueAt(seleccion, 9));
            Correo = String.valueOf(Tabla_Citas.getValueAt(seleccion, 10));
            Domicilio = String.valueOf(Tabla_Citas.getValueAt(seleccion, 11));
            CP = String.valueOf(Tabla_Citas.getValueAt(seleccion, 12));
            NSocio = String.valueOf(Tabla_Citas.getValueAt(seleccion, 13));
            MascotaSeleccionada.setText(nombreMascota);
            PropietarioSeleccionado.setText(nombrePropietario + " " + apellidoPaterno + " " + apellidoMaterno);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    public ventana_buscadorMascotaCita() {
        initComponents();
        imagen = new ArchiVet.Imagen.imagenes();
        adminCitas = new AdminCitas();
        buscadorJTable = new Buscardor_JTable();
        adminCitas.obtenerModeloTablaCitas(Tabla_Citas, "buscadorMascota");
        ocultarBarraTitulo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.mascotas3,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.usuario,0,0,getWidth(),getHeight(),this);
            }
        };
        Mascota = new javax.swing.JTextField();
        Propietario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Citas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        MascotaSeleccionada = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PropietarioSeleccionado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(47, 69, 56));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1075));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1465, 730));

        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel2.setPreferredSize(new java.awt.Dimension(50, 50));

        Mascota.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Mascota.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));
        Mascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MascotaKeyReleased(evt);
            }
        });

        Propietario.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Propietario.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));
        Propietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PropietarioKeyReleased(evt);
            }
        });

        Tabla_Citas.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 14, 75)));
        Tabla_Citas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Citas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Citas.setRowHeight(35);
        Tabla_Citas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Citas.getTableHeader().setResizingAllowed(false);
        Tabla_Citas.getTableHeader().setReorderingAllowed(false);
        Tabla_Citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Citas);

        jButton1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel3.setText("Mascota:");

        MascotaSeleccionada.setBackground(new java.awt.Color(255, 255, 255));
        MascotaSeleccionada.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MascotaSeleccionada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MascotaSeleccionada.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel5.setText("Propietario:");

        PropietarioSeleccionado.setBackground(new java.awt.Color(255, 255, 255));
        PropietarioSeleccionado.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PropietarioSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropietarioSeleccionado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MascotaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PropietarioSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Mascota, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 330, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mascota)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(MascotaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PropietarioSeleccionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(215, 208, 183));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel4.setText("Buscador propietario/Mascota");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(757, 757, 757)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registrarCita.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MascotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MascotaKeyReleased
        try {
            buscadorJTable.buscarEnTabla(adminCitas.obtenerModeloTablaCitas(Tabla_Citas, "buscadorMascota"), adminCitas.obtenerBuscadorMascotaCitasArray(), Mascota.getText(), "MASCOTAS");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_MascotaKeyReleased

    private void PropietarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PropietarioKeyReleased
        try {
            buscadorJTable.buscarEnTabla(adminCitas.obtenerModeloTablaCitas(Tabla_Citas, "buscadorMascota"), adminCitas.obtenerBuscadorMascotaCitasArray(), Propietario.getText(), "PROPIETARIO");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_PropietarioKeyReleased

    private void Tabla_CitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CitasMouseClicked
        tablaCitas(evt);
    }//GEN-LAST:event_Tabla_CitasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        aceptarDatos(evt);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Mascota;
    private javax.swing.JLabel MascotaSeleccionada;
    public static javax.swing.JTextField Propietario;
    private javax.swing.JLabel PropietarioSeleccionado;
    public static javax.swing.JTable Tabla_Citas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
