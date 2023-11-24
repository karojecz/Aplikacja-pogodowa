package com.example.aplikacjapogodowa.view;

import com.example.aplikacjapogodowa.controller.MainViewController;
import com.example.aplikacjapogodowa.Launcher;
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
    }
}
