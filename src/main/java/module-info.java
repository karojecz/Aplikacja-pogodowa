module com.example.aplikacjapogodowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.net.http;
    requires gson;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires jtransc.annotations;
    requires nv.i18n;
    requires org.apache.commons.lang3;





    opens com.example.aplikacjapogodowa to javafx.fxml;
    opens com.example.aplikacjapogodowa.view;
    opens com.example.aplikacjapogodowa.controller;
    opens com.example.aplikacjapogodowa.model;
    opens com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesCurrent;
    opens  com.example.aplikacjapogodowa.model.openWeatherMapsFeaturesForecast;
    opens com.example.aplikacjapogodowa.model.geocodingFeatures;
    exports com.example.aplikacjapogodowa;
    opens com.example.aplikacjapogodowa.model.client;
}