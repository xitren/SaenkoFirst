package com.gusev.fx;

import com.saenko.fx.Connection;
import com.saenko.fx.Node;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javafx.geometry.Insets;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.Reader;

public class UpperController implements Initializable {
    public Pane view;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Node.factory("graf.json");
        } catch (ParseException e) {
            System.out.println(e);
        }
        view.getChildren().addAll(Node.getAll());
        view.getChildren().addAll(Connection.getAll());
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        Node a = Node.getAll().stream().findFirst().get();
        final KeyValue kv = new KeyValue(a.centerYProperty(), 0);
        final KeyFrame kf = new KeyFrame(Duration.ZERO, kv);
        final KeyValue fkv = new KeyValue(a.centerYProperty(), 400);
        final KeyFrame fkf = new KeyFrame(Duration.seconds(3), fkv);
        timeline.getKeyFrames().addAll(kf,fkf);
        timeline.play();
    }

}



