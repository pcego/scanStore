/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.gui;

import br.com.kpc.drugstore.core.Company;
import br.com.kpc.drugstore.service.Service;
import br.com.kpc.drugstore.service.WindowInstance;
import br.com.kpc.drugstore.util.Config;
import br.com.kpc.drugstore.util.Cryptography;
import br.com.kpc.drugstore.util.FormatDate;
import br.com.kpc.drugstore.util.KPCSeg;
import br.com.kpc.drugstore.util.SystemMessage;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
        Config.considerarEnterComoTab(tvSenha);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tvCnpj = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btChaveInstalacao = new javax.swing.JButton();
        lbAguarde = new javax.swing.JLabel();
        btValidar = new javax.swing.JButton();
        tvSenha = new javax.swing.JPasswordField();

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

        tvCnpj.setEnabled(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/Login.png"))); // NOI18N

        btChaveInstalacao.setText("Gerar Chave.");
        btChaveInstalacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChaveInstalacaoActionPerformed(evt);
            }
        });

        lbAguarde.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbAguarde.setForeground(new java.awt.Color(0, 102, 102));
        lbAguarde.setText("Aguarde...");

        btValidar.setText("Validar");
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
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
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tvCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(tvSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btValidar))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lbAguarde)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btChaveInstalacao)
                .addGap(56, 56, 56))
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
                            .addComponent(btValidar)
                            .addComponent(tvSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAguarde)
                        .addGap(12, 12, 12))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btChaveInstalacao)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Company company = new Company();
    private String serialCompleto;
    private String[] serialDetalhes;
    private String retornoWS;

    private void btChaveInstalacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChaveInstalacaoActionPerformed
        //Gerar Chave
        gerarChave();
        //validar
        if (!validarSerial(company.getSystem_key())) {
            return;
        }


    }//GEN-LAST:event_btChaveInstalacaoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lbAguarde.setVisible(false);
        company = Service.getIRepositoryCompany().getCompany();
        if (company == null) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Não existe empresa cadastrada, é necessário cadastrar uma empresa.");
            WindowInstance.getInstance(WindowInstance.COMPANYWINDOW).setVisible(true);
            this.dispose();
        } else {

            tvCnpj.setText(company.getCnpj());
            //Iniciando verificação se esta menos de 5 dias do vencimento
            Date dataHoje = new Date();
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            // se a chave não é valida OU falta menos de 5 dias para vencer
            if ((!validarSerial(company.getSystem_key())) || (FormatDate.diferencaDias(formataData.format(dataHoje), serialDetalhes[4]) < 5)) {
                //Gerar Chave
                gerarChave();
                //validar novamente
                if (!validarSerial(company.getSystem_key())) {
                    return;
                }
            }

        }

    }//GEN-LAST:event_formWindowOpened

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        
        //Validando se o serial é valido, se não for sai da função
        if (!validarSerial(company.getSystem_key())) {
            return;
        }
        
        //Verificando usuario é senha
        if ((Cryptography.criptography(new String(tvSenha.getPassword()))).equals(company.getPasswd())) {
            WindowInstance.getInstance(WindowInstance.PRINCIPAL).setVisible(true);
            this.dispose();
        } else {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Senha inválida!");
        }


    }//GEN-LAST:event_btValidarActionPerformed

    private void gerarChave() {
        btChaveInstalacao.setEnabled(false);
        btValidar.setEnabled(false);
        lbAguarde.setVisible(true);
        //Verificar se tem internet para conectar ao WS
        if (!verificarExisteConexaoComInternet()) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Problema ao conectar ao serviço de validação, entre em contato com o suporte.");
            btChaveInstalacao.setEnabled(true);
            btValidar.setEnabled(true);
            lbAguarde.setVisible(false);
            return;
        }
        try {
            String codInstall;
            KPCSeg seg = new KPCSeg();

            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstall
            codInstall = "X,"
                    + company.getCnpj() + ","
                    + seg.getHDSerial("c") + ","
                    + seg.getCPUSerial() + ","
                    + "00/00/0000" + ","
                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));

            URL url = new URL(Config.URLWEBSERVICEVALIDACAO + seg.encrypt(codInstall).replace("/", "@").trim());
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            retornoWS = in.readLine();
            System.out.println("Res " + retornoWS);
            if (validarSerial(retornoWS)) {

                Date DataExpire = null;
                try {
                    DataExpire = new SimpleDateFormat("dd/MM/yyyy").parse(serialDetalhes[4]);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(ClienteFrame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

                company.setDateExpire(DataExpire);
                tvCnpj.setText(serialDetalhes[1]);
                company.setSystem_key(retornoWS);

                Service.getIRepositoryCompany().atualizar(company);
            }

            btChaveInstalacao.setEnabled(true);
            btValidar.setEnabled(true);
            lbAguarde.setVisible(false);
        } catch (Exception ex) {
            btValidar.setEnabled(true);
            btChaveInstalacao.setEnabled(true);
            lbAguarde.setVisible(false);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// True deu certo

    private boolean validarSerial(String key) {

        if (key.trim().equals("")) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Favor informar o serial de instalação");
            return false;
        }
        try {

            KPCSeg seg = new KPCSeg();
            serialCompleto = seg.decrypt(key);
            serialDetalhes = serialCompleto.split(",");

            // 0   1       2           3            4             5
            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
            //Valida CNPJ = do Banco
            if (!company.getCnpj().trim().equals(serialDetalhes[1])) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido 001");
                return false;
            }
            //Valida Serial HD
            if (!KPCSeg.getHDSerial("c").trim().equals(serialDetalhes[2])) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido 002");
                return false;
            }
            //Valida Serial CPU
            if (!KPCSeg.getCPUSerial().trim().equals(serialDetalhes[3])) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido 003");
                return false;
            }
            //Valida Data Vencimento
            if (FormatDate.transformaData(serialDetalhes[4]).before(new Date())) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido 004");
                return false;
            }
            //Valida se a data atual é a data da instalação
            if (new Date().equals(new Date(serialDetalhes[5]))) {
                SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido 005");
                return false;
            }

//                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
            //tvCodInstalacao1.setText(seg.encrypt(codInstalacao));
            // tvSerial.setText();
        } catch (Exception ex) {
            SystemMessage.kpcShowMessage(null, SystemMessage.ERROR, "Serial inválido 007");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

//    public void validarSerial(String key) {
//        try {
//            String codInstalacao;
//
//            KPCSeg seg = new KPCSeg();
//            Company company = new Company();
//            company = Service.getIRepositoryCompany().getCompany();
//
//            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
//            codInstalacao = "X,"
//                    + company.getCnpj() + ","
//                    + seg.getHDSerial("c") + ","
//                    + seg.getCPUSerial() + ","
//                    + "00/00/0000" + ","
//                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
//          
//            tvSerial.setText(seg.decrypt(key));
//        } catch (Exception ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
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
                /* if ("Nimbus".equals(info.getName())) {
                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
                 break;

                 }
                 */
                UIManager.setLookAndFeel(Config.THEMA);
                Properties props = new Properties();
                props.put("", "");
                AeroLookAndFeel.setCurrentTheme(props);
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
    private javax.swing.JButton btChaveInstalacao;
    private javax.swing.JButton btValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbAguarde;
    private javax.swing.JTextField tvCnpj;
    private javax.swing.JPasswordField tvSenha;
    // End of variables declaration//GEN-END:variables

    private boolean verificarExisteConexaoComInternet() {
        int respontaURL;
        try {
            java.net.URL urlWeb = new java.net.URL(Config.IPWEBSERVICEVALIDACAO); // 
            java.net.URLConnection conn = urlWeb.openConnection();

            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conn;
            httpConn.connect();
            respontaURL = httpConn.getResponseCode();

        } catch (java.net.MalformedURLException urlmal) {
            System.out.println("Não Conectado1: " + urlmal);
            return false;
        } catch (java.io.IOException ioexcp) {
            System.out.println("Não Conectado2: " + ioexcp);
            return false;
        }

        if (respontaURL == 200) {
            System.out.println("Conectado");
            return true;
        } else {
            System.out.println("Não Conectado");
            return false;
        }
    }
}
