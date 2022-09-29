module com.mixer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.mixer to javafx.fxml;
    exports com.mixer;
}
