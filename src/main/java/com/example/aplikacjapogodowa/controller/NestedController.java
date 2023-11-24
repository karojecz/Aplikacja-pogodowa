package com.example.aplikacjapogodowa.controller;

import com.example.aplikacjapogodowa.model.Weather;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class NestedController {
    @FXML
    private TableView<Weather> tableView;
    @FXML
    private TableColumn<Weather, LocalDateTime> date;
    @FXML
    private TableColumn<Weather, String> description;

    @FXML
    private TableColumn<Weather, Integer> pressure;

    @FXML
    private TableColumn<Weather, Double>temp, windSpeed, rain;



    void displayWeather(ObservableList<Weather> weather) {

        temp.setCellValueFactory(new PropertyValueFactory<Weather, Double>("dayTemp"));
        date.setCellValueFactory(new PropertyValueFactory<Weather, LocalDateTime>("localDateTime"));
        pressure.setCellValueFactory(new PropertyValueFactory<Weather, Integer>("pressure"));
        rain.setCellValueFactory(new PropertyValueFactory<Weather, Double>("rain"));
        windSpeed.setCellValueFactory(new PropertyValueFactory<Weather, Double>("wind_speed"));
        description.setCellValueFactory(new PropertyValueFactory<Weather, String>("description"));

        tableView.setItems(weather);
    }
    void setTableVisible(Boolean bool){
        if (bool==true) tableView.setVisible(true);
        else tableView.setVisible(false);
    }


}
