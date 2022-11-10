package com.example.gra;

import javafx.application.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.*;

// svg path "<komenda svg>", fillOval itp
// setOnKeyPressed
// serialise

public class JavaFXApp extends Application {

    Stage stage;
    private static final int FRAME_WIDTH = 960;
    private static final int FRAME_HEIGHT = 600;


    public static void main(String[] args) {
        launch(args);
    }

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

        AnchorPane pane = new AnchorPane(menuBar);

        Game game = new Game(960, 600);
        for (Circle item : game.targets)
            pane.getChildren().add(item);
        pane.getChildren().add(game.player1);
        pane.getChildren().add(game.player2);

        Scene scene = new Scene(pane, FRAME_WIDTH, FRAME_HEIGHT);

        primaryStage.setScene(scene);
        scene.setOnKeyPressed((KeyEvent event) -> {
                    double x = game.player1.getX();
                    double y = game.player1.getY();
                    switch (event.getCode()) {
                        case RIGHT:
                            if (x + 20 + game.player1.getWidth() < FRAME_WIDTH) game.player1.setX(x + 20);
                            break;
                        case LEFT:
                            if (x - 20 > 0) game.player1.setX(x - 20);
                            break;
                        case UP:
                            if (y - 20 - game.player1.getHeight() > 0) game.player1.setY(y - 20);
                            break;
                        case DOWN:
                            if (y + 20 + game.player1.getHeight() < FRAME_HEIGHT) game.player1.setY(y + 20);
                            break;
                    }
                    game.checkCollision(game.player1);
                }
        );
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            exit_dialog();
        });

        primaryStage.show();
    }

    public void item_1() {
        System.out.println("item 1");
    }

    public void exit_dialog() {
        System.out.println("exit dialog");

        Alert alert = new Alert(AlertType.CONFIRMATION, "Do you really want to exit the program?.", ButtonType.YES, ButtonType.NO);

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