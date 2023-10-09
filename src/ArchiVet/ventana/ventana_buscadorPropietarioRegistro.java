package ArchiVet.ventana;

import ArchiVet.Administrador.AdminPropietario;
import ArchiVet.ventana.componente.Buscardor_JTable;
import static ArchiVet.ventana.ventana_menu.registro;
import static ArchiVet.ventana.ventana_registroMascotaPropietario.*;
import java.awt.Graphics;

public class ventana_buscadorPropietarioRegistro extends javax.swing.JInternalFrame {

    private AdminPropietario adminPropietario;
    private Buscardor_JTable buscadorTabla;
    private ArchiVet.Imagen.imagenes imagen;
    private Buscardor_JTable filtro;

    private void bloquear() {
        ID_propietario.setEditable(false);
        dueño1.setEditable(false);
        paterno1.setEditable(false);
        materno1.setEditable(false);
        telefono1.setEditable(false);
        correo1.setEditable(false);
        direccion1.setEditable(false);
        codigo1.setEditable(false);
        GUARDAR.setVisible(false);
        GUARDAR1.setVisible(true);
        ID.setVisible(true);
        ID_propietario.setVisible(true);
    }

    private void limpiarCampos() {
        dueño1.setText("");
        materno1.setText("");
        paterno1.setText("");
        telefono1.setText("");
        correo1.setText("");
        direccion1.setText("");
        codigo1.setText("");
        ID_propietario.setText("");
    }

    private void mandarDatos() {
        ID_propietario.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 0).toString());
        dueño1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 1).toString());
        paterno1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 2).toString());
        materno1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 3).toString());
        telefono1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 4).toString());
        correo1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 5).toString());
        direccion1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 6).toString());
        codigo1.setText(Tablita.getValueAt(Tablita.getSelectedRow(), 7).toString());
    }

    public ventana_buscadorPropietarioRegistro() {
        initComponents();
        filtro = new Buscardor_JTable();
        adminPropietario = new AdminPropietario();
        imagen = new ArchiVet.Imagen.imagenes();
        buscadorTabla = new Buscardor_JTable();
        adminPropietario.obtenerModeloTablaPropietarios(Tablita);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SEPARADOR_5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtfiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.usuario,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        txtpropietario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablita = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        SEPARADOR_4 = new javax.swing.JPanel();
        SEPARADOR_6 = new javax.swing.JPanel();

        SEPARADOR_5.setBackground(new java.awt.Color(204, 204, 0));
        SEPARADOR_5.setPreferredSize(new java.awt.Dimension(917, 3));

        javax.swing.GroupLayout SEPARADOR_5Layout = new javax.swing.GroupLayout(SEPARADOR_5);
        SEPARADOR_5.setLayout(SEPARADOR_5Layout);
        SEPARADOR_5Layout.setHorizontalGroup(
            SEPARADOR_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        SEPARADOR_5Layout.setVerticalGroup(
            SEPARADOR_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(47, 69, 56));

        txtfiltro.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        txtfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroActionPerformed(evt);
            }
        });
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfiltroKeyTyped(evt);
            }
        });

        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Propietario:");

        txtpropietario.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        txtpropietario.setForeground(new java.awt.Color(242, 242, 242));
        txtpropietario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 242, 242)));

        jPanel2.setBackground(new java.awt.Color(215, 208, 183));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel4.setText("Buscador propietario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(513, 513, 513))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Tablita.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tablita.setRowHeight(35);
        Tablita.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tablita.getTableHeader().setResizingAllowed(false);
        Tablita.getTableHeader().setReorderingAllowed(false);
        Tablita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablitaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tablita);

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

        SEPARADOR_4.setBackground(new java.awt.Color(204, 204, 0));
        SEPARADOR_4.setPreferredSize(new java.awt.Dimension(917, 3));

        javax.swing.GroupLayout SEPARADOR_4Layout = new javax.swing.GroupLayout(SEPARADOR_4);
        SEPARADOR_4.setLayout(SEPARADOR_4Layout);
        SEPARADOR_4Layout.setHorizontalGroup(
            SEPARADOR_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        SEPARADOR_4Layout.setVerticalGroup(
            SEPARADOR_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        SEPARADOR_6.setBackground(new java.awt.Color(204, 204, 0));
        SEPARADOR_6.setPreferredSize(new java.awt.Dimension(917, 3));

        javax.swing.GroupLayout SEPARADOR_6Layout = new javax.swing.GroupLayout(SEPARADOR_6);
        SEPARADOR_6.setLayout(SEPARADOR_6Layout);
        SEPARADOR_6Layout.setHorizontalGroup(
            SEPARADOR_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        SEPARADOR_6Layout.setVerticalGroup(
            SEPARADOR_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 861, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(21, 21, 21))))
            .addComponent(SEPARADOR_4, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
            .addComponent(SEPARADOR_6, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SEPARADOR_6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SEPARADOR_4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1)
                        .addComponent(jLabel2))
                    .addComponent(txtpropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablitaMouseClicked
        int seleccionar = Tablita.rowAtPoint(evt.getPoint());
        String Nombre = String.valueOf(Tablita.getValueAt(seleccionar, 1));
        String apellidoP = String.valueOf(Tablita.getValueAt(seleccionar, 2));
        String apellidoM = String.valueOf(Tablita.getValueAt(seleccionar, 3));
        txtpropietario.setText(Nombre + " " + apellidoP + " " + apellidoM);
        mandarDatos();
    }//GEN-LAST:event_TablitaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bloquear();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtfiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyTyped

    }//GEN-LAST:event_txtfiltroKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registro.setVisible(true);
        this.dispose();
        limpiarCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroActionPerformed

    }//GEN-LAST:event_txtfiltroActionPerformed

    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
        buscadorTabla.buscarEnTabla(adminPropietario.obtenerModeloTablaPropietarios(Tablita), adminPropietario.obtenerPropietariosArray(), txtfiltro.getText(), "NOMBRE");
    }//GEN-LAST:event_txtfiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SEPARADOR_4;
    private javax.swing.JPanel SEPARADOR_5;
    private javax.swing.JPanel SEPARADOR_6;
    public static javax.swing.JTable Tablita;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtfiltro;
    private javax.swing.JLabel txtpropietario;
    // End of variables declaration//GEN-END:variables
}
