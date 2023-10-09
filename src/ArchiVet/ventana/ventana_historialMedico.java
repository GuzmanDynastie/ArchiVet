package ArchiVet.ventana;

import ArchiVet.Admin.AdminUsuario;
import ArchiVet.Modelo.Usuario;
import static ArchiVet.ventana.ventana_menu.panel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

public class ventana_historialMedico extends javax.swing.JInternalFrame {

    private Usuario usuario;
    private ArchiVet.Imagen.imagenes imagen;
    private ventana_aplicarVacuna Vacuna;
    private ventana_aplicarDesparacitante Desparacitar;
    private BD.OBD obd;
    private Date Actual = new Date();
    private long longActual = Actual.getTime();
    private java.sql.Date Fecha = new java.sql.Date(longActual);

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void limpiar() {
        Realizar.setText("");
        Precio.setText("");
    }

    private void subir() {
        obd.subirConsulta(8, Mascota.getText(), Fecha, "Consulta", Float.parseFloat(Precio.getText()), Realizar.getText(), 2, usuario.getUsuario());
        obd.historial(8, Mascota.getText(), "Macho", "Consulta", Float.parseFloat(Precio.getText()), Realizar.getText(), 2);
        obd.tablaConsultas(Previos, Mascota.getText());
        limpiar();
    }

    private void validar() {
        if (Mascota.getText().isBlank() || Propietario.getText().isBlank() || Precio.getText().isBlank() || Realizar.getText().isBlank()) {
            System.out.println("Su ingreso no puede ser realizado si hay campos vacios");
        } else {
            System.out.println("Su ingreso fue exitoso");
            subir();
        }
    }

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
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
        usuario = new Usuario();
        obd = new BD.OBD();
        ocultarBarraTitulo();
        
        Realizar.setLineWrap(true);
        Resultado.setLineWrap(true);
        obd.tablaConsultas(Previos, Mascota.getText());
        Vacuna =  new ventana_aplicarVacuna(adminUsuario);
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
        agregarconsulta = new javax.swing.JButton();
        Precio = new javax.swing.JTextField();
        lPrecio = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Previos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        Realizar = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        MAS1 = new javax.swing.JLabel();
        MAS2 = new javax.swing.JLabel();
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
        TVacunas.setShowGrid(true);
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
        TDesparacitacion.setShowGrid(true);
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

        agregarconsulta.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        agregarconsulta.setText("Agregar");
        agregarconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarconsultaActionPerformed(evt);
            }
        });

        Precio.setBackground(new java.awt.Color(0, 0, 0));
        Precio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Precio.setForeground(new java.awt.Color(255, 255, 255));

        lPrecio.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        lPrecio.setForeground(new java.awt.Color(242, 242, 242));
        lPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPrecio.setText("Precio");

        Previos.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Previos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mascota", "Fecha", "Medico", "Servicio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Previos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Previos.setGridColor(new java.awt.Color(102, 102, 102));
        Previos.setMaximumSize(new java.awt.Dimension(700, 450));
        Previos.setMinimumSize(new java.awt.Dimension(700, 450));
        Previos.setPreferredSize(new java.awt.Dimension(700, 450));
        Previos.setRowHeight(35);
        Previos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Previos.setShowGrid(true);
        Previos.setShowHorizontalLines(false);
        Previos.setShowVerticalLines(false);
        Previos.getTableHeader().setResizingAllowed(false);
        Previos.getTableHeader().setReorderingAllowed(false);
        Previos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreviosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Previos);
        Previos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (Previos.getColumnModel().getColumnCount() > 0) {
            Previos.getColumnModel().getColumn(0).setResizable(false);
            Previos.getColumnModel().getColumn(1).setResizable(false);
            Previos.getColumnModel().getColumn(2).setResizable(false);
            Previos.getColumnModel().getColumn(3).setResizable(false);
        }

        Realizar.setColumns(20);
        Realizar.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Realizar.setRows(5);
        jScrollPane6.setViewportView(Realizar);

        Resultado.setColumns(20);
        Resultado.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Resultado.setRows(5);
        jScrollPane4.setViewportView(Resultado);

        MAS1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MAS1.setForeground(new java.awt.Color(255, 255, 255));
        MAS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MAS1.setText("Descrpcion servicio");
        MAS1.setMaximumSize(new java.awt.Dimension(100, 35));
        MAS1.setMinimumSize(new java.awt.Dimension(100, 35));
        MAS1.setPreferredSize(new java.awt.Dimension(100, 35));

        MAS2.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        MAS2.setForeground(new java.awt.Color(255, 255, 255));
        MAS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MAS2.setText("Descripcion servicio realizado");
        MAS2.setMaximumSize(new java.awt.Dimension(100, 35));
        MAS2.setMinimumSize(new java.awt.Dimension(100, 35));
        MAS2.setPreferredSize(new java.awt.Dimension(100, 35));

        javax.swing.GroupLayout FondoConsultasLayout = new javax.swing.GroupLayout(FondoConsultas);
        FondoConsultas.setLayout(FondoConsultasLayout);
        FondoConsultasLayout.setHorizontalGroup(
            FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoConsultasLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MAS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(agregarconsulta))
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Precio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(MAS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        FondoConsultasLayout.setVerticalGroup(
            FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoConsultasLayout.createSequentialGroup()
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lPrecio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoConsultasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MAS1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MAS2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(FondoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoConsultasLayout.createSequentialGroup()
                        .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregarconsulta)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
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

    private void PreviosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviosMouseClicked
        Resultado.setText(String.valueOf(Previos.getValueAt(Previos.getSelectedRow(), 3)));
    }//GEN-LAST:event_PreviosMouseClicked

    private void agregarconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarconsultaActionPerformed
        validar();
    }//GEN-LAST:event_agregarconsultaActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        ventana_menu.FondoBotones.setVisible(true);
        ventana_menu.cerrar.setVisible(true);
        this.dispose();
        panel.setVisible(true);
    }//GEN-LAST:event_cerrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra1;
    private javax.swing.JPanel FondoCarnet;
    private javax.swing.JPanel FondoConsultas;
    private javax.swing.JLabel MAS;
    private javax.swing.JLabel MAS1;
    private javax.swing.JLabel MAS2;
    public static javax.swing.JTextField Mascota;
    private javax.swing.JLabel PRO;
    private javax.swing.JTextField Precio;
    public static javax.swing.JTable Previos;
    public static javax.swing.JTextField Propietario;
    private javax.swing.JTextArea Realizar;
    private javax.swing.JTextArea Resultado;
    public static javax.swing.JTable TDesparacitacion;
    public static javax.swing.JTable TVacunas;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton agregarconsulta;
    private javax.swing.JLabel cerrar;
    private javax.swing.JTabbedPane historial1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lPrecio;
    // End of variables declaration//GEN-END:variables
}
