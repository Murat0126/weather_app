package com.example.home.weather_app;
public class LocationModel {

    static String id = "";
    static String name = "";

    public static String getId() {
        return id;
    }

    public void setId(String resultId) {
        id = resultId;
    }

    public static String getName(){
        return name;
    }

    public void setName(String resultName) {
        name = resultName;
    }
}
