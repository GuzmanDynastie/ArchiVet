package ArchiVet.ventana;

import ArchiVet.Admin.AdminDesparacitante;
import ArchiVet.Admin.AdminMedicamento;
import ArchiVet.Admin.AdminVacuna;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static ArchiVet.ventana.ventana_menu.panel;
import java.awt.Graphics;
import java.sql.SQLException;

public class ventana_inventarios extends javax.swing.JInternalFrame {

    private AdminVacuna adminVacuna;
    private AdminDesparacitante adminDesparacitante;
    private AdminMedicamento adminMedicamento;
    private ArchiVet.Imagen.imagenes imagen;

    public ventana_inventarios() throws SQLException {
        initComponents();
        imagen = new ArchiVet.Imagen.imagenes();
        adminVacuna = new AdminVacuna();
        adminDesparacitante = new AdminDesparacitante();
        adminMedicamento = new AdminMedicamento();
        iconoAgregar.setToolTipText("AGREGAR");
        iconoAgregar1.setToolTipText("AGREGAR");
        iconoAgregar2.setToolTipText("AGREGAR");

        adminVacuna.obtenerModeloTablaVacunas(Tabla_Vacunas);
        adminDesparacitante.obtenerModeloTablaDesparacitantes(Tabla_Desparacitantes);
        adminMedicamento.obtenerModeloTablaMedicamentos(Tabla_Medicamentos);

        Font myFont2 = new Font("Arial", Font.CENTER_BASELINE, 20);
        Inventarios.setFont(myFont2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        iconoInventario = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Inventario2,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        icono_cerrarVentana = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };
        Inventarios = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Vacunas = new javax.swing.JTable();
        iconoAgregar = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Agregar_Producto,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_Medicamentos = new javax.swing.JTable();
        iconoAgregar2 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Agregar_Producto,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Desparacitantes = new javax.swing.JTable();
        iconoAgregar1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Agregar_Producto,0,0,getWidth(),getHeight(),this);
            }
        };

        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(47, 69, 56));

        jPanel2.setBackground(new java.awt.Color(215, 208, 183));

        iconoInventario.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel1.setText("Inventario");

        icono_cerrarVentana.setPreferredSize(new java.awt.Dimension(50, 50));
        icono_cerrarVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono_cerrarVentanaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(826, 826, 826)
                .addComponent(icono_cerrarVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icono_cerrarVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Inventarios.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Inventarios.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Inventarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventariosMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(47, 69, 56));
        jPanel6.setForeground(new java.awt.Color(242, 242, 242));

        Tabla_Vacunas.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 9, 70)));
        Tabla_Vacunas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Vacunas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Lote", "Cantidad", "Precio", "Caducidad", "Borrar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Vacunas.setRowHeight(35);
        Tabla_Vacunas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Vacunas.getTableHeader().setResizingAllowed(false);
        Tabla_Vacunas.getTableHeader().setReorderingAllowed(false);
        Tabla_Vacunas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_VacunasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Vacunas);
        if (Tabla_Vacunas.getColumnModel().getColumnCount() > 0) {
            Tabla_Vacunas.getColumnModel().getColumn(0).setResizable(false);
            Tabla_Vacunas.getColumnModel().getColumn(0).setPreferredWidth(10);
            Tabla_Vacunas.getColumnModel().getColumn(1).setResizable(false);
            Tabla_Vacunas.getColumnModel().getColumn(1).setPreferredWidth(10);
            Tabla_Vacunas.getColumnModel().getColumn(2).setResizable(false);
            Tabla_Vacunas.getColumnModel().getColumn(2).setPreferredWidth(10);
            Tabla_Vacunas.getColumnModel().getColumn(3).setResizable(false);
            Tabla_Vacunas.getColumnModel().getColumn(3).setPreferredWidth(10);
            Tabla_Vacunas.getColumnModel().getColumn(4).setResizable(false);
            Tabla_Vacunas.getColumnModel().getColumn(4).setPreferredWidth(10);
            Tabla_Vacunas.getColumnModel().getColumn(5).setResizable(false);
            Tabla_Vacunas.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        iconoAgregar.setPreferredSize(new java.awt.Dimension(50, 50));
        iconoAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoAgregarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1729, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        Inventarios.addTab("Vacunas", jPanel6);

        jPanel8.setBackground(new java.awt.Color(47, 69, 56));

        Tabla_Medicamentos.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Tabla_Medicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Lote", "Cantidad", "Precio", "Caducidad", "Borrar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Medicamentos.setRowHeight(35);
        Tabla_Medicamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Medicamentos.getTableHeader().setResizingAllowed(false);
        Tabla_Medicamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Tabla_Medicamentos);
        if (Tabla_Medicamentos.getColumnModel().getColumnCount() > 0) {
            Tabla_Medicamentos.getColumnModel().getColumn(0).setResizable(false);
            Tabla_Medicamentos.getColumnModel().getColumn(1).setResizable(false);
            Tabla_Medicamentos.getColumnModel().getColumn(2).setResizable(false);
            Tabla_Medicamentos.getColumnModel().getColumn(3).setResizable(false);
            Tabla_Medicamentos.getColumnModel().getColumn(4).setResizable(false);
            Tabla_Medicamentos.getColumnModel().getColumn(5).setResizable(false);
        }

        iconoAgregar2.setPreferredSize(new java.awt.Dimension(50, 50));
        iconoAgregar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoAgregar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1729, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        Inventarios.addTab("Medicamentos", jPanel8);

        jPanel7.setBackground(new java.awt.Color(47, 69, 56));

        Tabla_Desparacitantes.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Desparacitantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Lote", "Cantidad", "Precio", "Caducidad", "Borrar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Desparacitantes.setRowHeight(35);
        Tabla_Desparacitantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Desparacitantes.getTableHeader().setResizingAllowed(false);
        Tabla_Desparacitantes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Tabla_Desparacitantes);
        if (Tabla_Desparacitantes.getColumnModel().getColumnCount() > 0) {
            Tabla_Desparacitantes.getColumnModel().getColumn(0).setResizable(false);
            Tabla_Desparacitantes.getColumnModel().getColumn(1).setResizable(false);
            Tabla_Desparacitantes.getColumnModel().getColumn(2).setResizable(false);
            Tabla_Desparacitantes.getColumnModel().getColumn(3).setResizable(false);
            Tabla_Desparacitantes.getColumnModel().getColumn(4).setResizable(false);
            Tabla_Desparacitantes.getColumnModel().getColumn(5).setResizable(false);
        }

        iconoAgregar1.setPreferredSize(new java.awt.Dimension(50, 50));
        iconoAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoAgregar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1729, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        Inventarios.addTab("Desparacitantes", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Inventarios)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inventarios)
                .addContainerGap())
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

    private void icono_cerrarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_cerrarVentanaMouseClicked
        ventana_menu.FondoBotones.setVisible(true);
        ventana_menu.cerrar.setVisible(true);
        this.dispose();
        panel.setVisible(true);
    }//GEN-LAST:event_icono_cerrarVentanaMouseClicked

    private void Tabla_VacunasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_VacunasMouseClicked
        int columna = Tabla_Vacunas.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / Tabla_Vacunas.getRowHeight();

        if (fila < Tabla_Vacunas.getRowCount() && fila >= 0 && columna < Tabla_Vacunas.getColumnCount() && columna >= 0) {
            Object value = Tabla_Vacunas.getValueAt(fila, columna);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equalsIgnoreCase("E")) {
                    JOptionPane.showMessageDialog(null, "Este boton es de Eliminar");
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
    }//GEN-LAST:event_Tabla_VacunasMouseClicked

    private void iconoAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoAgregarMouseClicked
        ventana_inventarioVacuna interVac = new ventana_inventarioVacuna();
        interVac.setVisible(true);
    }//GEN-LAST:event_iconoAgregarMouseClicked

    private void iconoAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoAgregar1MouseClicked
        ventana_inventarioDesparacitante invDes = new ventana_inventarioDesparacitante();
        invDes.setVisible(true);
    }//GEN-LAST:event_iconoAgregar1MouseClicked

    private void iconoAgregar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoAgregar2MouseClicked
        ventana_inventarioMedicamento invMed = new ventana_inventarioMedicamento();
        invMed.setVisible(true);
    }//GEN-LAST:event_iconoAgregar2MouseClicked

    private void InventariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventariosMouseClicked
        try {
            adminVacuna.obtenerModeloTablaVacunas(Tabla_Vacunas);
            adminDesparacitante.obtenerModeloTablaDesparacitantes(Tabla_Desparacitantes);
            adminMedicamento.obtenerModeloTablaMedicamentos(Tabla_Medicamentos);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_InventariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane Inventarios;
    public static javax.swing.JTable Tabla_Desparacitantes;
    public static javax.swing.JTable Tabla_Medicamentos;
    public static javax.swing.JTable Tabla_Vacunas;
    private javax.swing.JLabel iconoAgregar;
    private javax.swing.JLabel iconoAgregar1;
    private javax.swing.JLabel iconoAgregar2;
    private javax.swing.JLabel iconoInventario;
    private javax.swing.JLabel icono_cerrarVentana;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
