/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author www
 */
public class Mask {

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo CPF
     * @throws ParseException
     */
    public static void maskCPF(JFormattedTextField field) throws ParseException {
        MaskFormatter cpf = new MaskFormatter();
        cpf.setMask("###.###.###-##");
        cpf.install(field);
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo CPF
     * @throws ParseException
     */
    public static void maskCNPJ(JFormattedTextField field) throws ParseException {
        MaskFormatter cnpj = new MaskFormatter();
        cnpj.setMask("##.###.###/####-##");
        cnpj.install(field);
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo CPF
     * @throws ParseException
     */
    public static void maskDate(JFormattedTextField field) throws ParseException {
        MaskFormatter data = new MaskFormatter();
        data.setMask("##/##/####");
        data.install(field);
        field.setText("");
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo RG
     * @throws ParseException
     */
    public static void maskRG(JFormattedTextField field) throws ParseException {
        MaskFormatter rg = new MaskFormatter();
        rg.setMask("#######-#");
        rg.install(field);
    }

    public static void maskIncricaoEstadual(JFormattedTextField field) throws ParseException {
        MaskFormatter inscricao = new MaskFormatter();
        inscricao.setMask("##.###.###-#");
        inscricao.install(field);
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo numero com
     * a <br>
     * quantidade de colunas determinado no field setColumn determina o tamanho
     * do JTextFiel digito
     * @throws ParseException
     */
    public static void maskNumber(JFormattedTextField field) throws ParseException {
        MaskFormatter digite = new MaskFormatter();
        String mask = "########";
        for (int i = 0; i < field.getColumns(); i++) {
            mask += "#";
        }
        digite.setMask(mask);
        digite.install(field);
        field.setText("");
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo telefone
     * @throws ParseException
     */
    public static void maskFone(JFormattedTextField field) throws ParseException {
        MaskFormatter fone = new MaskFormatter();
        fone.setMask("(##)####-####");
        fone.install(field);
        field.setText("");
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo Cep
     * @throws ParseException
     */
    public static void maskCep(JFormattedTextField field) throws ParseException {
        MaskFormatter cep = new MaskFormatter();
        cep.setMask("#####-###");
        cep.install(field);
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo Renavam
     * @throws ParseException
     */
    public static void maskRenavam(JFormattedTextField field) throws ParseException {
        MaskFormatter renavam = new MaskFormatter();
        renavam.setMask("##.######-#");
        renavam.install(field);
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo placa
     * @throws ParseException
     */
    public static void maskPlaca(JFormattedTextField field) throws ParseException {
        MaskFormatter placa = new MaskFormatter();
        placa.setMask("UUU-####");
        placa.install(field);
    }

    /**
     * Método que configurar a mascara no JFormattedTextField
     *
     * @param field Recebe o campo para configurar a mascara do tipo 10 caracter
     * em maiusculo
     * @throws ParseException
     */
    public static void maskCaracterMa50(JFormattedTextField field) throws ParseException {
        MaskFormatter placa = new MaskFormatter();
        placa.setMask("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        placa.install(field);
    }

    /**
     * Metodo estatico para validar CPF e/ou CNPJ
     *
     * @param s_aux String com CPF ou CNPJ para ser validado
     * @return true para CPF ou CNPJ valido e false para invalido
     */
    public static boolean validaCpfCnpj(String s_aux) {
        s_aux = s_aux.replace(".", "").replace("-", "").replace("/", "").trim();
        if (s_aux.length() != 11 && s_aux.length() != 14) {
            return false;
        }

        if (s_aux.length() == 11) {
            if (s_aux.equals("00000000000") || s_aux.equals("11111111111")
                    || s_aux.equals("22222222222") || s_aux.equals("33333333333")
                    || s_aux.equals("44444444444") || s_aux.equals("55555555555")
                    || s_aux.equals("66666666666") || s_aux.equals("77777777777")
                    || s_aux.equals("88888888888") || s_aux.equals("99999999999")) {
                return (false);
            }

            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();

                d1 = d1 + (11 - n_Count) * digitoCPF;

                d2 = d2 + (12 - n_Count) * digitoCPF;
            }

            resto = (d1 % 11);

            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;

            resto = (d2 % 11);

            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }

            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());

            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

            return nDigVerific.equals(nDigResult);
        } else if (s_aux.length() == 14) {
            int soma = 0, aux, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();

            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);

            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }

    public static String maskMostradata(JFormattedTextField field) throws ParseException {
        //pega data do computador
        Date data = new Date();
        //cria o formatador
        SimpleDateFormat dformatador = new SimpleDateFormat("dd/MM/yyyy");
        // cria a string para armazenar data
        String sData = dformatador.format(data);

        //retorna o pedido
        return sData;
    }

    public static String limparMaskCPF(String cpf) {
        return cpf.replace(".", "").replace("-", "");
    }

    public static String limparMaskCNPJ(String cpf) {
        return cpf.replace(".", "").replace("-", "").replace("/", "");
    }

    public static String limparMasTelefone(String cpf) {
        return cpf.replace("(", "").replace(")", "").replace("-)", "");
    }

    public static void validaSomenteNumero(JTextField Numero) {
        long valor;
        if (Numero.getText().trim().length() != 0) {
            try {
                valor = Long.parseLong(Numero.getText().trim());
            } catch (NumberFormatException ex) {
                SystemMessage.kpcShowMessage(ex, SystemMessage.INFORMATION, "Esse Campo só aceita números");

                Numero.grabFocus();// foca o campo 
                Numero.setText(""); //limpa o campo 
            }
        }
    }
}
