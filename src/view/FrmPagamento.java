
package view;

import model.MQuarto;
import model.MPagamento;
import model.MReserva;
import controle.Conexao;
import controle.Despesas;
import controle.Quarto;
import controle.Pagamento;
import controle.Servico;
import controle.Reserva;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aelysson
 */
public class FrmPagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPagamento
     */
    public FrmPagamento() {
        initComponents();
        mostrar(idreserva);
        anular();
        txtidreserva.setText(idreserva);
        txtcliente.setText(cliente);
        txtquarto.setText(endereco);
        txtidquarto.setText(idendereco);
        txttotalreserva.setText(Double.toString(totalreserva));
        
        Despesas func = new Despesas();
        func.mostrar(idreserva);
        
        txttotal_pagamento.setText(Double.toString(totalreserva + func.totaldespesa));
        
        
    }
    
    private String action = "Salvar";
    public static String idreserva;
    public static String cliente;
    public static String idendereco;
    public static String endereco;
    public static Double totalreserva;
    

    void ocultar_columnas() {
        tabelaPag.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaPag.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaPag.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tabelaPag.getColumnModel().getColumn(1).setMaxWidth(0);
        tabelaPag.getColumnModel().getColumn(1).setMinWidth(0);
        tabelaPag.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_colunasConsumos() {
        tabelaDosConsumos.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaDosConsumos.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaDosConsumos.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tabelaDosConsumos.getColumnModel().getColumn(1).setMaxWidth(0);
        tabelaDosConsumos.getColumnModel().getColumn(1).setMinWidth(0);
        tabelaDosConsumos.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tabelaDosConsumos.getColumnModel().getColumn(2).setMaxWidth(0);
        tabelaDosConsumos.getColumnModel().getColumn(2).setMinWidth(0);
        tabelaDosConsumos.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    
    
    void anular() {
        txtidpagamento.setVisible(false);
        
        txtidreserva.setVisible(false);
        txtcliente.setEnabled(false);
        txtnum_comprovante.setEnabled(false);
        cbotipo_comprovante.setEnabled(false);
        txttotal_pagamento.setEnabled(false);
        txttotalreserva.setEnabled(false);
  
        txtidquarto.setVisible(false);
        txtquarto.setEnabled(false);
         
        btnsalvar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnexcluir.setEnabled(false);
        txtidpagamento.setText("");
        txtnum_comprovante.setText("");

        txttotal_pagamento.setText("");

    }

    void habilitar() {
        txtidpagamento.setVisible(false);
        
        txtidreserva.setVisible(true);
        txtcliente.setEnabled(true);
        txtnum_comprovante.setEnabled(true);
        cbotipo_comprovante.setEnabled(true);

        txttotal_pagamento.setEnabled(true);
        txttotalreserva.setEnabled(true);
        
        txtidquarto.setVisible(true);
        txtquarto.setEnabled(true);
         
        btnsalvar.setEnabled(true);
        btncancelar.setEnabled(true);
        btnexcluir.setEnabled(true);
        txtidpagamento.setText("");
        txtnum_comprovante.setText("");

        txttotal_pagamento.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Pagamento func = new Pagamento();
            modelo = func.mostrar(buscar);

            tabelaPag.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));
            
            //Mostrar os dados de despesa
            Despesas func2 = new Despesas();
            modelo= func2.mostrar(buscar);
            tabelaDosConsumos.setModel(modelo);
            ocultar_colunasConsumos();
            
            lbltotalregistrosconsumo.setText("Total Consumos " + func2.totalregistros);
            lbltotalconsumo.setText("Consumo Total: $." + func2.totaldespesa );
            

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttotal_reserva = new javax.swing.JPanel();
        txtidpagamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnum_comprovante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbotipo_comprovante = new javax.swing.JComboBox();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttotalreserva = new javax.swing.JTextField();
        txtidquarto = new javax.swing.JTextField();
        txtquarto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttotal_pagamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPag = new javax.swing.JTable();
        btnexcluir = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnImprimirComprovante = new javax.swing.JButton();
        btnImprimirComprovanteDespesas = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaDosConsumos = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txttotal_reserva.setBackground(new java.awt.Color(255, 204, 102));
        txttotal_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagamentos"));

        jLabel2.setText("Reserva:");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Quarto:");

        jLabel6.setText("Num Comprovante:");

        txtnum_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_comprovanteActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo Comprovante:");

        cbotipo_comprovante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartao", "Ticket" }));
        cbotipo_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_comprovanteActionPerformed(evt);
            }
        });

        btnnovo.setBackground(new java.awt.Color(51, 51, 51));
        btnnovo.setForeground(new java.awt.Color(255, 255, 255));
        btnnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/novo.GIF"))); // NOI18N
        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnsalvar.setBackground(new java.awt.Color(51, 51, 51));
        btnsalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salvar.png"))); // NOI18N
        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(51, 51, 51));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Reserva:");

        txtidquarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidquartoActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Pagamento:");

        txttotal_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotal_pagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txttotal_reservaLayout = new javax.swing.GroupLayout(txttotal_reserva);
        txttotal_reserva.setLayout(txttotal_reservaLayout);
        txttotal_reservaLayout.setHorizontalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txttotal_reservaLayout.createSequentialGroup()
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txttotal_reservaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addComponent(btnnovo)
                                    .addGap(42, 42, 42)
                                    .addComponent(btnsalvar)
                                    .addGap(58, 58, 58)
                                    .addComponent(btncancelar))
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtidquarto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbotipo_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txttotal_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtnum_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(266, 266, 266)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(101, 101, 101))
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(txtquarto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txttotal_reservaLayout.setVerticalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addComponent(txtidpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidquarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtquarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbotipo_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnum_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txttotal_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnovo)
                    .addComponent(btnsalvar)
                    .addComponent(btncancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pagamentos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pagamentos"));

        tabelaPag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaPag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPagMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaPag);

        btnexcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnexcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Deletar.png"))); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        btnsair.setBackground(new java.awt.Color(51, 51, 51));
        btnsair.setForeground(new java.awt.Color(255, 255, 255));
        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btnsair.setText("Sair");
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        btnImprimirComprovante.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimirComprovante.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirComprovante.setText("Imprimir");
        btnImprimirComprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprovanteActionPerformed(evt);
            }
        });

        btnImprimirComprovanteDespesas.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimirComprovanteDespesas.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirComprovanteDespesas.setText("Imprimir Despesas");
        btnImprimirComprovanteDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprovanteDespesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnImprimirComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImprimirComprovanteDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(btnexcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsair)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexcluir)
                    .addComponent(btnsair)
                    .addComponent(btnImprimirComprovante)
                    .addComponent(btnImprimirComprovanteDespesas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbltotalregistros))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Despesas"));

        tabelaDosConsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaDosConsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDosConsumosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaDosConsumos);

        lbltotalregistrosconsumo.setText("Registros");

        lbltotalconsumo.setText("jLabel12");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbltotalconsumo)
                        .addGap(48, 48, 48)
                        .addComponent(lbltotalregistrosconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosconsumo)
                    .addComponent(lbltotalconsumo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        txttotal_reserva.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
        txtidreserva.transferFocus();
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txtnum_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_comprovanteActionPerformed
        // TODO add your handling code here:
        txtnum_comprovante.transferFocus();
    }//GEN-LAST:event_txtnum_comprovanteActionPerformed

    private void cbotipo_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_comprovanteActionPerformed
        // TODO add your handling code here:
        cbotipo_comprovante.transferFocus();
    }//GEN-LAST:event_cbotipo_comprovanteActionPerformed

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnsalvar.setText("Salvar");
        action = "salvar";
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        // TODO add your handling code here:

        if (txttotal_pagamento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Adicione o total de comprovantes");
            txttotal_pagamento.requestFocus();
            return;
        }

        if (txtnum_comprovante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Quantos comprovantes foram pagos?");
            txtnum_comprovante.requestFocus();
            return;
        }

        MPagamento dts = new MPagamento();
        Pagamento func = new Pagamento();

        dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));


        int seleccionado = cbotipo_comprovante.getSelectedIndex();
        dts.setTipo_comprovante((String) cbotipo_comprovante.getItemAt(seleccionado));
        
        dts.setNum_comprovante(txtnum_comprovante.getText());
        //dts.setIgv(Double.parseDouble(txtigv.getText()));
        dts.setTotal_pagamento(Double.parseDouble(txttotal_pagamento.getText()));
        
        Calendar cal;
        int d,m,a;     
        

        if (action.equals("Salvar")) {
            if (func.adicionar(dts)) {
                JOptionPane.showMessageDialog(rootPane, " Foi pago $. " + txttotal_pagamento.getText() + 
                        " do Sr. " + txtcliente.getText() + "Conta paga com exito. ");
                mostrar(idreserva);
                anular();
                
                //Desocupar quarto
                Quarto func2 = new Quarto();
                MQuarto dts2 = new MQuarto();
                
                dts2.setIdquarto(Integer.parseInt(txtidquarto.getText()));
                func2.desocupar(dts2);
                
                //Cancelar
                
                Reserva func3 = new Reserva();
                MReserva dts3 = new MReserva();
                
                dts3.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func3.pagar(dts3);
                
            }

        }
        else if (action.equals("editar")){
            dts.setIdpagamento(Integer.parseInt(txtidpagamento.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "O pagamento do Sr. " + 
                        txtcliente.getText() + " Foi modificado");
                mostrar(idreserva);
                anular();
            }
        }
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tabelaPagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPagMouseClicked
        // TODO add your handling code here:
        btnsalvar.setText("Editar");
        habilitar();
        btnexcluir.setEnabled(true);
        action="editar";

        int fila = tabelaPag.rowAtPoint(evt.getPoint());

        txtidpagamento.setText(tabelaPag.getValueAt(fila, 0).toString());
        txtidreserva.setText(tabelaPag.getValueAt(fila, 1).toString());
        
        cbotipo_comprovante.setSelectedItem(tabelaPag.getValueAt(fila, 2).toString());
        txtnum_comprovante.setText(tabelaPag.getValueAt(fila, 3).toString());
        txttotal_pagamento.setText(tabelaPag.getValueAt(fila, 4).toString());

       

    }//GEN-LAST:event_tabelaPagMouseClicked

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        // TODO add your handling code here:
        if (!txtidpagamento.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Excluir o pagamento?","Confirmar",2);

            if (confirmacion==0) {
                Pagamento func = new Pagamento ();
                MPagamento dts= new MPagamento();

                dts.setIdpagamento(Integer.parseInt(txtidpagamento.getText()));
                func.excluir(dts);
                mostrar(idreserva);
                anular();

            }

        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsairActionPerformed

    private void txtidquartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidquartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidquartoActionPerformed

    private void txttotal_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotal_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotal_pagamentoActionPerformed

    private void tabelaDosConsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDosConsumosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaDosConsumosMouseClicked

    private Connection connection=new Conexao().conectar();
    
    
    
    private void btnImprimirComprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprovanteActionPerformed
        if (!txtidpagamento.getText().equals("")) {
            Map p = new HashMap();
            p.put("idpagamento", txtidpagamento.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/rptComprovante.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprovante");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirComprovanteActionPerformed

    private void btnImprimirComprovanteDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprovanteDespesasActionPerformed
        if (!txtidpagamento.getText().equals("")) {
            Map p = new HashMap();
            p.put("idpagamento", txtidpagamento.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/rptComprovanteDespesa.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprovante Despesa");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirComprovanteDespesasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimirComprovante;
    private javax.swing.JButton btnImprimirComprovanteDespesas;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox cbotipo_comprovante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    private javax.swing.JTable tabelaDosConsumos;
    private javax.swing.JTable tabelaPag;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtidpagamento;
    private javax.swing.JTextField txtidquarto;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtnum_comprovante;
    private javax.swing.JTextField txtquarto;
    private javax.swing.JTextField txttotal_pagamento;
    private javax.swing.JPanel txttotal_reserva;
    private javax.swing.JTextField txttotalreserva;
    // End of variables declaration//GEN-END:variables
}
