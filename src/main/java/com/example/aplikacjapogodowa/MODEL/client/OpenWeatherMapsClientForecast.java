package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class OpenWeatherMapsClientForecast implements WeatherClient{

    @Override
    public Weather getWeather(String cityname, String countryName) throws IOException {
        return null;
    }
    public void testForecastAPI() throws IOException {
        String city="czaplinek";
        String APIkey= Config.getAPIkey2();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        String countryCode="pl";
        URL url=new URL("https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&appid=a726ecc4c3e0e1118a0210537040f19f");
        InputStreamReader reader=new InputStreamReader(url.openStream());
        System.out.println(reader);

        try {
            ObjectMapper om = new ObjectMapper();
            System.out.println(om.readTree(url));
          //  Root root = om.readValue(reader, Root.class);
            //System.out.println(root);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
