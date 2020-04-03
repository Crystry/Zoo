package com.zoo.conrtoller;

import com.zoo.model.User;
import com.zoo.util.UserWay;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserAction {
    public static void main(String[] args) throws Exception {
        UserWay u=new UserWay();

        //调用query函数
        //List<User> user1= u.query();
        //for (User user:user1) {
        //    System.out.println(user.getName()+','+user.getPassword()+','+user.getAttribute());
        //}


        User user2=new User();

        user2.setName("Coco");
        user2.setPassword(123456789);
        user2.setAttribute("pandaAdministrator");


        //调用addUser函数
        //u.addUser(user2);

        //调用更新函数
        //user2.setId(1002);
        //u.updateUser(user2);

        //调用删除函数
         //u.deleteUser(1005);

        //调用查询某个用户函数
      User user3=u.get(1002);
        System.out.println(user3.toString());

    }
}
