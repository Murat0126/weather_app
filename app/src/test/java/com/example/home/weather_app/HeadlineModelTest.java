package com.example.home.weather_app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeadlineModelTest {

    HeadlineModel headlineModel;

    @Before
    public void setUp() throws Exception {
        headlineModel = new HeadlineModel();
    }

    @Test
    public void setText() {
        String text = "test";
        headlineModel.setText(text);
        String result = headlineModel.getText();
        assertEquals(result,text);
    }
}