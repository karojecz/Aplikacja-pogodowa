package com.example.aplikacjapogodowa.CONTROLLER;

import com.example.aplikacjapogodowa.Config;
import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherService;
import com.example.aplikacjapogodowa.MODEL.WeatherServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;
    private Config config=new Config();
    private String APIkey= config.getAPIkey();
    private String url="https://api.openweathermap.org/data/3.0/onecall/timemachine?lat=39.099724&lon=-94.578331&dt=1643803200&appid={"+APIkey+"}";

    @FXML
    private Button checkWeatherButton;

    @FXML
    private Label temperature;

    @FXML
    private Label teperatureLabel;
    private WeatherService weatherService;
    public MainViewController(String fxmlName){this.fxmlName=fxmlName;}

    @FXML
    void CheckWeatherAction() {
        System.out.println("click!!");
        String cityName="Krakow";
        Weather weather=weatherService.getWeather(cityName);
        displayWeather(weather);
    }


    private void displayWeather(Weather weather) {
        temperature.setVisible(true);
        teperatureLabel.setVisible(true);
        temperature.setText(" "+weather.getTempInCelcius());

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
