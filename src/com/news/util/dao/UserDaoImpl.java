package com.news.util.dao;

import com.news.util.pojo.NewsUser;
import com.news.util.util.MySqlUtil;

import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    MySqlUtil mySqlUtil=new MySqlUtil();

    public ResultSet existUser(String username,String password){
        String sql="select count(1) from news_user where username=?and password=?";
        Object[] params={username,password};
        ResultSet resultSet=mySqlUtil.executeQuerySql(sql,params);
        return  resultSet;

    }
//添加用户--封装思想
    @Override
    public int addUser(NewsUser user) {
        String sql="insert into news_user(username,password,email)values(?,?,?)";
        Object[] params={user.getUsername(),user.getPassword(),user.getEmail()};
        return this.mySqlUtil.executeUpdateSql(sql,params);
    }
}
