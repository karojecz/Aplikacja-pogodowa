package com.example.aplikacjapogodowa.MODEL;

import java.time.Instant;
import java.time.LocalDate;

public class Weather {


    String cityName;
    double tempInCelcius;
    LocalDate localDate;
    double rain;
    double windSpeed;
    double lat;
    double lon;

    LocalDate date;


    public Weather(String cityname, double tempInCelcius, double rain, double wind, LocalDate date) {
        this.cityName=cityname;
        this.tempInCelcius=tempInCelcius;
        this.rain=rain;
        this.windSpeed=wind;
        this.date=date;



    }
    public Weather(double tempIncelcius, double rain){
        this.tempInCelcius=tempIncelcius;
        this.rain=rain;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
    public LocalDate getDate(){return date;}


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
