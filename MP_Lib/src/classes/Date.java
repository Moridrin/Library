/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import calculations.Convert;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author jeroen
 */
public class Date extends java.util.Date {

    public Date() {
        super();
    }

    public Date(String date) throws ParseException {
        super();
        this.setYear(Convert.toInt(date.substring(0, 2)));
        this.setMonth(Convert.toInt(date.substring(3, 5)));
        this.setDate(Convert.toInt(date.substring(6, 8)));
    }

    public Date(int year, int month, int day) {
        super(year, month, day);
    }

    @Override
    public String toString() {
        String returner = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        returner = sdf.format(this);
        return returner;
    }

}
