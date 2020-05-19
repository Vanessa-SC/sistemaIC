/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Vanessa Hwang
 */
public class funciones {
   SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
   SimpleDateFormat dd = new SimpleDateFormat("dd");
    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return yyyyMMdd.format(jd.getDate());
        } else {
            return null;
        }
    }
    
    public String getFechaActual(){
        //Calendar fecha = Calendar.getInstance();
        Date fecha = new Date();
        return yyyyMMdd.format(fecha);
    }
}
