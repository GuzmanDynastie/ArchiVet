package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.Modelo.Usuario;
import ArchiVet.ventana.componente.FondoBotones;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class ventana_iniciarSesion extends javax.swing.JFrame {

    private AdminUsuario adminUsuario;
    private ArchiVet.Imagen.imagenes imagen;
    private ventana_menu inicio;
    //public static FondoBotones panel = new FondoBotones();

    private void LimLog() {
        usuarion.setText("Ingrese su usuario");
        contraseñan.setText("********");
    }

    private void verifica() {
        String usuario = usuarion.getText();
        String contrasenia = contraseñan.getText();

        if (usuario.isEmpty() || contrasenia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos de manera correcta");
        } else if (adminUsuario.ingresarDataBase(new Usuario(usuario, contrasenia))) {
            adminUsuario.agregarUsuario(usuario);

            JOptionPane.showMessageDialog(null, "Bienvenido");
            LimLog();
            inicio.setEnabled(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
        }
    }

    public ventana_iniciarSesion() {
        initComponents();
        adminUsuario = new AdminUsuario();
        imagen = new ArchiVet.Imagen.imagenes();
        inicio = new ventana_menu(adminUsuario);
        inicio.setVisible(true);
        inicio.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JPanel();
        Salir = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };
        logo = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.logo,0,0,getWidth(),getHeight(),this);
            }
        };
        usuariom = new javax.swing.JLabel();
        usuarion = new javax.swing.JTextField();
        contraseñam = new javax.swing.JLabel();
        contraseñan = new javax.swing.JPasswordField();
        botony = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Back.setBackground(new java.awt.Color(47, 69, 56));
        Back.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(215, 208, 183)));

        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });

        usuariom.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        usuariom.setForeground(new java.awt.Color(215, 208, 183));
        usuariom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuariom.setText("Usuario");
        usuariom.setMaximumSize(new java.awt.Dimension(162, 30));
        usuariom.setMinimumSize(new java.awt.Dimension(162, 30));
        usuariom.setPreferredSize(new java.awt.Dimension(162, 30));

        usuarion.setBackground(new java.awt.Color(47, 69, 56));
        usuarion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        usuarion.setForeground(new java.awt.Color(255, 255, 255));
        usuarion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarion.setText("Ingrese su usuario");
        usuarion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        usuarion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usuarion.setMaximumSize(new java.awt.Dimension(162, 30));
        usuarion.setMinimumSize(new java.awt.Dimension(162, 30));
        usuarion.setPreferredSize(new java.awt.Dimension(162, 30));
        usuarion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarionMousePressed(evt);
            }
        });
        usuarion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarionActionPerformed(evt);
            }
        });

        contraseñam.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        contraseñam.setForeground(new java.awt.Color(215, 208, 183));
        contraseñam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contraseñam.setText("Contraseña");
        contraseñam.setMaximumSize(new java.awt.Dimension(162, 30));
        contraseñam.setMinimumSize(new java.awt.Dimension(162, 30));
        contraseñam.setPreferredSize(new java.awt.Dimension(162, 30));

        contraseñan.setBackground(new java.awt.Color(47, 69, 56));
        contraseñan.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        contraseñan.setForeground(new java.awt.Color(255, 255, 255));
        contraseñan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contraseñan.setText("********");
        contraseñan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        contraseñan.setMaximumSize(new java.awt.Dimension(162, 30));
        contraseñan.setMinimumSize(new java.awt.Dimension(162, 30));
        contraseñan.setPreferredSize(new java.awt.Dimension(162, 30));
        contraseñan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contraseñanMousePressed(evt);
            }
        });

        botony.setBackground(new java.awt.Color(153, 204, 255));
        botony.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        botony.setForeground(new java.awt.Color(102, 102, 255));
        botony.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botony.setText("Entrar");
        botony.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botony.setOpaque(true);
        botony.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BackLayout = new javax.swing.GroupLayout(Back);
        Back.setLayout(BackLayout);
        BackLayout.setHorizontalGroup(
            BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(BackLayout.createSequentialGroup()
                .addComponent(usuariom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackLayout.createSequentialGroup()
                .addComponent(contraseñam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(BackLayout.createSequentialGroup()
                .addGroup(BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(contraseñan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(usuarion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(botony, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackLayout.setVerticalGroup(
            BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackLayout.createSequentialGroup()
                .addGroup(BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuariom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usuarion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contraseñam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contraseñan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botony, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarionMousePressed
        if (String.valueOf(contraseñan.getPassword()).equals("")) {
            contraseñan.setText("********");
            contraseñan.setForeground(Color.white);
        }
        if (usuarion.getText().equals("Ingrese su usuario")) {
            usuarion.setText("");
            usuarion.setForeground(Color.white);
        }
    }//GEN-LAST:event_usuarionMousePressed

    private void contraseñanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñanMousePressed
        if (usuarion.getText().isEmpty()) {
            usuarion.setText("Ingrese su usuario");
            usuarion.setForeground(Color.white);
        }
        if (String.valueOf(contraseñan.getPassword()).equals("********")) {
            contraseñan.setText("");
            contraseñan.setForeground(Color.white);
        }
    }//GEN-LAST:event_contraseñanMousePressed

    private void botonyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonyMouseClicked
        if (usuarion.getText().equals("Ingrese su usuario") || String.valueOf(contraseñan.getPassword()).equals("********")) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos de manera correcta\"");
        } else {
            verifica();
        }
    }//GEN-LAST:event_botonyMouseClicked

    private void usuarionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarionActionPerformed

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana_iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_iniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form  */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_iniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Back;
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel botony;
    private javax.swing.JLabel contraseñam;
    private javax.swing.JPasswordField contraseñan;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel usuariom;
    private javax.swing.JTextField usuarion;
    // End of variables declaration//GEN-END:variables
}
