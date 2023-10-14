package ArchiVet.ventana;

import ArchiVet.Admin.AdminDesparacitante;
import ArchiVet.Admin.AdminMedicamento;
import ArchiVet.Admin.AdminVacuna;
import ArchiVet.ventana.componente.Render_Button_JTable;
import Archivet.Controlador.Filtraciones;
import static ArchiVet.ventana.ventana_puntoVenta.SALDO;
import static ArchiVet.ventana.ventana_puntoVenta.mostradorCaja;
import static ArchiVet.ventana.ventana_mostradorCaja.PAGO;
import static ArchiVet.ventana.ventana_mostradorCaja.RES_CLAVE;
import static ArchiVet.ventana.ventana_mostradorCaja.Tabla_PRODUCTOS_ADD;
import static ArchiVet.ventana.ventana_mostradorCaja.Total_Cuenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ventana_productos extends javax.swing.JInternalFrame {
    
    private AdminVacuna adminVacuna;
    private AdminDesparacitante adminDesparacitante;
    private AdminMedicamento adminMedicamento;
    private ArchiVet.Imagen.imagenes imagen;

    static int Pieza;
    public static Object[] Compra = new Object[9];
    static String[] TITULOS = {"DESCRIPCION", "LOTE", "PRECIO UNITARIO", "CADUCIDAD", "PIEZAS", "BORRAR", ""};

    static DefaultTableModel model = new DefaultTableModel(null, TITULOS) {

        Class[] types = new Class[]{
            java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
        };

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        public boolean isCellEditable(int fila, int columna) {
            if (RES_CLAVE == true) {
                if (columna == 4) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        }
    };

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    public ventana_productos() throws SQLException {
        initComponents();
        
        imagen = new ArchiVet.Imagen.imagenes();
        adminVacuna = new AdminVacuna();
        adminDesparacitante = new AdminDesparacitante();
        adminMedicamento = new AdminMedicamento();
        adminVacuna.obtenerModeloTablaVacunas(Tabla_Vacunas);
        adminDesparacitante.obtenerModeloTablaDesparacitantes(Tabla_Desparacitantes);
        adminMedicamento.obtenerModeloTablaMedicamentos(Tabla_Medicamentos);
        ocultarBarraTitulo();

        Font myFont2 = new Font("Arial", Font.CENTER_BASELINE, 20);
        Inventarios.setFont(myFont2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        iconoInventario = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.Carrito1,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen.volver,0,0,getWidth(),getHeight(),this);
            }
        };
        Inventarios = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Vacunas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Desparacitantes = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_Medicamentos = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(47, 69, 56));

        jPanel2.setBackground(new java.awt.Color(215, 208, 183));

        iconoInventario.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 30)); // NOI18N
        jLabel1.setText("Productos");

        jLabel3.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(iconoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );

        Inventarios.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Inventarios.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(47, 69, 56));

        Tabla_Vacunas.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        Tabla_Vacunas.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla_Vacunas.setRowHeight(35);
        Tabla_Vacunas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Vacunas.getTableHeader().setResizingAllowed(false);
        Tabla_Vacunas.getTableHeader().setReorderingAllowed(false);
        Tabla_Vacunas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tabla_VacunasFocusLost(evt);
            }
        });
        Tabla_Vacunas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_VacunasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Vacunas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1729, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        Inventarios.addTab("Vacunas", jPanel6);

        jPanel7.setBackground(new java.awt.Color(47, 69, 56));

        Tabla_Desparacitantes.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Tabla_Desparacitantes.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla_Desparacitantes.setRowHeight(35);
        Tabla_Desparacitantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Desparacitantes.getTableHeader().setResizingAllowed(false);
        Tabla_Desparacitantes.getTableHeader().setReorderingAllowed(false);
        Tabla_Desparacitantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_DesparacitantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_Desparacitantes);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1729, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        Inventarios.addTab("Desparacitantes", jPanel7);

        jPanel8.setBackground(new java.awt.Color(47, 69, 56));

        Tabla_Medicamentos.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Tabla_Medicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla_Medicamentos.setRowHeight(35);
        Tabla_Medicamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Medicamentos.getTableHeader().setResizingAllowed(false);
        Tabla_Medicamentos.getTableHeader().setReorderingAllowed(false);
        Tabla_Medicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_MedicamentosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla_Medicamentos);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1729, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        Inventarios.addTab("Medicamentos", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Inventarios)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Inventarios)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla_VacunasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_VacunasMouseClicked
        Tabla_PRODUCTOS_ADD.setDefaultRenderer(Object.class, new Render_Button_JTable());

        ImageIcon icono;

        JButton btn = new JButton("");
        icono = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/borrar1.png"));
        btn.setIcon(icono);
        btn.setBounds(0, 0, 50, 35);
        btn.setName("E");

//            JButton btn2 = new JButton("");
//            icono2 = new ImageIcon(getClass().getResource("/Iconos/editar.png"));
//            btn2.setIcon(icono2);
//            btn2.setBounds(0, 0, 50, 35);
//            btn2.setName("M");
        int seleccion = Tabla_Vacunas.rowAtPoint(evt.getPoint());

        int columna = Tabla_Vacunas.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / Tabla_Vacunas.getRowHeight();

        Tabla_PRODUCTOS_ADD.setModel(model);
        //Tabla_PRODUCTOS_ADD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Tabla_PRODUCTOS_ADD.getColumn("DESCRIPCION").setPreferredWidth(640);
        Tabla_PRODUCTOS_ADD.getColumn("LOTE").setPreferredWidth(460);
        Tabla_PRODUCTOS_ADD.getColumn("PRECIO UNITARIO").setPreferredWidth(190);
        Tabla_PRODUCTOS_ADD.getColumn("CADUCIDAD").setPreferredWidth(245);
        Tabla_PRODUCTOS_ADD.getColumn("PIEZAS").setPreferredWidth(115);
        //Tabla_PRODUCTOS_ADD.getColumn("").setPreferredWidth(15);
        Tabla_PRODUCTOS_ADD.getColumn("BORRAR").setPreferredWidth(65);
        Tabla_PRODUCTOS_ADD.getColumn("").setPreferredWidth(0);

        if (fila < Tabla_Vacunas.getRowCount() && fila >= 0 && columna < Tabla_Vacunas.getColumnCount() && columna >= 0) {
            Object value = Tabla_Vacunas.getValueAt(fila, columna);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equalsIgnoreCase("AGREGAR")) {
                    int stock = Integer.parseInt(String.valueOf(Tabla_Vacunas.getValueAt(seleccion, 2)));

                    if (stock == 0) {
                        JOptionPane.showMessageDialog(null, "Ya no exiten piezas en existencia, recuerde surtir mas");
                    } else {
                        do {
                            try {

                                if (stock <= 10) {
                                    JOptionPane.showMessageDialog(null, "Quedan solamente " + stock + " piezas en existencia, recuerde surtir mas");
                                } 
                                    JOptionPane.showMessageDialog(null, "Recuerda que solo hay " + stock + " piezas");
                                    Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));

                                    if (Pieza < 0) {
                                        JOptionPane.showMessageDialog(null, "Error, no puedes ingresar numeros negativos", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error, Solo puedes ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } while (stock < Pieza || Pieza <= 0 || stock == 0);

                        Compra[0] = String.valueOf(Tabla_Vacunas.getValueAt(seleccion, 0)); //DESCRIPCION
                        Compra[1] = String.valueOf(Tabla_Vacunas.getValueAt(seleccion, 1)); //LOTE
                        Compra[2] = String.valueOf(Tabla_Vacunas.getValueAt(seleccion, 3)); //CADUCIDAD
                        Compra[3] = String.valueOf(Tabla_Vacunas.getValueAt(seleccion, 4)); //PRECIO UNITARIO
                        Compra[4] = Pieza;
                        //Compra[5] = btn2;
                        Compra[5] = btn;
                        Compra[6] = stock;

                        JOptionPane.showMessageDialog(null, "Productos Agregados");

                        int filaExistente = -1;
                        int ultimoValor = 0;

                        // Buscar la fila correspondiente en Tabla_PRODUCTOS_ADD
                        for (int i = 0; i < Tabla_PRODUCTOS_ADD.getRowCount(); i++) {
                            String descripcion = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 0));
                            String lote = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 1));
                            if (descripcion.equals(Compra[0]) && lote.equals(Compra[1])) {
                                filaExistente = i;
                                ultimoValor = Integer.parseInt(String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 4))); // Obtener el último valor de "PIEZAS"
                                break;
                            }
                        }

                        if (filaExistente != -1) {
                            // Sumar el valor de Compra[4] al último valor de "PIEZAS" y actualizarlo en la fila existente
                            int nuevoValor = Integer.parseInt(Compra[4].toString());
                            int NN = nuevoValor + ultimoValor;
                            Tabla_PRODUCTOS_ADD.setValueAt(NN, filaExistente, 4); // Actualizar el valor de "PIEZAS"
                            // Actualizar otros valores si es necesario
                        } else {
                            // Agregar una nueva fila si no existe una fila correspondiente
                            model.addRow(Compra);
                        }
                        Filtraciones.UPDATE_VACUNAS((stock - Pieza), Compra[1].toString());
                        try {
                            //filtraciones.Inventario_Vacunas("A", Tabla_Vacunas);
                            adminVacuna.obtenerModeloTablaVacunas(Tabla_Vacunas);
                        } catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                        }
                        
                    }
                    Tabla_PRODUCTOS_ADD.setCellSelectionEnabled(true);

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
    }//GEN-LAST:event_Tabla_VacunasMouseClicked

    private void Tabla_VacunasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tabla_VacunasFocusLost

    }//GEN-LAST:event_Tabla_VacunasFocusLost

    private void Tabla_DesparacitantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DesparacitantesMouseClicked
        Tabla_PRODUCTOS_ADD.setDefaultRenderer(Object.class, new Render_Button_JTable());

        ImageIcon icono;

        JButton btn = new JButton("");
        icono = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/borrar1.png"));
        btn.setIcon(icono);
        btn.setBounds(0, 0, 50, 35);
        btn.setName("E");

//            JButton btn2 = new JButton("");
//            icono2 = new ImageIcon(getClass().getResource("/Iconos/editar.png"));
//            btn2.setIcon(icono2);
//            btn2.setBounds(0, 0, 50, 35);
//            btn2.setName("M");
        int seleccion = Tabla_Desparacitantes.rowAtPoint(evt.getPoint());

        int columna = Tabla_Desparacitantes.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / Tabla_Desparacitantes.getRowHeight();

        Tabla_PRODUCTOS_ADD.setModel(model);
        Tabla_PRODUCTOS_ADD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Tabla_PRODUCTOS_ADD.getColumn("DESCRIPCION").setPreferredWidth(640);
        Tabla_PRODUCTOS_ADD.getColumn("LOTE").setPreferredWidth(460);
        Tabla_PRODUCTOS_ADD.getColumn("PRECIO UNITARIO").setPreferredWidth(190);
        Tabla_PRODUCTOS_ADD.getColumn("CADUCIDAD").setPreferredWidth(245);
        Tabla_PRODUCTOS_ADD.getColumn("PIEZAS").setPreferredWidth(115);
        //Tabla_PRODUCTOS_ADD.getColumn("").setPreferredWidth(15);
        Tabla_PRODUCTOS_ADD.getColumn("BORRAR").setPreferredWidth(65);
        Tabla_PRODUCTOS_ADD.getColumn("").setPreferredWidth(0);

        if (fila < Tabla_Desparacitantes.getRowCount() && fila >= 0 && columna < Tabla_Desparacitantes.getColumnCount() && columna >= 0) {
            Object value = Tabla_Desparacitantes.getValueAt(fila, columna);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equalsIgnoreCase("AGREGAR")) {
                    
                        int stock = Integer.parseInt(String.valueOf(Tabla_Desparacitantes.getValueAt(seleccion, 2)));
                        if (stock <= 10) {
                            JOptionPane.showMessageDialog(null, "Quedan solamente " + stock + " piezas en existencia, recuerde surtir mas");
                        }
                        
                        do {
                            try {
                                JOptionPane.showMessageDialog(null, "Recuerda que solo hay " + stock + " piezas");
                                Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                                
                                if (Pieza < 0) {
                                    JOptionPane.showMessageDialog(null, "Error, no puedes ingresar numeros negativos", "Error", JOptionPane.ERROR_MESSAGE);
                                    Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                                }
                                
                                if (Pieza == 0) {
                                    JOptionPane.showMessageDialog(null, "Error, necesitas seleccionar minimo 1 pieza", "Error", JOptionPane.ERROR_MESSAGE);
                                    Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                                }
                                
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error, Solo puedes ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
                                Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                            }
                            
                        } while (stock < Pieza || Pieza <= 0);
                        
                        Compra[0] = String.valueOf(Tabla_Desparacitantes.getValueAt(seleccion, 0)); //DESCRIPCION
                        Compra[1] = String.valueOf(Tabla_Desparacitantes.getValueAt(seleccion, 1)); //LOTE
                        Compra[2] = String.valueOf(Tabla_Desparacitantes.getValueAt(seleccion, 3)); //CADUCIDAD
                        Compra[3] = String.valueOf(Tabla_Desparacitantes.getValueAt(seleccion, 4)); //PRECIO UNITARIO
                        Compra[4] = Pieza;
                        Compra[6] = stock;
                        Compra[5] = btn;
                        
                        JOptionPane.showMessageDialog(null, "Productos Agregados");
                        
                        int filaExistente = -1;
                        int ultimoValor = 0;
                        
                        // Buscar la fila correspondiente en Tabla_PRODUCTOS_ADD
                        for (int i = 0; i < Tabla_PRODUCTOS_ADD.getRowCount(); i++) {
                            String descripcion = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 0));
                            String lote = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 1));
                            if (descripcion.equals(Compra[0]) && lote.equals(Compra[1])) {
                                filaExistente = i;
                                ultimoValor = Integer.parseInt(String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 4))); // Obtener el último valor de "PIEZAS"
                                break;
                            }
                        }
                        
                        if (filaExistente != -1) {
                            // Sumar el valor de Compra[4] al último valor de "PIEZAS" y actualizarlo en la fila existente
                            int nuevoValor = Integer.parseInt(Compra[4].toString());
                            int NN = nuevoValor + ultimoValor;
                            Tabla_PRODUCTOS_ADD.setValueAt(NN, filaExistente, 4); // Actualizar el valor de "PIEZAS"
                            // Actualizar otros valores si es necesario
                        } else {
                            // Agregar una nueva fila si no existe una fila correspondiente
                            model.addRow(Compra);
                        }
                        Filtraciones.UPDATE_DESPARACITANTES((stock - Pieza), Compra[1].toString());
                        
                    try {
                        //filtraciones.Inventario_Vacunas("B", Tabla_Desparacitantes);
                        adminDesparacitante.obtenerModeloTablaDesparacitantes(Tabla_Desparacitantes);
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }  
                }
                Tabla_PRODUCTOS_ADD.setCellSelectionEnabled(true);

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

    }//GEN-LAST:event_Tabla_DesparacitantesMouseClicked

    private void Tabla_MedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_MedicamentosMouseClicked
        Tabla_PRODUCTOS_ADD.setDefaultRenderer(Object.class, new Render_Button_JTable());

        ImageIcon icono, icono2;

        JButton btn = new JButton("");
        icono = new ImageIcon(getClass().getResource("/ArchiVet/Imagen/borrar1.png"));
        btn.setIcon(icono);
        btn.setBounds(0, 0, 50, 35);
        btn.setName("E");

//            JButton btn2 = new JButton("");
//            icono2 = new ImageIcon(getClass().getResource("/Iconos/editar.png"));
//            btn2.setIcon(icono2);
//            btn2.setBounds(0, 0, 50, 35);
//            btn2.setName("M");
        int seleccion = Tabla_Medicamentos.rowAtPoint(evt.getPoint());

        int columna = Tabla_Medicamentos.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / Tabla_Medicamentos.getRowHeight();

        Tabla_PRODUCTOS_ADD.setModel(model);
        Tabla_PRODUCTOS_ADD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Tabla_PRODUCTOS_ADD.getColumn("DESCRIPCION").setPreferredWidth(640);
        Tabla_PRODUCTOS_ADD.getColumn("LOTE").setPreferredWidth(460);
        Tabla_PRODUCTOS_ADD.getColumn("PRECIO UNITARIO").setPreferredWidth(190);
        Tabla_PRODUCTOS_ADD.getColumn("CADUCIDAD").setPreferredWidth(245);
        Tabla_PRODUCTOS_ADD.getColumn("PIEZAS").setPreferredWidth(115);
        //Tabla_PRODUCTOS_ADD.getColumn("").setPreferredWidth(15);
        Tabla_PRODUCTOS_ADD.getColumn("BORRAR").setPreferredWidth(65);
        Tabla_PRODUCTOS_ADD.getColumn("").setPreferredWidth(0);

        if (fila < Tabla_Medicamentos.getRowCount() && fila >= 0 && columna < Tabla_Medicamentos.getColumnCount() && columna >= 0) {
            Object value = Tabla_Medicamentos.getValueAt(fila, columna);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equalsIgnoreCase("AGREGAR")) {
                    int stock = Integer.parseInt(String.valueOf(Tabla_Medicamentos.getValueAt(seleccion, 2)));
                    if (stock <= 10) {
                        JOptionPane.showMessageDialog(null, "Quedan solamente " + stock + " piezas en existencia, recuerde surtir mas");
                    }

                    do {
                        try {
                            JOptionPane.showMessageDialog(null, "Recuerda que solo hay " + stock + " piezas");
                            Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));

                            if (Pieza < 0) {
                                JOptionPane.showMessageDialog(null, "Error, no puedes ingresar numeros negativos", "Error", JOptionPane.ERROR_MESSAGE);
                                Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                            }

                            if (Pieza == 0) {
                                JOptionPane.showMessageDialog(null, "Error, necesitas seleccionar minimo 1 pieza", "Error", JOptionPane.ERROR_MESSAGE);
                                Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                            }

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error, Solo puedes ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
                            Pieza = Integer.parseInt(JOptionPane.showInputDialog("Cunatas piezas desea agregar"));
                        }

                    } while (stock < Pieza || Pieza <= 0);

                    Compra[0] = String.valueOf(Tabla_Medicamentos.getValueAt(seleccion, 0)); //DESCRIPCION
                    Compra[1] = String.valueOf(Tabla_Medicamentos.getValueAt(seleccion, 1)); //LOTE
                    Compra[2] = String.valueOf(Tabla_Medicamentos.getValueAt(seleccion, 3)); //CADUCIDAD
                    Compra[3] = String.valueOf(Tabla_Medicamentos.getValueAt(seleccion, 4)); //PRECIO UNITARIO
                    Compra[4] = Pieza;
                    Compra[6] = stock;
                    Compra[5] = btn;

                    JOptionPane.showMessageDialog(null, "Productos Agregados");

                    int filaExistente = -1;
                    int ultimoValor = 0;

                    // Buscar la fila correspondiente en Tabla_PRODUCTOS_ADD
                    for (int i = 0; i < Tabla_PRODUCTOS_ADD.getRowCount(); i++) {
                        String descripcion = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 0));
                        String lote = String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 1));
                        if (descripcion.equals(Compra[0]) && lote.equals(Compra[1])) {
                            filaExistente = i;
                            ultimoValor = Integer.parseInt(String.valueOf(Tabla_PRODUCTOS_ADD.getValueAt(i, 4))); // Obtener el último valor de "PIEZAS"
                            break;
                        }
                    }

                    if (filaExistente != -1) {
                        // Sumar el valor de Compra[4] al último valor de "PIEZAS" y actualizarlo en la fila existente
                        int nuevoValor = Integer.parseInt(Compra[4].toString());
                        int NN = nuevoValor + ultimoValor;
                        Tabla_PRODUCTOS_ADD.setValueAt(NN, filaExistente, 4); // Actualizar el valor de "PIEZAS"
                        // Actualizar otros valores si es necesario
                    } else {
                        // Agregar una nueva fila si no existe una fila correspondiente
                        model.addRow(Compra);
                    }
                    Filtraciones.UPDATE_MEDICAMENTOS((stock - Pieza), Compra[1].toString());
                    try {
                        //filtraciones.Inventario_Vacunas("C", Tabla_Medicamentos);
                        adminMedicamento.obtenerModeloTablaMedicamentos(Tabla_Medicamentos);
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                Tabla_PRODUCTOS_ADD.setCellSelectionEnabled(true);

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

    }//GEN-LAST:event_Tabla_MedicamentosMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        double Piezas, Precio;
        double MAXT = 0;

        for (int i = 0; i < Tabla_PRODUCTOS_ADD.getRowCount(); i++) {

            Precio = Double.parseDouble(Tabla_PRODUCTOS_ADD.getValueAt(i, 2).toString());
            Piezas = Double.parseDouble(Tabla_PRODUCTOS_ADD.getValueAt(i, 4).toString());

            MAXT += Precio * Piezas;
        }

        if (SALDO != 0) {
            Total_Cuenta.setForeground(Color.red);
            PAGO.setForeground(Color.red);
            Total_Cuenta.setText(String.valueOf(MAXT + SALDO));
        } else if (SALDO == 0) {
            Total_Cuenta.setForeground(Color.red);
            PAGO.setForeground(Color.red);
            Total_Cuenta.setText(String.valueOf(MAXT));
        }

        System.out.println(MAXT);
        mostradorCaja.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane Inventarios;
    public static javax.swing.JTable Tabla_Desparacitantes;
    public static javax.swing.JTable Tabla_Medicamentos;
    public static javax.swing.JTable Tabla_Vacunas;
    private javax.swing.JLabel iconoInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
