package com.news.util.test;

import com.news.util.dao.UserDao;
import com.news.util.dao.UserDaoImpl;
import com.news.util.pojo.NewsUser;
import com.news.util.service.UserService;
import com.news.util.service.UserServiceImpl;
import com.news.util.util.MySqlUtil;
import org.junit.Test;

import java.sql.ResultSet;

public class UserTest {
    MySqlUtil mySqlUtil=new MySqlUtil();
    UserDao userDao= new UserDaoImpl();
    UserService userService=new UserServiceImpl();
    @Test
    public void existUserTest(){

       String username="admin";
       String password="12345";
       ResultSet resultSet=userDao.existUser(username,password);
       try{
       while(resultSet.next()){
          int count= resultSet.getInt(1);
           System.out.println("count-->"+count);
       }}catch (Exception e){
           e.getStackTrace();
       }finally {
           mySqlUtil.closeResource();
       }
    }
    @Test
    public void loginUserTest(){

        String username="admin";
        String password="12345";
        boolean flag=true;
    flag  = userService.LoginUser(username,password);
    if (flag==true){
        System.out.println("存在");
    }else {
        System.out.println("不存在！");
    }
    }
    @Test
    public void addUserTest(){
        NewsUser user=new NewsUser();
        user.setUsername("1704");
        user.setPassword("12345");
        user.setEmail("1234");
      int i=this.userDao.addUser(user);
        System.out.println("i-->"+i);
    }
//注册功能
    @Test
    public void registerTest(){
        NewsUser user=new NewsUser();
        user.setEmail("1703.qq.com");
        user.setPassword("123456");
        user.setUsername("胡歌");
       boolean b= this.userService.register(user);
        System.out.println("b-->"+b);

    }
}
