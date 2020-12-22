package com.news.util.servlet;

import com.news.util.pojo.NewsUser;
import com.news.util.service.UserService;
import com.news.util.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="RegisterServlet",urlPatterns ={"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对请求统一处理
        //处理post请求的时候，设置编码的样式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //传递参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        //非空判断

        if(username!=null && !username.equals("")&& password!=null && !password.equals("")
                && email!=null && !email.equals("")){
            //将三个参数保存到数据中
            UserService userService=new UserServiceImpl();
            NewsUser newsUser=new NewsUser();
            newsUser.setUsername(username);
            newsUser.setPassword(password);
            newsUser.setEmail(email);
           boolean b= userService.register(newsUser);
           //再次发送请求，给网民一个提示信息
            if(b){
                 //注册成功
                request.getRequestDispatcher("pages/RegisterSuccess.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("pages/RegisterFailure.jsp").forward(request,response);

            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
