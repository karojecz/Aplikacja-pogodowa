package com.example.aplikacjapogodowa.CONTROLLER;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainViewController {

    @FXML
    private Button checkWeatherButton;

    @FXML
    private Label temperature;

    @FXML
    private Label teperatureLabel;

    @FXML
    void CheckWeatherAction() {
        System.out.println("click!!");
    }


}
