package com.example.aplikacjapogodowa.MODEL;

import java.time.LocalDate;

public class Weather {


    String cityName;
    double tempInCelcius;
    LocalDate localDate;
    double rain;
    double windSpeed;

    public Weather(String cityname, double tempInCelcius, double rain, double wind ) {
        this.cityName=cityname;
        this.tempInCelcius=tempInCelcius;
        this.rain=rain;
        this.windSpeed=wind;



    }

    public double getTempInCelcius() {
        return this.tempInCelcius;
    }

    public String getCityName() {
        return cityName;
    }

    public double getRain() {

        return rain;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", tempInCelcius=" + tempInCelcius +
                ", localDate=" + localDate +
                ", rain=" + rain +
                '}';
    }
}
