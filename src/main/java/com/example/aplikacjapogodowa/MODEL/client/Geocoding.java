package com.example.aplikacjapogodowa.MODEL.client;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.geocodingFeatures.GeocodingRoot;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.text.WordUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

public class Geocoding {
    public  void geocodingTest(String cityName, String countryName) throws IOException {

        try {
            String coutryUperCase= WordUtils.capitalizeFully(countryName);

            //String outputCountryName= changeToEnglishName(coutryUperCase);
            String cityName2="Lisewo";
            String countryCode2="UK";



           // String countryCode= CountryCode.findByName(outputCountryName).get(0).name();
            String APIkey = Config.getAPIkey2();
          //  URL endpointTEST = new URL("http://api.openweathermap.org");
          //  URL url = new URL(endpointTEST, "/data/2.5/weather?q=" + cityName + "," + countryCode + "&APPID=" + APIkey + "&units=metric");

            URL url=new URL("http://api.openweathermap.org/geo/1.0/direct?q="+cityName2+"&limit=5&appid="+APIkey);
            InputStreamReader reader = new InputStreamReader(url.openStream());


            ObjectMapper om = new ObjectMapper();

           // Root root = om.readValue(reader, Root.class);
            GeocodingRoot[] root = om.readValue(reader, GeocodingRoot[].class);
            for(int i=0; i<root.length; i++){
                System.out.println(i+" "+root[i]);
            }



        } catch (MalformedURLException | ConnectException | JsonMappingException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
