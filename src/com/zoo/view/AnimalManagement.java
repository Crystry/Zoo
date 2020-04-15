package com.zoo.view;

import com.zoo.controller.AnimalAction;
import com.zoo.model.Animal;
import com.zoo.model.Tourist;
import com.zoo.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class AnimalManagement {
    private final Stage stage = new Stage();

    public AnimalManagement() throws Exception {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        //顶部.
        /*Label label = new Label("管理系统");
        label.setFont(new Font("宋体", 20));
        root.setTop(label);*/
        Button panda=new Button("Panda");
        //Button bear=new Button("Bear");

        root.setTop(panda);

        //左侧


        //中部
        TableView<Animal> table = new TableView<>();
        //table.setEditable(true);

        TableColumn<Animal, String> first = new TableColumn<>("AnimalName");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalName"));

        TableColumn<Animal, String> second = new TableColumn<>("AnimalType");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalType"));

        TableColumn<Animal, String> third = new TableColumn<>("AnimalSex");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalSex"));

        TableColumn<Animal, String> forth = new TableColumn<>("AnimalAge");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalAge"));

        TableColumn<Animal, String> fifth = new TableColumn<>("AnimalIntroduction");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalIntroduction"));

        TableColumn<Animal, String> sixth = new TableColumn<>("AnimalPresentSituation");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalPresentSituation"));

        TableColumn<Animal, String> seventh = new TableColumn<>("AnimalKeeper");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalKeeper"));



        AnimalAction action = new AnimalAction();
        List<Animal> result=action.query();
        for (int i=0;i<result.size();i++) {
        }
       // table.setItems(listData);
        table.getColumns().addAll(first, second, third,forth,fifth,sixth,seventh);
        table.getItems().addAll(action.query());

        root.setCenter(table);

        stage.setScene(scene);
        stage.setTitle("管理系统");
        stage.setHeight(600);
        stage.setWidth(800);
        stage.show();
    }

}
