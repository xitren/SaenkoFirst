package com.gusev.fx;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class UpperController implements Initializable {
    public Pane view;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("graf.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
            JSONArray nodes = (JSONArray) jsonObject.get("nodes");
            nodes.forEach((obj) -> {
                JSONObject node = (JSONObject) obj;
                long Xcenter = (long) node.get("centerx");
                long Ycenter = (long) node.get("centery");
                long r = (long) node.get("r");
                String nodename = (String) node.get("name");
                System.out.println(" " + r + " " + Ycenter + " " + Xcenter);
                Nodes nodes1 = new Nodes(nodename, Xcenter,Ycenter, r);
                StackPane stack = new StackPane();
                Label label = new Label(nodename);
                stack.getChildren().addAll(nodes1, label);
                StackPane.setMargin(nodes1, new Insets(nodes1.getCenterY()-10, 0, 0, nodes1.getCenterX()-10));
                StackPane.setMargin(label, new Insets(nodes1.getCenterY()-10, 0, 0, nodes1.getCenterX()-10));
                Line line = new Line(nodes1.getCenterX(),  nodes1.getCenterY(),500 , 500);
                view.getChildren().addAll(stack, line);
                System.out.println(nodes1.name);

            });

        }catch (IOException c) {
            c.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

}



