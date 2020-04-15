package com.zoo.controller;

import com.zoo.model.Animal;
import com.zoo.model.User;
import com.zoo.util.AnimalWay;
import com.zoo.util.UserWay;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AnimalAction {
    public void addAnimal(Animal animal) throws SQLException {
        AnimalWay way=new AnimalWay();
        way.addAnimal(animal);
    }

    public List<Animal> query(String AnimalName) throws Exception {

        AnimalWay way=new AnimalWay();
        return way.query(AnimalName);
    }


    public void edit(Animal animal) throws SQLException {
        AnimalWay way=new AnimalWay();
        way.updateAnimal(animal);
    }

    public void delete(String AnimalName) throws SQLException {
        AnimalWay way=new AnimalWay();
        way.deleteAnimal(AnimalName);
    }

    public static List<Animal> query() throws Exception {

        AnimalWay way=new AnimalWay();
        return way.query();
    }

    public List<Animal> query(List<Map<String, Object>> params) throws Exception {

        AnimalWay way=new AnimalWay();
        return way.query(params);

    }
}
