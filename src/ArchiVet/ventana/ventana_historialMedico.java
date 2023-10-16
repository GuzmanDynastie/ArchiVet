package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.Modelo.Usuario;
import ArchiVet.ventana.componente.Buscardor_JTable;
import static ArchiVet.ventana.ventana_menu.panel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ventana_historialMedico extends javax.swing.JInternalFrame {

    private Usuario usuario;
    private ArchiVet.Imagen.imagenes imagen;
    private ventana_aplicarVacuna Vacuna;
    private ventana_aplicarDesparacitante Desparacitar;
    private BD.OBD obd;
    private Date Actual = new Date();
    private long longActual = Actual.getTime();
    private java.sql.Date Fecha = new java.sql.Date(longActual);
    ventana_aplicarConsulta consulta;
    private Buscardor_JTable buscadorJTable;

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void limpiar() {
        //Realizar.setText("");
        //Precio.setText("");
    }

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    public void ocultarcomponentes() {
        lMotivo.setVisible(false);
        ScrollMotivo.setVisible(false);
        lDiagnostico.setVisible(false);
        ScrollDiagnostico.setVisible(false);
        lReceta.setVisible(false);
        ScrollReceta.setVisible(false);
        lHistorialConsultas.setVisible(false);
        ScrollHistorialConsultas.setVisible(false);
        agregarconsulta.setVisible(false);
        historial1.setEnabled(false);
        cerrar.setVisible(false);
        lDate.setEnabled(false);
        Date.setEnabled(false);
        lPeso.setEnabled(false);
        Peso.setEnabled(false);
        lFC.setEnabled(false);
        FC.setEnabled(false);
        lFR.setEnabled(false);
        FR.setEnabled(false);
    }

    public void CargarTablaVacuna() {
        DefaultTableModel mode = (DefaultTableModel) TVacunas.getModel();
        mode.setRowCount(0);
        obd.tablaVacunasapli(TVacunas, mode, Mascota.getText());
    }

    public void CargarTablaDesparacitar() {
        DefaultTableModel mode = (DefaultTableModel) TDesparacitacion.getModel();
        mode.setRowCount(0);
        obd.tablaDesparapli(TDesparacitacion, mode, Mascota.getText());
    }

    public ventana_historialMedico(AdminUsuario adminUsuario) {
        initComponents();
        imagen = new ArchiVet.Imagen.imagenes();
        Desparacitar = new ventana_aplicarDesparacitante();
        consulta = new ventana_aplicarConsulta(adminUsuario);
        usuario = new Usuario();
        obd = new BD.OBD();
        ocultarBarraTitulo();

        Motivo.setLineWrap(true);
        Diagnostico.setLineWrap(true);
        Receta.setLineWrap(true);
        obd.tablaConsultas(HistorialConsultas, Mascota.getText());
        Vacuna = new ventana_aplicarVacuna(adminUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historial1 = new javax.swing.JTabbedPane();
        FondoCarnet = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TVacunas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TDesparacitacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        FondoConsultas = new javax.swing.JPanel();
        lMotivo = new javax.swing.JLabel();
        ScrollMotivo = new javax.swing.JScrollPane();
        Motivo = new javax.swing.JTextArea();
        lDiagnostico = new javax.swing.JLabel();
        ScrollDiagnostico = new javax.swing.JScrollPane();
        Diagnostico = new javax.swing.JTextArea();
        lReceta = new javax.swing.JLabel();
        ScrollReceta = new javax.swing.JScrollPane();
        Receta = new javax.swing.JTextArea();
        ScrollHistorialConsultas = new javax.swing.JScrollPane();
        HistorialConsultas = new javax.swing.JTable();
        lHistorialConsultas = new javax.swing.JLabel();
        lDate = new javax.swing.JLabel();
        Date = new com.toedter.calendar.JDateChooser();
        Filtra = new javax.swing.JLabel();
        Borrar = new javax.swing.JLabel();
        lPeso = new javax.swing.JLabel();
        Peso = new javax.swing.JTextField();
        lFC = new javax.swing.JLabel();
        FC = new javax.swing.JTextField();
        lFR = new javax.swing.JLabel();
        FR = new javax.swing.JTextField();
        agregarconsulta = new javax.swing.JButton();
        Barra1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        MAS = new javax.swing.JLabel();
        Mascota = new javax.swing.JTextField();
        PRO = new javax.swing.JLabel();
        Propietario = new javax.swing.JTextField();
        cerrar = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.cerrar,0,0,getWidth(),getHeight(),this);
            }
        };

        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        historial1.setBackground(new java.awt.Color(47, 69, 56));
        historial1.setForeground(new java.awt.Color(255, 255, 255));
        historial1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        historial1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historial1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        historial1.setOpaque(true);
        historial1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historial1MouseClicked(evt);
            }
        });

        FondoCarnet.setBackground(new java.awt.Color(47, 69, 56));

        TVacunas.setAutoCreateRowSorter(true);
        TVacunas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        TVacunas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Vacuna", "Precio", "Lote", "Medico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        TVacunas.setGridColor(new java.awt.Color(255, 255, 255));
        TVacunas.setRowHeight(25);
        TVacunas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TVacunas.setShowGrid(false);
        TVacunas.getTableHeader().setResizingAllowed(false);
        TVacunas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TVacunas);
        if (TVacunas.getColumnModel().getColumnCount() > 0) {
            TVacunas.getColumnModel().getColumn(0).setResizable(false);
            TVacunas.getColumnModel().getColumn(1).setResizable(false);
            TVacunas.getColumnModel().getColumn(2).setResizable(false);
            TVacunas.getColumnModel().getColumn(3).setResizable(false);
            TVacunas.getColumnModel().getColumn(4).setResizable(false);
        }

        TDesparacitacion.setAutoCreateRowSorter(true);
        TDesparacitacion.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        TDesparacitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Desparasitacion", "Precio", "Lote", "Medico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        TDesparacitacion.setRowHeight(25);
        TDesparacitacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TDesparacitacion.setShowGrid(false);
        TDesparacitacion.getTableHeader().setResizingAllowed(false);
        TDesparacitacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TDesparacitacion);
        if (TDesparacitacion.getColumnModel().getColumnCount() > 0) {
            TDesparacitacion.getColumnModel().getColumn(0).setResizable(false);
            TDesparacitacion.getColumnModel().getColumn(1).setResizable(false);
            TDesparacitacion.getColumnModel().getColumn(2).setResizable(false);
            TDesparacitacion.getColumnModel().getColumn(3).setResizable(false);
            TDesparacitacion.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vacunas");

        jButton1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Desparasitacion");

        jButton2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoCarnetLayout = new javax.swing.GroupLayout(FondoCarnet);
        FondoCarnet.setLayout(FondoCarnetLayout);
        FondoCarnetLayout.setHorizontalGroup(
            FondoCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoCarnetLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(FondoCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoCarnetLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1769, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(FondoCarnetLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        FondoCarnetLayout.setVerticalGroup(
            FondoCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoCarnetLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(FondoCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(FondoCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        historial1.addTab("Carnet", FondoCarnet);

        FondoConsultas.setBackground(new java.awt.Color(47, 69, 56));

        lMotivo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lMotivo.setForeground(new java.awt.Color(255, 255, 255));
        lMotivo.setText("Motivo de consulta");

        Motivo.setEditable(false);
        Motivo.setColumns(20);
        Motivo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Motivo.setRows(5);
        Motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ScrollMotivo.setViewportView(Motivo);

        lDiagnostico.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lDiagnostico.setForeground(new java.awt.Color(255, 255, 255));
        lDiagnostico.setText("Diagnostico");

        Diagnostico.setEditable(false);
        Diagnostico.setColumns(20);
        Diagnostico.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Diagnostico.setRows(5);
        Diagnostico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ScrollDiagnostico.setViewportView(Diagnostico);

        lReceta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lReceta.setForeground(new java.awt.Color(255, 255, 255));
        lReceta.setText("Receta");

        Receta.setEditable(false);
        Receta.setColumns(20);
        Receta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Receta.setRows(5);
        Receta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ScrollReceta.setViewportView(Receta);

        HistorialConsultas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        HistorialConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Motivo", "Medico", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HistorialConsultas.setMaximumSize(new java.awt.Dimension(500, 500));
        HistorialConsultas.setMinimumSize(new java.awt.Dimension(500, 500));
        HistorialConsultas.setPreferredSize(new java.awt.Dimension(500, 500));
        HistorialConsultas.setRowHeight(29);
        HistorialConsultas.getTableHeader().setResizingAllowed(false);
        HistorialConsultas.getTableHeader().setReorderingAllowed(false);
        HistorialConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistorialConsultasMouseClicked(evt);
            }
        });
        ScrollHistorialConsultas.setViewportView(HistorialConsultas);
        if (HistorialConsultas.getColumnModel().getColumnCount() > 0) {
            HistorialConsultas.getColumnModel().getColumn(0).setResizable(false);
            HistorialConsultas.getColumnModel().getColumn(0).setPreferredWidth(150);
            HistorialConsultas.getColumnModel().getColumn(1).setResizable(false);
            HistorialConsultas.getColumnModel().getColumn(1).setPreferredWidth(200);
            HistorialConsultas.getColumnModel().getColumn(2).setResizable(false);
            HistorialConsultas.getColumnModel().getColumn(2).setPreferredWidth(150);
            HistorialConsultas.getColumnModel().getColumn(3).setResizable(false);
            HistorialConsultas.getColumnModel().getColumn(3).setPreferredWidth(1);
            HistorialConsultas.getColumnModel().getColumn(4).setResizable(false);
            HistorialConsultas.getColumnModel().getColumn(4).setPreferredWidth(1);
            HistorialConsultas.getColumnModel().getColumn(5).setResizable(false);
            HistorialConsultas.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        lHistorialConsultas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lHistorialConsultas.setForeground(new java.awt.Color(255, 255, 255));
        lHistorialConsultas.setText("Consultas Anteriores");

        lDate.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lDate.setForeground(new java.awt.Color(255, 255, 255));
        lDate.setText("Filtar fecha");
        lDate.setPreferredSize(new java.awt.Dimension(100, 29));

        Date.setPreferredSize(new java.awt.Dimension(100, 29));

        Filtra.setText("jLabel3");
        Filtra.setMaximumSize(new java.awt.Dimension(50, 50));
        Filtra.setMinimumSize(new java.awt.Dimension(50, 50));
        Filtra.setPreferredSize(new java.awt.Dimension(50, 50));
        Filtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FiltraMouseClicked(evt);
            }
        });

        Borrar.setText("jLabel8");
        Borrar.setMaximumSize(new java.awt.Dimension(50, 50));
        Borrar.setMinimumSize(new java.awt.Dimension(50, 50));
        Borrar.setPreferredSize(new java.awt.Dimension(50, 50));
        Borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BorrarMouseClicked(evt);
            }
        });

        lPeso.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lPeso.setForeground(new java.awt.Color(255, 255, 255));
        lPeso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPeso.setText("Peso");
        lPeso.setMaximumSize(new java.awt.Dimension(100, 29));
        lPeso.setMinimumSize(new java.awt.Dimension(100, 29));
        lPeso.setPreferredSize(new java.awt.Dimension(100, 29));

        Peso.setEditable(false);
        Peso.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Peso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Peso.setMaximumSize(new java.awt.Dimension(100, 29));
        Peso.setMinimumSize(new java.awt.Dimension(100, 29));
        Peso.setPreferredSize(new java.awt.Dimension(100, 29));

        lFC.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lFC.setForeground(new java.awt.Color(255, 255, 255));
        lFC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lFC.setText("F.C.");
        lFC.setMaximumSize(new java.awt.Dimension(100, 29));
        lFC.setMinimumSize(new java.awt.Dimension(100, 29));
        lFC.setPreferredSize(new java.awt.Dimension(100, 29));

        FC.setEditable(false);
        FC.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        FC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FC.setMaximumSize(new java.awt.Dimension(100, 29));
        FC.setMinimumSize(new java.awt.Dimension(100, 29));
        FC.setPreferredSize(new java.awt.Dimension(100, 29));

        lFR.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lFR.setForeground(new java.awt.Color(255, 255, 255));
        lFR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lFR.setText("F.R.");
        lFR.setMaximumSize(new java.awt.Dimension(100, 29));
        lFR.setMinimumSize(new java.awt.Dimension(100, 29));
        lFR.setPreferredSize(new java.awt.Dimension(100, 29));

        FR.setEditable(false);
        FR.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        FR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FR.setMaximumSize(new java.awt.Dimension(100, 29));
        FR.setMinimumSize(new java.awt.Dimension(100, 29));
        FR.setPreferredSize(new java.awt.Dimension(100, 29));

        agregarconsulta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        agregarconsulta.setText("Agregar");
        agregarconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarconsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoConsultasLayout = new javax.swing.GroupLayout(FondoConsultas);
        FondoConsultas.setLayout(FondoConsultasLayout);
        FondoConsultasLayout.setHorizontalGroup(
            FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoConsultasLayout.createSequentialGroup()
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FondoConsultasLayout.createSequentialGroup()
                                .addComponent(Filtra, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lHistorialConsultas))
                    .addComponent(ScrollHistorialConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScrollDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lDiagnostico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lReceta))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoConsultasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(agregarconsulta)
                .addGap(800, 800, 800))
        );
        FondoConsultasLayout.setVerticalGroup(
            FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoConsultasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lReceta)
                        .addComponent(lDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addComponent(ScrollReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoConsultasLayout.createSequentialGroup()
                                .addComponent(ScrollMotivo)
                                .addGap(18, 18, 18)
                                .addComponent(lDiagnostico)
                                .addGap(18, 18, 18)
                                .addComponent(ScrollDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoConsultasLayout.createSequentialGroup()
                                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Filtra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lHistorialConsultas)
                                .addGap(18, 18, 18)
                                .addComponent(ScrollHistorialConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33)
                        .addComponent(agregarconsulta)
                        .addGap(31, 31, 31))))
        );

        historial1.addTab("Consultas", FondoConsultas);

        Barra1.setBackground(new java.awt.Color(215, 208, 183));
        Barra1.setToolTipText("");

        Titulo.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Titulo.setText("Historial Medico");
        Titulo.setMaximumSize(new java.awt.Dimension(150, 35));
        Titulo.setMinimumSize(new java.awt.Dimension(150, 35));
        Titulo.setPreferredSize(new java.awt.Dimension(150, 35));

        MAS.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MAS.setForeground(new java.awt.Color(0, 0, 0));
        MAS.setText("Mascota");
        MAS.setMaximumSize(new java.awt.Dimension(100, 35));
        MAS.setMinimumSize(new java.awt.Dimension(100, 35));
        MAS.setPreferredSize(new java.awt.Dimension(100, 35));

        Mascota.setEditable(false);
        Mascota.setBackground(new java.awt.Color(215, 208, 183));
        Mascota.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Mascota.setForeground(new java.awt.Color(0, 0, 0));
        Mascota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Mascota.setFocusable(false);
        Mascota.setMaximumSize(new java.awt.Dimension(100, 35));
        Mascota.setMinimumSize(new java.awt.Dimension(100, 35));
        Mascota.setPreferredSize(new java.awt.Dimension(100, 35));
        Mascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MascotaMouseClicked(evt);
            }
        });

        PRO.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        PRO.setForeground(new java.awt.Color(0, 0, 0));
        PRO.setText("Propietario");
        PRO.setMaximumSize(new java.awt.Dimension(100, 35));
        PRO.setMinimumSize(new java.awt.Dimension(100, 35));
        PRO.setPreferredSize(new java.awt.Dimension(100, 35));

        Propietario.setEditable(false);
        Propietario.setBackground(new java.awt.Color(215, 208, 183));
        Propietario.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Propietario.setForeground(new java.awt.Color(0, 0, 0));
        Propietario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Propietario.setFocusable(false);
        Propietario.setMaximumSize(new java.awt.Dimension(400, 35));
        Propietario.setMinimumSize(new java.awt.Dimension(400, 35));
        Propietario.setPreferredSize(new java.awt.Dimension(400, 35));
        Propietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PropietarioMouseClicked(evt);
            }
        });

        cerrar.setMaximumSize(new java.awt.Dimension(50, 50));
        cerrar.setMinimumSize(new java.awt.Dimension(50, 50));
        cerrar.setPreferredSize(new java.awt.Dimension(50, 50));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Barra1Layout = new javax.swing.GroupLayout(Barra1);
        Barra1.setLayout(Barra1Layout);
        Barra1Layout.setHorizontalGroup(
            Barra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MAS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Mascota, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Propietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Barra1Layout.setVerticalGroup(
            Barra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Barra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Barra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Mascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Propietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Barra1Layout.createSequentialGroup()
                        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(Barra1Layout.createSequentialGroup()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Barra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(historial1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Barra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historial1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void historial1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historial1MouseClicked
        CargarTablaVacuna();
        CargarTablaDesparacitar();
    }//GEN-LAST:event_historial1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vacuna.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Desparacitar.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MascotaMouseClicked
        //obd.datcosnu(Nombre.getSelectedItem().toString(), Mascota);
    }//GEN-LAST:event_MascotaMouseClicked

    private void PropietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PropietarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        ventana_menu.FondoBotones.setVisible(true);
        ventana_menu.cerrar.setVisible(true);
        this.dispose();
        panel.setVisible(true);
    }//GEN-LAST:event_cerrarMouseClicked

    private void agregarconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarconsultaActionPerformed
        ocultarcomponentes();
        FondoConsultas.add(consulta);
        consulta.setVisible(true);
    }//GEN-LAST:event_agregarconsultaActionPerformed

    private void HistorialConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistorialConsultasMouseClicked
        Motivo.setText(String.valueOf(HistorialConsultas.getValueAt(HistorialConsultas.getSelectedRow(), 1)));
        Diagnostico.setText(String.valueOf(HistorialConsultas.getValueAt(HistorialConsultas.getSelectedRow(), 3)));
        Receta.setText(String.valueOf(HistorialConsultas.getValueAt(HistorialConsultas.getSelectedRow(), 4)));
        String[] parametros = (String.valueOf(HistorialConsultas.getValueAt(HistorialConsultas.getSelectedRow(), 5))).split("/");
        Peso.setText(parametros[0]);
        FC.setText(parametros[1]);
        FR.setText(parametros[2]);
    }//GEN-LAST:event_HistorialConsultasMouseClicked

    private void FiltraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FiltraMouseClicked
        SimpleDateFormat filtro = new SimpleDateFormat("yyyy-MM-dd");

        /*TableRowSorter<DefaultTableModel> Sorter;
        DefaultTableModel Modelo = (DefaultTableModel) this.HistorialConsultas.getModel();
        Sorter = new TableRowSorter<>(Modelo);
        HistorialConsultas.setRowSorter(Sorter);
        Sorter.setRowFilter(RowFilter.regexFilter(filtro.format(Date), 0));*/
        DefaultTableModel mode = (DefaultTableModel) HistorialConsultas.getModel();
        //buscadorJTable.buscarEnTabla(mode, , filtro, "Fecha");
    }//GEN-LAST:event_FiltraMouseClicked

    private void BorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarMouseClicked

    }//GEN-LAST:event_BorrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra1;
    public static javax.swing.JLabel Borrar;
    public static com.toedter.calendar.JDateChooser Date;
    public static javax.swing.JTextArea Diagnostico;
    public static javax.swing.JTextField FC;
    public static javax.swing.JTextField FR;
    public static javax.swing.JLabel Filtra;
    private javax.swing.JPanel FondoCarnet;
    private javax.swing.JPanel FondoConsultas;
    public static javax.swing.JTable HistorialConsultas;
    private javax.swing.JLabel MAS;
    public static javax.swing.JTextField Mascota;
    public static javax.swing.JTextArea Motivo;
    private javax.swing.JLabel PRO;
    public static javax.swing.JTextField Peso;
    public static javax.swing.JTextField Propietario;
    public static javax.swing.JTextArea Receta;
    public static javax.swing.JScrollPane ScrollDiagnostico;
    public static javax.swing.JScrollPane ScrollHistorialConsultas;
    public static javax.swing.JScrollPane ScrollMotivo;
    public static javax.swing.JScrollPane ScrollReceta;
    public static javax.swing.JTable TDesparacitacion;
    public static javax.swing.JTable TVacunas;
    private javax.swing.JLabel Titulo;
    public static javax.swing.JButton agregarconsulta;
    public static javax.swing.JLabel cerrar;
    public static javax.swing.JTabbedPane historial1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lDate;
    public static javax.swing.JLabel lDiagnostico;
    public static javax.swing.JLabel lFC;
    public static javax.swing.JLabel lFR;
    private javax.swing.JLabel lHistorialConsultas;
    public static javax.swing.JLabel lMotivo;
    public static javax.swing.JLabel lPeso;
    public static javax.swing.JLabel lReceta;
    // End of variables declaration//GEN-END:variables
}
