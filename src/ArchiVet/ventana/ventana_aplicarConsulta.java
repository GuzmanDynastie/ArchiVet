package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.Modelo.Usuario;
import BD.OBD;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JComponent;

public class ventana_aplicarConsulta extends javax.swing.JInternalFrame {

    private Usuario usuario;
    private ArchiVet.Imagen.imagenes imagen;
    private BD.OBD obd;
    private Date Actual = new Date();
    private long longActual = Actual.getTime();
    private java.sql.Date Fecha = new java.sql.Date(longActual);
    private JComponent Barra;
    private Dimension dimBarra;
    public static int IDMASCOTA, IDPROPIETARIO;
    public static String mascota, propietario;
    private AdminUsuario adminUsuario;

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    public void mostrarcomponentes() {
        ventana_historialMedico.ScrollMotivo.setVisible(true);
        ventana_historialMedico.ScrollDiagnostico.setVisible(true);
        ventana_historialMedico.ScrollReceta.setVisible(true);
        ventana_historialMedico.ScrollHistorialConsultas.setVisible(true);
        //ventana_historialMedico.Precio.setVisible(true);
        //ventana_historialMedico.lPrecio.setVisible(true);
        ventana_historialMedico.agregarconsulta.setVisible(true);
        //ventana_historialMedico.MAS1.setVisible(true);
        //ventana_historialMedico.MAS2.setVisible(true);
        ventana_historialMedico.historial1.setEnabled(true);
        ventana_historialMedico.cerrar.setVisible(true);
    }

    private void limpiar() {
        Motivo.setText("");
        Diagnostico.setText("");
        Receta.setText("");
        Precio.setText("");
    }

    private void subir() {
        obd.subirConsulta(IDMASCOTA, mascota, Fecha, "Consulta", Float.parseFloat(Precio.getText()), Motivo.getText(), Diagnostico.getText(), Receta.getText(), Peso.getText(), IDPROPIETARIO, adminUsuario.dameListaUsuarios());
        obd.historial(IDMASCOTA, mascota, "Macho", "Consulta", Float.parseFloat(Precio.getText()), Motivo.getText(), IDPROPIETARIO);
        obd.tablaConsultas(ventana_historialMedico.HistorialConsultas, mascota);
        System.out.println(IDMASCOTA + " - " + IDPROPIETARIO);
        limpiar();
        mostrarcomponentes();
    }

    public ventana_aplicarConsulta(AdminUsuario adminUsuario) {
        initComponents();
        this.adminUsuario = adminUsuario;
        ocultarBarraTitulo();
        imagen = new ArchiVet.Imagen.imagenes();
        usuario = new Usuario();
        obd = new OBD();
        adminUsuario = new AdminUsuario();
        Motivo.setLineWrap(true);
        Diagnostico.setLineWrap(true);
        Receta.setLineWrap(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        lMotivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Motivo = new javax.swing.JTextArea();
        lDiagnostico = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Diagnostico = new javax.swing.JTextArea();
        lReceta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Receta = new javax.swing.JTextArea();
        lPrecio = new javax.swing.JLabel();
        Guardar = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.gua,0,0,getWidth(),getHeight(),this);
            }
        };
        Precio = new javax.swing.JTextField();
        Peso = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(1796, 978));
        setMinimumSize(new java.awt.Dimension(1796, 978));
        setPreferredSize(new java.awt.Dimension(1796, 978));

        Fondo.setBackground(new java.awt.Color(47, 69, 56));

        lMotivo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lMotivo.setForeground(new java.awt.Color(255, 255, 255));
        lMotivo.setText("Motivo de consulta");

        Motivo.setColumns(20);
        Motivo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Motivo.setRows(5);
        Motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane1.setViewportView(Motivo);

        lDiagnostico.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lDiagnostico.setForeground(new java.awt.Color(255, 255, 255));
        lDiagnostico.setText("Diagnostico");

        Diagnostico.setColumns(20);
        Diagnostico.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Diagnostico.setRows(5);
        Diagnostico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane3.setViewportView(Diagnostico);

        lReceta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lReceta.setForeground(new java.awt.Color(255, 255, 255));
        lReceta.setText("Receta");

        Receta.setColumns(20);
        Receta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Receta.setRows(5);
        Receta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane2.setViewportView(Receta);

        lPrecio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lPrecio.setText("Precio");

        Guardar.setMaximumSize(new java.awt.Dimension(75, 75));
        Guardar.setMinimumSize(new java.awt.Dimension(75, 75));
        Guardar.setOpaque(true);
        Guardar.setPreferredSize(new java.awt.Dimension(75, 75));
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarMouseClicked(evt);
            }
        });

        Precio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Precio.setMaximumSize(new java.awt.Dimension(150, 35));
        Precio.setMinimumSize(new java.awt.Dimension(150, 35));
        Precio.setPreferredSize(new java.awt.Dimension(150, 35));

        Peso.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lDiagnostico)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(lReceta)
                        .addGap(741, 741, 741))
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(FondoLayout.createSequentialGroup()
                                    .addGap(104, 104, 104)
                                    .addComponent(lPrecio)
                                    .addGap(17, 17, 17))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Peso))
                                    .addGap(146, 146, 146)))))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lReceta))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(lPrecio)
                                .addGap(18, 18, 18)
                                .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(lDiagnostico)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        subir();
        this.dispose();
    }//GEN-LAST:event_GuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Diagnostico;
    private javax.swing.JPanel Fondo;
    public static javax.swing.JLabel Guardar;
    private javax.swing.JTextArea Motivo;
    private javax.swing.JTextField Peso;
    private javax.swing.JTextField Precio;
    private javax.swing.JTextArea Receta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lDiagnostico;
    private javax.swing.JLabel lMotivo;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JLabel lReceta;
    // End of variables declaration//GEN-END:variables
}
