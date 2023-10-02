package com.example.aplikacjapogodowa.MODEL;

public class Weather2 {
    private final double dayTemp;
    private final int pressure;
    private final double rain;
    private final double wind_speed;
    private final String description;


    public Weather2(double dayTemp, int pressure, double rain, double wind_speed, String description) {
        this.dayTemp = dayTemp;
        this.pressure = pressure;
        this.rain = rain;
        this.wind_speed = wind_speed;
        this.description = description;
    }

    public double getDayTemp() {
        return dayTemp;
    }

    public int getPressure() {
        return pressure;
    }

    public double getRain() {
        return rain;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public String getDescription() {
        return description;
    }
}
