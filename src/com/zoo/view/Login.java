package com.zoo.view;

import com.zoo.model.ZooUtil;
import com.zoo.util.UserWay;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.SQLException;

public class Login extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color: #FFF5EE");

        Scene scene=new Scene(gr);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);

        Label labelName=new Label("用户名：");
        labelName.setFont(Font.font(14));

        Label labelPassword=new Label("密码：");
        labelPassword.setFont(Font.font(14));

        Label labelAttribute=new Label("身份：");
        labelPassword.setFont(Font.font(14));


        TextField textFieldName =new TextField();
        textFieldName.setTooltip(new Tooltip("请输入用户名："));
        PasswordField passwordFieldName =new PasswordField();
        passwordFieldName.setTooltip(new Tooltip("请输入密码："));

        ChoiceBox choiceBox=new ChoiceBox();
        choiceBox.setItems(FXCollections.observableArrayList(
                "Chief","Tourist","PandaAdministrator"
        ));

      //  textFieldName.setUserData("123");
        //passwordFieldName.setUserData("123");

        Button login =new Button("登录");
        Button clear = new Button("清除");
        Button register=new Button("注册");

        gr.add(labelName,0,0);
        gr.add(textFieldName,1,0);
        gr.add(labelPassword,0,1);
        gr.add(passwordFieldName,1,1);
        gr.add(labelAttribute,0,2);
        gr.add(choiceBox,1,2);

        gr.add(login,1,3);
        gr.add(clear,0,3);
        gr.add(register, 0,4);

        gr.setAlignment(Pos.CENTER);

        gr.setHgap(2);
        gr.setVgap(10);

        GridPane.setMargin(login,new Insets(0,0,0,120));


        primaryStage.show();
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textFieldName.setText("");
                passwordFieldName.setText("");
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn= ZooUtil.getConnection();
               String name=textFieldName.getText();
                String password=passwordFieldName.getText();
                String attribute= (String) choiceBox.getValue();
                UserWay way=new UserWay();

                if(way.selectName(name)) {
                    if (way.selectPassword(name,password)) {
                        if (way.selectAttribute(name,attribute)) {
                            System.out.println("登录成功");
                            primaryStage.close();
                           // MyWindow window=new MyWindow();
                            if (way.judgeAttribute1(attribute)) {       //判断是否为龙妈
                                try {
                                    BossManagement bossManagement=new BossManagement();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }else if (way.judgeAttribute2(attribute)) {        //判断是否为游客
                                //MyWindow window=new MyWindow();
                                try {

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else {
                                //MyWindow window=new MyWindow();
                                try {
                                    AnimalManagement animalManagement =new AnimalManagement();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                      else {
                            primaryStage.setTitle("身份选择错误，请重新选择！");
                            FadeTransition fade =new FadeTransition();
                            fade.setDuration(Duration.seconds(0.1));
                            fade.setNode(gr);
                            fade.setFromValue(0);
                            fade.setToValue(1);
                            fade.play();
                        }
                    }
                        else {
                    primaryStage.setTitle("密码错误");
                        System.out.println("登录失败");
                    passwordFieldName.setText("");

                    FadeTransition fade =new FadeTransition();
                        fade.setDuration(Duration.seconds(0.1));
                        fade.setNode(gr);
                        fade.setFromValue(0);
                        fade.setToValue(1);
                        fade.play();

                }
            }else {
                    primaryStage.setTitle("这个Id不存在，请注册！");
                    textFieldName.setText("");
                    passwordFieldName.setText("");
                    FadeTransition fade =new FadeTransition();
                    fade.setDuration(Duration.seconds(0.1));
                    fade.setNode(gr);
                    fade.setFromValue(0);
                    fade.setToValue(1);
                    fade.play();


                }
        }
        });
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Register register=new Register();
                primaryStage.setTitle("注册成功！");
            }
        });
    }
}
class MyWindow{
    private final Stage stage=new Stage();
    public MyWindow(){
        stage.show();
    }

}
