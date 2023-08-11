package com.example.aplikacjapogodowa.MODEL;

import java.time.LocalDate;

public class Weather {


    String cityName;
    double tempInCelcius;
    LocalDate localDate;
    double rain;

    public Weather(String cityname, double tempInCelcius ) {
        this.cityName=cityname;
        this.tempInCelcius=tempInCelcius;



    }

    public double getTempInCelcius() {
        return this.tempInCelcius;
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
