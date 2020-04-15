package com.zoo.view;

import com.zoo.model.User;
import com.zoo.model.ZooUtil;
import com.zoo.util.UserWay;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.SQLException;

public class Register {
    private final Stage stage=new Stage();
    public Register(){
        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color: #FFF5EE");

        Scene scene=new Scene(gr);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setHeight(300);
        stage.setWidth(500);
        stage.setResizable(false);

        Label labelName=new Label("请设置用户名：");
        labelName.setFont(Font.font(14));

        Label labelPassword=new Label("请设置密码：");
        labelPassword.setFont(Font.font(14));

        Label labelPassword1=new Label("请重新输入密码：");
        labelPassword.setFont(Font.font(14));

        Button register =new Button("注册");

        TextField textFieldName =new TextField();
        textFieldName.setTooltip(new Tooltip("请输入用户名："));
        PasswordField passwordFieldName =new PasswordField();
        passwordFieldName.setTooltip(new Tooltip("请输入密码："));
        PasswordField passwordFieldName1 =new PasswordField();
        passwordFieldName1.setTooltip(new Tooltip("请重新输入密码："));

        gr.add(labelName,0,0);
        gr.add(textFieldName,1,0);
        gr.add(labelPassword,0,1);
        gr.add(passwordFieldName,1,1);
        gr.add(labelPassword1,0,2);
        gr.add(passwordFieldName1,1,2);


        gr.add(register, 2,3);
        gr.setAlignment(Pos.CENTER);

        gr.setHgap(5);
        gr.setVgap(17);

        UserWay way=new UserWay();

        stage.show();
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn= ZooUtil.getConnection();
                String name=textFieldName.getText();
                String password=passwordFieldName.getText();
                String password1=passwordFieldName1.getText();

                if(password.equals(password1)){
                    UserWay way=new UserWay();
                    User user=new User();
                    user.setName(name);
                    user.setPassword(password);
                    user.setAttribute("Tourist");

                    try {
                        way.addUser(user);
                        stage.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else{
                    stage.setTitle("密码输入不相同，请重新输入");
                    passwordFieldName.setText("");
                    passwordFieldName1.setText("");
                    FadeTransition fade =new FadeTransition();
                    fade.setDuration(Duration.seconds(0.1));
                    fade.setNode(gr);
                    fade.setFromValue(0);
                    fade.setToValue(1);
                    fade.play();

                }
            }
        });
    }

}
