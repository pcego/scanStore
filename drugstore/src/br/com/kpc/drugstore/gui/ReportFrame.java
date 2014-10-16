/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.gui;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.dao.ConnectionDb;
import br.com.kpc.drugstore.service.Service;
import br.com.kpc.drugstore.util.Config;
import br.com.kpc.drugstore.util.Mask;
import br.com.kpc.drugstore.util.SystemMessage;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.kpc.drugstore.relatorios.Filter;
import br.com.kpc.drugstore.util.fieldValidation;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dino
 */
public class ReportFrame extends javax.swing.JFrame {

    /**
     * Creates new form ReportFrame
     */
    public ReportFrame() {
        initComponents();
        definindoMask();
        Config.considerarEnterComoTab(this);
        // coloca uma figura na barra de título da janela
        URL url = this.getClass().getResource(Config.LOGOBARRATITULO);
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tvDateRecipeIn = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        tvDateShopOut = new javax.swing.JFormattedTextField();
        tvDateRecipeOut = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tvDateShopIn = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        tvName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btPesquisaCliente = new javax.swing.JButton();
        tvCPF = new javax.swing.JFormattedTextField();
        rbTodos = new javax.swing.JRadioButton();
        rbVendasPorCliente = new javax.swing.JRadioButton();
        rbUltimaCompraDoCliente = new javax.swing.JRadioButton();
        rbIntervaloDeDataDeVenda = new javax.swing.JRadioButton();
        rbIntervaloDeDataDaReceita = new javax.swing.JRadioButton();
        rbDataVendaPorCliente = new javax.swing.JRadioButton();
        rbDataReceitaPorCliente = new javax.swing.JRadioButton();
        btConfirmar1 = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios - KPC Software Delopmet");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tvDateRecipeIn.setEnabled(false);
        tvDateRecipeIn.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel24.setText("Data receita");
        jLabel24.setPreferredSize(new java.awt.Dimension(68, 20));

        tvDateShopOut.setEnabled(false);
        tvDateShopOut.setPreferredSize(new java.awt.Dimension(100, 20));

        tvDateRecipeOut.setEnabled(false);
        tvDateRecipeOut.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel22.setText("até");
        jLabel22.setPreferredSize(new java.awt.Dimension(35, 20));

        jLabel23.setText("até");
        jLabel23.setPreferredSize(new java.awt.Dimension(35, 20));

        tvDateShopIn.setEnabled(false);
        tvDateShopIn.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel21.setText("Data venda");
        jLabel21.setPreferredSize(new java.awt.Dimension(68, 20));

        tvName.setEnabled(false);
        tvName.setPreferredSize(new java.awt.Dimension(450, 20));
        tvName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tvNameFocusLost(evt);
            }
        });

        jLabel11.setText("CPF");
        jLabel11.setPreferredSize(new java.awt.Dimension(68, 20));

        btPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/pesquisa.png"))); // NOI18N
        btPesquisaCliente.setContentAreaFilled(false);
        btPesquisaCliente.setEnabled(false);
        btPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaClienteActionPerformed(evt);
            }
        });

        tvCPF.setEnabled(false);
        tvCPF.setPreferredSize(new java.awt.Dimension(100, 20));
        tvCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tvCPFFocusLost(evt);
            }
        });
        tvCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tvCPFKeyPressed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.setText("TODOS");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbVendasPorCliente);
        rbVendasPorCliente.setText("VENDAS POR CLIENTE");
        rbVendasPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVendasPorClienteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbUltimaCompraDoCliente);
        rbUltimaCompraDoCliente.setText("ULTIMA COMPRA DO CLIENTE");
        rbUltimaCompraDoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUltimaCompraDoClienteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbIntervaloDeDataDeVenda);
        rbIntervaloDeDataDeVenda.setText("INTERVALO DE DATA DE VENDA");
        rbIntervaloDeDataDeVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIntervaloDeDataDeVendaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbIntervaloDeDataDaReceita);
        rbIntervaloDeDataDaReceita.setText("INTERVALO DE DATA DA RECEITA");
        rbIntervaloDeDataDaReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIntervaloDeDataDaReceitaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbDataVendaPorCliente);
        rbDataVendaPorCliente.setText("DATA VENDA POR CLIENTE");
        rbDataVendaPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataVendaPorClienteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbDataReceitaPorCliente);
        rbDataReceitaPorCliente.setText("DATA RECEITA POR CLIENTE");
        rbDataReceitaPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataReceitaPorClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tvDateShopIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tvDateShopOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tvDateRecipeIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tvDateRecipeOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tvCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tvName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbVendasPorCliente))
                    .addComponent(rbIntervaloDeDataDaReceita))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDataVendaPorCliente)
                    .addComponent(rbUltimaCompraDoCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDataReceitaPorCliente)
                    .addComponent(rbIntervaloDeDataDeVenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodos)
                    .addComponent(rbVendasPorCliente)
                    .addComponent(rbUltimaCompraDoCliente)
                    .addComponent(rbIntervaloDeDataDeVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbIntervaloDeDataDaReceita)
                    .addComponent(rbDataVendaPorCliente)
                    .addComponent(rbDataReceitaPorCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tvCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvDateShopIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvDateShopOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvDateRecipeIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvDateRecipeOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btConfirmar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/salvar.png"))); // NOI18N
        btConfirmar1.setText("Confirmar");
        btConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmar1ActionPerformed(evt);
            }
        });

        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/cancelar.png"))); // NOI18N
        btCancelar1.setText("Cancelar");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private static Client clientVG = new Client();
    private int OpcaoFiltro = 0;

    private void tvNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tvNameFocusLost
        tvName.setText(tvName.getText().toUpperCase());
    }//GEN-LAST:event_tvNameFocusLost

    private void btConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmar1ActionPerformed
        StringBuilder sql = null;
        Filter filter = new Filter();

        if (!fieldValidation()) {
            return;
        } else if (rbTodos.isSelected()) {
            sql = filter.createSqlRel(Filter.TODOS, null, null, null);
            geraRel(sql);
        } else if (rbVendasPorCliente.isSelected()) {
            sql = filter.createSqlRel(Filter.VENDAS_CLIENTE, Mask.limparMaskCPF(tvCPF.getText()).trim(), null, null);
            geraRel(sql);

        } else if (rbUltimaCompraDoCliente.isSelected()) {
            sql = filter.createSqlRel(Filter.ULTIMA_COMPRA_CLIENTE, Mask.limparMaskCPF(tvCPF.getText()).trim(), null, null);
            geraRel(sql);

        } else if (rbIntervaloDeDataDeVenda.isSelected()) {
            sql = filter.createSqlRel(Filter.INTERVALO_DATA_VENDA, null, tvDateShopIn.getText().trim(), tvDateShopOut.getText().trim());
            geraRel(sql);

        } else if (rbIntervaloDeDataDaReceita.isSelected()) {
            sql = filter.createSqlRel(Filter.INTERVALO_DATA_VENDA, null, tvDateRecipeIn.getText().trim(), tvDateRecipeOut.getText().trim());
            geraRel(sql);

        } else if (rbDataVendaPorCliente.isSelected()) {
            sql = filter.createSqlRel(Filter.INTERVALO_DATA_VENDA, Mask.limparMaskCPF(tvCPF.getText()).trim(), tvDateShopIn.getText().trim(), tvDateShopOut.getText().trim());
            geraRel(sql);

        } else if (rbDataReceitaPorCliente.isSelected()) {
            sql = filter.createSqlRel(Filter.INTERVALO_DATA_VENDA, Mask.limparMaskCPF(tvCPF.getText()).trim(), tvDateRecipeIn.getText().trim(), tvDateRecipeOut.getText().trim());
            geraRel(sql);
        }


    }//GEN-LAST:event_btConfirmar1ActionPerformed


    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        limparCampos();
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaClienteActionPerformed
        ConsultarCliente.getJanelaConsultarCliente("REPORTFRAME").setVisible(true);
    }//GEN-LAST:event_btPesquisaClienteActionPerformed

    private void tvCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tvCPFFocusLost
        carregarNomeCLiente();
    }//GEN-LAST:event_tvCPFFocusLost

    private void tvCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tvCPFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvCPFKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        limparCampos();
    }//GEN-LAST:event_formWindowClosed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        habilitaCampos(false);
        limparCampos();
        OpcaoFiltro = Filter.TODOS;
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbVendasPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVendasPorClienteActionPerformed
        habilitaCampos(false);
        limparCampos();
        tvCPF.setEnabled(true);
        btPesquisaCliente.setEnabled(true);
        OpcaoFiltro = Filter.VENDAS_CLIENTE;
    }//GEN-LAST:event_rbVendasPorClienteActionPerformed

    private void rbUltimaCompraDoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUltimaCompraDoClienteActionPerformed
        habilitaCampos(false);
        limparCampos();
        tvCPF.setEnabled(true);
        btPesquisaCliente.setEnabled(true);
        OpcaoFiltro = Filter.ULTIMA_COMPRA_CLIENTE;
    }//GEN-LAST:event_rbUltimaCompraDoClienteActionPerformed

    private void rbIntervaloDeDataDeVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIntervaloDeDataDeVendaActionPerformed
        habilitaCampos(false);
        limparCampos();
        tvDateShopIn.setEnabled(true);
        tvDateShopOut.setEnabled(true);
        OpcaoFiltro = Filter.INTERVALO_DATA_VENDA;

    }//GEN-LAST:event_rbIntervaloDeDataDeVendaActionPerformed

    private void rbIntervaloDeDataDaReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIntervaloDeDataDaReceitaActionPerformed
        habilitaCampos(false);
        limparCampos();
        tvDateRecipeIn.setEnabled(true);
        tvDateRecipeOut.setEnabled(true);
        OpcaoFiltro = Filter.INTERVALO_DATA_RECEITA;

    }//GEN-LAST:event_rbIntervaloDeDataDaReceitaActionPerformed

    private void rbDataVendaPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataVendaPorClienteActionPerformed
        habilitaCampos(false);
        limparCampos();
        tvCPF.setEnabled(true);
        btPesquisaCliente.setEnabled(true);
        tvDateShopIn.setEnabled(true);
        tvDateShopOut.setEnabled(true);
        OpcaoFiltro = Filter.CLIENTE_DATA_VENDA;
    }//GEN-LAST:event_rbDataVendaPorClienteActionPerformed

    private void rbDataReceitaPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataReceitaPorClienteActionPerformed
        habilitaCampos(false);
        tvCPF.setEnabled(true);
        btPesquisaCliente.setEnabled(true);
        tvDateRecipeIn.setEnabled(true);
        tvDateRecipeOut.setEnabled(true);
        OpcaoFiltro = Filter.DATA_RECEITA_CLIENTE;
    }//GEN-LAST:event_rbDataReceitaPorClienteActionPerformed

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
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btCancelar1;
    private static javax.swing.JButton btConfirmar1;
    private javax.swing.JButton btPesquisaCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbDataReceitaPorCliente;
    private javax.swing.JRadioButton rbDataVendaPorCliente;
    private javax.swing.JRadioButton rbIntervaloDeDataDaReceita;
    private javax.swing.JRadioButton rbIntervaloDeDataDeVenda;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JRadioButton rbUltimaCompraDoCliente;
    private javax.swing.JRadioButton rbVendasPorCliente;
    private static javax.swing.JFormattedTextField tvCPF;
    private static javax.swing.JFormattedTextField tvDateRecipeIn;
    private static javax.swing.JFormattedTextField tvDateRecipeOut;
    private static javax.swing.JFormattedTextField tvDateShopIn;
    private static javax.swing.JFormattedTextField tvDateShopOut;
    private static javax.swing.JTextField tvName;
    // End of variables declaration//GEN-END:variables

    private void definindoMask() {

        try {
            Mask.maskDate(tvDateRecipeIn);
            Mask.maskDate(tvDateRecipeOut);
            Mask.maskDate(tvDateShopIn);
            Mask.maskDate(tvDateShopOut);
            Mask.maskCPF(tvCPF);

        } catch (ParseException ex) {
            Logger.getLogger(ReportFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Recebe o retorno da pesquisa
    protected static void getClientReturn(Client cli) {
        clientVG = cli;
        tvCPF.setText(String.valueOf(clientVG.getCpf()));
        tvName.setText(clientVG.getName());
    }

    //carrega os dados ns busca pelo CPF
    private void carregarNomeCLiente() {
        if (tvCPF.getText().trim().length() == 14) {
            clientVG = Service.getIRepositoryClient().getClientByCpf(Mask.limparMaskCPF(tvCPF.getText()).trim(), true);
            tvName.setText(clientVG.getName());
        }
    }

    private void fieldComplete() {

        if ((!Mask.limparMaskData(tvDateRecipeIn.getText()).trim().equals("")) && (Mask.limparMaskData(tvDateRecipeIn.getText()).trim().length() == 8) && (Mask.limparMaskData(tvDateRecipeOut.getText()).trim().equals(""))) {
            tvDateRecipeOut.setText(tvDateRecipeIn.getText());
        }
        if ((!Mask.limparMaskData(tvDateRecipeOut.getText()).trim().equals("")) && (Mask.limparMaskData(tvDateRecipeOut.getText()).trim().length() == 8) && (Mask.limparMaskData(tvDateRecipeIn.getText()).trim().equals(""))) {
            tvDateRecipeIn.setText(tvDateRecipeOut.getText());
        }

        if ((!Mask.limparMaskData(tvDateShopIn.getText()).trim().equals("")) && (Mask.limparMaskData(tvDateShopIn.getText()).trim().length() == 8) && (Mask.limparMaskData(tvDateShopOut.getText()).trim().equals(""))) {
            tvDateShopOut.setText(tvDateShopIn.getText());
        }
        if ((!Mask.limparMaskData(tvDateShopOut.getText()).trim().equals("")) && (Mask.limparMaskData(tvDateShopOut.getText()).trim().length() == 8) && (Mask.limparMaskData(tvDateShopIn.getText()).trim().equals(""))) {
            tvDateShopIn.setText(tvDateShopOut.getText());
        }

    }

    private boolean fieldValidation() {
        if (rbTodos.isSelected()) {
            return true;
        } else if ((rbVendasPorCliente.isSelected()) && (!fieldValidation.validCPF(tvCPF))) {
            return false;

        } else if ((rbUltimaCompraDoCliente.isSelected()) && (!fieldValidation.validCPF(tvCPF))) {
            return false;

        } else if ((rbIntervaloDeDataDeVenda.isSelected()) && (!fieldValidation.validDateShop(tvDateShopIn, tvDateShopOut))) {
            return false;

        } else if ((rbIntervaloDeDataDaReceita.isSelected()) && (!fieldValidation.validtDateRecipe(tvDateRecipeIn, tvDateRecipeOut))) {
            return false;

        } else if ((rbDataVendaPorCliente.isSelected()) && ((!fieldValidation.validCPF(tvCPF)) || (!fieldValidation.validDateShop(tvDateShopIn, tvDateShopOut)))) {
            return false;

        } else if ((rbDataReceitaPorCliente.isSelected()) && ((!fieldValidation.validCPF(tvCPF)) || (!fieldValidation.validtDateRecipe(tvDateRecipeIn, tvDateRecipeOut)))) {
            return false;
        }

        return true;
    }

    private void limparCampos() {
        //  cbFiltros.setSelectedIndex(0);
        tvCPF.setText("");
        tvDateRecipeIn.setText("");
        tvDateRecipeOut.setText("");
        tvDateShopIn.setText("");
        tvDateShopOut.setText("");
        tvName.setText("");

    }

    public void habilitaCampos(boolean acao) {
        tvCPF.setEnabled(acao);
        btPesquisaCliente.setEnabled(acao);
        tvDateShopIn.setEnabled(acao);
        tvDateShopOut.setEnabled(acao);
        tvDateRecipeIn.setEnabled(acao);
        tvDateRecipeOut.setEnabled(acao);
    }

    private void geraRel(StringBuilder sql) {

        HashMap hm2 = new HashMap();

        hm2.put("query", sql);

        File rel = new File("C:\\scanStore\\drugstore\\src\\br\\com\\kpc\\drugstore\\relatorios\\documentos.jrxml");

        try {
            //gerando o jasper design
            JasperDesign desenho = JRXmlLoader.load(rel);
            //compila o relatório
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JasperPrint print = JasperFillManager.fillReport(relatorio, hm2, ConnectionDb.getConnectionDs());
            JasperViewer visao = new JasperViewer(print, false);
            visao.setVisible(true);
        } catch (JRException jrex) {
            System.out.println("deu erro: " + jrex);
        }
    }

    public String temFiltro(String filtro) {
        if (filtro.trim().equals("")) {
            return "";
        } else {
            return " and ";
        }
    }
}
