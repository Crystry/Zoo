package com.zoo.model;

import java.sql.*;

public class ZooUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/zoo?serverTimezone=UTC";
    private static final String USER="root";
    private static final String PASSWORD="7758258";

    private static Connection conn = null;

    static {
        //1、加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、获得数据库的连接
        try {
           conn=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        return conn;
    }

}

