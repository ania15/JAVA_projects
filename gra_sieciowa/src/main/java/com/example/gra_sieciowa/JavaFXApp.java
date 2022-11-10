package com.example.gra_sieciowa;

import javafx.application.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


import java.util.*;

public class JavaFXApp extends Application {

    Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

//svg
    //setonkeypressed
    //datagramsocket
    //datagrampacket

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        stage = primaryStage;

        Menu menu1 = new Menu("File");


        MenuItem menuItem1 = new MenuItem("Item 1");


        MenuItem menuItem2 = new MenuItem("Exit");

        menuItem2.setOnAction(e -> {
            System.out.println("Exit Selected");

            exit_dialog();

        });

        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);


        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().add(menu1);

        VBox vBox = new VBox(menuBar);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);

        scene.setOnKeyPressed((KeyEvent event) -> {
                    switch (event.getCode()) {
                        case RIGHT:
                            
                            break;
                        case LEFT:

                            break;
                        case UP:

                            break;
                        case DOWN:

                            break;
                    }
                }
        )

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            exit_dialog();
        });

        primaryStage.show();
    }

    public void item_1() {
        System.out.println("item 1");
    }

    //malowanie
    //komunikacja
    //lapanie kursora
    //przeslanie komhnikatu
    public void exit_dialog() {
        System.out.println("exit dialog");

        Alert alert = new Alert(AlertType.CONFIRMATION,
                "Do you really want to exit the program?.",
                ButtonType.YES, ButtonType.NO);

        alert.setResizable(true);
        alert.onShownProperty().addListener(e -> {
            Platform.runLater(() -> alert.setResizable(false));
        });

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            Platform.exit();
        } else {
        }

    }
}