package ArchiVet.ventana;

import ArchiVet.Admin.AdminCitas;
import ArchiVet.Modelo.Citas;
import ArchiVet.ventana.componente.Buscardor_JTable;
import Archivet.Controlador.Filtraciones;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_menu.panel;
import static ArchiVet.ventana.ventana_registrarCita.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class ventana_agendarCitas extends javax.swing.JInternalFrame implements Runnable {

    public static AdminCitas adminCitas;
    private ArchiVet.Imagen.imagenes imagen;
    private ventana_registroMascotaPropietario registroMascotaPropietario;
    private Buscardor_JTable buscadorTabla;
    public static ventana_registrarCita registrarCita;

    public SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");

    public static int ID_SS = 0, NSocio;

    public static String horaCITA, nombreMASCOTA, ESTADO = "", fechaCita = "";
    String horaa, minutos, segundos, AMPM;
    Thread h1;

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void atenderCita(java.awt.event.MouseEvent evt) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormato = formatoFecha.format(new Date());

            if (fechaCita.contains(fechaFormato)) {
                Object[] Opciones = {"Cancelar", "Continuar"};
                Object opcion = JOptionPane.showOptionDialog(null, "Deseas continuar con la consulta?", "Aviso", JOptionPane.YES_NO_OPTION, HEIGHT, frameIcon, Opciones, iconable);
                try {
                    if (opcion.equals(0)) {
                    } else if (opcion.equals(1)) {
                        JOptionPane.showMessageDialog(null, "Accion establecida");
                    }
                } catch (Exception | Error e) {
                    System.err.println(e.getMessage());
                }
            } else if (fechaCita.isBlank()) {
                JOptionPane.showMessageDialog(null, "Aun no se ah seleccionado una cita", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden atender las citas que no sean para hoy", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            System.err.println(e.getMessage());
        }
    }

    private void mostrarDatosCita(Citas citas) {
        if (citas != null) {
            Fecha_Cita2.setText(citas.getFechaCita());
            ComboboxEstado.setSelectedItem(citas.getEstadoCita());
            ComboboxCita.setSelectedItem(citas.getServicioCita());
            Detalle_Cita.setText(citas.getDetalleCita());
            ObservacionesCita.setText(citas.getObservacionesCita());
            MEspecie.setText(citas.getEspecieMascota());
            MNombre.setText(citas.getNombreMascota());
            MSEXO.setText(citas.getSexoMascota());
            MRaza.setText(citas.getRazaMascota());
            MColor.setText(citas.getColorMascota());
            MFecha.setText(citas.getFechaNaciminetoMas());
            PNombre.setText(citas.getNombrePropietario());
            PApellidos.setText(citas.getApellidosPropietario());
            PTelefono.setText(citas.getTelefonoPropietario());
            PCorreo.setText(citas.getCorreoPropietario());
            PDomicilio.setText(citas.getDomicilioPropietario());
            PCP.setText(String.valueOf(citas.getCodigoPostal()));
            PSocio.setText(String.valueOf(citas.getNumeroSocio()));
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún médico con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarCita(java.awt.event.MouseEvent evt) {
        if (ID_SS == 0) {
            JOptionPane.showMessageDialog(null, "Primero selecciona una columna", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ventana_registrarCita RG = new ventana_registrarCita();
            Fondo.add(RG);
            RG.setVisible(true);
            RG.setLocation(0, 0);

            jPanel3.setVisible(false);
            jLabel25.setVisible(false);

            LabelSAVE.setVisible(false);
            LabelUPDATE.setVisible(true);

            String horaRegistrada = horaCITA.substring(0, 2);
            String minutoRegistrado = horaCITA.substring(3, 5);

            int hora = 0;

            if (horaRegistrada.equals("10")) {
                hora = 0;
            } else if (horaRegistrada.equals("11")) {
                hora = 1;
            } else if (horaRegistrada.equals("12")) {
                hora = 2;
            } else if (horaRegistrada.equals("13")) {
                hora = 3;
            } else if (horaRegistrada.equals("14")) {
                hora = 4;
            } else if (horaRegistrada.equals("15")) {
                hora = 5;
            } else if (horaRegistrada.equals("16")) {
                hora = 6;
            } else if (horaRegistrada.equals("17")) {
                hora = 7;
            } else if (horaRegistrada.equals("18")) {
                hora = 8;
            } else if (horaRegistrada.equals("19")) {
                hora = 9;
            } else if (horaRegistrada.equals("20")) {
                hora = 10;
            }

            int minuto = 0;

            if (minutoRegistrado.equals("00")) {
                minuto = 0;
            } else if (minutoRegistrado.equals("15")) {
                minuto = 1;
            } else if (minutoRegistrado.equals("30")) {
                minuto = 2;
            } else if (minutoRegistrado.equals("45")) {
                minuto = 3;
            }

            Combo_Hora.setSelectedIndex(hora);
            Combo_Minutos.setSelectedIndex(minuto);
            mostrarDatosCita(adminCitas.consultarCitasPorID(ID_SS));
            //Filtraciones.EditarCitas_Agendadas(ID_SS);
            this.dispose();
        }
    }

    private void mostrarDatosSeleccionados(java.awt.event.MouseEvent evt) {
        try {
            String Observacion;
            int Selector = CitasA.rowAtPoint(evt.getPoint());
            horaCITA = String.valueOf(CitasA.getValueAt(Selector, 0));
            ID_SS = Integer.parseInt(String.valueOf(CitasA.getValueAt(Selector, 15)));
            ESTADO = String.valueOf(CitasA.getValueAt(Selector, 2));
            fechaCita = String.valueOf(CitasA.getValueAt(Selector, 1));

            Observacion = String.valueOf(CitasA.getValueAt(Selector, 14));
            Observaciones_Cita.setText(Observacion);

            switch (ESTADO) {
                case "Activo":
                    Estado_Cita.setText(ESTADO);
                    Estado_Cita.setForeground(Color.green);
                    break;
                case "Pendiente":
                    Estado_Cita.setText(ESTADO);
                    Estado_Cita.setForeground(Color.yellow);
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    private void opcionAgendarCita(java.awt.event.MouseEvent evt) {
        Object[] Opciones = {"Registrar Usuario", "Continuar"};
        Object opcion = JOptionPane.showOptionDialog(null, "Recuerda que para agendar cita el usuario tiene que estar registrado previamente", "Aviso", JOptionPane.YES_NO_OPTION, HEIGHT, frameIcon, Opciones, iconable);
        try {
            if (opcion.equals(0)) {
                Fondo.add(registroMascotaPropietario);
                registroMascotaPropietario.setVisible(true);
                registroMascotaPropietario.setLocation(390, 150);
                this.dispose();
            } else if (opcion.equals(1)) {

                Fondo.add(registrarCita);
                registrarCita.setVisible(true);
                registrarCita.setLocation(0, 0);
                LabelUPDATE.setVisible(false);

                this.dispose();
            }
        } catch (Exception | Error e) {
            System.err.println(e.getMessage());
        }
    }

    public void consultarDB_limpiarDatos() {
        try {
            adminCitas.obtenerModeloTablaCitas(CitasA, "agendarCitas");
            Fecha_Cita_P.setDate(new Date());
            Estado_Cita.setText("");
            Observaciones_Cita.setText("");
            ESTADO = "";
            fechaCita = "";
            ID_SS = 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ventana_agendarCitas() {

        initComponents();
        adminCitas = new AdminCitas();
        adminCitas.obtenerModeloTablaCitas(CitasA, "agendarCitas");
        imagen = new ArchiVet.Imagen.imagenes();
        registroMascotaPropietario = new ventana_registroMascotaPropietario();
        buscadorTabla = new Buscardor_JTable();
        registrarCita = new ventana_registrarCita();
        ocultarBarraTitulo();

        Boton_Refresh.setToolTipText("Refrescar tabla");
        Fecha_Cita_P.setDate(new Date());

        h1 = new Thread(this);
        h1.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Principal = new javax.swing.JPanel();
        Panel_TOP = new javax.swing.JPanel();
        Icono_Agenda = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.calendarioa,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };
        Panel_Contenedor = new javax.swing.JPanel();
        Panel_Calendario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Fecha_Actual = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Hora_Actual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.calendario_,0,0,getWidth(),getHeight(),this);
            }
        };
        Panel_AgregarCita = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.calendarioa,0,0,getWidth(),getHeight(),this);
            }
        };
        Click_Agendar = new javax.swing.JLabel();
        Panel_EditarCita = new javax.swing.JPanel();
        Editar_Cita = new javax.swing.JLabel();
        Panel_BorrarCita = new javax.swing.JPanel();
        Borrar_Cita = new javax.swing.JLabel();
        Panel_ConsultarCitas = new javax.swing.JPanel();
        Consultar_Citas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fecha_Cita_P = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        CitasA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Observaciones_Cita = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Estado_Cita = new javax.swing.JLabel();
        Buscar_Boton = new javax.swing.JButton();
        Boton_Refresh = new javax.swing.JButton(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Actualizar_Citas,0,0,getWidth(),getHeight(),this);
            }
        };

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Panel_Principal.setBackground(new java.awt.Color(47, 69, 56));

        Panel_TOP.setBackground(new java.awt.Color(215, 208, 183));

        Icono_Agenda.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel1.setText("Agendar citas veterinarias");

        jLabel8.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_TOPLayout = new javax.swing.GroupLayout(Panel_TOP);
        Panel_TOP.setLayout(Panel_TOPLayout);
        Panel_TOPLayout.setHorizontalGroup(
            Panel_TOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TOPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Icono_Agenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        Panel_TOPLayout.setVerticalGroup(
            Panel_TOPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Icono_Agenda, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_TOPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Panel_TOPLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Contenedor.setBackground(new java.awt.Color(47, 69, 56));

        Panel_Calendario.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Calendario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CALENDARIO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Narrow", 0, 28))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel2.setText("Hoy");

        Fecha_Actual.setEditable(false);
        Fecha_Actual.setBackground(new java.awt.Color(255, 255, 255));
        Fecha_Actual.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Fecha_Actual.setForeground(new java.awt.Color(102, 102, 102));
        Fecha_Actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fecha_Actual.setText("2023-04-11");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel3.setText("Hora actual");

        Hora_Actual.setEditable(false);
        Hora_Actual.setBackground(new java.awt.Color(255, 255, 255));
        Hora_Actual.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Hora_Actual.setForeground(new java.awt.Color(102, 102, 102));
        Hora_Actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Hora_Actual.setText("07:42:00");

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout Panel_CalendarioLayout = new javax.swing.GroupLayout(Panel_Calendario);
        Panel_Calendario.setLayout(Panel_CalendarioLayout);
        Panel_CalendarioLayout.setHorizontalGroup(
            Panel_CalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_CalendarioLayout.createSequentialGroup()
                .addGroup(Panel_CalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_CalendarioLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Fecha_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_CalendarioLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_CalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CalendarioLayout.createSequentialGroup()
                        .addComponent(Hora_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CalendarioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(70, 70, 70))))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_CalendarioLayout.setVerticalGroup(
            Panel_CalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_CalendarioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(Panel_CalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_CalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hora_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Panel_AgregarCita.setBackground(new java.awt.Color(28, 186, 164));
        Panel_AgregarCita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setPreferredSize(new java.awt.Dimension(50, 50));

        Click_Agendar.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Click_Agendar.setForeground(new java.awt.Color(255, 255, 255));
        Click_Agendar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Click_Agendar.setText("Agendar la cita");
        Click_Agendar.setToolTipText("");
        Click_Agendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Click_AgendarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_AgregarCitaLayout = new javax.swing.GroupLayout(Panel_AgregarCita);
        Panel_AgregarCita.setLayout(Panel_AgregarCitaLayout);
        Panel_AgregarCitaLayout.setHorizontalGroup(
            Panel_AgregarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AgregarCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Click_Agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        Panel_AgregarCitaLayout.setVerticalGroup(
            Panel_AgregarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Click_Agendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel_EditarCita.setBackground(new java.awt.Color(138, 149, 151));
        Panel_EditarCita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Editar_Cita.setBackground(new java.awt.Color(84, 94, 96));
        Editar_Cita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Editar_Cita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Editar_Cita.setText("Editar cita");
        Editar_Cita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Editar_Cita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Editar_CitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_EditarCitaLayout = new javax.swing.GroupLayout(Panel_EditarCita);
        Panel_EditarCita.setLayout(Panel_EditarCitaLayout);
        Panel_EditarCitaLayout.setHorizontalGroup(
            Panel_EditarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Editar_Cita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_EditarCitaLayout.setVerticalGroup(
            Panel_EditarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Editar_Cita, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        Panel_BorrarCita.setBackground(new java.awt.Color(138, 149, 151));
        Panel_BorrarCita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Borrar_Cita.setBackground(new java.awt.Color(84, 94, 96));
        Borrar_Cita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Borrar_Cita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Borrar_Cita.setText("Atender Cita");
        Borrar_Cita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Borrar_Cita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Borrar_CitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_BorrarCitaLayout = new javax.swing.GroupLayout(Panel_BorrarCita);
        Panel_BorrarCita.setLayout(Panel_BorrarCitaLayout);
        Panel_BorrarCitaLayout.setHorizontalGroup(
            Panel_BorrarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BorrarCitaLayout.createSequentialGroup()
                .addComponent(Borrar_Cita, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Panel_BorrarCitaLayout.setVerticalGroup(
            Panel_BorrarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Borrar_Cita, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        Panel_ConsultarCitas.setBackground(new java.awt.Color(138, 149, 151));
        Panel_ConsultarCitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Consultar_Citas.setBackground(new java.awt.Color(84, 94, 96));
        Consultar_Citas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Consultar_Citas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Consultar_Citas.setText("Consultar citas entre fechas");
        Consultar_Citas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Consultar_Citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Consultar_CitasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_ConsultarCitasLayout = new javax.swing.GroupLayout(Panel_ConsultarCitas);
        Panel_ConsultarCitas.setLayout(Panel_ConsultarCitasLayout);
        Panel_ConsultarCitasLayout.setHorizontalGroup(
            Panel_ConsultarCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Consultar_Citas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_ConsultarCitasLayout.setVerticalGroup(
            Panel_ConsultarCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ConsultarCitasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Consultar_Citas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Seleccione la fecha de la cita");

        Fecha_Cita_P.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Fecha_Cita_P.setMinSelectableDate(new java.util.Date(1641020496000L));
        Fecha_Cita_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fecha_Cita_PMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Fecha_Cita_PMousePressed(evt);
            }
        });

        CitasA.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 110)));
        CitasA.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        CitasA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CitasA.setRowHeight(35);
        CitasA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CitasA.getTableHeader().setResizingAllowed(false);
        CitasA.getTableHeader().setReorderingAllowed(false);
        CitasA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CitasAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CitasA);

        Observaciones_Cita.setEditable(false);
        Observaciones_Cita.setBackground(new java.awt.Color(204, 204, 204));
        Observaciones_Cita.setColumns(20);
        Observaciones_Cita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Observaciones_Cita.setRows(5);
        Observaciones_Cita.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 58), 2, true));
        jScrollPane2.setViewportView(Observaciones_Cita);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Datos / Observaciones de la cita");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("Estado de la cita");

        Estado_Cita.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Estado_Cita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Estado_Cita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Buscar_Boton.setBackground(new java.awt.Color(153, 204, 255));
        Buscar_Boton.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Buscar_Boton.setForeground(new java.awt.Color(102, 102, 255));
        Buscar_Boton.setText("Buscar");
        Buscar_Boton.setBorder(null);
        Buscar_Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_BotonActionPerformed(evt);
            }
        });

        Boton_Refresh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        Boton_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ContenedorLayout = new javax.swing.GroupLayout(Panel_Contenedor);
        Panel_Contenedor.setLayout(Panel_ContenedorLayout);
        Panel_ContenedorLayout.setHorizontalGroup(
            Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Panel_Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Panel_AgregarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(Panel_BorrarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Panel_EditarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Panel_ConsultarCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(89, 89, 89)
                .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Fecha_Cita_P, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ContenedorLayout.createSequentialGroup()
                        .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_ContenedorLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Estado_Cita, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Buscar_Boton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_ContenedorLayout.setVerticalGroup(
            Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                        .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(Fecha_Cita_P, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel_Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ContenedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(Panel_AgregarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(Panel_EditarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(Panel_BorrarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(Panel_ConsultarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ContenedorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Boton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buscar_Boton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addComponent(Estado_Cita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout Panel_PrincipalLayout = new javax.swing.GroupLayout(Panel_Principal);
        Panel_Principal.setLayout(Panel_PrincipalLayout);
        Panel_PrincipalLayout.setHorizontalGroup(
            Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_TOP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel_PrincipalLayout.setVerticalGroup(
            Panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PrincipalLayout.createSequentialGroup()
                .addComponent(Panel_TOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        try {
            this.dispose();
            ventana_menu.FondoBotones.setVisible(true);
            ventana_menu.cerrar.setVisible(true);
            ventana_menu.cerrarSesion.setVisible(true);
            panel.setVisible(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void Click_AgendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Click_AgendarMouseClicked
        opcionAgendarCita(evt);
    }//GEN-LAST:event_Click_AgendarMouseClicked

    private void CitasAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CitasAMouseClicked
        mostrarDatosSeleccionados(evt);
    }//GEN-LAST:event_CitasAMouseClicked

    private void Fecha_Cita_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fecha_Cita_PMouseClicked

    }//GEN-LAST:event_Fecha_Cita_PMouseClicked

    private void Fecha_Cita_PMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fecha_Cita_PMousePressed

    }//GEN-LAST:event_Fecha_Cita_PMousePressed

    private void Buscar_BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_BotonActionPerformed
        try {
            if (Fecha_Cita_P.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Revise que no esten vacios ambos campos de busqueda", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                buscadorTabla.buscarEnTabla(adminCitas.obtenerModeloTablaCitas(CitasA, "agendarCitas"), adminCitas.obtenerCitasArray(), Formato.format(Fecha_Cita_P.getDate()), "FECHA CITA");
            }
        } catch (NullPointerException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_Buscar_BotonActionPerformed

    private void Boton_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_RefreshActionPerformed
        consultarDB_limpiarDatos();
    }//GEN-LAST:event_Boton_RefreshActionPerformed

    private void Editar_CitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Editar_CitaMouseClicked
        editarCita(evt);
    }//GEN-LAST:event_Editar_CitaMouseClicked

    private void Borrar_CitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrar_CitaMouseClicked
        atenderCita(evt);
    }//GEN-LAST:event_Borrar_CitaMouseClicked

    private void Consultar_CitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Consultar_CitasMouseClicked
        ventana_consultaEntreFechas between = new ventana_consultaEntreFechas();
        Fondo.add(between);
        between.setVisible(true);
        between.setLocation(0, 0);
        Filtraciones.Filtro_Fechas_Fechas();
        this.setVisible(false);
    }//GEN-LAST:event_Consultar_CitasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Borrar_Cita;
    private javax.swing.JButton Boton_Refresh;
    private javax.swing.JButton Buscar_Boton;
    public static javax.swing.JTable CitasA;
    private javax.swing.JLabel Click_Agendar;
    private javax.swing.JLabel Consultar_Citas;
    private javax.swing.JLabel Editar_Cita;
    public static javax.swing.JLabel Estado_Cita;
    private javax.swing.JTextField Fecha_Actual;
    public static com.toedter.calendar.JDateChooser Fecha_Cita_P;
    private javax.swing.JTextField Hora_Actual;
    private javax.swing.JLabel Icono_Agenda;
    public static javax.swing.JTextArea Observaciones_Cita;
    private javax.swing.JPanel Panel_AgregarCita;
    private javax.swing.JPanel Panel_BorrarCita;
    private javax.swing.JPanel Panel_Calendario;
    private javax.swing.JPanel Panel_ConsultarCitas;
    private javax.swing.JPanel Panel_Contenedor;
    private javax.swing.JPanel Panel_EditarCita;
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JPanel Panel_TOP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();

        while (ct == h1) {
            String Fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            calcula();
            Hora_Actual.setText(horaa + ":" + minutos + ":" + segundos + " " + AMPM);
            Fecha_Actual.setText(Fecha);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaActual = new Date();

        calendario.setTime(fechaActual);
        AMPM = calendario.get(Calendar.AM_PM) == Calendar.AM ? "am" : "pm";

        if (AMPM.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            horaa = h > 9 ? "" + h : "0" + h;
        } else {
            horaa = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
}
