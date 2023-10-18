package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.MODEL.Weather2;

public interface WeatherClient {
    Weather2 getWeather2(String cityName, String countryName);
}
