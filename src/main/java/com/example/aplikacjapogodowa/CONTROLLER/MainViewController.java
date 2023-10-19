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
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;

    @FXML
    private TableView<Weather> TableDestination;

    @FXML
    private TableView<Weather> TableOrigin;
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
    private TableColumn<Weather, LocalDateTime> dateDestination;

    @FXML
    private TableColumn<Weather, LocalDateTime> dateOrigin;

    @FXML
    private TableColumn<Weather, String> descriptionDestination;
    @FXML
    private TableColumn<Weather, String> descriptionOrigin;

    @FXML
    private TableColumn<Weather, Integer> pressureDestination;

    @FXML
    private TableColumn<Weather, Integer> pressureOrigin;

    @FXML
    private TableColumn<Weather, Double> rainDestination;

    @FXML
    private TableColumn<Weather, Double> rainOrigin;

    @FXML
    private TableColumn<Weather, Double> temperatureDestination;

    @FXML
    private TableColumn<Weather, Double> temperatureOrigin;

    @FXML
    private TableColumn<Weather, Double> windSpeedDestination;

    @FXML
    private TableColumn<Weather, Double> windspeedOrigin;


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



                    WeatherForecast weatherForecast2=weatherService.getWeatherForecast2(cityName,countryName);
                    WeatherForecast weatherForecast21=weatherService.getWeatherForecast2(cityName,countryName);
                    Collection<Weather> weather2s=weatherForecast2.getWeather2s();

                    WeatherForecast weatherForecast2DEStination=weatherService.getWeatherForecast2(cityNameDestination,countryNameDestinatiom);
                    Collection<Weather> weather2sDEstination=weatherForecast2DEStination.getWeather2s();

                    ObservableList<Weather> list= FXCollections.observableList(new ArrayList<>(weather2s));
                    ObservableList<Weather> listDestination=FXCollections.observableList(new ArrayList<>(weather2sDEstination));







                    displayWeather(list, listDestination);
                } catch (Exception e) {
                    e.printStackTrace();
                    textFieldErrorLabel.setText("city name or country code are wrong");
                    textFieldErrorLabel.setVisible(true);
                }
            }



    }

    private void displayWeather(ObservableList<Weather> weatherOrigin, ObservableList<Weather> weatherDestination) {


        temperatureDestination.setCellValueFactory(new PropertyValueFactory<Weather, Double>("dayTemp"));
        dateDestination.setCellValueFactory(new PropertyValueFactory<Weather, LocalDateTime>("localDateTime"));
        pressureDestination.setCellValueFactory(new PropertyValueFactory<Weather, Integer>("pressure"));
        rainDestination.setCellValueFactory(new PropertyValueFactory<Weather, Double>("rain"));
        windSpeedDestination.setCellValueFactory(new PropertyValueFactory<Weather, Double>("wind_speed"));
        descriptionDestination.setCellValueFactory(new PropertyValueFactory<Weather, String>("description"));

        temperatureOrigin.setCellValueFactory(new PropertyValueFactory<Weather, Double>("dayTemp"));
        dateOrigin.setCellValueFactory(new PropertyValueFactory<Weather, LocalDateTime>("localDateTime"));
        pressureOrigin.setCellValueFactory(new PropertyValueFactory<Weather, Integer>("pressure"));
        rainOrigin.setCellValueFactory(new PropertyValueFactory<Weather, Double>("rain"));
        windspeedOrigin.setCellValueFactory(new PropertyValueFactory<Weather, Double>("wind_speed"));
        descriptionOrigin.setCellValueFactory(new PropertyValueFactory<Weather, String>("description"));


        TableDestination.setItems(weatherOrigin);
        TableOrigin.setItems(weatherDestination);



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
