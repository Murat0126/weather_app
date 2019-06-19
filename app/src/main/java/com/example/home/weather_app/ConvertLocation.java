package com.example.home.weather_app;

import org.json.JSONException;
import org.json.JSONObject;


public class ConvertLocation {
    public static void convertToLocationCode(String locationSearchRezults) {
        String resultId = "";
        String resultName = "";
        LocationModel locationModel = new LocationModel();
        MainActivity mainActivity = new MainActivity();

        try{
            JSONObject rootObject = new JSONObject(locationSearchRezults);
            resultId = rootObject.getString("id");
            resultName = rootObject.getString("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        locationModel.setId(resultId);
        locationModel.setName(resultName);

    }
}
