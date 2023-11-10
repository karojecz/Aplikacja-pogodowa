package com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesCurrent;

public class Wind{
    public double speed;
    public int deg;
    public double gust;

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
