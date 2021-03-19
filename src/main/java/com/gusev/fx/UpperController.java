package com.gusev.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("/home/maxim/Test.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

           long orderID = (long) jsonObject.get("orderID");
            System.out.println(orderID);

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


