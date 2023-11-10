package com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesForecast;

public class Temp {
    public double day;
    public double min;
    public double max;
    public double night;
    public double eve;
    public double morn;

    @Override
    public String toString() {
        return "Temp{" +
                "day=" + day +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}
