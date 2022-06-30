package com.cs122.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class NotArt extends Application {
    /**
     * Creates and displays several shapes that are not art.
     * */
    public void start(Stage stage) {
        Line line = new Line(35, 60, 150, 170);

        Circle circle = new Circle(100, 65, 20);
        circle.setFill(Color.LIGHTBLUE);

        Rectangle rectangle = new Rectangle(60, 70, 250, 60);
        rectangle.setStroke(Color.LIGHTCORAL);
        rectangle.setStrokeWidth(2);
        rectangle.setFill(null);

        Ellipse ellipse = new Ellipse(200, 100, 150, 50);
        ellipse.setFill(Color.LIGHTSEAGREEN);

        Text quote = new Text(120, 100, "Ce n'est pas de l'art.");

        Group root = new Group(ellipse, rectangle, circle, line, quote);
        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("This is not art.");
        stage.setScene(scene);
        stage.show();
    }
}
