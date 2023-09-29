package com.example.aplikacjapogodowa.MODEL.geocodingFeatures;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    public String name;
    public LocalNames local_names;
    public double lat;
    public double lon;
    public String country;
    public String state;

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", local_names=" + local_names +
                ", lat=" + lat +
                ", lon=" + lon +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
