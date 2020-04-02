package com.zoo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ZooUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/zoo";
    private static final String USER="root";
    private static final String PASSWORD="7758258";


    public static void main(String[] args) throws Exception {
        //1、加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、获得数据库的连接
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        //3、通过数据库连接操作数据库，实现增删改查
        Statement stmt =conn.createStatement();
        ResultSet rs=stmt.executeQuery("select Id,Name from user ");

        while (rs.next()){
            System.out.println(rs.getInt("Id")+','+rs.getString("Name"));
        }

    }
}
