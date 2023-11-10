package com.example.aplikacjapogodowa.controller;


import com.example.aplikacjapogodowa.model.*;

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
    @FXML
    NestedController leftNestedController;
    @FXML
    NestedController destinationTableController;
    private final String fxmlName;


    @FXML
    private TableView<Weather> TableOrigin;


    @FXML
    private Button checkWeatherButton;

    @FXML
    private TextField cityName;

    @FXML
    private TextField countryName;


    @FXML
    private Label originTableName;

    @FXML
    private Label textFieldErrorLabel;


    @FXML
    private TableColumn<Weather, LocalDateTime> dateOrigin;


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
    private TableColumn<Weather, Double> temperatureOrigin;


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


        try {

            originTableName.setVisible(true);
            originTableName.setText("Weather in " + cityName.substring(0, 1).toUpperCase() + cityName.substring(1).toLowerCase());

            TableOrigin.setVisible(true);
            textFieldErrorLabel.setVisible(false);


            WeatherForecast weatherForecast2 = weatherService.getWeatherForecast2(cityName, countryName);

            Collection<Weather> weather2s = weatherForecast2.getWeather2s();


            ObservableList<Weather> list = FXCollections.observableList(new ArrayList<>(weather2s));


//nested
            destinationTableController.displayWeather(list);


        } catch (Exception e) {
            e.printStackTrace();
            textFieldErrorLabel.setText("city name or country code are wrong");
            textFieldErrorLabel.setVisible(true);
        }


    }

    private void displayWeather(ObservableList<Weather> weatherOrigin) {


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = WeatherServiceFactory.createWeatherService();

        originTableName.setVisible(false);
        TableOrigin.setVisible(false);

        textFieldErrorLabel.setVisible(false);


    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }
}
