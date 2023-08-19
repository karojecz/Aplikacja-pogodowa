package com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast;

import java.util.ArrayList;

public class Current {
    public int dt;
    public int sunrise;
    public int sunset;
    public double temp;
    public double feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double uvi;
    public int clouds;
    public int visibility;
    public double wind_speed;
    public int wind_deg;
    public double wind_gust;
    public ArrayList<Weather> weather;
    public double rain;

    @Override
    public String toString() {
        return "Current{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", temp=" + temp +
                ", feels_like=" + feels_like +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dew_point=" + dew_point +
                ", uvi=" + uvi +
                ", clouds=" + clouds +
                ", visibility=" + visibility +
                ", wind_speed=" + wind_speed +
                ", wind_deg=" + wind_deg +
                ", wind_gust=" + wind_gust +
                ", weather=" + weather +
                '}';
    }
}
