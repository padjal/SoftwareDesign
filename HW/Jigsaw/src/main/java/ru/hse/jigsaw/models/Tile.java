package ru.hse.jigsaw.models;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    private int size = 100;

    public Rectangle getTile(){
        var rect = new Rectangle(100, 100);
        rect.setFill(Color.RED);
        return rect;
    }
}
