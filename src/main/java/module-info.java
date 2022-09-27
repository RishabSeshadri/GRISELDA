module com.mixer {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mixer to javafx.fxml;
    exports com.mixer;
}
