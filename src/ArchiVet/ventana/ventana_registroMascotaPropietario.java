package ArchiVet.ventana;

import ArchiVet.Administrador.AdminMascota;
import ArchiVet.Administrador.AdminPropietario;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_menu.panel;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ventana_registroMascotaPropietario extends javax.swing.JInternalFrame {

    private AdminPropietario adminPropietario;
    private AdminMascota adminMascota;
    private ArchiVet.Imagen.imagenes imagen;

    private static boolean bandera = false;

    int ultimoID;

    private boolean validarCamposVacios() {
        if (nombre_mascota.getText().isEmpty() || especie.getSelectedIndex() == 0 || raza.getSelectedIndex() == 0 || color_mascota.getText().isEmpty() || SEXO.getSelectedIndex() == 0 || años.toString().isEmpty()
                || dueño1.getText().isEmpty() || paterno1.getText().isEmpty() || materno1.getText().isEmpty() || telefono1.getText().isEmpty() || correo1.getText().isEmpty() || direccion1.getText().isEmpty() || codigo1.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "campos vacios debes llenar todos los espacios");
        } else {
            bandera = true;
        }
        return bandera;
    }

    private void guardarRegistro(String opcion) {
        switch (opcion) {
            case "A":
                adminPropietario.agregarPropietario(dueño1.getText(), paterno1.getText(), materno1.getText(), telefono1.getText(), correo1.getText(), direccion1.getText(), codigo1.getText());
                adminMascota.agregarMascota(nombre_mascota.getText(), especie.getSelectedItem().toString(), raza.getSelectedItem().toString(), color_mascota.getText(), SEXO.getSelectedItem().toString(), años.getYear(), ultimoID + 1);
                limpiar();
                break;
            case "B":
                adminMascota.agregarMascota(nombre_mascota.getText(), especie.getSelectedItem().toString(), raza.getSelectedItem().toString(), color_mascota.getText(), SEXO.getSelectedItem().toString(), años.getYear(), Integer.parseInt(ID_propietario.getText()));
                limpiar();
                break;
        }

    }

    private String[] datos(String opcion) {
        String[] gatos = {"Siames", "Azul", "Bengala", "Cartujo", "Maine coon", "Persa", "Angora", "Fold escoces", "Gato americano sin pelo", "Egipcio"};
        String[] perros = {"Basset Hound", "Beagle", "Bernes de la montaña", "Border Collie", "Boxer", "Bulldog", "Caniche", "Chihuahua", "Chow Chow", "Cocker",
            "Collie", "Dalmata", "Doberman", "Dogo de Burdeos", "Galgo", "Golden Retriever", "Gran Danés", "Husky", "Labrador", "Mastín inglés", "Pastor Alemán",
            "Pekinés", "Perro salchicha", "Pitbull", "Pointer", "Pomerania", "Rottweiler", "San Bernardo", "San Huberto", "Terranova"};

        switch (opcion) {
            case "Gato":
                return gatos;
            case "Perro":
                return perros;
            default:
                return new String[0];
        }

    }

    private void desbloquear() {
        ID_propietario.setEditable(true);
        dueño1.setEditable(true);
        paterno1.setEditable(true);
        materno1.setEditable(true);
        telefono1.setEditable(true);
        correo1.setEditable(true);
        direccion1.setEditable(true);
        codigo1.setEditable(true);
        GUARDAR.setVisible(true);
        GUARDAR1.setVisible(false);
        ID.setVisible(false);
        ID_propietario.setVisible(false);
    }

    private void limpiar() {
        nombre_mascota.setText("");
        especie.setSelectedIndex(0);
        raza.setSelectedIndex(0);
        color_mascota.setText("");
        SEXO.setSelectedIndex(0);
        dueño1.setText("");
        paterno1.setText("");
        materno1.setText("");
        telefono1.setText("");
        correo1.setText("");
        direccion1.setText("");
        codigo1.setText("");
        ID_propietario.setText("");
    }

    public ventana_registroMascotaPropietario() {

        initComponents();
        adminPropietario = new AdminPropietario();
        adminMascota = new AdminMascota();
        imagen = new ArchiVet.Imagen.imagenes();
        ultimoID = adminPropietario.obtenerUltimoID();

        GUARDAR1.setVisible(false);
        ID.setVisible(false);
        ID_propietario.setVisible(false);
        Propietarios.setToolTipText("TABLA PROPIETARIOS");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.mascotas2,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Propietarios = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.dueno,0,0,getWidth(),getHeight(),this);
            }
        };
        nombre = new javax.swing.JPanel();
        lnombre = new javax.swing.JLabel();
        lespecie = new javax.swing.JLabel();
        lraza = new javax.swing.JLabel();
        lcolor = new javax.swing.JLabel();
        laño = new javax.swing.JLabel();
        nombre_mascota = new javax.swing.JTextField();
        especie = new javax.swing.JComboBox<>();
        raza = new javax.swing.JComboBox<>();
        color_mascota = new javax.swing.JTextField();
        lsexo = new javax.swing.JLabel();
        SEXO = new javax.swing.JComboBox<>();
        años = new com.toedter.calendar.JYearChooser();
        jPanel4 = new javax.swing.JPanel();
        lnombrep = new javax.swing.JLabel();
        lpaterno = new javax.swing.JLabel();
        lmaterno = new javax.swing.JLabel();
        ltelefono = new javax.swing.JLabel();
        lcorreo = new javax.swing.JLabel();
        ldireccion = new javax.swing.JLabel();
        lcodigo = new javax.swing.JLabel();
        dueño1 = new javax.swing.JTextField();
        paterno1 = new javax.swing.JTextField();
        materno1 = new javax.swing.JTextField();
        correo1 = new javax.swing.JTextField();
        direccion1 = new javax.swing.JTextField();
        telefono1 = new javax.swing.JFormattedTextField();
        codigo1 = new javax.swing.JFormattedTextField();
        ID = new javax.swing.JLabel();
        ID_propietario = new javax.swing.JTextField();
        GUARDAR1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.gua,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel34 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cancelar,0,0,getWidth(),getHeight(),this);
            }
        };
        GUARDAR = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.gua,0,0,getWidth(),getHeight(),this);
            }
        };

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1130, 730));

        jPanel2.setBackground(new java.awt.Color(47, 69, 56));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(215, 208, 183)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1122, 735));

        jPanel1.setBackground(new java.awt.Color(215, 208, 183));
        jPanel1.setForeground(new java.awt.Color(215, 208, 183));

        jLabel2.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel1.setText("Alta de paciente ");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Propietarios:");

        Propietarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));
        Propietarios.setPreferredSize(new java.awt.Dimension(75, 75));
        Propietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PropietariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addComponent(Propietarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Propietarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nombre.setBackground(new java.awt.Color(47, 69, 56));
        nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(242, 242, 242)));

        lnombre.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lnombre.setForeground(new java.awt.Color(242, 242, 242));
        lnombre.setText("NOMBRE:");

        lespecie.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lespecie.setForeground(new java.awt.Color(242, 242, 242));
        lespecie.setText("ESPECIE:");

        lraza.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lraza.setForeground(new java.awt.Color(242, 242, 242));
        lraza.setText("RAZA:");

        lcolor.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lcolor.setForeground(new java.awt.Color(240, 240, 240));
        lcolor.setText("COLOR:");

        laño.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        laño.setForeground(new java.awt.Color(240, 240, 240));
        laño.setText("AÑO NACIMIENTO");

        nombre_mascota.setBackground(new java.awt.Color(47, 69, 56));
        nombre_mascota.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        nombre_mascota.setForeground(new java.awt.Color(240, 240, 240));
        nombre_mascota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        nombre_mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_mascotaActionPerformed(evt);
            }
        });

        especie.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        especie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Selecciona una especie-", "Gato", "Perro" }));
        especie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                especieItemStateChanged(evt);
            }
        });

        raza.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        raza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        raza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                razaActionPerformed(evt);
            }
        });

        color_mascota.setBackground(new java.awt.Color(47, 69, 56));
        color_mascota.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        color_mascota.setForeground(new java.awt.Color(240, 240, 240));
        color_mascota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 242, 242)));
        color_mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color_mascotaActionPerformed(evt);
            }
        });

        lsexo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lsexo.setForeground(new java.awt.Color(240, 240, 240));
        lsexo.setText("SEXO:");

        SEXO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        SEXO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Selecciona el sexo-", "Macho ", "Hembra" }));

        años.setEndYear(2023);
        años.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        años.setInheritsPopupMenu(true);
        años.setMinimum(2000);
        años.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                añosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                añosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout nombreLayout = new javax.swing.GroupLayout(nombre);
        nombre.setLayout(nombreLayout);
        nombreLayout.setHorizontalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lraza)
                            .addComponent(lnombre)
                            .addComponent(lespecie)
                            .addComponent(lcolor)
                            .addComponent(lsexo))
                        .addGap(35, 35, 35)
                        .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(especie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(raza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SEXO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(color_mascota)
                            .addComponent(nombre_mascota)))
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addComponent(laño)
                        .addGap(18, 18, 18)
                        .addComponent(años, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        nombreLayout.setVerticalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lnombre)
                    .addComponent(nombre_mascota, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lespecie)
                    .addComponent(especie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lraza)
                    .addComponent(raza, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcolor)
                    .addComponent(color_mascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lsexo)
                    .addComponent(SEXO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(laño, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(años, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(47, 69, 56));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        lnombrep.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lnombrep.setForeground(new java.awt.Color(240, 240, 240));
        lnombrep.setText("NOMBRE:");

        lpaterno.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lpaterno.setForeground(new java.awt.Color(240, 240, 240));
        lpaterno.setText("A. PATERNO:");

        lmaterno.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lmaterno.setForeground(new java.awt.Color(240, 240, 240));
        lmaterno.setText("A. MATERNO:");

        ltelefono.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ltelefono.setForeground(new java.awt.Color(240, 240, 240));
        ltelefono.setText("TELEFONO:");

        lcorreo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lcorreo.setForeground(new java.awt.Color(240, 240, 240));
        lcorreo.setText("CORREO:");

        ldireccion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ldireccion.setForeground(new java.awt.Color(240, 240, 240));
        ldireccion.setText("DIRECCION:");

        lcodigo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lcodigo.setForeground(new java.awt.Color(240, 240, 240));
        lcodigo.setText("CODIGO POSTAL:");

        dueño1.setBackground(new java.awt.Color(47, 69, 56));
        dueño1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        dueño1.setForeground(new java.awt.Color(240, 240, 240));
        dueño1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(240, 240, 240)));

        paterno1.setBackground(new java.awt.Color(47, 69, 56));
        paterno1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        paterno1.setForeground(new java.awt.Color(240, 240, 240));
        paterno1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(240, 240, 240)));
        paterno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paterno1ActionPerformed(evt);
            }
        });

        materno1.setBackground(new java.awt.Color(47, 69, 56));
        materno1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        materno1.setForeground(new java.awt.Color(240, 240, 240));
        materno1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(240, 240, 240)));

        correo1.setBackground(new java.awt.Color(47, 69, 56));
        correo1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        correo1.setForeground(new java.awt.Color(240, 240, 240));
        correo1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(240, 240, 240)));

        direccion1.setBackground(new java.awt.Color(47, 69, 56));
        direccion1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        direccion1.setForeground(new java.awt.Color(240, 240, 240));
        direccion1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(240, 240, 240)));
        direccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccion1ActionPerformed(evt);
            }
        });

        telefono1.setBackground(new java.awt.Color(47, 69, 56));
        telefono1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 242, 242)));
        telefono1.setForeground(new java.awt.Color(242, 242, 242));
        try {
            telefono1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telefono1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N

        codigo1.setBackground(new java.awt.Color(47, 69, 56));
        codigo1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 242, 242)));
        codigo1.setForeground(new java.awt.Color(242, 242, 242));
        try {
            codigo1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        codigo1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N

        ID.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ID.setForeground(new java.awt.Color(242, 242, 242));
        ID.setText("N° SOCIO:");

        ID_propietario.setBackground(new java.awt.Color(47, 69, 56));
        ID_propietario.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ID_propietario.setForeground(new java.awt.Color(242, 242, 242));
        ID_propietario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 242, 242)));
        ID_propietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_propietarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lmaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ltelefono)
                                .addComponent(lcorreo)
                                .addComponent(ldireccion)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(lnombrep)
                                    .addGap(31, 31, 31)))
                            .addComponent(lpaterno))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(direccion1)
                            .addComponent(correo1)
                            .addComponent(telefono1)
                            .addComponent(dueño1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paterno1)
                            .addComponent(materno1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ID)
                        .addGap(31, 31, 31)
                        .addComponent(ID_propietario))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lcodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigo1)))
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnombrep)
                    .addComponent(dueño1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lpaterno)
                    .addComponent(paterno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lmaterno)
                    .addComponent(materno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ltelefono)
                    .addComponent(telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcorreo)
                    .addComponent(correo1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ldireccion)
                    .addComponent(direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcodigo)
                    .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID_propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        GUARDAR1.setPreferredSize(new java.awt.Dimension(75, 75));
        GUARDAR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GUARDAR1MouseClicked(evt);
            }
        });

        jLabel34.setPreferredSize(new java.awt.Dimension(75, 75));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        GUARDAR.setPreferredSize(new java.awt.Dimension(50, 50));
        GUARDAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GUARDARMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(205, Short.MAX_VALUE)
                        .addComponent(GUARDAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GUARDAR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void especieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_especieItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (ventana_registroMascotaPropietario.especie.getSelectedIndex() > 0) {
                ventana_registroMascotaPropietario.raza.setModel(new DefaultComboBoxModel(this.datos(ventana_registroMascotaPropietario.especie.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_especieItemStateChanged

    private void paterno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paterno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paterno1ActionPerformed

    private void direccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccion1ActionPerformed

    private void GUARDARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GUARDARMouseClicked
        if (validarCamposVacios() != false) {
            guardarRegistro("A");
        }
    }//GEN-LAST:event_GUARDARMouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        ventana_menu.FondoBotones.setVisible(true);
        limpiar();
        desbloquear();
        ventana_menu.cerrar.setVisible(true);
        this.dispose();
        panel.setVisible(true);
    }//GEN-LAST:event_jLabel34MouseClicked

    private void razaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_razaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_razaActionPerformed

    private void añosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_añosKeyTyped
        if (evt.toString() != null) {
            evt.consume();
        }
    }//GEN-LAST:event_añosKeyTyped

    private void añosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_añosKeyReleased
        evt.consume();
    }//GEN-LAST:event_añosKeyReleased

    private void PropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PropietariosMouseClicked
        ventana_buscadorPropietarioRegistro buscador = new ventana_buscadorPropietarioRegistro();
        Fondo.add(buscador);
        buscador.setVisible(true);
        this.setVisible(false);
        buscador.setLocation(320, 180);

    }//GEN-LAST:event_PropietariosMouseClicked

    private void GUARDAR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GUARDAR1MouseClicked
        if (validarCamposVacios() != false) {
            guardarRegistro("B");
        }
    }//GEN-LAST:event_GUARDAR1MouseClicked

    private void ID_propietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_propietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_propietarioActionPerformed

    private void nombre_mascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_mascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_mascotaActionPerformed

    private void color_mascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color_mascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_color_mascotaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel GUARDAR;
    public static javax.swing.JLabel GUARDAR1;
    public static javax.swing.JLabel ID;
    public static javax.swing.JTextField ID_propietario;
    private javax.swing.JLabel Propietarios;
    private javax.swing.JComboBox<String> SEXO;
    private com.toedter.calendar.JYearChooser años;
    public static javax.swing.JFormattedTextField codigo1;
    public static javax.swing.JTextField color_mascota;
    public static javax.swing.JTextField correo1;
    public static javax.swing.JTextField direccion1;
    public static javax.swing.JTextField dueño1;
    public static javax.swing.JComboBox<String> especie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel laño;
    private javax.swing.JLabel lcodigo;
    private javax.swing.JLabel lcolor;
    private javax.swing.JLabel lcorreo;
    private javax.swing.JLabel ldireccion;
    private javax.swing.JLabel lespecie;
    private javax.swing.JLabel lmaterno;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel lnombrep;
    private javax.swing.JLabel lpaterno;
    private javax.swing.JLabel lraza;
    private javax.swing.JLabel lsexo;
    private javax.swing.JLabel ltelefono;
    public static javax.swing.JTextField materno1;
    private javax.swing.JPanel nombre;
    public static javax.swing.JTextField nombre_mascota;
    public static javax.swing.JTextField paterno1;
    public static javax.swing.JComboBox<String> raza;
    public static javax.swing.JFormattedTextField telefono1;
    // End of variables declaration//GEN-END:variables
}
