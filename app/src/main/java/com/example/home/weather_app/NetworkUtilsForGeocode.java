package com.example.home.weather_app;

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.net.Uri;

public class NetworkUtilsForGeocode {

    private final static String GEOPOSITION_BASE_URL = "https://api.openweathermap.org/data/2.5/weather?";
    private final static String api_Key = "59f75cc16ec1dcd78f84c092c08b9b01";
    private final static String PARAM_API_KEY = "appid";
    private final static String PARAM_METRIC = "metric";
    private final static String METRIC_VALUE = "true";
    private final static String PARAM_LATITUDE = "lat";
    private final static String PARAM_LONGITUDE = "lon";


    private URL geopositionURl;
    private double latitude;
    private  double longitude;

    void setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getResponseFromHttpUrl() throws IOException {
        Uri buildUri = Uri.parse(GEOPOSITION_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_LATITUDE, String.valueOf(latitude))
                .appendQueryParameter(PARAM_LONGITUDE, String.valueOf(longitude))
                .appendQueryParameter(PARAM_API_KEY, api_Key)
                .appendQueryParameter(PARAM_METRIC, METRIC_VALUE)
                .build();
        try {
            geopositionURl = new URL(buildUri.toString());
        }catch(MalformedURLException e){
            e.printStackTrace();
        }

            HttpURLConnection urlConnection = (HttpURLConnection) geopositionURl.openConnection();
            InputStream input = urlConnection.getInputStream();
            Scanner scanner =  new Scanner(input);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();

            if(hasInput){
                return scanner.next();
            }else{
                return null;
            }
    }
}
