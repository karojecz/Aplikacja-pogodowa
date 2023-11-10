package com.example.aplikacjapogodowa.model;

import com.example.aplikacjapogodowa.model.client.WeatherClient;

import java.io.IOException;

public class WeatherService {
    private final WeatherClient openWeatherMapsClientForecast;
    public WeatherService(WeatherClient weatherClient ){
        this.openWeatherMapsClientForecast =weatherClient;
    }
    public WeatherForecast getWeatherForecast2(String cityName, String countryName) throws IOException {
        return openWeatherMapsClientForecast.getWeatherForecast2(cityName,countryName);
    }



}
