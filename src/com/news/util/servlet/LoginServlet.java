package com.news.util.servlet;

import com.news.util.dao.UserDao;
import com.news.util.service.UserService;
import com.news.util.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.doPost(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //对请求进行统一处理
//        req.setCharacterEncoding("utf-8");
//
//        String username=req.getParameter("uname");
//        String password=req.getParameter("upassword");
//
//        //调用service中的方法
//        UserService userService=new  UserServiceImpl();
//        boolean b=userService.LoginUser(username,password);
//
//        if(b) {//表示用户存在
//            HttpSession session = req.getSession();
//            session.setAttribute("usernamekey", username);
//            //页面的跳转 发送url路径
////            req.getRequestDispatcher("/index.jsp").forward(req,resp);
////
////        }else{
////            //用户不存在
////            //页面的跳转
////            req.getRequestDispatcher("/index.jsp").forward(req,resp);
////        }
//            req.getRequestDispatcher("/index.jsp").forward(req, resp);//与上面的方法相同
//        }
//
//    }
//}
@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在这里统一处理请求
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("uname");
        String password = request.getParameter("upassword");

        UserService userService = new UserServiceImpl();
        boolean b = userService.LoginUser(username, password);
        //把结果返回给jsp页面，然后浏览器渲染   false 不存在 true 存在
        if(b){//true 存在
            HttpSession session = request.getSession();
            session.setAttribute("usernameKey",username);
            //刷新index.jsp页面
            request.getRequestDispatcher("/index.jsp").forward(request,response);

        }else{//不存在
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }
}
