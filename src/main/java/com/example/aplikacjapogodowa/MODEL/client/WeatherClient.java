package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.MODEL.Weather;

import java.io.IOException;
import java.net.MalformedURLException;

public interface WeatherClient {
    Weather getWeather(String cityname, String countryName) throws IOException;
}
