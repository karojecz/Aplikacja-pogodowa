package com.example.aplikacjapogodowa.MODEL;

import java.time.Instant;
import java.time.LocalDate;

public class Weather<T> {
    T weatherObject;

public Weather(T o){
    weatherObject=o;
}
public T getWeatherObject(){
    return weatherObject;
}

}
