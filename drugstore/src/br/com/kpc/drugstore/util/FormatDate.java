/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import br.com.kpc.drugstore.gui.ClienteFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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

    public static long diferencaDias(String dtInicial, String dtFinal) {
        
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            ini.setTime(sdf.parse(dtInicial));
            fim.setTime(sdf.parse(dtFinal));
        } catch (Exception e) {
        }

        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();

        System.out.println("Total " +  ((dt2 - dt1) / 86400000) );

        return ((dt2 - dt1) / 86400000);
    }
}
