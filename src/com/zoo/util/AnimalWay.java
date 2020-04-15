package com.zoo.util;

import com.zoo.model.Animal;
import com.zoo.model.User;
import com.zoo.model.ZooUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnimalWay {
    public void addAnimal(Animal animal) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into animal " +
                " (AnimalName,AnimalType,AnimalSex,AnimalAge,AnimalIntroduction,AnimalPresentSituation,AnimalKeeper) " +
                " values( " +
                " ?,?,?,?,?,?,?) ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, animal.getAnimalName());
        ptmt.setString(2, animal.getAnimalType());
        ptmt.setString(3, animal.getAnimalSex());
        ptmt.setString(4, animal.getAnimalAge());
        ptmt.setString(5, animal.getAnimalIntroduction());
        ptmt.setString(6, animal.getAnimalPresentSituation());
        ptmt.setString(7, animal.getAnimalKeeper());
        ptmt.execute();

    }

    public void updateAnimal(Animal animal) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  animal " +
                " set  AnimalName=?,AnimalType=?,AnimalSex=?,AnimalAge=?,AnimalIntroduction=?," +
                "AnimalPresentSituation=?,AnimalKeeper=? " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, animal.getAnimalName());
        ptmt.setString(2, animal.getAnimalType());
        ptmt.setString(3, animal.getAnimalSex());
        ptmt.setString(4, animal.getAnimalAge());
        ptmt.setString(5, animal.getAnimalIntroduction());
        ptmt.setString(6, animal.getAnimalPresentSituation());
        ptmt.setString(7, animal.getAnimalKeeper());
        ptmt.execute();



    }

    public void deleteAnimal(String AnimalName) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from animal " +
                " where AnimalName=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, AnimalName);
        ptmt.execute();

    }

    //查询全部
    public List<Animal> query() throws SQLException {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(" select * from animal ");

        List<Animal> animal = new ArrayList<>();
      //  Animal A=null;
        while (rs.next()) {
            //A = new Animal();
            String animalName=rs.getString("AnimalName");
            String animalType=rs.getString("AnimalType");
            String animalSex=rs.getString("AnimalSex");
            String animalAge=rs.getString("AnimalAge");
            String animalIntroduction=rs.getString("AnimalIntroduction");
            String animalPresentSituation=rs.getString("AnimalPresentSituation");
            String animalKeeper;
            animalKeeper = rs.getString("AnimalKeeper");
            Animal A=new Animal(animalName,animalType,animalSex,animalAge,
                    animalIntroduction,animalPresentSituation,animalKeeper);
            animal.add(A);
        }
        return animal;

    }

    //查询单个

    public List<Animal>query (String AnimalName) throws SQLException {
        List<Animal> animal=new ArrayList<>();
        Connection conn=ZooUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append(" select * from animal ");
        sb.append(" where AnimalName=? ");
        PreparedStatement ptmt=conn.prepareStatement(sb.toString());
        ptmt.setString(1,AnimalName);
        ResultSet rs=ptmt.executeQuery();

        Animal A=null;
        while (rs.next()){
            A=new Animal();
            A.setAnimalName(rs.getString("AnimalName"));
            A.setAnimalType(rs.getString("AnimalType"));
            A.setAnimalSex(rs.getString("AnimalSex"));
            A.setAnimalAge(rs.getString("AnimalAge"));
            A.setAnimalIntroduction(rs.getString("AnimalIntroduction"));
            A.setAnimalPresentSituation(rs.getString("AnimalPresentSituation"));
            A.setAnimalKeeper(rs.getString("AnimalKeeper"));
            animal.add(A);
        }
        return animal;

    }
    public List<Animal> query(List<Map<String,Object>> params) throws SQLException {
        List<Animal> animal=new ArrayList<>();

        Connection conn=ZooUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append(" select * from user where 1=1 ");

        if(params!=null&&params.size()>0){
            for (int i=0;i<params.size();i++){
                Map<String,Object>map=params.get(i);
                sb.append(" and "+map.get("AnimalName")+" "+map.get("rela")+" "+map.get("value")+" ");
            }
        }

        PreparedStatement ptmt=conn.prepareStatement(sb.toString());

        ResultSet rs=ptmt.executeQuery();

        Animal A=null;
        while (rs.next()){
            A=new Animal();
            A.setAnimalName(rs.getString("AnimalName"));
            A.setAnimalType(rs.getString("AnimalType"));
            A.setAnimalSex(rs.getString("AnimalSex"));
            A.setAnimalAge(rs.getString("AnimalAge"));
            A.setAnimalIntroduction(rs.getString("AnimalIntroduction"));
            A.setAnimalPresentSituation(rs.getString("AnimalPresentSituation"));
            A.setAnimalKeeper(rs.getString("AnimalKeeper"));
            animal.add(A);
        }
        return animal;
    }
}
