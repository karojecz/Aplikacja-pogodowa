package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;

import com.example.aplikacjapogodowa.MODEL.client.WeatherClient;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeatures.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpRequest;
import java.util.Scanner;


import com.fasterxml.jackson.databind.ObjectMapper;


public class OpenWeatherMapsClient implements WeatherClient {

    @Override
    public Weather getWeather(String cityname, String countryName) throws IOException {

        String city=cityname;
        String APIkey= Config.getAPIkey();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        String countryCode=countryName;
        URL url=new URL(endpointTEST,"/data/2.5/weather?q="+city+","+countryCode+"&appid="+APIkey+"&units=metric");
        InputStreamReader reader=new InputStreamReader(url.openStream());

        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);
            System.out.println(root);
            return new Weather(cityname,root.main.temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

       return null;
    }
    public void testApi() throws IOException {
        String city="czaplinek";
        String APIkey= Config.getAPIkey2();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        String countryCode="pl";
        URL url=new URL(endpointTEST,"/data/2.5/weather?q="+city+","+countryCode+"&APPID="+APIkey+"&units=metric");
        InputStreamReader reader=new InputStreamReader(url.openStream());

        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);
            System.out.println(root);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}







