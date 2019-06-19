package com.example.home.weather_app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemplateFormatsTest {

    TemplateFormats templateFormats;


    @Before
    public void setUp() throws Exception {
        templateFormats = new TemplateFormats();
    }


    @Test
    public void convertToCelsius() {
        double tempFarenhait = 50;
        double tempCelcius = templateFormats.convertToCelsius(tempFarenhait);
        Assert.assertEquals(tempCelcius, 10.0, .1);
    }

    @Test
    public void convertDate() {
        String date = "2019-06-13T07:00:00+09:00";
        String result = templateFormats.convertDate(date);
        assertEquals(result,"13 июн 2019");
    }



}