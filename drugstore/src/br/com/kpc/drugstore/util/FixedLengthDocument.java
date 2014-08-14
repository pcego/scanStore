/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.kpc.drugstore.util;


import javax.swing.*;
import javax.swing.text.*;
/**
 * Utilizado para limitar caracteres 
 * Exemplo;         taMensagem.setDocument(new FixedLengthDocument(150));
 * @author www
 */
public class FixedLengthDocument extends PlainDocument
{
    private int iMaxLength;

    public FixedLengthDocument(int maxlen)
    {
        super();
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException
    {
        if (str == null)
            return;

        if (iMaxLength <= 0) // aceitara qualquer no. de caracteres
        {
            super.insertString(offset, str, attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) // se o comprimento final for menor...
            super.insertString(offset, str, attr); // ...aceita str
        else
        {
            if (getLength() == iMaxLength)
                return; // nada a fazer
            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
}