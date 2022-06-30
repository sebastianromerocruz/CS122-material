package com.cs122.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Snowman extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Ellipse base = new Ellipse(80, 210, 80, 60);
        base.setFill(Color.GHOSTWHITE);
        Ellipse middle = new Ellipse(80, 130, 50, 40);
        middle.setFill(Color.GHOSTWHITE);

        Circle head = new Circle(80, 70, 30);
        head.setFill(Color.GHOSTWHITE);

        Circle rightEye = new Circle(70, 60, 5);
        Circle leftEye = new Circle(90, 60, 5);

        Line mouth = new Line(70, 80, 90, 80);

        Circle topButton = new Circle(80, 120, 6);
        topButton.setFill(Color.CORAL);

        Circle bottomButton = new Circle(80, 140, 6);
        bottomButton.setFill(Color.CORAL);

        Line leftArm = new Line(110, 130, 160, 130);
        leftArm.setStrokeWidth(3);
        Line rightArm= new Line(50, 130, 0, 100);
        rightArm.setStrokeWidth(3);

        Rectangle stovepipe = new Rectangle(60, 0, 40, 50);
        Rectangle brim = new Rectangle(50, 45, 60, 5);

        Group hat = new Group(stovepipe, brim);
        hat.setTranslateX(10);
        hat.setRotate(15);

        Group snowman = new Group(base, middle, head, leftEye, rightEye, mouth, topButton, bottomButton, leftArm, rightArm, hat);
        snowman.setTranslateX(170);
        snowman.setTranslateY(50);

        Circle sun = new Circle(50, 50, 30);
        sun.setFill(Color.LIGHTGOLDENRODYELLOW);

        Rectangle ground = new Rectangle(0, 250, 500, 100);
        ground.setFill(Color.STEELBLUE);

        Group root = new Group(ground, sun, snowman);
        Scene scene= new Scene(root, 500, 350, Color.LIGHTBLUE);

        stage.setTitle("Snowman");
        stage.setScene(scene);
        stage.show();
    }
}
