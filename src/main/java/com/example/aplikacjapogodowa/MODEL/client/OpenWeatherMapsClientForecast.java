package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherCurrent;
import com.example.aplikacjapogodowa.MODEL.WeatherForecast;
import com.example.aplikacjapogodowa.MODEL.WeatherService;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.Daily;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.RootForecast;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class OpenWeatherMapsClientForecast implements WeatherClient{

    @Override
    public Weather getWeather(String cityName, String countryName) throws IOException {

        OpenWeatherMapsClientCurrent openWeatherMapsClientCurrent=new OpenWeatherMapsClientCurrent();
        Weather weather=openWeatherMapsClientCurrent.getWeather(cityName,countryName);
        String lon=String.valueOf(openWeatherMapsClientCurrent.getCoord(cityName,countryName).lon);
        String lat=String.valueOf(openWeatherMapsClientCurrent.getCoord(cityName,countryName).lat);


        String APIkey= Config.getAPIkey();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        URL url=new URL(endpointTEST,"/data/3.0/onecall?lat="+lat+"&lon="+lon+"&appid="+APIkey+"&units=metric");

        InputStreamReader reader=new InputStreamReader(url.openStream());


        try {
            ObjectMapper om = new ObjectMapper();

            RootForecast root = om.readValue(reader, RootForecast.class);
            System.out.println(root);

            System.out.println("first day: "+root.daily.get(0));
            System.out.println(root.daily.get(0).temp.day);
            double rain=0;


            int timeInMili =root.daily.get(0).dt;

            Instant instant = Instant.ofEpochMilli((timeInMili*1000L));

            ZoneId zone = ZoneId.of("America/Edmonton");
            LocalDate date = LocalDate.ofInstant(instant, zone);


            return new Weather(cityName,root.daily.get(0).temp.day,root.daily.get(0).rain,root.daily.get(0).wind_speed, date);
        } catch (Exception e) {
            e.printStackTrace();
        }





        return null;
    }
    public void testForecastAPI() throws IOException {

        OpenWeatherMapsClientCurrent openWeatherMapsClientCurrent=new OpenWeatherMapsClientCurrent();
        String ciytyName="london";
        String countryName="uk";

        String lon=String.valueOf(openWeatherMapsClientCurrent.getCoord(ciytyName,countryName).lon);
        String lat=String.valueOf(openWeatherMapsClientCurrent.getCoord(ciytyName,countryName).lat);


        String APIkey= Config.getAPIkey();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        URL url=new URL(endpointTEST,"/data/3.0/onecall?lat="+lat+"&lon="+lon+"&appid="+APIkey+"&units=metric");

        InputStreamReader reader=new InputStreamReader(url.openStream());


        try {
            ObjectMapper om = new ObjectMapper();
          //  System.out.println("url check "+om.readTree(url));
            RootForecast root = om.readValue(reader, RootForecast.class);
          //  System.out.println(root);
          //  System.out.println("first day: "+root.daily.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public ArrayList<WeatherForecast> getWeatherForcast(String cityName, String countryName) throws IOException {
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

    public static RootForecast getRoot(String cityName, String countryName) throws IOException {
        OpenWeatherMapsClientCurrent openWeatherMapsClientCurrent=new OpenWeatherMapsClientCurrent();
        Weather weather=openWeatherMapsClientCurrent.getWeather(cityName,countryName);
        String lon=String.valueOf(openWeatherMapsClientCurrent.getCoord(cityName,countryName).lon);
        String lat=String.valueOf(openWeatherMapsClientCurrent.getCoord(cityName,countryName).lat);


        String APIkey= Config.getAPIkey();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        URL url=new URL(endpointTEST,"/data/3.0/onecall?lat="+lat+"&lon="+lon+"&appid="+APIkey+"&units=metric");

        InputStreamReader reader=new InputStreamReader(url.openStream());


        try {
            ObjectMapper om = new ObjectMapper();

            RootForecast root = om.readValue(reader, RootForecast.class);
            System.out.println(root);
            return root;




        } catch (Exception e) {
            e.printStackTrace();
        }





        return null;
    }
}
