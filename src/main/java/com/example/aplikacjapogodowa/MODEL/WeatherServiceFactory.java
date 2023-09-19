package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientCurrent;
import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;


public class WeatherServiceFactory {

    public static WeatherService createWeatherService() {
        return new WeatherService(createWeatherClient());
    }

    private static OpenWeatherMapsClientForecast createWeatherClient() {
        return new OpenWeatherMapsClientForecast();
    }
}
