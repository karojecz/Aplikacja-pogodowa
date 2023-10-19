package com.example.aplikacjapogodowa.MODEL;

import java.util.Collection;
import java.util.Objects;

public class WeatherForecast {
    private final String cityName;
    private final Collection<Weather> weather2s;

    public WeatherForecast(String cityName, Collection<Weather> weather2s) {
        this.cityName = cityName;
        this.weather2s = weather2s;
    }

    public String getCityName() {
        return cityName;
    }

    public Collection<Weather> getWeather2s() {
        return weather2s;
    }

    @Override
    public String toString() {
        return "WeatherForecast2{" +
                "cityName='" + cityName + '\'' +
                ", weather2s=" + weather2s +
                '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(cityName, weather2s);
    }
}
