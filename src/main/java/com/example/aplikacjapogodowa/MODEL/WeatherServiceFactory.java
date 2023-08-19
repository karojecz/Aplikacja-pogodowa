package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientCurrent;
import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;

public class WeatherServiceFactory {

    public static WeatherService createWeatherService() {


        return new WeatherService(createWeatherClient());
    }

    private static WeatherClient createWeatherClient() {
        return new OpenWeatherMapsClientForecast();
    }
}
