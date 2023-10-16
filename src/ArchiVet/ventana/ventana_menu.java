package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.ventana.componente.FondoBotones;
import java.awt.Color;
import java.awt.Graphics;
import ArchiVet.ventana.componente.RoundedBorder;
import java.sql.SQLException;

public class ventana_menu extends javax.swing.JFrame {

    public static FondoBotones panel;
    private ventana_inventarios inventarios;
    private ventana_registroMedico mediRegi;
    private ArchiVet.Imagen.imagenes imagen;
    public static ventana_agendarCitas citas;
    public static ventana_registroMascotaPropietario registro;
    private AdminUsuario adminUsuario;

    public void bloquear() {
        ingresoMascota.setEnabled(false);
        busqueda.setEnabled(false);
        inventario.setEnabled(false);
        caja.setEnabled(false);
        ingresoMedicos.setEnabled(false);
        cerrar.setEnabled(false);
    }

    public void invisible() {
        FondoBotones.setVisible(false);
        cerrar.setVisible(false);
    }

    private void panelMenu() {
        panel.setOpaque(false);
        panel.setBounds(50, 50, 650, 125);
        panel.setBorder(new RoundedBorder(60, 2, Color.WHITE)); // Borde redondeado personalizado
        panel.setLocation(640, 925);
        Fondo.add(panel);
    }

    private void setToolTipText() {
        ingresoMascota.setToolTipText("Registro Mascota");
        busqueda.setToolTipText("Historial Clinico");
        inventario.setToolTipText("Inventario");
        caja.setToolTipText("Pagos");
        ingresoMedicos.setToolTipText("Registro Medicos");
        calen.setToolTipText("Agendar Cita");
        cerrar.setToolTipText("Cerrar");
    }

    public ventana_menu(AdminUsuario adminUsuario) throws SQLException {
        initComponents();

        FondoBotones.setOpaque(false);
        this.adminUsuario = adminUsuario;
        panel = new FondoBotones();
        inventarios = new ventana_inventarios();
        mediRegi = new ventana_registroMedico();
        imagen = new ArchiVet.Imagen.imagenes();
        citas = new ventana_agendarCitas();
        registro = new ventana_registroMascotaPropietario();

        panelMenu();
        setToolTipText();

        setIconImage(imagen.logo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.fondo,0,0,getWidth(),getHeight(),this);
            }
        };
        cerrar = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cer1,0,0,getWidth(),getHeight(),this);
            }
        };
        FondoBotones = new javax.swing.JPanel();
        ingresoMascota = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.añadirperro,0,0,getWidth(),getHeight(),this);
            }
        };
        busqueda = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.bus1,0,0,getWidth(),getHeight(),this);
            }
        };
        inventario = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.inv1,0,0,getWidth(),getHeight(),this);
            }
        };
        caja = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.pag1,0,0,getWidth(),getHeight(),this);
            }
        };
        ingresoMedicos = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.emp1,0,0,getWidth(),getHeight(),this);
            }
        };
        calen = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cal1,0,0,getWidth(),getHeight(),this);
            }
        };
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Fondo.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Fondo.setMinimumSize(new java.awt.Dimension(1920, 1080));
        Fondo.setPreferredSize(new java.awt.Dimension(1920, 1080));

        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        FondoBotones.setBackground(new java.awt.Color(250, 240, 230));
        FondoBotones.setMaximumSize(new java.awt.Dimension(645, 87));
        FondoBotones.setMinimumSize(new java.awt.Dimension(645, 87));
        FondoBotones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FondoBotonesFocusGained(evt);
            }
        });

        ingresoMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoMascotaMouseClicked(evt);
            }
        });

        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                busquedaMouseClicked(evt);
            }
        });

        inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventarioMouseClicked(evt);
            }
        });

        caja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaMouseClicked(evt);
            }
        });

        ingresoMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoMedicosMouseClicked(evt);
            }
        });

        calen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FondoBotonesLayout = new javax.swing.GroupLayout(FondoBotones);
        FondoBotones.setLayout(FondoBotonesLayout);
        FondoBotonesLayout.setHorizontalGroup(
            FondoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingresoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingresoMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        FondoBotonesLayout.setVerticalGroup(
            FondoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoBotonesLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(FondoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingresoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresoMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(calen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setText("jButton1");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(641, Short.MAX_VALUE)
                .addComponent(FondoBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(529, 529, 529)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(506, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(396, 396, 396)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(FondoBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ingresoMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoMedicosMouseClicked
        mediRegi.setVisible(true);
        invisible();
        panel.setVisible(false);
    }//GEN-LAST:event_ingresoMedicosMouseClicked

    private void cajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaMouseClicked
        ventana_puntoVenta cuenta = new ventana_puntoVenta(adminUsuario);
        ventana_puntoVenta.Titulo.setText("Cuenta");
        cuenta.logoCuenta = imagen.recibo;
        Fondo.add(cuenta);
        cuenta.setLocation(310, 180);
        cuenta.show();
        panel.setVisible(false);
        invisible();
    }//GEN-LAST:event_cajaMouseClicked

    private void inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventarioMouseClicked
        Fondo.add(inventarios);
        inventarios.show();
        invisible();
        panel.setVisible(false);
    }//GEN-LAST:event_inventarioMouseClicked

    private void busquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_busquedaMouseClicked
        ventana_puntoVenta cuenta = new ventana_puntoVenta(adminUsuario);
        ventana_puntoVenta.Titulo.setText("Historial");
        cuenta.logoCuenta = imagen.historial;
        Fondo.add(cuenta);
        cuenta.setLocation(310, 180);
        cuenta.show();
        invisible();
        panel.setVisible(false);
    }//GEN-LAST:event_busquedaMouseClicked

    private void ingresoMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoMascotaMouseClicked
        Fondo.add(registro);
        registro.setVisible(true);
        registro.setLocation(390, 150);
        invisible();
        panel.setVisible(false);
    }//GEN-LAST:event_ingresoMascotaMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void FondoBotonesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FondoBotonesFocusGained

    }//GEN-LAST:event_FondoBotonesFocusGained

    private void calenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenMouseClicked
        Fondo.add(citas);
        citas.setVisible(true);
        citas.setLocation(0, 0);
        //Filtraciones.Citas_Agendadas(CitasA);

        invisible();
        panel.setVisible(false);
    }//GEN-LAST:event_calenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Fondo;
    public static javax.swing.JPanel FondoBotones;
    private javax.swing.JLabel busqueda;
    private javax.swing.JLabel caja;
    private javax.swing.JLabel calen;
    public static javax.swing.JLabel cerrar;
    public static javax.swing.JLabel ingresoMascota;
    private javax.swing.JLabel ingresoMedicos;
    private javax.swing.JLabel inventario;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
