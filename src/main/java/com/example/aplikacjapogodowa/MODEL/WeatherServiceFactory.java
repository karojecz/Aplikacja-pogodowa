package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.ExampleWeatherClient;
import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClient;
import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;

public class WeatherServiceFactory {

    public static WeatherService createWeatherService() {


        return new WeatherService(createWeatherClient());
    }

    private static WeatherClient createWeatherClient() {
        return new OpenWeatherMapsClient();
    }
}
