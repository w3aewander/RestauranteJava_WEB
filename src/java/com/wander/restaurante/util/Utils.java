/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Wanderlei
 */
public class Utils {

    /**
     * Converte uma string em data
     *
     * @param s
     * @return
     * @throws ParseException
     */
    public static java.util.Date toDBDateFromString(String s) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date d = sf.parse(s);
        return d;
    }

    /**
     * Método sobrecarregado para converter uma String em data
     *
     * @param s
     * @param formato
     * @return
     * @throws ParseException
     */
    public static java.util.Date toDBDateFromString(String s, String formato) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(formato);
        java.util.Date d = sf.parse(s);
        return d;
    }

    /**
     * Converte uma data do banco MySQL para o format string dd/MM/yyyy
     *
     * @param d
     * @return String
     */
    public static String fromDBDateToString(java.sql.Date d) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        return sf.format(d);
    }

    /**
     * Método sobrecarregado para converter uma data do banco MySQL para o
     * format string dd/MM/yyyy
     *
     * @param d
     * @param formato
     * @return String
     */
    public static String fromDBDateToString(java.sql.Date d, String formato) {
        SimpleDateFormat sf = new SimpleDateFormat(formato);
        return sf.format(d);
    }

    /**
     *
     * @param d
     * @return
     */
    public static java.sql.Date convertJavaDateToSqlDate(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    public static Calendar convertReverse(Timestamp value) {
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        format.setLenient(false);
        String stringData = format.format(value);
        Calendar data = Calendar.getInstance();
        try {
            data.setTimeInMillis(format.parse(stringData).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
