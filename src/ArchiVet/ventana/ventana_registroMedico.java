package ArchiVet.ventana;

import ArchiVet.Administrador.AdminMedico;
import ArchiVet.Modelo.Medico;
import static ArchiVet.ventana.ventana_menu.panel;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class ventana_registroMedico extends javax.swing.JFrame {

    private static int idMedico;

    private AdminMedico adminMedico;
    private ArchiVet.Imagen.imagenes imagen;

    public static boolean bandera = false;

    public ventana_registroMedico() {
        initComponents();
        adminMedico = new AdminMedico();
        imagen = new ArchiVet.Imagen.imagenes();

        adminMedico.obtenerModeloTablaPropietarios(MedicoIngresados);
    }

    private void mostrarDatosMedico(Medico medico) {
        if (medico != null) {
            NOMBRE.setText(medico.getNombre());
            APELLIDO.setText(medico.getApellidoP());
            USUARIO.setText(medico.getUsuario());
            CONTRASEÑA.setText(medico.getContrasenia());
            TELEFONO.setText(medico.getTelefono());
            CELULAR.setText(medico.getCelular());
            CORREO.setText(medico.getEmail());
            DOMICILIO.setText(medico.getDireccion());
            CODIGO.setText(medico.getCP());
            CARGO.setSelectedItem(medico.getCargo());
            CEDULA.setText(medico.getCedula());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún médico con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Vacio() {
        if (!(NOMBRE.getText().isEmpty() && APELLIDO.getText().isEmpty() && USUARIO.getText().isEmpty() && CONTRASEÑA.getText().isEmpty() && TELEFONO.getText().isBlank()
                && CELULAR.getText().trim().isBlank() && CORREO.getText().isEmpty() && DOMICILIO.getText().isEmpty() && CODIGO.getText().isEmpty()
                && CARGO.getSelectedIndex() == 0 && CEDULA.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos de manera correcta", "Exito", JOptionPane.PLAIN_MESSAGE);

            if (bandera == false) {
                adminMedico.agregarMedico(TELEFONO.getText(), USUARIO.getText(), CONTRASEÑA.getText(), CARGO.getSelectedItem().toString(),
                        CEDULA.getText(), NOMBRE.getText(), APELLIDO.getText(), CELULAR.getText(), CORREO.getText(),
                        DOMICILIO.getText(), CODIGO.getText());
            } else if (bandera == true) {
                Medico medico = new Medico(idMedico, TELEFONO.getText(), USUARIO.getText(), CONTRASEÑA.getText(), CARGO.getSelectedItem().toString(),
                        CEDULA.getText(), NOMBRE.getText(), APELLIDO.getText(), CELULAR.getText(), CORREO.getText(), DOMICILIO.getText(),
                        CODIGO.getText());
                adminMedico.actualizarMedico(medico);
                bandera = false;
            }
            adminMedico.obtenerModeloTablaPropietarios(MedicoIngresados);
            Vaciar();
        } else {
            JOptionPane.showMessageDialog(null, "No se han ingresasdo los datos de manera correcta", "Error de ingreso", JOptionPane.CANCEL_OPTION);
        }
    }

    private void eliminarMedico() {
        Medico medico = new Medico(idMedico, TELEFONO.getText(), USUARIO.getText(), CONTRASEÑA.getText(), CARGO.getSelectedItem().toString(),
                CEDULA.getText(), NOMBRE.getText(), APELLIDO.getText(), CELULAR.getText(), CORREO.getText(), DOMICILIO.getText(),
                CODIGO.getText(), 0);
        adminMedico.eliminarMedico(medico);
        adminMedico.obtenerModeloTablaPropietarios(MedicoIngresados);
        Vaciar();
    }

    private void Vaciar() {
        NOMBRE.setText("");
        CONTRASEÑA.setText("");
        TELEFONO.setText("");
        CORREO.setText("");
        DOMICILIO.setText("");
        CARGO.setSelectedIndex(0);
        CEDULA.setText("");
        USUARIO.setText("");
        APELLIDO.setText("");
        CODIGO.setText("");
        CELULAR.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondiu = new javax.swing.JPanel();
        NOM = new javax.swing.JLabel();
        NOMBRE = new javax.swing.JTextField();
        APE = new javax.swing.JLabel();
        APELLIDO = new javax.swing.JTextField();
        TEL = new javax.swing.JLabel();
        TELEFONO = new javax.swing.JFormattedTextField();
        CEL = new javax.swing.JLabel();
        CELULAR = new javax.swing.JFormattedTextField();
        COR = new javax.swing.JLabel();
        CORREO = new javax.swing.JTextField();
        DOM = new javax.swing.JLabel();
        DOMICILIO = new javax.swing.JTextField();
        COD = new javax.swing.JLabel();
        CODIGO = new javax.swing.JTextField();
        USU = new javax.swing.JLabel();
        USUARIO = new javax.swing.JTextField();
        CON = new javax.swing.JLabel();
        CONTRASEÑA = new javax.swing.JTextField();
        CAR = new javax.swing.JLabel();
        CARGO = new javax.swing.JComboBox<>();
        CED = new javax.swing.JLabel();
        CEDULA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedicoIngresados = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };
        INGRESAR = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.guardar,0,0,getWidth(),getHeight(),this);
            }
        };
        ELIMINAR = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Elimminae_Usuario,0,0,getWidth(),getHeight(),this);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Fondiu.setBackground(new java.awt.Color(47, 69, 56));
        Fondiu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        NOM.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        NOM.setForeground(new java.awt.Color(255, 255, 255));
        NOM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NOM.setText("Nombre:");

        NOMBRE.setBackground(new java.awt.Color(47, 69, 56));
        NOMBRE.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        NOMBRE.setForeground(new java.awt.Color(255, 255, 255));
        NOMBRE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NOMBRE.setToolTipText("");
        NOMBRE.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        NOMBRE.setNextFocusableComponent(CONTRASEÑA);

        APE.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        APE.setForeground(new java.awt.Color(255, 255, 255));
        APE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        APE.setText("Apellido:");

        APELLIDO.setBackground(new java.awt.Color(47, 69, 56));
        APELLIDO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        APELLIDO.setForeground(new java.awt.Color(255, 255, 255));
        APELLIDO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        APELLIDO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));

        TEL.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        TEL.setForeground(new java.awt.Color(255, 255, 255));
        TEL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TEL.setText("Telefono:");

        TELEFONO.setBackground(new java.awt.Color(47, 69, 56));
        TELEFONO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        TELEFONO.setForeground(new java.awt.Color(255, 255, 255));
        try {
            TELEFONO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TELEFONO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TELEFONO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        TELEFONO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TELEFONOActionPerformed(evt);
            }
        });

        CEL.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CEL.setForeground(new java.awt.Color(255, 255, 255));
        CEL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CEL.setText("Celular:");

        CELULAR.setBackground(new java.awt.Color(47, 69, 56));
        CELULAR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        CELULAR.setForeground(new java.awt.Color(255, 255, 255));
        try {
            CELULAR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CELULAR.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CELULAR.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CELULAR.setMaximumSize(new java.awt.Dimension(30, 150));
        CELULAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CELULARActionPerformed(evt);
            }
        });

        COR.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        COR.setForeground(new java.awt.Color(255, 255, 255));
        COR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        COR.setText("Correo:");

        CORREO.setBackground(new java.awt.Color(47, 69, 56));
        CORREO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CORREO.setForeground(new java.awt.Color(255, 255, 255));
        CORREO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CORREO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        CORREO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CORREOActionPerformed(evt);
            }
        });

        DOM.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        DOM.setForeground(new java.awt.Color(255, 255, 255));
        DOM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DOM.setText("Domicilio:");

        DOMICILIO.setBackground(new java.awt.Color(47, 69, 56));
        DOMICILIO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        DOMICILIO.setForeground(new java.awt.Color(255, 255, 255));
        DOMICILIO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DOMICILIO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));

        COD.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        COD.setForeground(new java.awt.Color(255, 255, 255));
        COD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        COD.setText("C.P.");
        COD.setToolTipText("");

        CODIGO.setBackground(new java.awt.Color(47, 69, 56));
        CODIGO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CODIGO.setForeground(new java.awt.Color(255, 255, 255));
        CODIGO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CODIGO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));

        USU.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        USU.setForeground(new java.awt.Color(255, 255, 255));
        USU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        USU.setText("Usuario:");

        USUARIO.setBackground(new java.awt.Color(47, 69, 56));
        USUARIO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        USUARIO.setForeground(new java.awt.Color(255, 255, 255));
        USUARIO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        USUARIO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        USUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USUARIOActionPerformed(evt);
            }
        });

        CON.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CON.setForeground(new java.awt.Color(255, 255, 255));
        CON.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CON.setText("Contraseña:");

        CONTRASEÑA.setBackground(new java.awt.Color(47, 69, 56));
        CONTRASEÑA.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CONTRASEÑA.setForeground(new java.awt.Color(255, 255, 255));
        CONTRASEÑA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CONTRASEÑA.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));

        CAR.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CAR.setForeground(new java.awt.Color(255, 255, 255));
        CAR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CAR.setText("Cargo:");

        CARGO.setBackground(new java.awt.Color(47, 69, 56));
        CARGO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CARGO.setForeground(new java.awt.Color(255, 255, 255));
        CARGO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el cargo", "Medico/a" }));

        CED.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CED.setForeground(new java.awt.Color(255, 255, 255));
        CED.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CED.setText("Cedula:");

        CEDULA.setBackground(new java.awt.Color(47, 69, 56));
        CEDULA.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CEDULA.setForeground(new java.awt.Color(255, 255, 255));
        CEDULA.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CEDULA.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(242, 242, 242)));
        CEDULA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CEDULAMouseClicked(evt);
            }
        });

        MedicoIngresados.setAutoCreateRowSorter(true);
        MedicoIngresados.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 71)));
        MedicoIngresados.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MedicoIngresados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Celular", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MedicoIngresados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        MedicoIngresados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MedicoIngresados.setFocusable(false);
        MedicoIngresados.setRowHeight(35);
        MedicoIngresados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        MedicoIngresados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        MedicoIngresados.setShowGrid(true);
        MedicoIngresados.getTableHeader().setResizingAllowed(false);
        MedicoIngresados.getTableHeader().setReorderingAllowed(false);
        MedicoIngresados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicoIngresadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MedicoIngresados);
        if (MedicoIngresados.getColumnModel().getColumnCount() > 0) {
            MedicoIngresados.getColumnModel().getColumn(0).setResizable(false);
            MedicoIngresados.getColumnModel().getColumn(0).setPreferredWidth(50);
            MedicoIngresados.getColumnModel().getColumn(1).setResizable(false);
            MedicoIngresados.getColumnModel().getColumn(1).setPreferredWidth(163);
            MedicoIngresados.getColumnModel().getColumn(2).setResizable(false);
            MedicoIngresados.getColumnModel().getColumn(2).setPreferredWidth(161);
            MedicoIngresados.getColumnModel().getColumn(3).setResizable(false);
            MedicoIngresados.getColumnModel().getColumn(3).setPreferredWidth(161);
            MedicoIngresados.getColumnModel().getColumn(4).setResizable(false);
            MedicoIngresados.getColumnModel().getColumn(4).setPreferredWidth(161);
        }

        jPanel1.setBackground(new java.awt.Color(215, 208, 183));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registro Medico");

        cerrar.setMaximumSize(new java.awt.Dimension(50, 50));
        cerrar.setMinimumSize(new java.awt.Dimension(50, 50));
        cerrar.setPreferredSize(new java.awt.Dimension(50, 50));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(567, 567, 567)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        INGRESAR.setMaximumSize(new java.awt.Dimension(75, 75));
        INGRESAR.setMinimumSize(new java.awt.Dimension(75, 75));
        INGRESAR.setPreferredSize(new java.awt.Dimension(75, 75));
        INGRESAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                INGRESARMouseClicked(evt);
            }
        });

        ELIMINAR.setMaximumSize(new java.awt.Dimension(75, 75));
        ELIMINAR.setMinimumSize(new java.awt.Dimension(75, 75));
        ELIMINAR.setPreferredSize(new java.awt.Dimension(75, 75));
        ELIMINAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ELIMINARMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FondiuLayout = new javax.swing.GroupLayout(Fondiu);
        Fondiu.setLayout(FondiuLayout);
        FondiuLayout.setHorizontalGroup(
            FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondiuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondiuLayout.createSequentialGroup()
                        .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(USU, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(USUARIO))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(CEL, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(COD, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(COR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CORREO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(APE, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(APELLIDO))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addComponent(DOM, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DOMICILIO))
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CED, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CON, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CEDULA)
                                    .addComponent(CONTRASEÑA))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(FondiuLayout.createSequentialGroup()
                        .addComponent(CAR, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CARGO, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INGRESAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        FondiuLayout.setVerticalGroup(
            FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondiuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondiuLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(FondiuLayout.createSequentialGroup()
                        .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(APE)
                                    .addComponent(APELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CEL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(COR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CORREO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(COD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DOM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DOMICILIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CED)
                                .addComponent(CEDULA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CON, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CONTRASEÑA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(USU)
                            .addComponent(USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondiuLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CARGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondiuLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(FondiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(INGRESAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Fondiu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondiu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TELEFONOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TELEFONOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TELEFONOActionPerformed

    private void CELULARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CELULARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CELULARActionPerformed

    private void CEDULAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CEDULAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CEDULAMouseClicked

    private void CORREOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CORREOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CORREOActionPerformed

    private void USUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USUARIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USUARIOActionPerformed

    private void MedicoIngresadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicoIngresadosMouseClicked
        bandera = true;
        idMedico = Integer.parseInt(MedicoIngresados.getValueAt(MedicoIngresados.getSelectedRow(), 0).toString());
        mostrarDatosMedico(adminMedico.consultarMedicoPorID(idMedico));
    }//GEN-LAST:event_MedicoIngresadosMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        Vaciar();
        panel.setVisible(true);
        ventana_menu.FondoBotones.setVisible(true);
        ventana_menu.cerrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cerrarMouseClicked

    private void INGRESARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INGRESARMouseClicked
        Vacio();
        adminMedico.obtenerModeloTablaPropietarios(MedicoIngresados);
    }//GEN-LAST:event_INGRESARMouseClicked

    private void ELIMINARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ELIMINARMouseClicked
        eliminarMedico();

    }//GEN-LAST:event_ELIMINARMouseClicked

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
            java.util.logging.Logger.getLogger(ventana_registroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_registroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_registroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_registroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_registroMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel APE;
    private javax.swing.JTextField APELLIDO;
    private javax.swing.JLabel CAR;
    private javax.swing.JComboBox<String> CARGO;
    private javax.swing.JLabel CED;
    private javax.swing.JTextField CEDULA;
    private javax.swing.JLabel CEL;
    private javax.swing.JFormattedTextField CELULAR;
    private javax.swing.JLabel COD;
    private javax.swing.JTextField CODIGO;
    private javax.swing.JLabel CON;
    private javax.swing.JTextField CONTRASEÑA;
    private javax.swing.JLabel COR;
    private javax.swing.JTextField CORREO;
    private javax.swing.JLabel DOM;
    private javax.swing.JTextField DOMICILIO;
    private javax.swing.JLabel ELIMINAR;
    private javax.swing.JPanel Fondiu;
    private javax.swing.JLabel INGRESAR;
    private javax.swing.JTable MedicoIngresados;
    private javax.swing.JLabel NOM;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JLabel TEL;
    private javax.swing.JFormattedTextField TELEFONO;
    private javax.swing.JLabel USU;
    private javax.swing.JTextField USUARIO;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
