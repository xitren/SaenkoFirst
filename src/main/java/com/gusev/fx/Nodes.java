package com.gusev.fx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Nodes extends Circle {
    String name;

    public Nodes(String name, Long centerx, Long centery, Long r) {
            this.name=name;
            this.setCenterX(centerx);
            this.setCenterY(centery);
            this.setRadius(r);
            this.setFill(Color.BLUE);

    }
}
