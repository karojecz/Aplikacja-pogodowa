package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;

import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Coord;
import com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent.Root;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neovisionaries.i18n.CountryCode;
import org.apache.commons.lang3.text.WordUtils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


public class OpenWeatherMapsClientCurrent {

    public Coord getCoord(String cityName, String countryName) throws IOException {


        String coutryUperCase= WordUtils.capitalizeFully(countryName);




        String countryCode= CountryCode.findByName(coutryUperCase).get(0).name();
        String APIkey = Config.getAPIkey2();
        URL endpointTEST = new URL("http://api.openweathermap.org");
        URL url = new URL(endpointTEST, "/data/2.5/weather?q=" + cityName + "," + countryCode + "&APPID=" + APIkey + "&units=metric");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);

            return root.coord;
        } catch (MalformedURLException | ConnectException | JsonMappingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}







