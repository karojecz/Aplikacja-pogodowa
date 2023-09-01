package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.*;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.Weather;

import java.util.ArrayList;

public class WeatherForecast {

    private int dt;
    private int sunrise;
    private int sunset;
    private int moonrise;
    private int moonset;
    private double moon_phase;
    private String summary;
    private Temp temp;
    private FeelsLike feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private ArrayList<Weather> weather;
    private int clouds;
    private double pop;
    private double uvi;
    private double rain;

    private Daily daily;



    public WeatherForecast(int dt, int sunrise, int sunset, int moonrise, int moonset, double moon_phase, String summary, Temp temp, FeelsLike feels_like, int pressure, int humidity, double dew_point, double wind_speed, int wind_deg, double wind_gust, ArrayList<Weather> weather, int clouds, double pop, double uvi, double rain) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moon_phase = moon_phase;
        this.summary = summary;
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dew_point = dew_point;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.wind_gust = wind_gust;
        this.weather = weather;
        this.clouds = clouds;
        this.pop = pop;
        this.uvi = uvi;
        this.rain = rain;

    }
    public WeatherForecast(int dt, int pressure, double temp){
        this.dt=dt;
        this.pressure=pressure;
        this.temp.day=temp;
    }

    public int getDt() {
        return dt;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public int getMoonrise() {
        return moonrise;
    }

    public int getMoonset() {
        return moonset;
    }

    public double getMoon_phase() {
        return moon_phase;
    }

    public String getSummary() {
        return summary;
    }

    public Temp getTemp() {
        return temp;
    }

    public FeelsLike getFeels_like() {
        return feels_like;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getDew_point() {
        return dew_point;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public int getClouds() {
        return clouds;
    }

    public double getPop() {
        return pop;
    }

    public double getUvi() {
        return uvi;
    }

    public double getRain() {
        return rain;
    }

    public Daily getDaily() {
        return daily;
    }
}
