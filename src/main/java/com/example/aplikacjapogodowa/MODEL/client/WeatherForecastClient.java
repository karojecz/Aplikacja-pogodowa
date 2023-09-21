package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherForecast;

import java.io.IOException;
import java.util.ArrayList;

public interface WeatherForecastClient {
    Weather getWeatherForecast(String cityName, String countryName) throws IOException;
}
