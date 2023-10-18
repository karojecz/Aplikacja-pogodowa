package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.Daily;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.RootForecast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherService {
    private final OpenWeatherMapsClientForecast openWeatherMapsClientForecast;
    public WeatherService(OpenWeatherMapsClientForecast weatherClient ){
        this.openWeatherMapsClientForecast =weatherClient;
    }
    public WeatherForecast2 getWeatherForecast2(String cityName, String countryName) throws IOException {
        return openWeatherMapsClientForecast.getWeatherForecast2(cityName,countryName);
    }

    public ObservableList<WeatherForecast> getForecastWeather(String cityName, String countryName) throws IOException {


        Weather weather=openWeatherMapsClientForecast.getWeatherForecast(cityName,countryName);
        RootForecast rootForecast=(RootForecast) weather.getWeatherObject();

        ArrayList<Daily> dailies=rootForecast.daily;
        ArrayList<WeatherForecast> weatherForecasts=new ArrayList<>();
        for(int i=0; i<rootForecast.daily.size(); i++){
            WeatherForecast weatherForecast=new WeatherForecast(
                    rootForecast.daily.get(i).dt,
                    rootForecast.daily.get(i).sunrise,
                    rootForecast.daily.get(i).sunset,
                    rootForecast.daily.get(i).moonrise,
                    rootForecast.daily.get(i).moonset,
                    rootForecast.daily.get(i).moon_phase,
                    rootForecast.daily.get(i).summary,
                    rootForecast.daily.get(i).temp,
                    rootForecast.daily.get(i).feels_like,
                    rootForecast.daily.get(i).pressure,
                    rootForecast.daily.get(i).humidity,
                    rootForecast.daily.get(i).dew_point,
                    rootForecast.daily.get(i).wind_speed,
                    rootForecast.daily.get(i).wind_deg,
                    rootForecast.daily.get(i).wind_gust,
                    rootForecast.daily.get(i).weather,
                    rootForecast.daily.get(i).clouds,
                    rootForecast.daily.get(i).pop,
                    rootForecast.daily.get(i).uvi,
                    rootForecast.daily.get(i).rain

            );
            weatherForecasts.add(weatherForecast);


        }
        ObservableList<WeatherForecast> data =
                FXCollections.observableArrayList(
                       weatherForecasts
                );

        return data;
    }

}
