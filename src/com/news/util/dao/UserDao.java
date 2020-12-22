package com.news.util.dao;

import com.news.util.pojo.NewsUser;

import java.sql.ResultSet;

public interface UserDao {
    //验证登录(查询)
    public ResultSet existUser(String uesrname,String password);

    //添加用户 使用封装
    public int  addUser(NewsUser user);
}
