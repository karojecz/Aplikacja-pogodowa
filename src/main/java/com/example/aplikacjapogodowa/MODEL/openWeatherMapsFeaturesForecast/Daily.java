package com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast;

import java.util.ArrayList;

public class Daily {
    public int dt;
    public int sunrise;
    public int sunset;
    public int moonrise;
    public int moonset;
    public double moon_phase;
    public String summary;
    public Temp temp;
    public FeelsLike feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double wind_speed;
    public int wind_deg;
    public double wind_gust;
    public ArrayList<Weather> weather;
    public int clouds;
    public double pop;
    public double uvi;
    public double rain;

    @Override
    public String toString() {
        return "Daily{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", moonrise=" + moonrise +
                ", moonset=" + moonset +
                ", moon_phase=" + moon_phase +
                ", summary='" + summary + '\'' +
                ", temp=" + temp +
                ", feels_like=" + feels_like +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dew_point=" + dew_point +
                ", wind_speed=" + wind_speed +
                ", wind_deg=" + wind_deg +
                ", wind_gust=" + wind_gust +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", pop=" + pop +
                ", uvi=" + uvi +
                ", rain=" + rain +
                '}';
    }
}
