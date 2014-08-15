/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import javax.swing.JOptionPane;

/**
 *
 * @author pcego
 */
public class RunBackup extends GenericBackup {

    public void createBackup() {

        if (backup()) {
            JOptionPane.showMessageDialog(null, "Backup Realizado Com Sucesso",
                    "Ferramenta Backup", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao Criar Backup. Arquivo Gerado foi Corrompido!!",
                    "Ferramenta Backup", JOptionPane.INFORMATION_MESSAGE);
        }
    }

//    public void restore() throws IOException {
//
//        if (restoreBackup()) {
//            JOptionPane.showMessageDialog(null, "Recuperação Realizada Com Sucesso",
//                    "Ferramenta Backup", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Falha ao Recuperar Backup",
//                    "Ferramenta Backup", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
}
