package com.example.aplikacjapogodowa.MODEL;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientCurrent;
import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.Daily;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.RootForecast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast.getRoot;

public class WeatherService {
    private final OpenWeatherMapsClientForecast weatherClient;
    public WeatherService(OpenWeatherMapsClientForecast weatherClient ){
        this.weatherClient=weatherClient;
    }
    public Weather getWeather(String cityname, String countryName) throws IOException {
        return weatherClient.getWeather(cityname, countryName);
    }
    public ObservableList<WeatherForecast> getForecastWeather(String cityName, String countryName) throws IOException {

        //RootForecast rootForecast=getRoot(cityName,countryName);
       // ArrayList<Daily> dailies=rootForecast.daily;
        //ArrayList<WeatherForecast> weatherForecasts=new ArrayList<>();
        OpenWeatherMapsClientForecast openWeatherMapsClientForecast=new OpenWeatherMapsClientForecast();
        ArrayList<WeatherForecast> weatherForecasts=openWeatherMapsClientForecast.getWeatherForcast(cityName, countryName);

        /*
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

         */
        ObservableList<WeatherForecast> data =
                FXCollections.observableArrayList(
                       weatherForecasts
                );

        return data;
    }




}
