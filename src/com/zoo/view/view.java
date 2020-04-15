package com.zoo.view;

import com.zoo.controller.UserAction;
import com.zoo.model.User;

import java.sql.SQLException;
import java.util.*;

public class view {
    private static final String CONTEXT="欢迎来到用户禁区：\n" +
            "下面是用户禁区的功能列表：\n" +
            "[MAIN/M]:主菜单\n" +
            "[QUERY/Q]:查看全部用户的信息\n" +
            "[GET/G]:查看某位用户的详细信息\n" +
            "[ADD/A]:添加用户信息\n" +
            "[UPDATE/U]:更新用户信息\n" +
            "[DELETE/D]:删除用户信息\n" +
            "[SEARCH/S]:查询用户信息(根据姓名、手机号来查询)\n" +
            "[EXIT/E]:退出用户禁区\n" +
            "[BREAK/B]:退出当前功能，返回主菜单";

    private static final String OPERATION_MAIN="MAIN";
    private static final String OPERATION_QUERY="QUERY";
    private static final String OPERATION_GET="GET";
    private static final String OPERATION_ADD="ADD";
    private static final String OPERATION_UPDATE="UPDATE";
    private static final String OPERATION_DELETE="DELETE";
    private static final String OPERATION_SEARCH="SEARCH";
    private static final String OPERATION_EXIT="EXIT";
    private static final String OPERATION_BREAK="BREAK";

    public static void main(String[] args) throws SQLException {

        System.out.println(CONTEXT);
        //怎么保持程序一直运行

        Scanner scan = new Scanner(System.in);
        User user = new User();
        UserAction action = new UserAction();
        String prenious = null; //记忆标记
        Integer step = 1;

        List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();

        Map<String, Object> param = new HashMap<String, Object>();
        while (scan.hasNext()) {
            String in = scan.next().toString();
            /*---------------------退出功能---------------------------------*/
            if (OPERATION_EXIT.equals(in.toUpperCase())
                    || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("您已成功退出用户禁区。");
                break;
            }
            /*---------------------搜索功能-----------------------------------*/
            else if (OPERATION_QUERY.equals(in.toUpperCase())
                    || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())) {
                try {
                    List<User> list = action.query(params);
                    for (User u : list) {
                        System.out.println(u.getId() + ",姓名：" + u.getName() + ",身份：" + u.getAttribute());
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
            /*--------------------------返回主菜单功能------------------------------*/
            else if (OPERATION_BREAK.equals(in.toUpperCase())
                    || OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("退出当前功能，返回主菜单");
                System.out.println(CONTEXT);
                continue;
            }
            /*---------------------------模糊查询功能--------------------------------*/
            else if (OPERATION_SEARCH.equals(in.toUpperCase())
                    || OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())
                    || OPERATION_SEARCH.equals(prenious)) {
                prenious = OPERATION_SEARCH;
                System.out.println("查询用户信息（根据姓名，身份来查询）");
                if (1 == step) {
                    System.out.println("输入用户姓名：");
                } else if (2 == step) {

                    param.put("name", "Name");
                    param.put("rela", "=");
                    param.put("value", in);
                    params.add(param);
                    System.out.println("输入用户身份");
                } else if (3 == step) {

                    param.put("name", "Attribute");
                    param.put("rela", "=");
                    param.put("value", in);
                    params.add(param);

                    List<User> result;
                    try {
                        result = action.query(params);
                        for (int i = 0; i < result.size(); i++) {
                            System.out.println(result.get(i).toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (OPERATION_SEARCH.equals(prenious)) {
                    step++;
                }

            }
            /*----------------------------详细查询功能--------------------------*/
            else if (OPERATION_GET.equals(in.toUpperCase())
                    || OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
                    || OPERATION_GET.equals(prenious)) {
                prenious = OPERATION_GET;

                if (1 == step) {
                    System.out.println("请输入用户编号：");
                } else if (2 == step) {
                    try {
                        Integer id = Integer.valueOf(in);
                        User u = action.get(id);
                        System.out.println(u.toString());
                        System.out.println("查询完成！");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (OPERATION_GET.equals(prenious)) {
                    step++;
                }

            }
            /*---------------------------显示主菜单功能-------------------------------------*/
            else if (OPERATION_MAIN.equals(in.toUpperCase())
                    || OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("显示主菜单");
                System.out.println(CONTEXT);
            }
            /*-------------------------------删除功能------------------------------------*/
            else if (OPERATION_DELETE.equals(in.toUpperCase())
                    || OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
                    || OPERATION_DELETE.equals(prenious)) {
                prenious = OPERATION_DELETE;
                System.out.println("删除用户信息");
                if (1 == step) {
                    System.out.println("输入用户id");
                } else if (2 == step) {
                    Integer id = Integer.valueOf(in);
                    try {
                        action.delete(id);
                        System.out.println("删除用户成功");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (OPERATION_DELETE.equals(prenious)) {
                    step++;
                }
            }
            /*----------------------------------更新功能----------------------------------*/
            else if (OPERATION_UPDATE.equals(in.toUpperCase())
                    || OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
                    || OPERATION_UPDATE.equals(prenious)) {
                prenious = OPERATION_UPDATE;
                System.out.println("更新用户信息");
                if (1 == step) {
                    System.out.println("请输入用户编号：");
                } else if (2 == step) {
                    Integer id = Integer.valueOf(in);
                    user.setId(id);
                    System.out.println("输入用户姓名：");
                } else if (3 == step) {
                    user.setName(in);
                    System.out.println("输入用户密码：");
                } else if (4 == step) {
                    user.setPassword(in);
                    System.out.println("输入用户身份：");
                } else if (5 == step) {
                    user.setAttribute(in);
                   // action.edit(user);
                    System.out.println("修改用户成功");

                    if (OPERATION_UPDATE.equals(prenious)) {
                        step++;
                    }

                }
                /*-----------------------------------添加功能--------------------------------*/
                else if (OPERATION_ADD.equals(in.toUpperCase())
                        || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
                        || OPERATION_ADD.equals(prenious)) {
                    prenious = OPERATION_ADD;
                    //新增用户

                    if (1 == step) {
                        System.out.println("请输入用户的［姓名］");
                    } else if (2 == step) {
                        user.setName(in);
                        System.out.println("请输入用户的［密码］");
                    } else if (3 == step) {
                        user.setPassword(in);
                        System.out.println("请输入用户的［身份");
                    } else if (4 == step) {
                        user.setAttribute(in);
                        try {
                            action.add(user);
                            System.out.println("新增用户成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("新增用户失败");
                        }
                    }
                    if (OPERATION_ADD.equals(prenious)) {
                        step++;
                    }
                } else {
                    System.out.println("您输入的值为:" + in);
                }

            }
        }


    }
}
