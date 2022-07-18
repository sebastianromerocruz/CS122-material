package com.cs122.javafx;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FahrenheitPane extends GridPane {
    public static final int FONT_SIZE = 18;

    private Label result;
    private TextField fahrenheit;

    public FahrenheitPane() {
        Font font = new Font(FONT_SIZE);

        Label inputLabel = new Label("Fahrenheit:");
        inputLabel.setFont(font);
        GridPane.setHalignment(inputLabel, HPos.RIGHT);

        Label outputLabel = new Label("Celsius:");
        outputLabel.setFont(font);

        GridPane.setHalignment(outputLabel, HPos.RIGHT);

        result = new Label("---");
        result.setFont(font);
        GridPane.setHalignment(result, HPos.CENTER);

        fahrenheit = new TextField();
        fahrenheit.setFont(font);
        fahrenheit.setPrefWidth(50);
        fahrenheit.setAlignment(Pos.CENTER);
        fahrenheit.setOnAction(this::processReturn);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: cyan");

        add(inputLabel, 0, 0);
        add(fahrenheit, 1, 0);
        add(outputLabel, 0, 1);
        add(result, 1, 1);
    }

    private void processReturn(ActionEvent actionEvent) {
        int fahrenheitTemperature = Integer.parseInt(fahrenheit.getText());
        int celsiusTemperature = (fahrenheitTemperature - 32) * 5 / 9;
        result.setText(celsiusTemperature + " ");
    }

}
