module com.example.gra_sieciowa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gra_sieciowa to javafx.fxml;
    exports com.example.gra_sieciowa;
}