package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.ventana.componente.Creacion_PDF;
import Archivet.Controlador.Filtraciones;
import static ArchiVet.ventana.ventana_puntoVenta.ID_PET;
import static ArchiVet.ventana.ventana_puntoVenta.NAME_PET;
import static ArchiVet.ventana.ventana_puntoVenta.Nombre_Seleccionado;
import static ArchiVet.ventana.ventana_puntoVenta.NumeroID;
import static ArchiVet.ventana.ventana_puntoVenta.SALDO;
import static ArchiVet.ventana.ventana_menu.Fondo;
import static ArchiVet.ventana.ventana_pagarCaja.Descripcion_Pagar_Cuenta;
import static ArchiVet.ventana.ventana_pagarCaja.Hora_Fecha;
import static ArchiVet.ventana.ventana_pagarCaja.Nombre_Mascota_Pagar_Cuenta;
import static ArchiVet.ventana.ventana_pagarCaja.Total_Pagar_Cuenta;
import com.lowagie.text.DocumentException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ventana_mostradorCaja extends javax.swing.JInternalFrame {

    private static Filtraciones filtraciones;
    private static Creacion_PDF creacion_pdf;
    private ArchiVet.Imagen.imagenes imagen;
    private AdminUsuario adminUsuario;

    public static ArrayList VACUNAS = new ArrayList();
    public static ArrayList MEDICAMENTOS = new ArrayList();
    public static ArrayList DESPARACITANTES = new ArrayList();

    public static int Seleccion, Contador_Servicio, STOCK;
    public static String TFolio, TMascota, TPropietario, TDescripcion, TFecha, TCargo, LOTE;
    public static String sexoMascota, PRODUCTOS_EXISTENTES;

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void tablaProductosADD() {
        String[] TITULOS = {"DESCRIPCION", "LOTE", "PRECIO UNITARIO", "CADUCIDAD", "PIEZAS", "BORRAR", ""};
        DefaultTableModel model = new DefaultTableModel(null, TITULOS);
        int[] columnWidths = {640, 460, 190, 245, 115, 65, 0};
        Tabla_PRODUCTOS_ADD.setModel(model);
        TableColumnModel columnModel = Tabla_PRODUCTOS_ADD.getColumnModel();

        // Configurar el ancho preferido para cada columna en función del arreglo
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }

    private void volver() {
        try {
            Filtraciones.UPDATE_VACUNAS(STOCK, LOTE);
            Filtraciones.UPDATE_MEDICAMENTOS(STOCK, LOTE);
            Filtraciones.UPDATE_DESPARACITANTES(STOCK, LOTE);

            ventana_puntoVenta cuenta = new ventana_puntoVenta(adminUsuario);
            ventana_puntoVenta.Titulo.setText("Cuenta");
            cuenta.logoCuenta = imagen.recibo;

            Fondo.add(cuenta);
            cuenta.setVisible(true);
            cuenta.setLocation(310, 180);

            this.dispose();
            Descripcion_Area.setText("");
            PAGO.setText("");

        } catch (Exception | ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        }
    }

    public ventana_mostradorCaja(AdminUsuario adminUsuario) {

        initComponents();
        imagen = new ArchiVet.Imagen.imagenes();
        creacion_pdf = new Creacion_PDF();
        filtraciones = new Filtraciones();
        ocultarBarraTitulo();
        Buscador_Mascota.setEditable(false);
        this.adminUsuario = adminUsuario;

        Filtraciones.BusquedaMascota_Fecha("", "");
        tablaProductosADD();
        Volver.setToolTipText("Volver");
        Font myFont2 = new Font("Arial", Font.CENTER_BASELINE, 25);
        Venta.setFont(myFont2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Volver = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.volver,0,0,getWidth(),getHeight(),this);
            }
        };
        Venta = new javax.swing.JTabbedPane();
        Panel_Cuenta = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Usuario = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.usuario,0,0,getWidth(),getHeight(),this);
            }
        };
        Nombre_Usuario_Cuenta = new javax.swing.JTextField();
        Pagar_Cuenta = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.dinero,0,0,getWidth(),getHeight(),this);
            }
        };
        jSeparator2 = new javax.swing.JSeparator();
        Pago = new javax.swing.JTextField();
        Button_PAY_Cuenta = new javax.swing.JButton();
        Total_Cuenta = new javax.swing.JTextField();
        PAGO = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Venta_Extras = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Descripcion_Area = new javax.swing.JTextArea();
        Pago1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabla_PRODUCTOS_ADD = new javax.swing.JTable();
        Pago3 = new javax.swing.JTextField();
        Agregar_otros = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Agregar_Producto,0,0,getWidth(),getHeight(),this);
            }
        };
        Panel_Historial = new javax.swing.JPanel();
        jSeparator19 = new javax.swing.JSeparator();
        Usuario2 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.usuario,0,0,getWidth(),getHeight(),this);
            }
        };
        Nombre_Usuario_Historial = new javax.swing.JTextField();
        Historial = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.hora,0,0,getWidth(),getHeight(),this);
            }
        };
        Pago4 = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_Historial = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.pdf,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel6 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.mascotas3,0,0,getWidth(),getHeight(),this);
            }
        };
        Buscador_Mascota = new javax.swing.JTextField();
        Buscador_Fecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cal1,0,0,getWidth(),getHeight(),this);
            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        Descripcion_Area_Historial = new javax.swing.JTextArea();
        Pago2 = new javax.swing.JTextField();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(47, 69, 56));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel2.setBackground(new java.awt.Color(215, 208, 183));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        Volver.setPreferredSize(new java.awt.Dimension(50, 50));
        Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1864, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Venta.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Venta.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Venta.setInheritsPopupMenu(true);
        Venta.setPreferredSize(new java.awt.Dimension(1456, 960));
        Venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentaMouseClicked(evt);
            }
        });

        Panel_Cuenta.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Cuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(215, 208, 183)));
        Panel_Cuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Cuenta.setPreferredSize(new java.awt.Dimension(1387, 930));

        jSeparator1.setBackground(new java.awt.Color(47, 69, 56));
        jSeparator1.setForeground(new java.awt.Color(47, 69, 56));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);

        Usuario.setPreferredSize(new java.awt.Dimension(50, 50));

        Nombre_Usuario_Cuenta.setEditable(false);
        Nombre_Usuario_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_Usuario_Cuenta.setBorder(null);
        Nombre_Usuario_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_Usuario_CuentaActionPerformed(evt);
            }
        });

        Pagar_Cuenta.setPreferredSize(new java.awt.Dimension(50, 50));

        Pago.setEditable(false);
        Pago.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Pago.setText("Realizar Pago...");
        Pago.setBorder(null);
        Pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoActionPerformed(evt);
            }
        });

        Button_PAY_Cuenta.setBackground(new java.awt.Color(0, 102, 255));
        Button_PAY_Cuenta.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        Button_PAY_Cuenta.setForeground(new java.awt.Color(153, 204, 255));
        Button_PAY_Cuenta.setText("Pagar");
        Button_PAY_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PAY_CuentaActionPerformed(evt);
            }
        });

        Total_Cuenta.setEditable(false);
        Total_Cuenta.setFont(new java.awt.Font("Arial Narrow", 0, 32)); // NOI18N
        Total_Cuenta.setText("0.00");
        Total_Cuenta.setBorder(null);
        Total_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_CuentaActionPerformed(evt);
            }
        });

        PAGO.setEditable(false);
        PAGO.setFont(new java.awt.Font("Arial Narrow", 0, 32)); // NOI18N
        PAGO.setText("$");
        PAGO.setBorder(null);
        PAGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAGOActionPerformed(evt);
            }
        });

        Tabla_Venta_Extras.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 69)));
        Tabla_Venta_Extras.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Venta_Extras.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "ID_Mascota", "Nombre_Mascota", "Servicio", "ID_Propietario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Venta_Extras.setToolTipText("");
        Tabla_Venta_Extras.setRowHeight(35);
        Tabla_Venta_Extras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Venta_Extras.getTableHeader().setResizingAllowed(false);
        Tabla_Venta_Extras.getTableHeader().setReorderingAllowed(false);
        Tabla_Venta_Extras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_Venta_ExtrasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Venta_Extras);
        Tabla_Venta_Extras.getAccessibleContext().setAccessibleName("");

        Descripcion_Area.setEditable(false);
        Descripcion_Area.setColumns(20);
        Descripcion_Area.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Descripcion_Area.setRows(5);
        jScrollPane2.setViewportView(Descripcion_Area);

        Pago1.setEditable(false);
        Pago1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Pago1.setText("Descripcion");
        Pago1.setBorder(null);
        Pago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pago1ActionPerformed(evt);
            }
        });

        Tabla_PRODUCTOS_ADD.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 3, 65)));
        Tabla_PRODUCTOS_ADD.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_PRODUCTOS_ADD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DESCRIPCION", "LOTE", "PRECIO UNITARIO", "CADUCIDAD", "PIEZAS", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_PRODUCTOS_ADD.setToolTipText("");
        Tabla_PRODUCTOS_ADD.setRowHeight(35);
        Tabla_PRODUCTOS_ADD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_PRODUCTOS_ADD.getTableHeader().setResizingAllowed(false);
        Tabla_PRODUCTOS_ADD.getTableHeader().setReorderingAllowed(false);
        Tabla_PRODUCTOS_ADD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tabla_PRODUCTOS_ADDFocusLost(evt);
            }
        });
        Tabla_PRODUCTOS_ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_PRODUCTOS_ADDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(Tabla_PRODUCTOS_ADD);

        Pago3.setEditable(false);
        Pago3.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Pago3.setText("Agregar otros");
        Pago3.setBorder(null);
        Pago3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pago3ActionPerformed(evt);
            }
        });

        Agregar_otros.setPreferredSize(new java.awt.Dimension(50, 50));
        Agregar_otros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_otrosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_CuentaLayout = new javax.swing.GroupLayout(Panel_Cuenta);
        Panel_Cuenta.setLayout(Panel_CuentaLayout);
        Panel_CuentaLayout.setHorizontalGroup(
            Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(Panel_CuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_CuentaLayout.createSequentialGroup()
                        .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1827, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1827, Short.MAX_VALUE)
                            .addGroup(Panel_CuentaLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nombre_Usuario_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(Panel_CuentaLayout.createSequentialGroup()
                        .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_CuentaLayout.createSequentialGroup()
                                .addComponent(Pago3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Agregar_otros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1079, Short.MAX_VALUE))))
            .addGroup(Panel_CuentaLayout.createSequentialGroup()
                .addGap(818, 818, 818)
                .addComponent(PAGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Total_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CuentaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_PAY_Cuenta)
                .addGap(16, 16, 16))
        );
        Panel_CuentaLayout.setVerticalGroup(
            Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_CuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_Usuario_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CuentaLayout.createSequentialGroup()
                        .addComponent(Button_PAY_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CuentaLayout.createSequentialGroup()
                        .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pagar_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PAGO, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel_CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Agregar_otros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pago3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Pago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Venta.addTab("Cuenta", Panel_Cuenta);

        Panel_Historial.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Historial.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(215, 208, 183)));
        Panel_Historial.setPreferredSize(new java.awt.Dimension(1387, 930));

        jSeparator19.setBackground(new java.awt.Color(47, 69, 56));
        jSeparator19.setForeground(new java.awt.Color(47, 69, 56));
        jSeparator19.setAlignmentX(1.0F);
        jSeparator19.setAlignmentY(1.0F);

        Usuario2.setPreferredSize(new java.awt.Dimension(50, 50));

        Nombre_Usuario_Historial.setEditable(false);
        Nombre_Usuario_Historial.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Nombre_Usuario_Historial.setBorder(null);
        Nombre_Usuario_Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_Usuario_HistorialActionPerformed(evt);
            }
        });

        Historial.setPreferredSize(new java.awt.Dimension(50, 50));

        Pago4.setEditable(false);
        Pago4.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Pago4.setText("Historial");
        Pago4.setBorder(null);
        Pago4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pago4ActionPerformed(evt);
            }
        });

        jSeparator20.setBackground(new java.awt.Color(47, 69, 56));
        jSeparator20.setForeground(new java.awt.Color(47, 69, 56));
        jSeparator20.setAlignmentX(1.0F);
        jSeparator20.setAlignmentY(1.0F);

        Tabla_Historial.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Historial.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Historial.setRowHeight(35);
        Tabla_Historial.setRowSelectionAllowed(false);
        Tabla_Historial.getTableHeader().setResizingAllowed(false);
        Tabla_Historial.getTableHeader().setReorderingAllowed(false);
        Tabla_Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_HistorialMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla_Historial);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));

        Buscador_Mascota.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Buscador_Mascota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Buscador_MascotaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Buscador_MascotaFocusLost(evt);
            }
        });
        Buscador_Mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscador_MascotaActionPerformed(evt);
            }
        });
        Buscador_Mascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Buscador_MascotaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Buscador_MascotaKeyTyped(evt);
            }
        });

        Buscador_Fecha.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Buscador_Fecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Buscador_FechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Buscador_FechaFocusLost(evt);
            }
        });
        Buscador_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscador_FechaActionPerformed(evt);
            }
        });
        Buscador_Fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Buscador_FechaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Buscador_FechaKeyTyped(evt);
            }
        });

        jLabel7.setPreferredSize(new java.awt.Dimension(50, 50));

        Descripcion_Area_Historial.setEditable(false);
        Descripcion_Area_Historial.setColumns(20);
        Descripcion_Area_Historial.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Descripcion_Area_Historial.setRows(5);
        jScrollPane4.setViewportView(Descripcion_Area_Historial);

        Pago2.setEditable(false);
        Pago2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Pago2.setText("Servicios aplicados");
        Pago2.setBorder(null);
        Pago2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pago2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_HistorialLayout = new javax.swing.GroupLayout(Panel_Historial);
        Panel_Historial.setLayout(Panel_HistorialLayout);
        Panel_HistorialLayout.setHorizontalGroup(
            Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_HistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(Panel_HistorialLayout.createSequentialGroup()
                        .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pago2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_HistorialLayout.createSequentialGroup()
                                .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_HistorialLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Historial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Pago4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nombre_Usuario_Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Panel_HistorialLayout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscador_Mascota, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscador_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 501, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator19, javax.swing.GroupLayout.DEFAULT_SIZE, 1839, Short.MAX_VALUE))
            .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator20, javax.swing.GroupLayout.DEFAULT_SIZE, 1839, Short.MAX_VALUE))
        );
        Panel_HistorialLayout.setVerticalGroup(
            Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_HistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_Usuario_Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Buscador_Fecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(Buscador_Mascota, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pago4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Pago2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_HistorialLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(917, Short.MAX_VALUE)))
            .addGroup(Panel_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_HistorialLayout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(842, Short.MAX_VALUE)))
        );

        Venta.addTab("Historial", Panel_Historial);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(Venta, javax.swing.GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1001, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(66, Short.MAX_VALUE)
                    .addComponent(Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

    }//GEN-LAST:event_jPanel2MousePressed

    private void Nombre_Usuario_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_Usuario_CuentaActionPerformed

    }//GEN-LAST:event_Nombre_Usuario_CuentaActionPerformed

    private void PagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PagoActionPerformed

    private void Button_PAY_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PAY_CuentaActionPerformed
        double TO = Double.parseDouble(Total_Cuenta.getText());
        if (TO <= 0) {
            JOptionPane.showMessageDialog(null, "No es posible acceder a pagar, este \ncliente no tiene adeudo", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ventana_pagarCaja pagarCaja = new ventana_pagarCaja();
            Fondo.add(pagarCaja);
            pagarCaja.setVisible(true);
            pagarCaja.setLocation(0, 0);
            ventana_pagarCaja.Nombre_Usuario_Pagar_Cuenta.setText(Nombre_Seleccionado.getText().trim());
            Filtraciones.cargarNombre_Mascota(NumeroID, ID_PET, Nombre_Mascota_Pagar_Cuenta, Total_Pagar_Cuenta);
            Total_Pagar_Cuenta.setText(Total_Cuenta.getText());
            Filtraciones.cargarDescripcion_Pagos(NumeroID, ID_PET, Descripcion_Pagar_Cuenta);
            Nombre_Mascota_Pagar_Cuenta.setText(NAME_PET);

            DefaultTableModel D = (DefaultTableModel) Tabla_PRODUCTOS_ADD.getModel();
            String Piezas = "", Precio = "", Producto = "";
            for (int i = 0; i < Tabla_PRODUCTOS_ADD.getRowCount(); i++) {
                Piezas = String.valueOf(D.getValueAt(i, 4));
                Precio = String.valueOf(D.getValueAt(i, 2));
                Producto = String.valueOf(D.getValueAt(i, 0));

                String Formato = String.format("%10s %12s", Piezas + " piezas", "    |    $" + Precio + "      |      " + Producto + "\n");

                Descripcion_Pagar_Cuenta.append(Formato);
            }

            Hora_Fecha.setText(new SimpleDateFormat("EEEEEEEEE, dd/MM/yyyy").format(Calendar.getInstance().getTime()));

            this.setVisible(false);
        }

    }//GEN-LAST:event_Button_PAY_CuentaActionPerformed

    private void Total_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_CuentaActionPerformed

    }//GEN-LAST:event_Total_CuentaActionPerformed

    private void PAGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAGOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PAGOActionPerformed

    private void Nombre_Usuario_HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_Usuario_HistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_Usuario_HistorialActionPerformed

    private void Pago4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pago4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pago4ActionPerformed

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked
        volver();
    }//GEN-LAST:event_VolverMouseClicked

    private void Tabla_Venta_ExtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_Venta_ExtrasMouseClicked

    }//GEN-LAST:event_Tabla_Venta_ExtrasMouseClicked

    private void Pago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pago1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pago1ActionPerformed

    private void Tabla_HistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_HistorialMouseClicked
        try {
            Seleccion = Tabla_Historial.rowAtPoint(evt.getPoint());
            TFolio = String.valueOf(Tabla_Historial.getValueAt(Seleccion, 0));
            TMascota = String.valueOf(Tabla_Historial.getValueAt(Seleccion, 1));
            TPropietario = String.valueOf(Tabla_Historial.getValueAt(Seleccion, 3));
            TDescripcion = String.valueOf(Tabla_Historial.getValueAt(Seleccion, 4));
            TFecha = String.valueOf(Tabla_Historial.getValueAt(Seleccion, 5));
            TCargo = String.valueOf(Tabla_Historial.getValueAt(Seleccion, 6));

            Descripcion_Area_Historial.setText(TDescripcion);

        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_Tabla_HistorialMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            creacion_pdf.PDF_Historial(TFecha, TFolio, TPropietario, TMascota, TDescripcion, TCargo);
        } catch (FileNotFoundException | DocumentException | NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Buscador_MascotaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador_MascotaFocusGained

    }//GEN-LAST:event_Buscador_MascotaFocusGained

    private void Buscador_MascotaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador_MascotaFocusLost

    }//GEN-LAST:event_Buscador_MascotaFocusLost

    private void Buscador_MascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscador_MascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador_MascotaActionPerformed

    private void Buscador_MascotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Buscador_MascotaKeyReleased
        Filtraciones.BusquedaMascota_Fecha(Buscador_Mascota.getText(), Buscador_Fecha.getText());
    }//GEN-LAST:event_Buscador_MascotaKeyReleased

    private void Buscador_MascotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Buscador_MascotaKeyTyped

    }//GEN-LAST:event_Buscador_MascotaKeyTyped

    private void Buscador_FechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador_FechaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador_FechaFocusGained

    private void Buscador_FechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Buscador_FechaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador_FechaFocusLost

    private void Buscador_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscador_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador_FechaActionPerformed

    private void Buscador_FechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Buscador_FechaKeyReleased
        Filtraciones.BusquedaMascota_Fecha(Buscador_Mascota.getText(), Buscador_Fecha.getText());
    }//GEN-LAST:event_Buscador_FechaKeyReleased

    private void Buscador_FechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Buscador_FechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscador_FechaKeyTyped

    private void Pago2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pago2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pago2ActionPerformed

    private void VentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentaMouseClicked
        Descripcion_Area_Historial.setText("");
    }//GEN-LAST:event_VentaMouseClicked

    private void Tabla_PRODUCTOS_ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PRODUCTOS_ADDMouseClicked
        int Seleccion = Tabla_PRODUCTOS_ADD.rowAtPoint(evt.getPoint());
        int columna = Tabla_PRODUCTOS_ADD.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / Tabla_PRODUCTOS_ADD.getRowHeight();

        LOTE = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(Seleccion, 1));
        STOCK = Integer.parseInt(Tabla_PRODUCTOS_ADD.getValueAt(Seleccion, 6).toString());

        try {
            if (fila < Tabla_PRODUCTOS_ADD.getRowCount() && fila >= 0 && columna < Tabla_PRODUCTOS_ADD.getColumnCount() && columna >= 0) {
                Object value = Tabla_PRODUCTOS_ADD.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;

                    if (boton.getName().equalsIgnoreCase("E")) {

                        JOptionPane.showMessageDialog(null, "Eliminar");
                        DefaultTableModel D = (DefaultTableModel) Tabla_PRODUCTOS_ADD.getModel();
                        D.removeRow(Seleccion);

                        double Piezas, Precio;
                        double MAXT = 0;

                        for (int i = 0; i < Tabla_PRODUCTOS_ADD.getRowCount(); i++) {

                            Precio = Double.parseDouble(Tabla_PRODUCTOS_ADD.getValueAt(i, 2).toString());
                            Piezas = Double.parseDouble(Tabla_PRODUCTOS_ADD.getValueAt(i, 4).toString());

                            MAXT += Precio * Piezas;
                        }

                        double SUM_TOTAL = MAXT + SALDO;

                        Total_Cuenta.setText(String.valueOf(SUM_TOTAL));

                        System.out.println(SUM_TOTAL);
                        Filtraciones.UPDATE_VACUNAS(STOCK, LOTE);
                        Filtraciones.UPDATE_MEDICAMENTOS(STOCK, LOTE);
                        Filtraciones.UPDATE_DESPARACITANTES(STOCK, LOTE);

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
        } catch (NumberFormatException | Error e) {
        }

    }//GEN-LAST:event_Tabla_PRODUCTOS_ADDMouseClicked

    private void Pago3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pago3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pago3ActionPerformed

    private void Agregar_otrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_otrosMouseClicked
        try {
            ventana_productos productos = new ventana_productos();
            Fondo.add(productos);
            this.setVisible(false);
            productos.setVisible(true);
            productos.setLocation(0, 0);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_Agregar_otrosMouseClicked

    private void Tabla_PRODUCTOS_ADDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tabla_PRODUCTOS_ADDFocusLost

    }//GEN-LAST:event_Tabla_PRODUCTOS_ADDFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agregar_otros;
    public static javax.swing.JTextField Buscador_Fecha;
    public static javax.swing.JTextField Buscador_Mascota;
    private javax.swing.JButton Button_PAY_Cuenta;
    public static javax.swing.JTextArea Descripcion_Area;
    public static javax.swing.JTextArea Descripcion_Area_Historial;
    private javax.swing.JLabel Historial;
    public static javax.swing.JTextField Nombre_Usuario_Cuenta;
    public static javax.swing.JTextField Nombre_Usuario_Historial;
    public static javax.swing.JTextField PAGO;
    private javax.swing.JLabel Pagar_Cuenta;
    private javax.swing.JTextField Pago;
    private javax.swing.JTextField Pago1;
    private javax.swing.JTextField Pago2;
    private javax.swing.JTextField Pago3;
    private javax.swing.JTextField Pago4;
    public static javax.swing.JPanel Panel_Cuenta;
    public static javax.swing.JPanel Panel_Historial;
    public static javax.swing.JTable Tabla_Historial;
    public static javax.swing.JTable Tabla_PRODUCTOS_ADD;
    public static javax.swing.JTable Tabla_Venta_Extras;
    public static javax.swing.JTextField Total_Cuenta;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel Usuario2;
    public static javax.swing.JTabbedPane Venta;
    private javax.swing.JLabel Volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    // End of variables declaration//GEN-END:variables
}
