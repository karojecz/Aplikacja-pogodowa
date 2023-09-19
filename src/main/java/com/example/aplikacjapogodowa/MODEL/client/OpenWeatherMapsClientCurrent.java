package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;

import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Coord;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Root;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


public class OpenWeatherMapsClientCurrent {

    public Coord getCoord(String cityName, String countrName) throws IOException {
        String APIkey = Config.getAPIkey2();
        URL endpointTEST = new URL("http://api.openweathermap.org");
        URL url = new URL(endpointTEST, "/data/2.5/weather?q=" + cityName + "," + countrName + "&APPID=" + APIkey + "&units=metric");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);

            return root.coord;
        } catch (MalformedURLException | ConnectException | JsonMappingException e) {
            e.printStackTrace();
        }
        return null;
    }


}






