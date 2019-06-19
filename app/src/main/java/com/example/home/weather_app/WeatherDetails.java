package com.example.home.weather_app;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class
WeatherDetails extends AsyncTask<URL, Void, String> {

    @SuppressLint("StaticFieldLeak")
    private MainActivity mainActivity;
    LocationModel locationModel =new LocationModel();


    WeatherDetails(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }


    public void setWeatherNetWork(NetWorkUtils weatherNetWork) {
        this.weatherNetWork = weatherNetWork;
    }

    private NetWorkUtils weatherNetWork;
    private ArrayList<Weather>  weatherArrayList;
    private String headlineModels;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(URL... urls) {

        String weatherSearchResults = null;

        try{
            weatherSearchResults = weatherNetWork.getResponseFromHttpUrl();
        }catch (IOException e){
            e.printStackTrace();
        }

        if(weatherSearchResults != null && !weatherSearchResults.equals("")){
            weatherArrayList = Converter.convertToWeatherList(weatherSearchResults);
            headlineModels = ConverterForHeadLine.convertToTextView(weatherSearchResults);
        }
        return weatherSearchResults;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mainActivity.setWeatherList(weatherArrayList);
        mainActivity.setHeadlineText(headlineModels);

    }

}