package com.example.javafxapplication2;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage)  {

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                new PieChart.Data("Data 1", 20),
                new PieChart.Data("Data 2", 10),
                new PieChart.Data("Data 3", 30)
        );


        Button btn1 = new Button("Add data");
        Button btn2 = new Button("Delete data");
        btn2.setOnAction((event)->{
            if(!data.isEmpty())
                data.remove(new Random().nextInt(data.size()));
        });

        btn1.setOnAction((event) -> {
            data.add(new PieChart.Data("Data " + (data.size()+1) ,
                    10 + new Random().nextInt(30)));
        });

        //------------------------------------------

        PieChart pie = new PieChart(data);


        FlowPane root = new FlowPane();
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(pie);



        //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //       Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 450, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}