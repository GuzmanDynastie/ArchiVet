package ArchiVet.ventana;

import ArchiVet.Admin.AdminPropietarioMascota;
import ArchiVet.Admin.AdminUsuario;
import ArchiVet.ventana.componente.Buscardor_JTable;
import BD.OBD;
import static ArchiVet.ventana.ventana_pagarCaja.SEX;
import Archivet.Controlador.Filtraciones;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_menu.panel;
import static ArchiVet.ventana.ventana_mostradorCaja.*;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ventana_puntoVenta extends javax.swing.JInternalFrame {

    private AdminPropietarioMascota adminPropietarioMascota;
    private Buscardor_JTable buscadorJTable;
    private ArchiVet.Imagen.imagenes imagen;
    public static ventana_mostradorCaja mostradorCaja;
    private AdminUsuario adminUsuario;

    public static ventana_historialMedico historialMedico;
    public static ventana_aplicarConsulta consulta;
    public static OBD obd;

    public static int seleccionDueno, NumeroID, ID_PET;
    public static double SALDO;
    public static String NAME_PET;
    public Image logoCuenta;


    private void entrarHistorial() {
        if (Nombre_Seleccionado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede acceder con campos vacios");
        } else {
            try {

                Fondo.add(historialMedico);
                historialMedico.setVisible(true);
                historialMedico.setLocation(0, 0);
                this.setVisible(false);

                historialMedico.Propietario.setText(Nombre_Seleccionado.getText().trim());
                historialMedico.Mascota.setText(NAME_PET.trim());
                
                historialMedico.CargarTablaVacuna();
                historialMedico.CargarTablaDesparacitar();
                obd.tablaConsultas(historialMedico.Previos, NAME_PET);
                
                consulta.mascota=NAME_PET;
                consulta.IDMASCOTA=ID_PET;
                consulta.IDPROPIETARIO=NumeroID;

            } catch (IllegalStateException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void entrarCaja() {
        if (Nombre_Seleccionado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede acceder con campos vacios");
        } else {
            try {

                Fondo.add(mostradorCaja);
                mostradorCaja.setVisible(true);
                mostradorCaja.setLocation(0, 0);
                this.setVisible(false);

                ventana_mostradorCaja.Nombre_Usuario_Cuenta.setText(Nombre_Seleccionado.getText().trim());
                ventana_mostradorCaja.Nombre_Usuario_Historial.setText(Nombre_Seleccionado.getText().trim());
                ventana_mostradorCaja.Buscador_Mascota.setText(NAME_PET.trim());

                Descripcion_Area.setText("");

                Filtraciones.cargarGastos_Mascota(NumeroID, ID_PET, Descripcion_Area);
                Filtraciones.cargarSuma_Total(NumeroID, ID_PET, Total_Cuenta, PAGO);
                SALDO = Double.parseDouble(Total_Cuenta.getText());
                Filtraciones.cargarHistorial_Ventas(NumeroID, ID_PET, Tabla_Historial);

                DefaultTableModel D = (DefaultTableModel) Tabla_PRODUCTOS_ADD.getModel();
                while (Tabla_PRODUCTOS_ADD.getRowCount() > 0) {
                    D.removeRow(0);
                }
            } catch (SQLException | ExceptionInInitializerError | IllegalArgumentException | IllegalAccessError | IllegalCallerException | IllegalMonitorStateException | IllegalStateException ex) {
            }
        }
    }

    private void tablaCuenta(java.awt.event.MouseEvent evt) {
        try {
            seleccionDueno = Tabla_Cuenta.rowAtPoint(evt.getPoint());

            ID_PET = Integer.parseInt(String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 8)));
            NumeroID = Integer.parseInt(String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 0)));

            SEX = String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 6));

            String nombre = String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 1));
            String apellidoP = String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 2));
            String apellidoM = String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 3));

            NAME_PET = String.valueOf(Tabla_Cuenta.getValueAt(seleccionDueno, 4));

            Nombre_Seleccionado.setText(nombre + " " + apellidoP + " " + apellidoM);

        } catch (NumberFormatException | NullPointerException e) {
        }
    }

    public ventana_puntoVenta(AdminUsuario adminUsuario) {

        try {
            initComponents();
            this.adminUsuario = adminUsuario;
            historialMedico = new ventana_historialMedico(adminUsuario);
            mostradorCaja = new ventana_mostradorCaja(adminUsuario);

            obd = new OBD();
            buscadorJTable = new Buscardor_JTable();
            adminPropietarioMascota = new AdminPropietarioMascota();
            imagen = new ArchiVet.Imagen.imagenes();
            adminPropietarioMascota.obtenerModeloTablaPropietariosMascotas(Tabla_Cuenta);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CONTENIDO_1 = new javax.swing.JPanel();
        CONTENIDO_2 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(logoCuenta,0,0,getWidth(),getHeight(),this);
            }
        };
        Titulo = new javax.swing.JLabel();
        Cerrar_ventana = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel6 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.usuario,0,0,getWidth(),getHeight(),this);
            }
        };
        Nombre_Dueno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.mascotas3,0,0,getWidth(),getHeight(),this);
            }
        };
        Nombre_MASCOTA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Nombre_Seleccionado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Cuenta = new javax.swing.JTable();
        Correcto = new javax.swing.JButton();
        SEPARADOR_3 = new javax.swing.JPanel();
        SEPARADOR_4 = new javax.swing.JPanel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 750));

        CONTENIDO_1.setBackground(new java.awt.Color(47, 69, 56));

        CONTENIDO_2.setBackground(new java.awt.Color(215, 208, 183));

        Logo.setMaximumSize(new java.awt.Dimension(75, 75));
        Logo.setMinimumSize(new java.awt.Dimension(75, 75));
        Logo.setName(""); // NOI18N
        Logo.setPreferredSize(new java.awt.Dimension(75, 75));

        Titulo.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        Titulo.setPreferredSize(new java.awt.Dimension(100, 50));

        Cerrar_ventana.setMaximumSize(new java.awt.Dimension(50, 50));
        Cerrar_ventana.setMinimumSize(new java.awt.Dimension(50, 50));
        Cerrar_ventana.setPreferredSize(new java.awt.Dimension(50, 50));
        Cerrar_ventana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cerrar_ventanaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CONTENIDO_2Layout = new javax.swing.GroupLayout(CONTENIDO_2);
        CONTENIDO_2.setLayout(CONTENIDO_2Layout);
        CONTENIDO_2Layout.setHorizontalGroup(
            CONTENIDO_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENIDO_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cerrar_ventana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        CONTENIDO_2Layout.setVerticalGroup(
            CONTENIDO_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENIDO_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar_ventana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CONTENIDO_2Layout.createSequentialGroup()
                .addGroup(CONTENIDO_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));

        Nombre_Dueno.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_Dueno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nombre_DuenoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Nombre_DuenoFocusLost(evt);
            }
        });
        Nombre_Dueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_DuenoActionPerformed(evt);
            }
        });
        Nombre_Dueno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nombre_DuenoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre_DuenoKeyTyped(evt);
            }
        });

        jLabel8.setPreferredSize(new java.awt.Dimension(50, 50));

        Nombre_MASCOTA.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_MASCOTA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nombre_MASCOTAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Nombre_MASCOTAFocusLost(evt);
            }
        });
        Nombre_MASCOTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_MASCOTAActionPerformed(evt);
            }
        });
        Nombre_MASCOTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nombre_MASCOTAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre_MASCOTAKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usted selecciono el cliente: ");

        Nombre_Seleccionado.setEditable(false);
        Nombre_Seleccionado.setBackground(new java.awt.Color(47, 69, 56));
        Nombre_Seleccionado.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_Seleccionado.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Seleccionado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Nombre_Seleccionado.setBorder(null);
        Nombre_Seleccionado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Nombre_Seleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_SeleccionadoActionPerformed(evt);
            }
        });

        Tabla_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 71)));
        Tabla_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Cuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mascota", "Raza", "Nombre dueño", "Apellido paterno", "Correo", "Telefono", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Cuenta.setToolTipText("");
        Tabla_Cuenta.setAutoscrolls(false);
        Tabla_Cuenta.setRowHeight(35);
        Tabla_Cuenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CuentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Cuenta);

        Correcto.setBackground(new java.awt.Color(155, 155, 155));
        Correcto.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Correcto.setText("Correcto");
        Correcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrectoActionPerformed(evt);
            }
        });

        SEPARADOR_3.setBackground(new java.awt.Color(204, 204, 0));
        SEPARADOR_3.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout SEPARADOR_3Layout = new javax.swing.GroupLayout(SEPARADOR_3);
        SEPARADOR_3.setLayout(SEPARADOR_3Layout);
        SEPARADOR_3Layout.setHorizontalGroup(
            SEPARADOR_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        SEPARADOR_3Layout.setVerticalGroup(
            SEPARADOR_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        SEPARADOR_4.setBackground(new java.awt.Color(204, 204, 0));
        SEPARADOR_4.setPreferredSize(new java.awt.Dimension(917, 3));

        javax.swing.GroupLayout SEPARADOR_4Layout = new javax.swing.GroupLayout(SEPARADOR_4);
        SEPARADOR_4.setLayout(SEPARADOR_4Layout);
        SEPARADOR_4Layout.setHorizontalGroup(
            SEPARADOR_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        SEPARADOR_4Layout.setVerticalGroup(
            SEPARADOR_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout CONTENIDO_1Layout = new javax.swing.GroupLayout(CONTENIDO_1);
        CONTENIDO_1.setLayout(CONTENIDO_1Layout);
        CONTENIDO_1Layout.setHorizontalGroup(
            CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CONTENIDO_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CONTENIDO_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(CONTENIDO_1Layout.createSequentialGroup()
                        .addGroup(CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CONTENIDO_1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(Nombre_Seleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CONTENIDO_1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nombre_Dueno, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nombre_MASCOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(Correcto)))
                .addContainerGap())
            .addComponent(SEPARADOR_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addComponent(SEPARADOR_3, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        CONTENIDO_1Layout.setVerticalGroup(
            CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENIDO_1Layout.createSequentialGroup()
                .addComponent(CONTENIDO_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SEPARADOR_4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_MASCOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_Dueno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(SEPARADOR_3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CONTENIDO_1Layout.createSequentialGroup()
                        .addGroup(CONTENIDO_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre_Seleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONTENIDO_1Layout.createSequentialGroup()
                        .addComponent(Correcto)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CONTENIDO_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CONTENIDO_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nombre_DuenoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_DuenoFocusGained

    }//GEN-LAST:event_Nombre_DuenoFocusGained

    private void Nombre_DuenoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_DuenoFocusLost

    }//GEN-LAST:event_Nombre_DuenoFocusLost

    private void Nombre_DuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_DuenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_DuenoActionPerformed

    private void Nombre_DuenoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_DuenoKeyReleased
        buscadorJTable.buscarEnTabla(adminPropietarioMascota.obtenerModeloTablaPropietariosMascotas(Tabla_Cuenta), adminPropietarioMascota.obtenerPropietariosMascotasArray(), Nombre_Dueno.getText(), "NOMBRE");
    }//GEN-LAST:event_Nombre_DuenoKeyReleased

    private void Nombre_DuenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_DuenoKeyTyped

    }//GEN-LAST:event_Nombre_DuenoKeyTyped

    private void Tabla_CuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CuentaMouseClicked
        tablaCuenta(evt);
    }//GEN-LAST:event_Tabla_CuentaMouseClicked

    private void Nombre_SeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_SeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_SeleccionadoActionPerformed

    private void CorrectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrectoActionPerformed
        if (Titulo.getText().equals("Cuenta")) {
            entrarCaja();
        } else if (Titulo.getText().equals("Historial")) {
            entrarHistorial();
        }
    }//GEN-LAST:event_CorrectoActionPerformed

    private void Cerrar_ventanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cerrar_ventanaMouseClicked
        ventana_menu.FondoBotones.setVisible(true);
        ventana_menu.cerrar.setVisible(true);
        this.dispose();
        panel.setVisible(true);
    }//GEN-LAST:event_Cerrar_ventanaMouseClicked

    private void Nombre_MASCOTAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_MASCOTAFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_MASCOTAFocusGained

    private void Nombre_MASCOTAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_MASCOTAFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_MASCOTAFocusLost

    private void Nombre_MASCOTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_MASCOTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_MASCOTAActionPerformed

    private void Nombre_MASCOTAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_MASCOTAKeyReleased
        buscadorJTable.buscarEnTabla(adminPropietarioMascota.obtenerModeloTablaPropietariosMascotas(Tabla_Cuenta), adminPropietarioMascota.obtenerPropietariosMascotasArray(), Nombre_MASCOTA.getText(), "MASCOTA");
    }//GEN-LAST:event_Nombre_MASCOTAKeyReleased

    private void Nombre_MASCOTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_MASCOTAKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_MASCOTAKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CONTENIDO_1;
    private javax.swing.JPanel CONTENIDO_2;
    private javax.swing.JLabel Cerrar_ventana;
    public static javax.swing.JButton Correcto;
    private javax.swing.JLabel Logo;
    public static javax.swing.JTextField Nombre_Dueno;
    public static javax.swing.JTextField Nombre_MASCOTA;
    public static javax.swing.JTextField Nombre_Seleccionado;
    private javax.swing.JPanel SEPARADOR_3;
    private javax.swing.JPanel SEPARADOR_4;
    public static javax.swing.JTable Tabla_Cuenta;
    public static javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
