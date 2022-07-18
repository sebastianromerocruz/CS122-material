package com.cs122.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FahrenheitConverter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new FahrenheitPane(), 300, 150);

        stage.setTitle("Converter");
        stage.setScene(scene);
        stage.show();
    }
}
