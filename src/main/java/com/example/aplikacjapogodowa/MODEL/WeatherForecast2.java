package com.example.aplikacjapogodowa.MODEL;

import java.util.Collection;
import java.util.Objects;

public class WeatherForecast2 {
    private final String cityName;
    private final Collection<Weather2> weather2s;

    public WeatherForecast2(String cityName, Collection<Weather2> weather2s) {
        this.cityName = cityName;
        this.weather2s = weather2s;
    }

    public String getCityName() {
        return cityName;
    }

    public Collection<Weather2> getWeather2s() {
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
