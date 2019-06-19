package com.example.home.weather_app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationModelTest {

    private LocationModel locationModel;

    @Before
    public void setUp() throws Exception {
        locationModel = new LocationModel();
    }

    @Test
    public void Id() {
        String id = "2541";
        locationModel.setId(id);
        String result = LocationModel.getId();
        assertEquals(result,id);
    }



    @Test
    public void Name() {
        String name = "Bishkek";
        locationModel.setName(name);
        String result = locationModel.getName();
        assertEquals(result,name);

    }



}