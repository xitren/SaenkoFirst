package com.saenko.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.validation.constraints.Null;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class Node extends Circle {
    private final String name;
    private static final Set<Node> all = new HashSet<>();

    public void clearPull(){
        all.clear();
    }

    private static Node getNodeByName(String name){
        for(Node n: all){
            if (n.name.equals(name)){
                return n;
            }
        }
        return null;
    }
    @Override
    protected void finalize (){
        System.out.println("Finalize for " + toString());
    }

    @Override
    public String toString() {
        return ("(" + getCenterX()+ "," + getCenterY() + ")");
    }

    public static Set<Node> getAll() {
        return all;
    }

    public Node(String name, Long centerx, Long centery, Long r) {
        this.name=name;
        this.setCenterX(centerx);
        this.setCenterY(centery);
        this.setRadius(r);
        this.setFill(Color.BLUE);
        all.add(this);
    }

    public static Set<Node> factory(String filename) throws ParseException {
        Set<Node> set = new HashSet<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(filename);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray nodes = (JSONArray) jsonObject.get("nodes");
            nodes.forEach((obj) -> {
                JSONObject node = (JSONObject) obj;
                long Xcenter = (long) node.get("centerx");
                long Ycenter = (long) node.get("centery");
                long r = (long) node.get("r");
                String nodename = (String) node.get("name");
                Node n = new Node(nodename, Xcenter, Ycenter, r);
                set.add(n);
            });
            JSONArray connections = (JSONArray) jsonObject.get("connections");
            connections.forEach((obj) -> {
                JSONObject node = (JSONObject) obj;
                String startNode = (String) node.get("start");
                String endNode = (String) node.get("end");
                Connection c = new Connection(getNodeByName(startNode), getNodeByName(endNode));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}

