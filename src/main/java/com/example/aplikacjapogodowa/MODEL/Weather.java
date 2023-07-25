package com.example.aplikacjapogodowa.MODEL;

import java.time.LocalDate;

public class Weather {


    String cityName;
    double tempInCelcius;
    LocalDate localDate;

    public Weather(String cityname, double tempInCelcius, LocalDate localDate) {
        this.cityName=cityname;
        this.tempInCelcius=tempInCelcius;
        this.localDate=localDate;

    }

    public String getTempInCelcius() {
        return "10 stopni";
    }



}
