package com.example.home.weather_app;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TemplateFormats {

    String date;

    public double convertToCelsius(double temperature) {
        temperature = (temperature-32) * 5/9.0;
        return temperature;
    }


    public String convertDate(String date) {
        String[] pieces_from_date = new String[2];
        int i = 0;
        for (String retval : date.split("T",2)) {
            pieces_from_date[i] = retval;
            this.date = pieces_from_date[0];
            i=i+1;
        }
        String pattern = "dd MMM yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd");
        Date newDate= null;
        try {
            newDate = spf.parse(this.date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf= new SimpleDateFormat(pattern, new Locale("ru", "DK"));
        this.date = spf.format(newDate);

        return this.date;
    }
}
