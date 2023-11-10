package com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesForecast;

import java.util.ArrayList;


public class RootForecast {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public Current current;
    public ArrayList<Minutely> minutely;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;
    public ArrayList<Alert> alerts;

    @Override
    public String toString() {
        return "RootForecast{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", timezone_offset=" + timezone_offset +
                ", current=" + current +
                ", minutely=" + minutely +
                ", hourly=" + hourly +
                ", daily=" + daily +
                ", alerts=" + alerts +
                '}';
    }
}
