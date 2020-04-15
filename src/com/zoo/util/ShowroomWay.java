package com.zoo.util;

import com.zoo.model.Showroom;
import com.zoo.model.User;
import com.zoo.model.ZooUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowroomWay {
    //增加用户
    public void addShowroom(Showroom showroom) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into showroom " +
                " (ShowroomName,ShowroonIntroduction,ShowroomLocation,ShowroomLocationSize,ShowroomKeeper) " +
                " values( " +
                " ?,?,?,?,?) ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, showroom.getShowroomName());
        ptmt.setString(2, showroom.getShowroomIntroduction());
        ptmt.setString(3, showroom.getShowroomLocation());
        ptmt.setString(4, showroom.getShowroomLocationSize());
        ptmt.setString(5, showroom.getShowroonKeeper());


        ptmt.execute();

    }

    public void updateShowroom(Showroom showroom) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  showroom " +
                " set ShowroomIntroduction=?,ShowroomLocation=?,ShowroomLocationSize=? ShowroomKeeper=?" +
                " where ShowName=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, showroom.getShowroomName());
        ptmt.setString(2, showroom.getShowroomIntroduction());
        ptmt.setString(3, showroom.getShowroomLocation());
        ptmt.setString(4, showroom.getShowroomLocationSize());
        ptmt.setString(5,showroom.getShowroonKeeper());
        ptmt.execute();


    }

    public void deleteShowroom(String ShowroomName) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from user " +
                " where ShowrooomName=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, ShowroomName);
        ptmt.execute();

    }

    //查询全部
    public List<Showroom> query() throws SQLException {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select * from showroom ");

        List<Showroom> showroom = new ArrayList<>();
        Showroom showroom1;
        showroom1 = null;
        while (rs.next()) {
            showroom1 = new Showroom();
            showroom1.setShowroomName(rs.getString("ShowroomName"));
            showroom1.setShowroomIntroduction(rs.getString("ShowroomIntroduction"));
            showroom1.setShowroomLocation(rs.getString("ShowroomLocation"));
            showroom1.setShowroomLocationSize(rs.getString("ShowroomLocationSize"));
            showroom1.setShowroonKeeper(rs.getString("ShowroomKeeper"));
            showroom.add(showroom1);
        }
        return showroom;

    }

    //查询单

    public List<Showroom> query(String ShowroomName) throws SQLException {
        List<Showroom> showroom = new ArrayList<>();
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from showroom ");
        sb.append(" where ShowroomName=? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, ShowroomName);
        ResultSet rs = ptmt.executeQuery();

        Showroom showroom1 = null;
        while (rs.next()) {
            showroom1 = new Showroom();
            showroom1.setShowroomName(rs.getString("ShowroomName"));
            showroom1.setShowroomIntroduction(rs.getString("showroomIntroduction"));
            showroom1.setShowroomLocation(rs.getString("showroomIntroduction"));
            showroom1.setShowroomLocationSize(rs.getString("showroomIntroductionSize"));
            showroom1.setShowroonKeeper(rs.getString("showroomKeeper"));
            showroom.add(showroom1);
        }
        return showroom;
    }

    public List<Showroom> query(List<Map<String, Object>> params) throws SQLException {
        List<Showroom> showroom = new ArrayList<>();
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from showroom where 1=1 ");

        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                Map<String, Object> map = params.get(i);
                sb.append(" and " + map.get("Showroomname") + " " + map.get("rela") + " " + map.get("value") + " ");
            }
        }
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();

        Showroom showroom1 = null;
        while (rs.next()) {
            showroom1 = new Showroom();
            showroom1.setShowroomName(rs.getString("ShowroomName"));
            showroom1.setShowroomIntroduction(rs.getString("showroomIntroduction"));
            showroom1.setShowroomLocation(rs.getString("showroomIntroduction"));
            showroom1.setShowroomLocationSize(rs.getString("showroomIntroductionSize"));
            showroom1.setShowroonKeeper(rs.getString("showroomKeeper"));
            showroom.add(showroom1);
        }
        return showroom;
    }
}
