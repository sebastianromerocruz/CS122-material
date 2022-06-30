package com.cs122.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

    /**
    * Creates and displays two Text objects in a JavaFX window.
    * */
    @Override
    public void start(Stage stage) throws Exception {
        /* Two Text objects are instantiated */
        Text hello = new Text(
                // In this case, the position of each Text object is specified.
                // The origin of the Java coordinate system is in the upper left corner,
                // Meaning that all coordinates in Java are positive.
                50,
                50,
                "Hello, JavaFX."
        );
        Text question = new Text(120, 80, "What's up?");

        // And added to a Group object, root
        Group root = new Group(hello, question);

        // We say that this group serves as the ROOT NODE of a Scene object
        Scene scene = new Scene(root, 300, 120, Color.LIGHTBLUE);

        // Finally, we display this scene in the primary window, or Stage
        stage.setTitle("Our first JavaFX program.");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the JavaFX application. This method is not required
     * in IDEs that launch JavaFX applications automatically.
     * */
    public static void main(String[] args) {
        launch(args);
    }
}
