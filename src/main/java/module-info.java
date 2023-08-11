module com.example.aplikacjapogodowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.net.http;
    requires gson;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;





    opens com.example.aplikacjapogodowa to javafx.fxml;
    opens com.example.aplikacjapogodowa.VIEW;
    opens com.example.aplikacjapogodowa.CONTROLLER;
    opens com.example.aplikacjapogodowa.MODEL;
    opens com.example.aplikacjapogodowa.MODEL.openWeatherMapsFeaturesCurrent;
    exports com.example.aplikacjapogodowa;
}