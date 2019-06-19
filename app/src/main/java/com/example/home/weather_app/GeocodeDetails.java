package com.example.home.weather_app;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.io.IOException;
import java.net.URL;

public class GeocodeDetails extends AsyncTask<URL, Void, String> {

    @SuppressLint("StaticFieldLeak")
    private MainActivity mainActivity;
    LocationModel locationModel;

    GeocodeDetails(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        geocodeNetWork = new NetworkUtilsForGeocode();
    }


    private NetworkUtilsForGeocode geocodeNetWork;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(URL... urls) {

        String geocodeSearchResults = "";

        try{
            geocodeSearchResults = geocodeNetWork.getResponseFromHttpUrl();
        }catch (IOException e){
            e.printStackTrace();
        }
        return geocodeSearchResults;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        WeatherDetails weatherDetails = new WeatherDetails(mainActivity);
        NetWorkUtils weatherNetWork = new NetWorkUtils();
        ConvertLocation.convertToLocationCode(s);
        weatherNetWork.setCode(LocationModel.getId());
        mainActivity.setName(LocationModel.getName());
        weatherDetails.setWeatherNetWork(weatherNetWork);
        weatherDetails.execute();

    }


    public void setLocation(double latitude, double longitude) {
        geocodeNetWork.setLocation(latitude, longitude);
    }
}
