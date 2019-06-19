package com.example.home.weather_app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class WeatherAdapter extends ArrayAdapter<Weather> {

    private Context context;

    public WeatherAdapter(Context context, ArrayList<Weather> weatherArrayList) {
        super(context,0 , weatherArrayList);
        this.context = context;
}

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Weather weather = (Weather) getItem(position);
        WeatherIcons weatherIcons = new WeatherIcons();
        TemplateFormats templateFormats = new TemplateFormats();

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView dateTextView = (TextView) convertView.findViewById(R.id.tvDate);
        TextView minTextView = (TextView) convertView.findViewById(R.id.tvLowTemperature);
        TextView maxTextView = (TextView) convertView.findViewById(R.id.tvHighTemperature);
        TextView linkTextView = (TextView) convertView.findViewById(R.id.tvLink);
        TextView dayTextView = (TextView) convertView.findViewById(R.id.iconPhrase_day);
        TextView nightTextView = (TextView) convertView.findViewById(R.id.iconPhrase_night);
        ImageView dayIcon = (ImageView) convertView.findViewById(R.id.icon_day);
        ImageView nightIcon = (ImageView) convertView.findViewById(R.id.icon_night);

        assert weather != null;

        int iconDay = Integer.parseInt(weather.getD_icon());
        Drawable day =context.getResources().getDrawable(weatherIcons.getIcon(iconDay));
        dayIcon.setImageDrawable(day);

        int iconNight = Integer.parseInt(weather.getN_icon());
        Drawable night =context.getResources().getDrawable(weatherIcons.getIcon(iconNight));
        nightIcon.setImageDrawable(night);

        double minimumTemperature = templateFormats.convertToCelsius(Double.parseDouble(weather.getMinTemp()));
        double maximumTemperature = templateFormats.convertToCelsius(Double.parseDouble(weather.getMaxTemp()));
        minTextView.setText(String.valueOf(minimumTemperature));
        maxTextView.setText(String.valueOf(maximumTemperature));

        String date = templateFormats.convertDate(weather.getDate());
        dateTextView.setText(date);
        linkTextView.setText(weather.getLink());
        dayTextView.setText(weather.getD_iconPhrase());
        nightTextView.setText(weather.getN_iconPhrase());

        return convertView;
    }
}
