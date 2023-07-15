module com.example.aplikacjapogodowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.aplikacjapogodowa to javafx.fxml;
    opens com.example.aplikacjapogodowa.VIEW;
    opens com.example.aplikacjapogodowa.CONTROLLER;
    opens com.example.aplikacjapogodowa.MODEL;
    exports com.example.aplikacjapogodowa;
}