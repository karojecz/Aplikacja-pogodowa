package com.example.aplikacjapogodowa.MODEL.client;


import com.example.aplikacjapogodowa.MODEL.WeatherForecast;

public interface WeatherClient {


    WeatherForecast getWeatherForecast2(String cityName, String countryName);
}
