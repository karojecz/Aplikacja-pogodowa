package com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast;

public class Minutely {
    public int dt;
    public int precipitation;

    @Override
    public String toString() {
        return "Minutely{" +
                "dt=" + dt +
                ", precipitation=" + precipitation +
                '}';
    }
}
