package com.news.util.servlet;

import com.news.util.service.UserService;
import com.news.util.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet1",urlPatterns = "/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("uname");
       String password=request.getParameter("upassword");
       if (username!=null&&!username.equals("")&&password!=null&&!password.equals("")){
           UserService userService=new UserServiceImpl();
          boolean b= userService.LoginUser(username,password);
          if (b){
          HttpSession session= request.getSession();
          session.setAttribute("usernamekey",username);
          request.getRequestDispatcher("/index.jsp").forward(request,response);

          }else {
              request.getRequestDispatcher("WEB-INF/LoginFailure.jsp").forward(request,response);
          }}
          else {
           response.sendRedirect(request.getContextPath()+"/LoginFailure.jsp");
           }


       }

    }

