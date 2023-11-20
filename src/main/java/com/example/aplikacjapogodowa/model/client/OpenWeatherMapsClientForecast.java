package com.example.aplikacjapogodowa.model.client;

import com.example.aplikacjapogodowa.Config;

import com.example.aplikacjapogodowa.model.Weather;
import com.example.aplikacjapogodowa.model.WeatherForecast;
import com.example.aplikacjapogodowa.model.geocodingFeatures.GeocodingRoot;
import com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesForecast.Daily;
import com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesForecast.RootForecast;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neovisionaries.i18n.CountryCode;
import org.apache.commons.lang3.text.WordUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;


public class OpenWeatherMapsClientForecast implements WeatherClient {


    public static LocalDateTime getLocalDateTime(int dt) {
        Instant instant = Instant.ofEpochSecond( dt );
        LocalDateTime localDateTime =LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime;
    }
    @Override
    public WeatherForecast getWeatherForecast2(String cityName, String countryName){
        RootForecast rootForecast= null;
        try {
            rootForecast = getRoot(cityName,countryName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Daily> weatherForecastForFiveDays=getDailyWeatherArray(rootForecast);
        Weather weather2;
        Collection<Weather> weather2s=new ArrayList<>();

        for(Daily daily : weatherForecastForFiveDays){
            weather2=new Weather(cityName, daily.temp.day,daily.pressure,daily.rain,daily.wind_speed,daily.weather.get(0).description,getLocalDateTime(daily.dt));

            weather2s.add(weather2);
        }

        return new WeatherForecast(cityName,weather2s);
    }
    private static ArrayList<Daily> getDailyWeatherArray(RootForecast rootForecast){
        return rootForecast.daily;
    }




    public static RootForecast getRoot(String cityName, String countryName) throws IOException {
        try {


            GeocodingRoot geocodingRoot=getGeocordingRoot(cityName,countryName);
            double lat=geocodingRoot.lat;
            double lon=geocodingRoot.lon;

            String APIkey = Config.getAPIkey();
            URL endpointTEST = new URL("http://api.openweathermap.org");
            URL url = new URL(endpointTEST, "/data/3.0/onecall?lat=" + lat + "&lon=" + lon + "&appid=" + APIkey + "&units=metric");

            InputStreamReader reader = new InputStreamReader(url.openStream());
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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


    private static GeocodingRoot getGeocordingRoot(String cityName, String countryName){
        try {
            String APIkey = Config.getAPIkey2();

            URL url=new URL("http://api.openweathermap.org/geo/1.0/direct?q="+cityName+"&limit=5&appid="+APIkey);
            InputStreamReader reader = new InputStreamReader(url.openStream());

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            GeocodingRoot[] root = om.readValue(reader, GeocodingRoot[].class);

            String countryCode=changeToCountryCode(countryName);


            for(GeocodingRoot geocodingRoot:root){

                if(countryCode.equals(geocodingRoot.country)){

                    return geocodingRoot;
                }

            }
        } catch (MalformedURLException | ConnectException | JsonMappingException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;

    }
    private static String changeToCountryCode(String name){
        String englishName= WordUtils.capitalizeFully(name);

        Locale outLocale = Locale.forLanguageTag("en_GB");
        Locale inLocale = Locale.forLanguageTag("pl-PL");
        String countryCode="";
        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getDisplayCountry(inLocale).equals(englishName)) {

                englishName=l.getDisplayCountry(outLocale);
                System.out.println("english name+code: "+englishName+"  "+l.getCountry());
                countryCode=l.getCountry();


                break;
            }
        }
        return countryCode;

    }
    private static String changeToEnglishName(String name){
        String englishName= WordUtils.capitalizeFully(name);

        Locale outLocale = Locale.forLanguageTag("en_GB");
        Locale inLocale = Locale.forLanguageTag("pl-PL");
        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getDisplayCountry(inLocale).equals(englishName)) {

                englishName=l.getDisplayCountry(outLocale);
                System.out.println("english name+code: "+englishName+"  "+l.getCountry());


                break;
            }
        }
        return englishName;
    }




}
