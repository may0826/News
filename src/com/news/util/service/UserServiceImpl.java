package com.news.util.service;

import com.news.util.dao.UserDao;
import com.news.util.dao.UserDaoImpl;
import com.news.util.pojo.NewsUser;
import com.news.util.util.MySqlUtil;

import java.sql.ResultSet;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    MySqlUtil mysqlUtil = new MySqlUtil();

    @Override
    public boolean LoginUser(String username, String password) {
        ResultSet resultSet = userDao.existUser(username, password);
        int count = 0;
        boolean flag = false;
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(1);

            }
            if (count > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            mysqlUtil.closeResource();

        }
        return flag;
    }

    //注册功能
    public boolean register(NewsUser user) {
        int i = userDao.addUser(user);
        boolean flag = false;
//        if (i>0){
//            return true;
//        }else{
//            return false;
//        }
        if (i > 0) {
            flag = true;
        }
            return flag;

    }
}
