package com.example.home.weather_app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherTest {

    private Weather weather;

    @Before
    public void setUp() throws Exception {
        weather = new Weather();

    }

    @Test
    public void Date() {
        String date = "2019 06 06";
        weather.setDate(date);
        String result = weather.getDate();
        assertEquals(result, date);
    }


    @Test
    public void MinTemp() {
        String minTemp = "20";
        weather.setMinTemp(minTemp);
        String result = weather.getMinTemp();
        assertEquals(result, minTemp);
    }

    @Test
    public void MaxTemp() {
        String maxTemp = "30";
        weather.setMaxTemp(maxTemp);
        String result = weather.getMaxTemp();
        assertEquals(result, maxTemp);
    }

    @Test
    public void Link() {
        String link = "https://stackoverflow.com/questions";
        weather.setLink(link);
        String result = weather.getLink();
        assertEquals(result, link);
    }

    @Test
    public void N_iconPhrase() {
        String n_iconPhrase = "Преимущественно ясно";
        weather.seticonPhrase(n_iconPhrase);
        String result = weather.getN_iconPhrase();
        assertEquals(result, n_iconPhrase);
    }

    @Test
    public void D_iconPhrase() {
        String d_iconPhrase = "Ливни";
        weather.set_d_iconPhrase(d_iconPhrase);
        String result = weather.getD_iconPhrase();
        assertEquals(result, d_iconPhrase);
    }

    @Test
    public void D_icon() {
        String d_icon = "3";
        weather.set_d_icon(d_icon);
        String result = weather.getD_icon();
        assertEquals(result, d_icon);
    }

    @Test
    public void N_icon() {
        String n_icon = "12";
        weather.set_n_icon(n_icon);
        String result = weather.getN_icon();
        assertEquals(result, n_icon);
    }

}