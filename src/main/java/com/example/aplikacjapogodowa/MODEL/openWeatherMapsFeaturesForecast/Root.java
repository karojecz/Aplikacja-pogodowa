package com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast;

import java.util.ArrayList;

public class Root {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public Current current;
    public ArrayList<Minutely> minutely;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;
    public ArrayList<Alert> alerts;
}
