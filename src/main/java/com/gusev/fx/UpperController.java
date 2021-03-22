package com.gusev.fx;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.aspectj.weaver.bcel.BcelRenderer;
import org.dom4j.Text;
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
                String name = (String) node.get("name");
                System.out.println(" " + r + " " + Ycenter + " " + Xcenter);
                StackPane stack = new StackPane();
                Circle circle = new Circle(Xcenter, Ycenter, r, Color.RED);
                Label label = new Label(name);
                stack.getChildren().addAll(circle, label);
                StackPane.setAlignment(circle, Pos.TOP_CENTER);
                StackPane.setAlignment(label, Pos.TOP_CENTER);
                StackPane.setMargin(circle, new Insets(circle.getCenterY(), 0, 0, circle.getCenterX()));
                StackPane.setMargin(label, new Insets(circle.getCenterY(), 0, 0, circle.getCenterX()));
                view.getChildren().add(stack);
                view.getChildren().add(stack);
            });

        }catch (IOException c) {
            c.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

}



