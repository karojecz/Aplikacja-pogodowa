package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherService {
    private final OpenWeatherMapsClientForecast openWeatherMapsClientForecast;
    public WeatherService(OpenWeatherMapsClientForecast weatherClient ){
        this.openWeatherMapsClientForecast =weatherClient;
    }

    public ObservableList<WeatherForecast> getForecastWeather(String cityName, String countryName) throws IOException {

        OpenWeatherMapsClientForecast openWeatherMapsClientForecast=new OpenWeatherMapsClientForecast();
        ArrayList<WeatherForecast> weatherForecasts=openWeatherMapsClientForecast.getWeatherForecast(cityName, countryName);

        ObservableList<WeatherForecast> data =
                FXCollections.observableArrayList(
                       weatherForecasts
                );

        return data;
    }




}
