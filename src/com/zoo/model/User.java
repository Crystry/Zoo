package com.zoo.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private String Password;


    private SimpleIntegerProperty Id=new SimpleIntegerProperty(this,"Id");
    private SimpleStringProperty Name=new SimpleStringProperty(this,"Name");
    private SimpleStringProperty Attribute=new SimpleStringProperty(this,"Attribute");



    public SimpleIntegerProperty IdProperty(){
        return Id;
    }
    public Integer getId() {
        //return Id;
        return IdProperty().get();
    }

    public void setId(Integer id) {
        IdProperty().set(id);
    }

    public SimpleStringProperty NameProperty(){
        return Name;
    }
    public String getName() {
        return NameProperty().get();
    }

    public void setName(String name) {
        NameProperty().set(name);
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public SimpleStringProperty AttributeProperty(){
        return Name;
    }
    public String getAttribute() {
        return AttributeProperty().get();
    }

    public void setAttribute(String attribute) {
        AttributeProperty().set(attribute);
    }

    public User(){

    }
    public User(Integer aId, String aName, String aAttribute) {
        setId(aId);
        setName(aName);
        setAttribute(aAttribute);

    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Attribute='" + Attribute + '\'' +
                '}';
    }
}
