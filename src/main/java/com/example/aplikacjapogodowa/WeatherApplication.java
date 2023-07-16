package com.example.aplikacjapogodowa;

import com.example.aplikacjapogodowa.CONTROLLER.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainViewController mainViewController=new MainViewController("MainView.fxml");
       //FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource("MainView.fxml"));
       FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource(mainViewController.getFxmlName()));
        fxmlLoader.setController(mainViewController);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}