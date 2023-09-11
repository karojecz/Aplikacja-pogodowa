package com.example.aplikacjapogodowa.CONTROLLER;


import com.example.aplikacjapogodowa.MODEL.WeatherForecast;
import com.example.aplikacjapogodowa.MODEL.WeatherService;
import com.example.aplikacjapogodowa.MODEL.WeatherServiceFactory;
import com.neovisionaries.i18n.CountryCode;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;

    @FXML
    private TableView<WeatherForecast> TableDestination;

    @FXML
    private TableView<WeatherForecast> TableOrigin;
    @FXML
    private TextField cityNameDestination;

    @FXML
    private TextField countryNameDestination;

    @FXML
    private Button checkWeatherButton;

    @FXML
    private TextField cityName;

    @FXML
    private TextField countryName;

    @FXML
    private Label destinationTableName;

    @FXML
    private Label originTableName;

    @FXML
    private Label textFieldErrorLabel;


    @FXML
    private TableColumn<WeatherForecast, LocalDateTime> dateDestination;

    @FXML
    private TableColumn<WeatherForecast, LocalDateTime> dateOrigin;

    @FXML
    private TableColumn<WeatherForecast, String> descriptionDestination;
    @FXML
    private TableColumn<WeatherForecast, String> descriptionOrigin;

    @FXML
    private TableColumn<WeatherForecast, Integer> pressureDestination;

    @FXML
    private TableColumn<WeatherForecast, Integer> pressureOrigin;

    @FXML
    private TableColumn<WeatherForecast, Double> rainDestination;

    @FXML
    private TableColumn<WeatherForecast, Double> rainOrigin;

    @FXML
    private TableColumn<WeatherForecast, Double> temperatureDestination;

    @FXML
    private TableColumn<WeatherForecast, Double> temperatureOrigin;

    @FXML
    private TableColumn<WeatherForecast, Double> windSpeedDestination;

    @FXML
    private TableColumn<WeatherForecast, Double> windspeedOrigin;


    private WeatherService weatherService;

    public MainViewController(String fxmlName) {
        this.fxmlName = fxmlName;
    }

    @FXML
    void CheckWeatherAction() throws IOException {


        try {
           // String code =  CountryCode.findByName("Germany").get(0).name();
            System.out.println(code);
            String cityName = this.cityName.getText();
            String countryName = this.countryName.getText();

            String cityNameDestination = this.cityNameDestination.getText();
            String countryNameDestinatiom = this.countryNameDestination.getText();

            if (cityName.isEmpty() || countryName.isEmpty() || cityNameDestination.isEmpty() || countryNameDestinatiom.isEmpty()) {
                textFieldErrorLabel.setText("You need to fill all city and country fileds to get weather");
                textFieldErrorLabel.setVisible(true);
            } else {

                destinationTableName.setVisible(true);
                destinationTableName.setText("Weather in " + cityNameDestination.substring(0, 1).toUpperCase() + cityNameDestination.substring(1));
                originTableName.setVisible(true);
                originTableName.setText("Weather in " + cityName.substring(0, 1).toUpperCase() + cityName.substring(1));
                TableDestination.setVisible(true);
                TableOrigin.setVisible(true);
                textFieldErrorLabel.setVisible(false);
                try {
                    ObservableList<WeatherForecast> weather = weatherService.getForecastWeather(cityName, countryName);
                    ObservableList<WeatherForecast> weaterDestination = weatherService.getForecastWeather(cityNameDestination, countryNameDestinatiom);
                    displayWeather(weather, weaterDestination);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    textFieldErrorLabel.setText("city name or country code are wrong");
                    textFieldErrorLabel.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayWeather(ObservableList<WeatherForecast> weatherOrigin, ObservableList<WeatherForecast> weatherDestination) {

        temperatureDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("dayTemp"));
        dateDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, LocalDateTime>("localDateTime"));
        pressureDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Integer>("pressure"));
        rainDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("rain"));
        windSpeedDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("wind_speed"));
        descriptionDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, String>("description"));

        temperatureOrigin.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("dayTemp"));
        dateOrigin.setCellValueFactory(new PropertyValueFactory<WeatherForecast, LocalDateTime>("localDateTime"));
        pressureOrigin.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Integer>("pressure"));
        rainOrigin.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("rain"));
        windspeedOrigin.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("wind_speed"));
        descriptionOrigin.setCellValueFactory(new PropertyValueFactory<WeatherForecast, String>("description"));


        TableDestination.setItems(weatherOrigin);
        TableOrigin.setItems(weatherDestination);

    }

    private void displayWeatherFor5days(ArrayList<WeatherForecast> weatherForecasts) {

        // System.out.println(weatherForecasts.get(0).getTemp().day);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();
        destinationTableName.setVisible(false);
        originTableName.setVisible(false);
        TableOrigin.setVisible(false);
        TableDestination.setVisible(false);
        textFieldErrorLabel.setVisible(false);


    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }
}
