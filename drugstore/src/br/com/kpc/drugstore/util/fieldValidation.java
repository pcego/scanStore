/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import javax.swing.JFormattedTextField;

/**
 *
 * @author www
 */
public class fieldValidation {

    public static boolean validCPF(JFormattedTextField tvCPF) {
        if ((Mask.limparMaskCPF(tvCPF.getText()).trim().equals("")) || (tvCPF.getText().trim().length() < 14)) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Informe seu CPF!");
            tvCPF.requestFocus();
            return false;
        } else if (!Mask.validaCpfCnpj(tvCPF.getText())) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "CPF digitado é inválido");
            tvCPF.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validDateShop(JFormattedTextField tvDateShopIn, JFormattedTextField tvDateShopOut) {
        if ((Mask.limparMaskData(tvDateShopIn.getText()).trim().equals("")) || (Mask.limparMaskData(tvDateShopIn.getText()).trim().length() < 8)) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Por favor, insira uma data válida!");
            tvDateShopIn.requestFocus();
            return false;
        }
        if ((Mask.limparMaskData(tvDateShopOut.getText()).trim().equals("")) || (Mask.limparMaskData(tvDateShopOut.getText()).trim().length() < 8)) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Por favor, insira uma data válida!");
            tvDateShopOut.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validtDateRecipe(JFormattedTextField tvDateRecipeIn, JFormattedTextField tvDateRecipeOut) {
        if ((Mask.limparMaskData(tvDateRecipeIn.getText()).trim().equals("")) || (Mask.limparMaskData(tvDateRecipeIn.getText()).trim().length() < 8)) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Por favor, insira uma data válida!");
            tvDateRecipeIn.requestFocus();
            return false;
        }
        if ((Mask.limparMaskData(tvDateRecipeOut.getText()).trim().equals("")) || (Mask.limparMaskData(tvDateRecipeOut.getText()).trim().length() < 8)) {
            SystemMessage.kpcShowMessage(null, SystemMessage.INFORMATION, "Por favor, insira uma data válida!");
            tvDateRecipeOut.requestFocus();
            return false;
        }

        return true;
    }

}
