package com.example.aplikacjapogodowa.MODEL.client;

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
    public Weather getWeather(String cityname) {
       return null;
    }
    public void testApi() throws IOException {
        URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=a726ecc4c3e0e1118a0210537040f19f");
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







