package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.MODEL.Weather;

public interface WeatherClient {
    Weather getWeather(String cityname);
}
