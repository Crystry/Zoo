package com.zoo.controller;

import com.zoo.model.User;
import com.zoo.util.UserWay;

import java.sql.SQLException;
import java.util.*;

public class UserAction {

    public void add(User user) throws SQLException {
        UserWay way=new UserWay();
        way.addUser(user);
    }

    public User get(Integer id) throws SQLException {
        UserWay way=new UserWay();
        return way.get(id);
    }

   /* public void edit(User user) throws SQLException {
        UserWay way=new UserWay();
        way.updateUser(user);
    }*/

    public void delete(Integer id) throws SQLException {
        UserWay way=new UserWay();
        way.deleteUser(id);
    }

    public List<User> query() throws Exception {
        UserWay way=new UserWay();
        return way.query();
    }

    public List<User> query(List<Map<String, Object>> params) throws Exception {
        UserWay way=new UserWay();
        return way.query(params);

    }
}






