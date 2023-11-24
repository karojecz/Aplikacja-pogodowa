package com.example.aplikacjapogodowa;

import com.example.aplikacjapogodowa.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;


public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMAinWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}