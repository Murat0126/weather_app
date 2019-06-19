package com.example.home.weather_app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


class Converter {

    static ArrayList<Weather> convertToWeatherList(String weatherSearchRezults) {
        ArrayList<Weather> weatherArrayList = new ArrayList<>();

        try{
            JSONObject rootObject = new JSONObject(weatherSearchRezults);
            JSONArray results = rootObject.getJSONArray("DailyForecasts");

            for (int i = 0; i<results.length(); i++ ){

                Weather weather = new Weather();
                JSONObject dailyForecastsObj = results.getJSONObject(i);
                String date = dailyForecastsObj.getString("Date");
                weather.setDate(date);

                JSONObject temperatureObj = dailyForecastsObj.getJSONObject("Temperature");
                String minTemperature = temperatureObj.getJSONObject("Minimum").getString("Value");
                weather.setMinTemp(minTemperature);

                JSONObject dayObj = dailyForecastsObj.getJSONObject("Day");
                String d_iconPhrase = dayObj.getString("IconPhrase");
                weather.set_d_iconPhrase(d_iconPhrase);
                String d_icon = dayObj.getString("Icon");
                weather.set_d_icon(d_icon);

                JSONObject nightObj = dailyForecastsObj.getJSONObject("Night");
                String n_iconPhrase = nightObj.getString("IconPhrase");
                weather.seticonPhrase(n_iconPhrase);
                String n_icon = dayObj.getString("Icon");
                weather.set_n_icon(n_icon);

                String maxTemperature = temperatureObj.getJSONObject("Maximum").getString("Value");
                weather.setMaxTemp(maxTemperature);

                String link = dailyForecastsObj.getString("Link");
                weather.setLink(link);
                weatherArrayList.add(weather);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weatherArrayList;

    }

}
