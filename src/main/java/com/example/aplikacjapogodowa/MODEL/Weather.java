package com.example.aplikacjapogodowa.MODEL;

import java.time.LocalDateTime;

public class Weather {
    private final String cityName;
    private final double dayTemp;
    private final int pressure;
    private final double rain;
    private final double wind_speed;
    private final String description;
    private final LocalDateTime localDateTime;


    public Weather(String cityName, double dayTemp, int pressure, double rain, double wind_speed, String description, LocalDateTime localDateTime) {
        this.cityName = cityName;
        this.dayTemp = dayTemp;
        this.pressure = pressure;
        this.rain = rain;
        this.wind_speed = wind_speed;
        this.description = description;
        this.localDateTime = localDateTime;
    }

    public String getCityName() {
        return cityName;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
