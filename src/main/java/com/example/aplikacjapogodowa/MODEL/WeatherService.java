package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;

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
