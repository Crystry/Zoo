package com.zoo.conrtoller;

import com.zoo.model.User;
import com.zoo.util.UserWay;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserAction {
    public static void main(String[] args) throws Exception {
        UserWay u=new UserWay();

        List<User> user1= u.query();

        for (User user:user1) {
            System.out.println(user.getId()+','+user.getName());

        }
    }
}
