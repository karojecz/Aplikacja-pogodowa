package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherCurrent;
import com.example.aplikacjapogodowa.MODEL.WeatherForecast;
import com.example.aplikacjapogodowa.MODEL.WeatherService;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Coord;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.Daily;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.RootForecast;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class OpenWeatherMapsClientForecast implements WeatherForecastClient{


    public static RootForecast getRoot(String cityName, String countryName) throws IOException {
        try {
            OpenWeatherMapsClientCurrent openWeatherMapsClientCurrent = new OpenWeatherMapsClientCurrent();

            Coord coord= openWeatherMapsClientCurrent.getCoord(cityName,countryName);
            String lon = String.valueOf(coord.lon);
            String lat = String.valueOf(coord.lat);


            String APIkey = Config.getAPIkey();
            URL endpointTEST = new URL("http://api.openweathermap.org");
            URL url = new URL(endpointTEST, "/data/3.0/onecall?lat=" + lat + "&lon=" + lon + "&appid=" + APIkey + "&units=metric");

            InputStreamReader reader = new InputStreamReader(url.openStream());


            ObjectMapper om = new ObjectMapper();


            RootForecast root = om.readValue(reader, RootForecast.class);

            return root;


        } catch (MalformedURLException e){
            e.printStackTrace();
        }catch (ConnectException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public Weather<RootForecast> getWeatherForecast(String cityName, String countryName) throws IOException {
        RootForecast rootForecast=getRoot(cityName,countryName);
        Weather weather=new Weather<>(rootForecast);
        return weather;

    }
}
