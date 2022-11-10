package com.example.gra;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Game {
    private int width;
    private int height;

    public int points1;
    public int points2;
    public ArrayList<Circle> targets;
    public Rectangle player1;
    public Rectangle player2;

    public Game( int width, int height ) {
        this.width = width;
        this.height = height;

        this.points1 = 0;
        this.points2 = 0;
        this.targets = new ArrayList<Circle>();
        for( int i = 0; i < 10; i++ ) {
            // Circle(X, Y, r, Paint f)
            this.targets.add( new Circle(Math.random() * width, Math.random() * height, 20, Color.YELLOW) );
        }

        this.player1 = new Rectangle(50, 50, 30, 30); // Rectangle(x, y, w, h)
        this.player1.setFill( Color.BLUE );

        this.player2 = new Rectangle(width - 50, height - 50, 30, 30);
        this.player2.setFill( Color.RED );
    }

    public void checkCollision(Shape block) {
        for(Shape static_bloc : this.targets){
            if(block.getBoundsInParent().intersects(static_bloc.getBoundsInParent())){
                static_bloc.setFill( Color.TRANSPARENT );
                this.points1++;
            }
        }
    }

}
