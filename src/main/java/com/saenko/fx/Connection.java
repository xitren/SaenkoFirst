package com.saenko.fx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.HashSet;
import java.util.Set;

public class Connection extends Line {
    private final Node start;
    private final Node end;
    private static final Set<Connection> all;

    static {
        all = new HashSet<>();
    }

    private Connection(Node start, Node end, Color blue){
        this.start = start;
        this.end = end;
        this.startXProperty().bind(start.centerXProperty());
        this.startYProperty().bind(start.centerYProperty());
        this.endYProperty().bind(end.centerYProperty());
        this.endXProperty().bind(end.centerXProperty());
        all.add(this);
    }

    @Override
    protected void finalize (){
        System.out.println("Finalize for " + toString());
    }

    @Override
    public String toString() {
        return ("<" + getStartX()+ "," + getStartY() +"," + getEndX() + "," + getEndY() + ">");
    }

    public void clearPull(){
        all.clear();
    }

    public static Set<Connection> getAll() {
        return all;
    }

    public Connection(Node start, Node end){
        this(start, end, Color.BLUE);
    }

    public Node getEnd() {
        return end;
    }
    public Node getStart(){
        return start;
    }
}
