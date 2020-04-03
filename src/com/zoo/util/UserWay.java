package com.zoo.util;

import com.zoo.model.User;
import com.zoo.model.ZooUtil;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;

public class UserWay {
    public void addUser(){

    }
    public void deleteUser(){

    }
    public void updateUser(){

    }
    public List<User> query() throws Exception {
        Connection conn=ZooUtil.getConnection();
            Statement   stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("select Id,Name from user ");

        List<User> U= new ArrayList<User>();
        User user1 = null;

        while (rs.next()){
            user1=new User();
            user1.setId(rs.getInt("Id"));
            user1.setName(rs.getString("NAME"));
          U.add(user1);
        }

        return U;
    }
    public User get(){
        return null;
    }
}
