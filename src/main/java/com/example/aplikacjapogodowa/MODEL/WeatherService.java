package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherService {
    private final OpenWeatherMapsClientForecast weatherClient;
    public WeatherService(OpenWeatherMapsClientForecast weatherClient ){
        this.weatherClient=weatherClient;
    }
    public Weather getWeather(String cityname, String countryName) throws IOException {
        return weatherClient.getWeather(cityname, countryName);
    }
    public ArrayList<WeatherForecast> getForecastWeather(String cityName, String countryName) throws IOException {

        return weatherClient.getWeatherForcast(cityName,countryName);
    }




}
