package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;

import java.io.IOException;

public class WeatherService {
    private final WeatherClient weatherClient;
    public WeatherService(WeatherClient weatherClient){
        this.weatherClient=weatherClient;
    }
    public Weather getWeather(String cityname, String countryName) throws IOException {
        return weatherClient.getWeather(cityname, countryName);
    }


}
