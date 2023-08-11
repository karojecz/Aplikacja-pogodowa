package com.example.aplikacjapogodowa.CONTROLLER;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherService;
import com.example.aplikacjapogodowa.MODEL.WeatherServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;



    @FXML
    private Button checkWeatherButton;

    @FXML
    private Label temperature;

    @FXML
    private Label teperatureLabel;
    @FXML
    private TextField cityName;

    @FXML
    private TextField countryName;
    @FXML
    private Label wind;
    @FXML
    private Label rain;
    @FXML
    private Label city;
    private WeatherService weatherService;
    public MainViewController(String fxmlName){this.fxmlName=fxmlName;}

    @FXML
    void CheckWeatherAction() throws IOException {

        String cityName=this.cityName.getText();
        String countryName=this.countryName.getText();
        Weather weather=weatherService.getWeather(cityName,countryName);
        displayWeather(weather);
    }


    private void displayWeather(Weather weather) {
        temperature.setVisible(true);
        teperatureLabel.setVisible(true);
        temperature.setText(String.valueOf(weather.getTempInCelcius()));
        rain.setText(String.valueOf(weather.getRain()));
        city.setText(weather.getCityName());
        wind.setText(String.valueOf(weather.getWindSpeed()));
        System.out.println(weather.toString());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService= WeatherServiceFactory.createWeatherService();
        temperature.setVisible(false);
       teperatureLabel.setVisible(false);

    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }
}
