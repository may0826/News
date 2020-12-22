package com.news.util.util;

import com.news.util.util.ConfigManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public class MySqlUtil {
    private Connection connection=null;
    private PreparedStatement preparedStatement=null;
    private  ResultSet resultSet=null;


    //通过tomcat中的server.xml，获得与数据库的连接

//    public boolean getConnection(){
//
//        try {
//
//            //获得上下文对象
//
//            Context context = new InitialContext();
//
//            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/news");
//
//            connection = dataSource.getConnection();
//
//
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//
//        return true;
//
//    }




    public boolean getConnection(){

        //数据库的连接
        String driver = ConfigManager.getInstance().getString("driver3");//方法是静态的 所以可以直接用类名.方法 不需要new一个对象
        String url = ConfigManager.getInstance().getString("url3");
        String username= ConfigManager.getInstance().getString("username3");
        String password= ConfigManager.getInstance().getString("password3");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    //关闭资源：封装思想
    public void closeResource(){
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //统一查询
    public ResultSet executeQuerySql(String sql, Object[] params){
        if(this.getConnection()){
            try {
                preparedStatement = connection.prepareStatement(sql);

                //通过for循环的方式给占位符赋值 null.length-- -1
                if(params!=null ) {
                    for (int i = 0; i < params.length; i++) {
                        preparedStatement.setObject(i+1, params[i]);
                    }
                }
                //执行查询
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }/*finally {
                this.closeResource();
            }  finally 不要写*/
        }else {
            System.out.println("连接失败");
        }
        return resultSet;
    }


    //增删改统一方法
    public int executeUpdateSql(String sql,Object[] params){
        int count=0;
        if(this.getConnection()){

            try {
                preparedStatement = connection.prepareStatement(sql);
                //通过for循环的方式给占位符赋值 null.length-- -1
                if(params!=null ) {
                    for (int i = 0; i < params.length; i++) {
                        preparedStatement.setObject(i+1, params[i]);
                    }
                }
                //执行增加/删除功能  executeUpdate()
                count = preparedStatement.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                this.closeResource();
            }
        }else{
            System.out.println("连接失败");
        }
        return count;
    }
}
