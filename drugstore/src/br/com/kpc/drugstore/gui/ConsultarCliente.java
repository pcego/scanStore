/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.gui;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.IRepositoryClient;
import br.com.kpc.drugstore.dao.DaoClient;
import br.com.kpc.drugstore.tableModel.TableModelClient;
import br.com.kpc.drugstore.util.Mask;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author www
 */
public class ConsultarCliente extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarCliente
     */
    public ConsultarCliente() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbGrid = new javax.swing.JTable();
        btPesquisa = new javax.swing.JButton();
        cbOpcao = new javax.swing.JComboBox();
        tvCriterio = new javax.swing.JFormattedTextField();
        lTotalRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbGrid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbGridKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbGrid);
        if (tbGrid.getColumnModel().getColumnCount() > 0) {
            tbGrid.getColumnModel().getColumn(0).setPreferredWidth(150);
            tbGrid.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbGrid.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        btPesquisa.setText("Pesquisa");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        cbOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CIDADE", "NOME", "CPF", "TODOS" }));
        cbOpcao.setSelectedIndex(1);
        cbOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOpcaoActionPerformed(evt);
            }
        });

        tvCriterio.setMaximumSize(new java.awt.Dimension(50, 50));
        tvCriterio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tvCriterioFocusLost(evt);
            }
        });

        lTotalRegistros.setText("Total Registros: 00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tvCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisa))
                    .addComponent(jScrollPane2)
                    .addComponent(lTotalRegistros))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisa)
                    .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lTotalRegistros))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Client client;
    TableModelClient model;
    private static String janelaDeRetorno;


    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        loadingTable();


    }//GEN-LAST:event_btPesquisaActionPerformed

    private void cbOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOpcaoActionPerformed
        try {

            switch (cbOpcao.getSelectedItem().toString()) {
                case "CPF":
                    tvCriterio.setEnabled(true);
                    tvCriterio.setSize(200, 28);
                    try {
                        tvCriterio.setValue(null);
                        MaskFormatter cpf = new MaskFormatter("###.###.###-##");
                        tvCriterio.setFormatterFactory(
                                new DefaultFormatterFactory(cpf));
                        tvCriterio.updateUI();
                    } catch (ParseException ex) {
                        Logger.getLogger(RecipeFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "TODOS":
                    tvCriterio.setSize(400, 28);
                    tvCriterio.setEnabled(false);
                    tvCriterio.setText("");
                    break;
                default:
                    tvCriterio.setEnabled(true);
                    tvCriterio.setSize(400, 28);
                    try {
                        tvCriterio.setValue(null);
                        MaskFormatter cpf = new MaskFormatter("**************************************************");
                        tvCriterio.setFormatterFactory(
                                new DefaultFormatterFactory(cpf));
                        tvCriterio.updateUI();
                    } catch (ParseException ex) {
                        Logger.getLogger(RecipeFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbOpcaoActionPerformed

    private void tbGridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbGridKeyPressed
        Client cli = new Client();
        cli = model.getClient(tbGrid.getSelectedRow());

        switch (janelaDeRetorno) {
            case "CADCLIENTE":
                ClienteFrame.getCliente(cli);
                break;
            case "CADRECEITA":
                RecipeFrame.getClienteRetorno(cli);

        }

        this.dispose();
    }//GEN-LAST:event_tbGridKeyPressed

    private void tvCriterioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tvCriterioFocusLost
        tvCriterio.setText(tvCriterio.getText().toUpperCase());
    }//GEN-LAST:event_tvCriterioFocusLost

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
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisa;
    private javax.swing.JComboBox cbOpcao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lTotalRegistros;
    private javax.swing.JTable tbGrid;
    private javax.swing.JFormattedTextField tvCriterio;
    // End of variables declaration//GEN-END:variables

    private void loadingTable() {
        IRepositoryClient iRepositoryClient = (IRepositoryClient) new DaoClient();
        List<Client> listClisnt = new ArrayList<Client>();
        listClisnt.clear();

        switch (cbOpcao.getSelectedItem().toString()) {
            case "CIDADE":
                if (validarTamanhoDoCampos()) {
                    listClisnt = iRepositoryClient.listClientByCity(tvCriterio.getText().trim(), true);
                    verificarRegistros(listClisnt.size());
                }
                break;
            case "NOME":
                if (validarTamanhoDoCampos()) {
                    listClisnt = iRepositoryClient.listClientByName(tvCriterio.getText().trim(), true);
                    verificarRegistros(listClisnt.size());
                }
                break;
            case "CPF":
                if (Mask.validaCpfCnpj(tvCriterio.getText())) {
                    client = new Client();
                    client = iRepositoryClient.getClientByCpf(tvCriterio.getText().trim(), true);
                    listClisnt.add(client);
                    verificarRegistros(listClisnt.size());
                } else {
                    JOptionPane.showMessageDialog(this, "CPF digitado é inválido");
                }

                break;
            case "TODOS":
                listClisnt = iRepositoryClient.listAll(true);
                verificarRegistros(listClisnt.size());
                break;
        }
        model = new TableModelClient(listClisnt);
        tbGrid.setModel(model);
    }

    protected static ConsultarCliente consultarCliente;

    protected static ConsultarCliente getJanelaNULL() {
        consultarCliente = null;
        return consultarCliente;
    }

    protected static ConsultarCliente getJanelaConsultarCliente(String janela) {
        if (consultarCliente == null) {
            consultarCliente = new ConsultarCliente();
        }
        janelaDeRetorno = janela;
        return consultarCliente;
    }

    private boolean validarTamanhoDoCampos() {

        if (tvCriterio.getText().length() < 3) {
            JOptionPane.showMessageDialog(this, "Por favor, digite no minimo 3 character");
            return false;
        }
        return true;

    }

    private void verificarRegistros(int qtdRegistros) {
        if (qtdRegistros > 0) {
            lTotalRegistros.setText("Total Registros: " + qtdRegistros);
        } else {
            int resposta;
            String[] opcoes = {"Sim", "Nao"};
            resposta = JOptionPane.showOptionDialog(this, "Cliente não encontrado deseja cadastra?",
                    "Cliente não encotnrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (resposta == 0) {
                ClienteFrame.getJanelaCliente().setVisible(true);
                this.dispose();
            }
        }
    }

}