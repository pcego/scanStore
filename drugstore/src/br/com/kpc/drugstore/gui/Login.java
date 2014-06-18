/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.gui;

import br.com.kpc.drugstore.core.Company;
import br.com.kpc.drugstore.service.Service;
import br.com.kpc.drugstore.service.WindowInstance;
import br.com.kpc.drugstore.util.Cryptography;
import br.com.kpc.drugstore.util.FormatDate;
import br.com.kpc.drugstore.util.KPCSeg;
import br.com.kpc.drugstore.util.Mask;
import br.com.kpc.drugstore.util.SystemMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author www
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tvCnpj = new javax.swing.JTextField();
        tvSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tvSerial = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tvCodInstalacao1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/logoKPCMini2.png"))); // NOI18N

        jLabel2.setText("CNPJ:");

        jLabel3.setText("Senha:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/Login.png"))); // NOI18N

        jButton1.setText("Chave instalação");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tvSerial.setColumns(20);
        tvSerial.setLineWrap(true);
        tvSerial.setRows(4);
        tvSerial.setTabSize(3);
        tvSerial.setAutoscrolls(false);
        jScrollPane1.setViewportView(tvSerial);

        tvCodInstalacao1.setColumns(20);
        tvCodInstalacao1.setLineWrap(true);
        tvCodInstalacao1.setRows(3);
        tvCodInstalacao1.setTabSize(4);
        tvCodInstalacao1.setAutoscrolls(false);
        jScrollPane2.setViewportView(tvCodInstalacao1);

        jButton2.setText("Validando Serial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tvSenha))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tvCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(69, 69, 69))
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(243, 243, 243))))
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tvCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tvSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String codInstall;

            KPCSeg seg = new KPCSeg();
            Company company = new Company();
            company = Service.getIRepositoryCompany().getCompany();

            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstall
            codInstall = "X,"
                    + company.getCnpj() + ","
                    + seg.getHDSerial("c") + ","
                    + seg.getCPUSerial() + ","
                    + "00/00/0000" + ","
                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
            System.out.println(codInstall);
            tvCodInstalacao1.setText(seg.encrypt(codInstall));
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        if (Service.getIRepositoryCompany().getCompany() == null) {
            WindowInstance.getInstance(WindowInstance.COMPANYWINDOW).setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String serialCompleto;
        String detalhes[];
        if (tvSerial.getText().trim().equals("")) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Favor informar o serial de instalação");
            return;
        }
        try {
            Company company = new Company();
            company = Service.getIRepositoryCompany().getCompany();

            KPCSeg seg = new KPCSeg();
            serialCompleto = seg.decrypt(tvSerial.getText());
            detalhes = serialCompleto.split(",");

            // 0   1       2           3            4             5
            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
            if (!company.getCnpj().trim().equals(detalhes[1])) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido");
                return;
            }
            if (!KPCSeg.getHDSerial("c").trim().equals(detalhes[2])) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido");
                return;
            }
            if (!KPCSeg.getCPUSerial().trim().equals(detalhes[3])) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido");
                return;
            }
            if (FormatDate.transformaData(detalhes[4]).before(new Date())) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido");
                return;
            }
            if (new Date().equals(new Date(detalhes[5]))) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido");
                return;
            }

//                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
            //tvCodInstalacao1.setText(seg.encrypt(codInstalacao));
            // tvSerial.setText();
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    public void validarSerial(String key) {
        try {
            String codInstalacao;

            KPCSeg seg = new KPCSeg();
            Company company = new Company();
            company = Service.getIRepositoryCompany().getCompany();

            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
            codInstalacao = "X,"
                    + company.getCnpj() + ","
                    + seg.getHDSerial("c") + ","
                    + seg.getCPUSerial() + ","
                    + "00/00/0000" + ","
                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
            System.out.println(codInstalacao);
            tvCodInstalacao1.setText(seg.encrypt(codInstalacao));
            tvSerial.setText(seg.decrypt(tvCodInstalacao1.getText()));
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tvCnpj;
    private javax.swing.JTextArea tvCodInstalacao1;
    private javax.swing.JTextField tvSenha;
    private javax.swing.JTextArea tvSerial;
    // End of variables declaration//GEN-END:variables

    private void validarNoService() {
        String registro;
        Company company;
        company = Service.getIRepositoryCompany().getCompany();

        registro = Cryptography.criptography(Mask.limparMaskCNPJ(company.getCnpj()) + KPCSeg.getHDSerial("c") + KPCSeg.getCPUSerial());

        tvSerial.setText(registro);
    }

}
