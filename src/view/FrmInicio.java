
package view;

/**
 *
 * @author cragl
 */
public class FrmInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
        this.setExtendedState(FrmInicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reserva de Hotel");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblidpessoa = new javax.swing.JLabel();
        lblnome = new javax.swing.JLabel();
        lblacesso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnusisreserva = new javax.swing.JMenu();
        mnuarquivo = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        mnureservas = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        mnuconfiguracoes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuferramentas = new javax.swing.JMenu();
        mnusair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(102, 255, 255));

        lblidpessoa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblidpessoa.setText("jLabel1");
        escritorio.add(lblidpessoa);
        lblidpessoa.setBounds(20, 10, 130, 16);

        lblnome.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblnome.setText("jLabel2");
        escritorio.add(lblnome);
        lblnome.setBounds(20, 40, 130, 16);

        lblacesso.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblacesso.setText("jLabel7");
        escritorio.add(lblacesso);
        lblacesso.setBounds(20, 70, 130, 16);

        mnusisreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Inicio.png"))); // NOI18N
        mnusisreserva.setMnemonic('f');
        mnusisreserva.setText("SisReserva");
        menuBar.add(mnusisreserva);

        mnuarquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/arquivo.png"))); // NOI18N
        mnuarquivo.setMnemonic('e');
        mnuarquivo.setText("Arquivo");

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/quartos.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Quartos");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        mnuarquivo.add(cutMenuItem);

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/produtos.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Produtos");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        mnuarquivo.add(copyMenuItem);

        menuBar.add(mnuarquivo);

        mnureservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Reservas.png"))); // NOI18N
        mnureservas.setMnemonic('h');
        mnureservas.setText("Reservas");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reservas-despesas.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Reservas e Despesas");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        mnureservas.add(contentMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Clientes");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        mnureservas.add(aboutMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagamentos.png"))); // NOI18N
        jMenuItem1.setText("Pagamentos");
        mnureservas.add(jMenuItem1);

        menuBar.add(mnureservas);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Consultas.png"))); // NOI18N
        mnuconsultas.setText("Consultas");
        menuBar.add(mnuconsultas);

        mnuconfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Configuracoes.png"))); // NOI18N
        mnuconfiguracoes.setText("Configurações");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/funcionarios.png"))); // NOI18N
        jMenuItem2.setText("Usuarios e Acessos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuconfiguracoes.add(jMenuItem2);

        menuBar.add(mnuconfiguracoes);

        mnuferramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Ferramentas.png"))); // NOI18N
        mnuferramentas.setText("Ferramentas");
        menuBar.add(mnuferramentas);

        mnusair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Sair.png"))); // NOI18N
        mnusair.setText("Sair");
        mnusair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnusairMouseClicked(evt);
            }
        });
        menuBar.add(mnusair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        // TODO add your handling code here:
        FrmQuarto form =new FrmQuarto();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        // TODO add your handling code here:
        FrmServico form =new FrmServico();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        FrmCliente form =new FrmCliente();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        FrmFuncionario form =new FrmFuncionario();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnusairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnusairMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnusairMouseClicked

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
        FrmReserva form = new FrmReserva();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        FrmReserva.txtidfuncionario.setText(lblidpessoa.getText());
        FrmReserva.idusuario=Integer.parseInt(lblidpessoa.getText());
    }//GEN-LAST:event_contentMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JLabel lblacesso;
    public static javax.swing.JLabel lblidpessoa;
    public static javax.swing.JLabel lblnome;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuarquivo;
    public static javax.swing.JMenu mnuconfiguracoes;
    private javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnuferramentas;
    private javax.swing.JMenu mnureservas;
    private javax.swing.JMenu mnusair;
    private javax.swing.JMenu mnusisreserva;
    // End of variables declaration//GEN-END:variables

}
