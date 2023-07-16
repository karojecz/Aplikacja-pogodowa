package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.MODEL.Weather;

import java.time.LocalDate;

public class ExampleWeatherClient implements WeatherClient{
    @Override
    public Weather getWeather(String cityname) {
        return new Weather(cityname,10., LocalDate.now());
    }
}
