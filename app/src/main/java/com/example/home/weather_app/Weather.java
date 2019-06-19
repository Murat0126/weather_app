package com.example.home.weather_app;

public class Weather {

    private String date;
    private String minTemp;
    private String maxTemp;
    private String link;
    private String text;
    private String n_iconPhrase;
    private String d_iconPhrase;
    private String d_icon;
    private String n_icon;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getN_iconPhrase() {
        return n_iconPhrase;
    }

    public void seticonPhrase(String n_iconPhrase) {
        this.n_iconPhrase = n_iconPhrase;
    }

    public String getD_iconPhrase() {
        return d_iconPhrase;
    }

    public void set_d_iconPhrase(String d_iconPhrase) {
        this.d_iconPhrase = d_iconPhrase;
    }

    public String getD_icon() {
        return d_icon;
    }

    public void set_d_icon(String d_icon) {
        this.d_icon = d_icon;
    }

    public String getN_icon() {
        return n_icon;
    }

    public void set_n_icon(String n_icon) {
        this.n_icon = n_icon;
    }
}
