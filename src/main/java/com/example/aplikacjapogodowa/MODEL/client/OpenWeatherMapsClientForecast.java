package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.RootForecast;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class OpenWeatherMapsClientForecast implements WeatherClient{

    @Override
    public Weather getWeather(String cityName, String countryName) throws IOException {

        OpenWeatherMapsClientCurrent openWeatherMapsClientCurrent=new OpenWeatherMapsClientCurrent();
        Weather weather=openWeatherMapsClientCurrent.getWeather(cityName,countryName);
        double lon=getLonForCity(weather);
        double lat=getLatForCity(weather);


        String APIkey= Config.getAPIkey();
        URL endpointTEST=new URL("http://api.openweathermap.org");
        URL url=new URL(endpointTEST,"/data/3.0/onecall?lat="+lat+"&lon=-"+lon+"&appid="+APIkey+"&units=metric");

        InputStreamReader reader=new InputStreamReader(url.openStream());


        try {
            ObjectMapper om = new ObjectMapper();
            System.out.println(om.readTree(url));
            RootForecast root = om.readValue(reader, RootForecast.class);
            System.out.println(root);
            System.out.println("first day: "+root.daily.get(0));
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
            System.out.println("url check "+om.readTree(url));
            RootForecast root = om.readValue(reader, RootForecast.class);
            System.out.println(root);
            System.out.println("first day: "+root.daily.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private double getLatForCity(Weather weather)  {



        return weather.getLat();

    }
    private double getLonForCity(Weather weather){
        return weather.getLon();
    }
}
