package com.zoo.util;

import com.zoo.model.ZooUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BossWay {
    public boolean selectName(String aName)  {
        int number1=0;
        String Name=null;
        Connection conn= ZooUtil.getConnection();
        String sql="select * from user ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs=ptmt.executeQuery();
            while (rs.next()){
                Name=rs.getString("Name");
                number1++;
                if (Name.equals(aName)){
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*public boolean selectPassword(String aPassword){
        int number2=0;
        String Password=null;
        Connection conn=ZooUtil.getConnection();
        String sql="select * from boss";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs=ptmt.executeQuery();
                while (rs.next()){
                Password=rs.getString("Password");
                number2++;
                if (Password.equals(aPassword)){
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }*/
}
