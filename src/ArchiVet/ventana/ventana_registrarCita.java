package ArchiVet.ventana;

import ArchiVet.Admin.AdminCitas;
import ArchiVet.Modelo.Citas;
import static ArchiVet.ventana.ventana_agendarCitas.ID_SS;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_menu.citas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class ventana_registrarCita extends javax.swing.JInternalFrame {

    private AdminCitas adminCitas;
    private ArchiVet.Imagen.imagenes imagen;

    public String Fecha, Horas, Minutos, Cita_Horario;

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void actualizarDatos() {
        Horas = Combo_Hora.getSelectedItem().toString();
        Minutos = Combo_Minutos.getSelectedItem().toString();
        String Hor = "";
        if (Integer.parseInt(Horas) < 12) {
            Hor = "AM";
        } else {
            Hor = "PM";
        }
        Cita_Horario = Horas + ":" + Minutos + " " + Hor;
        int G = new Date().getHours();

        SimpleDateFormat formatoF = new SimpleDateFormat("yyyy-MM-dd");
        String FF = formatoF.format(new Date());

        if (Detalle_Cita.getText().trim().isEmpty() || ObservacionesCita.getText().trim().isEmpty() || ComboboxCita.getSelectedIndex() == 0 || PNombre.getText().isEmpty() || MNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor completelos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Fecha.equals(FF) && Integer.parseInt(Horas) <= G) {
            JOptionPane.showMessageDialog(null, "Las citas no se pueden generar en esta hora habil", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Citas updateCitas = new Citas(Cita_Horario, Fecha_Cita2.getText(), ComboboxEstado.getSelectedItem().toString(), ComboboxCita.getSelectedItem().toString(), Detalle_Cita.getText(), ObservacionesCita.getText(), ID_SS);
                adminCitas.actualizarCita(updateCitas);

                this.dispose();
                Fondo.add(citas);
                citas.setVisible(true);
                citas.setLocation(0, 0);
                LabelUPDATE.setVisible(false);
                citas.consultarDB_limpiarDatos();
                cleanDates();

            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void guardarDatos() {
        Horas = Combo_Hora.getSelectedItem().toString();
        Minutos = Combo_Minutos.getSelectedItem().toString();
        String Hor = "";
        if (Integer.parseInt(Horas) < 12) {
            Hor = "AM";
        } else {
            Hor = "PM";
        }
        Cita_Horario = Horas + ":" + Minutos + " " + Hor;
        int G = new Date().getHours();

        SimpleDateFormat formatoF = new SimpleDateFormat("yyyy-MM-dd");
        String FF = formatoF.format(new Date());

        if (Detalle_Cita.getText().trim().isEmpty() || ObservacionesCita.getText().trim().isEmpty() || ComboboxCita.getSelectedIndex() == 0 || PNombre.getText().isEmpty() || MNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor completelos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Fecha.equals(FF) && Integer.parseInt(Horas) <= G) {
            JOptionPane.showMessageDialog(null, "Las citas no se pueden generar en esta hora habil", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                adminCitas.insertarCita(Cita_Horario, Fecha_Cita2.getText(), ComboboxEstado.getSelectedItem().toString(), ComboboxCita.getSelectedItem().toString(),
                        Detalle_Cita.getText(), ObservacionesCita.getText(), MEspecie.getText(), MNombre.getText(), MSEXO.getText(),
                        MRaza.getText(), MColor.getText(), MFecha.getText(), PNombre.getText(), PApellidos.getText(),
                        PTelefono.getText(), PCorreo.getText(), PDomicilio.getText(), Integer.parseInt(PCP.getText()),
                        Integer.parseInt(PSocio.getText()));

                citas.setVisible(true);
                citas.consultarDB_limpiarDatos();
                cleanDates();
                this.dispose();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void cleanDates() {
        PNombre.setText("");
        PApellidos.setText("");
        PTelefono.setText("");
        PCP.setText("");
        PCorreo.setText("");
        PSocio.setText("");
        PDomicilio.setText("");

        MNombre.setText("");
        MEspecie.setText("");
        MFecha.setText("");
        MRaza.setText("");
        MSEXO.setText("");
        MColor.setText("");

        ComboboxCita.setSelectedIndex(0);
        Fecha_Cita2.setText("");
        jDateChooser_Registro.setMinSelectableDate(new Date());
        Combo_Hora.setSelectedIndex(0);
        Combo_Minutos.setSelectedIndex(0);

        ComboboxEstado.setSelectedIndex(0);
        Detalle_Cita.setText("");
        ObservacionesCita.setText("");
    }

    public int numero;

    public ventana_registrarCita() {
        initComponents();
        adminCitas = new AdminCitas();
        imagen = new ArchiVet.Imagen.imagenes();
        ocultarBarraTitulo();

        jDateChooser_Registro.setDate(new Date());
        LabelSAVE.setToolTipText("GUARDAR");
        Cancelar_Cita.setToolTipText("CANCELAR");
        LabelUPDATE.setToolTipText("ACTUALIZAR");
        jDateChooser_Registro.setMinSelectableDate(new Date());

        System.out.println(new Date().getHours());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PApellidos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PTelefono = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PCorreo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PDomicilio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PCP = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        MNombre = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        MEspecie = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MRaza = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        MColor = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        MFecha = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        ComboboxCita = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        Fecha_Cita2 = new javax.swing.JTextField();
        jDateChooser_Registro = new com.toedter.calendar.JDateChooser();
        Hora_Para_Cita1 = new javax.swing.JTextField();
        Combo_Hora = new javax.swing.JComboBox<>();
        Combo_Minutos = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        Detalle_Cita = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ObservacionesCita = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        ComboboxEstado = new javax.swing.JComboBox<>();
        LabelSAVE = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.guardar,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel13 = new javax.swing.JLabel();
        PSocio = new javax.swing.JLabel();
        MSexo = new javax.swing.JLabel();
        MSEXO = new javax.swing.JLabel();
        Cancelar_Cita = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Cancelar_Azul,0,0,getWidth(),getHeight(),this);
            }
        };
        LabelUPDATE = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.actualizar,0,0,getWidth(),getHeight(),this);
            }
        };

        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(47, 69, 56));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel2.setBackground(new java.awt.Color(47, 69, 56));
        jPanel2.setForeground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 186, 164));
        jLabel1.setText("Datos del Propietario");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Nombre:");

        PNombre.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PNombre.setForeground(new java.awt.Color(242, 242, 242));
        PNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Apellidos:");

        PApellidos.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PApellidos.setForeground(new java.awt.Color(242, 242, 242));
        PApellidos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Telefono:");

        PTelefono.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PTelefono.setForeground(new java.awt.Color(242, 242, 242));
        PTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Correo:");

        PCorreo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PCorreo.setForeground(new java.awt.Color(242, 242, 242));
        PCorreo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Domicilio:");

        PDomicilio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PDomicilio.setForeground(new java.awt.Color(242, 242, 242));
        PDomicilio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Código Postal:");

        PCP.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PCP.setForeground(new java.awt.Color(242, 242, 242));
        PCP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 186, 164));
        jLabel14.setText("Datos del Paciente");

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(242, 242, 242));
        jLabel15.setText("Nombre:");

        MNombre.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MNombre.setForeground(new java.awt.Color(242, 242, 242));
        MNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(242, 242, 242));
        jLabel17.setText("Especie:");

        MEspecie.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        MEspecie.setForeground(new java.awt.Color(242, 242, 242));
        MEspecie.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel19.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(242, 242, 242));
        jLabel19.setText("Raza:");

        MRaza.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        MRaza.setForeground(new java.awt.Color(242, 242, 242));
        MRaza.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel21.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(242, 242, 242));
        jLabel21.setText("Color:");

        MColor.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        MColor.setForeground(new java.awt.Color(242, 242, 242));
        MColor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jLabel23.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(242, 242, 242));
        jLabel23.setText("Fecha de nacimiento:");

        MFecha.setFont(new java.awt.Font("Arial", 0, 26)); // NOI18N
        MFecha.setForeground(new java.awt.Color(242, 242, 242));
        MFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        jPanel3.setBackground(new java.awt.Color(28, 186, 164));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Buscar al paciente");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos sobre servicio y fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Narrow", 0, 24))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel26.setText("Cita");

        ComboboxCita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ComboboxCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Desparacitacion", "Vacunacion", "Consultorio" }));

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        jLabel28.setBackground(new java.awt.Color(204, 0, 51));
        jLabel28.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Seleccionar hora");
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Fecha_Cita2.setEditable(false);
        Fecha_Cita2.setBackground(new java.awt.Color(255, 255, 255));
        Fecha_Cita2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Fecha_Cita2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(28, 186, 164)));

        jDateChooser_Registro.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jDateChooser_Registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser_RegistroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jDateChooser_RegistroMousePressed(evt);
            }
        });
        jDateChooser_Registro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser_RegistroPropertyChange(evt);
            }
        });

        Hora_Para_Cita1.setEditable(false);
        Hora_Para_Cita1.setBackground(new java.awt.Color(255, 255, 255));
        Hora_Para_Cita1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Hora_Para_Cita1.setText(":");
        Hora_Para_Cita1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(28, 186, 164)));

        Combo_Hora.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Combo_Hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", " " }));
        Combo_Hora.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Combo_HoraPropertyChange(evt);
            }
        });

        Combo_Minutos.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Combo_Minutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45", " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(ComboboxCita, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser_Registro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Fecha_Cita2)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(Combo_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Hora_Para_Cita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Combo_Minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ComboboxCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fecha_Cita2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(jDateChooser_Registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Hora_Para_Cita1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_Minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion de la cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial Narrow", 0, 24))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel30.setText("Detalle de la cita:");

        Detalle_Cita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Detalle_Cita.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Detalle_Cita.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));
        Detalle_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Detalle_CitaActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel31.setText("Observaciones de la cita:");

        ObservacionesCita.setBackground(new java.awt.Color(204, 204, 204));
        ObservacionesCita.setColumns(20);
        ObservacionesCita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ObservacionesCita.setRows(5);
        ObservacionesCita.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(ObservacionesCita);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Detalle_Cita, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 297, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Detalle_Cita, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(242, 242, 242));
        jLabel29.setText("Estado:");

        ComboboxEstado.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        ComboboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Activo", "Concluido", "Cancelado" }));

        LabelSAVE.setPreferredSize(new java.awt.Dimension(75, 75));
        LabelSAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelSAVEMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(242, 242, 242));
        jLabel13.setText("N° Socio:");

        PSocio.setBackground(new java.awt.Color(255, 255, 255));
        PSocio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PSocio.setForeground(new java.awt.Color(242, 242, 242));
        PSocio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        MSexo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MSexo.setForeground(new java.awt.Color(242, 242, 242));
        MSexo.setText("Sexo:");

        MSEXO.setFont(new java.awt.Font("Arial", 0, 26)); // NOI18N
        MSEXO.setForeground(new java.awt.Color(242, 242, 242));
        MSEXO.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));

        Cancelar_Cita.setPreferredSize(new java.awt.Dimension(75, 75));
        Cancelar_Cita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cancelar_CitaMouseClicked(evt);
            }
        });

        LabelUPDATE.setPreferredSize(new java.awt.Dimension(75, 75));
        LabelUPDATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelUPDATEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(MSexo)
                                .addGap(18, 18, 18)
                                .addComponent(MSEXO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(18, 18, 18)
                                        .addComponent(ComboboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(LabelSAVE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Cancelar_Cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(LabelUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(286, 286, 286))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)))
                                        .addGap(39, 39, 39)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(148, 148, 148))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(MEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(MRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(MColor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(PCP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(PApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel13)
                                        .addGap(27, 27, 27)
                                        .addComponent(PSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(PCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(PCP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(PSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MEspecie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MRaza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel23))
                    .addComponent(MSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MSEXO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelSAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelUPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(ComboboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Cancelar_Cita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1908, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

    }//GEN-LAST:event_jLabel28MouseClicked

    private void Detalle_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Detalle_CitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Detalle_CitaActionPerformed

    private void Cancelar_CitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancelar_CitaMouseClicked
        try {
            citas.setVisible(true);
            citas.consultarDB_limpiarDatos();
            cleanDates();
            this.setVisible(false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_Cancelar_CitaMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        try {
            ventana_buscadorMascotaCita buscadorMascotaCita = new ventana_buscadorMascotaCita();
            Fondo.add(buscadorMascotaCita);
            buscadorMascotaCita.setVisible(true);
            buscadorMascotaCita.setLocation(0, 0);

            //Filtraciones.Buscar_Citas(Tabla_Citas);
            this.dispose();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jLabel25MouseClicked

    private void LabelSAVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSAVEMouseClicked
        guardarDatos();
    }//GEN-LAST:event_LabelSAVEMouseClicked

    private void jDateChooser_RegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser_RegistroMouseClicked

    }//GEN-LAST:event_jDateChooser_RegistroMouseClicked

    private void jDateChooser_RegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser_RegistroMousePressed

    }//GEN-LAST:event_jDateChooser_RegistroMousePressed

    private void jDateChooser_RegistroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser_RegistroPropertyChange
        if (evt.getOldValue() != null) {
            SimpleDateFormat formatoF = new SimpleDateFormat("yyyy-MM-dd");
            Fecha = formatoF.format(jDateChooser_Registro.getDate());

            Fecha_Cita2.setText(Fecha);
        }
    }//GEN-LAST:event_jDateChooser_RegistroPropertyChange

    private void LabelUPDATEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelUPDATEMouseClicked
        actualizarDatos();
    }//GEN-LAST:event_LabelUPDATEMouseClicked

    private void Combo_HoraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Combo_HoraPropertyChange

    }//GEN-LAST:event_Combo_HoraPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Cancelar_Cita;
    public static javax.swing.JComboBox<String> Combo_Hora;
    public static javax.swing.JComboBox<String> Combo_Minutos;
    public static javax.swing.JComboBox<String> ComboboxCita;
    public static javax.swing.JComboBox<String> ComboboxEstado;
    public static javax.swing.JTextField Detalle_Cita;
    public static javax.swing.JTextField Fecha_Cita2;
    public static javax.swing.JTextField Hora_Para_Cita1;
    public static javax.swing.JLabel LabelSAVE;
    public static javax.swing.JLabel LabelUPDATE;
    public static javax.swing.JLabel MColor;
    public static javax.swing.JLabel MEspecie;
    public static javax.swing.JLabel MFecha;
    public static javax.swing.JLabel MNombre;
    public static javax.swing.JLabel MRaza;
    public static javax.swing.JLabel MSEXO;
    private javax.swing.JLabel MSexo;
    public static javax.swing.JTextArea ObservacionesCita;
    public static javax.swing.JLabel PApellidos;
    public static javax.swing.JLabel PCP;
    public static javax.swing.JLabel PCorreo;
    public static javax.swing.JLabel PDomicilio;
    public static javax.swing.JLabel PNombre;
    public static javax.swing.JLabel PSocio;
    public static javax.swing.JLabel PTelefono;
    public static com.toedter.calendar.JDateChooser jDateChooser_Registro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.raven.swing.TimePicker timePicker1;
    // End of variables declaration//GEN-END:variables
}
