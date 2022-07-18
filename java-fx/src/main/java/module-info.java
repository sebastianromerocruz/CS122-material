module com.cs122.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.cs122.javafx to javafx.fxml;
    exports com.cs122.javafx;
}