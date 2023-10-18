package com.example.aplikacjapogodowa.CONTROLLER;


import com.example.aplikacjapogodowa.MODEL.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;

    @FXML
    private TableView<Weather2> TableDestination;

    @FXML
    private TableView<Weather2> TableOrigin;
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
    private TableColumn<Weather2, LocalDateTime> dateDestination;

    @FXML
    private TableColumn<Weather2, LocalDateTime> dateOrigin;

    @FXML
    private TableColumn<Weather2, String> descriptionDestination;
    @FXML
    private TableColumn<Weather2, String> descriptionOrigin;

    @FXML
    private TableColumn<Weather2, Integer> pressureDestination;

    @FXML
    private TableColumn<Weather2, Integer> pressureOrigin;

    @FXML
    private TableColumn<Weather2, Double> rainDestination;

    @FXML
    private TableColumn<Weather2, Double> rainOrigin;

    @FXML
    private TableColumn<Weather2, Double> temperatureDestination;

    @FXML
    private TableColumn<Weather2, Double> temperatureOrigin;

    @FXML
    private TableColumn<Weather2, Double> windSpeedDestination;

    @FXML
    private TableColumn<Weather2, Double> windspeedOrigin;


    private WeatherService weatherService;

    public MainViewController(String fxmlName) {
        this.fxmlName = fxmlName;
    }

    @FXML
    void CheckWeatherAction() throws IOException {




            String cityName = this.cityName.getText();
            String countryName = this.countryName.getText();

            String cityNameDestination = this.cityNameDestination.getText();
            String countryNameDestinatiom = this.countryNameDestination.getText();


            if (cityName.isEmpty() || countryName.isEmpty() || cityNameDestination.isEmpty() || countryNameDestinatiom.isEmpty()) {
                textFieldErrorLabel.setText("You need to fill all city and country fileds to get weather");
                textFieldErrorLabel.setVisible(true);
            } else {
                try {
                destinationTableName.setVisible(true);
                destinationTableName.setText("Weather in " + cityNameDestination.substring(0, 1).toUpperCase() + cityNameDestination.substring(1).toLowerCase());
                originTableName.setVisible(true);
                originTableName.setText("Weather in " + cityName.substring(0, 1).toUpperCase() + cityName.substring(1).toLowerCase());
                TableDestination.setVisible(true);
                TableOrigin.setVisible(true);
                textFieldErrorLabel.setVisible(false);

                    //ObservableList<WeatherForecast2> weather = weatherService.getForecastWeather(cityName, countryName);
                   // ObservableList<WeatherForecast2> weaterDestination = weatherService.getForecastWeather(cityNameDestination, countryNameDestinatiom);
                    //weather2****************************
                    WeatherForecast2 weatherForecast2=weatherService.getWeatherForecast2(cityName,countryName);
                    WeatherForecast2 weatherForecast21=weatherService.getWeatherForecast2(cityName,countryName);
                    Collection<Weather2> weather2s=weatherForecast2.getWeather2s();

                    WeatherForecast2 weatherForecast2DEStination=weatherService.getWeatherForecast2(cityNameDestination,countryNameDestinatiom);
                    Collection<Weather2> weather2sDEstination=weatherForecast2DEStination.getWeather2s();

                    ObservableList<Weather2> list= FXCollections.observableList(new ArrayList<>(weather2s));
                    ObservableList<Weather2> listDestination=FXCollections.observableList(new ArrayList<>(weather2sDEstination));







                    displayWeather(list, listDestination);
                } catch (Exception e) {
                    e.printStackTrace();
                    textFieldErrorLabel.setText("city name or country code are wrong");
                    textFieldErrorLabel.setVisible(true);
                }
            }



    }

    private void displayWeather(ObservableList<Weather2> weatherOrigin, ObservableList<Weather2> weatherDestination) {


        temperatureDestination.setCellValueFactory(new PropertyValueFactory<Weather2, Double>("dayTemp"));
        dateDestination.setCellValueFactory(new PropertyValueFactory<Weather2, LocalDateTime>("localDateTime"));
        pressureDestination.setCellValueFactory(new PropertyValueFactory<Weather2, Integer>("pressure"));
        rainDestination.setCellValueFactory(new PropertyValueFactory<Weather2, Double>("rain"));
        windSpeedDestination.setCellValueFactory(new PropertyValueFactory<Weather2, Double>("wind_speed"));
        descriptionDestination.setCellValueFactory(new PropertyValueFactory<Weather2, String>("description"));

        temperatureOrigin.setCellValueFactory(new PropertyValueFactory<Weather2, Double>("dayTemp"));
        dateOrigin.setCellValueFactory(new PropertyValueFactory<Weather2, LocalDateTime>("localDateTime"));
        pressureOrigin.setCellValueFactory(new PropertyValueFactory<Weather2, Integer>("pressure"));
        rainOrigin.setCellValueFactory(new PropertyValueFactory<Weather2, Double>("rain"));
        windspeedOrigin.setCellValueFactory(new PropertyValueFactory<Weather2, Double>("wind_speed"));
        descriptionOrigin.setCellValueFactory(new PropertyValueFactory<Weather2, String>("description"));


        TableDestination.setItems(weatherOrigin);
        TableOrigin.setItems(weatherDestination);

/*
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

 */

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
