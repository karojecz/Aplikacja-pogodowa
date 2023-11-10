package com.example.aplikacjapogodowa;

import com.example.aplikacjapogodowa.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;


public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        ViewFactory viewFactory=new ViewFactory();
        viewFactory.showMAinWindow();
        /*
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



*/
    }

    public static void main(String[] args) {
        launch();
    }
}