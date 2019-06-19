package com.example.home.weather_app;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherIconsTest {

    WeatherIcons weatherIcons = new WeatherIcons();
    @Test
    public void getIcon() {
        int number = 5;
        int icon = weatherIcons.getIcon(number);
        assertEquals(icon,  R.drawable.ic5);
    }
}