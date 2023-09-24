package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;

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
import java.util.Locale;


public class OpenWeatherMapsClientCurrent {
    private static String changeToEnglishName(String name){
        String englishName=name;
        Locale outLocale = Locale.forLanguageTag("en_GB");
        Locale inLocale = Locale.forLanguageTag("pl-PL");
        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getDisplayCountry(inLocale).equals(name)) {

                englishName=l.getDisplayCountry(outLocale);
                break;
            }
        }
        return englishName;
    }

    public Coord getCoord(String cityName, String countryName) throws IOException {

        try {
        String coutryUperCase= WordUtils.capitalizeFully(countryName);

        String outputCountryName= changeToEnglishName(coutryUperCase);



        String countryCode= CountryCode.findByName(outputCountryName).get(0).name();
        String APIkey = Config.getAPIkey2();
        URL endpointTEST = new URL("http://api.openweathermap.org");
        URL url = new URL(endpointTEST, "/data/2.5/weather?q=" + cityName + "," + countryCode + "&APPID=" + APIkey + "&units=metric");
        InputStreamReader reader = new InputStreamReader(url.openStream());


            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(reader, Root.class);

            return root.coord;
        } catch (MalformedURLException | ConnectException | JsonMappingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}







