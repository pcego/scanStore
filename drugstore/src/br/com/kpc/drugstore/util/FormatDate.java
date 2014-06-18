/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pcego
 */
public class FormatDate {

    public static String dateCovertToShow(Date date) {

        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static Date transformaData(String data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatador.parse(data);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

}
