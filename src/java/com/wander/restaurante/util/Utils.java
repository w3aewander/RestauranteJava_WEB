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

    public Timestamp convertForward(Calendar value) {
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        format.setLenient(false);
        String stringData = format.format(value.getTime());
        Timestamp data = null;
        try {
            data = new Timestamp(format.parse(stringData).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
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
        }
        return data;
    }
}
