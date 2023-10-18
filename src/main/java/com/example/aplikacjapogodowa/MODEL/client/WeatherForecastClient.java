package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherForecast2;

import java.io.IOException;

public interface WeatherForecastClient {
    Weather getWeatherForecast(String cityName, String countryName) throws IOException;

    WeatherForecast2 getWeatherForecast2(String cityName, String countryName);
}
