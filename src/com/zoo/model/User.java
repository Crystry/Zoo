package com.zoo.model;

public class User {
    private Integer Id;
    private String Name;
    private Integer Password;
    private String Attribute;

    public String getAttribute() {
        return Attribute;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setAttribute(String attribute) {
        Attribute = attribute;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer password) {
        Password = password;
    }
}
