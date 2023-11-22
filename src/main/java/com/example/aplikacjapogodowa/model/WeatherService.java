package com.example.aplikacjapogodowa.model;

import com.example.aplikacjapogodowa.model.client.WeatherClient;

import java.io.IOException;

public class WeatherService {
    private final WeatherClient openWeatherMapsClientForecast;
    public WeatherService(WeatherClient weatherClient ){
        this.openWeatherMapsClientForecast =weatherClient;
    }
    public WeatherForecast getWeatherForecast(String cityName, String countryName) throws IOException {
        return openWeatherMapsClientForecast.getWeatherForecast(cityName,countryName);
    }



}
