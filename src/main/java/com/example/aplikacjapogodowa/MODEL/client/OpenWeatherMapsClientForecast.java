package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.geocodingFeatures.GeocodingRoot;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast.RootForecast;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.text.WordUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;


public class OpenWeatherMapsClientForecast implements WeatherForecastClient{




    public static RootForecast getRoot(String cityName, String countryName) throws IOException {
        try {
            OpenWeatherMapsClientCurrent openWeatherMapsClientCurrent = new OpenWeatherMapsClientCurrent();

            GeocodingRoot geocodingRoot=getGeocordingRoot(cityName);
            double lat=geocodingRoot.lat;
            double lon=geocodingRoot.lon;



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
    private static GeocodingRoot getGeocordingRoot(String cityName){
        try {
            String coutryUperCase= WordUtils.capitalizeFully(cityName);
            String cityName2="London";

            String APIkey = Config.getAPIkey2();

            URL url=new URL("http://api.openweathermap.org/geo/1.0/direct?q="+cityName+"&limit=5&appid="+APIkey);
            InputStreamReader reader = new InputStreamReader(url.openStream());

            ObjectMapper om = new ObjectMapper();
            GeocodingRoot[] root = om.readValue(reader, GeocodingRoot[].class);
            System.out.println(root[0]);
            return root[0];
        } catch (MalformedURLException | ConnectException | JsonMappingException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

}
