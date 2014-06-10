/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.gui;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.IRepositoryClient;
import br.com.kpc.drugstore.core.IRepositoryRecipe;
import br.com.kpc.drugstore.core.Recipe;
import br.com.kpc.drugstore.core.Ticket;
import br.com.kpc.drugstore.dao.DaoClient;
import br.com.kpc.drugstore.dao.DaoRecipe;
import br.com.kpc.drugstore.scan.Scan;
import br.com.kpc.drugstore.service.Service;
import br.com.kpc.drugstore.util.Config;
import br.com.kpc.drugstore.util.FormatDate;
import br.com.kpc.drugstore.util.Mask;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.omg.CORBA.TCKind;

/**
 *
 * @author www
 */
public class RecipeFrame extends javax.swing.JFrame {

    /**
     * Creates new form RecipeFrame
     */
    public RecipeFrame() {
        initComponents();
        definindoMask();
        btTypeDefault();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btPesquisaCliente = new javax.swing.JButton();
        rbAnticoncepcional = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tvCupomFiscal = new javax.swing.JTextField();
        tvCPF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tvNumAutorizacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tvNomeCliente = new javax.swing.JTextField();
        tvDtVenda = new javax.swing.JFormattedTextField();
        tvDtReceita = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        displayOutros = new javax.swing.JLabel();
        displayCupom = new javax.swing.JLabel();
        displayReceita = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Receita - KPC Software Delopmet");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/salvar.png"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Receitas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/pesquisa.png"))); // NOI18N
        btPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaClienteActionPerformed(evt);
            }
        });

        rbAnticoncepcional.setText("Receita de Anticoncepcional");

        jLabel5.setText("Data Venda:");

        jLabel4.setText("Data da Receita:");

        tvCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tvCPFFocusLost(evt);
            }
        });

        jLabel1.setText("CPF:");

        jLabel2.setText("Nº de Autorização:");

        jLabel3.setText("Nº Cupom Fiscal:");

        jLabel7.setText("Nome do cliente:");

        tvNomeCliente.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbAnticoncepcional)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tvCupomFiscal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tvNumAutorizacao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tvCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tvNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tvDtReceita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(tvDtVenda, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(99, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tvCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(btPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tvNumAutorizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(tvDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tvNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvCupomFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(tvDtReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(rbAnticoncepcional)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/logoKPCMini2.png"))); // NOI18N

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/CadReceita2.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digitalização", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        displayOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receita.png"))); // NOI18N
        displayOutros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayOutrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                displayOutrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                displayOutrosMouseExited(evt);
            }
        });

        displayCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receita.png"))); // NOI18N
        displayCupom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayCupomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                displayCupomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                displayCupomMouseExited(evt);
            }
        });

        displayReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receita.png"))); // NOI18N
        displayReceita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayReceitaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                displayReceitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                displayReceitaMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Receita");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Outro");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cupom");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(displayReceita)
                .addGap(117, 117, 117)
                .addComponent(displayCupom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayOutros)
                .addGap(85, 85, 85))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel8)
                .addGap(163, 163, 163)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayCupom)
                    .addComponent(displayOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10))
                    .addComponent(jLabel9)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btConfirmar, btNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btConfirmar)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Declarações de variaveis Globais
     */
    private IRepositoryClient repoCliente = (IRepositoryClient) new DaoClient();
    private IRepositoryRecipe repoRecipe = (IRepositoryRecipe) new DaoRecipe();
    private Recipe recipeVG = new Recipe();
    private Ticket ticketVG = new Ticket();
    private static Client clientVG = new Client();

    ;
    private void definindoMask() {

        try {
            Mask.maskCPF(tvCPF);
            Mask.maskDate(tvDtReceita);
            Mask.maskDate(tvDtVenda);
        } catch (ParseException ex) {
            Logger.getLogger(RecipeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        recipeVG.setClient(clientVG);
        recipeVG.setDt_recipe(new Date(tvDtReceita.getText()));

        if (rbAnticoncepcional.isSelected()) {
            recipeVG.setRecipe_type("anticoncepcional");
        } else {
            recipeVG.setRecipe_type("normal");
        }

        ticketVG.setAuth_number(tvNumAutorizacao.getText());
        ticketVG.setDt_shop(new Date(tvDtVenda.getText()));
        ticketVG.setTicket_number(tvCupomFiscal.getText());

        Service.getIRepositoryRecipe().salvar(recipeVG);
        Service.getIRepositoryTicket().salvar(ticketVG);


    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        btTypeDefault();
        limparCampos();

    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaClienteActionPerformed
        ConsultarCliente.getJanelaConsultarCliente("CADRECEITA").setVisible(true);
    }//GEN-LAST:event_btPesquisaClienteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        btTypeDefault();
        limparCampos();
    }//GEN-LAST:event_formWindowClosed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        btTypeInsert();
        tvDtVenda.setText(FormatDate.dateCovertToShow(new Date()));

    }//GEN-LAST:event_btNovoActionPerformed

    private void tvCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tvCPFFocusLost
        if (tvCPF.getText().trim().length() == 14) {
            clientVG = Service.getIRepositoryClient().getClientByCpf(Mask.limparMaskCPF(tvCPF.getText()).trim(), true);
            tvNomeCliente.setText(clientVG.getName());
        }
    }//GEN-LAST:event_tvCPFFocusLost

    private void displayReceitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayReceitaMouseClicked
        boolean retorno = false;
        Scan sc = new Scan();
        File[] img = sc.getGuiScan(Config.DIRETORIOIMAGEM + Mask.limparMaskCPF(tvCPF.getText()));

        retorno = Scan.renameImg(img[0], Config.DIRETORIOIMAGEM + Mask.limparMaskCPF(tvCPF.getText()), "receita.jpg");
        //carregarImg(displayReceita, img[0]);

        if (retorno) {
            recipeVG.setRecipe_image(Mask.limparMaskCPF(tvCPF.getText()) + "receita.jpg");
            System.out.println("sucesso");
            displayReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receitaScannerOK.png")));

        } else {
            System.out.println("falha ao renomear");
        }

    }//GEN-LAST:event_displayReceitaMouseClicked

    private void displayCupomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayCupomMouseClicked
        boolean retorno = false;
        Scan sc = new Scan();
        File[] img = sc.getGuiScan(Config.DIRETORIOIMAGEM + Mask.limparMaskCPF(tvCPF.getText()));

        retorno = Scan.renameImg(img[0], Config.DIRETORIOIMAGEM + Mask.limparMaskCPF(tvCPF.getText()), "cupom.jpg");
        //carregarImg(displayReceita, img[0]);

        if (retorno) {
            ticketVG.setTicket_image(Mask.limparMaskCPF(tvCPF.getText()) + "cupom.jpg");
            System.out.println("sucesso");
            displayCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receitaScannerOK.png")));

        } else {
            System.out.println("falha ao renomear");
        }
    }//GEN-LAST:event_displayCupomMouseClicked

    private void displayReceitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayReceitaMouseEntered

        displayReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receitaScanner.png")));

    }//GEN-LAST:event_displayReceitaMouseEntered

    private void displayReceitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayReceitaMouseExited
        displayReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receita.png")));
    }//GEN-LAST:event_displayReceitaMouseExited

    private void displayCupomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayCupomMouseEntered
        displayCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receitaScanner.png")));
    }//GEN-LAST:event_displayCupomMouseEntered

    private void displayOutrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayOutrosMouseEntered
        displayOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receitaScanner.png")));
    }//GEN-LAST:event_displayOutrosMouseEntered

    private void displayCupomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayCupomMouseExited
        displayCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receita.png")));
    }//GEN-LAST:event_displayCupomMouseExited

    private void displayOutrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayOutrosMouseExited
        displayOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receita.png")));
    }//GEN-LAST:event_displayOutrosMouseExited

    private void displayOutrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayOutrosMouseClicked
        boolean retorno = false;
        Scan sc = new Scan();
        File[] img = sc.getGuiScan(Config.DIRETORIOIMAGEM + Mask.limparMaskCPF(tvCPF.getText()));

        retorno = Scan.renameImg(img[0], Config.DIRETORIOIMAGEM + Mask.limparMaskCPF(tvCPF.getText()), "outroDocumento.jpg");
        //  carregarImg(displayReceita, img[0]);

        if (retorno) {
            ticketVG.setTicket_image(Mask.limparMaskCPF(tvCPF.getText()) + "outroDocumento.jpg");
            System.out.println("sucesso");
            displayOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/kpc/drugstore/img/receitaScannerOK.png")));

        } else {
            System.out.println("falha ao renomear");
        }
    }//GEN-LAST:event_displayOutrosMouseClicked

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
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecipeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisaCliente;
    private javax.swing.JLabel displayCupom;
    private javax.swing.JLabel displayOutros;
    private javax.swing.JLabel displayReceita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JRadioButton rbAnticoncepcional;
    private static javax.swing.JFormattedTextField tvCPF;
    private javax.swing.JTextField tvCupomFiscal;
    private javax.swing.JFormattedTextField tvDtReceita;
    private javax.swing.JFormattedTextField tvDtVenda;
    private javax.swing.JTextField tvNomeCliente;
    private javax.swing.JTextField tvNumAutorizacao;
    // End of variables declaration//GEN-END:variables

    private void carregarImg(JLabel componente, File img) {

        //File img = new File("C:\\imagens\\testando.jpg");
        //File img = new File(caminho);
        try {
            BufferedImage bfi = ImageIO.read(img);

            componente.setIcon(new ImageIcon(bfi));
        } catch (IOException iex) {
            System.out.println(iex);
        }
    }

    protected static void getClienteRetorno(Client cli) {
        clientVG = cli;
        tvCPF.setText(clientVG.getCpf());
    }

    private void limparCampos() {
        tvCPF.setText("");
        tvNumAutorizacao.setText("");
        tvCupomFiscal.setText("");
        tvDtVenda.setText("");
        tvDtReceita.setText("");
        rbAnticoncepcional.setSelected(false);

    }

    private void habilitarCampos(boolean acao) {
        tvCPF.setEnabled(acao);
        tvNumAutorizacao.setEnabled(acao);
        tvCupomFiscal.setEnabled(acao);
        tvDtVenda.setEnabled(acao);
        tvDtReceita.setEnabled(acao);
        rbAnticoncepcional.setEnabled(acao);
    }

    private void btTypeDefault() {
        habilitarCampos(false);
        btNovo.setEnabled(true);
        btConfirmar.setEnabled(false);
        btCancelar.setEnabled(false);
        btPesquisaCliente.setEnabled(false);
    }

    private void btTypeInsert() {
        limparCampos();
        habilitarCampos(true);
        btNovo.setEnabled(false);
        btConfirmar.setEnabled(true);
        btCancelar.setEnabled(true);
        btPesquisaCliente.setEnabled(true);

    }

}
