package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.Modelo.Usuario;
import static ArchiVet.ventana.ventana_historialMedico.Mascota;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import static ArchiVet.ventana.ventana_historialMedico.TVacunas;
import javax.swing.table.DefaultTableModel;

public class ventana_aplicarVacuna extends javax.swing.JFrame {

    private static AdminUsuario adminUsuario;

    BD.OBD obd = new BD.OBD();
    ArchiVet.Imagen.imagenes imagen = new ArchiVet.Imagen.imagenes();

    public void Limpiar() {
        Descripcion.setSelectedIndex(0);
        Lote.setText("");
        Precio.setText("");
    }

    void CargarTablaVacuna() {
        DefaultTableModel mode = (DefaultTableModel) TVacunas.getModel();
        mode.setRowCount(0);
        obd.tablaVacunasapli(TVacunas, mode, Mascota.getText());
    }

    public void verificar() {
        if (!(Lote.getText().isEmpty() || Precio.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Se ha guardado con exito", "Guardado", JOptionPane.DEFAULT_OPTION);
            long fec = Aplicacion.getDate().getTime();
            java.sql.Date fech = new java.sql.Date(fec);
            obd.aplivacunas(fech, Descripcion.getSelectedItem().toString(), Lote.getText(), Double.valueOf(Precio.getText()), Mascota.getText(), adminUsuario.dameListaUsuarios().replaceAll("\\[|\\]", ""));
            Limpiar();
            CargarTablaVacuna();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha guardado\nVerifique los campos", "Error", JOptionPane.DEFAULT_OPTION);
        }
    }
    
    private void nombreMedico(Usuario usuario) {
        
    }

    public ventana_aplicarVacuna(AdminUsuario adminUsuario) {
        initComponents();
        this.adminUsuario = adminUsuario;

        System.out.println(adminUsuario.dameListaUsuarios());
        
        obd.combovacu(Descripcion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Lote = new javax.swing.JTextField();
        Precio = new javax.swing.JTextField();
        ldescripcion = new javax.swing.JLabel();
        llote = new javax.swing.JLabel();
        lprecio = new javax.swing.JLabel();
        Aplicacion = new com.toedter.calendar.JDateChooser();
        laplicacion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Cerrar1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        Guardar = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.guardar,0,0,getWidth(),getHeight(),this);
            }
        };
        Descripcion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(448, 370));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(47, 69, 56));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(215, 208, 183)));
        jPanel2.setMaximumSize(new java.awt.Dimension(494, 470));
        jPanel2.setMinimumSize(new java.awt.Dimension(494, 470));

        Lote.setEditable(false);
        Lote.setBackground(new java.awt.Color(47, 69, 56));
        Lote.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Lote.setForeground(new java.awt.Color(255, 255, 255));
        Lote.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(250, 240, 230)));
        Lote.setMaximumSize(new java.awt.Dimension(64, 28));
        Lote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoteMouseClicked(evt);
            }
        });

        Precio.setEditable(false);
        Precio.setBackground(new java.awt.Color(47, 69, 56));
        Precio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Precio.setForeground(new java.awt.Color(255, 255, 255));
        Precio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(250, 240, 230)));
        Precio.setMaximumSize(new java.awt.Dimension(64, 28));

        ldescripcion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ldescripcion.setForeground(new java.awt.Color(255, 255, 255));
        ldescripcion.setText("Descripción");

        llote.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        llote.setForeground(new java.awt.Color(255, 255, 255));
        llote.setText("Lote");

        lprecio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lprecio.setForeground(new java.awt.Color(255, 255, 255));
        lprecio.setText("Precio");

        Aplicacion.setBackground(new java.awt.Color(47, 69, 56));
        Aplicacion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(250, 240, 230)));
        Aplicacion.setForeground(new java.awt.Color(255, 255, 255));
        Aplicacion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Aplicacion.setMaxSelectableDate(new java.util.Date(1767164470000L));
        Aplicacion.setMaximumSize(new java.awt.Dimension(82, 34));
        Aplicacion.setMinSelectableDate(new java.util.Date(1577862118000L));

        laplicacion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        laplicacion.setForeground(new java.awt.Color(255, 255, 255));
        laplicacion.setText("Aplicacion");

        jPanel3.setBackground(new java.awt.Color(215, 208, 183));

        Cerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cerrar1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel2.setText("Vacuna");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(164, 164, 164)
                .addComponent(Cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        Guardar.setPreferredSize(new java.awt.Dimension(75, 75));
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarMouseClicked(evt);
            }
        });

        Descripcion.setBackground(new java.awt.Color(47, 69, 56));
        Descripcion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Descripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        Descripcion.setMaximumSize(new java.awt.Dimension(72, 32));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(laplicacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(lprecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ldescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(llote, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laplicacion)
                    .addComponent(Aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ldescripcion)
                    .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llote)
                    .addComponent(Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lprecio)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        verificar();
    }//GEN-LAST:event_GuardarMouseClicked

    private void Cerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cerrar1MouseClicked
        try {
            Limpiar();
            this.dispose();
        } catch (Exception exception) {

        }
    }//GEN-LAST:event_Cerrar1MouseClicked

    private void LoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoteMouseClicked
        obd.datvacunas(Descripcion.getSelectedItem().toString(), Lote, Precio);
    }//GEN-LAST:event_LoteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Aplicacion;
    private javax.swing.JLabel Cerrar1;
    private javax.swing.JComboBox<String> Descripcion;
    private javax.swing.JLabel Guardar;
    private javax.swing.JTextField Lote;
    private javax.swing.JTextField Precio;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel laplicacion;
    private javax.swing.JLabel ldescripcion;
    private javax.swing.JLabel llote;
    private javax.swing.JLabel lprecio;
    // End of variables declaration//GEN-END:variables
}
