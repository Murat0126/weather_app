package com.example.home.weather_app;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetWorkUtils {

    private final static String WEATHERDB_BASE_URL =
            "http://dataservice.accuweather.com/forecasts/v1/daily/5day/";
    private final static String api_Key = "pDwZQqdvQgSK4gxEbx1Y9HeCb5triviF";
    private final static String PARAM_API_KEY = "apikey";
    private final static String LANGUAGE = "language";
    private final static String PARAM_LANGUAGE = "ru";
    private URL weatherURl;
    public String code;

    public void setCode(String code) {
        this.code = code;
    }

    String getResponseFromHttpUrl() throws IOException {

        Uri BuildUri = Uri.parse(WEATHERDB_BASE_URL + code).buildUpon()
                .appendQueryParameter(PARAM_API_KEY,api_Key)
                .appendQueryParameter(LANGUAGE, PARAM_LANGUAGE)
                .build();
        try {
            weatherURl = new URL(BuildUri.toString());
        }catch(MalformedURLException e){
            e.printStackTrace();
        }

        HttpURLConnection urlConnection = (HttpURLConnection) weatherURl.openConnection();

        try{
            InputStream input = urlConnection.getInputStream();
            Scanner scanner =  new Scanner(input);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();

            if(hasInput){
                return scanner.next();
            }else{
                return null;
            }
        }finally {
            urlConnection.disconnect();
        }
    }
}
