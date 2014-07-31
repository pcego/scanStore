/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.test;

import br.com.kpc.drugstore.dao.ConnectionDb;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class TestImagen extends javax.swing.JFrame {

    /**
     * Creates new form TestImagen
     */
    public TestImagen() {
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

        imagen = new javax.swing.JLabel();
        carregarImg = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        carregarImg.setText("Carregar");
        carregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarImgActionPerformed(evt);
            }
        });

        jButton1.setText("Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Documentos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carregarImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carregarImg)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarImgActionPerformed

        File img = new File("C:\\imagens\\testando.jpg");

        try {
            BufferedImage bfi = ImageIO.read(img);
            imagen.setIcon(new ImageIcon(bfi));
        } catch (IOException iex) {
            System.out.println(iex);
        }
    }//GEN-LAST:event_carregarImgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        HashMap hm = new HashMap();
        hm.put("active_opt", true);
        File rel = new File("C:\\scanStore\\drugstore\\src\\br\\com\\kpc\\drugstore\\relatorios\\RelClientsByStatus.jrxml");

        String data = null;

        //new SimpleDateFormat("yyyy/MM/dd").format(data);
        //System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(data));

        try {
            //gerando o jasper design
            JasperDesign desenho = JRXmlLoader.load(rel);
            //compila o relatório
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JasperPrint print = JasperFillManager.fillReport(relatorio, hm, ConnectionDb.getConnectionDs());
            JasperViewer visao = new JasperViewer(print, true);
            visao.setVisible(true);
        } catch (JRException jrex) {
            System.out.println("deu erro: " + jrex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        HashMap hm2 = new HashMap();
        //sql base para geração de todos os relatórios para listagem de documentos
        StringBuilder sql_base = new StringBuilder("select cl.name, cl.cpf, cl.cpf_image, cl.rg_image, r.dt_recipe, r.recipe_type, \n" +
"r.recipe_image, r.other_document, t.dt_shop, t.ticket_image, \n" +
"t.ticket_number, t.auth_number from clients as cl INNER join recipes as r\n" +
"on cl.clientId = r.CLIENT_clientId INNER join tickets as t\n" +
"on r.recipeId = t.RECIPE_recipeId ");
        
        //implementação dos filtros para relatórios de documentos
        String filtro = "WHERE cl.CPF = 95111212604 and "
                + "r.recipeId = (select MAX(recipeId) from recipes where clientId = (select clientId from clients where cpf = 95111212604))";
        sql_base.append(filtro);
        hm2.put("query", sql_base);
       
        File rel = new File("C:\\scanStore\\drugstore\\src\\br\\com\\kpc\\drugstore\\relatorios\\documentos.jrxml");

        try {
            //gerando o jasper design
            JasperDesign desenho = JRXmlLoader.load(rel);
            //compila o relatório
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JasperPrint print = JasperFillManager.fillReport(relatorio, hm2, ConnectionDb.getConnectionDs());
            JasperViewer visao = new JasperViewer(print, true);
            visao.setVisible(true);
        } catch (JRException jrex) {
            System.out.println("deu erro: " + jrex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TestImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestImagen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carregarImg;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
