module com.example.finals {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finals to javafx.fxml;
    exports com.example.finals;
}