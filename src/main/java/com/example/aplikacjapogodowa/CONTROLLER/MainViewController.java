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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainViewController implements FxmlDefinedController, Initializable {
    private final String fxmlName;


    @FXML
    private Button checkWeatherButton;

    @FXML
    private TableColumn<Weather, Double> tempDestinationDay1;



    @FXML
    private TableView<Weather> TableDestinationDay1;



    @FXML
    private TextField cityName;

    @FXML
    private TextField countryName;

    @FXML
    private TableColumn<Weather, Double> dateDestinationDay1;

    private WeatherService weatherService;
    public MainViewController(String fxmlName){this.fxmlName=fxmlName;}

    @FXML
    void CheckWeatherAction() throws IOException {

        String cityName=this.cityName.getText();
        String countryName=this.countryName.getText();
        ArrayList<WeatherForecast> weather=weatherService.getForecastWeather(cityName,countryName);
        displayWeatherFor5days(weather);

    }


    private void displayWeather(Weather weather) {

      //  System.out.println(weather.toString());
       // TableDestinationDay1.getColumns().add(column1);
       // TableDestinationDay1.getColumns().add(column2);








    }
    private final ObservableList<Weather> data =
            FXCollections.observableArrayList(
                    new Weather(12d, 34d),
                    new Weather(34d,121d),
                    new Weather(21d,23d)
            );
    private void testDisplayTable(){
        Weather weather=new Weather(12d,23d);



        dateDestinationDay1.setCellValueFactory(new PropertyValueFactory<Weather,Double>("tempInCelcius"));

        tempDestinationDay1.setCellValueFactory(new PropertyValueFactory<Weather,Double>("rain"));

        TableDestinationDay1.setItems(data);

    }
    private void displayWeatherFor5days(ArrayList<WeatherForecast> weatherForecasts){

       // System.out.println(weatherForecasts.get(0).getTemp().day);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService= WeatherServiceFactory.createWeatherService();
        testDisplayTable();



    }

    @Override
    public String getFxmlName() {
        return fxmlName;
    }
}
