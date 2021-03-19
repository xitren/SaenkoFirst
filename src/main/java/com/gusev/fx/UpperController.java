package com.gusev.fx;

import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

        try (Reader reader = new FileReader("/home/maxim/graf.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            JSONArray nodes = (JSONArray) jsonObject.get("nodes");
            nodes.forEach((obj)->{
                JSONObject node = (JSONObject) obj;
                long Xcenter = (long) node.get("centerx");
                long Ycenter = (long) node.get("centery");
                long r = (long) node.get("r");
                System.out.println(" "+r+" "+Ycenter+" "+Xcenter);
                view.getChildren().add(new Circle(Xcenter, Ycenter,r));
            });

            String shopperName = (String) jsonObject.get("shopperName");
            System.out.println(shopperName);

            String shopperEmail = (String) jsonObject.get("shopperEmail");
            System.out.println(shopperEmail);


        }catch (IOException c) {
            c.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

}



