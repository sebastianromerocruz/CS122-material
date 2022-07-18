package com.cs122.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PushCounter extends Application {
    private int count;      // How we will keep count
    private Text countText; // How we will display the count


    @Override
    public void start(Stage stage) {
        // STEP 1: Starting state
        count = 0;
        countText = new Text("Number of Pushes: 0");

        // STEP 2: Create our button and tell it what to do
        Button button = new Button("Push me!");
        button.setOnAction(this::processButtonPress); // See STEP 3

        // Or, with lambda expression...
//        button.setOnAction((event) -> {
//            count++;
//            countText.setText("Number of Pushes: " + count);
//        });

        // STEP 4: Create a nicely aligned box to put our elements in
        FlowPane flowPane = new FlowPane(button, countText);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(20);
        flowPane.setStyle("-fx-background-color: cyan");

        // STEP 5: Mount the scene and set the stage
        Scene scene = new Scene(flowPane, 300, 100);

        stage.setTitle("Push Counter");
        stage.setScene(scene);
        stage.show();
    }

    private void processButtonPress(ActionEvent actionEvent) {
        // STEP 3: What should our button do when pressed?
        //         Simply increase the count and update the text
        count++;
        countText.setText("Number of Pushes: " + count);
    }
}
