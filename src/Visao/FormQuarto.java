package Visao;

import Controle.Fquarto;
import Dados.Vquarto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aelysson
 */
public class FormQuarto extends javax.swing.JFrame {

    /**
     * FormQuarto
     */
    public FormQuarto() {
        initComponents();
    }
    
    private String action="salvar";
    void ocultar_colunas(){
        tblistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tblistado.getColumnModel().getColumn(0).setMinWidth(0);
        tblistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    void inabilitar(){
        textquarto.setVisible(false);
        cbandar.setEnabled(false);
        textnumero.setEnabled(false);
        textdescricao.setEnabled(false);
        textcaracteristicas.setEnabled(false);
        textpreco_diario.setEnabled(false);
        cbstatus.setEnabled(false);
        cbtipo_quarto.setEnabled(false);
        
        btnsalvar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnsair.setEnabled(false);
        textquarto.setText("");
        textpreco_diario.setText("");
        textdescricao.setText("");
        textcaracteristicas.setText("");
    }
    
    void habilitar(){
        textquarto.setVisible(false);
        
        cbandar.setEnabled(true);
        textnumero.setEnabled(true);
        textdescricao.setEnabled(true);
        textcaracteristicas.setEnabled(true);
        textpreco_diario.setEnabled(true);
        cbstatus.setEnabled(true);
        cbtipo_quarto.setEnabled(true);
        
        btnsalvar.setEnabled(true);
        btncancelar.setEnabled(true);
        btnsair.setEnabled(true);
        textquarto.setText("");
        textpreco_diario.setText("");
        textdescricao.setText("");
        textcaracteristicas.setText("");
    }
    
    void mostrar(String buscar){
        try {
            DefaultTableModel modelo;
            
            Fquarto func = new Fquarto();
            modelo = func.mostrar(buscar);
            
            tblistado.setModel(modelo);
            ocultar_colunas();
            lbltotalregistros.setText("Total de registros: " + Integer.toString(func.totalderegistros));
            
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textquarto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textnumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbandar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textdescricao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textcaracteristicas = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        textpreco_diario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbstatus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbtipo_quarto = new javax.swing.JComboBox<>();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblistado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        textbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btndeletar = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quarto");

        jPanel1.setBackground(new java.awt.Color(209, 229, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Quarto"));

        jLabel2.setText("Numero:");

        textnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textnumeroActionPerformed(evt);
            }
        });

        jLabel3.setText("Andar:");

        cbandar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "6", "7" }));
        cbandar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbandarActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição:");

        textdescricao.setColumns(20);
        textdescricao.setRows(5);
        jScrollPane1.setViewportView(textdescricao);

        jLabel5.setText("Características:");

        textcaracteristicas.setColumns(20);
        textcaracteristicas.setRows(5);
        jScrollPane2.setViewportView(textcaracteristicas);

        jLabel6.setText("Preço diário:");

        textpreco_diario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textpreco_diarioActionPerformed(evt);
            }
        });

        jLabel7.setText("Status:");

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponível", "Ocupado", "Em manuteção" }));
        cbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatusActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de quarto:");

        cbtipo_quarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Casal", "Familiar" }));
        cbtipo_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipo_quartoActionPerformed(evt);
            }
        });

        btnnovo.setBackground(new java.awt.Color(0, 51, 51));
        btnnovo.setForeground(new java.awt.Color(255, 255, 255));
        btnnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/novo.GIF"))); // NOI18N
        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnsalvar.setBackground(new java.awt.Color(0, 51, 51));
        btnsalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/salvar.png"))); // NOI18N
        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(0, 51, 51));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(btnnovo))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(btncancelar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textpreco_diario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbtipo_quarto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbstatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 120, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textquarto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textnumero)
                                .addComponent(cbandar, 0, 120, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textquarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textpreco_diario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cbtipo_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnovo)
                    .addComponent(btnsalvar)
                    .addComponent(btncancelar)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Quartos"));

        tblistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblistado);

        jLabel9.setText("Buscar");

        btnbuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/buscar.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btndeletar.setBackground(new java.awt.Color(0, 51, 51));
        btndeletar.setForeground(new java.awt.Color(255, 255, 255));
        btndeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/deletar.png"))); // NOI18N
        btndeletar.setText("Deletar");
        btndeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletarActionPerformed(evt);
            }
        });

        btnsair.setBackground(new java.awt.Color(0, 51, 51));
        btnsair.setForeground(new java.awt.Color(255, 255, 255));
        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/sair.gif"))); // NOI18N
        btnsair.setText("Sair");

        lbltotalregistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(textbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsair)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btndeletar)
                    .addComponent(btnsair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbltotalregistros)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnsalvar.setText("Salvar");
        action = "salvar";
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        // TODO add your handling code here:
        if (textnumero.getText().length() ==0) {
            JOptionPane.showConfirmDialog(rootPane, "Você deve inserir um número de quarto");
            textnumero.requestFocus();
            return;
        }
        if (textdescricao.getText().length() ==0) {
            JOptionPane.showConfirmDialog(rootPane, "Você deve inserir uma descrição de quarto");
            textdescricao.requestFocus();
            return;
        }
        
        if (textpreco_diario.getText().length() ==0) {
            JOptionPane.showConfirmDialog(rootPane, "Você deve inserir o preço do quarto");
            textpreco_diario.requestFocus();
            return;
        }
        
        if (textcaracteristicas.getText().length() ==0) {
            JOptionPane.showConfirmDialog(rootPane, "Você deve inserir o preço do quarto");
            textcaracteristicas.requestFocus();
            return;
        }
        Vquarto dts = new Vquarto();
        Fquarto func = new Fquarto();
        
        dts.setNumero(textnumero.getText());
        
        int selecionado = cbandar.getSelectedIndex();
        dts.setAndar((String)cbandar.getItemAt(selecionado));
        dts.setDescricao(textdescricao.getText());
        dts.setCaracteristicas(textcaracteristicas.getText());
        dts.setPreco_diario(Double.parseDouble(textpreco_diario.getText()));
        
        selecionado = cbstatus.getSelectedIndex();
        dts.setStatus((String)cbstatus.getItemAt(selecionado));
        
        selecionado = cbtipo_quarto.getSelectedIndex();
        dts.setTipo_quarto((String)cbtipo_quarto.getItemAt(selecionado));
        
        
        if (action.equals("salvar")) {
            if (func.inserir(dts)) {
                JOptionPane.showConfirmDialog(rootPane, "O quarto foi registrado com sucesso!");
                mostrar("");
            }
        }
        
        if (action.endsWith("editar")) {
            dts.setIdquarto(Integer.parseInt(textquarto.getText()));
            
            if (func.editar(dts)) {
                JOptionPane.showConfirmDialog(rootPane, "O quarto foi editado com sucesso!");
                mostrar("");
            }
        }
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btndeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletarActionPerformed
        // TODO add your handling code here:
        
        if (!textquarto.getText().equals("")) {
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que quer excluir o quarto?","Confirmar", 2);
            
            if (confirmacao ==0) {
                Fquarto func = new Fquarto();
                Vquarto dts = new Vquarto();
                mostrar("");
                inabilitar();
            }
        }
    }//GEN-LAST:event_btndeletarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(textbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void textnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textnumeroActionPerformed
        // TODO add your handling code here:
        
        textnumero.transferFocus();
    }//GEN-LAST:event_textnumeroActionPerformed

    private void cbandarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbandarActionPerformed
        // TODO add your handling code here:
        cbandar.transferFocus();
    }//GEN-LAST:event_cbandarActionPerformed

    private void textpreco_diarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textpreco_diarioActionPerformed
        // TODO add your handling code here:
        textpreco_diario.transferFocus();
    }//GEN-LAST:event_textpreco_diarioActionPerformed

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
        // TODO add your handling code here:
        cbstatus.transferFocus();
    }//GEN-LAST:event_cbstatusActionPerformed

    private void cbtipo_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipo_quartoActionPerformed
        // TODO add your handling code here:
        cbtipo_quarto.transferFocus();
    }//GEN-LAST:event_cbtipo_quartoActionPerformed

    private void tblistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblistadoMouseClicked
        // TODO add your handling code here:
        btnsalvar.setText("Editar");
        habilitar();
        btndeletar.setEnabled(true);
        action="editar";
        
        int fila = tblistado.rowAtPoint(evt.getPoint());
        textquarto.setText(tblistado.getValueAt(fila, 0).toString());
        textnumero.setText(tblistado.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_tblistadoMouseClicked

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
            java.util.logging.Logger.getLogger(FormQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndeletar;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox<String> cbandar;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JComboBox<String> cbtipo_quarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tblistado;
    private javax.swing.JTextField textbuscar;
    private javax.swing.JTextArea textcaracteristicas;
    private javax.swing.JTextArea textdescricao;
    private javax.swing.JTextField textnumero;
    private javax.swing.JTextField textpreco_diario;
    private javax.swing.JTextField textquarto;
    // End of variables declaration//GEN-END:variables
}
