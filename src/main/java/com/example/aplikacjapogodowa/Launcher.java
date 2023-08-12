package com.example.aplikacjapogodowa;

import com.example.aplikacjapogodowa.CONTROLLER.MainViewController;
import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientCurrent;

import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;


public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        MainViewController mainViewController=new MainViewController("MainView.fxml");
       //FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource("MainView.fxml"));
       FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(mainViewController.getFxmlName()));
        fxmlLoader.setController(mainViewController);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

       // OpenWeatherMapsClientCurrent openWeatherMapsClient=new OpenWeatherMapsClientCurrent();

          // openWeatherMapsClient.testApi();
       OpenWeatherMapsClientForecast openWeatherMapsClientForecast=new OpenWeatherMapsClientForecast();
       openWeatherMapsClientForecast.testForecastAPI();



    }

    public static void main(String[] args) {
        launch();
    }
}