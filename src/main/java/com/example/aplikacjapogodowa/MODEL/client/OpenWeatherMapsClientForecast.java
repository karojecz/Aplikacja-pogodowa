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
            System.out.println(om);

            RootForecast root = om.readValue(reader, RootForecast.class);
            System.out.println(root);
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
    public ArrayList<WeatherForecast> getWeatherForecast(String cityName, String countryName) throws IOException {
        RootForecast rootForecast=getRoot(cityName,countryName);
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

        return weatherForecasts;
    }
}
