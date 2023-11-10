package com.example.aplikacjapogodowa.model.client;


import com.example.aplikacjapogodowa.model.WeatherForecast;

public interface WeatherClient {


    WeatherForecast getWeatherForecast2(String cityName, String countryName);
}
