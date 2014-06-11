/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Pcego
 */
public class SystemMessage extends JOptionPane {

    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFORMATION = 3;
    public static final int DIALOG = 4;
    public static final int SIMPLEDIALOG = 5;

    private static final String ERRO = "Ocorreu Um Erro ";
    private static final String FALHA = "Falha ao ";
    private static final String TITLE_ERROR = "Ops!! Temos Problema...! ";
    private static final String TITLE_INFORMATION = "Informação";
    private static final String TITLE_WARNING = "Ops!! Atenção!";
    private static String[] opt = {"Sim", "Não"};

    public static void kpcShowMessage(Exception ex, int id, String message) {

        if (ex != null) {

            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
        }

        switch (id) {

            case ERROR:

                showMessageDialog(null, ERRO + message,
                        TITLE_ERROR, JOptionPane.ERROR_MESSAGE, null);
                break;

            case WARNING:

                showMessageDialog(null, TITLE_WARNING + message,
                        "Ops...", JOptionPane.WARNING_MESSAGE, null);
                break;

            case INFORMATION:

                showMessageDialog(null, message,
                        TITLE_INFORMATION, JOptionPane.INFORMATION_MESSAGE, null);
                break;

        }
    }

    public int kpcDialog(int id, String message, String title) {

        switch (id) {
            case DIALOG:

                int opcao = showOptionDialog(this, message,
                        title, JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opt, opt[1]);

                return opcao;

            default:
                return -1;

            case SIMPLEDIALOG:

                showMessageDialog(null, message);
                return 0;
        }

    }

}
