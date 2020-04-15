package com.zoo.util;

import com.zoo.model.User;
import com.zoo.model.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;
import java.util.*;


public class UserWay {
    //增加用户
    public void addUser(User user) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into user " +
                " (Name,Password,Attribute) " +
                " values( " +
                " ?,?,?) ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, user.getName());
        ptmt.setString(2, user.getPassword());
        ptmt.setString(3, user.getAttribute());
        ptmt.execute();

    }

    public void updateUser(User user) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  user " +
                " set Name=?,Password=?,Attribute=? " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, user.getName());
        ptmt.setString(2, user.getPassword());
        ptmt.setString(3, user.getAttribute());
        ptmt.setInt(4, user.getId());
        ptmt.execute();


    }

    public void deleteUser(Integer Id) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from user " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, Id);
        ptmt.execute();

    }

    //查询全部
    public List<User> query() throws SQLException {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select * from user ");
       // ObservableList<User> user = FXCollections.observableArrayList();

        List<User> user = new ArrayList<>();
       //User u = null;
        while (rs.next()) {

            Integer id=rs.getInt("Id");
            String name=rs.getString("Name");
            String attribute=rs.getString("Attribute");
            User u=new User(id,name,attribute);
            user.add(u);
        }
        return user;

    }

    //查询单个
    public User get(Integer Id) throws SQLException {
        User user = null;
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " select * from user " +
                " where Id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, Id);
        ResultSet rs = ptmt.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("Id"));
            user.setName(rs.getString("Name"));
            user.setAttribute(rs.getString("Attribute"));
        }
        return user;

    }


    public List<User> query(String Name) throws SQLException {
        List<User> user = new ArrayList<>();
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from user ");
        sb.append(" where Name=? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, Name);
        ResultSet rs = ptmt.executeQuery();

        User u = null;
        while (rs.next()) {
            u = new User();
            u.setId(rs.getInt("Id"));
            u.setName(rs.getString("Name"));
            u.setAttribute(rs.getString("Attribute"));

            user.add(u);
        }
        return user;

    }

    public List<User> query(List<Map<String, Object>> params) throws SQLException {
        List<User> user = new ArrayList<>();

        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from user where 1=1 ");

        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                Map<String, Object> map = params.get(i);
                sb.append(" and " + map.get("name") + " " + map.get("rela") + " " + map.get("value") + " ");
            }
        }


        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ResultSet rs = ptmt.executeQuery();

        User u = null;
        while (rs.next()) {
            u = new User();
            u.setId(rs.getInt("Id"));
            u.setName(rs.getString("Name"));
            u.setPassword(rs.getString("Password"));
            u.setAttribute(rs.getString("Attribute"));

            user.add(u);
        }
        return user;
    }

    //查询Name
    public boolean selectName(String aName) {
        String Name = null;
        Connection conn = ZooUtil.getConnection();
        String sql = "select * from user";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Name = rs.getString("Name");
                if (Name.equals(aName)) {

                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean selectPassword(String aName, String aPassword) {
        String Password = null;
        Connection conn = ZooUtil.getConnection();
        String sql = "select Password from user where Name='" + aName + "'";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Password = rs.getString("Password");
                if (Password.equals(aPassword)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean selectAttribute(String aName, String aAttribute) {
        String Attribute = null;
        Connection conn = ZooUtil.getConnection();
        String sql = "select * from user where Name='" + aName + "'";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Attribute = rs.getString("Attribute");

                if (Attribute.equals(aAttribute)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean judgeAttribute1(String aAttribute) {
        String Boss="Chief";
        if (aAttribute == Boss) {
            return true;

        }
        return false;
    }
    public boolean judgeAttribute2(String aAttribute) {
        if (aAttribute == "Tourist") {
            return true;

        }
        return false;
    }
}

