package com.example.aplikacjapogodowa.VIEW;

import com.example.aplikacjapogodowa.CONTROLLER.MainViewController;
import com.example.aplikacjapogodowa.Launcher;
import com.example.aplikacjapogodowa.MODEL.client.Geocoding;
import com.example.aplikacjapogodowa.MODEL.client.OpenWeatherMapsClientForecast;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    public void showMAinWindow() throws IOException {
       Stage stage=new Stage();
        MainViewController mainViewController=new MainViewController("MainView.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(mainViewController.getFxmlName()));
        fxmlLoader.setController(mainViewController);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Weather Forecast");
        stage.setScene(scene);
        stage.show();


        OpenWeatherMapsClientForecast openWeatherMapsClientForecast=new OpenWeatherMapsClientForecast();
        Geocoding tets=new Geocoding();
        tets.geocodingTest("London","UK");


    }
}
