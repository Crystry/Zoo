package com.zoo.controller;

import com.zoo.model.Showroom;
import com.zoo.util.ShowroomWay;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ShowroonAction {
    public void addShowroom(Showroom showroom) throws SQLException {
        ShowroomWay way=new ShowroomWay();
        way.addShowroom(showroom);
    }
    public void deleteShowroom(String showroomName) throws SQLException {
        ShowroomWay way=new ShowroomWay();
        way.deleteShowroom(showroomName);
    }
    public void editShowroom(Showroom showroom) throws SQLException {
        ShowroomWay way=new ShowroomWay();
        way.updateShowroom(showroom);
    }
    public List<Showroom> query() throws Exception {

        ShowroomWay way=new ShowroomWay();
        return way.query();
    }

    public List<Showroom> query(List<Map<String, Object>> params) throws Exception {
        ShowroomWay way=new ShowroomWay();
        return way.query(params);
    }
}
