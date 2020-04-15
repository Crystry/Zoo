package com.zoo.view;

import com.zoo.controller.AnimalAction;
import com.zoo.controller.UserAction;
import com.zoo.model.User;
import com.zoo.model.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BossManagement {
   // private final TableView tableView = new TableView();
    private final Stage stage = new Stage();

    public BossManagement() throws Exception {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        //顶部.
        Label label = new Label("管理系统");
        label.setFont(new Font("宋体", 20));
        root.setTop(label);


        //左侧


        //中部
        TableView<User> table = new TableView<User>();
        table.setEditable(true);

        TableColumn<User, String> first = new TableColumn<>("Id");
        first.setMinWidth(200);
        first.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<User, String> second = new TableColumn<>("Name");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<User, String> third = new TableColumn<>("Attribute");
        first.setMinWidth(100);
        first.setCellValueFactory(new PropertyValueFactory<>("Attribute"));

        UserAction action = new UserAction();
        table.getColumns().addAll(first, second, third);
        table.getItems().addAll(action.query());



            root.setCenter(table);

            stage.setScene(scene);
            stage.setTitle("管理系统");
            stage.setHeight(600);
            stage.setWidth(500);
            stage.show();
        }

    }
 /* final TextField addId = new TextField();
        addId.setPromptText("Id");
        addId.setMaxWidth(200);
        final TextField addName = new TextField();
        addName.setMaxWidth(100);
        addName.setPromptText("Name");
        final TextField addAttribute = new TextField();
        addAttribute.setMaxWidth(100);
        addAttribute.setPromptText("Attribute");*/
//ObservableList<User> listData =FXCollections.observableArrayList(action.query());
//table.setItems(listData);
//List<User> user=new ArrayList<>();