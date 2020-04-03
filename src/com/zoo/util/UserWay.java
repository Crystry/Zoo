package com.zoo.util;

import com.zoo.model.User;
import com.zoo.model.ZooUtil;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;



public class UserWay {
    //增加用户
    public void addUser(User u) throws Exception {
        Connection conn = ZooUtil.getConnection();
        String sql = "" + "insert into user" + "(Name,Password,Attribute)" +
                "values(" + "?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, u.getName());
        ptmt.setInt(2, u.getPassword());
        ptmt.setString(3, u.getAttribute());
        ptmt.execute();

    }

    //删除用户
    public void deleteUser(Integer Id) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" + " delete from user " +
                " where Id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);


        ptmt.setInt(1, Id);
        ptmt.execute();

    }

    //更新用户
    public void updateUser(User u) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" + " update  user " + " set Name=?,Password=?,Attribute=? " +
                " where Id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, u.getName());
        ptmt.setInt(2, u.getPassword());
        ptmt.setString(3, u.getAttribute());
        ptmt.setInt(4, u.getId());
        ptmt.execute();


    }

    //查全部用户
    public List<User> query() throws Exception {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select Id,Name,Password,Attribute from user ");

        List<User> U = new ArrayList<User>();
        User user1 = null;

        while (rs.next()) {
            user1 = new User();
            user1.setId(rs.getInt("Id"));
            user1.setName(rs.getString("Name"));
            user1.setPassword(rs.getInt("Password"));
            user1.setAttribute(rs.getString("Attribute"));
            U.add(user1);
        }

        return U;
    }

    //查询某个用户
    public User get(Integer Id) throws SQLException {
        User user = null;
        Connection conn = ZooUtil.getConnection();
        String sql = "" + " select * from user" +
                " where Id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, Id);
        ResultSet rs = ptmt.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("Id"));
            user.setName(rs.getString("Name"));
            user.setAttribute("Attribute");


        }
        return user;
    }

}

