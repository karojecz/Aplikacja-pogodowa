package com.example.aplikacjapogodowa.CONTROLLER;


import com.example.aplikacjapogodowa.MODEL.Weather;
import com.example.aplikacjapogodowa.MODEL.WeatherForecast;
import com.example.aplikacjapogodowa.MODEL.WeatherService;
import com.example.aplikacjapogodowa.MODEL.WeatherServiceFactory;
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
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;


    @FXML
    private Button checkWeatherButton;

    @FXML
    private TableColumn<WeatherForecast, LocalDateTime> dateDestination;
    @FXML
    private TableColumn<WeatherForecast, String> descriptionDestination;

    @FXML
    private TableColumn<WeatherForecast, Integer> pressureDestination;

    @FXML
    private TableColumn<WeatherForecast, Double> rainDestination;
    @FXML
    private TableColumn<WeatherForecast, Double> windSpeedDestination;



    @FXML
    private TableView<WeatherForecast> TableDestinationDay1;



    @FXML
    private TextField cityName;

    @FXML
    private TextField countryName;


    @FXML
    private TableColumn<WeatherForecast, Double> temperatureDestination;
    ;


    private WeatherService weatherService;
    public MainViewController(String fxmlName){this.fxmlName=fxmlName;}

    @FXML
    void CheckWeatherAction() throws IOException {

        String cityName=this.cityName.getText();
        String countryName=this.countryName.getText();
        ObservableList<WeatherForecast> weather=weatherService.getForecastWeather(cityName,countryName);
        testDisplayTable(weather);

    }


    private void displayWeather(Weather weather) {

      //  System.out.println(weather.toString());
       // TableDestinationDay1.getColumns().add(column1);
       // TableDestinationDay1.getColumns().add(column2);








    }

    private void testDisplayTable(ObservableList<WeatherForecast> data){




        temperatureDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast,Double>("dayTemp"));

        dateDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, LocalDateTime>("localDateTime"));
        pressureDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast,Integer>("pressure"));
        rainDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, Double>("rain"));
        windSpeedDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast,Double>("wind_speed"));
        descriptionDestination.setCellValueFactory(new PropertyValueFactory<WeatherForecast, String>("description"));

        TableDestinationDay1.setItems(data);

    }
    private void displayWeatherFor5days(ArrayList<WeatherForecast> weatherForecasts){

       // System.out.println(weatherForecasts.get(0).getTemp().day);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService= WeatherServiceFactory.createWeatherService();
       // testDisplayTable();



    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }
}
