package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;

public class WeatherService {
    private final WeatherClient weatherClient;
    public WeatherService(WeatherClient weatherClient){
        this.weatherClient=weatherClient;
    }
    public Weather getWeather(String cityname){
        return weatherClient.getWeather(cityname);
    }


}
