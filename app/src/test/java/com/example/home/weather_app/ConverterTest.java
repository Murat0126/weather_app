package com.example.home.weather_app;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import static org.junit.Assert.*;

import static androidx.test.InstrumentationRegistry.getContext;

public class ConverterTest {

    Converter converter;

    @Before
    public void setUp() throws Exception {
        converter = new Converter();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getResources().getAssets().open("weather.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



    @Test
    public void convertToWeatherList() throws IOException, JSONException {

        String weatherJson = loadJSONFromAsset();
        ArrayList<Weather> result = Converter.convertToWeatherList(weatherJson);
        assertEquals(result, 25);


    }
}