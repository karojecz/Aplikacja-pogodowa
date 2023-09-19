package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;

import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Coord;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Root;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


public class OpenWeatherMapsClientCurrent  {






    public Weather getWeather(String cityname, String countryName) throws IOException {
        try {
        String city=cityname;
        String APIkey= Config.getAPIkey();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        String countryCode=countryName;
        URL url=new URL(endpointTEST,"/data/2.5/weather?q="+city+","+countryCode+"&appid="+APIkey+"&units=metric");
        InputStreamReader reader=new InputStreamReader(url.openStream());


            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);

            double rain=0;
            double windSpeed=0;
            ZoneId zone = ZoneId.of("America/Edmonton");
           LocalDate localDate= LocalDate.ofEpochDay(root.dt);

            if(root.wind!=null){
                windSpeed=root.wind.speed;
            }
            if(root.rain!=null){
                rain=root.rain._1h;
            }

            return new Weather(cityname,root.main.temp,rain,windSpeed,localDate);
        } catch (Exception e) {
         //   e.printStackTrace();
            System.out.println("openWeatherMapsCurrent getWeather-URL ERROR");
        }

       return null;
    }


    public Coord getCoord(String cityName, String countrName) throws IOException {
        String city=cityName;
        String APIkey= Config.getAPIkey2();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        String countryCode=countrName;
        URL url=new URL(endpointTEST,"/data/2.5/weather?q="+city+","+countryCode+"&APPID="+APIkey+"&units=metric");
        InputStreamReader reader=new InputStreamReader(url.openStream());

        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);

            return root.coord;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }






}







