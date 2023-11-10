package com.example.aplikacjapogodowa.model;


import com.example.aplikacjapogodowa.model.client.OpenWeatherMapsClientForecast;
import com.example.aplikacjapogodowa.model.client.WeatherClient;


public class WeatherServiceFactory {

    public static WeatherService createWeatherService() {
        return new WeatherService(createWeatherClient());
    }

    private static WeatherClient createWeatherClient() {
        return new OpenWeatherMapsClientForecast();
    }
}
