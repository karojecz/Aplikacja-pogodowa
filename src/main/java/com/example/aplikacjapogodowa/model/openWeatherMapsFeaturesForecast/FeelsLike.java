package com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesForecast;

public class FeelsLike {
    public double day;
    public double night;
    public double eve;
    public double morn;

    @Override
    public String toString() {
        return "FeelsLike{" +
                "day=" + day +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}
