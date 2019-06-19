package com.example.home.weather_app;

import org.json.JSONException;
import org.json.JSONObject;

public class ConverterForHeadLine {

    public static String convertToTextView (String searchText){
       String textInHeadline = "";
        HeadlineModel headlineModel = new HeadlineModel();

        try{
            JSONObject rootObject = new JSONObject(searchText);
            JSONObject resultHeadline = rootObject.getJSONObject("Headline");
            String text = resultHeadline.getString("Text");
            headlineModel.setText(text);
            textInHeadline = text;

        }catch (JSONException e){
            e.printStackTrace();
        }

        return textInHeadline;

    }
}
