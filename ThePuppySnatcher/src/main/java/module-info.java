module com.willei01.thepuppysnatcher {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.willei01.thepuppysnatcher to javafx.fxml;
    exports com.willei01.thepuppysnatcher;
}