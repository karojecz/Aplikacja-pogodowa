package com.example.aplikacjapogodowa.model;

import java.util.Collection;
import java.util.Objects;

public class WeatherForecast {
    private final String cityName;
    private final Collection<Weather> weathers;

    public WeatherForecast(String cityName, Collection<Weather> weather2s) {
        this.cityName = cityName;
        this.weathers = weather2s;
    }

    public String getCityName() {
        return cityName;
    }

    public Collection<Weather> getWeathers() {
        return weathers;
    }

    @Override
    public String toString() {
        return "WeatherForecast2{" +
                "cityName='" + cityName + '\'' +
                ", weather2s=" + weathers +
                '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(cityName, weathers);
    }
}
