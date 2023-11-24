package com.example.aplikacjapogodowa.controller;


import com.example.aplikacjapogodowa.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {

    @FXML
    NestedController originTableController;
    @FXML
    NestedController destinationTableController;
    private final String fxmlName;

    @FXML
    private Button checkWeatherButton;

    @FXML
    private TextField cityName, cityNameDestination, countryName, countryNameDestination;

    @FXML
    private Label originTableName, destinationTableName, textFieldErrorLabel;


    private WeatherService weatherService;

    public MainViewController(String fxmlName) {
        this.fxmlName = fxmlName;
    }

    @FXML
    void CheckWeatherAction() throws IOException {

        String cityName = this.cityName.getText();
        String countryName = this.countryName.getText();

        String cityNameDestination = this.cityNameDestination.getText();
        String countryNameDestination = this.countryNameDestination.getText();



        try {

            originTableName.setVisible(true);
            originTableName.setText("Weather in " + cityName.substring(0, 1).toUpperCase() + cityName.substring(1).toLowerCase());
            textFieldErrorLabel.setVisible(false);
            originTableName.setVisible(true);
            destinationTableName.setText("Weather in " + cityNameDestination.substring(0, 1).toUpperCase() + cityNameDestination.substring(1).toLowerCase());
            destinationTableController.setTableVisible(true);
            originTableController.setTableVisible(true);
            originTableName.setVisible(true);
            destinationTableName.setVisible(true);

            destinationTableController.displayWeather(this.settingWeatherData(cityNameDestination, countryNameDestination));
            originTableController.displayWeather(this.settingWeatherData(cityName, countryName));
        } catch (Exception e) {
            e.printStackTrace();
            textFieldErrorLabel.setText("city name or country code are wrong");
            textFieldErrorLabel.setVisible(true);
            destinationTableController.setTableVisible(false);
            originTableController.setTableVisible(false);
            originTableName.setVisible(false);
            destinationTableName.setVisible(false);
        }


    }

    private ObservableList<Weather> settingWeatherData(String cityName, String countryName) {
        WeatherForecast weatherForecast = null;
        try {
            weatherForecast = weatherService.getWeatherForecast(cityName, countryName);
        } catch (IOException e) {
            textFieldErrorLabel.setVisible(true);
            textFieldErrorLabel.setText("Weather service error");
            throw new RuntimeException(e);

        }
        Collection<Weather> weathers = weatherForecast.getWeathers();
        ObservableList<Weather> list = FXCollections.observableList(new ArrayList<>(weathers));
        return list;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        destinationTableController.setTableVisible(false);
        originTableController.setTableVisible(false);
        weatherService = WeatherServiceFactory.createWeatherService();

        originTableName.setVisible(false);
        destinationTableName.setVisible(false);
        textFieldErrorLabel.setVisible(false);


    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }
}
