module com.example.aplikacjapogodowa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aplikacjapogodowa to javafx.fxml;
    exports com.example.aplikacjapogodowa;
}