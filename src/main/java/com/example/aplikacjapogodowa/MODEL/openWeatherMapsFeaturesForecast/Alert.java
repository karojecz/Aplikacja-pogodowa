package com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesForecast;

import java.util.ArrayList;

public class Alert {
    public String sender_name;
    public String event;
    public int start;
    public int end;
    public String description;
    public ArrayList<String> tags;

    @Override
    public String toString() {
        return "Alert{" +
                "sender_name='" + sender_name + '\'' +
                ", event='" + event + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                '}';
    }
}
